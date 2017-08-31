package cn.creditall;

/*
 *@author zhuhongyan
 *@version ：2017年8月17日 下午3:52:41
 */
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import cn.creditall.ScreenShot;

public class AssertionListener extends TestListenerAdapter {

	private WebDriver driver;

	public AssertionListener(WebDriver driver) {
		this.driver = driver;
	}

	@Override
	public void onTestStart(ITestResult result) {
		Assertion.flag = true;
		Assertion.errors.clear();
	}

	@Override
	// 失败类
	public void onTestFailure(ITestResult tr) {

		if (!Assertion.flag) {
			ScreenShot shot = new ScreenShot(driver);
			shot.takeScreenshot();
			System.out.println(" onTestFailure ");
		}

		super.onTestFailure(tr);
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		this.handleAssertion(tr);
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		System.out.println(tr);
		// TODO Auto-generated method stub
		super.onTestSuccess(tr);
	}

	private int index = 0;

	private void handleAssertion(ITestResult tr) {
		// TODO Auto-generated method stub
		if (!Assertion.flag) {
			Throwable throwable = tr.getThrowable();
			if (throwable == null) {
				throwable = new Throwable();
			}
			StackTraceElement[] traces = throwable.getStackTrace();
			StackTraceElement[] alltrace = new StackTraceElement[0];
			for (Error e : Assertion.errors) {
				StackTraceElement[] errorTraces = e.getStackTrace();
				StackTraceElement[] et = this.getKeyStackTrace(tr, errorTraces);
				StackTraceElement[] message = new StackTraceElement[] { new StackTraceElement(
						"message : " + e.getMessage() + " in method : ", tr.getMethod().getMethodName(),
						tr.getTestClass().getRealClass().getSimpleName(), index) };
				index = 0;
				alltrace = this.merge(alltrace, message);
				alltrace = this.merge(alltrace, et);
			}
			if (traces != null) {
				traces = this.getKeyStackTrace(tr, traces);
				alltrace = this.merge(alltrace, traces);
			}
			throwable.setStackTrace(alltrace);
			tr.setThrowable(throwable);
			Assertion.flag = true;
			Assertion.errors.clear();
			tr.setStatus(ITestResult.FAILURE);
		}
	}

	private StackTraceElement[] getKeyStackTrace(ITestResult tr, StackTraceElement[] stackTraceElements) {
		List<StackTraceElement> ets = new ArrayList<StackTraceElement>();
		for (StackTraceElement stackTraceElement : stackTraceElements) {
			if (stackTraceElement.getClassName().equals(tr.getTestClass().getName())) {
				ets.add(stackTraceElement);
				index = stackTraceElement.getLineNumber();
			}
		}
		StackTraceElement[] et = new StackTraceElement[ets.size()];
		for (int i = 0; i < et.length; i++) {
			et[i] = ets.get(i);
		}
		return et;
	}

	private StackTraceElement[] merge(StackTraceElement[] traces1, StackTraceElement[] traces2) {
		StackTraceElement[] ste = new StackTraceElement[traces1.length + traces2.length];
		for (int i = 0; i < traces1.length; i++) {
			ste[i] = traces1[i];
		}
		for (int i = 0; i < traces2.length; i++) {
			ste[traces1.length + i] = traces2[i];
		}
		return ste;
	}
}
