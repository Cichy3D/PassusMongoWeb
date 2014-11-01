package pl.passus.app.model;

public class Rekord {

	private String pole;
	private String wartosc;
	private String czas;
	
	public String getPole() {
		return pole;
	}
	public void setPole(String pole) {
		this.pole = pole;
	}
	public String getWartosc() {
		return wartosc;
	}
	public void setWartosc(String wartosc) {
		this.wartosc = wartosc;
	}
	public String getCzas() {
		return czas;
	}
	public void setCzas(String czas) {
		this.czas = czas;
	}
	@Override
	public String toString() {
		return "Rekord [pole=" + pole + ", wartosc=" + wartosc + ", czas="
				+ czas + "]";
	}
	
	
	
}
