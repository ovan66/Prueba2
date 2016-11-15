package bastian.prueba2.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import bastian.prueba2.R;
import bastian.prueba2.data.PendingsData;
import bastian.prueba2.models.Pending;
import bastian.prueba2.views.main.pendingList.PendingListListener;

/**
 * Created by Bastian on 11-11-2016.
 */

public class PendingsAdapter extends RecyclerView.Adapter<PendingsAdapter.ViewHolder>{

    private List <Pending> pendings = new PendingsData().notDone();
    private PendingListListener listener;

    public PendingsAdapter(PendingListListener listener) {
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_pending, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Pending pending = pendings.get(position);
        holder.name.setText(pending.getName());
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.click(pending.getId());
            }
        });

    }

    @Override
    public int getItemCount() {
        return pendings.size();
    }
    public void add(Pending pending) {
        pendings.add(0,pending);
        notifyDataSetChanged();
    }

    public void search(String name){
        List<Pending> pendingsList = new PendingsData(). byName(name);
        pendings.clear();
        pendings.addAll(pendingsList);
        notifyDataSetChanged();

    }
    public void reset(){
        pendings.clear();;
        List<Pending> pendingList= new PendingsData().notDone();
        pendings.addAll(pendingList);
        notifyDataSetChanged();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        CheckBox status;

        ViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.nameTv);
            status = (CheckBox) view.findViewById(R.id.pendingCb);
        }

    }
}
