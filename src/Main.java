import Dao.UsuarioDao;
import View.MainFrame;

import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        MainFrame mainFrame = new MainFrame();
        mainFrame.mainShow();
    }
}