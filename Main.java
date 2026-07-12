import database1.DBConnection;
import service.Library;
import ui.MainFrame;

public class Main {

    public static void main(String[] args) {

        DBConnection.getConnection();

        Library library = new Library();

        new MainFrame(library);

    }

}