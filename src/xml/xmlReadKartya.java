package xml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import address.model.Kartya;
import address.model.Pakli;
import javafx.collections.ObservableList;

public class xmlReadKartya {

	public xmlReadKartya() {}

	public static ObservableList<Kartya> xmlKartyaIn() throws Exception{

			File file = new File("file.xml");
			JAXBContext jaxbcontext = JAXBContext.newInstance(Pakli.class);
			Unmarshaller jaxbUnmarshaller = jaxbcontext.createUnmarshaller();
			Pakli pakli = (Pakli) jaxbUnmarshaller.unmarshal(file);

			return pakli.getPakli();
	}
}
