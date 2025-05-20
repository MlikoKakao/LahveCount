import java.io.*;
import java.util.ArrayList;

public class LahevUtil{
    public static double PrumerSDPH(ArrayList<Lahev> lahve) {
        if (lahve.isEmpty()) return 0.0;

        double sum = 0.0;
        for (Lahev lahev : lahve) {
            sum += lahev.getCena();
        }

        return sum / lahve.size();
    }

    public static double PrumerBezDPH(ArrayList<Lahev> lahve) {
        if (lahve.isEmpty()) return 0.0;

        double sum = 0.0;
        for (Lahev lahev : lahve) {
            sum += lahev.getCena() - lahev.getDph();
        }

        return sum / lahve.size();
    }

    public static double PrumerMilil(ArrayList<Lahev> lahve) {
        if (lahve.isEmpty()) return 0.0;

        double sum = 0.0;
        for (Lahev lahev : lahve) {
            sum += lahev.getMl();
        }

        return sum / lahve.size();
    }
    public static void exportDoTxt(String filename, ArrayList<Lahev> lahve) {
        File file = new File(filename);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("Název | Barva | Ml | Cena | DPH (%)\n");
            writer.write("--------------------------------------\n");

            for (Lahev lahev : lahve) {
                writer.write(lahev.toString() + "\n");
            }

            System.out.println("Data exportována do:  " + filename);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
    public static void ulozDoSouboru(String nazev, ArrayList<Lahev> lahve) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nazev))) {
            out.writeObject(lahve);
            System.out.println("Data byla úspěšně uložena do souboru: " + nazev);
        } catch (IOException e) {
            System.out.println("Chyba při ukládání: " + e.getMessage());
        }
    }

    public static ArrayList<Lahev> nactiZeSouboru(String nazev) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nazev))) {
            ArrayList<Lahev> lahve = (ArrayList<Lahev>) in.readObject();
            System.out.println("Data byla úspěšně načtena ze souboru: " + nazev);
            return lahve;
        } catch (Exception e) {
            System.out.println("Nastala chyba [" + e + "]");
            return new ArrayList<>();
        }
    }
}
