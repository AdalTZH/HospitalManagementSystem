import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;


/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Tan Zhen Hao Adalson
 * Student ID:22001045
 * Class: E65P
 * Date/Time Last modified:3 February 2023
 */



public class WardManagement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//initialise Ward array with ward objects 
		Ward[] wardArr = new Ward[4];
		
		//-------------------
		// Complete code here
		wardArr[0] = new Ward("A","1 Bed, attached bath/toilet",10,535.00);
		wardArr[1] = new Ward("B1","4 Bed, attached bath/toilet",20,266.43);
		wardArr[2] = new Ward("B2","6 Bed, common bath/toilet",20,83.00);
		wardArr[3] = new Ward("C","8 Bed, common bath/toilet",50,37.00);
		//-------------------


		
		//initialise Patient arraylist with patient objects	
		ArrayList<Patient> patientList = new ArrayList<Patient>();
		
		//-------------------
		// Complete code here
		patientList.add(new Patient("111A","John Lee","A",2,"01/12/2022"));
		patientList.add(new Patient("222B","Mary Jane","B1",11,"02/12/2022"));
		patientList.add(new Patient("333C","Abdul Musri","B1",12,"03/12/2022"));
		patientList.add(new Patient("444D","Jane Tan","B2",2,"12/12/2022","",3));
		patientList.add(new Patient("555E","Paul Tan","C",2,"02/11/2022","",4));
		patientList.add(new Patient("666F","Paul Ng","C",3,"03/11/2022","09/11/2022",0));
		patientList.add(new Patient("777G","Wong Kuan","C",4,"02/12/2022"));
		//-------------------



		//display standard menu and ask for option
		int option = -99;
		publicMenu();

		
		//indefinite while loop
		while(option != 9) {
			boolean patientfound = true;
			option = Helper.readInt("\n\033[1mEnter option or 0 for main menu > ");

			//check for  options
			if(option == 0) {
				//display main menu
				publicMenu();
			} else if (option == 1) {
				//list ward info
				displayWardInfo(wardArr);		
			} else if (option == 2) {
				//display patient in ward
				displayPatientList(patientList);
			} else if (option == 3) {
				//admit patient
				admitPatient(patientList);
			} else if (option == 4) {
				//discharged patient
				patientfound = dischargePatient(patientList);
			} else if (option == 5) {
				//Remove patient visit
				patientfound = removePatient(patientList);
			} else if (option == 6) {
				//register visit
				patientfound = registerVisit(patientList);
			} else if (option == 7) {
				//End visit
				patientfound = endVisit(patientList);
			} else if (option == 8) {
				//End visit
				displayWardOverview(patientList, wardArr);
			} else if (option == 9) {
				//log out
				System.out.println("\nGood bye!");
			} else {
				//invalid option chosen
				System.out.println("\033[31m\n*** Invalid option selected ***\033[0m\n");
			}

			//if patient does not exist based on return boolean
			if (!patientfound) {
				System.out.print("\033[1m");
				System.out.print("\033[31m\n*** No such patient in ward ***\033[0m\n");
			}

		}

	} // end of main



	

	//-------------------------------------------------------------------------------------------------------
	//static method to print the standard menu \
	
	//-------------------------------------------------------------------------------------------------------
	public static void publicMenu() {
		//This is to bold text
		System.out.println("\033[1m");
		System.out.print("\033[34m");
		Helper.line(45, "*");
		System.out.println("*****     PATIENT  MANAGEMENT  MENU     *****");
		Helper.line(45, "*");
		System.out.print("\033[39m");
		
		//-------------------
		// Complete code here
		System.out.println("[1] < View all Ward Info >");
		System.out.println("[2] < Display Patient List >");
		System.out.println("[3] < Admit Patient >");
		System.out.println("[4] < Discharge Patient >");
		System.out.println("[5] < Remove Patient >");
		System.out.println("[6] < Register Visit >");
		System.out.println("[7] < End Visit >");
		System.out.println("[8] < Display Ward Overview >");
		System.out.println("[9] < Logout >\n");
		//-------------------

	}



	//-------------------------------------------------------------------------------------------------------
	//static method takes in a ward array and list out ward details in a tabular list
	//-------------------------------------------------------------------------------------------------------
	public static void displayWardInfo(Ward[] wardArr) {

		//-------------------
		// Complete code here
		System.out.println("\033[1m");
		System.out.print("\033[34m");
		Helper.line(24, "*");
		System.out.println("****** Ward Info *******");
		Helper.line(24, "*");
		System.out.print("\033[39m");
		Helper.line(67, "=");
        System.out.println(String.format("| %-5s | %-30s | %9s | %9s |","Ward","Description","Bed Count","Bed Charge"));
		Helper.line(67, "=");
		System.out.print("\033[0m");
		for(int i=0;i<wardArr.length;i++) {
			Ward w = wardArr[i];
			System.out.println(String.format("| %-5s | %-30s | %9d | $%9.2f |",w.getWard(),w.getDescription(),w.getBedCount(),w.getBedCharge()));
			Helper.line(67, "=");
		}
		//-------------------

		System.out.println();
	}


	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and display all the patient information in a tabular list
	//-------------------------------------------------------------------------------------------------------
	public static void displayPatientList(ArrayList<Patient> patientList) {

		//-------------------
		// Complete code here
		System.out.print("\033[1m");
		System.out.print("\033[34m");
		Helper.line(24, "*");
		System.out.println("***** Patient List *****");
		Helper.line(24, "*");
		System.out.print("\033[39m");
		Helper.line(88, "=");
        System.out.println(String.format("| %-5s | %-15s | %-4s | %3s | %11s | %15s | %13s | ", "NRIC4","Name","Ward","Bed","Date Warded","Date discharged","Visitor count"));
		Helper.line(88, "=");
		System.out.print("\033[0m");
		for(int i=0;i<patientList.size();i++) {
			Patient p = patientList.get(i);
			System.out.println(String.format("| %-5s | %-15s | %-4s | %3d | %11s | %15s | %13d | ", p.getNric4(), p.getName(),p.getWard(),p.getBed(),p.getDateWarded(),p.getDateDischarged(),p.getVisitorCount()));
			Helper.line(88, "=");
		}
		//-------------------

	}


	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and performs the admit patient functionality
	//-------------------------------------------------------------------------------------------------------
	public static void admitPatient(ArrayList<Patient> patientList) {

		//-------------------
		// Complete code here
		
		boolean validNric4 = false;
		boolean digitNric = false;
		boolean patientExist = true;
		boolean wardValid = false;
		boolean bedVacant = false;
		
		
		String nric = "";
		String name = "";
		String ward = "";
		int bed = 0;
		
		System.out.println("\033[1m");
		System.out.print("\033[34m");
		Helper.line(25, "*");
		System.out.println("***** Admit Patient *****");
		Helper.line(25, "*");
		System.out.print("\033[39m");
		

		// Check if NRIC4 is valid
		while(!validNric4) {
			nric = Helper.readString("Enter patient 4 digit NRIC > ");
			for(int i=0;i<(nric.length())-1;i++) {
				if(Character.isDigit(nric.charAt(i)) && nric.length()==4) {
					digitNric = true;
				}else{
					digitNric=false;
					break;
					// Break so that the loop will stop running and become true because of the next input	
				}
			}
			if(nric.isEmpty()) {
				System.out.println("\n*** Please enter NRIC4! ***\n");
			}else if(nric.length()>4 || nric.length() <4){
				System.out.println("\033[31m\n*** Invalid NRIC4! Please try again! ***\033[0m\n");
				System.out.print("\033[1m");
				// To prevent error when there is less than 4 characters entered
			}else if(Character.isLetter(nric.charAt((3))) && digitNric) {
				validNric4 = true;
			}else {
				System.out.println("\033[31m\n*** Invalid NRIC4! Please try again! ***\033[0m\n");
				System.out.print("\033[1m");
			}
	    }
		
		// Check if patient name is valid and if patient already exist
		boolean validName = false;
		if(validNric4) {
			while(!validName) {
				name = Helper.readString("Enter patient name > ");
				if(name.isEmpty()) {
					System.out.println("\033[31m\n*** Invalid Name! Please try again! ***\033[0m\n");
					System.out.print("\033[1m");
				}else {
					validName = true;
				}
			}

			
			for(int i=(patientList.size()-1);i>=0;i--) {
				if(patientList.get(i).getDateDischarged().isEmpty() && patientList.get(i).getName().equalsIgnoreCase(name.trim()) && patientList.get(i).getNric4().equalsIgnoreCase(nric.trim())) {
					System.out.println("\033[31m\n*** Patient already exist ***\033[0m\n");
					System.out.print("\033[1m");
					patientExist = true;
					break;
				}else {
					patientExist = false;
				}
			}
			
		}
		// Check if ward is valid and if there is available beds in ward
		if(!patientExist) {
			while(!wardValid) {
				ward = Helper.readString("Enter ward > ");
				if(ward.trim().equalsIgnoreCase("A") || ward.trim().equalsIgnoreCase("B1") || ward.trim().equalsIgnoreCase("B2") || ward.trim().equalsIgnoreCase("C")) {
					wardValid = true;
				}else {
					wardValid = false;
					System.out.println("\033[31m\n*** Invalid Ward! Please try again ***\033[0m\n");
					System.out.print("\033[1m");
				}
			}
		}
		// Check if bed no. is valid and if bed is available
		boolean bedAvailable = false;
		if(wardValid) {
			while(!bedVacant) {
				bed = Helper.readInt("Enter bed > ");
				if(ward.trim().equalsIgnoreCase("A") && bed>0 && bed<=10 || ward.trim().equalsIgnoreCase("B1") && bed>0 && bed<=20 || ward.trim().equalsIgnoreCase("B2") && bed>0 && bed<=20 || ward.trim().equalsIgnoreCase("C") && bed>0 && bed<=50) {
					for(int i=(patientList.size()-1);i>=0;i--) {
						if(patientList.get(i).getWard().equalsIgnoreCase(ward) && patientList.get(i).getBed()==bed && patientList.get(i).getDateDischarged().isEmpty()) {
							System.out.println("\033[31m\n*** Bed occupied! Please select another bed ***\033[0m\n");	
							System.out.print("\033[1m");
							bedAvailable = false;
							break;
						}else {
							bedAvailable = true;
						}
					}
				}else {
					System.out.println("\033[31m\n*** Invalid Bed No.! Please try again ***\033[0m\n");
					System.out.print("\033[1m");
				}
				if(bedAvailable == true) {
					bedVacant = true;
				}

			}
		}
		// Check if date format is valid
		if(bedVacant) {
			Date dateWarded = Helper.readDate("Enter date warded > ");
			name = name.trim().substring(0, 1).toUpperCase() + name.trim().substring(1);
			for(int i = 0;i<name.length();i++) {
				if(name.charAt(i)==' '){
					if(name.charAt(i+1)!=' ') {
						name = name.substring(0,i+1)+ name.substring(i+1,i+2).toUpperCase()+ name.substring(i+2);
					}else if(name.charAt(i+1)==' ' && i==name.length()-1) {
						name=name.substring(0,name.length()-2);
					}else if(name.charAt(i+1)==' '){
						name=name.substring(0,i)+name.substring(i+1);
						i--;
					}
				}
			}
			//To make sure patient name is capitalized even if it is the last name
			ward = ward.toUpperCase();
			nric = nric.toUpperCase();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			String strDateWarded = dateFormat.format(dateWarded);
			patientList.add(new Patient(nric,name,ward,bed,strDateWarded));
			patientList.get(patientList.size()-1).display();
			System.out.println("*** Patient has been added ***");
						
		}
		//-------------------

	}



	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and performs the discharge patient functionality
	//It will return 'true' if the patient record exist
	//-------------------------------------------------------------------------------------------------------
	public static boolean dischargePatient(ArrayList<Patient> patientList) {

		boolean patientfound = false;

		//-------------------
		// Complete code here
		
		System.out.println("\033[1m");
		System.out.print("\033[34m");
		Helper.line(29, "*");
		System.out.println("***** Discharge Patient *****");
		Helper.line(29, "*"); 
		System.out.println("\033[39m");
		
		boolean valid = false;
		// Check if name field is blank
		while(!valid) {
			String name = Helper.readString("Enter patient name > ");
			if(name.isEmpty()) {
				System.out.println("\n\033[31m*** Please Enter Patient Name! ***\033[0m\n");
				System.out.print("\033[1m");
			}else {
				valid=true;
				for(int i=(patientList.size()-1);i>=0;i--) {
					// loop from descending in case patient has more than one visit, most recent visit will be captured
					if(patientList.get(i).getDateDischarged().isEmpty() && patientList.get(i).getName().equalsIgnoreCase(name)) {
						patientList.get(i).display();
						Date dateDischarged = Helper.readDate("Enter date discharged > ");
						SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
						String strDateDischarged = dateFormat.format(dateDischarged);
						patientList.get(i).setDateDischarged(strDateDischarged);
						patientList.get(i).setVisitorCount(0);
						System.out.println("\n*** Patient is discharged ***");
						patientfound=true;
						break;
				    }else if(!patientList.get(i).getDateDischarged().isEmpty() && patientList.get(i).getName().equalsIgnoreCase(name)) {
					System.out.println("\033[31m\n*** Patient has already been discharged ***\033[0m");
					patientfound=true;
					break;
					// break so previous visits will not be captured leading to bug 
				    }
				}
		}	
		}
		//-------------------

		return patientfound;
	}




	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and performs the remove patient functionality
	//It will return 'true' if the patient record exist
	//-------------------------------------------------------------------------------------------------------
	public static boolean removePatient(ArrayList<Patient> patientList) {

		boolean patientfound = false;

		//-------------------
		// Complete code here

		boolean valid = false;
		boolean look = false;
		//to continue looking for records and if other records is not found
		
		System.out.println("\033[1m");
		System.out.print("\033[34m");
		Helper.line(26, "*");
		System.out.println("***** Remove Patient *****");
		Helper.line(26, "*");
		System.out.println("\033[39m");
		
		String name = Helper.readString("Enter patient name > ");

			for(int i=patientList.size()-1;i>=0;i--) {
				// loop from descending in case patient has more than one visit, most recent visit will be captured
				if(patientList.get(i).getName().equalsIgnoreCase(name.trim())) {
					patientList.get(i).display();
					char delete = Helper.readChar("Confirm deletion (y/n) > ");
					boolean deleteValid = false;
					while(!deleteValid) {
						if(Character.toLowerCase(delete)=='y') {
							deleteValid=true;
							patientList.remove(i);
							System.out.println("\n*** Patient has been deleted ***\n");
							patientfound=true;
							char cont = Helper.readChar("Continue looking for previous records? (y/n) > ");
							// Might have more than one patient record
							while(!valid) {
								if (Character.toLowerCase(cont)=='n') {
									look = false;
									valid = true;
									break;
								}else if(Character.toLowerCase(cont)=='y') {
									look = true;
									valid = true;
									i--;
								}else {
									System.out.println("\n\033[31m*** Invalid option ***\033[0m");
									System.out.print("\033[1m");
									cont = Helper.readChar("\nPlease enter a valid option (y/n) > ");
								}
							}

						}else if(Character.toLowerCase(delete)=='n') {
							patientfound=true;
							look = false;
							deleteValid = true;
							break;
						}else {
							System.out.println("\n\033[31m*** Invalid option ***\033[0m");
							System.out.print("\033[1m");
							delete = Helper.readChar("\nPlease enter a valid option (y/n) > ");
					}
						
					}
					
				}
			
		}if(look) {
			System.out.println("\033[31m\n*** No other records can be found ***\033[0m");
		}

			
		//-------------------

		return patientfound;
	}


	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and performs the register visit functionality
	//It will return 'true' if the patient record exist
	//-------------------------------------------------------------------------------------------------------
	public static boolean registerVisit(ArrayList<Patient> patientList) {

		boolean patientfound = false;

		//-------------------
		// Complete code here
		
		boolean valid = false;
		
		System.out.println("\033[1m");
		System.out.print("\033[34m");
		Helper.line(26, "*");
		System.out.println("***** Register Visit *****");
		Helper.line(26, "*");
		System.out.println("\033[39m");
		
		String name = Helper.readString("Enter patient name > ");

		for(int i=patientList.size()-1;i>=0;i--) {
			// loop from descending in case patient has more than one visit, most recent visit will be captured
			if(patientList.get(i).getName().equalsIgnoreCase(name.trim())) {
				patientList.get(i).display();
				patientfound=true;
				if(!patientList.get(i).getDateDischarged().isEmpty()) {
					System.out.println("\033[31m*** Patient has been discharged ***\033[0m");
					break;
				}
				if(patientList.get(i).getVisitorCount()==4) {
					System.out.println("\033[31m*** No additional visitor allowed ***\033[0m");
					break;
				}else if(patientList.get(i).getVisitorCount()<4) {
					System.out.println("*** Only "+(4-patientList.get(i).getVisitorCount())+" visitor(s) allowed ***\n");
					int visitors = Helper.readInt("Enter number of new visitors > ");
					while(!valid) {
						if(visitors<=4-patientList.get(i).getVisitorCount() && visitors>0) {
							valid = true;
							patientList.get(i).setVisitorCount(visitors+patientList.get(i).getVisitorCount());
							System.out.println("\n*** Please proceed to ward ***");
							break;
						}else if(visitors>4-patientList.get(i).getVisitorCount()) {
							System.out.println("\n\033[31m*** Visitors exceeded ***\033[0m");
							System.out.print("\033[1m");
							visitors = Helper.readInt("\nPlease enter valid amount of visitors > ");
						}else if(visitors==0) {
							break;
						}else{
							System.out.println("\n\033[31m*** Invalid amount of visitors ***\033[0m");
							System.out.print("\033[1m");
							visitors = Helper.readInt("\nPlease enter valid amount of visitors > ");
						}
					}
				}
			}
		}
	
		//-------------------

		return patientfound;
	}

	//-------------------------------------------------------------------------------------------------------
	//static method takes in a patient arraylist and performs the end visit functionality
	//It will return 'true' if the patient record exist
	//-------------------------------------------------------------------------------------------------------
	public static boolean endVisit(ArrayList<Patient> patientList) {

		boolean patientfound = false;

		//-------------------
		// Complete code here
		
		boolean valid= false;
		
		System.out.println("\033[1m");
		System.out.print("\033[34m");
		Helper.line(24, "*");
		System.out.println("****** End Visit ******");
		Helper.line(24, "*");
		System.out.println("\033[39m");
		
		
		String name = Helper.readString("Enter patient name > ");

		for(int i=patientList.size()-1;i>=0;i--) {
			// loop from descending in case patient has more than one visit, most recent visit will be captured
			if(patientList.get(i).getName().equalsIgnoreCase(name.trim())) {
				patientList.get(i).display();
				patientfound=true;
				if(!patientList.get(i).getDateDischarged().isEmpty()) {
					System.out.println("\033[31m*** Patient has been discharged ***\033[0m");
					break;
				}else if(patientList.get(i).getVisitorCount()==0) {
					System.out.println("\033[31m*** There are no visitor(s) ***\033[0m");
					break;
				}else if(patientList.get(i).getVisitorCount()<=4 && patientList.get(i).getVisitorCount()>0) {
					int visitors = Helper.readInt("Enter number of visitor(s) leaving > ");
					while(!valid) {
						if(visitors<=patientList.get(i).getVisitorCount() && visitors>0) {
							valid = true;
							patientList.get(i).setVisitorCount(patientList.get(i).getVisitorCount()-visitors);
							System.out.println("\n*** No of visitor(s) still in ward : "+patientList.get(i).getVisitorCount()+" ***");
							break;
						}else if(visitors>patientList.get(i).getVisitorCount()) {
							System.out.println("\n\033[31m*** Visitor(s) leaving is more than visited ***\033[0m");
							System.out.print("\033[1m");
							visitors = Helper.readInt("\nPlease enter valid amount of visitor(s) leaving > ");
						}else if(visitors==0) {
							break;
						}else{
							System.out.println("\n\033[31m*** Invalid amount of visitor(s) ***\033[0m");
							System.out.print("\033[1m");
							visitors = Helper.readInt("\nPlease enter valid amount of visitor(s) leaving > ");
						}
					}
				}
			}
		}
		
		//-------------------

		return patientfound;
	}

	
	
	//------------------------------------------------------------------------------------------------------------
	//static method that takes in a patient arraylist, a ward array and display an overview of the ward information
	//------------------------------------------------------------------------------------------------------------
	public static void displayWardOverview (ArrayList<Patient> patientList, Ward[] wardArr) {

		//-------------------
		// Complete code here
		
		int[] wardPatientArr = new int[4];
		int[] wardVisitorArr = new int[4];
		int totalBedCount = 0;
		int totalPatient = 0;
		int totalVisitor = 0;
		

		
		for(int i=patientList.size()-1;i>=0;i--) {
			if(patientList.get(i).getWard().equals("A") && patientList.get(i).getDateDischarged().isEmpty()) {
				wardPatientArr[0] += 1;
				wardVisitorArr[0] += patientList.get(i).getVisitorCount();
			}else if(patientList.get(i).getWard().equals("B1") && patientList.get(i).getDateDischarged().isEmpty()) {
				wardPatientArr[1] += 1;
				wardVisitorArr[1] += patientList.get(i).getVisitorCount();
			}else if(patientList.get(i).getWard().equals("B2") && patientList.get(i).getDateDischarged().isEmpty()) {
				wardPatientArr[2] += 1;
				wardVisitorArr[2] += patientList.get(i).getVisitorCount();
			}else if(patientList.get(i).getWard().equals("C") && patientList.get(i).getDateDischarged().isEmpty()) {
				wardPatientArr[3] += 1;
				wardVisitorArr[3] += patientList.get(i).getVisitorCount();	
			}
		}
		
		for(int i=0; i<wardArr.length;i++) {
			totalBedCount += wardArr[i].getBedCount();
			totalPatient += wardPatientArr[i];
			totalVisitor += wardVisitorArr[i];
		}

		
		System.out.println("\033[1m");
		System.out.print("\033[34m");
		Helper.line(25, "*");
		System.out.println("***** Ward Overview *****");
		Helper.line(25, "*");
		System.out.println("\033[39m");
		
		System.out.println("<<< Ward Info >>>");
		Helper.line(54, "=");
        System.out.println(String.format("| %-5s | %-30s | %9s |","Ward","Description","Bed Count"));
		Helper.line(54, "=");
		System.out.print("\033[0m");
		for(int i=0;i<wardArr.length;i++) {
			Ward w = wardArr[i];
			System.out.println(String.format("| %-5s | %-30s | %9d |",w.getWard(),w.getDescription(),w.getBedCount()));
			Helper.line(54, "=");
		}
		
		System.out.println("\033[1m");
		System.out.println("<<< Ward Summary >>>");
		Helper.line(53, "=");
		System.out.println(String.format("| %-5s | %-9s | %-13s | %-13s |", "Ward","Bed Count","Patient Count","Visitor Count"));
		Helper.line(53, "=");
		System.out.print("\033[0m");
		for(int i=0;i<wardArr.length;i++) {
			System.out.println(String.format("| %-5s | %9d | %13d | %13d |",wardArr[i].getWard(),wardArr[i].getBedCount(),wardPatientArr[i],wardVisitorArr[i]));
			Helper.line(53, "=");
		}
		System.out.print("\033[1m");

		Helper.line(53, "=");
		System.out.println(String.format("| %-5s | %9d | %13d | %13d |","Total",totalBedCount,totalPatient,totalVisitor));
		Helper.line(53, "=");
		
		
		
		
		
		//-------------------

		}


}