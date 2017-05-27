package address.model;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@XmlRootElement(name = "kartya")
@XmlAccessorType(XmlAccessType.NONE)
public class Kartya {

	private final StringProperty szin;

	private final StringProperty ertek;

	private final StringProperty kepCime;

	public Kartya() {
		this(null, null, null);
	}

	public Kartya(String szin, String ertek, String kepCime) {
		this.szin = new SimpleStringProperty(szin);
		this.ertek = new SimpleStringProperty(ertek);
		this.kepCime = new SimpleStringProperty(kepCime);
	}
	
	public int kartyaSzorzas(int a, int b){		
		return a*b;
	}
	@XmlElement(name = "szin")
	public void setSzin(String szin) {
		this.szin.set(szin);
	}

	public String getSzin() {
		return szin.get();
	}

	public StringProperty szinProperty() {
		return szin;
	}
	// ----------------------------

	@XmlElement(name = "ertek")
	public void setErtek(String ertek) {
		this.ertek.set(ertek);
	}

	public String getErtek() {
		return ertek.get();
	}

	public StringProperty ertekProperty() {
		return ertek;
	}
	// ----------------------------

	@XmlElement(name = "kepCime")
	public void setKepCime(String kepCime) {
		this.kepCime.set(kepCime);
	}

	public String getKepCime() {
		return kepCime.get();
	}

	public StringProperty kepCimeProperty() {
		return kepCime;
	}

	@Override
	public String toString() {
		return getSzin() + " " + getErtek() + " " + getKepCime();
	}
}