package kamokukanri;

import java.util.List;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class SubjectListAction extends Action {
	
public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session=request.getSession();
		
//		未ログイン時の処理
		if (session.getAttribute("teacher")==null) {
			return "subject_list_error.jsp";
		}
		
//		
		Teacher teacher=(Teacher)session.getAttribute("teacher");
		String keyword=teacher.getSchool_cd();
		
		SubjectDAO dao=new SubjectDAO();
		List<Subject> list2=dao.search(keyword);
//		System.out.println(list);
		
		session.setAttribute("list2", list2);
		
		return "subject_list.jsp";
	}
}
