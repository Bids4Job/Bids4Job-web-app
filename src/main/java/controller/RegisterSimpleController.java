package controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.lang3.StringUtils;

import dao.PropertiesFileUtils;
import dao.SimpleUserDAO;
import domain.SimpleUser;
import service.SimpleUserService;

/**
 * Servlet implementation class RegisterSimpleController
 */
@WebServlet("/register_simple")
@MultipartConfig(maxFileSize = 16177215)
public class RegisterSimpleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Parameter names
	private static final String FIRST_NAME = "firstname";
	private static final String LAST_NAME = "surname";
	private static final String EMAIL = "email";
	private static final String USERNAME = "uname";
	private static final String PASSWORD = "upass";
	private static final String PASSWORD_VERIFICATION = "upass-verification";
	private static final String LOCATION = "location";
	private static final String PROFILE_IMAGE = "simple-image";
	// Storage Location info
	private static final String CONFIG_FILE = "config.properties";
	private static final String UPLOAD_LOCATION = "upload.location";

	// A service for SimpleUser database operations
	private SimpleUserService simpleUserService;

	// Dispatchers for error and registered pages
	RequestDispatcher errorDispatcher;
	RequestDispatcher registeredDispatcher;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterSimpleController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		// Define RequestDispatcher object to forward any errors
		errorDispatcher = getServletContext().getRequestDispatcher("/errorprinter.jsp");

		// Define RequestDispatcher object to forward if data are correct and
		// successfully stored in database
		registeredDispatcher = getServletContext().getRequestDispatcher("/registered.jsp");

		// Instantiate a SimpleUser service object
		simpleUserService = new SimpleUserService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		// Read parameters from request
		String username = request.getParameter(USERNAME);
		String password = request.getParameter(PASSWORD);
		String passwordVerification = request.getParameter(PASSWORD_VERIFICATION);
		String email = request.getParameter(EMAIL);
		String firstName = request.getParameter(FIRST_NAME);
		String lastName = request.getParameter(LAST_NAME);
		String location = request.getParameter(LOCATION);

		// Obtain the upload file part in this multipart request
		Part imagePart = request.getPart(PROFILE_IMAGE);

		String errorMessage = "";

		errorMessage += checkAlphaDashes(firstName, lastName);
		errorMessage += checkAlphanumericDashes(username, password);
		errorMessage += verifyPassword(password, passwordVerification);
		// Check if the selected file (if any) is an image
		if (imagePart.getSize() != 0) {
			errorMessage += checkUploadContentType(imagePart.getContentType(), "image");
		}

		if (errorMessage.length() > 0) {
			request.setAttribute("errorMessage", errorMessage);
			errorDispatcher.forward(request, response);
			return;
		}

		try {
			if (simpleUserService.exist(SimpleUserDAO.EMAIL, email)) {
				request.setAttribute("errorMessage", "Email already exists.");
				errorDispatcher.forward(request, response);
				return;
			}
			if (simpleUserService.exist(SimpleUserDAO.USERNAME, username)) {
				request.setAttribute("errorMessage", "Username already exists.");
				errorDispatcher.forward(request, response);
				return;
			}

			// Create the SimpleUser to be stored
			SimpleUser simpleUser = new SimpleUser().setFirstName(firstName).setLastName(lastName).setLocation(location)
					.setUsername(username).setPassword(password).setEmail(email);

			if (imagePart.getSize() != 0) {
				// Get the absolute path of the web application
				String appPath = request.getServletContext().getRealPath("");
				// The upload location
				String uploadLocation = PropertiesFileUtils.getPropertyValue(CONFIG_FILE, UPLOAD_LOCATION);
				// Construct path of the directory to save uploaded files
				String savePath = appPath + File.separator + uploadLocation;
				// Define the path to the final storage location
				File uploadFile = new File(savePath);
				if (!uploadFile.exists()) {
					uploadFile.mkdir();
				}
				String contentType = "." + imagePart.getContentType().split("/")[1];
				File file = new File(uploadFile, username + contentType);

				try (InputStream input = imagePart.getInputStream()) {
					Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
					// Set the photo url
					simpleUser.setPhotoName(username + contentType);
				}
			}

			simpleUser = simpleUserService.create(simpleUser);

			// Get the HttpSession that is associated with this request
			HttpSession session = request.getSession();
			// Set the user to session
			session.setAttribute("simple-user", simpleUser);
			
			registeredDispatcher.forward(request, response);

		} catch (IllegalAccessException | InstantiationException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", e.getMessage());
			errorDispatcher.forward(request, response);
		}

	}

	private String verifyPassword(String password, String passwordVerification) {
		StringBuilder errorBuilder = new StringBuilder();
		if (!password.equals(passwordVerification))
			errorBuilder.append("Password should match Password(confirm)<br>");
		return errorBuilder.toString();
	}

	private String checkAlphaDashes(String firstName, String lastName) {
		StringBuilder errorBuilder = new StringBuilder();
		if (!StringUtils.isAlphaSpace(firstName.replace('-', ' '))) {
			errorBuilder.append(firstName).append(" should contain only letters and hyphens").append("<br>");
		}
		if (!StringUtils.isAlphaSpace(lastName.replace('-', ' '))) {
			errorBuilder.append(lastName).append(" should contain only letters and hyphens").append("<br>");
		}
		return errorBuilder.toString();
	}

	private String checkAlphanumericDashes(String username, String password) {
		StringBuilder errorBuilder = new StringBuilder();
		if (!StringUtils.isAlphanumericSpace(username.replace('-', ' '))) {
			errorBuilder.append(username).append(" should contain only letters, numbers and hyphens").append("<br>");
		}
		if (!StringUtils.isAlphanumericSpace(password.replace('-', ' '))) {
			errorBuilder.append(password).append(" should contain only letters, numbers and hyphens").append("<br>");
		}
		return errorBuilder.toString();
	}

	/**
	 * Checks if the uploaded file is of ContentType image.
	 * 
	 * @param contentType
	 *            the content type to be checked
	 * @param desiredType
	 *            the desired content type
	 * @return an error message if an error occurred
	 */
	private String checkUploadContentType(String contentType, String desiredType) {
		StringBuilder errorBuilder = new StringBuilder();
		String type = contentType.split("/")[0];
		if (!type.equals(desiredType))
			errorBuilder.append("The file to be uploaded should be an image").append("<br>");
		return errorBuilder.toString();
	}

}
