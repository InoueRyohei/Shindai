package gakuseikanri;

import java.util.List;

import bean.Class_num;
import bean.Student;
import bean.Teacher;
import dao.Class_numDAO;
import dao.StudentDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class StudentUpdateAction extends Action {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session=request.getSession();
		
		Teacher teacher=(Teacher)session.getAttribute("teacher");
		String keyword=teacher.getSchool_cd();
		
		Class_numDAO Cdao=new Class_numDAO();
		List<Class_num> class_list=Cdao.search(keyword);
		
		session.setAttribute("class_list", class_list);
		
		String update_no = request.getParameter("update_no");
        StudentDAO Sdao = new StudentDAO();
        Student student = Sdao.searchByNo(update_no); // 学生番号で学生情報を取得
        request.setAttribute("student", student);
        return "student_update.jsp"; // 学生変更画面を表示
	}
}
