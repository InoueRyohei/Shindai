package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Student;

//studentテーブルに対する処理を行う。
//学生検索と学生追加、変更、削除の機能を持たせる
public class StudentDAO extends DAO {
//	学生検索機能
	public List<Student> search(String keyword) throws Exception {
		List<Student> list=new ArrayList<>();
		
		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement(
			"select * from student where school_cd = ?");
		st.setString(1, keyword);
		ResultSet rs=st.executeQuery();
		
		while (rs.next()) {
			Student s=new Student();
			s.setNo(rs.getString("no"));
			s.setName(rs.getString("name"));
			s.setEnt_year(rs.getInt("ent_year"));
			s.setClass_num(rs.getInt("class_num"));
			s.setIs_attend(rs.getBoolean("is_attend"));
			s.setSchool_cd(rs.getString("school_cd"));
			list.add(s);
		}
		
		st.close();
		con.close();
		
		return list;
	}
	
	//追加機能
	 public int insert(Student student) throws Exception {
		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
				"INSERT INTO STUDENT VALUES(?, ?, ?, ?, ?, ?)");
		
		st.setString(1, student.getNo());
		st.setString(2, student.getName());
		st.setInt(3, student.getEnt_year());
		st.setInt(4, student.getClass_num());
		st.setBoolean(5, student.getIs_attend());
		st.setString(6, student.getSchool_cd());
		
		
		int list=st.executeUpdate();

		st.close();
		con.close();
		return list;
	}
}

	