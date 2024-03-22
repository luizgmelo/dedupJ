package dedup;

import java.io.File;

public class Dedup {
	public static void main(String[] args) {
		File directory = new File(".");
		File[] contents = directory.listFiles();
		for (File f : contents) {
			System.out.println(f.getAbsolutePath());
		}
	}
}
