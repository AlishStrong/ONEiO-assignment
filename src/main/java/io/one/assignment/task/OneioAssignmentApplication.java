package io.one.assignment.task;

/*public class OneioAssignmentApplication {
	public static void main(String[] args) {
		String toTest = "1, 2, 3, ;4, 5,";
		testInput(toTest);
//		List<Integer> integerList = new ArrayList<>();
//		for (int i = 1; i <= 20; i++) {
//			integerList.add(i);
//		}
//		System.out.println("Initial list");
//		System.out.println(integerList);;
//
//		System.out.println("=======================");
//		System.out.println("List with Fizz and Buzz");
//		FizzBuzzService fizzBuzzService = new FizzBuzzService();
//		System.out.println(fizzBuzzService.doFizzBuzz(integerList));
	}

	public static void testInput(String toTest) {
		if (
				//toTest.matches(".*[^,\\W].*")
				toTest.replace(" ", "").matches(".*[^,0-9].*|.*,,.*")
			) {
			System.out.println("There are letters");
		} else {
			System.out.println("All ok");
		}
	}
}*/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OneioAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneioAssignmentApplication.class, args);
	}

}

