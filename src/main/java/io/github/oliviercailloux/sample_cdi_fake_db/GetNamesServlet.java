package io.github.oliviercailloux.sample_cdi_fake_db;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

@WebServlet("/customers/names")
public class GetNamesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private FakeDatabase db;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
		resp.setContentType(MediaType.TEXT_PLAIN);
		resp.setLocale(Locale.ENGLISH);

		@SuppressWarnings("resource")
		final ServletOutputStream out = resp.getOutputStream();

		for (String name : db.getCustomerNames()) {
			out.println(name);
		}
	}
}
