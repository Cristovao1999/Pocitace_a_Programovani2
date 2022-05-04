import java.util.List;
import java.util.ArrayList;

public class Student {
	private String fname;//jmeno
	private String lname;//prijmeni
	private int yearOfBirth;//rok narozeni
	private float average;//studijni prumer
	
	
	public Student(String fname, String lname, int yearOfBirth, float average) {
		this.fname = fname;
		this.lname = lname;
		this.yearOfBirth = yearOfBirth;
        this.average = average;
	}
	public String toString() {
		
		return "Name: " + fname + " Surname: " + lname + "\nYear of birth: " + yearOfBirth + "\nAverage: " + average + "\n";
	}
	
}
