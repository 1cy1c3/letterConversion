package com.letter.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.letter.validator.Phone;

/**
 * Controller for input validation
 *
 * @author Rune Krauss
 */
public class Letter {
	@Pattern(regexp="(0?[1-9]|[12][0-9]|3[01]).(0?[1-9]|1[012]).((19|20)\\d\\d)")
	@NotNull
	private String date;
	
	@NotEmpty
	@Pattern(regexp="([a-zA-Z]{3,30}\\s*)+")
	private String senderSurname;
	
	@NotEmpty
	@Pattern(regexp="[a-zA-Z]{3,30}")
	private String senderName;
	
	@NotEmpty
	@Pattern(regexp="[a-zA-Z]+[a-zA-Zßöüä\\s]*")
	@Size(min = 5, max = 30)
	private String senderStreet;
	
	@NotEmpty
	@Pattern(regexp="[0-9]+[a-zA-Z]?")
	private String senderNr;

	@NotEmpty
	@Size(min = 5, max = 5)
	@Pattern(regexp="^([0]{1}[1-9]{1}|[1-9]{1}[0-9]{1})[0-9]{3}$")
	private String senderPLZ;

	@NotEmpty
	@Pattern(regexp="[a-zA-Z]{5,30}")
	private String senderPlace;

	@NotEmpty
	@Phone
	private String senderPhone;

	@NotEmpty
	@Email
	//@Pattern(regexp="[a-zA-Z0-9_-\.]+@[a-zA-Z0-9\.]+[a-zA-Z]{2,4}")
	private String senderEmail;
	
	@NotEmpty
	@Pattern(regexp="([a-zA-Z]{3,30}\\s*)+")
	@Size(min = 2, max = 30)
	private String recipientSurname;
	
	@NotEmpty
	@Pattern(regexp="[a-zA-Z]{3,30}")
	@Size(min = 2, max = 30)
	private String recipientName;

	@NotEmpty
	@Pattern(regexp="[a-zA-Z]+[a-zA-Zßöüä\\s]*")
	@Size(min = 5, max = 30)
	private String recipientStreet;

	@NotEmpty
	@Pattern(regexp="[0-9]+[a-zA-Z]?")
	private String recipientNr;

	@NotEmpty
	@Size(min = 5, max = 5)
	@Pattern(regexp="^([0]{1}[1-9]{1}|[1-9]{1}[0-9]{1})[0-9]{3}$")
	private String recipientPLZ;

	@NotEmpty
	@Pattern(regexp="[a-zA-Z]{5,30}")
	private String recipientPlace;

	@Pattern(regexp="[a-zA-Z0-9]*")
	@Size(min = 0, max = 50)
	private String reference;

	@NotEmpty
	@Pattern(regexp="[a-zA-Z0-9\\s]*")
	@Size(min = 15, max = 40)
	private String regard;

	@NotEmpty
	@Pattern(regexp="^[a-zA-Z0-9\\s]*[,]$")
	@Size(min = 15, max = 50)
	private String salutation;

	@NotNull
	//@Min(50)
	//@Max(500)
	@Size(min = 50, max = 1000)
	private String text;

	@NotEmpty
	@Pattern(regexp="[a-zA-Z]+[a-zA-Z0-9üöäß\\s]*")
	@Size(min = 11, max = 50)
	private String greeting;

	@Pattern(regexp="[a-zA-Z0-9]*")
	@Size(min = 0, max = 50)
	private String facilities;

	public String getSenderSurname() {
		return senderSurname;
	}

	public void setSenderSurname(String senderSurname) {
		this.senderSurname = senderSurname;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSenderStreet() {
		return senderStreet;
	}

	public void setSenderStreet(String senderStreet) {
		this.senderStreet = senderStreet;
	}

	public String getSenderNr() {
		return senderNr;
	}

	public void setSenderNr(String senderNr) {
		this.senderNr = senderNr;
	}

	public String getSenderPLZ() {
		return senderPLZ;
	}

	public void setSenderPLZ(String senderPLZ) {
		this.senderPLZ = senderPLZ;
	}

	public String getSenderPlace() {
		return senderPlace;
	}

	public void setSenderPlace(String senderPlace) {
		this.senderPlace = senderPlace;
	}

	public String getSenderPhone() {
		return senderPhone;
	}

	public void setSenderPhone(String senderPhone) {
		this.senderPhone = senderPhone;
	}

	public String getSenderEmail() {
		return senderEmail;
	}

	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}

	public String getRecipientSurname() {
		return recipientSurname;
	}

	public void setRecipientSurname(String recipientSurname) {
		this.recipientSurname = recipientSurname;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getRecipientStreet() {
		return recipientStreet;
	}

	public void setRecipientStreet(String recipientStreet) {
		this.recipientStreet = recipientStreet;
	}

	public String getRecipientNr() {
		return recipientNr;
	}

	public void setRecipientNr(String recipientNr) {
		this.recipientNr = recipientNr;
	}

	public String getRecipientPLZ() {
		return recipientPLZ;
	}

	public void setRecipientPLZ(String recipientPLZ) {
		this.recipientPLZ = recipientPLZ;
	}

	public String getRecipientPlace() {
		return recipientPlace;
	}

	public void setRecipientPlace(String recipientPlace) {
		this.recipientPlace = recipientPlace;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getRegard() {
		return regard;
	}

	public void setRegard(String regard) {
		this.regard = regard;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public String getFacilities() {
		return facilities;
	}

	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}

	@Override
	public String toString() {
		return "Letter [senderSurname=" + senderSurname + ", senderName="
				+ senderName + ", senderStreet=" + senderStreet + ", senderNr="
				+ senderNr + ", senderPLZ=" + senderPLZ + ", senderPlace="
				+ senderPlace + ", senderPhone=" + senderPhone
				+ ", senderEmail=" + senderEmail + ", recipientSurname="
				+ recipientSurname + ", recipientName=" + recipientName
				+ ", recipientStreet=" + recipientStreet + ", recipientNr="
				+ recipientNr + ", recipientPLZ=" + recipientPLZ
				+ ", recipientPlace=" + recipientPlace + ", reference="
				+ reference + ", regard=" + regard + ", salutation="
				+ salutation + ", text=" + text + ", greeting=" + greeting
				+ ", facilities=" + facilities + "]";
	}

}
