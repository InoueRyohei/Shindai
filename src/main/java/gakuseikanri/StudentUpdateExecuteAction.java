package gakuseikanri;

import bean.Student;
import dao.StudentDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class StudentUpdateExecuteAction extends Action {
	public String execute(
			HttpServletRequest request, HttpServletResponse response
		) throws Exception {
			
		String update_no = request.getParameter("update_no");
        String no = request.getParameter("no");
        String name = request.getParameter("name");
        int ent_year = Integer.parseInt(request.getParameter("ent_year"));
        int class_num = Integer.parseInt(request.getParameter("class_num"));
        boolean is_attend = request.getParameter("is_attend") != null;
        
        if (name == null || name.isEmpty()) {
            request.setAttribute("errorMessage", "氏名を入力してください");
            Student student = new Student();
            student.setNo(no);
            student.setName(name);
            student.setEnt_year(ent_year);
            student.setClass_num(class_num);
            student.setIs_attend(is_attend);
            request.setAttribute("student", student);
            return "student_update.jsp";
        }

        Student student = new Student();
        student.setNo(no);
        student.setName(name);
        student.setEnt_year(ent_year);
        student.setClass_num(class_num);
        student.setIs_attend(is_attend);
		
        StudentDAO dao = new StudentDAO();
        dao.update(student, update_no);
        return "student_update_done.jsp"; 
	}
}
