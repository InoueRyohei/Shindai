package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Class_num;

//class_numテーブルに対する処理を行う
//
public class Class_numDAO extends DAO {
	public List<Class_num> search(String keyword)
			throws Exception {
			List<Class_num> list=new ArrayList<>();
			
			Connection con=getConnection();
			
			PreparedStatement st;
			st=con.prepareStatement(
				"select * from class_num where school_cd = ?");
			st.setString(1, keyword);
			ResultSet rs=st.executeQuery();
			
			while (rs.next()) {
				Class_num c=new Class_num();
				c.setSchool_cd(rs.getString("school_cd"));
				c.setClass_num(rs.getString("class_num"));
				list.add(c);
			}
			
			st.close();
			con.close();
			return list;
	}
}
