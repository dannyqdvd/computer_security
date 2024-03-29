import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;


public class SecureSystem
{
	List<Subject> subject_list = new ArrayList<Subject>();
	ReferenceMonitor rf = new ReferenceMonitor();

	public SecureSystem(){}

	public void createSubject(String name, SecurityLevel level)
	{
		//create new subject object
		Subject s = new Subject(name,level);
		subject_list.add(s);
	}

	public ReferenceMonitor getReferenceMonitor()
	{
		return rf;
	}

	public static void main (String args[]) throws IOException
	{
		SecureSystem sys = new SecureSystem();

		// LOW and HIGH are constants defined in the SecurityLevel 
        // class, such that HIGH dominates LOW.
		SecurityLevel low  = SecurityLevel.LOW;
		SecurityLevel high = SecurityLevel.HIGH;

		// We add two subjects, one high and one low.
		sys.createSubject("Lyle", low);
		sys.createSubject("Hal", high);

		// We add two objects, one high and one low.
		// sys.getReferenceMonitor().createNewObject("LObj", low);
		// sys.getReferenceMonitor().createNewObject("HObj", high);

		//Read from file and create instruction objects
		File file = null;
		if (0 < args.length) {
		   file = new File(args[0]);
		}

		String foutname = args[1];

		File output = new File (foutname);

		sys.getReferenceMonitor().readfile(sys.subject_list, file, output);


	}
	 
}

/*ReferenceMonitor Class*/
class ReferenceMonitor
{
	List<Object> object_list = new ArrayList<Object>();

	public Object createNewObject(String name, SecurityLevel security_level)
	{
		Object o = new Object(name, security_level);
		object_list.add(o);
		return o;
	}

	public ReferenceMonitor(){}

	public void readfile(List<Subject> subject_list, File file, File output) throws IOException
	{
		// Parse in text file
		System.out.println();
		//File file = new File("instructionList.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;
		System.out.println("Reading from file: " + file);
		System.out.println();

		//file writer for Lyle to write the message out
		//File output = new File ("inputfilename.out");
		BufferedWriter wr = new BufferedWriter(new FileWriter(output));
		Scanner scanner = new Scanner (file);
		
		String bitstream = "";


		while(scanner.hasNext() != false)
		{	line = scanner.nextLine();


				// Create a copy of line and change all chars to uppercase
				String upCase = line.toUpperCase();
				String delim = "[ ]+";
				String[] tokens = upCase.split(delim);


				//READ CASE
				if(tokens[0].equals("READ") && tokens.length == 3)
				{
					//pass back object
					for(int i = 0; i < this.object_list.size(); i++)
					{
						String temp = this.object_list.get(i).objectName;
						//compare to object in command
						if(temp.equalsIgnoreCase(tokens[2])) 
						{
							Object o = this.object_list.get(i);
							ExecuteRead(tokens, o, subject_list);
						}
					}
				}
				//WRITE CASE
				else if(tokens[0].equals("WRITE") && tokens.length == 4 )
				{
					for(int i = 0; i < this.object_list.size(); i++)
					{
						String temp = this.object_list.get(i).objectName;
						
						//compare to object in command
						if(temp.equalsIgnoreCase(tokens[2])) 
						{
							Object o = this.object_list.get(i);
							ExecuteWrite(tokens, o, subject_list, Integer.parseInt(tokens[3]));
							break;
						}
					}
				}

				//CREATE CASE - no op if object exists on any level, sec level is 
				//	equal to the subject; init value is 0
				else if (tokens[0].equals("CREATE") && tokens.length == 3){

					boolean exists = false;
					if(!this.object_list.isEmpty()){
						

						for(int i = 0; i < this.object_list.size(); i++)
						{
							String temp = this.object_list.get(i).objectName;
							
							//compare to object in command-- if an object exists, no op
							if(temp.equalsIgnoreCase(tokens[2])) 
							{
								exists = true;
							}
						}

						if(exists == false){
							ExecuteCreate(tokens, subject_list);
						}
				
					}


					else {
						ExecuteCreate(tokens, subject_list);

					}

				}


				//DESTROY CASE
				else if (tokens[0].equals("DESTROY") && tokens.length == 3){

					for(int i = 0; i < this.object_list.size(); i++)
					{
						String temp = this.object_list.get(i).objectName;
						
						//compare to object in command-- if an object exists, check write access of sub
						if(temp.equalsIgnoreCase(tokens[2])) 
						{
							Object o = this.object_list.get(i);
							ExecuteDestroy(tokens, subject_list, o);
						}


					}
				}

				//write to file
				else if(tokens[0].equals("RUN") && tokens.length == 2){

					if(tokens[1].equalsIgnoreCase("lyle")){

						//check if read value of lyle and write to output file
						for(int i = 0; i < subject_list.size(); i++)
						{
							String temp = subject_list.get(i).subjectName;
							//get subject from name
							if(temp.equalsIgnoreCase("lyle")){

								int valueRead = subject_list.get(i).recent;
								//0010101101...
								bitstream = bitstream + String.valueOf(valueRead);

							}
						}


					}

				}

							
				//BAD CASE
				else
				{	
					InstructionObject bo = new InstructionObject();
					bo.createBadObject();
					//printState(bo, subject_list, "s", "o", 0);
				}

				// while (bitstream.length() < 4){

				// 	String bitstream2 = new String(new BigInteger(bitstream, 2).toByteArray());
				// 	wr.write(bitstream2);
				// 	bitstream = "";

				//}
			//}


		
		}

		br.close();
		fr.close();

		

		//if(!bitstream.equals(null)){

		String bitstream2 = new String(new BigInteger(bitstream, 2).toByteArray());
		wr.write(bitstream2);
		//}

		wr.close();
		
	}

	public void ExecuteDestroy(String[] tokens,  List<Subject> subject_list, Object o)
	{


		//loop through subject list to find correct subject	
		for(int i = 0; i < subject_list.size(); i++)
		{
			String temp = subject_list.get(i).subjectName;

			//get subject from name
			if(temp.equalsIgnoreCase(tokens[1]))
			{	
				//get subject level 
				SecurityLevel sub_sec_levl = subject_list.get(i).subjectLevel;

				//if sub-hi, obj-hi or sub-lo, obj-lo then delete
				if((sub_sec_levl == SecurityLevel.LOW && o.objectLevel == SecurityLevel.HIGH) || (sub_sec_levl == SecurityLevel.HIGH && o.objectLevel == SecurityLevel.HIGH) || (sub_sec_levl == SecurityLevel.LOW && o.objectLevel == SecurityLevel.LOW) ){
					
					//create destroy instr obj
					InstructionObject co = new InstructionObject();
					co.createDestroyObject(tokens[1], tokens[2]);
					object_list.remove(o);

					//printState(co, subject_list, temp, o.objectName, 0 );

					break;
				}
			}
		}
		
	}

	public void ExecuteCreate(String[] tokens,  List<Subject> subject_list)
	{


		//loop through subject list to find correct subject	
		for(int i = 0; i < subject_list.size(); i++)
		{
			String temp = subject_list.get(i).subjectName;

			//get subject from name
			if(temp.equalsIgnoreCase(tokens[1]))
			{	
				//get subject level 
				SecurityLevel sub_sec_levl = subject_list.get(i).subjectLevel;
				Object newObj = createNewObject(tokens[2], sub_sec_levl);

				InstructionObject co = new InstructionObject();
				co.createCreateObject(tokens[1], tokens[2]);
				//printState(co, subject_list, temp, newObj.objectName, 0 );
				return;
			}
		}
		
	}

	public void ExecuteRead(String[] tokens, Object o, List<Subject> subject_list)
	{
		//loop through subject list to find correct subject	
		for(int i = 0; i < subject_list.size(); i++)
		{
			String temp = subject_list.get(i).subjectName;
			//get subject from name
			if(temp.equalsIgnoreCase(tokens[1]))
			{
				//check to see if subject level is greater than object level; 
				//if yes, read and set value of recent
				if((subject_list.get(i).subjectLevel == SecurityLevel.HIGH) || (subject_list.get(i).subjectLevel == SecurityLevel.LOW && o.objectLevel == SecurityLevel.LOW) )
				{
					//set recent to value of object
					subject_list.get(i).recent = o.value;
					//creating instruction object
					InstructionObject ro = new InstructionObject();
					ro.createReadObject(tokens[1], tokens[2]);
					//printState output
					//printState(ro, subject_list, temp, o.objectName, 0);
					return;

				}

				//subject - low, object-high
				else if (subject_list.get(i).subjectLevel == SecurityLevel.LOW && o.objectLevel == SecurityLevel.HIGH)
				{
					//set recent to value of object
					subject_list.get(i).recent = 0;
					//creating instruction object
					InstructionObject ro = new InstructionObject();
					ro.createReadObject(tokens[1], tokens[2]);
					//printState output
					//printState(ro, subject_list, temp, o.objectName, 0);
					return;
				}


			}
		}

		//if no name is found, bad instruction 
		InstructionObject ro = new InstructionObject();
		ro.createBadObject();
		//pass this object to another method in order to print state
		//printState(ro, subject_list, null, null, 0);
	}

	public void ExecuteWrite(String[] tokens, Object o, List<Subject> subject_list, int value)
	{

		//loop through subject list to find correct subject	
		for(int i = 0; i < subject_list.size(); i++)
		{
			String temp = subject_list.get(i).subjectName;

			//get subject from name
			if(temp.equalsIgnoreCase(tokens[1]))
			{
				//check to see if subject level is greater than object level; 
				//slo; or shi ohi
				if((subject_list.get(i).subjectLevel == SecurityLevel.LOW) || (subject_list.get(i).subjectLevel == SecurityLevel.HIGH && o.objectLevel == SecurityLevel.HIGH) )
				{
					//set recent to value of object
					o.value = value;
					//creating instruction object
					InstructionObject wo = new InstructionObject();
					wo.createWriteObject(tokens[1], tokens[2], value);
					//printState output
					//printState(wo, subject_list, temp, o.objectName, value);
					return;
				}

				//subject - high, object- lo
				// else if (subject_list.get(i).subjectLevel == SecurityLevel.HIGH && o.objectLevel == SecurityLevel.HIGH)
				// {
				// 	//creating instruction object
				// 	InstructionObject wo = new InstructionObject();
				// 	wo.createWriteObject(tokens[1], tokens[2], o.value);
				// 	//printState output
				// 	printState(wo, subject_list, temp, o.objectName, value);
				// 	return;
				// } 
			}
		}



		//if no name is found, bad instruction 
		InstructionObject ro = new InstructionObject();
		ro.createBadObject();
		//pass this object to another method in order to print state
		//printState(ro, subject_list, null, null, 0);		
	}

	public void printState(InstructionObject io, List<Subject> subject_list, String subject, String object, int value)
	{
		switch(io.type){
			case READ:
				System.out.println( subject.toLowerCase() + " reads " + object.toLowerCase());
				break;

			case WRITE:
				System.out.println( subject.toLowerCase() + " writes value " + value + " to " + object.toLowerCase());
				break;

			case CREATE:
				System.out.println( subject.toLowerCase() + " creates " + object.toLowerCase());
				break;

			case DESTROY:
				System.out.println( subject.toLowerCase() + " destroys " + object.toLowerCase());
				break;

			default:
				System.out.println("Bad Instruction");
				break;
		}
		System.out.println("The current state is: ");

		//prints out object list
		for (int i = 0; i < this.object_list.size(); i++)
		{
			System.out.println("	" + this.object_list.get(i).objectName + " has value: " +  this.object_list.get(i).value  );
		}
		//prints out subject list
		for (int i = 0; i < subject_list.size(); i++)
		{
			System.out.println("	" + subject_list.get(i).subjectName + " has recently read : " +  subject_list.get(i).recent  );
		}		
		System.out.println();

	}
}

class Object
{
	SecurityLevel objectLevel;
	String objectName;
	int value;

	//Subject constructor
	public Object(String name, SecurityLevel security_level)
	{
		//Created new securityLevel object for subjects
		this.objectLevel = security_level;
		this.objectName = name;
		this.value = 0;
	}	
}

class Subject
{
	SecurityLevel subjectLevel;
	String subjectName;
	int recent = 0;

	//Subject constructor
	public Subject(String name, SecurityLevel security_level)
	{
		//Created new securityLevel object for subjects
		this.subjectLevel = security_level;
		this.subjectName = name;

	}	
}

class InstructionObject
{
	InstructionType type;
	String subjectName;
	String objectName;
	int value;

	public InstructionObject(){}

	public void createReadObject(String sname, String oname)
	{
		this.type = InstructionType.READ;
		this.subjectName = sname;
		this.objectName = oname;
	}
	public void createWriteObject(String sname, String oname, int v)
	{
		this.type = InstructionType.WRITE;
		this.subjectName = sname;
		this.objectName = oname;
		this.value = v;
	}

	public void createBadObject()
	{
		this.type = InstructionType.BAD;
	}

	public void createCreateObject(String sname, String oname)
	{
		this.type = InstructionType.CREATE;
		this.subjectName = sname;
		this.objectName = oname;
	}

	public void createDestroyObject(String sname, String oname)
	{
		this.type = InstructionType.DESTROY;
		this.subjectName = sname;
		this.objectName = oname;
	}

}

enum SecurityLevel 
{
	HIGH,
	LOW
}

enum InstructionType
{
	READ,
	WRITE,
	BAD,	
	CREATE,
	DESTROY,
	RUN
}