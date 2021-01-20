package demo.sms;

//Install the Java helper library from twilio.com/docs/java/install

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class Twillio_Send_SMS {
	// Find your Account Sid and Token at twilio.com/console
	// and set the environment variables. See http://twil.io/secure
	//public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
	//public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");
	
	public static final String ACCOUNT_SID = "ACa2bd20b14b695be1e6781e6d2e109a8f";
	public static final String AUTH_TOKEN = "e0ad3e05878fb1a26074f93e38c78146";

	public static void main(String[] args) {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		Message message = Message.creator(
				new com.twilio.type.PhoneNumber("+14159653208"), //+14159653208
				new com.twilio.type.PhoneNumber("+353 851502157"),
				"This is the ship that made the Kessel Run in fourteen parsecs?").create();

		System.out.println(message.getSid());
	}
}
