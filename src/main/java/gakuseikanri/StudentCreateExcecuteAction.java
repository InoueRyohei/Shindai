package gakuseikanri;

import java.util.List;

import bean.Student;
import bean.Teacher;
import dao.StudentDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;


public class StudentCreateExcecuteAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
		
		
		HttpSession session=request.getSession();
		String name=request.getParameter("name");
		String no=request.getParameter("no");
		Integer ent_year=Integer.parseInt(request.getParameter("ent_year"));
		Integer class_num=Integer.parseInt(request.getParameter("class_num"));
		boolean is_attend=true;
		Teacher teacher=(Teacher)session.getAttribute("teacher");
		String school_cd=teacher.getSchool_cd();
		
		if (name == null || name.isEmpty() || no == null || no.isEmpty()) {
            request.setAttribute("errorMessage", "学生番号または氏名を入力してください");
            return "student_create.jsp";
        }
		
		if (ent_year == 0) {
            request.setAttribute("errorMessage", "入学年度を選択してください");
            return "student_create.jsp";
        }
		
//		学生番号が重複している場合の処理
		StudentDAO dao=new StudentDAO();
		List<Student> list=dao.search(""); 
		boolean noDuplication = false;
		for(int i=0; i<list.size(); i++) {
//			System.out.println(list.get(i).getNo());
			
			
			
			if (list.get(i).getNo().equals(no)) {
				System.out.println(no);
				noDuplication=true;
				break;
			}
		}
		
		if (noDuplication) {
			request.setAttribute("errorMessage", "学生番号が重複しています");
			return "student_create.jsp";
		}
		
		
		Student p=new Student();
		p.setEnt_year(ent_year);
		p.setNo(no);
		p.setName(name);
		p.setClass_num(class_num);
		p.setIs_attend(is_attend);
		p.setSchool_cd(school_cd);
//		StudentDAO dao=new StudentDAO();
		dao.insert(p);


		

		return "student_create_done.jsp";
	}

}

//372p gakuseikanri.StudentCreateExecuteAction