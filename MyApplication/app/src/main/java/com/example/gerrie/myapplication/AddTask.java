package com.example.gerrie.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
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

public class AddTask extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {


    TaskDBHelper mydb;
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
        setContentView(R.layout.task_add_new);

        mydb = new TaskDBHelper(getApplicationContext());
        intent = getIntent();
        isUpdate = intent.getBooleanExtra("isUpdate", false);

        dateFinal = todayDateString();

        Date your_date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(your_date);
        startYear = cal.get(Calendar.YEAR);
        startMonth = cal.get(Calendar.MONTH);
        startDay = cal.get(Calendar.DAY_OF_MONTH);

        if (isUpdate) {
            init_update();
        }

        EditText task_name = (EditText) findViewById(R.id.task_name1);
        if (!new3.ToDo_event_task_name.equals("")){
            task_name.setText(new3.ToDo_event_task_name);
            new3.ToDo_event_task_name="";
        }
        if (!Details_of_places_near_by.ToDo_event_task_name_near_by.equals("")){
            task_name.setText(Details_of_places_near_by.ToDo_event_task_name_near_by);
            Details_of_places_near_by.ToDo_event_task_name_near_by="";
        }
        if (!Details_of_places_jaffna.ToDo_event_task_name_jaffna.equals("")){
            task_name.setText(Details_of_places_jaffna.ToDo_event_task_name_jaffna);
            Details_of_places_jaffna.ToDo_event_task_name_jaffna="";
        }
        if (!Details_of_places_anuradhapura.ToDo_event_task_name_anuradhapura.equals("")){
            task_name.setText(Details_of_places_anuradhapura.ToDo_event_task_name_anuradhapura);
            Details_of_places_anuradhapura.ToDo_event_task_name_anuradhapura="";
        }
        if (!Details_of_places_kandy.ToDo_event_task_name_kandy.equals("")){
            task_name.setText(Details_of_places_kandy.ToDo_event_task_name_kandy);
            Details_of_places_kandy.ToDo_event_task_name_kandy="";
        }
        if (!Details_of_places_galle.ToDo_event_task_name_galle.equals("")){
            task_name.setText(Details_of_places_galle.ToDo_event_task_name_galle);
            Details_of_places_galle.ToDo_event_task_name_galle="";
        }
        if (!Details_of_places_main.ToDo_event_task_name_main.equals("")){
            task_name.setText(Details_of_places_main.ToDo_event_task_name_main);
            Details_of_places_main.ToDo_event_task_name_main="";
        }

    }


    public void init_update() {
        id = intent.getStringExtra("id");
        TextView toolbar_task_add_title = (TextView) findViewById(R.id.toolbar_task_add_title);
        EditText task_name = (EditText) findViewById(R.id.task_name);
        EditText task_date = (EditText) findViewById(R.id.task_date);
        toolbar_task_add_title.setText("Update");
        Cursor task = mydb.getDataSpecific(id);
        if (task != null) {
            task.moveToFirst();

            task_name.setText(task.getString(1).toString());
            Calendar cal = Function.Epoch2Calender(task.getString(2).toString());
            startYear = cal.get(Calendar.YEAR);
            startMonth = cal.get(Calendar.MONTH);
            startDay = cal.get(Calendar.DAY_OF_MONTH);
            task_date.setText(Function.Epoch2DateString(task.getString(2).toString(), "dd/MM/yyyy"));

        }

    }

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
        EditText task_name = (EditText) findViewById(R.id.task_name1);
        EditText task_date = (EditText) findViewById(R.id.task_date);
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
                    mydb.updateContact(id, nameFinal, dateFinal);
                    Toast.makeText(getApplicationContext(), "Task Updated", Toast.LENGTH_LONG).show();
                } else {
                    mydb.insertContact(nameFinal, dateFinal);
                    Toast.makeText(getApplicationContext(), "Task Added", Toast.LENGTH_LONG).show();
                }

                finish();
            } else {
                Toast.makeText(getApplicationContext(), "Try again", Toast.LENGTH_LONG).show();
            }
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        dpd = (DatePickerDialog) getFragmentManager().findFragmentByTag("startDatepickerdialog");
        if (dpd != null) dpd.setOnDateSetListener(this);
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        startYear = year;
        startMonth = monthOfYear;
        startDay = dayOfMonth;
        int monthAddOne = startMonth + 1;
        String date = (startDay < 10 ? "0" + startDay : "" + startDay) + "/" +
                (monthAddOne < 10 ? "0" + monthAddOne : "" + monthAddOne) + "/" +
                startYear;
        EditText task_date = (EditText) findViewById(R.id.task_date);
        task_date.setText(date);
    }



    public void showStartDatePicker(View v) {
        dpd = DatePickerDialog.newInstance(AddTask.this, startYear, startMonth, startDay);
        dpd.setOnDateSetListener(this);
        dpd.show(getFragmentManager(), "startDatepickerdialog");
    }

}