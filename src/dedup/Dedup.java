package dedup;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Dedup {
	
	public Dedup() {
		
	}
	
	public void run() {
		HashMap<String, ArrayList<File>> hashToFile = new HashMap<String, ArrayList<File>>();
		
		File directory = new File(".");
		File[] contents = directory.listFiles();
		MessageDigest digest;
		
		for (File f : contents) {
			try {
				Scanner fileReader = new Scanner(f);
				try {
					digest = MessageDigest.getInstance("SHA-256");
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
					continue;
				}
				String hash = this.hash(fileReader, digest);
				fileReader.close();
				if (hashToFile.containsKey(hash)) {
					hashToFile.get(hash).add(f);
				} else {
					ArrayList<File> values = new ArrayList<File>();
					values.add(f);
					hashToFile.put(hash, values);
				}	
			} catch (FileNotFoundException e) {
				// ignore errors.
				// System.out.println("An error occorued");
				// e.printStackTrace();
				continue;
			}
		}
		for (String key : hashToFile.keySet()) {
			System.out.printf("%s: %s\n", key, hashToFile.get(key).toString());
		}
	}
	
	private String hash(Scanner scanner, MessageDigest digest) {
		digest.reset();
		while(scanner.hasNextLine()) {
			String data = scanner.nextLine();
			digest.update(data.getBytes());
		}
		byte[] encodedHash = digest.digest();
		return this.bytesToHex(encodedHash);
		
	}
	
	private String bytesToHex(byte[] hash) {
	    StringBuilder hexString = new StringBuilder(2 * hash.length);
	    for (int i = 0; i < hash.length; i++) {
	        String hex = Integer.toHexString(0xff & hash[i]);
	        if(hex.length() == 1) {
	            hexString.append('0');
	        }
	        hexString.append(hex);
	    }
	    return hexString.toString();
	}
	
}
