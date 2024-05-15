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
		
		PreparedStatemet st=con.prepareStatement(
			"select * from subject where school=cd like ?");
		st.setString(1, '%'+keyword+'%');
		ResultSet rs=st.executeQuery();
		
		While (rs.next()) {
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

	//
	public Subject searchByNo(String )
	



--------------------------------------------------------------------------------------------------

	
	// 学生番号で学生情報を検索するメソッド
    public Student searchByNo(String studentNo) throws Exception {
        Connection con = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        Student student = null;

        try {
            st = con.prepareStatement("SELECT * FROM student WHERE no = ?");
            st.setString(1, studentNo);
            rs = st.executeQuery();

            if (rs.next()) {
                student = new Student();
                student.setNo(rs.getString("no"));
                student.setName(rs.getString("name"));
                student.setEnt_year(rs.getInt("ent_year"));
                student.setClass_num(rs.getInt("class_num"));
                student.setIs_attend(rs.getBoolean("is_attend"));
                student.setSchool_cd(rs.getString("school_cd"));
            }
        } finally {
            // リソースの解放
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            con.close();
        }

        return student;
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
	 
	 //変更機能
	 public int update(Student student, String update_no) throws Exception {
		 Connection con=getConnection();
		 
		 PreparedStatement st=con.prepareStatement(
				 "UPDATE STUDENT SET NO = ?, NAME = ?, ENT_YEAR = ?, CLASS_NUM = ?, IS_ATTEND = ?, SCHOOL_CD = ? "
				 + "WHERE NO = ?");
		 
		 st.setString(1, student.getNo());
		 st.setString(2, student.getName());
		 st.setInt(3, student.getEnt_year());
		 st.setInt(4, student.getClass_num());
		 st.setBoolean(5, student.getIs_attend());
		 st.setString(6, student.getSchool_cd());
		 st.setString(7, update_no);
		 
		 int list=st.executeUpdate();
		 
		 st.close();
		 con.close();
		 return list;
	 }
}
