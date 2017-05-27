package xml;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

import address.model.Kartya;
import address.model.Pakli;
import javafx.collections.FXCollections;

import javafx.collections.ObservableList;

public class xmlWriteKartya {
	
	public xmlWriteKartya(){}
	
	public void xmlKartyaOut(List<Kartya> lista, String fajlNev) throws Exception{
		
		Pakli pakli = new Pakli();
		ObservableList<Kartya> kartyak = FXCollections.observableArrayList();
		
		
		kartyak.addAll(lista);
		pakli.setPakli(kartyak);
    	
    	System.out.println("kimentelni való: "+kartyak);   	
    	  
    		File file = new File(fajlNev);
			JAXBContext jaxbcontext = JAXBContext.newInstance(Pakli.class);
			Marshaller jaxbmarshaller = jaxbcontext.createMarshaller();			
			jaxbmarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//			jaxbmarshaller.marshal(kartyak, file);
//			System.out.println(kartyak);
	

			for (Kartya lap : kartyak) {
				jaxbmarshaller.marshal(lap, file);
				jaxbmarshaller.marshal(lap, System.out);
				System.out.println();				
			}
	}

}
