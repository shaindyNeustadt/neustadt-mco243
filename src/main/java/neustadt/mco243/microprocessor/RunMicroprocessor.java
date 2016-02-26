package neustadt.mco243.microprocessor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunMicroprocessor {

	public static void main(String[] args) {

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			// BufferedReader reader = new BufferedReader(new FileReader(
			// "./mach.in"));

			String nextLine;
			while ((nextLine = reader.readLine()) != null) {
				new Microprocessor(nextLine);
			}

			reader.close();
		} catch (IOException e) {
			System.out.println("IO Exception");
		}
	}
}
