package c4q.com.final_prep;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.zip.Inflater;

import c4q.com.final_prep.modelclasses.User;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {
    Bundle bundle;
        User newUser;
        ImageView detailImage;
        TextView detailname;
        TextView detailLoction;
        TextView detailDob;
        TextView detailEmail;
        TextView detailCell;

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bundle = getArguments();
        newUser = bundle.getParcelable("user");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail_,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setViews(view);
        onBind(newUser);
    }

    private void setViews(@NonNull View view) {
        detailImage = view.findViewById(R.id.detail_image);
        detailname = view.findViewById(R.id.detail_name);
        detailLoction=view.findViewById(R.id.detail_dob);
        detailDob = view.findViewById(R.id.detail_dob);
        detailEmail=view.findViewById(R.id.detail_email);
        detailCell = view.findViewById(R.id.detail_cell);
    }

    public void onBind(User userData){
        Picasso.with(getContext()).load(newUser.getPicture().getThumbnail())
                .resize(150,150).into(detailImage);
        detailname.setText(userData.getName().getFullName());
        detailLoction.setText(userData.getLocation().getCity());
        detailDob.setText(userData.getDob());
        detailEmail.setText(userData.getEmail());
        detailCell.setText(userData.getCell());

    }


}
