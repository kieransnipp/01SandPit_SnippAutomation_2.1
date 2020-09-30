package demo;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.testng.annotations.Test;
 
import org.testng.Assert;

//public class Reports_Read_PDF extends BaseTest {
public class Reports_Read_PDF {

	//String username = Helper.GetOverRideJenkinsUserName("username2");
	//String password = Helper.GetOverRideJenkinsPassW("password2");

	@Test(priority = 1)
	public void readPDFTest() throws IOException {
		URL url = new URL(
				"http://www.betterteam.com/downloads/job-application-form-template-download-standard-20170814.pdf");
		//URL url = new URL("file:///C:/01SelenideWorkSpace/Snipp_Regression/src/testfiles/PDF.pdf");
		
		
		//String curentURL = driver.getCurrentUrl();
		//System.out.println("Current url is "+curentURL);
		
		InputStream is = url.openStream();
		BufferedInputStream fileParse = new BufferedInputStream(is);

		PDDocument document = null;
		document = PDDocument.load(fileParse);
		String pdfContent = new PDFTextStripper().getText(document);
		document.close();
		fileParse.close();
		
		Assert.assertTrue(pdfContent.contains("Signature"));
		Assert.assertTrue(pdfContent.contains("Opportunity Employer"));
		Assert.assertTrue(pdfContent.contains("Application For Employment"));
		Assert.assertTrue(pdfContent.contains("committed to excellence"));
		
		
		System.out.println(" *********************  ");
		System.out.println(" *********************  ");
		System.out.println("PDF content is = "+pdfContent);
	}
}
