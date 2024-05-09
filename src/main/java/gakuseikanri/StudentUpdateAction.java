package gakuseikanri;

import bean.Student;
import dao.StudentDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class StudentUpdateAction extends Action {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session=request.getSession();
		
		String update_no = request.getParameter("update_no");
        StudentDAO dao = new StudentDAO();
        Student student = dao.searchByNo(update_no); // 学生番号で学生情報を取得
        request.setAttribute("student", student);
        return "student_update.jsp"; // 学生変更画面を表示
	}
}
