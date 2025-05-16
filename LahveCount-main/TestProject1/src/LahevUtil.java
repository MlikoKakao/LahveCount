import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LahevUtil {
    public static double PrumerSDPH(ArrayList<Lahev> lahve) {
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
    public static double PrumerBezDPH(ArrayList<Lahev> lahve) {
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
    public static double PrumerMilil(ArrayList<Lahev> lahve) {
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
    public static void uloz(String filename, ArrayList<Lahev> lahve) {
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
}
