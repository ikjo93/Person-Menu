package collections;

import collections.dao.PersonMenu;
import collections.ui.UserInput;
import collections.ui.UserView;

import java.io.IOException;

public class PersonMenuTest {

    private static final UserInput ui = UserInput.getInstance();
    private static final UserView uv = UserView.getInstance();
    private final PersonMenu pm;

    public PersonMenuTest(PersonMenu pm) {
        this.pm = pm;
    }

    public void run() {
        Main : while (true) {
            try {
                int number = ui.getOptionNumber();

                switch (number) {
                    case 1:
                        pm.insert(ui.getNewPerson());
                        break;
                    case 2:
                        uv.search(pm.select());
                        break;
                    case 3:
                        pm.update(ui.getUpdatePerson());
                        break;
                    case 4:
                        pm.delete(ui.getDeleteIndex());
                        break;
                    case 5:
                        pm.save();
                        break;
                    case 6:
                        uv.exit();
                        break Main;
                    default:
                        uv.invalidOptionError();
                }
            } catch (NumberFormatException e) {
                uv.invalidInputFormatError();
            } catch (IllegalStateException e) {
                uv.processError(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
