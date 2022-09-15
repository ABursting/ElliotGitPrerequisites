package src;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
public class Tree {
	private ArrayList<String> list;
	public Tree(ArrayList<String> KVList) {
		list = KVList;
	}
	public static String encrypt(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger num = new BigInteger(1, messageDigest);
			String hex = num.toString(16);
			while (hex.length() < 32) {
				hex = "0" + hex;
			}
			return hex;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
	public String generateSHA1() {
		StringBuilder all = new StringBuilder();
		for(String s : list) {
			all.append(s);
		}
		return encrypt(all.toString());
	}
	public void createIndexFile() {
		
	}
}
