package primitiveWriteUTF;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class PrimitiveWriteUTF {

	String file1 = "C:\\Users\\David\\Desktop\\archivo1.txt";
	String file2 = "C:\\Users\\David\\Desktop\\text3.txt";

	DataOutputStream dos;
	DataInputStream dis;
	String [] cadena;

	public void lectura() throws IOException {
		try {
			File checking = new File ("C:\\Users\\David\\Desktop\\text3.txt");
			if (!checking.exists())
				checking.createNewFile();

			else {

				dis = new DataInputStream(new BufferedInputStream(new FileInputStream(file1)));
				
				int i = 0;
				while ((dis.available() > 0)) {
					cadena[i] = dis.readUTF();
					i++;
				}
				dis.close();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	}

	public void escritura() throws IOException {
		try {
			dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file2)));
			
			for (int x = 0; x < cadena.length;x++){
				dos.writeUTF(cadena[x]);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dos.close();
		}

	}

	public static void main(String[] args) {
		PrimitiveWriteUTF obj = new PrimitiveWriteUTF();
		try {
			obj.lectura();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
