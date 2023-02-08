package personmenu.jdbc.dao;

import java.util.List;

import personmenu.jdbc.dto.Person;

public interface PersonDao {

	int insert(Person person);
	
	int deleteByNo(int no);
	
	int update(Person person);
	
	List<Person> findAll();
}
