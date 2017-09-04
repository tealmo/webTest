package cn.creditall.Common;


import cn.creditall.Common.TestCase.DriverManager;
import cn.creditall.Page.SearchModule;

/*网站首页*/
public class WebHomePage {
	/**
	 * URL常量，很少用到，一般在起始页用，有时放到配置文件里去统一管理
	 */
	private static final String URL = "http://101.37.76.231:8080/creditall-main/";

	/**
	 * 只有homepage之类的起始页才必要有这个init方法用来打开URL。 return this 表示执行完毕之后页面仍旧在本页。
	 * 如果留在本页，并有页面刷新，就要return new JDHomepage 如果没有页面刷新等页面改变，就return this
	 * 如果跳转到其他页面，就return new xxxPage 这样写的好处，是每个方法的return语句上明确了页面跳转的预期结果
	 */
	public WebHomePage init() {
		DriverManager.getDriver().get(URL);
		System.out.println(URL);
		return this;
	}

	/**
	 * 可供重用的页面模块，作为成员对象在显示这个模块的页面中保存。 这里用了组合的写法（composite）,注意不要滥用继承。
	 */
	public SearchModule searchHeader = new SearchModule();

}
