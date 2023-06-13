package com.example.medz2;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@androidx.room.Dao

public interface Buy_Dao {
    @Insert
    void insert(BuyModal model);

    // below method is use to update
    // the data in our database.
    @Update
     void update(BuyModal model);

    // below line is use to delete a
    // specific course in our database.
    @Delete
    void delete(BuyModal model);

    // on below line we are making query to
    // delete all courses from our database.
    @Query("DELETE FROM course_table")
    void deleteAllCourses();

    // below line is to read all the courses from our database.
    // in this we are ordering our courses in ascending order
    // with our course name.
    @Query("SELECT * FROM course_table ORDER BY pillName ASC")
    LiveData<List<BuyModal>> getAllCourses();
}
