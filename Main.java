package collections;

import collections.dao.ArrayListPersonMenu;
import collections.dao.PersonMenu;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        PersonMenu pm = new ArrayListPersonMenu();
        new PersonMenuTest(pm).run();
    }
}
