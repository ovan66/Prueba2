package bastian.prueba2.views.main;

import bastian.prueba2.models.Pending;

/**
 * Created by Bastian on 11-11-2016.
 */

public interface CreateCallback {

    void succes (Pending pending);
    void fail();
}
