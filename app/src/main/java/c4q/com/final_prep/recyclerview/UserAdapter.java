package c4q.com.final_prep.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import java.util.zip.Inflater;

import c4q.com.final_prep.R;
import c4q.com.final_prep.modelclasses.User;

/**
 * Created by D on 2/18/18.
 */

public class UserAdapter extends RecyclerView.Adapter<Holder> {

    List<User> userList;

    // creates a list of the objects coming in from the URl. that are in the user class
    public UserAdapter(List<User> userList) {
        this.userList = userList;
    }

    //inflates the layout
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_items_layout,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

        User user = userList.get(position);
        holder.onbind(user);

    }

    //gets size of recyclerview
    @Override
    public int getItemCount() {
        return userList.size();
    }
}
