package rassy.com.roomdatabasepractice.room_db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {UserEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

//    private static AppDatabase instance;

    public abstract UserDao userDao();

    /*public static synchronized AppDatabase getInstance(Context context){

        if(instance!=null){
            instance = Room.databaseBuilder(context,AppDatabase.class,"user_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return instance;
    }*/
}
