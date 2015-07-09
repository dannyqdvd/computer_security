import java.io.*;
import java.util.*;
import java.lang.*;

public class PasswordCrack{
	
	public static void main (String args[]) throws IOException {

		//dictionary file
		File dict = null;
		if (0 < args.length) {
		   dict = new File(args[0]);
		}



		//passwords to crack
		File passwd = null;
		if (0 < args.length) {
		   passwd = new File(args[1]);
		}

		//Reading password file
		FileReader fr = new FileReader(passwd);
		BufferedReader br = new BufferedReader(fr);
		System.out.println("Reading password file: " + passwd);
		System.out.println();
		Scanner scanner = new Scanner (passwd);

		while(scanner.hasNextLine() ){
			String line = scanner.nextLine();
			String[] tokens = line.split(":");

			//1. Extract the encrypted password 
			//and salt for that user (see format below);
			String encryptedPasswd = tokens[1];
			String salt = "" + encryptedPasswd.charAt(0) + encryptedPasswd.charAt(1);

			System.out.printf("password: %s\n", encryptedPasswd);
			System.out.printf("salt: %s\n", salt);

			//2. Seed the word list with words that the user might have 
			//utilized in constructing his or her password (e.g., his first and last name);
			String[] fullName = tokens[4].split(" ");
			String firstName = fullName[0];
			String lastName = fullName[1];

			System.out.printf("First name: %s\n", firstName);
			System.out.printf("Last name: %s\n", lastName);
			System.out.println();

			//if true and pw found, skip next two steps
			boolean foundPasswd;

			//3. With the salt and augmented wordlist, 
			//systematically encrypt words and compare against 
			//the stored encrypted password;
			foundPasswd = checkDictionary(fullName, dict, 1, salt, encryptedPasswd);
			if(!foundPasswd){
				foundPasswd = checkDictionary(fullName, dict, 2, salt, encryptedPasswd);
			}

			if(!foundPasswd){
				foundPasswd = checkDictionary(fullName, dict, 3, salt, encryptedPasswd);
			}

			if(!foundPasswd){
				System.out.printf("Password not found for %s %s\n", firstName, lastName);
			}


			//4. Redo step 3, but using mangled 
			//versions of the words;

			
			//5. Redo step 4, attempting to apply 
			//two mangles to each word.





		}//end while

		//close password file
		fr.close();



	}//end main

	public static boolean checkDictionary(String[] fullName, File dict , int scanType, String salt, String encryptedPasswd) throws IOException{
		
		//Reading dictionary file
		FileReader fr_d = new FileReader(dict);
		BufferedReader br_d = new BufferedReader(fr_d);
		System.out.println("Reading dictionary: " + dict);
		Scanner scanner_d = new Scanner (dict);

		String firstName = fullName[0];
		String lastName = fullName[1];
		String wholeName = firstName + lastName;

		//*********************************
		//* Trying name combinations first
		//*********************************
		String fNameE = "";
		String lNameE = "";
		String wNameE = "";

		if(scanType == 1){

			//name jcrypted
			fNameE = jcrypt.crypt(salt, firstName);
			lNameE = jcrypt.crypt(salt, lastName);
			wNameE =  jcrypt.crypt(salt, wholeName);
			// System.out.printf("jcrypted First name: %s\n", fNameE);
			// System.out.printf("jcrypted Last name: %s\n", lNameE);
			// System.out.printf("jcrypted Whole name: %s\n", wNameE);
			//check to see if password is matched
			if(fNameE.equals(encryptedPasswd) || lNameE.equals(encryptedPasswd) || wNameE.equals(encryptedPasswd) ) {
				return true;
			}

			System.out.println();
		}

		else if(scanType == 2){

			//mangled name jcrypted
			fNameE = jcrypt.crypt(salt, firstName);
			lNameE = jcrypt.crypt(salt, lastName);

			// System.out.printf("jcrypted First name: %s\n", fNameE);
			// System.out.printf("jcrypted Last name: %s\n", lNameE);
			// System.out.println();
		}

		else if(scanType == 3){

			//name jcrypted
			fNameE = jcrypt.crypt(salt, firstName);
			lNameE = jcrypt.crypt(salt, lastName);

			// System.out.printf("jcrypted First name: %s\n", fNameE);
			// System.out.printf("jcrypted Last name: %s\n", lNameE);
			// System.out.println();
		}



		//*********************************
		//* Trying dictionary words
		//*********************************

		//scan dictionary 
		String encryptedWord = "";
		while(scanner_d.hasNextLine() ){
			String dictionary_word = scanner_d.nextLine();
			String temp = dictionary_word;

			switch(scanType){
				//no mangle
				case 1:	encryptedWord = jcrypt.crypt(salt, dictionary_word);
						//compare w/ actual encrypted password
						if(encryptedWord.equals(encryptedPasswd)){
							System.out.printf("Password for %s %s is: %s\n", firstName, lastName, dictionary_word);
							return true;
						}
						break;

				//one mangle
				case 2:	//dictionary_word = prepend(w)
						//dictionary_word = append(w)

						//delete first char
						temp = deleteFirstChar(dictionary_word);
						encryptedWord = jcrypt.crypt(salt, temp);
						//compare w/ actual encrypted password
						if(encryptedWord.equals(encryptedPasswd)){
							System.out.printf("Password for %s %s is: %s\n", firstName, lastName, dictionary_word);
							return true;
						}

						//delete last char
						temp = deleteLastChar(dictionary_word);
						encryptedWord = jcrypt.crypt(salt, temp);
						//compare w/ actual encrypted password
						if(encryptedWord.equals(encryptedPasswd)){
							System.out.printf("Password for %s %s is: %s\n", firstName, lastName, dictionary_word);
							return true;
						}

						//revString
						temp = revString(dictionary_word);
						encryptedWord = jcrypt.crypt(salt, temp);
						//compare w/ actual encrypted password
						if(encryptedWord.equals(encryptedPasswd)){
							System.out.printf("Password for %s %s is: %s\n", firstName, lastName, dictionary_word);
							return true;
						}


						//duplicateString
						temp = duplicateString(dictionary_word);
						encryptedWord = jcrypt.crypt(salt, temp);
						//compare w/ actual encrypted password
						if(encryptedWord.equals(encryptedPasswd)){
							System.out.printf("Password for %s %s is: %s\n", firstName, lastName, dictionary_word);
							return true;
						}


						//reflectString
						temp = reflectString(dictionary_word);
						encryptedWord = jcrypt.crypt(salt, temp);
						//compare w/ actual encrypted password
						if(encryptedWord.equals(encryptedPasswd)){
							System.out.printf("Password for %s %s is: %s\n", firstName, lastName, dictionary_word);
							return true;
						}

						//reflectString2
						temp = reflectString2(dictionary_word);
						encryptedWord = jcrypt.crypt(salt, temp);
						//compare w/ actual encrypted password
						if(encryptedWord.equals(encryptedPasswd)){
							System.out.printf("Password for %s %s is: %s\n", firstName, lastName, dictionary_word);
							return true;
						}

						//upCaseString
						temp = upCaseString(dictionary_word);
						encryptedWord = jcrypt.crypt(salt, temp);
						//compare w/ actual encrypted password
						if(encryptedWord.equals(encryptedPasswd)){
							System.out.printf("Password for %s %s is: %s\n", firstName, lastName, dictionary_word);
							return true;
						}

						//lowCaseString
						temp = lowCaseString(dictionary_word);
						encryptedWord = jcrypt.crypt(salt, temp);
						//compare w/ actual encrypted password
						if(encryptedWord.equals(encryptedPasswd)){
							System.out.printf("Password for %s %s is: %s\n", firstName, lastName, dictionary_word);
							return true;
						}


						//capitalString
						temp = capitalString(dictionary_word);
						encryptedWord = jcrypt.crypt(salt, temp);
						//compare w/ actual encrypted password
						if(encryptedWord.equals(encryptedPasswd)){
							System.out.printf("Password for %s %s is: %s\n", firstName, lastName, dictionary_word);
							return true;
						}

						//ncapitalString
						temp = nCapitalString(dictionary_word);
						encryptedWord = jcrypt.crypt(salt, temp);
						//compare w/ actual encrypted password
						if(encryptedWord.equals(encryptedPasswd)){
							System.out.printf("Password for %s %s is: %s\n", firstName, lastName, dictionary_word);
							return true;
						}

						//toggleString
						temp = toggleString(dictionary_word);
						encryptedWord = jcrypt.crypt(salt, temp);
						//compare w/ actual encrypted password
						if(encryptedWord.equals(encryptedPasswd)){
							System.out.printf("Password for %s %s is: %s\n", firstName, lastName, dictionary_word);
							return true;
						}

						//toggleString2
						temp = toggleString2(dictionary_word);
						encryptedWord = jcrypt.crypt(salt, temp);
						//compare w/ actual encrypted password
						if(encryptedWord.equals(encryptedPasswd)){
							System.out.printf("Password for %s %s is: %s\n", firstName, lastName, dictionary_word);
							return true;
						}




						break;

				case 3:
						break;

				default:	break;


			}//end switch statement

		}//end dictionary while








		return false;
	}//checkdictionary()


	/*
	    prepend a character to the string, e.g., @string;
	    append a character to the string, e.g., string9;
	    delete the first character from the string, e.g., tring;
	    delete the last character from the string, e.g., strin;

	    toggle case of the string, e.g., StRiNg or sTrInG; 
	 */

	public static String prepend(String w, char c ){
		//String result =	
		return c+w;


	}

	public static String append(String w){
		//String result =	
		return w;

	}

	public static String deleteFirstChar(String w){
		String r =	w.substring(1);
		return r;

	}

	public static String deleteLastChar(String w){
		String r = w.substring(0, w.length() - 1);
		return r;

	}

	public static String revString(String w){
		String r = new StringBuilder(w).reverse().toString();
		return r;

	}

	public static String duplicateString(String w){
		String r = w +w;
		return r;

	}

	public static String reflectString(String w){
		String r = w + new StringBuilder(w).reverse().toString();
		return r;

	}

	public static String reflectString2(String w){
		String r = new StringBuilder(w).reverse().toString() + w;
		return r;

	}

	public static String upCaseString(String w){
		return w.toUpperCase();
	}

	public static String lowCaseString(String w){
		return w.toLowerCase();
	}

	public static String capitalString(String w){
		String r = w.substring(0, 1).toUpperCase() + w.substring(1).toLowerCase();
		return r;

	}

	public static String nCapitalString(String w){
		String r = w.substring(0, 1).toLowerCase() + w.substring(1).toUpperCase();
		return r;

	}

	public static String toggleString(String w){
		return w;
	}

	public static String toggleString2(String w){
		return w;

	}



}//end class


	