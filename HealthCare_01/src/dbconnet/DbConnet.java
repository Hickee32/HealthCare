package dbconnet;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import views.MainController;

public class DbConnet extends MainController {

	private Connection conn; // DB 커넥션(연결) 객체
	private static final String USERNAME = "root"; // DB 접속시 ID
	private static final String PASSWORD = "1396"; // DB 접속시 패스워드
	// DB접속 경로 설정 만약에 Timezone exception 발생시에는 ?serverTimezone=UTC 추가
	private static final String URL = "jdbc:mysql://localhost:3307/healthcare?serverTimezone=UTC";

	public DbConnet() {
		// connection객체를 생성해서 DB에 연결함.
		try {
			System.out.println("생성자");
			// 동적 객체를 만들어줌
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("드라이버 로딩 성공!!");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("드라이버 로드 실패!!");
		}
	}

	// 회원가입
	public void insertUser(String id, String name, String pw) {
		// 쿼리문 준비
		String sql = "insert into UserTbl values(?,?,?,default);";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id); // 첫 번째 ? 매핑
			pstmt.setString(2, name); // 두 번째 ? 매핑
			pstmt.setString(3, pw);// 세 번째 ? 매핑
			// 쿼리문 실행하라.
			pstmt.executeUpdate();
			System.out.println("데이터 삽입 성공!");
		} catch (SQLException e) {
			System.out.println("데이터 삽입 실패!");
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void insertUserinfo(String id, double weight,double height, double bmi) {
	
		String sql = "insert into Userinfomation values(?,?,?,?);";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id); 
			pstmt.setDouble(2, weight);
			pstmt.setDouble(3, height);
			pstmt.setDouble(4, bmi);
			pstmt.executeUpdate();
			System.out.println("데이터 삽입 성공!");
		} catch (SQLException e) {
			System.out.println("데이터 삽입 실패!");
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void selectOne(String id) {
		String sql = "select Uweight,Uheight,Ubmi from userInformation where Userid = ?;";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			// 가져올 행이 있으면 true, 없으면 false
			if (rs.next()) {
				main.MainApp.setUweight(rs.getDouble("Uweight"));
				main.MainApp.setUheight(rs.getDouble("Uheight"));
				main.MainApp.setUbmi(rs.getDouble("Ubmi"));
			} else {
				main.MainApp.setUweight(0.0);
				main.MainApp.setUheight(0.0);
				main.MainApp.setUbmi(0.0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 아이디 중복 여부 매개변수 string -> label -> permit -> btn
	public void selectOne(String id, Label label, Boolean permit, Button btn) {
		String sql = "select * from UserTbl where Uid = ?;";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) { // 가져올 행이 있으면 true, 없으면 false
				permit = false;
				String setstr = "존재하는 아이디 입니다.";
				label.setText(setstr);

			} else {
				permit = true;
				String setstr = "사용 가능한 아이디 입니다.";
				label.setText(setstr);

			}

			if (permit) {
				btn.setVisible(true);
			} else {
				btn.setVisible(false);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean LoginDB(String id, String pw) {
		String sql = "select Uid,Uname,Upw,initdate from UserTbl where Uid =" + "'" + id + "';";

		String DBid = null;
		String DBpw = null;
		String DBname = null;
		Date DBdate = null;

		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				DBid = rs.getString("Uid");
				DBpw = rs.getString("Upw");
				DBname = rs.getString("Uname");
				DBdate = rs.getDate("initdate");

				System.out.println("id = " + DBid + ",DBpw = " + DBpw + ",DBname = " + DBname + ",DBdate = " + DBdate);
				if (!(DBid.equals(id)) || !(pw.equals(DBpw))) {
					return false;
				} else {
					main.MainApp.setUid(DBid);
					main.MainApp.setUname(DBname);
					main.MainApp.setUinidate(DBdate);

					selectOne(DBid);

					System.out.println("stid = " + main.MainApp.getUid() + ",stname = " + main.MainApp.getUname()
							+ ",stdate = " + main.MainApp.getUinidate());
					System.out.println("weight" + main.MainApp.getUweight() + "height" + main.MainApp.getUheight()
							+ "bmi" + main.MainApp.getUbmi());
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
