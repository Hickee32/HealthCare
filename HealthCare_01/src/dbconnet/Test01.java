package dbconnet;

public class Test01 {

	public static void main(String[] args) {

		DbConnet dbC = new DbConnet();

		// ����
		// dbC.insertStudent("pk", "�ڱ�", "1324");

		// �ߺ� ���̵� �˻�
		// dbC.selectOne("SMS");

		// dbC.selectOne("BB");

		dbC.LoginDB("admin", "0234");

	}

}
