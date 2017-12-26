package com.example.mthiaw.dateandtimepicker;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import static java.util.Calendar.AM;
import static java.util.Calendar.PM;

public class MainActivity extends AppCompatActivity {

    //declare the objects
    private EditText editTextDate;
    private EditText editTextTime;
    private EditText editTextEnter;
    private TextView textView;
    private Button button;
    private DatePickerDialog datePickerDialog; //This is the diaolog box to choose the date from
    private TimePickerDialog timePickerDialog; //This is the dialog box to choose the time from


    //The main activity OnCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Find the view of the buttonID then create an button OnClickListener
        button = (Button) findViewById(R.id.button_ID);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Find the textView_ID and the ediText_enter_ID
                textView = (TextView) findViewById(R.id.textView_ID);
                editTextEnter = (EditText) findViewById(R.id.editText_enter_ID);

                //place what's enter inside the editTextEnter into the textView
                textView.setText(editTextEnter.getText());


            }
        });


        /**
         *
         * The below is where we create the OnDateSetListener to pop the dialog calendar using the datePickerDialog
         * and the OnClickListener to have the ability to click on the editTextDate to pop the calendar
         */


        //Create a new OnDateSetListener
        DatePickerDialog.OnDateSetListener datePickerDialogOnDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                editTextDate = (EditText) findViewById(R.id.date_ID);
                editTextDate.setText(month + "-" + dayOfMonth + "-" + dayOfMonth);
            }
        };

        //This is very needed. It allows to set a start date for the dialog calendar. It comes right after declaring the OnDateSetListener
        datePickerDialog = new DatePickerDialog(this, datePickerDialogOnDateSetListener, 2017, 10, 26);

        //find the editTextDate
        editTextDate = (EditText) findViewById(R.id.date_ID);
        //Create the OnClickListener on the editTextDate
        editTextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //The only method we need here is to show the calendar when the editTextDate is clicked on
                datePickerDialog.show();
            }
        });




        /**
         *
         * The below is where we create the OnTimeSetListener to pop the dialog Time using the timePickerDialog
         * and the OnClickListener to have the ability to click on the editTextTime to pop the Time
         */

         //Create the OnTimeSetListener on new object timePickerDialogOnTimeSetListener
        TimePickerDialog.OnTimeSetListener timePickerDialogOnTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minute) {

                editTextTime = (EditText) findViewById(R.id.time_ID);
                editTextTime.setText(hour + ":" + minute);

            }
        };

        //This is very needed. It allows to set a start time for the dialog TIME. It comes right after declaring the OnTimeSetListener
        timePickerDialog = new TimePickerDialog(this,timePickerDialogOnTimeSetListener,8,00, DateFormat.is24HourFormat(this));


        editTextTime = (EditText) findViewById(R.id.time_ID);

        editTextTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //The only method we need here is to show the time when the editTextTime is clicked on
                timePickerDialog.show();
            }
        });




    }

}
