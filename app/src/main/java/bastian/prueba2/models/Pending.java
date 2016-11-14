package bastian.prueba2.models;

import com.orm.SugarRecord;

/**
 * Created by Bastian on 09-11-2016.
 */

public class Pending extends SugarRecord {

    private String name, description;
    private boolean done, day;

    public Pending() {
    }

    public boolean isDay() {
        return day;
    }

    public void setDay(boolean day) {
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
