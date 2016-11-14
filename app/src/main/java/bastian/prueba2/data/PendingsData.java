package bastian.prueba2.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bastian.prueba2.models.Pending;

/**
 * Created by Bastian on 11-11-2016.
 */

public class PendingsData {

    public List<Pending> notDone() {
        List<Pending> pendings = new ArrayList<>();
        List<Pending> pendingList = Pending.find(Pending.class, "done = 0");
        if (pendingList != null && pendingList.size() > 0) {
            pendings.addAll(pendingList);
        }
        return pendings;
    }

    public List<String> names() {
        List<String> names = new ArrayList<>();
        List<Pending> pendings = notDone();
        if (pendings.size() > 0) ;
        for (Pending pending : pendings) {
            names.add(pending.getName());
        }
        return names;
    }

    public List <Pending> byName (String name) {
        List <Pending> pendings = new ArrayList<>();
        String query = "done = 0 AND name LIKE" + "'%" + name + "%'" ;
        List <Pending> pendingList = Pending.find(Pending.class, query);
        if (pendingList != null && pendingList.size() > 0){
            pendings.addAll(pendingList);
        }
        return pendings;

    }
}