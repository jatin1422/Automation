package Data_Driven;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.Test;

public class Data_Reciever {

	@Test
	public void test() throws IOException {

		File_1 f = new File_1();

		ArrayList l = f.getdata();

		System.out.println(l.get(0));
		System.out.println(l.get(1));

		System.out.println(l.get(2));

	}
}
