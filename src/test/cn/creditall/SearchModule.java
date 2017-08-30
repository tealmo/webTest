package cn.creditall;

/*
 *@author zhuhongyan
 *@version ：2017年8月17日 下午3:52:41
 */
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import cn.creditall.TestCase.DriverManager;

public class SearchModule extends Page{
	/*登录页面元素定位*/
	@FindBy(linkText="登录")
	WebElement login;
	@FindBy(id = "userPhone")
	WebElement userName;

	@FindBy(id="userPassword")
	WebElement passWord;
	
	@FindBy(id="loginPopupBtn")
	WebElement enter;
	
	@FindBy(xpath = ".//*[@id='indexBody']/header/div/ul/li[5]/a")
	WebElement loginOut;
	
	/*投资页面元素定位*/
	@FindBy(linkText = "我要投资")
	WebElement investText;
	//点击投资的产品
	@FindBy(xpath = "html/body/div[2]/div[3]/div[2]/div[1]/input")
	WebElement invest;
	//在投资产品页面输入金额
	@FindBy(id="investAmount")
	WebElement  investAmount;
	//立即投资确认按钮
    @FindBy(xpath="html/body/div[2]/div[2]/div[2]/input")
    WebElement  investClick;
    //支付密码
    @FindBy(id="payPwd")
    WebElement  payPwd;
    //确认按钮
    @FindBy(id="payEnter")
    WebElement  payEnter;
    
    /*登录方法*/

	/**
	 * 点击登录,输入用户名和密码，点击确定
	 * 
	 * @param username  password
	 *            ：搜索关键字
	 * @return 返回一个WebItemPage 
	 */
	public ResultItemPage search(String username,String password) {

		login.click();
		userName.sendKeys(username);
		passWord.sendKeys(password);
		enter.click();
		return new ResultItemPage();
	}
	
	
	
    /*投资方法*/
	public ResultItemPage invest(String paypwd) throws InterruptedException {
		 DriverManager.getDriver().get("http://101.37.76.231:8080/creditall-main/index");
		// TODO Auto-generated method stub
		investText.click();
		invest.click();
		investAmount.sendKeys("100");
		investClick.click();
		Thread.sleep(1000);
		payPwd.sendKeys(paypwd);
		payEnter.click();
		Thread.sleep(1000);
		return new ResultItemPage();
	}
	
    
	
}
