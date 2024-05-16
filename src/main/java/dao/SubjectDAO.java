package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Subject;

//subjectテーブルに対する処理を行う。
//新規登録、変更、削除の機能を持たせる

public class SubjectDAO extends DAO {
	//	
	public List<Subject> search(String keyword) throws Exception {
		List<Subject> list=new ArrayList<>();
		
		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement(
			"select * from subject where school=cd like ?");
		st.setString(1, '%'+keyword+'%');
		ResultSet rs=st.executeQuery();
		
		while (rs.next()) {
			Subject s=new Subject();
			s.setSchool_cd(rs.getString("school_cd"));
			s.setCd(rs.getString("cd"));
			s.setName(rs.getString("name"));
			list.add(s);
		}
	
		st.close();
		con.close();
		
		return list;
	}

	//追加機能
	public int insert(Subject subject) throws Exception {
		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement(
				"INSERT INTO SUBJECT VALUES(?, ?, ?, ?, ?, ?)");
		
			st.setString(1,subject.getSchool_cd());
			st.setString(2,subject.getCd());
			st.setString(3,subject.getName());
			
			
			int list=st.executeUpdate();
			
			st.close();
			con.close();
			return list;
	}
	
	//	変更機能
	public int update(String subject, String update_no) throws Exception {
		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement(
				"UPDTE SUBJECT SET SCHOOL_CD = ?, CD = ?, NAME = ?" + "WHERE NO = ?");
		
		st.setString(1,subject.getSchool_cd());
		st.setString(2,subject.getCd());
		st.setString(3,subject.getName());
		st.setString(4,update_no);
		
		int list=st.executeUpdate();
		
		st.close();
		con.close();
		return list;
	}
}
