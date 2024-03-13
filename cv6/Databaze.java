import java.util.Scanner;
import java.io.*;

public class Databaze {
	public Databaze(int pocetPrvku)
	{
		prvkyDatabaze=new Student[pocetPrvku];
		sc=new Scanner(System.in);
		
	}
	
	public void setStudent()
	{
		System.out.println("Zadejte jmeno studenta, rok narozeni");
		String jmeno=sc.next();
		int rok= Test.pouzeCelaCisla(sc); 
		
		prvkyDatabaze[posledniStudent++]=new Student(jmeno,rok);
	}
	
	public Student getStudent(int idx) {
		return prvkyDatabaze[idx];
	}

	
	public void setPrumer(int idx, float prumer) throws MyExceptions
	{
		prvkyDatabaze[idx].setStudijniPrumer(prumer);
	}
	
	public void vypisDatabaze() throws MyExceptions{
		
		for(Student student : prvkyDatabaze) {
			if(student.getStudijniPrumer() == 0) {
				throw new MyExceptions("Nejdrive zadajte studijni prumer");
			}else {
				System.out.println(student);
			}
			
		}
	}
	
	public void ulozit() throws  NullPointerException{
		if (posledniStudent == 0) {
			throw new NullPointerException("Databaze prazdna");
		}else {
			System.out.print("Zadejte nazev souboru: ");
			String nazev = sc.next();
			String cestaSouboru = cesta + nazev + ".txt";
			file = new File(cestaSouboru);
			try{
				if (file.createNewFile()){
					writer = new FileWriter(cestaSouboru);
					for(Student student : prvkyDatabaze) {

						writer.write(student.toString() + "\n");
						
					}writer.close();//zajimava cast programu. *Nejde soubor smazat pokud neni zavren
					System.out.println("Uspesne ulozeno!");
				}else {
					System.out.println("Soubor uz existuje!");
					
//					for(Student student : prvkyDatabaze) {
//						writer.append(student);
//					
//					}writer.close();
				}
			}catch(IOException e) {
				System.out.println("Doslo k chybe!");
				e.printStackTrace();
			}
				
		}
	}


	public void nacist(String nazev) {
		String cestaSouboru = cesta + nazev + ".txt";
		try {
			file = new File(cestaSouboru);
			if(!file.createNewFile()){
				reader = new Scanner(file);
				while(reader.hasNext()) {
					String data = reader.nextLine();
					System.out.println(data);
				}
			}else {
				System.out.println("Soubor neexistuje");
			}

		}catch(IOException e) {
			System.out.println("Doslo k chybe!");
			e.printStackTrace();
		}
		
	}
	private Scanner sc, reader;
	private Student [] prvkyDatabaze;
	private int posledniStudent;
	private String cesta = "C:\\Users\\Cristóvão Cristóvão\\Downloads\\";
	private File file;
	private FileWriter writer;
	
}