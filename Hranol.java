
//Chyba: Cetverec
//Chyba: proc dedit z tridy ctverec, neni logicke
public class Hranol{

	// konstruktor se zadanim delky hrany, vysky a materialu
	Hranol(float podstava,float vyska, boolean drevena){	
		hrana=vyska;
		zeDreva=drevena;
		pocetHranolu++;
	}
	//vypocet obsah hranolu
	 double vypoctiObsah() {
		return (Math.sqrt(3)/4)*hrana*hrana;
	}
	// vypocet objemu hranolu
	 float vypoctiObjem() {
		//chyba: hrana*hrana*hrana;
		return this.hrana*hrana*hrana;		
	}
	
	// nastaveni materialu
	public void setDreveny(boolean dreveny){
		zeDreva=dreveny;
	}
	
	// zjisteni materialu
	public boolean jeDreveny(){
		return zeDreva;
	}
	
	// zjisteni celkoveho poctu existujicich kostek
	//chyba: static int getPocetHranolu()
	public int getPocetHranolu(){
		return pocetHranolu;
	}
	
	// zjisteni vysky hranolu
	//chyba: static float getHrana()
	public  float getHrana(){					
		return hrana;
	}
	// nastaveni vysky hranolu
	public void setHrana(float delka){			
		hrana=delka;
	}
		
	private float hrana;
	private boolean zeDreva;
	//final int pocetHranolu = 0;
	private int pocetHranolu=0;			
	
	
}
