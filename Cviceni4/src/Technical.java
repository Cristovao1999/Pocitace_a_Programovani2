import java.util.List;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Scanner;
import java.io.File;

class Technical extends Field{
	private String fname;//jmeno
	private String lname;//prijmeni
	private int yearOfBirth;//rok narozeni
	
    private TreeMap<Integer, Student> studentList;
    private List<Float> grade;
    private Scanner sc;
    
   public Technical(){
        sc = new Scanner(System.in);
        grade = new ArrayList<>();
        studentList = new TreeMap<>();
 
    }
    public void addNewStudent(){
        System.out.println("\tTECHNICAL FIELD\n");
		System.out.print("Enter student's first name: ");
		fname = sc.next();
		System.out.print("Enter student's last name: ");
		lname = sc.next();
		System.out.print("Enter student's year of birth: ");
		yearOfBirth = sc.nextInt();
		int id = (int) (Math.random() * 1000);
		System.out.println("Your ID is: " + id);
		studentList.put(id, new Student(fname, lname, yearOfBirth, 0.0f));
		System.out.println("Cadidate is successfully registered!");
    }
    @Override
    public void addStudentGrade(){
    	System.out.print("Enter student's ID: ");
        int id = sc.nextInt();
        System.out.print("Enter student's grade: ");
        grade.add(sc.nextFloat());
        float sum = 0;
        for(Float i : grade) {
        	sum = sum + i;
        }
        studentList.put(id, new Student(fname, lname, yearOfBirth, sum/grade.size()));      
    }
   @Override
   public void deleteStudent(int id) {
	   if(studentList.containsKey(id)) {
		   studentList.remove(id);
	   }
   }
   @Override
   public void lookForStudent() {
	   System.out.print("Enter student's ID: ");
	   int id = sc.nextInt();
	   if(studentList.containsKey(id)) {
		   System.out.println(studentList.get(id));
		   System.out.println();
	   }
	   else {
		   System.out.println("Student not found!");
	   }
	   
   }
   @Override
   public void numOfStudents() {
	   System.out.println("\tTECHNICAL FIELD\nTotal of students: " + studentList.size());
   }
   
  
   public void writeFile() {
	   
   }
}