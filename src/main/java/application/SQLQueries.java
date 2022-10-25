package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLQueries {

    private static final String url ="jdbc:mysql://127.0.0.1:3306/results ";
    private static final String user = "root";
    private static final String password = "password";


    public void reportToDB(String testCase, String result, String ex, String duration )throws SQLException {

        try(Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement())
        {
            String sqlInsert = "INSERT INTO resultstbl "
                    + "VALUES (null,'"+testCase+"','"+result+"','"+ex+"','"+getDateTime()+"','"+duration+"')";

            stmt.executeUpdate(sqlInsert);

        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }


    }
    public void reportToDB(String testCase, String result, String duration )throws SQLException {

        try(Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement())
        {
            String sqlInsert = "INSERT INTO resultstbl "
                    + "VALUES (null,'"+testCase+"','"+result+"',null,'"+getDateTime()+"','"+duration+"')";

            stmt.executeUpdate(sqlInsert);

        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }


    }
    public String getDateTime()
    {
        java.util.Date dt = new java.util.Date();

        java.text.SimpleDateFormat sdf =
                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return sdf.format(dt);
    }


}
