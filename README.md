UTEID: dtn384; js62724;
FIRSTNAME: Danny; Jenna;
LASTNAME: Nguyen; Saleh;
CSACCOUNT: dannytn; jenna900;
EMAIL: dannytnguyen91@gmail.com; jas009@utexas.edu;

[Program 5]
[Description]
compile with: javac PasswordCrack.java
run with: java PasswordCrack dict passwd

our program takes a password file and scans each line.we get the first name, last name, and then put them together in one name. we also get and store the salt. we then use different functions to test each password to see if any of them are discovered after altering/mangling them. we use append, prepend, delete first char, delete last char, revstring, duplicate string, reflect string, refelctstring2, upcasestring, lowcasestring, capital string, ncapitalstring, togglestring, and togglestring2. Then we try words from the dictionary to see if any of them match. if they do match, then we print out the password for the user.

[Finish]
We tried to finish the whole assignment but could not figure out some of the tests. got 14/20 on the first one and 11/20 on the second

[Test Cases]
[Input of test 1]
https://www.cs.utexas.edu/~byoung/cs361/passwd1

[Output of test 1]
We cracked 14 cases
Password for Michael Ferris is: michael
Password for Samantha Connelly is: amazing
Password for Tyler Jones is: eeffoc
Password for Alexander Brown is: squadro
Password for James Dover is: icious
Password for Benjamin Ewing is: abort6
Password for Morgan Simmons is: rdoctor
Password for Jennifer Elmer is: doorrood
Password for Nicole Rizzo is: keyskeys
Password for Evan Whitney is: Impact
Password for Jack Gibson is: sATCHEL
Password for Victor Esperanza is: THIRTY
Password for Connor Larson is: enoggone

We did not crack 15 cases
No passwords found for Abigail Smith
No passwords found for Caleb Patterson
No passwords found for Nathan Moore
No passwords found for Rachel Saxon
No passwords found for Dustin Hart
No passwords found for Paige Reiser

[Input of test 2]
https://www.cs.utexas.edu/~byoung/cs361/passwd2

[Output of test 2]
We cracked 11 cases
Password for Michael Ferris is: tremors
Password for Abigail Smith is: Saxon
Password for Tyler Jones is: eltneg
Password for James Dover is: enchant$
Password for Benjamin Ewing is: soozzoos
Password for Morgan Simmons is: dIAMETER
Password for Jennifer Elmer is: ElmerJ
Password for Nicole Rizzo is: INDIGNITY
Password for Evan Whitney is: ^bribed
Password for Jack Gibson is: ellows
Password for Caleb Patterson is: zoossooz

We did not crack 9 cases
No passwords found for Samantha Connelly
No passwords found for Alexander Brown
No passwords found for Victor Esperanza
No passwords found for Nathan Moore
No passwords found for Connor Larson
No passwords found for Rachel Saxon
No passwords found for Dustin Hart
No passwords found for Maia Salizar
No passwords found for Paige Reiser




You also need to report the similar results as above. If not, you lose 1.5 points.
If you do not report the two numbers, you will also lose 1.5 points.
