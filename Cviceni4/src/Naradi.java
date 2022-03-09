
public class Naradi extends Zbozi{
	//a) Field
	private int zarucniDoba;
	
	//b) Constructor
	public Naradi(String nazevZbozi, double cenaBezDph, int zarucniDoba) {
		super(nazevZbozi, cenaBezDph);
		this.zarucniDoba = zarucniDoba;
	}
	
	//c) Get and Set
	public int getZarucniDoba() {
		return zarucniDoba;
	}
	public void setZarucniDoba(int zarucniDoba) {
		this.zarucniDoba = zarucniDoba;
	}
	
	//d)Method implementation
	public String getJednotka() {
		return "mesicu";
	}
	@Override
	public int getTrvanlivost() {
		return 0;
	}
}
