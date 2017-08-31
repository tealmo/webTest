package cn.creditall;

/*
 *@author zhuhongyan
 *@version ：2017年8月17日 上午10:20:16
 */
/*蒋数据写入单元格,直接在已有的表格中写入数据*/
import java.io.File;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/*
@author zhuhongyan
*/
public class WriteExcel {
	public static void main(String[] args) {
		// 指定excel表格的名称
		WriteExcel excel = new WriteExcel("D:\\test.xls");
	}

	private String path;

	public WriteExcel(String path) {
		this.path = path;
	}

	public void write(String sheetName, int col, int row, String cont) throws Exception {
		File file = new File(path);
		Workbook workbook = Workbook.getWorkbook(file);
		WritableWorkbook book = Workbook.createWorkbook(new File(path), workbook);
		// 指定sheet名称
		WritableSheet sheet = book.getSheet(sheetName);
		// 指定单元格
		Label label = new Label(col, row, cont);
		// 写入指定单元格
		sheet.addCell(label);
		book.write();
		book.close();
	}

}
