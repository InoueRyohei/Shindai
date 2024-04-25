package student_management;

import java.util.List;

import bean.Student;
import dao.StudentDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class InsertAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
	
		String name=request.getParameter("name");
		Integer price=Integer.parseInt.parseInt(request.getParameter("price"));
	
		Student p=new Student();
		p.setEnt_year(ent_year);
		p.setNo(no);
		p.setName(name);
		p.setClass_num(class_num);		
		StudentDAO dao=new StudentDAO();
		dao.insert(p);

		List<Student> list=dao.search("");
		request.setAttribute("list, list");

		return "list.jsp";
	}
}
