package com.gmail.quickstart;

import java.util.HashMap;

import org.testng.annotations.Test;

public class GmailGetMail {
	
	@Test
	public void getMailFromGmail() {
		HashMap<String, String> hm  = GmailQuickstart.getGmailData("Streamxxx");
		
		String subject = hm.get("subject");
		String body = hm.get("body");
		String link = hm.get("link");
		
		System.out.println("Subject is ="+subject);
		System.out.println("Body is ="+body);
		System.out.println("Link is ="+link);
		
		
		
	}

}
