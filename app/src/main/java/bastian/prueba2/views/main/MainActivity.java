package bastian.prueba2.views.main;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import bastian.prueba2.R;
import bastian.prueba2.models.Pending;
import bastian.prueba2.views.main.pendingList.PendingListFragment;

public class MainActivity extends AppCompatActivity implements CreateCallback{

    private Dialog dialog;
    private PendingListFragment pendingListFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        pendingListFragment = (PendingListFragment) getSupportFragmentManager().findFragmentById(R.id.pendingListFragment);

        setDialog();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText pendingImput = (EditText) dialog.findViewById(R.id.pendingEt);
                pendingImput.setText("");
                dialog.show();
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.showSoftInput(getCurrentFocus(), InputMethodManager.SHOW_FORCED);

            }
        });

    }

    private void setDialog() {
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_create_pending);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

        final EditText pendingImput = (EditText) dialog.findViewById(R.id.pendingEt);

        ImageButton saveBtn = (ImageButton) dialog.findViewById(R.id.saveBtn);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pendingName = pendingImput.getText().toString();
                createPending(pendingName);
            }
        });

        pendingImput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_NEXT || actionId == EditorInfo.IME_ACTION_DONE) {
                    return true;
                }
                return false;
            }
        });
    }

    private void createPending (String name){
        PendingValidation pendingValidation = new PendingValidation(this);
        pendingValidation.init(name);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, 0);
        dialog.dismiss();
    }


    @Override
    public void succes(Pending pending) {
        pendingListFragment.addPending(pending);
    }

    @Override
    public void fail() {
        Toast.makeText(this, "Agrega un Contacto", Toast.LENGTH_SHORT).show();

    }
}
