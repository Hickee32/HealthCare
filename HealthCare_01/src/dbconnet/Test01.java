package dbconnet;

public class Test01 {

	public static void main(String[] args) {

		DbConnet dbC = new DbConnet();

		// 가입
		// dbC.insertStudent("pk", "박구", "1324");

		// 중복 아이디 검색
		// dbC.selectOne("SMS");

		// dbC.selectOne("BB");

		dbC.LoginDB("admin", "0234");

	}

}
