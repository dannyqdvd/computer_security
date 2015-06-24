import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;


public class Encoder{

	public static int [] letterFreq = new int[27]; 
	public static int sum = 0;
	public static double entropy = 0.0;

	public Encoder(){}


	public static void main (String args[]) throws IOException {

		Encoder e = new Encoder();
		//frequencies file

		File freqFile = null;
		if (0 < args.length) {
		   freqFile = new File(args[0]);
		}

		//puts frequencies into array and calculates sum
		readFreqFile(freqFile);

		//generate huffman code
		HuffmanCode.start(letterFreq);

		//calcuate entropy
		calcEntropy();








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

		}

	}

	public static void calcEntropy(){

		// h = - (sigma P * log2 P)
		for(int i = 0; i < letterFreq.length; i++){
			
			if(letterFreq[i] != 0){

				double prob = (double)letterFreq[i] / sum;

				entropy -= prob * log2(prob);

			}
		}

		System.out.printf("Entropy of this language is: %.2f\n", entropy );


	}

	private static double log2(double a) {
	  return Math.log(a) / Math.log(2);
	}







}
