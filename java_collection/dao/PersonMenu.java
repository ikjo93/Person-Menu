package personmenu.java_collection.dao;

import personmenu.java_collection.dto.Person;

import java.util.List;

public interface PersonMenu {

    void insert(Person person);

    void delete(int index);

    void update(Person person);

    List<Person> select();

    void save();
}
