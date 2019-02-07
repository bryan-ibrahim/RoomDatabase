package rassy.com.roomdatabasepractice;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import rassy.com.roomdatabasepractice.room_db.AppDatabase;
import rassy.com.roomdatabasepractice.room_db.UserEntity;

public class UpdateUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);
    }

    public void updateUser(View view) {
        EditText etId = findViewById(R.id.etIdToUpdate);
        EditText etFirstName = findViewById(R.id.etFirstNameUpdate);
        EditText etLastName = findViewById(R.id.etLastNameUpdate);
        EditText etEmail= findViewById(R.id.etEmailUpdate);

        Integer idToUpdate = Integer.parseInt(etId.getText().toString());
        String strFirstName = etFirstName.getText().toString();
        String strLastName = etLastName.getText().toString();
        String strEmail = etEmail.getText().toString();

        UserEntity user = new UserEntity();
        user.setId(idToUpdate);
        user.setFirstName(strFirstName);
        user.setLastName(strLastName);
        user.setEmailAddress(strEmail);

        AppDatabase appDatabase = Room.databaseBuilder(this,AppDatabase.class,"user_database")
                .allowMainThreadQueries()
                .build();

        appDatabase.userDao().updateUser(user);
        Toast.makeText(this, "Successfully updated", Toast.LENGTH_SHORT).show();
    }
}
