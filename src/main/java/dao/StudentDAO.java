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
			"select * from student where school_cd like ?");
		st.setString(1, '%'+keyword+'%');
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

	