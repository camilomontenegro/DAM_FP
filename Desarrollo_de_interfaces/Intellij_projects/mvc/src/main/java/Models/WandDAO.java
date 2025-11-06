package Models;

import DataBase.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WandDAO {
    private Connection conn;

    public WandDAO() {
        conn = DBConnection.getConnection();
    }

    public void create(Wand wand) throws SQLException {
        String sql = "insert into wand (wood, core, length) values (?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, wand.getWood());
        ps.setString(2, wand.getCore());
        ps.setString(3, wand.getLength());
    }
}
