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
			"select * from subject where school_cd like ?");
		st.setString(1, '%'+keyword+'%');
		ResultSet rs=st.executeQuery();
		
		while (rs.next()) {
			Subject sub=new Subject();
			sub.setSchool_cd(rs.getString("school_cd"));
			sub.setSubject_cd(rs.getString("cd"));
			sub.setSubject_name(rs.getString("name"));
			list.add(sub);
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
			st.setString(2,subject.getSubject_cd());
			st.setString(3,subject.getSubject_name());
			
			
			int list=st.executeUpdate();
			
			st.close();
			con.close();
			return list;
	}
	
	//	変更機能
	public int update(Subject subject, String update_no) throws Exception {
		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement(
				"UPDTE SUBJECT SET SCHOOL_CD = ?, CD = ?, NAME = ?" + "WHERE CD = ?");
		
		st.setString(1,subject.getSchool_cd());
		st.setString(2,subject.getSubject_cd());
		st.setString(3,subject.getSubject_name());
		st.setString(4,update_no);
		
		int list=st.executeUpdate();
		
		st.close();
		con.close();
		return list;
	}
}
