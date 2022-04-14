
public class Test {

	public static void main(String[] args) {
		//vypis obsahu ctverce
		Ctverec square = new Ctverec(20.5f);
		System.out.println("Obsah ctverce je " + square.vypoctiObsah() + " cm");
		
		Hranol[] hranol = new Hranol[] {
				new Hranol(23.5f, 2.6f, false),
				new Hranol(2.5f, 3.6f, true),
				new Hranol(3.5f, 32.6f, true)
		};
				
			System.out.println();
			int j = 0;
		for(int i = 0; i < hranol.length; i++) {
			System.out.println("Obsah " + (++j) + " ctverce je " + hranol[i].vypoctiObsah());
		}	
	}

}
