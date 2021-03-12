package dao;

import modelo.User;

import java.util.List;

import com.db4o.query.Query;

public class DAOUser extends DAO<User> {

    public User read(Object key) {
        String email = (String) key;

        Query q = manager.query();

        q.constrain(User.class);
        q.descend("email").constrain(email);

        List<User> results = q.execute();
        if (results.size() > 0)
            return results.get(0);
        else
            return null;
    }

    public List<User> getUsers(String chars) {
        Query q = manager.query();

        q.constrain(User.class);
        q.descend("nome").constrain(chars).like();

        List<User> results = q.execute();

        return results;
    }

}
