package controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.EmailUtils;

/**
 * Servlet implementation class SendEmailController
 */
@WebServlet("/send_email")
public class SendEmailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Request Parameters
	private static final String NAME = "name";
	private static final String EMAIL = "email";
	private static final String MESSAGE = "message";

	RequestDispatcher errorDispatcher;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SendEmailController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		// Define RequestDispatcher object to forward any errors
		errorDispatcher = getServletContext().getRequestDispatcher("/errorprinter.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("post");
		
		if (request.getParameter("submit") != null) {
			System.out.println("submit");
			EmailUtils.setMailServerProperties();

			String emailSubject = "Email from Bid4Job contact form";
			String emailBody = "";

			String name = request.getParameter(NAME);
			if (name != null) {
				System.out.println("name");
				emailBody = "Sender Name: " + name + "<br>";
			}

			String email = request.getParameter(EMAIL);
			if (email != null) {
				System.out.println("email");
				emailBody = emailBody + "Sender Email: " + email + "<br>";
			}

			String message = request.getParameter(MESSAGE);
			if (message != null) {
				System.out.println("message");
				emailBody = emailBody + "Message: " + message + "<br>";
			}

			String status = null;

			try {
				System.out.println("try");
				EmailUtils.createEmailMessage(emailSubject, emailBody);
				EmailUtils.sendEmail();
				status = "success";
				response.sendRedirect("index#contact");
			} catch (MessagingException me) {
				System.out.println("catch");
				me.printStackTrace();
				status = "error";
				request.setAttribute("errorMessage", "Error Sending Email: " + me.getMessage());
				errorDispatcher.forward(request, response);
			}
		}
	}

}
