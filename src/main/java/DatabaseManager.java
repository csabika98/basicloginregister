
import org.postgresql.ds.PGSimpleDataSource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.SQLOutput;


public class DatabaseManager {


    // we are going to connect to our DATABASE
    public DataSource connect() throws SQLException{

        PGSimpleDataSource dataSource = new PGSimpleDataSource();

        String dbName = "codecoolshop";
        String user = "postgres";
        String password = "derank123";

        dataSource.setDatabaseName(dbName);
        dataSource.setUser(user);
        dataSource.setPassword(password);

        System.out.println("Trying to connect! ");

        dataSource.getConnection().close();

        System.out.println("Connection OK! ");


        return dataSource;
    }




}
