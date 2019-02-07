package rassy.com.roomdatabasepractice;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import rassy.com.roomdatabasepractice.adapters_and_helpers.RecyclerViewAdapter;
import rassy.com.roomdatabasepractice.room_db.AppDatabase;
import rassy.com.roomdatabasepractice.room_db.UserEntity;

public class ViewUsersActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_users);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        AppDatabase appDatabase = Room.databaseBuilder(this,AppDatabase.class,"user_database")
                .allowMainThreadQueries()
                .build();

        List<UserEntity> users = appDatabase.userDao().getUsers();
        /*for(UserEntity userEntity: users){
            userEntity.
        }*/
        adapter = new RecyclerViewAdapter(users);
        recyclerView.setAdapter(adapter);

    }
}
