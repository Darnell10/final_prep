package c4q.com.final_prep.recyclerview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import c4q.com.final_prep.DetailFragment;
import c4q.com.final_prep.MainFragment;
import c4q.com.final_prep.R;
import c4q.com.final_prep.modelclasses.User;

/**
 * Created by D on 2/18/18.
 */

public class Holder extends RecyclerView.ViewHolder{

    private ImageView thumbnail;
    private TextView  itemviewName;



    public Holder(View itemView) {
        super(itemView);

        thumbnail = itemView.findViewById(R.id.thumbnail);
        itemviewName=itemView.findViewById(R.id.itemview_name);
    }

    public void onbind(User user){
        final User thisuser = user;
        Picasso.with(itemView.getContext()).load(thisuser.getPicture().getThumbnail())
                .resize(300,300).into(thumbnail);
        itemviewName.setText(thisuser.getName().getFullName());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("user", thisuser);
                DetailFragment detailFragment = new DetailFragment();
                detailFragment.setArguments(bundle);
                FragmentManager fragmentManager = ((AppCompatActivity)itemView.getContext())
                        .getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment_container,detailFragment)
                        .addToBackStack("previous")
                        .commit();
            }
        });
    }


}
