package cn.creditall.Common;

import cn.creditall.Page.SearchModule;

/*
 *@author zhuhongyan
 *@version ：2017年8月17日 下午3:52:41
 */
/*登录页面写死。方便其他页面调用,因为后期金福页面进入都需要登录这个页面*/
public class LoginCommon extends TestCase {

	public SearchModule loginCommon() throws InterruptedException {
		// 页面初始化
		WebHomePage home = new WebHomePage();
		home.init();
		// 结果页面the expected result page
		SearchModule login = new SearchModule();
		login.search("18895639352", "123abc");
		Thread.sleep(2000);
		// DriverManager.getDriver().get("http://101.37.76.231:8080/creditall-main/index");
		return new SearchModule();

	}

	public SearchModule investHeader = new SearchModule();

}