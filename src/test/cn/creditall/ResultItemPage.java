package cn.creditall;

/*
 *@author zhuhongyan
 *@version ：2017年8月17日 下午3:52:41
 */
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/*
 *@author zhuhongyan
 *@version ：2017年8月23日 下午12:43:22
 */
public class ResultItemPage extends Page {

	/* 登录页面 */
	// 实际的结果：注销、登录的按钮位置
	@FindBy(xpath = ".//*[@id='indexBody']/header/div/ul/li[5]/a")
	WebElement logText;

	// 关闭按钮
	@FindBy(xpath = ".//*[@id='loginPopup']/div[1]/a")
	WebElement closeLogin;

	/* 登录的实际结果 */
	public String getLoginActual() throws InterruptedException {
		// 程序运行的结果
		String actualresult = logText.getText();
		if (actualresult.contains("注销")) {
			actualresult = "登录成功";
			ResultItemPage logut = new ResultItemPage();
			logut.clickLogut();

		} else {
			actualresult = "登录失败";
			ResultItemPage login = new ResultItemPage();
			login.reLogin();

		}
		/* System.out.println(actualresult); */
		return actualresult;
	}

	// 注销按钮退出
	public void clickLogut() throws InterruptedException {
		logText.click();
		Thread.sleep(1000);
		logText.click();
	}

	// 重新登录：先关闭
	public void reLogin() throws InterruptedException {
		Thread.sleep(2000);
		closeLogin.click();
		Thread.sleep(1000);
		logText.click();
	}

	/* 投资页面 */
	// 作为判断的元素
	@FindBy(xpath = ".//*[@id='borrowSuccess']/div/span")
	WebElement buySucess;
	// 支付成功的确定
	@FindBy(id = "sure")
	WebElement sure;

	public String getInvestActualPay() throws InterruptedException {
		// 关闭按钮：密码不正确
		String actualPay = buySucess.getText();
		System.out.println("actualPay " + actualPay);
		// equals代表值之间的比较
		if (actualPay.equals("购买成功")) {
			actualPay = "支付成功";
		} else {
			actualPay = "支付失败";
			// actualPay=null;
		}
		return actualPay;
	}

}
