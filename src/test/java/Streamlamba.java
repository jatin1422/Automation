import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class Streamlamba {

	@Test
	public void first() {

		List<String> names = new ArrayList<String>();

		names.add("Vivek");
		names.add("Vasu");
		names.add("Vihan");
		names.add("anmol");
		names.add("himanshu");

		long Long = names.stream().filter(s -> s.startsWith("V")).count();

		System.out.println(Long);
		names.stream().filter(s -> s.length() > 2).forEach(s -> System.out.println(s));
		names.stream().filter(s->s.length()>2).limit(2).forEach(s->System.out.println(s));
		
	}
}
