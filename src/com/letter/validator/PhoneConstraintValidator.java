package com.letter.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Validator for phone constraints
 *
 * @author Rune Krauss
 */
public class PhoneConstraintValidator implements
		ConstraintValidator<Phone, String> {
	@Override
	public void initialize(Phone String) {
	}

	/**
	 * Method to check validation of the phone field
	 * @param String
	 *            phoneField Phone field
	 * @param ConstraintValidatorContext
	 *            cxt Get validator context
	 * 
	 * @return boolean Checked phone field
	 */
	@Override
	public boolean isValid(String phoneField, ConstraintValidatorContext cxt) {
		if (phoneField == null) {
			return false;
		}
		return phoneField.matches("[0-9()-]*");
	}
}