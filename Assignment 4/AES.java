import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;

public class AES{


	public static void main (String args[]) throws IOException {
	//java AES option keyFile inputFile

		//option - e or d
		String option = arg[1];
		char opt = option.CharAt(0);

		//keyfile - contains a single line of 64 hex characters
		File keyFile = null;
		if (0 < args.length) {
		   freqFile = new File(args[1]);
		}

		//inputfile - 32 hex characters per line
		File inputFile = null;
		if (0 < args.length) {
		   freqFile = new File(args[2]);
		}


		/*Debugging............................................*/
		String plaintext = "00112233445566778899AABBCCDDEEFF";
		String cipherKey = "0000000000000000000000000000000000000000000000000000000000000000"

		/*End Debugging........................................*/




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


}
