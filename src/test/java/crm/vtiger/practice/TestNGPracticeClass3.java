package crm.vtiger.practice;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

//A=65, Z=90,a=97, Z=122, 0=48, 9=57

public class TestNGPracticeClass3 {
	
	SoftAssert soft;
	
	

	@Test
	public void test1() {
		soft=new SoftAssert();
		soft.assertEquals(2, 1);
		System.out.println("Test1 --> class 3");	
		soft.assertAll();
	}

	@Test
	public void test2() {
		soft=new SoftAssert();
		soft.assertEquals("a", "b");
		System.out.println("Test2 --> class 3");
		soft.assertAll();
	}

	@Test
	public void test3() {
		soft=new SoftAssert();
		soft.assertEquals(22, 2);
		System.out.println("Test3 --> class 3");
		soft.assertAll();
	}


}
