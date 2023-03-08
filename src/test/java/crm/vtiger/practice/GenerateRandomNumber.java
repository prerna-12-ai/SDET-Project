package crm.vtiger.practice;

import com.github.javafaker.Faker;

public class GenerateRandomNumber {
	
	public static void main(String[] args) {
//		int random = new Random().nextInt(1000);
//		System.out.println(random);
		
		long ran = new Faker().number().randomNumber(3, false);
		System.out.println(ran);
		
	}

}
