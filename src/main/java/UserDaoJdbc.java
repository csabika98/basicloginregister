import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class UserDaoJdbc implements UserDao {

    private DataSource dataSource = new DatabaseManager().connect();
    private String username;
    private String password;
    private String email;
//private String created_on;
//private String last_login;


    public UserDaoJdbc(String username, String password, String email) throws SQLException {//, String created_on, String last_login) throws SQLException {
        this.username = username;
        this.password = password;
        this.email = email;
//    this.created_on = created_on;
//    this.last_login = last_login;


    }

    public UserDaoJdbc() throws SQLException {

    }


    @Override
    public void add(User user) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "INSERT INTO users(username, password, email) VALUES(?,?,?)";
            PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            st.setString(1, username);
            st.setString(2, password);
            st.setString(3, email);
            //st.setString(4, created_on);
            //st.setString(5, last_login);
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            rs.next();


        } catch (SQLException throwables) {
            throw new RuntimeException("Error while adding new user:", throwables);

        }


    }

    @Override
    public void update(User user) {

    }

    @Override
    public void remove(User user) {

    }

    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }


    @Override
    public User findByName(String username, String password) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if(!rs.next()) {
                return null;
            }return new User(rs.getString(1), rs.getString(2), rs.getString(3));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


