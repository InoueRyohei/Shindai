package loginkanri;


import bean.Teacher;
import dao.TeacherDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class LoginAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		HttpSession session=request.getSession();

		String id=request.getParameter("id");
		String password=request.getParameter("password");
		
		// IDまたはPWが未入力の場合にログインフォームに戻る
        if (id == null || id.isEmpty() || password == null || password.isEmpty()) {
            request.setAttribute("errorMessage", "IDまたはパスワードを入力してください");
            return "login-in.jsp";
        }

		TeacherDAO dao=new TeacherDAO();
		Teacher teacher=dao.search(id, password);
		
		if (teacher!=null) {
			session.setAttribute("teacher", teacher);
			return "../index/index.jsp";
		}
		
		request.setAttribute("errorMessage", "IDまたはパスワードが確認できませんでした");
        return "login-in.jsp";
	}
}
