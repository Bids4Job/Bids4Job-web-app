package controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.ProfessionalUser;
import domain.SimpleUser;

/**
 * Servlet implementation class ProfileImageController
 */
@WebServlet("/user_image/*")
public class ProfileImageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProfileImageController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get the Professional User object from session
		SimpleUser simpleUser = (SimpleUser) request.getSession().getAttribute("simple-user");
		ProfessionalUser professionalUser = (ProfessionalUser) request.getSession().getAttribute("pro");
		// Use a boolean to know if a ProfessionalUser or a SimpleUser is logged
		// in
		boolean isSimple = (simpleUser != null);
		boolean isPro = (professionalUser != null);

		String filename = "user_avatar.png";
		File file = new File(request.getServletContext().getRealPath("") + "/images", filename);
		if (isSimple | isPro) {
			// Get the appropriate photo name
			filename = isSimple ? simpleUser.getPhotoName() : professionalUser.getPhotoName();
			if (filename != null) {
				file = new File(request.getServletContext().getRealPath("") + "/profile-images", filename);
			}
		}
		response.setHeader("Content-Type", getServletContext().getMimeType(filename));
		response.setHeader("Content-Length", String.valueOf(file.length()));
		response.setHeader("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");
		Files.copy(file.toPath(), response.getOutputStream());
	}
}
