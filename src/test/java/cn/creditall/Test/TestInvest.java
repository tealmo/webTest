package cn.creditall.Test;

/*
 *@author zhuhongyan
 *@version ：2017年8月17日 下午3:52:41
 */
import java.util.List;

import org.testng.annotations.Test;

import cn.creditall.Assert.Assertion;
import cn.creditall.Common.LoginCommon;
import cn.creditall.Data.DataDriver;

public class TestInvest extends DataDriver {
	@Test
	public void invest() throws Exception {
		// 页面初始化
		// 结果页面the expected result page
		List<String> list = loginData("params", "invest");
		LoginCommon login = new LoginCommon();
		login.loginCommon();
		for (int i = 0; i < list.size(); i++) {
			// 调用页面初始化：调用公用的方法进行登录
			String params = list.get(i);
			System.out.println(params + "---------------");
			// 取到excel中的期望值的那一列
			List<String> expectedList = loginData("expectedText", "invest");
			// 实际结果的列表
			String actual = login.investHeader.invest(params).getInvestActualPay();
			System.out.println(actual);
			// 期望结果的列表
			String expected = expectedList.get(i);
			Assertion.verifyEquals(actual, expected);
			if (expected.equals(actual)) {
				writeData("invest", 5, i + 1, "case正常");
			} else {
				writeData("invest", 5, i + 1, "casebug");
			}
		}
	}
}
