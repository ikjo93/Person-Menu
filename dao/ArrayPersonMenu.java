package collections.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import collections.dto.Person;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayPersonMenu implements PersonMenu {

    private static final String JSON_FILE_TARGET = "data/array-users.json";

    private static final int MAX_SIZE = 100;
    private final Person[] people = new Person[MAX_SIZE];
    private int size = 0;
    private int index = 0;

    public ArrayPersonMenu() {
        loadData();
    }

    private void loadData() {
        try (Reader reader = new FileReader(JSON_FILE_TARGET)) {
            Gson gson = new Gson();
            Person[] data = gson.fromJson(reader, new TypeToken<Person[]>() {}.getType());
            for (Person p : data) {
                if (p != null) {
                    index = Math.max(index, p.getIndex() + 1);
                    people[size++] = p;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("파일이 존재하지 않습니다.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void insert(Person person) {
        if (size < MAX_SIZE) {
            person.setIndex(index++);
            people[size++] = person;
        } else {
            throw new IllegalStateException("더이상 사람을 추가할 수 없습니다.");
        }
    }

    @Override
    public void delete(int index) {
        for (int i = 0; i < size; i++) {
            if (people[i].hasSameIndex(index)) {
                people[i] = people[size - 1];
                people[size - 1] = null;
                size--;
                return;
            }
        }

        throw new IllegalStateException(index + "번호에 해당하는 사람이 없습니다.");
    }

    @Override
    public void update(Person person) {
        int index = person.getIndex();
        for (int i = 0; i < size; i++) {
            if (people[i].hasSameIndex(index)) {
                people[i] = person;
                return;
            }
        }

        throw new IllegalStateException(index + "번호에 해당하는 사람이 없습니다.");
    }

    @Override
    public List<Person> select() {
        return Arrays.stream(people)
                .limit(size)
                .collect(Collectors.toList());
    }

    @Override
    public void save() {
        try (Writer writer = new FileWriter(JSON_FILE_TARGET)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(people, writer);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
