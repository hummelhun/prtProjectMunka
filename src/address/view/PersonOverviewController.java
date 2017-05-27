package address.view;

import java.util.Collections;

import address.MainApp;
import address.model.Game;
import address.model.Kartya;
import address.model.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import xml.xmlReadKartya;
import xml.xmlWriteKartya;


public class PersonOverviewController {
	
	private Game game = new Game();
	private ObservableList<Kartya> pakli = FXCollections.observableArrayList();

	private ObservableList<Player> jatekosok = FXCollections.observableArrayList();

	private ObservableList<Kartya> kezdoKez1 = FXCollections.observableArrayList();
	private ObservableList<Kartya> kezdoKez2 = FXCollections.observableArrayList();

	private ObservableList<Kartya> lerakottKartyak = FXCollections.observableArrayList();

	private ObservableList<Kartya> player1Trash = FXCollections.observableArrayList();
	private ObservableList<Kartya> player2Trash = FXCollections.observableArrayList();
	
	private int kiHivott = 0;
	private int gyoztesJatekos=-1;
	private xmlReadKartya xmlReadKartya = new xmlReadKartya();

	@FXML
	private TableColumn<Kartya, String> szinColumn;

	@FXML
	private TableColumn<Kartya, String> ertekColumn;

	@FXML
	private Label szinLabel;
	@FXML
	private Label ertekLabel;
	@FXML
	private Label kepCimeLabel;

	@FXML
	private ImageView kep;

	@FXML
	private ImageView valasztottKartya1;
	@FXML
	private ImageView valasztottKartya2;

	@FXML
	private ImageView GP1P1;
	@FXML
	private ImageView GP1P2;
	@FXML
	private ImageView GP1P3;
	@FXML
	private ImageView GP1P4;

	@FXML
	private ImageView GP2P1;
	@FXML
	private ImageView GP2P2;
	@FXML
	private ImageView GP2P3;
	@FXML
	private ImageView GP2P4;
	
	@FXML
	private GridPane kartyaPanel1;
	@FXML
	private GridPane kartyaPanel2;
	
	@FXML
	private Circle elsoJatekosAHivoKor;	
	@FXML
	private Circle masodikJatekosAHivoKor;


	

	@FXML
	private void kepHalvanyabb() {
		if (kep.getOpacity() == 0) {
			kep.setOpacity(1);
		} else
			kep.setOpacity(0);
	}

	@FXML
	TextArea areaSource, areaDestiny;

	@FXML
	void atmasoljaSzoveget() {
		areaDestiny.setText("");
		areaDestiny.setText(areaSource.getText());
	}
	

	
	// Reference to the main application.
	private MainApp mainApp;

	public PersonOverviewController() {}
	
	/**
	 * 
	 * @param lapAPanelen
	 * @param jatekosIndex
	 * @param kartyaIndex
	 * 
	 * A grafikus felületen választott kártyák megejelenítéért felelõs metódus
	 */
	private void kartyatValaszt(ImageView lapAPanelen, int jatekosIndex, int kartyaIndex) {
		
//		System.out.println("Lerakott kartyak listája: " + lerakottKartyak);
//		System.out.println("Ki a hívó fél: a(z)" + (kiHivott + 1) + ". jatekos a hívó fél");
		if (lapAPanelen.getImage() != null) {

			System.out.println("valasztott az " + (jatekosIndex + 1) + ". jatekos, az " + (kartyaIndex + 1)
					+ ". sarszamú kartyajat");

			Kartya tmp = new Kartya(jatekosok.get(jatekosIndex).getKez().get(kartyaIndex).getSzin(),
					jatekosok.get(jatekosIndex).getKez().get(kartyaIndex).getErtek(),
					jatekosok.get(jatekosIndex).getKez().get(kartyaIndex).getKepCime());

//			System.out.println("a tmp kártya: " + tmp.toString());
//			System.out.println("lerakott kartya isempty (ha üres TRUE): " + lerakottKartyak.isEmpty());
			if (lerakottKartyak.isEmpty()) {
				lerakottKartyak.add(tmp);
				System.out.println("lerakottKartyak lista tartalma: " + lerakottKartyak);

				valasztottKartya1.setImage(lapAPanelen.getImage());

				Image megintHatlap = new Image("hatlap.png");
				valasztottKartya2.setImage(megintHatlap);

				areaSource.appendText("A(z) " + (jatekosIndex + 1) + ". jatekos, a(z) " + (kartyaIndex + 1)
						+ ". sarszamú kartyajat\n");
				jatekosok.get(jatekosIndex).setKezNull(kartyaIndex, jatekosok.get(jatekosIndex).getKez());
//				System.out.println(jatekosok.get(jatekosIndex).getKez());

				lapAPanelen.setImage(null);

				if (kiHivott == 0) {
					kiHivott = 1;
				} else {
					kiHivott = 0;
				}

			} else {
				lerakottKartyak.add(tmp);
				valasztottKartya2.setImage(lapAPanelen.getImage());
				areaSource.appendText("A(z) " + (jatekosIndex + 1) + ". jatekos, a(z) " + (kartyaIndex + 1)
						+ ". sorszamú kartyajat\n");
				jatekosok.get(jatekosIndex).setKezNull(kartyaIndex, jatekosok.get(jatekosIndex).getKez());
//				System.out.println(jatekosok.get(jatekosIndex).getKez());

				lapAPanelen.setImage(null);
				if (kiHivott == 0) {
					kiHivott = 1;
				} else {
					kiHivott = 0;
				}

			}
		} else {
			System.out.println("ez bizony null");
		}
		System.out.println("------------------");
	}
	

	
	/**
	 * Az adott kör végén eldönti, hogy melyik játék nyeri a lapokat, valamint azt is, hogy ki lesz a következõ körben a hívó fél
	 */
	private void dontMelyikNyer() {
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
			lerakottKartyak.clear();
			
			if (!pakli.isEmpty()) {
				kezFeltoltese();
			}
			if (kiHivott==0) {
				elsoJatekosAHivoKor.setOpacity(1);
				masodikJatekosAHivoKor.setOpacity(0);
			}
			else if (kiHivott==1) {
				masodikJatekosAHivoKor.setOpacity(1);
				elsoJatekosAHivoKor.setOpacity(0);
			}
		}
	}
	
    /**
     * Az adott kör végén a hiányzó lapokat feltölti a pakliból
     */
	private void kezFeltoltese() {
		if (kiHivott == 0) {
			egyesJatekosKezetTolti();
			kettesJatekosKezetTolti();
		} else if (kiHivott == 1) {
			kettesJatekosKezetTolti();
			egyesJatekosKezetTolti();
		}
	}
	
	/**
     * kezFeltoltese() metódus segédmetódusa
     */
	private void egyesJatekosKezetTolti() {
		Image felToltKep;
		for (int i = 0; i < 4; i++) {
			if (jatekosok.get(0).getKez().get(i).getErtek() == null) {
				if (i == 0) {
					jatekosok.get(0).setKez(0, pakli, pakli.get(0).getErtek(), 
													  pakli.get(0).getSzin(),
													  pakli.get(0).getKepCime());
					felToltKep = new Image(pakli.get(0).getKepCime());
					GP1P1.setImage(felToltKep);
				}
				if (i == 1) {
					jatekosok.get(0).setKez(1, pakli, pakli.get(0).getErtek(), 
													  pakli.get(0).getSzin(),
													  pakli.get(0).getKepCime());
					felToltKep = new Image(pakli.get(0).getKepCime());
					GP1P2.setImage(felToltKep);

				}
				if (i == 2) {
					jatekosok.get(0).setKez(2, pakli, pakli.get(0).getErtek(), 
													  pakli.get(0).getSzin(),
													  pakli.get(0).getKepCime());
					felToltKep = new Image(pakli.get(0).getKepCime());
					GP1P3.setImage(felToltKep);

				}
				if (i == 3) {
					jatekosok.get(0).setKez(3, pakli, pakli.get(0).getErtek(), 
													  pakli.get(0).getSzin(),
													  pakli.get(0).getKepCime());
					felToltKep = new Image(pakli.get(0).getKepCime());
					GP1P4.setImage(felToltKep);

				}

				if (!pakli.isEmpty()) {
					pakli.remove(0);
				}
			}
		}

	}
    /**
     * kezFeltoltese() metódus segédmetódusa
     */
	private void kettesJatekosKezetTolti() {
		Image felToltKep;
		for (int i = 0; i < 4; i++) {
			if (jatekosok.get(1).getKez().get(i).getErtek() == null) {
				if (i == 0) {
					jatekosok.get(1).setKez(0, pakli, pakli.get(0).getErtek(), 
													  pakli.get(0).getSzin(),
													  pakli.get(0).getKepCime());
					felToltKep = new Image(pakli.get(0).getKepCime());
					GP2P1.setImage(felToltKep);
				}
				if (i == 1) {
					jatekosok.get(1).setKez(1, pakli, pakli.get(0).getErtek(), 
													  pakli.get(0).getSzin(),
													  pakli.get(0).getKepCime());
					felToltKep = new Image(pakli.get(0).getKepCime());
					GP2P2.setImage(felToltKep);

				}
				if (i == 2) {
					jatekosok.get(1).setKez(2, pakli, pakli.get(0).getErtek(), 
													  pakli.get(0).getSzin(),
													  pakli.get(0).getKepCime());
					felToltKep = new Image(pakli.get(0).getKepCime());
					GP2P3.setImage(felToltKep);

				}
				if (i == 3) {
					jatekosok.get(1).setKez(3, pakli, pakli.get(0).getErtek(), 
													  pakli.get(0).getSzin(),
													  pakli.get(0).getKepCime());
					felToltKep = new Image(pakli.get(0).getKepCime());
					GP2P4.setImage(felToltKep);

				}
				if (!pakli.isEmpty()) {
					pakli.remove(0);
				}

			}
		}
	}
	
	public void feltol() {
		System.out.println("SIZE2: "+lerakottKartyak.size());
		System.out.println("kihovott: "+ kiHivott);
		if (lerakottKartyak.size() == 2) {
			lerakottKartyak.clear();
			if (!pakli.isEmpty()) {
				kezFeltoltese();
			}
			if (kiHivott == 0) {
				elsoJatekosAHivoKor.setOpacity(1);
				masodikJatekosAHivoKor.setOpacity(0);
			} else if (kiHivott == 1) {
				masodikJatekosAHivoKor.setOpacity(1);
				elsoJatekosAHivoKor.setOpacity(0);
			}
		}
	}
    /**
     * A pakli lapjainak és a játékosok kezének elfogyása után eldönti melyik játékos nyert
     */
	public void kiNyert(){
		int counter =0;
		int player1Pontok =0;
		int player2Pontok =0;
		for (Kartya alany : jatekosok.get(0).getKez()) {
			if (alany.getErtek()==null) {
				counter++;
			}
		}
		for (Kartya alany : jatekosok.get(1).getKez()) {
			if (alany.getErtek()==null) {
				counter++;
			}
		}
		System.out.println("A counter értéke: "+ counter);
		
		if (counter==8 && pakli.isEmpty()){
			for (Kartya alany : player1Trash) {
				if (alany.getErtek()=="10" || alany.getErtek()=="14") {
					player1Pontok++;
				}
			}
	
			for (Kartya alany : player2Trash) {
				if (alany.getErtek()=="10" || alany.getErtek()=="14") {
					player2Pontok++;
				}
			}
			if (player1Pontok==player2Pontok) {
				areaSource.appendText("Az 1. Játékos pontjai: " + player1Pontok + "\n");
				areaSource.appendText("Az 2. Játékos pontjai: " + player2Pontok + "\n");
				System.out.println("DÖNTETLEN");
				areaSource.appendText("A játéknak vége, DÖNTETLEN\n");
			}
			else if (player1Pontok>player2Pontok) {
				areaSource.appendText("Az 1. Játékos pontjai: " + player1Pontok + "\n");
				areaSource.appendText("Az 2. Játékos pontjai: " + player2Pontok + "\n");
				System.out.println("NYERT AZ ELSÕ JATÉKOS");
				areaSource.appendText("A játéknak vége, NYERT AZ ELSÕ JATÉKOS\n");
				gyoztesJatekos=0;
	        
			}
			else {
				areaSource.appendText("------------------------------------------\n");
				areaSource.appendText("Az 1. Játékos pontjai: " + player1Pontok + "\n");
				areaSource.appendText("Az 2. Játékos pontjai: " + player2Pontok + "\n");
				System.out.println("NYERT A MÁSODIK JÁTÉKOS");
				areaSource.appendText("A játéknak vége, NYERT A MÁSODIK JÁTÉKOS\n");
				gyoztesJatekos=1;
			}

		}
//		System.out.println("JATEKOS 1 PONTOK: "+ player1Pontok);
//		System.out.println("JATEKOS 2 PONTOK: "+ player2Pontok);
		
	}
	

    /**
     * Pakli beállítása, játékos és kezdõkezek beállítása, játék kezdése
     */
	@FXML
	void jatekKezdese_() throws Exception{
		game.jatekotKezd(pakli, kezdoKez1, kezdoKez2, jatekosok, kiHivott);
	
		Image card = new Image(jatekosok.get(0).getKez().get(0).getKepCime());		
		GP1P1.setImage(card);
		card = new Image(jatekosok.get(0).getKez().get(1).getKepCime());
		GP1P2.setImage(card);
		card = new Image(jatekosok.get(0).getKez().get(2).getKepCime());
		GP1P3.setImage(card);
		card = new Image(jatekosok.get(0).getKez().get(3).getKepCime());
		GP1P4.setImage(card);

		card = new Image(jatekosok.get(1).getKez().get(0).getKepCime());
		GP2P1.setImage(card);
		card = new Image(jatekosok.get(1).getKez().get(1).getKepCime());
		GP2P2.setImage(card);
		card = new Image(jatekosok.get(1).getKez().get(2).getKepCime());
		GP2P3.setImage(card);
		card = new Image(jatekosok.get(1).getKez().get(3).getKepCime());
		GP2P4.setImage(card);

		card = new Image("hatlap.png");
		valasztottKartya1.setImage(card);
		valasztottKartya2.setImage(card);
		areaSource.clear();
		areaSource.appendText("A játék elkezdõdött!\n");
		player1Trash.clear();
		player2Trash.clear();
		kiHivott = 0;		
	}



	@FXML
	private void kattintasElsoKartyan() {
		if (kiHivott == 0) {
			kartyatValaszt(GP1P1, 0, 0);
			dontMelyikNyer();	
//			game.dontMelyikNyer(lerakottKartyak, player1Trash, player2Trash, areaSource, kiHivott);
//			feltol();
			kiNyert();
		}
	}

	@FXML
	private void alsoMasodikonKattintas() {
		if (kiHivott == 0) {
			kartyatValaszt(GP1P2, 0, 1);
			dontMelyikNyer();
//			game.dontMelyikNyer(lerakottKartyak, player1Trash, player2Trash, areaSource, kiHivott);
//			feltol();
			kiNyert();
		}
	}

	@FXML
	private void alsoHarmadikonKattintas() {
		if (kiHivott == 0) {
			kartyatValaszt(GP1P3, 0, 2);
			dontMelyikNyer();
//			game.dontMelyikNyer(lerakottKartyak, player1Trash, player2Trash, areaSource, kiHivott);
//			feltol();
			kiNyert();
		}
	}

	@FXML
	private void alsoNegyedikenKattintas() {
		if (kiHivott == 0) {
			kartyatValaszt(GP1P4, 0, 3);
			dontMelyikNyer();
//			game.dontMelyikNyer(lerakottKartyak, player1Trash, player2Trash, areaSource, kiHivott);
//			feltol();
			kiNyert();
		}
	}

	@FXML
	private void felsoElsonKattintas() {
		if (kiHivott == 1) {
			kartyatValaszt(GP2P1, 1, 0);
			dontMelyikNyer();
//			game.dontMelyikNyer(lerakottKartyak, player1Trash, player2Trash, areaSource, kiHivott);
//			feltol();
			kiNyert();
		}
	}

	@FXML
	private void felsoMasodikonKattintas() {
		if (kiHivott == 1) {
			kartyatValaszt(GP2P2, 1, 1);
			dontMelyikNyer();
//			game.dontMelyikNyer(lerakottKartyak, player1Trash, player2Trash, areaSource, kiHivott);
//			feltol();
			kiNyert();
		}
	}

	@FXML
	private void felsoHarmadikonKattintas() {
		if (kiHivott == 1) {
			kartyatValaszt(GP2P3, 1, 2);
			dontMelyikNyer();
//			game.dontMelyikNyer(lerakottKartyak, player1Trash, player2Trash, areaSource, kiHivott);
//			feltol();
			kiNyert();
		}
	}

	@FXML
	private void felsoNegyedikenKattintas() {
		if (kiHivott == 1) {
			kartyatValaszt(GP2P4, 1, 3);
			dontMelyikNyer();
//			game.dontMelyikNyer(lerakottKartyak, player1Trash, player2Trash, areaSource, kiHivott);
//			feltol();
			kiNyert();
		}
	}
	@FXML
	private void kiMentes() throws Exception{
		xmlWriteKartya xmlWriteKartya = new xmlWriteKartya();
		xmlWriteKartya.xmlKartyaOut(pakli, "pakli.xml");
		xmlWriteKartya.xmlKartyaOut(player1Trash, "player1Trash.xml");
		xmlWriteKartya.xmlKartyaOut(player2Trash, "player2Trash.xml");
		
	}

	
	

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
}
