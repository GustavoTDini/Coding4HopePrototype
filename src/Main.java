import Dao.Gerenciador;
import Dao.UsuarioDao;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UsuarioDao.mostrarTodosUsuarios();
        System.out.println("Hello world!");
    }
}