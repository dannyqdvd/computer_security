import java.io.*;
import java.util.*;
import java.lang.*;


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
			String binary = new BigInteger(text.getBytes()).toString(2);
			System.out.println("As binary: "+binary);


			//get to from binary back to text
			String bitstream = new String(new BigInteger(binary, 2).toByteArray());
			System.out.println("As text: "+text2);




		}

		//generate instructions to log file
		//based on what is bit is seen in file

		//for loop
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
}