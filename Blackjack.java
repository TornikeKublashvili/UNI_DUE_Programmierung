
public class Blackjack {
	

//	// Schreiben Sie in die Methode blackjack die Loesung der Aufgabe.
	public static int blackjack(int a, int b) {
		if(a>21||b>21){
			return 0;
		}
		else if(a<0 ||b<0){
			return -1;
		}
		else if(a>=b){
			return a;
		}
		return b;
	}
	 
	//Die Methode main koennen Sie verwenden um die Methode blackjack zu testen.
	public static void main (String[] args) {
		
		System.out.println(blackjack(10,5)); 	//Erwartet: 10
		System.out.println(blackjack(15,31)); 	//Erwartet: 15
		System.out.println(blackjack(3,21));	//Erwartet: 21
		System.out.println(blackjack(50,20));	//Erwartet: 20
		System.out.println(blackjack(15,15));	//Erwartet: 15
		System.out.println(blackjack(21,21));	//Erwartet: 21
		System.out.println(blackjack(30,29));	//Erwartet: 0
		System.out.println(blackjack(10,-1));	//Erwartet: -1
	}

}
