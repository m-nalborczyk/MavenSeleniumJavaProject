package day35.pack1;

import org.testng.annotations.*;

public class Class1 {

	@Test
	void m1()
	{
		System.out.println("this is @test1 from Class 1");
	}
	@Test
	void m2()
	{
		System.out.println("this is @test2 from Class 1");
	}
	@BeforeMethod
	void m3(){
		System.out.println("this is @beforemethod from Class 1");
	}
	@AfterMethod
	void m4(){
		System.out.println("this is @aftermethod from Class 1");
	}
	
	@BeforeTest
	void m5()
	{
		System.out.println("this is @beforetest method from Class 1...");
	}

	@AfterTest
	void m6()
	{
		System.out.println("this is @aftertest method from Class 1...");
	}
	
	@BeforeSuite
	void bs()
	{
	 System.out.println(" this is Before suite method...");	
	}
	
	@AfterSuite
	void as()
	{
		System.out.println("this is After suite method");
	}
}
