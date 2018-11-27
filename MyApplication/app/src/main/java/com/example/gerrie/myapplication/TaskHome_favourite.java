package com.example.gerrie.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by Ferdousur Rahman Sarker on 3/16/2018.
 */

public class TaskHome_favourite extends AppCompatActivity {

    Activity activity;
    TaskDBHelper_favourite mydb;
    NoScrollListView_favourite taskListToday, taskListTomorrow, taskListUpcoming;
    NestedScrollView scrollView;
    ProgressBar loader;
    TextView todayText,tomorrowText,upcomingText;
    ArrayList<HashMap<String, String>> todayList = new ArrayList<HashMap<String, String>>();
    ArrayList<HashMap<String, String>> tomorrowList = new ArrayList<HashMap<String, String>>();
    ArrayList<HashMap<String, String>> upcomingList = new ArrayList<HashMap<String, String>>();

    private android.support.v7.widget.CardView cardView_today;
    private android.support.v7.widget.CardView cardView_tomorrow;
    private android.support.v7.widget.CardView cardView_next;

    public static String KEY_ID = "id";
    public static String KEY_TASK = "task";
    public static String KEY_DATE = "date";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_home_favourite);

        activity = TaskHome_favourite.this;
        mydb = new TaskDBHelper_favourite(activity);
        scrollView = (NestedScrollView) findViewById(R.id.scrollView_favourite);
        loader = (ProgressBar) findViewById(R.id.loader_favourite);
        taskListToday = (NoScrollListView_favourite) findViewById(R.id.taskListToday_favourite);
        taskListTomorrow = (NoScrollListView_favourite) findViewById(R.id.taskListTomorrow_favourite);
        taskListUpcoming = (NoScrollListView_favourite) findViewById(R.id.taskListUpcoming_favourite);

        todayText = (TextView) findViewById(R.id.todayText_favourite);
        tomorrowText = (TextView) findViewById(R.id.tomorrowText_favourite);
        //upcomingText = (TextView) findViewById(R.id.upcomingText_favourite);

        cardView_today = (android.support.v7.widget.CardView) findViewById(R.id.today_cardview_favourite);
        cardView_tomorrow = (android.support.v7.widget.CardView) findViewById(R.id.tomorrow_cardview_favourite);
        cardView_next = (android.support.v7.widget.CardView) findViewById(R.id.next_cardview_favourite);
    }


    /*public void openAddTask(View v)
    {
        Intent i = new Intent(this, AddTask_favourite.class);
        startActivity(i);
    }*/

    public void populateData()
    {
        mydb = new TaskDBHelper_favourite(activity);
        scrollView.setVisibility(View.GONE);
        loader.setVisibility(View.VISIBLE);

        LoadTask loadTask = new LoadTask();
        loadTask.execute();
    }

    @Override
    public void onResume() {
        super.onResume();

        populateData();

    }





    class LoadTask extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            todayList.clear();
            tomorrowList.clear();
            upcomingList.clear();
        }

        protected String doInBackground(String... args) {
            String xml = "";

            /* ===== TODAY ========*/
            Cursor today = mydb.getDataToday();
            loadDataList(today, todayList);
            /* ===== TODAY ========*/

            /* ===== TOMORROW ========*/
            Cursor tomorrow = mydb.getDataTomorrow();
            loadDataList(tomorrow, tomorrowList);
            /* ===== TOMORROW ========*/

            /* ===== UPCOMING ========*/
            Cursor upcoming = mydb.getDataUpcoming();
            loadDataList(upcoming, upcomingList);
            /* ===== UPCOMING ========*/

            return xml;
        }

        @Override
        protected void onPostExecute(String xml) {


            loadListView(taskListToday,todayList);
            loadListView(taskListTomorrow,tomorrowList);
            loadListView(taskListUpcoming,upcomingList);


            if(todayList.size()>0)
            {
                todayText.setVisibility(View.VISIBLE);
                cardView_today.setVisibility(View.VISIBLE);
            }else{
                todayText.setVisibility(View.INVISIBLE);
                cardView_today.setVisibility(View.INVISIBLE);
            }

            if(tomorrowList.size()>0)
            {
                tomorrowText.setVisibility(View.VISIBLE);
                cardView_tomorrow.setVisibility(View.VISIBLE);
            }else{
                tomorrowText.setVisibility(View.INVISIBLE);
                cardView_tomorrow.setVisibility(View.INVISIBLE);
            }

            if(upcomingList.size()>0)
            {
//              upcomingText.setVisibility(View.VISIBLE);
                cardView_next.setVisibility(View.VISIBLE);
            }else{
//                upcomingText.setVisibility(View.INVISIBLE);
                cardView_next.setVisibility(View.INVISIBLE);
            }


            loader.setVisibility(View.INVISIBLE);
            scrollView.setVisibility(View.VISIBLE);
        }
    }



    public void loadDataList(Cursor cursor, ArrayList<HashMap<String, String>> dataList)
    {
        if(cursor!=null ) {
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false) {

                HashMap<String, String> mapToday = new HashMap<String, String>();
                mapToday.put(KEY_ID, cursor.getString(0).toString());
                mapToday.put(KEY_TASK, cursor.getString(1).toString());
                mapToday.put(KEY_DATE, Function_favourite.Epoch2DateString(cursor.getString(2).toString(), "dd-MM-yyyy"));
                dataList.add(mapToday);
                cursor.moveToNext();
            }
        }
    }


    public void loadListView(ListView listView, final ArrayList<HashMap<String, String>> dataList)
    {
        ListTaskAdapter_favourite adapter = new ListTaskAdapter_favourite(activity, dataList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                /*Intent i = new Intent(activity, AddTask_favourite.class);
                i.putExtra("isUpdate", true);
                i.putExtra("id", dataList.get(+position).get(KEY_ID));
                startActivity(i);*/
            }
        });
    }
}
