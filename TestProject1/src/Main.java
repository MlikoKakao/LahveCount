import java.util.*;
import java.util.Scanner;

import lahev.Lahev;

import java.util.ArrayList;


public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String konec = "";
		
		
		
		ArrayList<Lahev> lahve = new ArrayList<Lahev>();
	do {
		System.out.println("Zápis lahví");
		System.out.println("Jakou akci chcete provést?:");
		System.out.println("P - Přidat, S - smazat, E - export do text., "
							+"AVGw - průměr s DPH, \nAVGo - průměr bez DPH,"
							+ " AVGl - průměrný objem láhve");
		String akce = scanner.next().toUpperCase();
	switch(akce) {
	case("P"): 
		System.out.print("Napiš název lahve: ");	
		String tName = scanner.next();
		System.out.print("Napiš barvu lahve: ");	
		String tBarva = scanner.next();
		System.out.print("Napiš kolik má lahev ml: ");	
		int tMl = scanner.nextInt();
		System.out.print("Napiš jaká je cena lahve: ");	
		int tCena = scanner.nextInt();
		System.out.print("Napiš jaké je DPH: ");	
		int tDph = scanner.nextInt();
			
		Lahev myObj = new Lahev(tName, tBarva, tMl, tCena, tDph);
			System.out.println("Název: "+myObj.getName()+", Barva: "
					+ myObj.getBarva()+", Ml: "+myObj.getMl() +", Cena: "+myObj.getCena()+
					", DPH: "+myObj.getDph());
			
			lahve.add(myObj);
			System.out.println(lahve);
		break;
	case("S"):
		lahve.remove(scanner.nextInt());
	case("E"):
	case("AVGW"):
		System.out.println("Průměrná cena je: "+Average(lahve));
		break;
	case("AVGO"):
		System.out.println("Průměrná cena je: "+ AverageWithout(lahve));
		break;
	case("AVGL"):
		System.out.println("Průměrné ml je: " + AverageMl(lahve));
		break;
			
		
		default: 
			System.out.println("Nezvolil jste žádnou z akcí");
	}
	System.out.print("Napiš Konec pokud chceš končit: ");
	konec = scanner.next();
	} while(!konec.equalsIgnoreCase("konec"));
	}
	

	public static double Average(ArrayList<Lahev> lahve) {
		double prumer=0;
		double sum = 0;
		int count = 0;
		for (Lahev lahev : lahve) {
			sum += lahev.getCena();
			count ++;
			prumer = sum / count;
		}		
		return prumer;
	}
	public static double AverageWithout(ArrayList<Lahev> lahve) {
		double prumerBez=0;
		double sum = 0;
		int count = 0;
		for (Lahev lahev : lahve) {
			sum += lahev.getCena()-lahev.getDph();
			count ++;
			prumerBez = sum / count;
		}		
		return prumerBez;
	}
	public static double AverageMl(ArrayList<Lahev> lahve) {
		double prumerMl=0;
		double sum = 0;
		int count = 0;
		for (Lahev lahev : lahve) {
			sum += lahev.getMl();
			count ++;
			prumerMl = sum / count;
		}		
		return prumerMl;
	}
}
