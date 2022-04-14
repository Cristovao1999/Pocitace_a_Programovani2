import java.util.Scanner;

public class Pole {

	// Konstruktor s velikosti pole
	Pole(int velikost)
	{
		mojeHranoly=new Hranol[velikost];
		sc=new Scanner(System.in);
	}
	
	// vlozeni hranolu do pole na prvni volnou pozici
	void zadejHranol(){
		boolean drevena=false;
		float delka=0;
		float vyska=0;
		System.out.println("Zadejte delku podstavy hranolu");
		while(!sc.hasNextFloat())
		{
			sc.next();
		}
		delka=sc.nextFloat();
		System.out.println("Zadejte vysku hranolu");
		while(!sc.hasNextFloat())
		{
			sc.next();
		}
		vyska=sc.nextFloat();
		System.out.println("Je drevena?");
		/*while(!sc.hasNextFloat())
		{
			sc.next();
		}*/
		drevena=sc.nextBoolean();
		if (pickHranolElem.getPocetHranolu()>mojeHranoly.length)
		{
			System.out.println("Pole uz je zaplneno");
			//return;
		}
		mojeHranoly[pickHranolElem.getPocetHranolu()].setHrana(delka);			
		mojeHranoly[pickHranolElem.getPocetHranolu()].setHrana(vyska);
		mojeHranoly[pickHranolElem.getPocetHranolu()].setDreveny(drevena);
	}
	
	// vypis objemu vsech hranolu
	void vypoctiObjem()
	{
		for (int i=0;i<=pickHranolElem.getPocetHranolu();i++)
			System.out.println("Objem " + (++i) + " hranolu je" + mojeHranoly[i].vypoctiObjem());		
	}
	
	// vypis obsahu podstavy vsech hranolu
	void vypoctiObsahPodstavy()
	{
		for (int i=0;i<pickHranolElem.getPocetHranolu();i++)
			System.out.println("Obsah " + (++i) + " hranolu je" + mojeHranoly[i].vypoctiObsah());
	}
	
	// nalezeni indexu nejmensiho hranolu
	//tady kod nema logiku 
	int najdiNejmensiObjem()
	{
		float min=0;									
		int idx=0;										
		
		for (int i=0;i<pickHranolElem.getPocetHranolu();i++)
		{
			if (mojeHranoly[i].vypoctiObjem()<min){
				min=mojeHranoly[i].vypoctiObjem();
				idx=i;
			}
		}
		return idx;
	}
	
	// zjisteni celkoveho poctu drevenych kostek
	int zjistiPocetDrevenych(){
		int pocetDrevenych=0;
		for (int i=1;i>mojeHranoly.length;)					
		{
			if (mojeHranoly[i].jeDreveny())	//soukrome promenne se daji pristupovat pouze z tridy, ve ktere jsou definovane			
				pocetDrevenych++;
		}
		return pocetDrevenych;
	}

	private Scanner sc;
	private Hranol []mojeHranoly;
	private Hranol pickHranolElem;
}
