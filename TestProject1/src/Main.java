import java.util.*;
import java.util.Scanner;

import lahev.Lahev;

import java.util.ArrayList;


public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String akce;
		
		System.out.println("Zápis lahví");
		System.out.println("Jakou akci chcete provést?:");
		System.out.println("P - Přidat, S - smazat, E - export do text., "
				+"AVGw - průměr s DPH, \nAVGo - průměr bez DPH,"
				+ " AVGl - průměrný objem láhve");
		akce = scanner.next();
		ArrayList<ArrayList<String>> seznamLahvi = new ArrayList<ArrayList
		<String>>();
		ArrayList<String> lahve = new ArrayList<String>();
	
	switch(akce) {
	case("P"): 
		Lahev myObj = new Lahev(akce, akce, 0, 0, 0);
	System.out.println(myObj.getName());
	System.out.println(myObj.getBarva());
	System.out.println(myObj.getMl());
	System.out.println(myObj.getCena());
	System.out.println(myObj.getDph());
	
	lahve.add(akce);
	System.out.println(lahve);
		break;
		
		
		
		/*String nazev1;
		String ml1;
		System.out.print("Přidej název lahve: ");
		nazev1 = scanner.next();
		System.out.print("Kolik má ml?: ");
		ml1 = scanner.next();
		lahve.add(nazev1);
		lahve.add(ml1);
		seznamLahvi.add(lahve);
		System.out.println(lahve);
	
		
		System.out.println(seznamLahvi);
		System.out.println("Smaž lahev: ");
		seznamLahvi.remove(scanner.nextInt());
		scanner.close();
		System.out.println(seznamLahvi);*/
		default: 
			System.out.println("Nothing happened");
	}
	}
}
