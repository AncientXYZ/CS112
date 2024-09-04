/*********************************
 * filename: FancyGraphics.java
 * 
 * Show off Java graphics capabilities,
 * including buttons, timers, and colors.
 * @author Paul Haskell
 */


import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


/** Handler class for ActionEvents.
 * The ActionEvents might come from buttons,
 * timers, menus, etc.
 */
class MyActions implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("button1")) {
			System.out.println("Button was pressed");
		} else if (e.getActionCommand().equals("timer1")) {
			System.out.print(".");
		}
	}
	
}


public class FancyGraphics {

	static public void main(String[] args) {
		JFrame jf = new JFrame("Fancy Graphics Demo");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel jp = new JPanel();
		jp.setPreferredSize(new Dimension(700, 500));
		jp.setBackground(new Color(240, 200, 40));
		
		MyActions handler = new MyActions();
		
		JButton jb = new JButton("Press me");
		jb.setActionCommand("button1");
		jp.add(jb);
		jb.addActionListener(handler);

		Timer stopwatch = new Timer(1000, handler);
		stopwatch.setActionCommand("timer1");
		stopwatch.start();

		jf.add(jp); // insert JPanel into JFrame
		jf.pack(); // set size of top-level window
		jf.setVisible(true);
		System.out.println("End of main()");
	}
}