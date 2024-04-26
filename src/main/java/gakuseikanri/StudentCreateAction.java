package gakuseikanri;

import java.util.List;

import bean.Class_num;
import bean.Teacher;
import dao.Class_numDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

//セッションのユーザーデータから
//セレクトボックス用のクラスデータを取得
public class StudentCreateAction extends Action {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session=request.getSession();
		
		Teacher teacher=(Teacher)session.getAttribute("teacher");
		String keyword=teacher.getSchool_cd();
		
		Class_numDAO dao=new Class_numDAO();
		List<Class_num> class_list=dao.search(keyword);
		
		session.setAttribute("class_list", class_list);
		
		return "student_create.jsp";
	}
}
