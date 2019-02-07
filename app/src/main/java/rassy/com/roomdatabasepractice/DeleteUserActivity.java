package rassy.com.roomdatabasepractice;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import rassy.com.roomdatabasepractice.room_db.AppDatabase;
import rassy.com.roomdatabasepractice.room_db.UserEntity;

public class DeleteUserActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_user);
    }

    public void deleteUser(View view) {
        EditText etIdToDelete = findViewById(R.id.etIdToDelete);
        Integer IdToDelete = Integer.parseInt(etIdToDelete.getText().toString());

        UserEntity userEntity = new UserEntity();
        userEntity.setId(IdToDelete);

        AppDatabase appDatabase = Room.databaseBuilder(this,AppDatabase.class,"user_database")
                .allowMainThreadQueries()
                .build();

        appDatabase.userDao().deleteUser(userEntity);
        Toast.makeText(this, "User deleted successfully", Toast.LENGTH_SHORT).show();
    }
}
