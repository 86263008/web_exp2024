package Hello;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/getSessionInfo")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SessionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setHeader("content-type","text/html;charset=utf-8");
		
		String info = "<h3>Session Infomation</h3>\n";
		info += String.format("<p>Creation Time:%s</p>\n", session.getCreationTime());
		info += String.format("<p>Session Id:%s</p>\n", session.getId());
		info += String.format("<p>Last Accessed Time:%s</p>\n", session.getLastAccessedTime());
		info += String.format("<p>Max Inactive Interval:%s</p>\n", session.getMaxInactiveInterval());
		
		response.getWriter().append(info);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
