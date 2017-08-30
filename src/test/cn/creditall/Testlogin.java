package cn.creditall;

/*
 *@author zhuhongyan
 *@version ：2017年8月17日 下午3:52:41
 */
import java.util.List;

import org.testng.annotations.Test;

public class Testlogin extends DataDriver {
	@Test
	public void login() throws Exception {
		// 页面初始化
		// 调用页面初始化
		// params代表执行的那一列的数据，login代表sheet的名称
		List<String> list = loginData("params", "login");
		// 数据循环操作
		for (int i = 0; i < list.size(); i++) {
			// 结果页面the expected result page
			// SearchLoginModule login =new SearchLoginModule();
			// 取数据
			WebHomePage home = new WebHomePage();
			String[] Params = list.get(i).split("-");
			// 实际结果与期望结果
			List<String> expectedList = loginData("expectedText", "login");
			// 程序运行所出现的结果,getActual得到程序运行的实际结果
			String actual = home.init().searchHeader.search(Params[0], Params[1]).getLoginActual();
			System.out.println(actual);
			// excel表中的结果
			String expected = expectedList.get(i);
			System.out.println(expected);
			Assertion.verifyEquals(actual, expected);
			// actual代表程序运行的实际结果，expcted代表excel表格的数据
			if (actual.equals(expected)) {
				// 数据写入excel
				writeData("login", 5, i + 1, "case正常");
			} else {
				writeData("login", 5, i + 1, "casebug");
			}
		}
	}
}