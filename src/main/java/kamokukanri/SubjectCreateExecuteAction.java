package kamokukanri;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class SubjectCreateExecuteAction extends Action{
	public String execute(
			HttpServletRequest request, HttpServletResponse response
		) throws Exception {
		
		HttpSession session=request.getSession();
		Teacher teacher=(Teacher)session.getAttribute("teacher");
		String school_cd=teacher.getSchool_cd();
		String subject_cd=request.getParameter("subject_cd");
		String subject_name=request.getParameter("subject_name");
		
		SubjectDAO dao=new SubjectDAO();
		Subject sub=new Subject();
		sub.setSchool_cd(school_cd);
		sub.setSubject_cd(subject_cd);
		sub.setSubject_name(subject_name);
		dao.insert(sub);
		
		return "subject_create_done.jsp";
	}
}
