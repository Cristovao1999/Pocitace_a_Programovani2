
public class Potravina extends Zbozi{
	//a) Field
	private int trvanlivost;
	
	//b) Constructor Potravina
	public Potravina( String nazevZbozi, double cenaBezDph, int trvanlivost) {
		super(nazevZbozi, cenaBezDph);
		this.trvanlivost = trvanlivost;
		
	}
	//c) Get and Set 
	public int getTrvanlivost() {
		return trvanlivost;
	}
	public void setTrvanlivost(int trvanlivost) {
		this.trvanlivost = trvanlivost;
	}
	//d) Method implementation
	public String getJednotka() {
		if(trvanlivost == 1) {
			return "den";
		}else if(trvanlivost == 2 || trvanlivost == 3 || trvanlivost == 4) {
			return "dny";
		}
		else {
			return "dnů";
		}
	}
}
