package collections.ui;

import collections.dto.Person;

import java.util.List;

public class UserView {

    private static final UserView instance = new UserView();

    private UserView() {}

    public static UserView getInstance() {
        return instance;
    }

    public void search(List<Person> people) {
        StringBuilder view = new StringBuilder();
        view.append("\n#사람목록\n");
        for (Person person : people) {
            view.append(person.getIndex()).append(": [")
                    .append(person.getName())
                    .append(",")
                    .append(person.getAge())
                    .append(",")
                    .append(person.getJob())
                    .append("]\n");
        }

        System.out.println(view);
    }

    public void exit() {
        System.out.println("\n프로그램을 종료합니다.");
    }

    public void invalidOptionError() {
        System.out.println("\n유효하지않은 명령어입니다. 다시 입력해주세요.");
    }

    public void invalidInputFormatError() {
        System.out.println("번호와 나이는 숫자 형식으로 입력해주세요.");
    }

    public void processError(String message) {
        System.out.println(message);
    }
}
