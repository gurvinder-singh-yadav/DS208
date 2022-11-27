package com.rodavid20.simplerecyclerviewdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.rodavid20.simplerecyclerviewdemo.datamodel.UserModel;

public class MainActivity extends AppCompatActivity {
    FirestoreRecyclerAdapter<UserModel, UserViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rvUserList = findViewById(R.id.rvUserList);
        rvUserList.setLayoutManager(new LinearLayoutManager(this));

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Query query = db.collection("users")
                .orderBy("name", Query.Direction.ASCENDING);

        FirestoreRecyclerOptions<UserModel> options =
                new FirestoreRecyclerOptions.Builder<UserModel>()
                        .setQuery(query, UserModel.class)
                        .build();

        adapter = new FirestoreRecyclerAdapter<UserModel, UserViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull UserViewHolder holder, int position, @NonNull UserModel model) {
                holder.setData(model.getName(), model.getPhone());
            }

            @NonNull
            @Override
            public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row, parent, false);
                return new UserViewHolder(view);
            }
        };
        rvUserList.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        private View view;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
        }

        public void setData(String title, String subtitle){
            TextView tvUserRowTitle = view.findViewById(R.id.tvUserRowTitle);
            tvUserRowTitle.setText(title);
            TextView tvUserRowSubTitle = view.findViewById(R.id.tvUserRowSubTitle);
            tvUserRowSubTitle.setText(subtitle);
        }
    }
}