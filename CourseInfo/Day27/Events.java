import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


class MyPanel
	extends
		JPanel
	implements
		MouseListener,
		KeyListener,
		ComponentListener
{
	MyPanel() {
		setFocusable(true); // can receive keyboard "focus". Must be before addKeyListener()
		addMouseListener(this);
		addKeyListener(this);
		addComponentListener(this);
	}

	// Mouse Event handlers
	public void mouseReleased(MouseEvent me) {
		System.out.println("Mouse released");
	}

	public void mousePressed(MouseEvent me) {
		System.out.println("Mouse pressed");
	}

	public void mouseClicked(MouseEvent me) {
		System.out.println("Mouse clicked");
	}

	public void mouseEntered(MouseEvent me) {
		System.out.println("Mouse entered");
	}

	public void mouseExited(MouseEvent me) {
		System.out.println("Mouse exited");
	}
	
	// Keyboard Event handlers
	public void keyTyped(KeyEvent ke) {
		final char ch = ke.getKeyChar();
		System.out.printf("Key typed: %c\n", ch);
	}
	public void keyPressed(KeyEvent evt) { }
	public void keyReleased(KeyEvent evt) { }

	// Window Event handlers
	public void componentShown(ComponentEvent ce) {
		System.out.println("Component shown");
	}
	
	public void componentHidden(ComponentEvent ce) {
		System.out.println("Component hidden");
	}
	
	public void componentMoved(ComponentEvent ce) {
		System.out.println("Component moved");
	}
	
	public void componentResized(ComponentEvent ce) {
		System.out.println("Component resized");
	}
}


public class Events
{
	static public void main(String[] args) {
		JFrame jf = new JFrame("Lots of events");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MyPanel mp = new MyPanel();
		mp.setPreferredSize(new Dimension(700, 500));
		
		jf.add(mp); // insert JPanel into JFrame
		jf.pack(); // set size of top-level window based on its contents
		jf.setVisible(true);

		mp.setVisible(false);	
		mp.setVisible(true);
	}

}