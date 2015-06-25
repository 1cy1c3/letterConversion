package com.letter.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.letter.form.Letter;
import com.letter.xml.XML;

/**
 * Controller for form actions
 *
 * @author Rune Krauss
 */
@Controller
public class FormController {
	/**
	 * Method to load form page
	 *
	 * @param Model
	 *            m Model of form actions
	 * 
	 * @return String An object for loading inputs
	 */
	@RequestMapping(value = "/formPage", method = RequestMethod.GET)
	public String loadFormPage(Model m) {
		m.addAttribute("letter", new Letter());
		return "formPage";
	}
	
	/**
	 * Method to handle form actions
	 *
	 * @param Letter
	 *            letter Form fields
	 * @param BindingResult
	 *            result Result of form validation
	 * @param Model
	 *            m Model of form actions
	 * 
	 * @return String An object for validating inputs
	 */
	@Autowired
	ServletContext servletContext;
	@RequestMapping(value = "/formPage", method = RequestMethod.POST)
	public String submitForm(@Valid Letter letter, BindingResult result, Model m) {
		if (result.hasErrors()) {
			return "formPage";
		}
		
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		XML xml = new XML(timestamp);
		
		xml.createXML(letter);
		xml.createPDF();
		
		File rootDir = new File( servletContext.getRealPath("/WEB-INF/jsp/") );
		System.out.print(rootDir);
		
		m.addAttribute("timestamp", timestamp);
		m.addAttribute("message",
				"Successfully saved letter: " + letter.toString());
		return "formPage";
	}
}
