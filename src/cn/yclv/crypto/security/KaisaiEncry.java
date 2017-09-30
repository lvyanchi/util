package cn.yclv.crypto.security;

public class KaisaiEncry {
	public static void main(String[] args) {
		String cyperText = "EXXEGOEXSRGI";
		System.out.println(cyperText);
		int[] asciiArray = stringToASCII(cyperText);
		for (int i = 0; i < asciiArray.length; i++) {
			System.out.print(asciiArray[i] + "|");
		}
		int[] assciiToLeftOneStep = assciiToLeftOneStep(asciiArray);
		String asciiToString = asciiToString(asciiArray);
		String asciiToString2 = asciiToString(assciiToLeftOneStep);
		System.out.println(asciiToString);
		System.out.println(asciiToString2);
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
	
	
	/**
	 * ascii码转为String
	 * @param asciiArray
	 * @return
	 */
	private static String asciiToString(int[] asciiArray){
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < asciiArray.length; i++) {
			char c = (char)asciiArray[i];
			sb.append(c);
		}
		return sb.toString();
	}
	
	
	private static int[] assciiToLeftOneStep(int[] asciiArray){
		int[] toLeftOneStep = new int[12];
		for (int i = 0; i < asciiArray.length; i++) {
			toLeftOneStep[i] = asciiArray[i] + 1;
		}
		return toLeftOneStep;
	}
}
