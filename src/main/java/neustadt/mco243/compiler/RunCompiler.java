package neustadt.mco243.compiler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RunCompiler {

	public static void main(String[] args) {

		try {
			BufferedReader reader = new BufferedReader(new FileReader("./compilerin.txt"));
			new Compiler(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
