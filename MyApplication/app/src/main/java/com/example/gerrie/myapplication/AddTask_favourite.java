package com.example.gerrie.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Ferdousur Rahman Sarker on 3/17/2018.
 */

public class AddTask_favourite extends AppCompatActivity{



    DatePickerDialog dpd;
    int startYear = 0, startMonth = 0, startDay = 0;
    String dateFinal;
    String nameFinal;

    String dateFinal_comparision;

    Intent intent;
    Boolean isUpdate;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.task_add_new_favourite);


        intent = getIntent();
        isUpdate = false;

        dateFinal = todayDateString();

        Date your_date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(your_date);
        startYear = cal.get(Calendar.YEAR);
        startMonth = cal.get(Calendar.MONTH);
        startDay = cal.get(Calendar.DAY_OF_MONTH);

       /* if (isUpdate) {
            init_update();
        }*/
    }


    /*public void init_update() {
        id = intent.getStringExtra("id");
        TextView toolbar_task_add_title = (TextView) findViewById(R.id.toolbar_task_add_title_favourite);
        EditText task_name = (EditText) findViewById(R.id.task_name_favourite);
        EditText task_date = (EditText) findViewById(R.id.task_date_favourite);
        toolbar_task_add_title.setText("Update");
        Cursor task = mydb_favourite.getDataSpecific(id);
        if (task != null) {
            task.moveToFirst();

            task_name.setText(task.getString(1).toString());
            Calendar cal = Function_favourite.Epoch2Calender(task.getString(2).toString());
            startYear = cal.get(Calendar.YEAR);
            startMonth = cal.get(Calendar.MONTH);
            startDay = cal.get(Calendar.DAY_OF_MONTH);
            task_date.setText(Function_favourite.Epoch2DateString(task.getString(2).toString(), "dd/MM/yyyy"));
        }

    }*/

    public String todayDateString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "dd/MM/yyyy", Locale.getDefault());

        return dateFormat.toString();
    }

    public void closeAddTask(View v) {
        finish();
    }


    public void doneAddTask(View v) {
        int errorStep = 0;
        EditText task_name = (EditText) findViewById(R.id.task_name_favourite);
        EditText task_date = (EditText) findViewById(R.id.task_date_favourite);
        nameFinal = task_name.getText().toString();
        dateFinal = task_date.getText().toString();
        if (!dateFinal.equals("")){
            dateFinal_comparision= Character.toString(dateFinal.charAt(6))+Character.toString(dateFinal.charAt(7))+Character.toString(dateFinal.charAt(8))+Character.toString(dateFinal.charAt(9))+Character.toString(dateFinal.charAt(3))+Character.toString(dateFinal.charAt(4))+Character.toString(dateFinal.charAt(0))+Character.toString(dateFinal.charAt(1));
        }else{
            dateFinal_comparision="99999999";
        }

  /* Checking */
        if (nameFinal.trim().length() < 1) {
            errorStep++;
            task_name.setError("Provide a task name");
        }

        if (dateFinal.trim().length() < 4) {
            errorStep++;
            task_date.setError("Provide a specific date");
        }

        String timeStamp = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());

        if (Integer.parseInt(timeStamp)>Integer.parseInt(dateFinal_comparision)){
            Toast.makeText(getApplicationContext(), "Please enter today or upcoming date", Toast.LENGTH_LONG).show();
        }else{
            if (errorStep == 0) {
                if (isUpdate) {
                    //mydb_favourite.updateContact(id, nameFinal, dateFinal);
                    //Toast.makeText(getApplicationContext(), "Task Updated", Toast.LENGTH_SHORT).show();
                } else {
                    //mydb_favourite.insertContact(nameFinal, dateFinal);
                    //Toast.makeText(getApplicationContext(), "Task Added", Toast.LENGTH_SHORT).show();
                }
                finish();
            } else {
                Toast.makeText(getApplicationContext(), "Try again", Toast.LENGTH_LONG).show();
            }
        }
    }
}