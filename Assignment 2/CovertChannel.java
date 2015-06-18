import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;


public class CovertChannel{

	public CovertChannel(){

	}

	public static void main (String args[]) throws IOException {

		//take in file to be transmitted
		//break them into bits

		File secretFile = null;
		if (0 < args.length) {
		   secretFile = new File(args[0]);
		}

		FileReader fr = new FileReader(secretFile);
		BufferedReader br = new BufferedReader(fr);
		String line;
		System.out.println("Reading from file: " + secretFile);

		while((line = br.readLine()) != null)
		{
			System.out.println(line);

			System.out.println("Text: "+ line);

			//get from text to binary
			String binary_line = new BigInteger(line.getBytes()).toString(2);
			System.out.println("As binary: "+ binary_line);


			//for the length of the string, hal will transmit it to lyle
			for(int i = 0; i < binary_line.length(); i++){

				char bit = binary_line.charAt(i);
				System.out.println(bit);

				//generate instructions to log file
				//based on what is bit is seen in file

				//	if bit == 0
				//		run HAL
				//		create HAL obj
				//	else -- bit == 1
				//		run HAL
				//
				//	CREATE LYLE OBJ
				//	WRITE LYLE OBJ 1
				//	DESTROY LYLE OBJ
				//	RUN LYLE



			}





			//get to from binary back to text
			String bitstream = new String(new BigInteger(binary_line, 2).toByteArray());
			System.out.println("As text: "+ bitstream);




		}

	

	}
}