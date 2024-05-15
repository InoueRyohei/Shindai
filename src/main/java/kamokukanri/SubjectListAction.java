package kamokukanri;

import java.util.List;

import javax.security.auth.Subject;

import bean.Teacher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class SubjectListAction extends Action {
	
public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session=request.getSession();
		
//		未ログイン時の処理
		if (session.getAttribute("teacher")==null) {
			return "student_list_error.jsp";
		}
		
//		
		Teacher teacher=(Teacher)session.getAttribute("teacher");
		String keyword=teacher.getSchool_cd();
		
		SubjectDAO dao=new SubjectDAO();
		List<Subject> list=dao.search(keyword);
		
		session.setAttribute("list", list);
		
		return "subject_list.jsp";
	}
}
