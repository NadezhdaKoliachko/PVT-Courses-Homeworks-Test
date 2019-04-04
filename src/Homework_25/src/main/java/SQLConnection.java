import java.sql.*;
import java.util.ArrayList;

public class SQLConnection {
    private static SQLConnection instance;

    private SQLConnection() throws SQLException {
    }

    public static SQLConnection getInstance() throws SQLException { // #3
        if (instance == null) {        //если объект еще не создан
            instance = new SQLConnection();    //создать новый объект
        }
        return instance;        // вернуть ранее созданный объект
    }
    public ArrayList<CharSequence> sqlConnector() {
        ArrayList<CharSequence> listOfUserData = new ArrayList<>();
        String url = "jdbc:mysql://localhost/test_automation?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "root";
        String password = "Krasnietulpani@1";
        String query = "SELECT * from users";
//Class.forName(&quot;com.mysql.cj.jdbc.Driver&quot;);
        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query))
        {
            while (rs.next())
            {
                listOfUserData.add(rs.getString(2));
                listOfUserData.add(rs.getString(3));
                listOfUserData.add(rs.getString(4));
                listOfUserData.add(rs.getString(5));
                listOfUserData.add(rs.getString(6));
                listOfUserData.add(rs.getString(7));
                listOfUserData.add(rs.getString(8));
                listOfUserData.add(rs.getString(9));
                listOfUserData.add(rs.getString(10));
            }
            rs.close();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return listOfUserData;
    }

}

