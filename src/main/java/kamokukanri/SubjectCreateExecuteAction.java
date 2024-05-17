package kamokukanri;

import java.util.List;

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
		
		if (subject_name == null || subject_name.isEmpty() || subject_cd == null || subject_cd.isEmpty()) {
            request.setAttribute("errorMessage", "科目コードまたは科目名を入力してください");
            return "subject_create.jsp";
        }
		
//		学生番号が重複している場合の処理
		SubjectDAO dao=new SubjectDAO();
		List<Subject> list=dao.search(""); 
		boolean noDuplication = false;
		for(int i=0; i<list.size(); i++) {
//			System.out.println(list.get(i).getNo());

			if (list.get(i).getSubject_cd().equals(subject_cd)) {
//				System.out.println(no);
				noDuplication=true;
				break;
			}
		}
		
		if (noDuplication) {
			request.setAttribute("errorMessage", "科目コードが重複しています");
			return "subject_create.jsp";
		}
		
//		SubjectDAO dao=new SubjectDAO();
		Subject sub=new Subject();
		sub.setSchool_cd(school_cd);
		sub.setSubject_cd(subject_cd);
		sub.setSubject_name(subject_name);
		dao.insert(sub);
		
		return "subject_create_done.jsp";
	}
}
