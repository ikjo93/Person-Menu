package personmenu.jdbc;

import personmenu.jdbc.dao.PersonJdbcDao;

public class Main {

	public static void main(String[] args) {
		new PersonTest(new PersonJdbcDao()).run();
	}

}
