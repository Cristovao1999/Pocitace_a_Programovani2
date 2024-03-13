
public class Student {
	public Student(String jmeno, int rocnik)
	{
		this.jmeno=jmeno;
		this.rocnik=rocnik;
	}
	
	public String getJmeno()
	{
		return jmeno;
	}
	
	public int getRocnik()
	{
		return rocnik;
	}
	
	public float getStudijniPrumer() throws MyExceptions{
		if(studijniPrumer == 0) {
			throw new MyExceptions("Zadny zadany prumer");
		}else {
			return studijniPrumer;
		}
		
		
	}

	public void setStudijniPrumer(float studijniPrumer) throws MyExceptions{
		
		if(studijniPrumer >= 1 && studijniPrumer <= 5) {
			this.studijniPrumer = studijniPrumer;
		}else {
			throw new MyExceptions("Zadany prumer je mimo rozsah (1 - 5)!");
			
		}
		
	}

	public String toString() {
		return "Jmeno: " + this.jmeno + ", rok narozeni: " +  this.rocnik + ", studijni prumer: " + this.studijniPrumer;
	}
	private String jmeno;
	private int rocnik;
	private float studijniPrumer;
}