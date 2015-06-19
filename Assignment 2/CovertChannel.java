import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;



public class CovertChannel{

	public CovertChannel(){}

	public static void main (String args[]) throws IOException {

		//take in file to be transmitted
		//break them into bits

		//secret file
		File secretFile = null;
		if (0 < args.length) {
		   secretFile = new File(args[0]);
		}

		FileReader fr = new FileReader(secretFile);
		BufferedReader br = new BufferedReader(fr);
		String line;
		System.out.println("Reading from file: " + secretFile);


		//generated instrution file for ss
		File log = new File ("log.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(log));



		while((line = br.readLine()) != null)
		{
			System.out.println(line);





			//for the length of the string, hal will transmit it to lyle
			for(int i = 0; i < binary_line.length(); i++){

				char bit = binary_line.charAt(i);
				System.out.println(bit);

				String runHal = "RUN HAL";
				String createHal = "CREATE HAL OBJ";
				String createLyle = "CREATE LYLE OBJ";
				String writeLyle = "WRITE LYLE OBJ 1";
				String destroyLyle = "DESTROY LYLE OBJ";
				String runLyle = "RUN LYLE";
				String readLyle = "READ LYLE OBJ";

				if(bit == '0'){
					writer.write(runHal);									writer.newLine();
					writer.newLine();

					writer.write(createHal);
					writer.newLine();
				}	
				else{
					writer.write(runHal);
					writer.newLine();					
				}

			
				writer.write(createLyle);
				writer.newLine();

				writer.write(writeLyle);
				writer.newLine();

				writer.write(readLyle);
				writer.newLine();

				writer.write(destroyLyle);
				writer.newLine();	

				writer.write(runLyle);
				writer.newLine();


			}



			writer.close();



		}

		//call secureSystem
		String [] ssargs = {"log.txt"}; 
		SecureSystem.main(ssargs);


	}
}