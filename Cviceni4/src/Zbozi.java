
public abstract class Zbozi {
	//a)Fields
	private String nazevZbozi;
	private double cenaBezDph;
	private double dph = 0.21;
	
	//b)Constructor 
	public Zbozi(String nazevZbozi, double cenaBezDph) {
		this.nazevZbozi = nazevZbozi;
		this.cenaBezDph = cenaBezDph;
	}
	//c) get and set
	public String getNazevZbozi() {
		return nazevZbozi;
	}
	public double getCenaBezDph() {
		return   cenaBezDph;
	}
	public void setNazevZbozi(String nazevZbozi) {
		this.nazevZbozi = nazevZbozi;
	}
	public void setCenaBezDph(double cenaBezDph) {
		this.cenaBezDph = cenaBezDph;
	}
	public double getDph() {
		return cenaBezDph*dph + cenaBezDph;
	}
	//d)Abstract method
	public abstract String getJednotka();
	public abstract int getTrvanlivost();
}
