package bastian.prueba2.views.main.filter;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.List;

import bastian.prueba2.R;
import bastian.prueba2.data.PendingsData;

/**
 * A simple {@link Fragment} subclass.
 */
public class FiltersButtonsFragment extends Fragment {

    private FiltersButtonsCallback callback;
    private List<String> filter;


    public FiltersButtonsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callback = (FiltersButtonsCallback) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_filters_buttons, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final ImageButton dayBtn = (ImageButton) view.findViewById(R.id.dayBtn);

        dayBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                dayBtn.setPressed(true);
                return true;
            }
        });

        dayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.night();
            }
        });




        final ImageButton nightBtn = (ImageButton) view.findViewById(R.id.nightBtn);
        dayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.night();
            }
        });

        dayBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                nightBtn.setPressed(true);
                return true;

            }
        });


    }
}

