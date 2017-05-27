package address.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@XmlRootElement(name = "pakli")
@XmlAccessorType(XmlAccessType.FIELD)
public class Pakli {

	@XmlElement(name = "kartya")
	private ObservableList<Kartya> pakli = FXCollections.observableArrayList();

	public ObservableList<Kartya> getPakli() {
		return pakli;
	}

	public void setPakli(ObservableList<Kartya> pakli) {
		this.pakli = pakli;
	}
}
