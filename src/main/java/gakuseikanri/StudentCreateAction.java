package gakuseikanri;

import java.util.List;

import bean.Student;
import dao.StudentDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;


public class StudentCreateAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
	
		String name=request.getParameter("name");
		String no=request.getParameter("no");
		Integer ent_year=Integer.parseInt(request.getParameter("ent_year"));
		Integer class_num=Integer.parseInt(request.getParameter("class_num"));
		
		
		Student p=new Student();
		p.setEnt_year(ent_year);
		p.setNo(no);
		p.setName(name);
		p.setClass_num(class_num);		
		StudentDAO dao=new StudentDAO();
		dao.insert(p);

		List<Student> list=dao.search("");
		request.setAttribute("list", list);
		

		return "student_create_done.jsp";
	}
}

//372p