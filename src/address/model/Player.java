package address.model;

import java.util.List;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Player {

	private final StringProperty nev;
	private final ListProperty<Kartya> kez;

	public Player(String nev, List<Kartya> kez){
		this.nev = new SimpleStringProperty(nev);
		ObservableList<Kartya> observableList = FXCollections.observableArrayList(kez);
	    this.kez = new SimpleListProperty<Kartya>(observableList);
	}
	
	public String getNev(){
		return nev.get();
	}
	public void setNev(String nev){
		this.nev.set(nev);
	}
	public StringProperty nevProperty(){
		return nev;
	}
	//--------------------
	public List<Kartya> getKez(){		
		return kez.get();
	}	
	public void setKez(int index, List<Kartya> kez, String ertek, String szin, String kepCime){
		this.kez.get(index).setErtek(ertek);
		this.kez.get(index).setKepCime(kepCime);
		this.kez.get(index).setSzin(szin);		
	}
	
	public void setKezNull(int index, List<Kartya> kez){
		this.kez.get(index).setErtek(null);
		this.kez.get(index).setKepCime(null);
		this.kez.get(index).setSzin(null);
	}
	public ListProperty<Kartya> kezProperty(){
		return kez;
	}

}