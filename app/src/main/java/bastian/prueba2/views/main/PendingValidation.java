package bastian.prueba2.views.main;

import bastian.prueba2.models.Pending;

/**
 * Created by Bastian on 11-11-2016.
 */

public class PendingValidation {

    private CreateCallback callback;

    public PendingValidation(CreateCallback callback) {
        this.callback = callback;
    }

    public void init (String name){

        if (name.trim().length() > 0){
            Pending pending = new Pending();
            pending.setName(name);
            pending.setDone(false);
            pending.save();
            callback.succes(pending);


        }else{
            callback.fail();
        }

    }
}
