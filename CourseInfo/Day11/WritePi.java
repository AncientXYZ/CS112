import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;

public class WritePi {

	public static void main(String[] args) {
		// System.out and System.in are not "synchronized".
		System.out.println("aaa");
		System.err.println("bbb");
		System.out.println("ccc");
		System.err.println("ddd");
		System.out.println("eee");
		System.err.println("fff");
		
		double pi = Math.PI;
		try {
			File piFile = new File("pi.rawData");
			FileOutputStream fos = new FileOutputStream(piFile);
			//fos.writeDouble(pi); no such method in FileOutputStream!
			DataOutputStream dos = new DataOutputStream(fos);
			dos.writeDouble(pi); // writes the 64 bits of the double directly, not human-readable
			dos.close();
			fos.close();
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
