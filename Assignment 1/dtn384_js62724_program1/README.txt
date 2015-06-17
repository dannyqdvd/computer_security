UTEID: dtn384; js62724;
FIRSTNAME: Danny; Jenna;
LASTNAME: Nguyen; Saleh;
CSACCOUNT: dannytn; jenna900;
EMAIL: dannytnguyen91@gmail.com; jas009@utexas.edu;

[Program 1]
[Description]
By using the Bell and LaPadula security rules, we created a system that validates read and write commands before they are performed in order to prevent information being transmitted in invalid ways.
There is one java file (SecureSystem.java) with all of our classes. We had 7 classes -- InstructionObject, InstructionType, Object, ReferenceMonitor, SecureSystem, SecurityLevel, and Subject. We first manually add 2 subjects (Hal and Lyle) and 2 objects (HObj, which is of a high security level, and LObj which is of a low security level). We store the objects in an array list called ObjectManager which is local to the ReferenceMonitor. Then SecureSystem reads from the file which we parse into InstructionObjects. We send these InstructionObjects to ReferenceMonitor which contains executeRead and executeWrite. These both check the access request of the InstructionObject and make sure they are valid. After doing that, the ReferenceMonitor will execute the commnands.
Use javac *.java to compile our program. To run the program use "java SecureSystem instructionList.txt"

[Finish]
We finished all of the assignment.

[Test Cases]
[Input of test 1]
write Hal HObj 
read Hal 
write Lyle LObj 10
read Hal LObj 
write Lyle HObj 20
write Hal LObj 200
read Hal HObj
read Lyle LObj
read Lyle HObj
foo Lyle LObj
Hi Lyle,This is Hal
The missile launch code is 1234567

[Output of test 1]
Reading from file: instructionList

Bad Instruction
The current state is: 
   LObj has value: 0
   HObj has value: 0
   Lyle has recently read: 0
   Hal has recently read: 0

Bad Instruction
The current state is: 
   LObj has value: 0
   HObj has value: 0
   Lyle has recently read: 0
   Hal has recently read: 0

lyle writes value 10 to lobj
The current state is: 
   LObj has value: 10
   HObj has value: 0
   Lyle has recently read: 0
   Hal has recently read: 0

hal reads lobj
The current state is: 
   LObj has value: 10
   HObj has value: 0
   Lyle has recently read: 0
   Hal has recently read: 10

lyle writes value 20 to hobj
The current state is: 
   LObj has value: 10
   HObj has value: 20
   Lyle has recently read: 0
   Hal has recently read: 10

hal writes value 200 to lobj
The current state is: 
   LObj has value: 10
   HObj has value: 20
   Lyle has recently read: 0
   Hal has recently read: 10

hal reads hobj
The current state is: 
   LObj has value: 10
   HObj has value: 20
   Lyle has recently read: 0
   Hal has recently read: 20

lyle reads lobj
The current state is: 
   LObj has value: 10
   HObj has value: 20
   Lyle has recently read: 10
   Hal has recently read: 20

lyle reads hobj
The current state is: 
   LObj has value: 10
   HObj has value: 20
   Lyle has recently read: 0
   Hal has recently read: 20

Bad Instruction
The current state is: 
   LObj has value: 10
   HObj has value: 20
   Lyle has recently read: 0
   Hal has recently read: 20

Bad Instruction
The current state is: 
   LObj has value: 10
   HObj has value: 20
   Lyle has recently read: 0
   Hal has recently read: 20

Bad Instruction
The current state is: 
   LObj has value: 10
   HObj has value: 20
   Lyle has recently read: 0
   Hal has recently read: 20
   
[Input of test 2]
hi
Hal Lyle HObj
write Lyle LObj 10
foo Lyle LObj
read Hal HObj
write Lyle HObj 30
read Hal LObj 
read Lyle HObj
write Lyle LObj 30
write Hal Hobj 10
write Hal LObj 10

[Output of test 2]
Reading from file: instructionList2

Bad Instruction
The current state is: 
	LObj has value: 0
	HObj has value: 0
	Lyle has recently read : 0
	Hal has recently read : 0

Bad Instruction
The current state is: 
	LObj has value: 0
	HObj has value: 0
	Lyle has recently read : 0
	Hal has recently read : 0

lyle writes value 10 to lobj
The current state is: 
	LObj has value: 10
	HObj has value: 0
	Lyle has recently read : 0
	Hal has recently read : 0

Bad Instruction
The current state is: 
	LObj has value: 10
	HObj has value: 0
	Lyle has recently read : 0
	Hal has recently read : 0

hal reads hobj
The current state is: 
	LObj has value: 10
	HObj has value: 0
	Lyle has recently read : 0
	Hal has recently read : 0

lyle writes value 30 to hobj
The current state is: 
	LObj has value: 10
	HObj has value: 30
	Lyle has recently read : 0
	Hal has recently read : 0

hal reads lobj
The current state is: 
	LObj has value: 10
	HObj has value: 30
	Lyle has recently read : 0
	Hal has recently read : 10

lyle reads hobj
The current state is: 
	LObj has value: 10
	HObj has value: 30
	Lyle has recently read : 0
	Hal has recently read : 10

lyle writes value 30 to lobj
The current state is: 
	LObj has value: 30
	HObj has value: 30
	Lyle has recently read : 0
	Hal has recently read : 10

hal writes value 10 to hobj
The current state is: 
	LObj has value: 30
	HObj has value: 10
	Lyle has recently read : 0
	Hal has recently read : 10

hal writes value 10 to lobj
The current state is: 
	LObj has value: 30
	HObj has value: 10
	Lyle has recently read : 0
	Hal has recently read : 10

Bad Instruction
The current state is: 
	LObj has value: 30
	HObj has value: 10
	Lyle has recently read : 0
	Hal has recently read : 10

[Input of test 3]
write Lyle HObj 20
write Lyle HObj 
read Hal LObj
read Hal Lobj
read Lyle HObj
write Hal HObj 40

[Output of test 3]
Reading from file: instructionList3.txt

lyle writes value 20 to hobj
The current state is: 
	LObj has value: 0
	HObj has value: 20
	Lyle has recently read : 0
	Hal has recently read : 0

Bad Instruction
The current state is: 
	LObj has value: 0
	HObj has value: 20
	Lyle has recently read : 0
	Hal has recently read : 0

hal reads lobj
The current state is: 
	LObj has value: 0
	HObj has value: 20
	Lyle has recently read : 0
	Hal has recently read : 0

hal reads lobj
The current state is: 
	LObj has value: 0
	HObj has value: 20
	Lyle has recently read : 0
	Hal has recently read : 0

lyle reads hobj
The current state is: 
	LObj has value: 0
	HObj has value: 20
	Lyle has recently read : 0
	Hal has recently read : 0

hal writes value 40 to hobj
The current state is: 
	LObj has value: 0
	HObj has value: 40
	Lyle has recently read : 0
	Hal has recently read : 0

[Input of test 4]
write Lyle LObj 10
read Lyle LObj
read Lyle LObj 10
hello
read Hal HObj
read Hal LObj
read LObj Hal
write Lyle HObj 100
write Lyle HObj 346
read Lyle LObj 208
what

[Output of test 4]
Reading from file: instructionList4.txt

lyle writes value 10 to lobj
The current state is: 
	LObj has value: 10
	HObj has value: 0
	Lyle has recently read : 0
	Hal has recently read : 0

lyle reads lobj
The current state is: 
	LObj has value: 10
	HObj has value: 0
	Lyle has recently read : 10
	Hal has recently read : 0

Bad Instruction
The current state is: 
	LObj has value: 10
	HObj has value: 0
	Lyle has recently read : 10
	Hal has recently read : 0

Bad Instruction
The current state is: 
	LObj has value: 10
	HObj has value: 0
	Lyle has recently read : 10
	Hal has recently read : 0

hal reads hobj
The current state is: 
	LObj has value: 10
	HObj has value: 0
	Lyle has recently read : 10
	Hal has recently read : 0

hal reads lobj
The current state is: 
	LObj has value: 10
	HObj has value: 0
	Lyle has recently read : 10
	Hal has recently read : 10

lyle writes value 100 to hobj
The current state is: 
	LObj has value: 10
	HObj has value: 100
	Lyle has recently read : 10
	Hal has recently read : 10

lyle writes value 346 to hobj
The current state is: 
	LObj has value: 10
	HObj has value: 346
	Lyle has recently read : 10
	Hal has recently read : 10

Bad Instruction
The current state is: 
	LObj has value: 10
	HObj has value: 346
	Lyle has recently read : 10
	Hal has recently read : 10

Bad Instruction
The current state is: 
	LObj has value: 10
	HObj has value: 346
	Lyle has recently read : 10
	Hal has recently read : 10

[Output of test 4]