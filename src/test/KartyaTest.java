package test;



import static org.junit.Assert.assertEquals;


import org.junit.Test;
import address.model.Kartya;


public class KartyaTest {
	
	
	
	@Test
	public void ertekTest(){
		Kartya tester = new Kartya("piros", "10", "piros_10.png");
		assertEquals("Megfelel� �rt�ket ad �t ", "10", tester.getErtek());				
	}
	@Test
	public void test2(){
		Kartya tester = new Kartya("piros", "10", "piros_10.png");
		assertEquals("megfelel� sz�nt ad-e vissza", "piros",  tester.getSzin());
	}
	@Test
	public void test3(){
		Kartya tester = new Kartya("piros", "10", "piros_10.png");
		assertEquals("megfelel� k�pc�met", "piros_10.png",  tester.getKepCime());
	}
	
	

}
