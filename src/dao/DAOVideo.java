package dao;

import com.db4o.query.Query;
import modelo.User;
import modelo.Video;
import modelo.View;

import java.util.ArrayList;
import java.util.List;

public class DAOVideo extends DAO<Video> {

    public Video read (Object key) {
        String link = (String) key;

        Query q = manager.query();

        q.constrain(Video.class);
        q.descend("link").constrain(link);

        List<Video> results = q.execute();
        if ( results.size()>0 )
            return results.get(0);
        else
            return null;
    }

    public Video consultarVideoPorLink(String n){
        Query q = manager.query();
        q.constrain(Video.class);
        q.descend("link").constrain(n);
        List<Video> resultados = q.execute();
        if(resultados.size()==0)
            return null;
        else
            return resultados.get(0);

    }
    public List<Video> consultarVideoPorPalavra(String n){
        Query q = manager.query();
        q.constrain(Video.class);
        q.descend("assuntos").descend("palavra").constrain(n);
        List<Video> resultados = q.execute();
        if(resultados.size()==0)
            return null;
        else
            return resultados;
    }

}
