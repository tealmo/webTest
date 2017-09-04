package cn.creditall.Data;

/*
 *@author zhuhongyan
 *@version ：2017年8月17日 下午3:52:41
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.creditall.Common.TestCase;
//操作数据写入
public class DataDriver extends TestCase {
	public List<String> loginData(String colName, String sheetName) throws Exception {
		List<String> paramList = new ArrayList<>();

		Map<String, String>[][] data = (Map<String, String>[][]) Numbers(sheetName);
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				String params = data[i][j].get(colName);
				System.out.println(params);
				paramList.add(params);
			}
		}
		return paramList;
	}

	// @DataProvider(name = "Login")
	public Object[][] Numbers(String sheetName) throws Exception {
		// 指定sheet的名称
	ReadExcel  excel=new ReadExcel(sheetName);
		return excel.getExcelData();

	}

	public void writeData(String sheetName, int col, int row, String cont) throws Exception {
		WriteExcel excel = new WriteExcel("D:\\test.xls");
		/* excel.write("login", 2, 5, "case正常"); */
		excel.write(sheetName, col, row, cont);
	}

}
