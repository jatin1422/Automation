package Testng;

import org.testng.annotations.Test;

public class New {
	
 int a;
	public New(int a) {
		
		this.a = a;
		
	}
	
	@Test
	public int se() {
		
		a = a+1;
		
		return a;
	}
	
	
}
