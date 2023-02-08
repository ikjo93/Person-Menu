package personmenu.jdbc;

import java.io.IOException;

import personmenu.jdbc.dao.PersonDao;
import personmenu.jdbc.display.UserInput;
import personmenu.jdbc.display.UserView;

public class PersonTest {
	
    private static final UserInput ui = UserInput.getInstance();
    private static final UserView uv = UserView.getInstance();
    private final PersonDao pd;
    
    public PersonTest(PersonDao pd) {
        this.pd = pd;
    }
    
	public void run() {
		Main : while (true) {
            try {
                int number = ui.getOptionNumber();

                switch (number) {
                    case 1:
                    	pd.insert(ui.getNewPerson());
                        break;
                    case 2:
                        uv.search(pd.findAll());
                        break;
                    case 3:
                    	pd.update(ui.getUpdatePerson());
                        break;
                    case 4:
                    	pd.deleteByNo(ui.getDeleteIndex());
                        break;
                    case 5:
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
