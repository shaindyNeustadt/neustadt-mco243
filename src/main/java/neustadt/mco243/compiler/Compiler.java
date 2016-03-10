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
				String location = getLocation(split[1]);
				builder.append(location);
				break;
			case "ST":
				builder.append(1);
				location = getLocation(split[1]);
				builder.append(location);
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
				location = getLocation(split[1]);
				builder.append(location);
				break;
			case "BR":
				builder.append(7);
				location = getLocation(split[1]);
				builder.append(location);
				break;
			case "STP":
				builder.append(8);
				break;
			case "DATA":
				builder.append(split[1]);
				break;
			}
		}

		System.out.println(builder.toString());
	}

	private String getLocation(String loc) {
		String location = (String) Integer.toString(Integer.parseInt(loc), 16)
				.toUpperCase();
		if (location.length() == 2) {
			return location;
		}
		return "0" + location;
	}

}
