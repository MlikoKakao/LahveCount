import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;


public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Zápis lahví");
		System.out.println("Jakou akci chcete provést?:");
		System.out.println("P - Přidat, S - smazat, E - export do text., "
				+"AVGw - průměr s DPH, \nAVGo - průměr bez DPH,"
				+ " AVGl - průměrný objem láhve");
		
		ArrayList<ArrayList<String>> seznamLahvi = new ArrayList<ArrayList
		<String>>();
		ArrayList<String> lahve = new ArrayList<String>();
	
	
		String nazev1;
		String ml1;
		String nazev2;
		String ml2;
		for(int i=0;i<2;i++) {
		
	
		System.out.print("Přidej název lahve: ");
		nazev1 = scanner.next();
		System.out.print("Kolik má ml?: ");
		ml1 = scanner.next();
		lahve.add(nazev1);
		lahve.add(ml1);
		
		seznamLahvi.add(lahve);
		
		lahve.remove(0);
		lahve.remove(0);
		System.out.println(lahve);
	
		// Hashmap to track each bottle's properties?
		// Or ArrayList with parent-child relationship?
	
		}
		System.out.println(seznamLahvi);
		System.out.println("Smaž lahev: ");
		seznamLahvi.remove(scanner.nextInt());
		scanner.close();
		System.out.println(seznamLahvi);
	}
}
