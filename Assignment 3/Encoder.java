import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;


public class Encoder{

	public static int [] letterFreq = new int[26]; 
	public static int sum = 0;
	public static double entropy = 0.0;

	//array of huffman code for each letter
	public static int [] encoded = new int[26];
	public static int volume = 0 ;
	public static double bps = 0.0;
	public static String totalBitsUsed = "";



	//pair arrays - 27^2 elements
	public static int [] pairFreq = new int[676];
	public static int pairSum = 0;
	public static double pairEntropy = 0.0;


	public static int [] pairEncoded = new int[676];
	public static double pbps = 0.0;
	public static String ptotalBitsUsed = "";






	public static void main (String args[]) throws IOException {

		Arrays.fill(encoded, -1);
		Arrays.fill(pairEncoded, -1);
		//frequencies file

		File freqFile = null;
		if (0 < args.length) {
		   freqFile = new File(args[0]);
		}

		volume = Integer.parseInt(args[1]);

		//puts frequencies into array and calculates sum
		readFreqFile(freqFile);
		//generate huffman code
		System.out.println();
		System.out.println("Single Alphabet");
		HuffmanCode.start(letterFreq);
		//calcuate entropy
		entropy = calcEntropy(letterFreq, sum);
		//create random volume of text
		createRandomText();
		//encode file
		encodeFile();
		System.out.printf("Entropy of this language is: %.2f\n", entropy );
		System.out.printf("Average bits per symbol is: %.2f\n" ,bps);
		double percentDiff = Math.abs(bps - entropy) * 100;
		System.out.printf("Percent diference: %.2f%s\n" , percentDiff, "%");
		//decode file
		decodeFile();



		//***************************Pair Symbols start*************************//

		//caculate pair arrays
		System.out.println();
		System.out.println("2-Symbol Derived Alphabet");
		calcPairs();
		PairHuffmanCode.start(pairFreq);


		//calculate pair ;pbps must read then caculate
		pairEntropy = calcEntropy(pairFreq, pairSum)/2 ;

		//encoding pair
		p_encodeFile();
		System.out.printf("Entropy of this language is: %.2f\n", pairEntropy);
		System.out.printf("Average bits per symbol is: %.2f\n" ,pbps);
		double ppercentDiff = Math.abs(pbps - pairEntropy) * 100;
		System.out.printf("Percent difference: %.2f%s\n" , ppercentDiff, "%");
		//decode pair
		p_decodeFile();

		System.out.println();
		System.out.printf("1-symbol vs 2-symbol percent difference: %.1f%s\n" , Math.abs(pbps - bps)*100, "%");




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




	public static double calcEntropy(int [] freq1, double sum1){

		// h = - (sigma P * log2 P)
		double h = 0;
		for(int i = 0; i < freq1.length; i++){
			
			if(freq1[i] != 0){

				double prob = (double)freq1[i] / (double) sum1;

				h -= prob * log2(prob);

			}
		}

		return h;

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

	//pair - write to file named testText.enc2
	public static void p_encodeFile() throws IOException{

		File enc2 = new File ("testText.enc2");
		BufferedWriter writer = new BufferedWriter(new FileWriter(enc2));

		FileReader fr = new FileReader("testText");
		BufferedReader br = new BufferedReader(fr);

		int f;
		int s;
		while( (f=br.read()) != -1 && (s=br.read())!= -1 ){

			char fletter = (char) f;
			char sletter = (char) s;

			//put letters together
			StringBuilder str = new StringBuilder();
			str.append((char) fletter);
			str.append((char) sletter);

			//get encoding of letter from map
			String encoding = PairHuffmanCode.encodingMap.get(str.toString());

			writer.write(encoding);
			writer.newLine();

			ptotalBitsUsed += encoding;
		}

		pbps = (double)ptotalBitsUsed.length() / volume / 2;

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

	//write to file named testText.dec1
	public static void p_decodeFile() throws IOException{

		File dec2 = new File ("testText.dec2");
		BufferedWriter writer = new BufferedWriter(new FileWriter(dec2));

		FileReader fr = new FileReader("testText.enc2");
		BufferedReader br = new BufferedReader(fr);

		String encoding = br.readLine();

		while( encoding != null ){


			//get encoding of letter from map
			String pair = PairHuffmanCode.decodingMap.get(encoding);

			writer.write(pair);

			encoding = br.readLine();
		}

		writer.close();

	}

	public static void calcPairs(){

		pairSum = sum*sum * 2;

		int pairIndex = 0;
		for(int i = 0; i < letterFreq.length; i++){
			for(int j = 0; j < letterFreq.length; j++){
				//fill in pair array
				pairFreq[pairIndex] = letterFreq[i] * letterFreq[j];
				pairIndex++;
			}
		}


	}







}
