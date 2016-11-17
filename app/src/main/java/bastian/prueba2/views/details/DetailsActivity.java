package bastian.prueba2.views.details;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;

import bastian.prueba2.R;
import bastian.prueba2.models.Pending;
import bastian.prueba2.views.main.pendingList.PendingListFragment;

/**
 * Created by Bastian on 12-11-2016.
 */

public class DetailsActivity extends AppCompatActivity {

    private Pending pending;
    private EditText descriptionImput;
    private Switch daySwitch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        long pendingId = getIntent().getLongExtra(PendingListFragment.PENDING_ID,0);
        pending = Pending.findById(Pending.class, pendingId);
        getSupportActionBar().setTitle(pending.getName());
        descriptionImput = (EditText) findViewById(R.id.descriptionEt);
        daySwitch = (Switch) findViewById(R.id.daySwitch);


    }

    @Override
    protected void onResume() {
        super.onResume();
        descriptionImput.setText(pending.getDescription());
        daySwitch.setChecked(pending.isDay());
    }

    @Override
    protected void onPause() {
        String description = descriptionImput.getText().toString();
        pending.setDescription(description);

        if (daySwitch.isChecked() == true){
            pending.setDay(true);
        }else{
            pending.setDay(false);
        }
        pending.save();
        super.onPause();
    }
}