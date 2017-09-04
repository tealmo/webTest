package cn.creditall.Common;

/*
 *@author zhuhongyan
 *@version ：2017年8月17日 下午3:52:41
 */
import org.openqa.selenium.support.PageFactory;

import cn.creditall.Common.TestCase.DriverManager;

/*
 *@author zhuhongyan
 *@version ：2017年8月17日 上午10:15:03
 */
public class Page {
	/**
	 * 构造方法，被所有Page的子类继承，所以每个页面都可以通过自动调用这个方法来初始化页面对象 it auto calls by all
	 * sub-page
	 */
	public Page() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

}
