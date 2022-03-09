
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//a)
		Zbozi[] myObj = new Zbozi[4];
		myObj[0] = new Potravina("Rohlík", 1.5, 1);
		myObj[1] = new Naradi("Kleště", 278.0, 24);
		myObj[2] = new Potravina("Chleba", 20.8, 6);
		myObj[3] = new Potravina("Jablko", 51.0, 20);
		for(int i = 0; i < myObj.length; i++) {
			if(i == 0 || i == 2 || i == 3){
				System.out.println(myObj[i].getNazevZbozi() + ", cena: " + myObj[i].getDph() + ", trvanlivost: " + myObj[i].getTrvanlivost() + " " + myObj[i].getJednotka());
		
			}else{
				System.out.println(myObj[i].getNazevZbozi() + ", cena: " + myObj[i].getDph());
			}
		}
		
	}
}
