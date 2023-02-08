package personmenu.java_collection;

import personmenu.java_collection.dao.ArrayListPersonMenu;
import personmenu.java_collection.dao.PersonMenu;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        PersonMenu pm = new ArrayListPersonMenu();
        new PersonMenuTest(pm).run();
    }
}
