import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;


public class Encoder{

	public static int [] letterFreq = new int[27]; 
	public static int sum = 0;
	public static double entropy = 0.0;
	//array of huffman code for each letter
	public static int [] encoded = new int[27];

	public static double volume = 10.0 ;
	public static double bps = 0.0;
	public static String totalBitsUsed = "";

	//pair arrays - 27^2 elements
	public static int [] pairFreq = new int[729];
	public static int [] pairEncoded = new int[729];
	public static int pairSum = 0;




	public static void main (String args[]) throws IOException {

		Arrays.fill(encoded, -1);
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

		//create random volume of text
		createRandomText();

		//encode file
		encodeFile();
		System.out.printf("Average bits per symbol is: %.2f\n" ,bps);
		double percentDiff = (bps - entropy) * 100;
		System.out.printf("Percent diiference: %.2f%s\n" , percentDiff, "%");

		//decode file
		decodeFile();

		//caculate pair arrays
		calcPairs();


	}

	public static void readFreqFile(File freqFile) throws IOException{


		FileReader fr = new FileReader(freqFile);
		BufferedReader br = new BufferedReader(fr);
		System.out.println("Reading from Frequencies file: " + freqFile);

		Scanner scanner = new Scanner (freqFile);

		int index = 0;
		while(scanner.hasNextLine() ){
			int f = scanner.nextInt();
			letterFreq[index] = f;

			sum += f;
			index++;

		}

		fr.close();

	}

	public static void calcEntropy(){

		// h = - (sigma P * log2 P)
		for(int i = 0; i < letterFreq.length; i++){
			
			if(letterFreq[i] != 0){

				double prob = (double)letterFreq[i] / (double) sum;

				entropy -= prob * log2(prob);

			}
		}

		System.out.printf("Entropy of this language is: %.2f\n", entropy );

	}

	private static double log2(double a) {
	  return Math.log(a) / Math.log(2);
	}

	public static void createRandomText() throws IOException{

		//generated test file for ss
		File testText = new File ("testText");
		BufferedWriter writer = new BufferedWriter(new FileWriter(testText));


		Random randomGenerator = new Random();

		char [] letters = new char[sum];
		int count = 0;
		for(int i = 0; i < letterFreq.length; i++){
			for(int j = 0; j < letterFreq[i]; j++){

				int symbol = i + 65;
				letters[count] = (char) symbol;
				count ++;
			}

		}
		

		int randomNum;
		for(int i = 0; i < volume; i++){
			randomNum = randomGenerator.nextInt(sum);
			writer.write(letters[randomNum]);

		}

		writer.close();
		

	}

	//write to file named testText.enc1
	public static void encodeFile() throws IOException{

		File enc1 = new File ("testText.enc1");
		BufferedWriter writer = new BufferedWriter(new FileWriter(enc1));

		FileReader fr = new FileReader("testText");
		BufferedReader br = new BufferedReader(fr);

		int r;
		while( (r=br.read()) != -1 ){
			char letter = (char) r;

			//get encoding of letter from map
			String encoding = HuffmanCode.encodingMap.get(letter);

			writer.write(encoding);
			writer.newLine();

			totalBitsUsed += encoding;
		}

		bps = (double)totalBitsUsed.length() / volume;

		writer.close();



	}

	//write to file named testText.dec1
	public static void decodeFile() throws IOException{

		File dec1 = new File ("testText.dec1");
		BufferedWriter writer = new BufferedWriter(new FileWriter(dec1));

		FileReader fr = new FileReader("testText.enc1");
		BufferedReader br = new BufferedReader(fr);

		String encoding = br.readLine();

		while( encoding != null ){


			//get encoding of letter from map
			char letter = HuffmanCode.decodingMap.get(encoding);

			writer.write(letter);

			encoding = br.readLine();
		}

		writer.close();

	}

	public static void calcPairs(){

		pairSum = sum * sum;
		System.out.printf("Pair sum: %d\n ", pairSum);


		int pairIndex = 0;
		for(int i = 0; i < letterFreq.length; i++){
			for(int j = 0; j < letterFreq.length; j++){
				//fill in pair array
				pairFreq[pairIndex] = letterFreq[i] * letterFreq[j];
				pairIndex++;
			}
		}

		//debug: print out new pairfreq array
		for(int i = 0; i < pairFreq.length; i++){
			System.out.printf("%d ", pairFreq[i]);
		}
		System.out.println();

	}







}
