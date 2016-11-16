package bastian.prueba2.views.main.pendingList;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bastian.prueba2.R;
import bastian.prueba2.adapters.PendingsAdapter;
import bastian.prueba2.models.Pending;
import bastian.prueba2.views.details.DetailsActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class PendingListFragment extends Fragment implements PendingListListener{

    public static final String PENDING_ID = "PENDING_ID";

    private PendingsAdapter pendingsAdapter;

    public PendingListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pending_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.pendingRv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        pendingsAdapter = new PendingsAdapter(this);
        recyclerView.setAdapter(pendingsAdapter);
        final SwipeRefreshLayout refreshLayout = (SwipeRefreshLayout) view;
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pendingsAdapter.reset();
                        refreshLayout.setRefreshing(false);

                    }
                },800);

            }
        });
    }

    public void addPending(Pending pending){
        pendingsAdapter.add(pending);

    }

    public void day() {
        pendingsAdapter.day();
    }

    public void night() {
        pendingsAdapter.night();
    }

    @Override
    public void click(long id) {
        Intent intent = new Intent(getActivity(), DetailsActivity.class);
        intent.putExtra(PENDING_ID,id);
        startActivity(intent);

    }

}