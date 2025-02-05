package lahev;

import java.io.Serializable;

public class Lahev implements Serializable {
	private String name;
	private String barva;
	private int ml;
	private int cena;
	private int dph;
	
	public Lahev(String name, String barva, int ml, int cena, int dph) {
		this.name = name;
		this.barva = barva;
		this.ml = ml;
		this.cena = cena;
		this.dph = dph;
		
	
	}
	public String getName() {
		return name;
	}
	public String getBarva() {
		return barva;
	}
	public int getMl() {
		return ml;
	}
	public int getCena() {
		return cena;
	}
	public int getDph() {
		return dph;
	}
	@Override
	public String toString() {
	    double dphProcento = (100.0 * this.getDph()) / this.getCena();
	    return String.format("%s | %s | %d ml | %d Kč | %.2f%% DPH",
	            this.getName(), this.getBarva(), this.getMl(), this.getCena(), dphProcento);
	}
}
