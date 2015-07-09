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
		System.out.println("Reading file: " + passwd);
		Scanner scanner = new Scanner (passwd);

		while(scanner.hasNextLine() ){
			String line = scanner.nextLine();

			//1. Extract the encrypted password 
			//and salt for that user (see format below);
			String encryptedPasswd = extractEncryptedPasswd(line);
			String salt = "" + encryptedPasswd.charAt(0) + encryptedPasswd.charAt(1);
			//2. Seed the word list with words that the user might have 
			//utilized in constructing his or her password (e.g., his first and last name);
			
			//3. With the salt and augmented wordlist, 
			//systematically encrypt words and compare against 
			//the stored encrypted password;
			
			//4. Redo step 3, but using mangled 
			//versions of the words;
			
			//5. Redo step 4, attempting to apply 
			//two mangles to each word.





		}

		//close password file
		fr.close();


		

	}

	public static String extractEncryptedPasswd(String line){

		String[] tokens = line.split(":");
		String encryptedPasswd = tokens[1];
		return encryptedPasswd;



	}

}
