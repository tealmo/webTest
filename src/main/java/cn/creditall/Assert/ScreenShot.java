package cn.creditall.Assert;
/*
 *@author zhuhongyan
 *@version ：2017年8月17日 下午3:52:41
 */
import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/*
 *@author zhuhongyan
 *@version ：2017年8月17日 上午10:24:50
 */
/*定义失败截图类*/
public class ScreenShot {
	public WebDriver driver;

	public ScreenShot(WebDriver driver) {
		this.driver = driver;
	}

	private void takeScreenshot(String screenPath) {
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(screenPath));
		} catch (IOException e) {
			System.out.println("Screen shot error: " + screenPath);
		}
	}

	public void takeScreenshot() {
		String screenName = String.valueOf(new Date().getTime()) + ".jpg";
		// 指定失败图片的保存文件路径：在输出文件下
		File dir = new File("failure-output");
		if (!dir.exists())
			dir.mkdirs();
		String screenPath = dir.getAbsolutePath() + "/" + screenName;
		this.takeScreenshot(screenPath);
	}
}