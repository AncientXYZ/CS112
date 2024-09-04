
public class Graphics {
	char myChar = '*';
	int horiz;
	int vert;
	
	public Graphics() {
		horiz = 3;
		vert = 5;
	}
	public Graphics(int x, int y) {
		horiz = x;
		vert = y;
	}
	
	public void draw() {
		for(int i = 0; i < vert; i++) {
			System.out.println();
		}
		for(int j = 0; j < horiz; j++) {
			System.out.print(" ");
		}
		System.out.println(myChar);
	}
	
	public static void main(String[] args) {
		Rectangle obj = new Rectangle(2, 3);
		obj.draw();
	}

}

class Rectangle extends Graphics {
	private int width;
	private int height;
	public Rectangle(int w, int h) {
		width = w;
		height = h;
	}
	public void draw() {
		for (int i = 0; i < vert; i++) {
			System.out.println();
		}
		for(int i = 0; i < height; i++) {
			for (int j = 0; j < horiz; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < width; j++) {
				System.out.print(myChar);
			}
			System.out.println();
		}
	}
}

// Next time, make a Square!
