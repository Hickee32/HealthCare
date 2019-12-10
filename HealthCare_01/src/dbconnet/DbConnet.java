package dbconnet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import views.RootController;

public class DbConnet extends RootController {

	private Connection conn; // DB Ŀ�ؼ�(����) ��ü
	private static final String USERNAME = "root"; // DB ���ӽ� ID
	private static final String PASSWORD = "1396"; // DB ���ӽ� �н�����
	// DB���� ��� ���� ���࿡ Timezone exception �߻��ÿ��� ?serverTimezone=UTC �߰�
	private static final String URL = "jdbc:mysql://localhost:3307/healthcare?serverTimezone=UTC";

	public DbConnet() {
		// connection��ü�� �����ؼ� DB�� ������.
		try {
			System.out.println("������");
			// ���� ��ü�� �������
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("����̹� �ε� ����!!");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("����̹� �ε� ����!!");
		}
	}

	// ȸ������
	public void insertUser(String id, String name, String pw) {
		// ������ �غ�
		String sql = "insert into UserTbl values(?,?,?);";

		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id); // ù ��° ? ����
			pstmt.setString(2, name); // �� ��° ? ����
			pstmt.setString(3, pw);// �� ��° ? ����
			// ������ �����϶�.
			pstmt.executeUpdate();
			System.out.println("������ ���� ����!");
		} catch (SQLException e) {
			System.out.println("������ ���� ����!");
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
		String sql = "select * from UserTbl where Uid = ?;";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			// pstmt.setString(2, id); //and ������ ���� ������ �߰��Ѵ�.
			ResultSet rs = pstmt.executeQuery();
			// select�� ����� ResultSet�� ��� ���ϵȴ�.
			if (rs.next()) { // ������ ���� ������ true, ������ false

				String setstr = "�����ϴ� ���̵� �Դϴ�.";
				System.out.println(setstr);
			} else {
				String setstr = "��� ������ ���̵� �Դϴ�.";
				System.out.println(setstr);
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

	// ���̵� �ߺ� ���� �Ű����� string -> label -> permit -> btn
	public void selectOne(String id, Label label, Boolean permit, Button btn) {
		String sql = "select * from UserTbl where Uid = ?;";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) { // ������ ���� ������ true, ������ false
				permit = false;
				String setstr = "�����ϴ� ���̵� �Դϴ�.";
				label.setText(setstr);

			} else {
				permit = true;
				String setstr = "��� ������ ���̵� �Դϴ�.";
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
		String sql = "select Uid,Uname,Upw from UserTbl where Uid =" + "'" + id + "'";
		String DBid = null;
		String DBpw = null;
		String DBname = null;

		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				DBid = rs.getString("Uid");
				DBpw = rs.getString("Upw");
				DBname = rs.getString("Uname");
				if (!(DBid.equals(id)) || !(pw.equals(DBpw))) {
					return false;
				} else {
					RootController.setUserLoginName(DBname);

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
