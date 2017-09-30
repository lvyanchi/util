package cn.yclv.crypto.security;

public class KaisaiEncry {
	public static void main(String[] args) {
		String cyperText = "EXXEGOEXSRGI";
//		stringToASCII(cyperText);
		int[] a = new int[]{88,99};
		String asciiToString = asciiToString(a);
		System.out.println(asciiToString);
	}

	
	/**
	 * stringToASCII
	 * @param str
	 * @return
	 */
	private static int[] stringToASCII(String str) {
		char[] charArray = str.toCharArray();
		int[] asciiArray = new int[12];
		for (int i = 0; i < charArray.length; i++) {
			asciiArray[i] = (int) charArray[i];
		}
		return asciiArray;
	}
	
	
	
	private static String asciiToString(int[] asciiArray){
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < asciiArray.length; i++) {
			char c = (char)asciiArray[i];
			sb.append(c);
		}
		return sb.toString();
	}
}
