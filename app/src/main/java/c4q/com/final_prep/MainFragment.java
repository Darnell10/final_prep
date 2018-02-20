package c4q.com.final_prep;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import c4q.com.final_prep.modelclasses.Response;
import c4q.com.final_prep.modelclasses.User;
import c4q.com.final_prep.recyclerview.UserAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private UserService userService;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_frag_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // calls recyclerview layout
        recyclerView = view.findViewById(R.id.recyclerview);
        layoutManager = new GridLayoutManager(getContext(), 2);
        networkCall();


    }

    public void networkCall() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://randomuser.me/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        userService = retrofit.create(UserService.class);

        Call<Response> responseCall = userService.getUser();
        responseCall.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                Log.d(TAG, "onResponse: " + response.body().getUser().size());
                recycler(response.body().getUser());
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void recycler(ArrayList<User> userdata) {
        recyclerView.setLayoutManager(layoutManager);
        UserAdapter userAdapter = new UserAdapter(userdata);
        recyclerView.setAdapter(userAdapter);
    }
}
