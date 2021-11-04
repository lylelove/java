import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCtest001 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            Driver driver = new com.microsoft.sqlserver.jdbc.SQLServerDriver();
            DriverManager.registerDriver(driver);
            String url="jdbc:sqlserver://localhost:1433; DatabaseName=test";
            String user="lylelove";
            String password= "lylelove2000A";
            connection = DriverManager.getConnection(url,user,password);
            System.out.println(connection);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
