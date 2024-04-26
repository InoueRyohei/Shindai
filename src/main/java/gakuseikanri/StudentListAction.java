package gakuseikanri;

import java.util.List;

import bean.Student;
import bean.Teacher;
import dao.StudentDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

//ログイン中のアカウントに応じて学生一覧を取得し、student_list.jspを返す。
//ログインしていない場合、student_list_error.jspを返す。
public  class StudentListAction extends Action {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session=request.getSession();
		
//		未ログイン時の処理
		if (session.getAttribute("teacher")==null) {
			return "student_list_error.jsp";
		}
		
//		
		Teacher teacher=(Teacher)session.getAttribute("teacher");
		String keyword=teacher.getSchool_cd();
		
		StudentDAO dao=new StudentDAO();
		List<Student> list=dao.search(keyword);
		
		session.setAttribute("list", list);
		
		return "student_list.jsp";
	}
}
