import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Database database = new Database();
		boolean run = true;
		int op;
		Scanner sc = new Scanner(System.in);
		while(run) {
			System.out.println("Welcome to BUT database");
			System.out.println();
			System.out.println("1. Add a new student");
			System.out.println("2. Add student grade");
			System.out.println("3. Delete student");
			System.out.println("4. Seek student");
			//System.out.println(5.);e
			//System.out.println(6.);f
			//System.out.println(7.);g
			System.out.println("8. Total number of students from individual fields");
			System.out.println("9. Read text from file");
			//System.out.println();
			System.out.println("11. End");
			op = sc.nextInt();
			switch(op) {
			case 1: database.addStudent();
					System.out.println();
				break;
			case 2: database.addGrade();
					System.out.println();
				break;
			case 3: database.delStudent();
					System.out.println();
				break;
			case 4: database.seekStudent();
					System.out.println();
				break;
			case 5: 
				break;
			case 6: 
				break;
			case 7:
				break;
			case 8: database.numStudents();
					System.out.println();
				break;
			case 9:	database.readFile();
					System.out.println();
				break;
			case 10:
				break;
			case 11: run = false;
				break;
			}
		}
	
	}

}
