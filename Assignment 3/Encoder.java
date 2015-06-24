import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;


public class Encoder{

	public static int [] letterFreq = new int[27]; 
	public static int sum=0;

	public Encoder(){}


	public static void main (String args[]) throws IOException {

		Encoder e = new Encoder();
		//frequencies file

		File freqFile = null;
		if (0 < args.length) {
		   freqFile = new File(args[0]);
		}

		readFreqFile(freqFile);
		HuffmanCode.start(letterFreq);






	}

	public static void readFreqFile(File freqFile) throws IOException{


		FileReader fr = new FileReader(freqFile);
		BufferedReader br = new BufferedReader(fr);
		String line;
		System.out.println("Reading from Frequencies file: " + freqFile);

		Scanner scanner = new Scanner (freqFile);

		int index = 0;
		while(scanner.hasNextLine() ){
			int f = scanner.nextInt();
			letterFreq[index] = f;

			sum += f;
			index++;

			//System.out.printf("Sum: %d index: %d" , sum, index);
		}

	}

}