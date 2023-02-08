package personmenu.java_collection.ui;

import personmenu.java_collection.dto.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInput {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final String GUIDE = "<사람메뉴>\n1. 추가 2. 검색 3. 수정 4. 삭제 5. 저장 6. 종료\n번호입력==> ";
    private static final UserInput instance = new UserInput();

    private UserInput() {}

    public static UserInput getInstance() {
        return instance;
    }

    public int getOptionNumber() throws IOException {
        System.out.print(GUIDE);
        return Integer.parseInt(br.readLine());
    }

    public Person getNewPerson() throws IOException {
        System.out.println();
        System.out.print("이름 : ");
        String name = br.readLine();

        System.out.print("나이 : ");
        int age = Integer.parseInt(br.readLine());

        System.out.print("직업 : ");
        String job = br.readLine();
        System.out.println();

        return new Person(name, age, job);
    }

    public Person getUpdatePerson() throws IOException {
        System.out.println();
        System.out.print("수정할 번호 : ");
        int updateNumber = Integer.parseInt(br.readLine());

        System.out.print("수정할 이름 : ");
        String name = br.readLine();

        System.out.print("나이 : ");
        int age = Integer.parseInt(br.readLine());

        System.out.print("직업 : ");
        String job = br.readLine();
        System.out.println();

        return new Person(updateNumber, name, age, job);
    }

    public int getDeleteIndex() throws IOException {
        System.out.println();
        System.out.print("삭제할 번호 : ");
        return Integer.parseInt(br.readLine());
    }
}
