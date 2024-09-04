import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Graphics2
	implements
		ActionListener
{
	int pressCount = 0;
	JTextField jtf;

	public void actionPerformed(ActionEvent ae) {
		System.out.printf("Button pressed %dx, text is: %s\n", ++pressCount, jtf.getText());
	}
	
	Graphics2() {
		JFrame jf = new JFrame("Name of Application");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel jp = new JPanel();
		//jp.setLayout(new BorderLayout(2, 8)); // LAYOUT
		jp.setPreferredSize(new Dimension(700, 500));
		
		JButton jb = new JButton("Press me");
		jb.addActionListener(this); // cannot use 'this' in static main() function
		jp.add(jb, BorderLayout.WEST); // LAYOUT

		jtf = new JTextField();
		jtf.setPreferredSize(new Dimension(200, 50));
		jp.add(jtf, BorderLayout.SOUTH); // LAYOUT
		
		jf.add(jp); // insert JPanel into JFrame
		jf.pack(); // set size of top-level window based on its contents
		jf.setVisible(true);
		
		/*
		// A pop-up window!
		String msg = JOptionPane.showInputDialog(jf, "Enter a message"); // POPUP
		System.err.println("dialog message: " + msg);
		*/
	}
	
	static public void main(String[] args) {
		Graphics2 g2 = new Graphics2();
	}

}