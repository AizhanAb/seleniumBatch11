package TESTNG;

import org.testng.annotations.*;

public class TestNGAnnotations {
    @BeforeSuite
            public void beforeSuite(){
        System.out.println("before suite");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("Beforetest ");
        //you can navigate to website
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("BeforeClass ");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforeMethod");
        //You can login page
    }
    @Test
    public void test1(){
        System.out.println("test 1 ");
    }
    ParameterAnnotation a= new ParameterAnnotation();



    @Test
    public void test2(){
        System.out.println("test 2 ");
    }
    @Test
    public void test3(){
        System.out.println("test 3 ");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod");
        //you can take a screenshot for failed test
        //Driver.quit();
    }
    @AfterTest
    public void afterTest(){
        System.out.println("Beforetest ");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("BeforeClass ");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("after suite");
    }
}
