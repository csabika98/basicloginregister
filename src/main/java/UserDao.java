

import java.util.List;

public interface UserDao {


    // INSERT INTO this will insert all the data for your database
    void add(User user);

    // ITS UPDATE METHOD so you can edit EXISTING USER
    void update(User user);

    void remove(User user);
    // FETCH ALL THE USERS / FETCHING , LIST THE REGISTERED USER by ID
    // USER ID = 6 , USERNAME = valami Password = SOMETHING
    User get(int id);


    // THIS IS LIST ALL USERS /
    List<User> getAll();


    User findByName(String username, String password);



}

