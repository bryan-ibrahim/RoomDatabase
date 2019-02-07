package rassy.com.roomdatabasepractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void addUser(View view) {
        startActivity(new Intent(MainActivity.this,AddUserActivity.class));
    }

    public void viewUsers(View view) {
        startActivity(new Intent(MainActivity.this,ViewUsersActivity.class));
    }

    public void updateUser(View view) {
        startActivity(new Intent(MainActivity.this,UpdateUserActivity.class));
    }

    public void deleteUser(View view) {
        startActivity(new Intent(MainActivity.this,DeleteUserActivity.class));
    }
}
