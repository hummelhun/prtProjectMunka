package address.model;

import java.util.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import xml.xmlReadKartya;

public class Game {

	public ObservableList<Kartya> pakli = FXCollections.observableArrayList();
	public ObservableList<Player> jatekosok = FXCollections.observableArrayList();

	public ObservableList<Kartya> kezdoKez1 = FXCollections.observableArrayList();
	public ObservableList<Kartya> kezdoKez2 = FXCollections.observableArrayList();

	public ObservableList<Kartya> lerakottKartyak = FXCollections.observableArrayList();

	public ObservableList<Kartya> player1Trash = FXCollections.observableArrayList();
	public ObservableList<Kartya> player2Trash = FXCollections.observableArrayList();

	public TextArea areaSource;

	public Game() {
	}

	public ObservableList<Kartya> getPakli() {
		return pakli;
	}

	public void setPakli(ObservableList<Kartya> pakli) {
		this.pakli = pakli;
	}

	public ObservableList<Player> getJatekosok() {
		return jatekosok;
	}

	public void setJatekosok(ObservableList<Player> jatekosok) {
		this.jatekosok = jatekosok;
	}

	public ObservableList<Kartya> getKezdoKez1() {
		return kezdoKez1;
	}

	public void setKezdoKez1(ObservableList<Kartya> kezdoKez1) {
		this.kezdoKez1 = kezdoKez1;
	}

	public ObservableList<Kartya> getKezdoKez2() {
		return kezdoKez2;
	}

	public void setKezdoKez2(ObservableList<Kartya> kezdoKez2) {
		this.kezdoKez2 = kezdoKez2;
	}

	public ObservableList<Kartya> getLerakottKartyak() {
		return lerakottKartyak;
	}

	public void setLerakottKartyak(ObservableList<Kartya> lerakottKartyak) {
		this.lerakottKartyak = lerakottKartyak;
	}

	public ObservableList<Kartya> getPlayer1Trash() {
		return player1Trash;
	}

	public void setPlayer1Trash(ObservableList<Kartya> player1Trash) {
		this.player1Trash = player1Trash;
	}

	public ObservableList<Kartya> getPlayer2Trash() {
		return player2Trash;
	}

	public void setPlayer2Trash(ObservableList<Kartya> player2Trash) {
		this.player2Trash = player2Trash;
	}

	public int getKiHivott() {
		return kiHivott;
	}

	public void setKiHivott(int kiHivott) {
		this.kiHivott = kiHivott;
	}

	public int kiHivott;

	public void jatekotKezd(ObservableList<Kartya> pakli, ObservableList<Kartya> kezdoKez1,
			ObservableList<Kartya> kezdoKez2, ObservableList<Player> jatekosok, int kiHivott) throws Exception {
		pakli.clear();

		// pakli.addAll(xmlReadKartya.xmlKartyaIn());
		// System.out.println(pakli);
		pakli.add(new Kartya("piros", "7", "piros_7.png"));
		pakli.add(new Kartya("piros", "9", "piros_9.png"));
		pakli.add(new Kartya("zold", "7", "zold_7.png"));
		pakli.add(new Kartya("zold", "8", "zold_8.png"));

		pakli.add(new Kartya("piros", "8", "piros_8.png"));
		pakli.add(new Kartya("piros", "10", "piros_10.png"));
		pakli.add(new Kartya("zold", "9", "zold_9.png"));
		pakli.add(new Kartya("zold", "10", "zold_10.png"));

		pakli.add(new Kartya("piros", "14", "piros_asz.png"));
		pakli.add(new Kartya("piros", "13", "piros_kiraly.png"));
		pakli.add(new Kartya("zold", "14", "zold_asz.png"));
		pakli.add(new Kartya("makk", "10", "makk_10.png"));

		// pakli.add(new Kartya("piros", "11", "piros_also.png"));
		// pakli.add(new Kartya("piros", "12", "piros_felso.png"));
		//
		// pakli.add(new Kartya("zold", "11", "piros_also.png"));
		// pakli.add(new Kartya("zold", "12", "piros_felso.png"));
		// pakli.add(new Kartya("zold", "13", "piros_kiraly.png"));
		//
		// pakli.add(new Kartya("makk", "7", "makk_7.png"));
		// pakli.add(new Kartya("makk", "8", "makk_8.png"));
		// pakli.add(new Kartya("makk", "9", "makk_9.png"));
		// pakli.add(new Kartya("makk", "11", "makk_also.png"));
		// pakli.add(new Kartya("makk", "12", "makk_felso.png"));
		// pakli.add(new Kartya("makk", "13", "makk_kiraly.png"));
		// pakli.add(new Kartya("makk", "14", "makk_asz.png"));
		//
		// pakli.add(new Kartya("tok", "7", "tok_7.png"));
		// pakli.add(new Kartya("tok", "8", "tok_8.png"));
		// pakli.add(new Kartya("tok", "9", "tok_9.png"));
		// pakli.add(new Kartya("tok", "10", "tok_10.png"));
		// pakli.add(new Kartya("tok", "11", "tok_also.png"));
		// pakli.add(new Kartya("tok", "12", "tok_felso.png"));
		// pakli.add(new Kartya("tok", "13", "tok_kiraly.png"));
		// pakli.add(new Kartya("tok", "14", "tok_asz.png"));

		Collections.shuffle(pakli);
		kezdoKez1.clear();

		for (int i = 0; i < 4; i++) {
			kezdoKez1.add(pakli.get(i));
		}

		kezdoKez2.clear();
		for (int i = 4; i < 8; i++) {
			kezdoKez2.add(pakli.get(i));
		}

		jatekosok.clear();
		jatekosok.add(new Player("Player1", kezdoKez1));
		jatekosok.add(new Player("Player2", kezdoKez2));

		for (int i = 0; i < 8; i++) {
			pakli.remove(0);
		}
		

	}

	public void dontMelyikNyer(ObservableList<Kartya> lerakottKartyak, ObservableList<Kartya> player1Trash,
			ObservableList<Kartya> player2Trash, TextArea areaSource, int kiHivott) {
		System.out.println("SIZE: "+lerakottKartyak.size());
		if (lerakottKartyak.size() == 2) {

			if (kiHivott == 0) {
				if (lerakottKartyak.get(1).getErtek() == lerakottKartyak.get(0).getErtek()
						|| lerakottKartyak.get(1).getErtek() == "7") {
					for (Kartya kartya : lerakottKartyak) {
						player2Trash.add(kartya);
					}					
					kiHivott = 1;
					areaSource.appendText("A 2. Játékos nyerte a kört\n");
					areaSource.appendText("get(0): "+lerakottKartyak.get(0).getErtek()+"\n");
					areaSource.appendText("get(1): "+lerakottKartyak.get(1).getErtek()+"\n");					
					
				} else {
					for (Kartya kartya : lerakottKartyak) {
						player1Trash.add(kartya);
					}
					areaSource.appendText("A 1. Játékos nyerte a kört\n");
					areaSource.appendText("get(0): "+lerakottKartyak.get(0).getErtek()+"\n");
					areaSource.appendText("get(1): "+lerakottKartyak.get(1).getErtek()+"\n");
				}
			} else if (kiHivott == 1) {
				if (lerakottKartyak.get(1).getErtek() == lerakottKartyak.get(0).getErtek()
						|| lerakottKartyak.get(1).getErtek() == "7") {
					for (Kartya kartya : lerakottKartyak) {
						player1Trash.add(kartya);
					}
					kiHivott = 0;
					areaSource.appendText("A 1. Játékos nyerte a kört\n");
					areaSource.appendText("get(0): "+lerakottKartyak.get(0).getErtek()+"\n");
					areaSource.appendText("get(1): "+lerakottKartyak.get(1).getErtek()+"\n");
				} else {
					for (Kartya kartya : lerakottKartyak) {
						player2Trash.add(kartya);
					}
					areaSource.appendText("A 2. Játékos nyerte a kört\n");
					areaSource.appendText("get(0): "+lerakottKartyak.get(0).getErtek()+"\n");
					areaSource.appendText("get(1): "+lerakottKartyak.get(1).getErtek()+"\n");
				}

			}
			System.out.println("player1 trash: " + player1Trash);
			System.out.println("player2 trash: " + player2Trash);
//			lerakottKartyak.clear();
//			if (!pakli.isEmpty()) {
//				kezFeltoltese();
//			}
//			if (kiHivott==0) {
//				elsoJatekosAHivoKor.setOpacity(1);
//				masodikJatekosAHivoKor.setOpacity(0);
//			}
//			else if (kiHivott==1) {
//				masodikJatekosAHivoKor.setOpacity(1);
//				elsoJatekosAHivoKor.setOpacity(0);
//			}
		}
		
		
	}

}
