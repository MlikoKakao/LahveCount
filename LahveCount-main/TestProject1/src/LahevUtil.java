import java.io.*;
import java.util.ArrayList;

public class LahevUtil{
    public static double PrumerSDPH(ArrayList<Lahev> lahve) {
        return lahve.stream().mapToDouble(lahev -> lahev.getCena()).average().orElse(0.0);
    }
    public static double PrumerBezDPH(ArrayList<Lahev> lahve) {
        return lahve.stream().mapToDouble(lahev -> lahev.getCena() - lahev.getDph()).average().orElse(0.0);
    }
    public static double PrumerMilil(ArrayList<Lahev> lahve) {
        return lahve.stream().mapToDouble(Lahev::getMl).average().orElse(0.0);
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
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Chyba při načítání: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
