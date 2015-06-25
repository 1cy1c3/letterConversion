package com.letter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.io.IOException;

/**
 * Controller for letter conversion
 *
 * @author Rune Krauss
 */
@Controller
public class LetterController {

	protected final Log logger = LogFactory.getLog(getClass());

	/**
	 * Method to generate values for the template
	 *
	 * @param HttpServletRequest
	 *            request Request parameter
	 * @param HttpServletResponse
	 *            response Response parameter
	 * 
	 * @throws ServletException
	 *             If a servlet is not found
	 * @throws IOException
	 *             If a value is not excepted
	 * 
	 * @return ModelAndView An object for rendering values
	 */
	@RequestMapping("/letter")
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String message = "test";

		logger.info("Return View");

		// Render to /jsp/letter.jsp
		return new ModelAndView("letter", "message", message);
	}
}