import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;

public class AES{


	public static String [][] plaintext_matrix = new String[4][4];
	public static String [][] cipherKey_matrix = new String[4][8];

	public static void main (String args[]) throws IOException {
	//java AES option keyFile inputFile

		//option - e or d
		String option = args[0];
		

		// //keyfile - contains a single line of 64 hex characters
		// File keyFile = null;
		// if (0 < args.length) {
		//    freqFile = new File(args[1]);
		// }

		// //inputfile - 32 hex characters per line
		// File inputFile = null;
		// if (0 < args.length) {
		//    freqFile = new File(args[2]);
		// }


		/*Debugging............................................*/
		String plaintext = "00112233445566778899AABBCCDDEEFF";
		String cipherKey = "0000000000000000000000000000000000000000000000000000000000000000";

		/*End Debugging........................................*/
		//System.out.printf("Hi! Option: %s\n", option);

		//put plain text into 4x4 matrix
		printMatrices(plaintext, cipherKey);

		//key expansion



		//do key expansion for 256 bit key
		//print key expansion
		//do it 14 times
			
			//rotword()
				// -take last column of round
				// 	-first item in column goes to the end, everything shifts up
				// -subbyte each item with s box
				// -XOR it with each column in the key round

				// -returns column in new round





		////////////Encrpytion/////////////////////

		//initial round - add round key

		//13 rounds 
		///subbytes
		//shift rowa
		//mix columns
		//add round key

		//final round
		//subbytes
		//shiftrows
		//addroundkey

		//




		//decrypting file 
		//You'll read in a line, converting from Hex to binary for storage into your state array. 
		//Apply the AES algorithm to encrypt the string as stored, and 
		//write out the ciphertext in Hex notation to the output file. 

	}

	public static void printMatrices(String plaintext, String cipherKey){

		
		int pt_counter = 0;
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 4; j++){
				String firstchar = "" +plaintext.charAt(pt_counter);
				pt_counter++;
				firstchar = firstchar + plaintext.charAt(pt_counter);
				plaintext_matrix[i][j] = firstchar;//Integer.parseInt(firstchar);
				pt_counter++;
			}

		}
		System.out.println();

		//prints out plain text in array
		System.out.println("The Plaintext is:");
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 4; j++){
				System.out.print(plaintext_matrix[j][i] + " ");
			}
			System.out.println();

		}


		//put key text into 4x4 matrix
		
		int pt_counter2 = 0;
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 8; j++){
				String firstchar2 = "" +cipherKey.charAt(pt_counter2);
				pt_counter2++;
				firstchar2 = firstchar2 + cipherKey.charAt(pt_counter2);
				cipherKey_matrix[i][j] = firstchar2;//Integer.parseInt(firstchar);
				pt_counter2++;
			}

		}
		System.out.println();


		//prints out plain text in array
		System.out.println("The CipherKey is:");
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 8; j++){
				System.out.print(cipherKey_matrix[i][j] + " ");
			}
			System.out.println();

		}
		System.out.println();


	}


}
