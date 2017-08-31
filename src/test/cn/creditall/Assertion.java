package cn.creditall;

/*
 *@author zhuhongyan
 *@version ：2017年8月17日 下午3:52:41
 */
import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.internal.TestResult;

import cn.creditall.TestCase.DriverManager;


public class Assertion {
	public static boolean flag = true;
	public static List<Error> errors = new ArrayList<Error>();
	
	public static void verifyEquals(Object actual, Object expected) {
		AssertionListener listener = new AssertionListener(DriverManager.getDriver());
		ITestResult result = new TestResult();
		try {
			Assert.assertEquals(actual, expected);
			result.setStatus(ITestResult.SUCCESS);
			result.setEndMillis(System.currentTimeMillis());
			listener.onTestSuccess(result);
		} catch (Error e) {
			errors.add(e);
			flag = false;
			result.setStatus(ITestResult.FAILURE);
			result.setEndMillis(System.currentTimeMillis());
			listener.onTestFailure(result);
		}
	}

	public static void verifyEquals(Object actual, Object expected, String message) {
		try {
			Assert.assertEquals(actual, expected);
		} catch (Error e) {
			errors.add(e);
			flag = false;
		}
	}
}
