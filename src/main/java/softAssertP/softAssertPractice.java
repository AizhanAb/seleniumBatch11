package softAssertP;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class softAssertPractice {
    public int getSum(int num1, int num2){
        return num1+num2;
    }
    @Test
    public void hardAssertIntro(){
        Assert.assertEquals(getSum(2,6), 8);
        System.out.println("test1");
        Assert.assertEquals(getSum(0,0), 0);
        System.out.println("test2");
        Assert.assertEquals(getSum(-6,7), -13);
        System.out.println("test1");
    }
    @Test
    public void softAssertIntro(){
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(getSum(2,6), 8);
        System.out.println("test1");
        softAssert.assertEquals(getSum(0,0), 0);
        System.out.println("test2");
        softAssert.assertEquals(getSum(-6,7), -13, "minus");
        System.out.println("test3");
        softAssert.assertAll();
    }
}
