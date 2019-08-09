package com.crm.qa.testdata;

import java.util.Locale;
import java.util.Random;

import org.joda.time.DateTime;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Address;
import io.codearte.jfairy.producer.person.Person;
import io.codearte.jfairy.producer.person.PersonProperties;

public class RegisterDataCanada {

	static // first create Fairy object. By default - Locale is English
	Fairy fairy = Fairy.create();

	static Fairy canadaFairy = Fairy.create(Locale.CANADA);
	// String telNumber = fairy.person().getTelephoneNumber().valueOf(6);

	// Create person object
	static Person person = canadaFairy.person();

//		// Generate random data
//		String firstName = person.getFirstName();
//		String lastName = person.getLastName();
//		String emailAddress = person.getEmail();
//
//		Address address = person.getAddress();
//		String addressLine1 = address.getAddressLine1();
//		String addressLine2 = address.getAddressLine2();
//		Person adultMale = canadaFairy.person(PersonProperties.male(), PersonProperties.minAge(21), PersonProperties.maxAge(60));
//
//		String referralLocation = address.getCity();
//		String postCode = address.getPostalCode();
//		DateTime dateOfBirth = adultMale.getDateOfBirth();

	public static String phoneNum() {
		double n = Math.random();
		long n3 = Math.round(Math.random() * 10000000);
		System.out.println(n3);

		return String.valueOf(n3);
	}
	
	public static String mobilePhoneNum() {
		double n = Math.random();
		long n3 = Math.round(Math.random() * 10000000);
		System.out.println(n3);

		return String.valueOf(n3);
	}

	public static String firstName() {
		String firstName = person.getFirstName();
		return firstName;
	}

	public static String lastName() {
		String lastName = person.getLastName();
		return lastName;
	}

	public static String getEmail() {
		String getEmail = person.getEmail();
		return getEmail;
	}

	public static Address getAddress() {
		Address address = person.getAddress();
		return address;
	}

	public static String getAddressLine1() {
		Address address = person.getAddress();
		String addressLine1 = address.getAddressLine1();
		return addressLine1;
	}

	public static String getAddressLine2() {
		Address address = person.getAddress();
		String getAddressLine2 = address.getAddressLine2();
		return getAddressLine2;
	}

	public static String city() {
		Address address = person.getAddress();
		String city = address.getCity();
		return city;
	}

	public static String postCode() {
		Address address = person.getAddress();
		String postCode = address.getPostalCode();
		return postCode;
	}

	public static DateTime dateOfBirth() {
		Person adultMale = canadaFairy.person(PersonProperties.male(), PersonProperties.minAge(21),
				PersonProperties.maxAge(60));
		DateTime dateOfBirth = adultMale.getDateOfBirth();
		return dateOfBirth;
	}

}
