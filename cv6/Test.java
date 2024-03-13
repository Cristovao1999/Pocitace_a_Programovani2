import java.util.Scanner;
import java.io.IOException;
import java.lang.Exception;

public class Test {

	public static int pouzeCelaCisla(Scanner sc) 
	{
		int cislo = 0;
		try
		{
			cislo = sc.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("Nastala vyjimka typu "+e.toString());
			System.out.println("zadejte prosim cele cislo ");
			sc.nextLine();
			cislo = pouzeCelaCisla(sc);
		}
		return cislo;
	}
	
	public static float pouzeCela(Scanner sc) 
	{
		float cislo = 0;
		try
		{
			cislo = sc.nextFloat();
		}
		catch(Exception e)
		{
			System.out.println("Nastala vyjimka typu "+e.toString());
			System.out.println("zadejte prosim desetine cislo ");
			sc.nextLine();
			cislo = pouzeCela(sc);
		}
		return cislo;
	}

	public static void main(String[] args) throws MyExceptions{	
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Databaze mojeDatabaze=new Databaze(1);
		int idx;
		float prumer;
		int volba;
		boolean run=true;
		while(run)
		{
			System.out.println("Vyberte pozadovanou cinnost:");
			System.out.println("1 .. vytvoreni nove databaze");
			System.out.println("2 .. vlozeni noveho studenta");
			System.out.println("3 .. nastaveni prumeru studenta");
			System.out.println("4 .. vypis informace o studentovi");
			System.out.println("5 .. vypis databaze");
			System.out.println("6 .. ulozit do souboru");
			System.out.println("7 .. nacist soubor");
			System.out.println("8 .. ukonceni aplikace");
			volba=pouzeCelaCisla(sc);
			switch(volba)
			{
				case 1:
					System.out.println("Zadejte pocet studentu");
					mojeDatabaze=new Databaze(pouzeCelaCisla(sc));
					break;
				case 2:
					try {
						mojeDatabaze.setStudent();
					}catch(ArrayIndexOutOfBoundsException e){
						System.out.println("Nemate vic poctu studentu!");
					}
						
					break;
				case 3:
					System.out.println("Zadejte index a prumer studenta");
					idx=pouzeCelaCisla(sc);
					prumer=pouzeCela(sc);
					try {
						mojeDatabaze.setPrumer(idx,prumer);
					}catch(ArrayIndexOutOfBoundsException e) {
						System.out.println("Index mimo databaze!");
					}catch(MyExceptions e) {
						System.out.println("Prumer mimo rozsah (1 - 5)!");
					}
						
					break;
				case 4:
					System.out.println("Zadejte index studenta");
					idx=pouzeCelaCisla(sc);
					try {
						Student info=mojeDatabaze.getStudent(idx);
						System.out.println("Jmeno: " + info.getJmeno() + " rok narozeni: " + info.getRocnik() + " prumer: " + info.getStudijniPrumer());
					}catch(ArrayIndexOutOfBoundsException e) {
						System.out.println("Nastala vyjimka typu "+e.toString());
						System.out.println("zadejte prosim vhodny index ");
					}catch(NullPointerException e) {
						System.out.println("Databaze prazdna!");
					}catch(MyExceptions e) {
						System.out.println("Nejdrive musite zadat prumer");
					}

					break;
				case 5:
					try {
						mojeDatabaze.vypisDatabaze();
					}catch(MyExceptions e) {
						System.out.println("Nejdrive musite zadat studijni prumer jednotliveho studenta pro cely vypis databaze");
					}catch(NullPointerException e){
						System.out.println("Nemate zadneho studenta!");
					}
					break;

				case 6:
					try {
						mojeDatabaze.ulozit();
					}catch(NullPointerException e) {
						System.out.println("Databaze prazdna!");
					}
					break;
					
				case 7:
					System.out.print("Zadejte nazev souboru: ");
					String nazev = sc.next();
					mojeDatabaze.nacist(nazev);
					break;
					
				case 8:
					run=false;
					break;
			}
			
		}
	}

}
