import java.util.Scanner;
import java.util.Objects;
import java.util.ArrayList;


public class Main {
	
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Lahev> lahve = new ArrayList<>();
        String akce;
        do {
            System.out.println("Zápis lahví");
            System.out.println("Jakou akci chcete provést?:");
            System.out.println("P - Přidat");
            System.out.println("S - Smazat");
            System.out.println("V - Výpis lahví");
            System.out.println("AVGsPDH - Průměr s DPH");
            System.out.println("AVGbezDPH - Průměr bez DPH");
            System.out.println("AVGMl - Průměrný objem láhve");
            System.out.println("E - Export do textového souboru");
            System.out.println("EPC - Export pro přečtení programem");
            System.out.println("N - Načti ze souboru");
            System.out.println("K - Konec programu");

            akce = scanner.next().toUpperCase();
            switch (akce) {
                case "P":
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


                    Lahev myObj = new Lahev(tJmeno, tBarva, tMl, tCena, tDph);
                    double dphProcento = (double) (100 * myObj.getDph()) / myObj.getCena();
                    System.out.println("Název: " + myObj.getJmeno() + ", Barva: "
                            + myObj.getBarva() + ", Ml: " + myObj.getMl() + ", Cena: " + myObj.getCena() +
                            ", DPH: " + dphProcento + "%");

                    lahve.add(myObj);

                    break;
                case "S":
                    System.out.print("Jakou láhev chceš smazat?");
                    lahve.remove(scanner.nextInt() - 1);
                    break;
                case "V":
                    if (lahve.isEmpty()) {
                        System.out.println("Seznam lahví je prázdný.");
                    } else {
                        System.out.println("\n--- Výpis všech lahví ---");
                        for (int i = 0; i < lahve.size(); i++) {
                            System.out.println((i + 1) + ". " + lahve.get(i));
                        }
                    }
                    break;

                case "AVGSPDH":
                    System.out.println("Průměrná cena je: " + LahevUtil.PrumerSDPH(lahve));
                    break;
                case "AVGBEZDPH":
                    System.out.println("Průměrná cena je: " + LahevUtil.PrumerBezDPH(lahve));
                    break;
                case "AVGML":
                    System.out.println("Průměrné ml je: " + LahevUtil.PrumerMilil(lahve));
                    break;
                case "E":
                    LahevUtil.exportDoTxt("bottles.dat", lahve);
                    System.out.println("Exportováno do textového souboru");
                    break;
                case "EPC":
                    LahevUtil.ulozDoSouboru("evidence.dat",lahve);
                case "N":
                    lahve = LahevUtil.nactiZeSouboru("evidence.dat");
                    break;
                default:
                    System.out.println("Nezvolil jste žádnou z akcí");
					break;

            }
        } while (!Objects.equals(akce, "K"));
        scanner.close();
    }
}
	

