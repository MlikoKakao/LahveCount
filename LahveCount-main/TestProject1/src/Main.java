import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import java.util.ArrayList;


public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String konec = "";


		ArrayList<Lahev> lahve = new ArrayList<>();
		do {
			System.out.println("Zápis lahví");
			System.out.println("Jakou akci chcete provést?:");
			System.out.println("P - Přidat, S - smazat, E - export do text., "
					+ "AVGw - průměr s DPH, \nAVGo - průměr bez DPH,"
					+ " AVGl - průměrný objem láhve");
			String akce = scanner.next().toUpperCase();
			switch (akce) {
				case ("P"):
					System.out.print("Napiš název lahve: ");
					String tJmeno = scanner.next();
					System.out.print("Napiš barvu lahve: ");
					String tBarva = scanner.next();
					System.out.print("Napiš kolik má lahev ml: ");
					int tMl = scanner.nextInt();
					System.out.print("Napiš jaká je cena lahve: ");
					int tCena = scanner.nextInt();
					System.out.print("Napiš jaké je DPH: ");
					int tDph = scanner.nextInt();
					double dphProcento;


					Lahev myObj = new Lahev(tJmeno, tBarva, tMl, tCena, tDph);
					dphProcento = (100 * myObj.getDph()) / myObj.getCena();
					System.out.println("Název: " + myObj.getJmeno() + ", Barva: "
							+ myObj.getBarva() + ", Ml: " + myObj.getMl() + ", Cena: " + myObj.getCena() +
							", DPH: " + dphProcento + "%");

					lahve.add(myObj);
					System.out.println(lahve);
					break;
				case ("S"):
					System.out.print("Jakou láhev chceš smazat?");
					lahve.remove(scanner.nextInt() - 1);
					break;
				case ("E"):
					LahevUtil.uloz("bottles.dat", lahve);
					System.out.println("Exportováno do textového souboru");
					break;
				case ("AVGSPDH"):
					System.out.println("Průměrná cena je: " + LahevUtil.PrumerSDPH(lahve));
					break;
				case ("AVGBEZDPH"):
					System.out.println("Průměrná cena je: " + LahevUtil.PrumerBezDPH(lahve));
					break;
				case ("AVGML"):
					System.out.println("Průměrné ml je: " + LahevUtil.PrumerMilil(lahve));
					break;


				default:
					System.out.println("Nezvolil jste žádnou z akcí");
			}
			System.out.print("Napiš Konec pokud chceš končit: ");
			konec = scanner.next();
		} while (!konec.equalsIgnoreCase("konec"));
		scanner.close();
	}
	}
	

