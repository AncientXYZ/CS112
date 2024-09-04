/*********************************
 * filename: SimpleGraphics.java
 * 
 * A very basic Java graphics program.
 * Just make a window.
 * 
 * @author Paul Haskell
 */


import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class SimpleGraphics {

	static public void main(String[] args) {
		JFrame jf = new JFrame("Simple Graphics Demo");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel jp = new JPanel();
		jp.setPreferredSize(new Dimension(700, 500));

		jf.add(jp); // insert JPanel into JFrame
		jf.pack(); // set size of top-level window
		jf.setVisible(true);
		System.out.println("End of main()");
	}
}