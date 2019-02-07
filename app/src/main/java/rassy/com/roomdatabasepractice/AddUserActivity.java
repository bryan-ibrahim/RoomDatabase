package rassy.com.roomdatabasepractice;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import rassy.com.roomdatabasepractice.room_db.AppDatabase;
import rassy.com.roomdatabasepractice.room_db.UserEntity;

public class AddUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
    }

    public void addUser(View view) {
        EditText etFirstName = findViewById(R.id.etFirstName);
        EditText etLastName = findViewById(R.id.etLastName);
        EditText etEmail= findViewById(R.id.etEmail);

        String strFirstName = etFirstName.getText().toString();
        String strLastName = etLastName.getText().toString();
        String strEmail = etEmail.getText().toString();

        UserEntity user = new UserEntity();
        user.setFirstName(strFirstName);
        user.setLastName(strLastName);
        user.setEmailAddress(strEmail);

        AppDatabase appDatabase = Room.databaseBuilder(this,AppDatabase.class,"user_database")
                .allowMainThreadQueries()
                .build();

        appDatabase.userDao().addUser(user);
        Toast.makeText(this, "Successfully saved", Toast.LENGTH_SHORT).show();
    }
}
