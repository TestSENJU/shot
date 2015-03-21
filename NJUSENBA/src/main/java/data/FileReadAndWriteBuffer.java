package data;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;

public class FileReadAndWriteBuffer {

	public static void write_to_file(String path, Hashtable<?, ?> objForWrite) {
		File file = new File(path);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			ObjectOutputStream os = new ObjectOutputStream(
					new FileOutputStream(file));
			os.writeObject(objForWrite);
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// TODO
	public static Hashtable<?, ?> read_from_file(String path)
			throws EOFException {
		Hashtable<?, ?> objForRead = new Hashtable<String, Object>();
		File file = new File(path);
		if (!file.exists()) {
			try {
				file.createNewFile();
				write_to_file(path, null);
			} catch (IOException e) {
				System.err.println("文件不存在，新建一个同名文件");
				e.printStackTrace();
			}
			return null;
		}
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(
					file));
			objForRead = (Hashtable<?, ?>) is.readObject();
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return objForRead;
	}

}
