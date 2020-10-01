package com.gmail.quickstart;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.base.BaseTest;

public class GmailGetMailTest extends BaseTest { 

	@Test(priority = 1) 
	public void getMailFromGmail() throws Exception {
		String mailSubjectTitleIs = "Streamxxx";
		boolean exist = false;

		try {
			exist = GmailQuickstart.isMailExist(mailSubjectTitleIs);
		} catch (Exception e) {
			System.out.println("Error caught is " + e.getMessage());
		}

		if (exist == true) {
			System.out.println("Email title found =" + exist);
			HashMap<String, String> hm = GmailQuickstart.getGmailData("subject:" + mailSubjectTitleIs);
			System.out.println("Subject =" + hm.get("subject"));
			System.out.println("=================");
			System.out.println("Body =" + hm.get("body"));
			System.out.println("=================");
			System.out.println("Link =" + hm.get("link"));

			System.out.println("=================");
			System.out.println("Total count of emails is :" + GmailQuickstart.getTotalCountOfMails());

			System.out.println("=================");
			
			//GmailQuickstart.clickOnLink();
		} else {
			System.out.println("Email title is not found");
		}
	}

//	@Test(priority = 2)
//	public void clickOnLink() {
//		String openLink = GmailQuickstart.clickOnLink();
//		
//		System.out.println("Link to open is ="+openLink);
//		driver.get(openLink);
//		
//
//	}

	@Test(priority = 3)
	public void clearOutInbox() throws Exception {
		System.out.println("Clear out inbox first");
		GmailQuickstart.deleteMails("Primary");
		//driver.close();
		//driver.quit();
	}

}
