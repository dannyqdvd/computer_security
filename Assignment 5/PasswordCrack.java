import java.io.*;
import java.util.*;
import java.lang.*;

public class PasswordCrack{

	//string of all characters to append/prepend
	public static String characters = "`1234567890-=~!@#$%^&*()_+qwertyuiop[]QWERTYUIOP{}|asdfghjklASDFGHJKL:zxcvbnm,./ZXCVBNM<>?";
	
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
		//System.out.println("Reading password file: " + passwd);
		System.out.println("List of cracked");
		System.out.println();
		Scanner scanner = new Scanner (passwd);

		while(scanner.hasNextLine() ){
			String line = scanner.nextLine();
			String[] tokens = line.split(":");

			//1. Extract the encrypted password 
			//and salt for that user (see format below);
			String encryptedPasswd = tokens[1];
			String salt = "" + encryptedPasswd.charAt(0) + encryptedPasswd.charAt(1);

			//System.out.printf("Encrypted password: %s\n", encryptedPasswd);
			//System.out.printf("salt: %s\n", salt);

			//2. Seed the word list with words that the user might have 
			//utilized in constructing his or her password (e.g., his first and last name);
			String[] fullName = tokens[4].split(" ");
			String firstName = fullName[0];
			String lastName = fullName[1];

			//System.out.printf("First name: %s\n", firstName);
			//System.out.printf("Last name: %s\n", lastName);

			//if true and pw found, skip next two steps
			boolean foundPasswd;

			//3. With the salt and augmented wordlist, 
			//systematically encrypt words and compare against 
			//the stored encrypted password;
			foundPasswd = checkDictionary(fullName, dict, 1, salt, encryptedPasswd);

			//4. Redo step 3, but using mangled 
			//versions of the words;
			if(!foundPasswd){
				foundPasswd = checkDictionary(fullName, dict, 2, salt, encryptedPasswd);
			}

			//5. Redo step 4, attempting to apply 
			//two mangles to each word.
			if(!foundPasswd){
				foundPasswd = checkDictionary(fullName, dict, 3, salt, encryptedPasswd);
			}

			//no passwords found
			if(!foundPasswd){
				System.out.printf("No passwords found for %s %s\n", firstName, lastName);
			}

			System.out.println();


			
		}//end while

		//close password file
		fr.close();



	}//end main

	public static boolean checkDictionary(String[] fullName, File dict , int scanType, String salt, String encryptedPasswd) throws IOException{
		
		//Reading dictionary file
		FileReader fr_d = new FileReader(dict);
		BufferedReader br_d = new BufferedReader(fr_d);
		//System.out.println("Reading dictionary: " + dict);
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

		String ftmp = "";
		String ltmp = "";
		String wtmp = "";

		//name jcrypted
		if(scanType == 1){

			
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

		}

		//mangled name jcrypted
		else if(scanType == 2){

			//TODO: append and prepend 
			//fNameE = prepend(ftmp)
			for(int i = 0; i < characters.length(); i++){
				ftmp = prepend(firstName, characters.charAt(i));
				fNameE = jcrypt.crypt(salt, ftmp);
				ltmp = prepend(lastName, characters.charAt(i));
				lNameE = jcrypt.crypt(salt, ltmp);
				wtmp = prepend(wholeName, characters.charAt(i));
				wNameE = jcrypt.crypt(salt, wtmp);
				if(fNameE.equals(encryptedPasswd)){
					System.out.printf("Password for %s %s is: %s\n", firstName, lastName, ftmp);
					return true;
				}
				else if (lNameE.equals(encryptedPasswd) ){
					System.out.printf("Password for %s %s is: %s\n", firstName, lastName, ltmp);
					return true;

				}
				else if (wNameE.equals(encryptedPasswd) ){
					System.out.printf("Password for %s %s is: %s\n", firstName, lastName, wtmp);
					return true;
				}
			}


			//append
			for(int i = 0; i < characters.length(); i++){

				ftmp = append(firstName, characters.charAt(i));
				fNameE = jcrypt.crypt(salt, ftmp);
				ltmp = append(lastName, characters.charAt(i));
				lNameE = jcrypt.crypt(salt, ltmp);
				wtmp = append(wholeName, characters.charAt(i));
				wNameE = jcrypt.crypt(salt, wtmp);
				if(fNameE.equals(encryptedPasswd)){
					System.out.printf("Password for %s %s is: %s\n", firstName, lastName, ftmp);
					return true;
				}
				else if (lNameE.equals(encryptedPasswd) ){
					System.out.printf("Password for %s %s is: %s\n", firstName, lastName, ltmp);
					return true;

				}
				else if (wNameE.equals(encryptedPasswd) ){
					System.out.printf("Password for %s %s is: %s\n", firstName, lastName, wtmp);
					return true;
				}
			}


			//delete first char
			ftmp = deleteFirstChar(firstName);
			fNameE = jcrypt.crypt(salt, ftmp);
			ltmp = deleteFirstChar(lastName);
			lNameE = jcrypt.crypt(salt, ltmp);
			wtmp = deleteFirstChar(wholeName);
			wNameE = jcrypt.crypt(salt, wtmp);
			if(fNameE.equals(encryptedPasswd)){
				System.out.printf("Password for %s %s is: %s\n", firstName, lastName, ftmp);
				return true;
			}
			else if (lNameE.equals(encryptedPasswd) ){
				System.out.printf("Password for %s %s is: %s\n", firstName, lastName, ltmp);
				return true;

			}
			else if (wNameE.equals(encryptedPasswd) ){
				System.out.printf("Password for %s %s is: %s\n", firstName, lastName, wtmp);
				return true;
			}

			//delete last char
			ftmp = deleteLastChar(firstName);
			fNameE = jcrypt.crypt(salt, ftmp);
			ltmp = deleteLastChar(lastName);
			lNameE = jcrypt.crypt(salt, ltmp);
			wtmp = deleteLastChar(wholeName);
			wNameE = jcrypt.crypt(salt, wtmp);
			if(fNameE.equals(encryptedPasswd)){
				System.out.printf("Password for %s %s is: %s\n", firstName, lastName, ftmp);
				return true;
			}
			else if (lNameE.equals(encryptedPasswd) ){
				System.out.printf("Password for %s %s is: %s\n", firstName, lastName, ltmp);
				return true;

			}
			else if (wNameE.equals(encryptedPasswd) ){
				System.out.printf("Password for %s %s is: %s\n", firstName, lastName, wtmp);
				return true;
			}

			//revString
			ftmp = revString(firstName);
			fNameE = jcrypt.crypt(salt, ftmp);
			ltmp = revString(lastName);
			lNameE = jcrypt.crypt(salt, ltmp);
			wtmp = revString(wholeName);
			wNameE = jcrypt.crypt(salt, wtmp);
			if(fNameE.equals(encryptedPasswd)){
				System.out.printf("Password for %s %s is: %s\n", firstName, lastName, ftmp);
				return true;
			}
			else if (lNameE.equals(encryptedPasswd) ){
				System.out.printf("Password for %s %s is: %s\n", firstName, lastName, ltmp);
				return true;

			}
			else if (wNameE.equals(encryptedPasswd) ){
				System.out.printf("Password for %s %s is: %s\n", firstName, lastName, wtmp);
				return true;
			}

			//duplicateString
			ftmp = duplicateString(firstName);
			fNameE = jcrypt.crypt(salt, ftmp);
			ltmp = duplicateString(lastName);
			lNameE = jcrypt.crypt(salt, ltmp);
			wtmp = duplicateString(wholeName);
			wNameE = jcrypt.crypt(salt, wtmp);
			if(fNameE.equals(encryptedPasswd)){
				System.out.printf("Password for %s %s is: %s\n", firstName, lastName, ftmp);
				return true;
			}
			else if (lNameE.equals(encryptedPasswd) ){
				System.out.printf("Password for %s %s is: %s\n", firstName, lastName, ltmp);
				return true;

			}
			else if (wNameE.equals(encryptedPasswd) ){
				System.out.printf("Password for %s %s is: %s\n", firstName, lastName, wtmp);
				return true;
			}

			//reflectString
			ftmp = reflectString(firstName);
			fNameE = jcrypt.crypt(salt, ftmp);
			ltmp = reflectString(lastName);
			lNameE = jcrypt.crypt(salt, ltmp);
			wtmp = reflectString(wholeName);
			wNameE = jcrypt.crypt(salt, wtmp);
			if(fNameE.equals(encryptedPasswd)){
				System.out.printf("Password for %s %s is: %s\n", firstName, lastName, ftmp);
				return true;
			}
			else if (lNameE.equals(encryptedPasswd) ){
				System.out.printf("Password for %s %s is: %s\n", firstName, lastName, ltmp);
				return true;

			}
			else if (wNameE.equals(encryptedPasswd) ){
				System.out.printf("Password for %s %s is: %s\n", firstName, lastName, wtmp);
				return true;
			}

			//reflectString2
			ftmp = reflectString2(firstName);
			fNameE = jcrypt.crypt(salt, ftmp);
			ltmp = reflectString2(lastName);
			lNameE = jcrypt.crypt(salt, ltmp);
			wtmp = reflectString2(wholeName);
			wNameE = jcrypt.crypt(salt, wtmp);
			if(fNameE.equals(encryptedPasswd)){
				System.out.printf("Password for %s %s is: %s\n", firstName, lastName, ftmp);
				return true;
			}
			else if (lNameE.equals(encryptedPasswd) ){
				System.out.printf("Password for %s %s is: %s\n", firstName, lastName, ltmp);
				return true;

			}
			else if (wNameE.equals(encryptedPasswd) ){
				System.out.printf("Password for %s %s is: %s\n", firstName, lastName, wtmp);
				return true;
			}


			// upCaseString
			ftmp = upCaseString(firstName);
			fNameE = jcrypt.crypt(salt, ftmp);
			ltmp = upCaseString(lastName);
			lNameE = jcrypt.crypt(salt, ltmp);
			wtmp = upCaseString(wholeName);
			wNameE = jcrypt.crypt(salt, wtmp);
			if(fNameE.equals(encryptedPasswd)){
				System.out.printf("Password for %s %s is: %s\n", firstName, lastName, ftmp);
				return true;
			}
			else if (lNameE.equals(encryptedPasswd) ){
				System.out.printf("Password for %s %s is: %s\n", firstName, lastName, ltmp);
				return true;

			}
			else if (wNameE.equals(encryptedPasswd) ){
				System.out.printf("Password for %s %s is: %s\n", firstName, lastName, wtmp);
				return true;
			}

			// lowCaseString
			ftmp = lowCaseString(firstName);
			fNameE = jcrypt.crypt(salt, ftmp);
			ltmp = lowCaseString(lastName);
			lNameE = jcrypt.crypt(salt, ltmp);
			wtmp = lowCaseString(wholeName);
			wNameE = jcrypt.crypt(salt, wtmp);
			if(fNameE.equals(encryptedPasswd)){
				System.out.printf("Password for %s %s is: %s\n", firstName, lastName, ftmp);
				return true;
			}
			else if (lNameE.equals(encryptedPasswd) ){
				System.out.printf("Password for %s %s is: %s\n", firstName, lastName, ltmp);
				return true;

			}
			else if (wNameE.equals(encryptedPasswd) ){
				System.out.printf("Password for %s %s is: %s\n", firstName, lastName, wtmp);
				return true;
			}

			// capitalString
			ftmp = capitalString(firstName);
			fNameE = jcrypt.crypt(salt, ftmp);
			ltmp = capitalString(lastName);
			lNameE = jcrypt.crypt(salt, ltmp);
			wtmp = capitalString(wholeName);
			wNameE = jcrypt.crypt(salt, wtmp);
			if(fNameE.equals(encryptedPasswd)){
				System.out.printf("Password for %s %s is: %s\n", firstName, lastName, ftmp);
				return true;
			}
			else if (lNameE.equals(encryptedPasswd) ){
				System.out.printf("Password for %s %s is: %s\n", firstName, lastName, ltmp);
				return true;

			}
			else if (wNameE.equals(encryptedPasswd) ){
				System.out.printf("Password for %s %s is: %s\n", firstName, lastName, wtmp);
				return true;
			}

			// nCapitalString
			ftmp = nCapitalString(firstName);
			fNameE = jcrypt.crypt(salt, ftmp);
			ltmp = nCapitalString(lastName);
			lNameE = jcrypt.crypt(salt, ltmp);
			wtmp = nCapitalString(wholeName);
			wNameE = jcrypt.crypt(salt, wtmp);
			if(fNameE.equals(encryptedPasswd)){
				System.out.printf("Password for %s %s is: %s\n", firstName, lastName, ftmp);
				return true;
			}
			else if (lNameE.equals(encryptedPasswd) ){
				System.out.printf("Password for %s %s is: %s\n", firstName, lastName, ltmp);
				return true;

			}
			else if (wNameE.equals(encryptedPasswd) ){
				System.out.printf("Password for %s %s is: %s\n", firstName, lastName, wtmp);
				return true;
			}

			// toggleString
			ftmp = toggleString(firstName);
			fNameE = jcrypt.crypt(salt, ftmp);
			ltmp = toggleString(lastName);
			lNameE = jcrypt.crypt(salt, ltmp);
			wtmp = toggleString(wholeName);
			wNameE = jcrypt.crypt(salt, wtmp);
			if(fNameE.equals(encryptedPasswd)){
				System.out.printf("Password for %s %s is: %s\n", firstName, lastName, ftmp);
				return true;
			}
			else if (lNameE.equals(encryptedPasswd) ){
				System.out.printf("Password for %s %s is: %s\n", firstName, lastName, ltmp);
				return true;

			}
			else if (wNameE.equals(encryptedPasswd) ){
				System.out.printf("Password for %s %s is: %s\n", firstName, lastName, wtmp);
				return true;
			}

			// toggleString2
			ftmp = toggleString2(firstName);
			fNameE = jcrypt.crypt(salt, ftmp);
			ltmp = toggleString2(lastName);
			lNameE = jcrypt.crypt(salt, ltmp);
			wtmp = toggleString2(wholeName);
			wNameE = jcrypt.crypt(salt, wtmp);
			if(fNameE.equals(encryptedPasswd)){
				System.out.printf("Password for %s %s is: %s\n", firstName, lastName, ftmp);
				return true;
			}
			else if (lNameE.equals(encryptedPasswd) ){
				System.out.printf("Password for %s %s is: %s\n", firstName, lastName, ltmp);
				return true;

			}
			else if (wNameE.equals(encryptedPasswd) ){
				System.out.printf("Password for %s %s is: %s\n", firstName, lastName, wtmp);
				return true;
			}



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
				case 2:	//prepend
						for(int i = 0; i < characters.length(); i++){

							temp = prepend(dictionary_word, characters.charAt(i));
							encryptedWord = jcrypt.crypt(salt, temp);
							//compare w/ actual encrypted password
							if(encryptedWord.equals(encryptedPasswd)){
								System.out.printf("Password for %s %s is: %s\n", firstName, lastName, temp);
								return true;
							}
						}


						//append
						for(int i = 0; i < characters.length(); i++){

							temp = append(dictionary_word, characters.charAt(i));
							encryptedWord = jcrypt.crypt(salt, temp);
							//compare w/ actual encrypted password
							if(encryptedWord.equals(encryptedPasswd)){
								System.out.printf("Password for %s %s is: %s\n", firstName, lastName, temp);
								return true;
							}
						}


						//delete first char
						temp = deleteFirstChar(dictionary_word);
						encryptedWord = jcrypt.crypt(salt, temp);
						//compare w/ actual encrypted password
						if(encryptedWord.equals(encryptedPasswd)){
							System.out.printf("Password for %s %s is: %s\n", firstName, lastName, temp);
							return true;
						}

						//delete last char
						temp = deleteLastChar(dictionary_word);
						encryptedWord = jcrypt.crypt(salt, temp);
						//compare w/ actual encrypted password
						if(encryptedWord.equals(encryptedPasswd)){
							System.out.printf("Password for %s %s is: %s\n", firstName, lastName, temp);
							return true;
						}

						//revString
						temp = revString(dictionary_word);
						encryptedWord = jcrypt.crypt(salt, temp);
						//compare w/ actual encrypted password
						if(encryptedWord.equals(encryptedPasswd)){
							System.out.printf("Password for %s %s is: %s\n", firstName, lastName, temp);
							return true;
						}


						//duplicateString
						temp = duplicateString(dictionary_word);
						encryptedWord = jcrypt.crypt(salt, temp);
						//compare w/ actual encrypted password
						if(encryptedWord.equals(encryptedPasswd)){
							System.out.printf("Password for %s %s is: %s\n", firstName, lastName, temp);
							return true;
						}


						//reflectString
						temp = reflectString(dictionary_word);
						encryptedWord = jcrypt.crypt(salt, temp);
						//compare w/ actual encrypted password
						if(encryptedWord.equals(encryptedPasswd)){
							System.out.printf("Password for %s %s is: %s\n", firstName, lastName, temp);
							return true;
						}

						//reflectString2
						temp = reflectString2(dictionary_word);
						encryptedWord = jcrypt.crypt(salt, temp);
						//compare w/ actual encrypted password
						if(encryptedWord.equals(encryptedPasswd)){
							System.out.printf("Password for %s %s is: %s\n", firstName, lastName, temp);
							return true;
						}

						//upCaseString
						temp = upCaseString(dictionary_word);
						encryptedWord = jcrypt.crypt(salt, temp);
						//compare w/ actual encrypted password
						if(encryptedWord.equals(encryptedPasswd)){
							System.out.printf("Password for %s %s is: %s\n", firstName, lastName, temp);
							return true;
						}

						//lowCaseString
						temp = lowCaseString(dictionary_word);
						encryptedWord = jcrypt.crypt(salt, temp);
						//compare w/ actual encrypted password
						if(encryptedWord.equals(encryptedPasswd)){
							System.out.printf("Password for %s %s is: %s\n", firstName, lastName, temp);
							return true;
						}


						//capitalString
						temp = capitalString(dictionary_word);
						encryptedWord = jcrypt.crypt(salt, temp);
						//compare w/ actual encrypted password
						if(encryptedWord.equals(encryptedPasswd)){
							System.out.printf("Password for %s %s is: %s\n", firstName, lastName, temp);
							return true;
						}

						//ncapitalString
						temp = nCapitalString(dictionary_word);
						encryptedWord = jcrypt.crypt(salt, temp);
						//compare w/ actual encrypted password
						if(encryptedWord.equals(encryptedPasswd)){
							System.out.printf("Password for %s %s is: %s\n", firstName, lastName, temp);
							return true;
						}

						//toggleString
						temp = toggleString(dictionary_word);
						encryptedWord = jcrypt.crypt(salt, temp);
						//compare w/ actual encrypted password
						if(encryptedWord.equals(encryptedPasswd)){
							System.out.printf("Password for %s %s is: %s\n", firstName, lastName, temp);
							return true;
						}

						//toggleString2
						temp = toggleString2(dictionary_word);
						encryptedWord = jcrypt.crypt(salt, temp);
						//compare w/ actual encrypted password
						if(encryptedWord.equals(encryptedPasswd)){
							System.out.printf("Password for %s %s is: %s\n", firstName, lastName, temp);
							return true;
						}




						break;

				//two mangles
				case 3:
						break;

				default:	break;

				


			}//end switch statement

		}//end dictionary while







		fr_d.close();
		return false;
	}//checkdictionary()


	//********************
	//* Mangle methods
	//********************

	public static String prepend(String w, char c ){
		//String result =	
		return c+w;


	}

	public static String append(String w, char c){
		//String result =	
		return w+c;

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
		String r = w + w;
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


	