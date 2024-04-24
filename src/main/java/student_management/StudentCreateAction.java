package student_management;

import bean.Product;
import dao.ProductDAO;
import tool.Action;
import javax.servlet.http.*;
import javax.util.List;

public class InsertAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
	
		String name=request.getParameter("name");
		Integer price=Integer.parseInt.parseInt(request.getParameter("price"));
	
		Product p=new Product();
		p.setEnt_year(ent_year);
		p.setNo(no);
		p.setName(name);
		p.setClass_num(class_num);		
		ProductDAO dao=new ProductDAO();
		dao.insert(p);

		List<Product> list=dao.search("");
		request.setAttribute("list, list");

		return "list.jsp"
	}
}
