package test;



import static org.junit.Assert.assertEquals;

import org.junit.Test;
import address.model.Kartya;


public class KartyaTest {
	@Test
	public void firstTest(){
		Kartya tester = new Kartya();
		
		assertEquals("asdf", 0, tester.kartyaSzorzas(0, 10));
	}

}
