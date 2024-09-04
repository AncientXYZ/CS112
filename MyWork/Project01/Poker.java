import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Poker {
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;

    private int myChips; // player's chips
    private int currentPot; // current pot

    public Poker(String ip, int port) throws IOException {
        socket = new Socket(ip, port);
        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());
    }

    private void write(String s) throws IOException {
        dos.writeUTF(s);
        dos.flush();
    }

    private String read() throws IOException {
        return dis.readUTF();
    }

    // calculate the value of a card
    private int cardValue(String card) {
        String value = card.substring(0, card.length() - 1);
        return "JQK".contains(value) ? 10 : "A".equals(value) ? 11 : Integer.parseInt(value);
    }

    // make decision based on the current bet and cards
    private String makeDecision(int currentBet, String... cards) {
        int betAmount = 0;

        int[] values = new int[cards.length];
        for (int i = 0; i < cards.length; i++) {
            values[i] = cardValue(cards[i]);
        }

        boolean hasPair = false;
        boolean hasThreeOfAKind = false;

        if (cards.length == 3) {
            hasPair = (values[0] == values[1] || values[0] == values[2] || values[1] == values[2]);
            hasThreeOfAKind = (values[0] == values[1] && values[1] == values[2]);
        } else if (cards.length == 2) {
            hasPair = (values[0] == values[1]);
        }

        if (hasThreeOfAKind || hasPair) {
            betAmount = Math.min(currentBet + 10, myChips);
        } else if (myChips >= currentBet) {
            betAmount = currentBet; // call
        } else {
            return "fold";
        }

        myChips -= betAmount; // update chips
        return "bet:" + betAmount; // return decision
    }

    public void start() throws IOException {
        try {
            while (true) {
                String serverCommand = read();
                System.out.println("Received command from server: " + serverCommand);

                if (serverCommand.startsWith("login")) {
                    write("AncientXYZ:Firefly");
                } else if (serverCommand.startsWith("bet1:") || serverCommand.startsWith("bet2:")) {
                    String[] parts = serverCommand.split(":");
                    myChips = Integer.parseInt(parts[1]); // update chips
                    currentPot = Integer.parseInt(parts[2]); // update pot
                    int currentBet = Integer.parseInt(parts[3]); // current bet
                    String holeCard = parts[4];
                    String upCard = parts[5];
                    String thirdCard = parts.length > 6 ? parts[6] : null;

                    String decision = (thirdCard == null) ?
                            makeDecision(currentBet, holeCard, upCard) :
                            makeDecision(currentBet, holeCard, upCard, thirdCard);
                    write(decision);
                } else if (serverCommand.startsWith("status:")) {
                    System.out.println("Game result: " + serverCommand);
                } else if (serverCommand.startsWith("done:")) {
                    System.out.println("Game over: " + serverCommand.substring(5));
                    break;
                }
            }
        } finally {
            dis.close();
            dos.close();
            socket.close();
        }
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("need 2 arguments: <ip> <port>");
            return;
        }
        try {
            String ip = args[0];
            int port = Integer.parseInt(args[1]);
            Poker client = new Poker(ip, port);
            client.start();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
