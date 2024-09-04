import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class Fonts
{
	public static void main(String[] args) {
		GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] allTheFonts = g.getAvailableFontFamilyNames();
		
		JFrame jf = new JFrame("Show fonts");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel jl = new JLabel("The quick brown fox jumps over the lazy dog.");
		jl.setPreferredSize(new Dimension(500, 100));

		jf.add(jl);
		jf.pack();
		jf.setVisible(true);
		
		for (String s : allTheFonts) {
			System.out.printf("font: %s\n", s);
			Font myFont = new Font(s, Font.PLAIN, 16);
			jl.setFont(myFont);
			try { // "Go to sleep" for 700 milliseconds.
				Thread.sleep(700);
			} catch (InterruptedException e) { System.err.println("INTERRUPT"); }
		}
	}

}