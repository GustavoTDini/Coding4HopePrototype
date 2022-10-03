import Dao.UsuarioDao;
import View.MainFrame;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UsuarioDao.mostrarTodosUsuarios();
        System.out.println("Hello world!");
        MainFrame mainFrame = new MainFrame();
    }
}