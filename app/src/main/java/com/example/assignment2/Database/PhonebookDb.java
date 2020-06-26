package com.example.assignment2.Database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.assignment2.Dao.ContactDao;
import com.example.assignment2.Model.Contact;
@Database(
        entities = {Contact.class},
        version = 1,
        exportSchema = false
)
public abstract class PhonebookDb extends RoomDatabase{

    private final String TAG = this.getClass().getSimpleName();

    public abstract ContactDao contactDao();

    private static PhonebookDb phonebookDb;

    public static PhonebookDb getInstance(final Context context)
    {
        if(phonebookDb == null) //If holmesglenDb does not exist, create the DB
        {
            phonebookDb = Room.databaseBuilder(
                    context.getApplicationContext(),
                    PhonebookDb.class,
                    "phonebook_room.db"
            ).allowMainThreadQueries().build();
        }
        return  phonebookDb;
    }

    public static int initData(final Context context){
        PhonebookDb db = getInstance(context);
        if(db.contactDao().getAllContacts().size() == 0) {
            db.contactDao().insert(
        new Contact("a Kakeru", "urgex@gmail.com", "123 456 789","01/01/2000"),
        new Contact("b Kakeru", "urgex@gmail.com", "123 456 789","01/01/2000"),
        new Contact("c Kakeru", "urgex@gmail.com", "123 456 789","01/01/2000"),
        new Contact("d Kakeru", "urgex@gmail.com", "123 456 789","01/01/2000"),
        new Contact("e Kakeru", "urgex@gmail.com", "123 456 789","01/01/2000"),
        new Contact("f Kakeru", "urgex@gmail.com", "123 456 789","01/01/2000"),
        new Contact("g Kakeru", "urgex@gmail.com", "123 456 789","01/01/2000"),
        new Contact("h Kakeru", "urgex@gmail.com", "123 456 789","01/01/2000"),
        new Contact("i Kakeru", "urgex@gmail.com", "123 456 789","01/01/2000"),
        new Contact("j Kakeru", "urgex@gmail.com", "123 456 789","01/01/2000"),
        new Contact("k Kakeru", "urgex@gmail.com", "123 456 789","01/01/2000")


            );
        }
        return db.contactDao().getAllContacts().size();
    }
}

