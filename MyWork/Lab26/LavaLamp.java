import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.Timer;

public class LavaLamp {
    JPanel jp = new JPanel();
    JButton jb = new JButton("Press me");
    int time = 0;
    int i = 0;

    //timer to start with pressing the button, stops when button is pressed again
    Timer stopwatch = new Timer(100, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            System.out.println(time++);
        }
    });
    //set Panel background color to white
    public void setPanelColor() {
        jp.setBackground(new Color(255, 255, 255));
    }

    //set Panel background color to red
    public void setPanelColorRed() {
        jp.setBackground(new Color(255, 0, 0));
    }

    //set Panel color to green
    public void setPanelColorGreen() {
        jp.setBackground(new Color(0, 255, 0));
    }

    //when button is pressed once the panel color is set to red and when pressed again the panel color is set to green
    public void buttonPressed() {
        jb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (i % 2 == 0) {
                    setPanelColorRed();
                } else {
                    setPanelColorGreen();
                }
                if (stopwatch.isRunning()) {
                    stopwatch.stop();
                } else {
                    stopwatch.start();
                }
                i++;
            }
        });
    }

    public static void main(String[] args) {
        LavaLamp lavaLamp = new LavaLamp();
        JFrame jf = new JFrame("Lava Lamp");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lavaLamp.jp.setPreferredSize(new Dimension(700, 500));
        lavaLamp.setPanelColor();
        lavaLamp.buttonPressed();
        lavaLamp.jp.add(lavaLamp.jb);
        jf.add(lavaLamp.jp);
        jf.pack();
        jf.setVisible(true);
    }
}