package test;



import static org.junit.Assert.assertEquals;


import org.junit.Test;
import address.model.Kartya;


public class KartyaTest {
	
	
	
	@Test
	public void ertekTest(){
		Kartya tester = new Kartya("piros", "10", "piros_10.png");
		assertEquals("Megfelelõ értéket ad át ", "10", tester.getErtek());				
	}
	@Test
	public void test2(){
		
	}
	
	

}
