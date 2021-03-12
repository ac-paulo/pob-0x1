package dao;

import modelo.View;
import com.db4o.query.Query;

import java.util.List;


public class DAOView extends DAO<View> {

    public View read (Object key) {
        String user = (String) key;

        Query q = manager.query();

        q.constrain(View.class);
        q.descend("user").constrain(user);

        List<View> results = q.execute();

        if ( results.size()>0 )
            return results.get(0);
        else
            return null;
    }

    public View consultarPorId(Integer n) {
        Query q = manager.query();
        q.constrain(View.class);
        q.descend("id").constrain(n);
        List<View> resultados = q.execute();
        if(resultados.size()==0)
            return null;
        else
            return resultados.get(0);
    }

    public View consultarVisualizacaoPorVideo(String n){
        Query q = manager.query();
        q.constrain(View.class);
        q.descend("video").constrain(n);
        List<View> resultados = q.execute();
        if(resultados.size()==0)
            return null;
        else
            return resultados.get(0);

    }
}
