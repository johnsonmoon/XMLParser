package xuyihao.xml.parser.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * Created by Xuyh at 2017年4月21日 下午6:10:57.
 */
public class CommonUtil {
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * Input a line of string from console.
	 * 
	 * @return
	 */
	public static String inputLine() {
		String line = "";
		try {
			line = reader.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return line;
	}

	/**
	 * Output a line of string into the console.
	 * 
	 * @param line
	 */
	public static void outputLine(String line) {
		System.out.println(line);
	}
}
