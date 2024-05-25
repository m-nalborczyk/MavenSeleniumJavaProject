package day35.pack1;

import org.testng.annotations.*;

public class Class2 {

	@Test
	void m1()
	{
		System.out.println("this is @test1 from Class 2");
	}
	@Test
	void m2()
	{
		System.out.println("this is @test2 from Class 2");
	}
	@BeforeMethod
	void m3(){
		System.out.println("this is @beforemethod from Class 2");
	}
	@AfterMethod
	void m4(){
		System.out.println("this is @aftermethod from Class 2");
	}

	@BeforeTest
	void m5()
	{
		System.out.println("this is @beforetest method from Class 2...");
	}

	@AfterTest
	void m6()
	{
		System.out.println("this is @aftertest method from Class 2...");
	}

	@BeforeSuite
	void bs()
	{
		System.out.println(" this is Before suite method from class 2...");
	}

	@AfterSuite
	void as()
	{
		System.out.println("this is After suite method from class 2");
	}
	
}
