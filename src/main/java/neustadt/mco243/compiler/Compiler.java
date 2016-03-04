package neustadt.mco243.compiler;

import java.io.BufferedReader;
import java.io.IOException;

public class Compiler {

	public Compiler(BufferedReader reader) throws IOException {
		compile(reader);
	}

	private void compile(BufferedReader reader) throws IOException {
		String line;
		StringBuilder builder = new StringBuilder();
		while ((line = reader.readLine()) != null) {
			String[] split = line.split(" ");
			switch (split[0]) {
			case "LD":
				builder.append(0);
				builder.append(Integer.toString(Integer.parseInt(split[1]), 16).toUpperCase());
				break;
			case "ST":
				builder.append(1);
				builder.append(Integer.toString(Integer.parseInt(split[1]), 16).toUpperCase());
				break;
			case "SWP":
				builder.append(2);
				break;
			case "ADD":
				builder.append(3);
				break;
			case "INC":
				builder.append(4);
				break;
			case "DEC":
				builder.append(5);
				break;
			case "BZ":
				builder.append(6);
				builder.append(Integer.toString(Integer.parseInt(split[1]), 16).toUpperCase());
				break;
			case "BR":
				builder.append(7);
				builder.append(Integer.toString(Integer.parseInt(split[1]), 16).toUpperCase());
				break;
			case "STP":
				builder.append(8);
				break;
			case "DATA":
				builder.append(reader.readLine());
				break;
			}
		}
		// int length = 256 - builder.length();
		// for(int i =0; i < length; i++){
		// builder.append(0);
		// }

		System.out.println(builder.toString());
		System.out.println(builder.length());
	}

}
