package dao;

import com.db4o.query.Query;

import modelo.Subject;

import java.util.List;


public class DAOSubject extends DAO<Subject>{

    public Subject read (Object key) {
        String word = (String) key;

        Query q = manager.query();

        q.constrain(Subject.class);
        q.descend("word").constrain(word);

        List<Subject> results = q.execute();

        if (results.size()>0)
            return results.get(0);
        else
            return null;
    }

}