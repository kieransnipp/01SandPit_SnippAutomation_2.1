package com.gmail.quickstart;


import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.GmailScopes;

import io.restassured.path.json.JsonPath;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.openqa.selenium.WebDriver;
import com.google.api.services.gmail.model.*;
import com.google.api.services.gmail.model.Thread;

public class GmailQuickstart {
	private static final String APPLICATION_NAME = "Gmail API Java Util";
	private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
	private static final String USER_ID = "me";

	/**
	 * Global instance of the scopes required by this quickstart. If modifying these
	 * scopes, delete your previously saved tokens/ folder.
	 */
	// private static final List<String> SCOPES =
	// Collections.singletonList(GmailScopes.GMAIL_LABELS);
	private static final List<String> SCOPES = Arrays.asList(GmailScopes.MAIL_GOOGLE_COM);

	// Path to credentials file
	//private static final String CREDENTIALS_FILE_PATH = "C:/01Work/03Automation/01Automation2020/SandPit_Demo/src/main/resources/credentials.json";
	
	private static final String CREDENTIALS_FILE_PATH = "/credentials.json";
	InputStream in = Gmail.class.getResourceAsStream(CREDENTIALS_FILE_PATH);

	static final String TOKENS_DIRECTORY_PATH = System.getProperty("user.dir") + File.separator + "src" + File.separator
			+ "main" + File.separator + "resources" + File.separator + "credentials";

	static HashMap<String, String> hm = new HashMap<String, String>();
	public static WebDriver driver;

	/**
	 * Creates an authorized Credential object.
	 * 
	 * @param HTTP_TRANSPORT The network HTTP Transport.
	 * @return An authorized Credential object.
	 * @throws IOExceptsion If the credentials.json file cannot be found.
	 */

	public static void main(String[] args) throws Exception {

		// Search for the email by the Subject title
		String mailSubjectTitleIs = "Streamxxx";
		boolean exist = false;

		// 1
		exist = isMailExist(mailSubjectTitleIs);

		if (exist == true) {
			System.out.println("Email title found =" + exist);
			HashMap<String, String> hm = getGmailData("subject:" + mailSubjectTitleIs);
			System.out.println("Subject =" + hm.get("subject"));
			System.out.println("=================");
			System.out.println("Body =" + hm.get("body"));
			System.out.println("=================");
			System.out.println("Link =" + hm.get("link"));

			System.out.println("=================");
			System.out.println("Total count of emails is :" + getTotalCountOfMails());

			System.out.println("=================");

		} else {
			System.out.println("Email title is not found");
		}

		//System.out.println("Open the link");
		// 2

		// 3
		deleteMails("Primary");

	}

	private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws Exception {
		// Load client secrets.
		InputStream in = GmailQuickstart.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
		if (in == null) {
			throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
		}

		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

		// Build flow and trigger user authorization request.
		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY,
				clientSecrets, SCOPES)
						.setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
						.setAccessType("offline").build();

		LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();

		return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
	}

	public static Gmail getService() throws Exception {
		// Build a new authorized API client service.
		final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
		Gmail service = new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
				.setApplicationName(APPLICATION_NAME).build();
		return service;
	}

	public static List<Message> listMessagesMatchingQuery(Gmail service, String userId, String query)
			throws IOException {
		ListMessagesResponse response = service.users().messages().list(userId).setQ(query).execute();
		List<Message> messages = new ArrayList<Message>();
		while (response.getMessages() != null) {
			messages.addAll(response.getMessages());
			if (response.getNextPageToken() != null) {
				String pageToken = response.getNextPageToken();
				response = service.users().messages().list(userId).setQ(query).setPageToken(pageToken).execute();
			} else {
				break;
			}
		}
		return messages;
	}

	public static Message getMessage(Gmail service, String userId, List<Message> messages, int index)
			throws IOException {
		Message message = service.users().messages().get(userId, messages.get(index).getId()).execute();
		return message;
	}

	public static void deleteMails(String category) throws Exception {
		Gmail service = getService();
		List<Message> messages = listMessagesMatchingQuery(service, USER_ID, category);
		// Retrieve a page of Threads; max of 100 by default.
		ListThreadsResponse threadsResponse = service.users().threads().list(USER_ID).setQ("category:" + category)
				.execute();
		List<com.google.api.services.gmail.model.Thread> threads = threadsResponse.getThreads();

		// Delete each Thread.
		for (Thread thread : threads) {
			String ThreadID = thread.getId();
			service.users().threads().delete(USER_ID, ThreadID).execute();
			System.out.println("************ Clean out inbox now ****************");

			System.out.println("Email are now deleted by category =" + category);
		}

	}

	public static HashMap<String, String> getGmailData(String query) {
		try {
			Gmail service = getService();
			List<Message> messages = listMessagesMatchingQuery(service, USER_ID, query);
			Message message = getMessage(service, USER_ID, messages, 0);
			JsonPath jp = new JsonPath(message.toString());
			String subject = jp.getString("payload.headers.find { it.name == 'Subject' }.value");
			String body = new String(Base64.getDecoder().decode(jp.getString("payload.parts[0].body.data")));
			String link = null;
			String arr[] = body.split("\n");
			for (String s : arr) {
				s = s.trim();
				if (s.startsWith("http") || s.startsWith("https") || s.startsWith("www") || s.startsWith("<http")
						|| s.startsWith("http://www")) {
					link = s.trim();
				}
			}
			// HashMap<String, String> hm = new HashMap<String, String>();
			hm.put("subject", subject);
			hm.put("body", body);
			hm.put("link", link);
			return hm;

		} catch (Exception e) {
			System.out.println("email not found....");
			throw new RuntimeException(e);
		}
	}

	public static void clickOnLink() throws Exception {
		String linkToOpen = hm.get("link");
		System.out.println("link to open is =" + linkToOpen);

		driver.get(linkToOpen);
		// return linkToOpen;
	}

	public static int getTotalCountOfMails() {
		int size;
		try {
			final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
			Gmail service = new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
					.setApplicationName(APPLICATION_NAME).build();
			List<com.google.api.services.gmail.model.Thread> threads = service.users().threads().list("me").execute()
					.getThreads();
			size = threads.size();
		} catch (Exception e) {
			System.out.println("Exception log " + e);
			size = -1;
		}
		return size;
	}

	public static boolean isMailExist(String messageTitle) {
		try {
			final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
			Gmail service = new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
					.setApplicationName(APPLICATION_NAME).build();
			ListMessagesResponse response = service.users().messages().list("me").setQ("subject:" + messageTitle)
					.execute();
			List<Message> messages = getMessages(response);
			return messages.size() != 0;
		} catch (Exception e) {
			System.out.println("Exception log" + e);
			return false;
		}
	}

	private static List<Message> getMessages(ListMessagesResponse response) {
		List<Message> messages = new ArrayList<Message>();
		try {
			final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
			Gmail service = new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
					.setApplicationName(APPLICATION_NAME).build();
			while (response.getMessages() != null) {
				messages.addAll(response.getMessages());
				if (response.getNextPageToken() != null) {
					String pageToken = response.getNextPageToken();
					response = service.users().messages().list(USER_ID).setPageToken(pageToken).execute();
				} else {
					break;
				}
			}
			return messages;
		} catch (Exception e) {
			System.out.println("Exception log " + e);
			return messages;
		}
	}
//	    	public static void main(String... args) throws Exception {
//			// Build a new authorized API client service.
//			final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
//			Gmail service = new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
//					.setApplicationName(APPLICATION_NAME).build();
//	
//			// Print the labels in the user's account.
//			String user = "me";
//			ListLabelsResponse listResponse = service.users().labels().list(user).execute();
//			List<Label> labels = listResponse.getLabels();
//			if (labels.isEmpty()) {
//				System.out.println("No labels found."); 
//			} else {
//				System.out.println("Labels:");
//				for (Label label : labels) {
//					System.out.printf("- %s\n", label.getName());
//				}
//			}
//		}

	public static void sendMessage(Gmail service, String userId, MimeMessage email)
			throws MessagingException, IOException {
		Message message = createMessageWithEmail(email);
		message = service.users().messages().send(userId, message).execute();

		System.out.println("Message id: " + message.getId());
		System.out.println(message.toPrettyString());
	}

	public static Message createMessageWithEmail(MimeMessage email) throws MessagingException, IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		email.writeTo(baos);
		Encoder encodedEmail = Base64.getMimeEncoder();

		Message message = new Message();
		message.setId(USER_ID);
		return message;
	}

	// Original
//	public static Message createMessageWithEmail(MimeMessage email) throws MessagingException, IOException {
//		ByteArrayOutputStream baos = new ByteArrayOutputStream();
//		email.writeTo(baos);
//		String encodedEmail = Base64.encodeBase64URLSafeString(baos.toByteArray());
//		Message message = new Message();
//		message.setRaw(encodedEmail);
//		return message;
//	}

	public static MimeMessage createEmail(String to, String from, String subject, String bodyText)
			throws MessagingException, IOException {
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);

		MimeMessage email = new MimeMessage(session);

		email.setFrom(new InternetAddress(from)); // me
		email.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(to)); //
		email.setSubject(subject);

		email.setText(bodyText);

		return email;
	}

	public static void sendEmail(NetHttpTransport HTTP_TRANSPORT) throws Exception {

		// Gmail service = Gmail.getGmailService();
		Gmail service = new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
				.setApplicationName(APPLICATION_NAME).build();
		MimeMessage Mimemessage = createEmail("afsarali273@gmail.com", "me", "This my demo test subject",
				"This is my body text");

		Message message = createMessageWithEmail(Mimemessage);

		message = service.users().messages().send("me", message).execute();

		System.out.println("Message id: " + message.getId());
		System.out.println(message.toPrettyString());
	}

}
