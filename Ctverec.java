class Ctverec {

	private float hrana;
	// vypocet obsahu ctverce
	int vypoctiObsah(){					
		return (int)(hrana*hrana);		
	}
	// zjisteni delky hrany ctverce
	float getHrana(){	//it should be public				
		return hrana;
	}
	// nastaveni delky hrany ctverce
	void setHrana(float delka){		//it should be public	
		hrana=delka;
	}
	// konstruktor se zadanim delky hrany ctverce
	Ctverec(float hrana){		
		
		this.hrana=hrana;	//this je dulezita, aby se lisily		
	}
}
