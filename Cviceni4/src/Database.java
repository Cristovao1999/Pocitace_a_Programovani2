
import java.util.Scanner;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.List;
import java.io.File;
import java.util.ArrayList;


public class Database {
	private Scanner sc;
	private Technical technical;
	private Humanities humanities;
	private Combined combined;


public Database() {
	technical = new Technical();
	humanities = new Humanities();
	combined = new Combined();
}
	public void addStudent() {
		//Here the options are defined
		sc = new Scanner(System.in);
		boolean run = true;
		while(run) {
			System.out.println("In which study field do you want to register the candidate?");
			System.out.println();
			System.out.println("1. Technical field");
			System.out.println("2. Humanities field");
			System.out.println("3. Combined studies");
			System.out.println("4. Exit");
			int choose = sc.nextInt();
			switch(choose){
				case 1: technical.addNewStudent();
						System.out.println();
					break;
				case 2:	humanities.addNewStudent();
						System.out.println();
					break;
				case 3:	combined.addNewStudent();
						System.out.println();
					break;
				case 4: run = false;
				break;
			}
		}
		
	}
	public void addGrade() {
		sc = new Scanner(System.in);
		boolean run = true;
		while(run) {
			System.out.println("Select the field where the student is registerd!");
			System.out.println();
			System.out.println("1. Technical field");
			System.out.println("2. Humanities field");
			System.out.println("3. Combined studies");
			System.out.println("4. Exit");
			int choose = sc.nextInt();
			switch(choose){
				case 1: technical.addStudentGrade();
						System.out.println();
					break;
				case 2:	humanities.addStudentGrade();
					
					System.out.println();	
					break;
				case 3:	combined.addStudentGrade();
					
					System.out.println();	
					break;
				case 4: run = false;
				break;
			}
		}
		
	}
	
	public void delStudent() {
		System.out.println("Enter student's ID: ");
		int id = sc.nextInt();
		technical.deleteStudent(id);
		humanities.deleteStudent(id);
		combined.deleteStudent(id);
		System.out.println("Student with id: " + id + " is out of database!");
	}

	public void seekStudent() {
		boolean run = true;
		sc = new Scanner(System.in);
		while(run) {
		System.out.println("\tSelect the field to find the student\n");
		System.out.println("1. Technical field");
		System.out.println("2. Humanities field");
		System.out.println("3. Combined studies");
		System.out.println("4. Exit");
		System.out.println();
		int op = sc.nextInt();
			switch(op) {
				case 1: technical.lookForStudent();
						System.out.println();
					break;
				case 2: humanities.lookForStudent();
						System.out.println();
					break;
				case 3:	combined.lookForStudent();
						System.out.println();
					break;
				case 4: run = false;
					break;
			}
		}
	}
	public void numStudents() {
		technical.numOfStudents();
		System.out.println();
		humanities.numOfStudents();
		System.out.println();
		combined.numOfStudents();
	}
	 public void readFile() {
		   try{
			   File file = new File("C:\\Users\\Cristóvão Cristóvão\\Desktop\\Myfile.txt");
			   Scanner read = new Scanner(file);
			   while(read.hasNext()) {
				   System.out.println(read.next());
			   }
		   }catch(Exception e) {
			   System.out.println("File does not exist: " + e.toString());
		   }
	   }
	
	
	
	
}
