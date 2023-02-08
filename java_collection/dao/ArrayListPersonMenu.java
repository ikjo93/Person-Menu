package personmenu.java_collection.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import personmenu.java_collection.dto.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArrayListPersonMenu implements PersonMenu {

    private static final String JSON_FILE_TARGET = "data/list-users.json";
    private final List<Person> people = new ArrayList<>();
    private int index = 0;

    public ArrayListPersonMenu() {
        loadData();
    }

    private void loadData() {
        try (Reader reader = new FileReader(JSON_FILE_TARGET)) {
            Gson gson = new Gson();
            List<Person> data = gson.fromJson(reader,
                    new TypeToken<ArrayList<Person>>() {}.getType()
            );
            for (Person p : data) {
                people.add(p);
                index = Math.max(index, p.getIndex() + 1);
            }
        } catch (FileNotFoundException e) {
            System.out.println("파일이 존재하지 않습니다.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void insert(Person person) {
        person.setIndex(index++);
        people.add(person);
    }

    @Override
    public void delete(int index) {
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).hasSameIndex(index)) {
                people.remove(i);
                return;
            }
        }

        throw new IllegalStateException(index + "에 해당하는 사람이 없습니다.");
    }

    @Override
    public void update(Person person) {
        int index = person.getIndex();
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).hasSameIndex(index)) {
                people.set(i, person);
                return;
            }
        }

        throw new IllegalStateException(index + "에 해당하는 사람이 없습니다.");
    }

    @Override
    public List<Person> select() {
        return new ArrayList<>(people);
    }

    @Override
    public void save() {
        try (Writer writer = new FileWriter(JSON_FILE_TARGET)){
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(people, writer);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
