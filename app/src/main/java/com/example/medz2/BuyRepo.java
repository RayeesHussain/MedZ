package com.example.medz2;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;

import java.util.List;

public class BuyRepo {

    // below line is the create a variable
    // for dao and list for all courses.
    private Buy_Dao dao;
    private LiveData<List<BuyModal>> allCourses;

    // creating a constructor for our variables
    // and passing the variables to it.
    public BuyRepo(Application application) {
        BuyDB database = BuyDB.getInstance(application);
        dao = database.Dao();
        allCourses = dao.getAllCourses();
    }

    // creating a method to insert the data to our database.
    public void insert(BuyModal model) {
        new InsertCourseAsyncTask(dao).execute(model);
    }

    // creating a method to update data in database.
    public void update(BuyModal model) {
        new UpdateCourseAsyncTask(dao).execute(model);
    }

    // creating a method to delete the data in our database.
    public void delete(BuyModal model) {
        new DeleteCourseAsyncTask(dao).execute(model);
    }

    // below is the method to delete all the courses.
    public void deleteAllCourses() {
        new DeleteAllCoursesAsyncTask(dao).execute();
    }

    // below method is to read all the courses.
    public LiveData<List<BuyModal>> getAllCourses() {
        return allCourses;
    }

    // we are creating a async task method to insert new course.
    private static class InsertCourseAsyncTask extends AsyncTask<BuyModal, Void, Void> {
        private Buy_Dao dao;

        private InsertCourseAsyncTask(Buy_Dao dao) {
            this.dao = dao;
        }



        @Override
        protected Void doInBackground(BuyModal... buyModals) {
            dao.insert(buyModals[0]);
            return null;

        }
    }

    // we are creating a async task method to update our course.
    private static class UpdateCourseAsyncTask extends AsyncTask<BuyModal, Void, Void> {
        private Buy_Dao dao;

        private UpdateCourseAsyncTask(Buy_Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(BuyModal... models) {
            // below line is use to update
            // our modal in dao.
            dao.update(models[0]);
            return null;
        }
    }

    // we are creating a async task method to delete course.
    private static class DeleteCourseAsyncTask extends AsyncTask<BuyModal, Void, Void> {
        private Buy_Dao dao;

        private DeleteCourseAsyncTask(Buy_Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(BuyModal... models) {
            // below line is use to delete
            // our course modal in dao.
            dao.delete(models[0]);
            return null;
        }
    }

    // we are creating a async task method to delete all courses.
    private static class DeleteAllCoursesAsyncTask extends AsyncTask<Void, Void, Void> {
        private Buy_Dao dao;
        private DeleteAllCoursesAsyncTask(Buy_Dao dao) {
            this.dao = dao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            // on below line calling method
            // to delete all courses.
            dao.deleteAllCourses();
            return null;
        }
    }
}
