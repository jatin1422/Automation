import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class Map_lambda {

	public void p() {

		Stream.of("vivek", "rahul", "Rajesh").filter(s -> s.endsWith("h")).map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));

		Stream.of("Sachin", "Anil", "Rajesh", "Rajesh", "rahul").filter(s -> s.length() > 3).sorted()
				.map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

		List<String> names = new ArrayList<String>();

		names.add("Vivek");
		names.add("Vasu");
		names.add("Vihan");
		names.add("anmol");
		names.add("himanshu");
		List<String> names1 = new ArrayList<String>();

		names.add("Viv");
		names.add("Vaf");
		names.add("kihan");
		names.add("nmol");
		names.add("imanshu");

		Stream<String> newstream = Stream.concat(names.stream(), names1.stream());

		// newstream.filter(s -> s.length() > 2).sorted().map(s ->
		// s.toUpperCase()).forEach(s -> System.out.println(s));
		boolean ss = newstream.anyMatch(s -> s.equalsIgnoreCase("Vivek"));

		System.out.println(ss);

	}

	@Test
	public void main() {
		List<String> co = Stream.of("vivek", "rahul", "Rajesh").filter(s -> s.endsWith("h")).map(s -> s.toUpperCase())
				.collect(Collectors.toList());
		co.get(0);

		List<Integer> in = Arrays.asList(1, 2, 67, 4, 3, 53, 3, 53, 3);
		List<Integer> in2 = in.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(in2);
		System.out.println(in2.get(2));
		
		

	}
}
