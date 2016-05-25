package com.example.amazon.communicationbetweenfragment;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity implements DatePicker.OnDateChangedListener, View.OnClickListener, Place_Dialog1.Callback, From_Dialog.Callback,
Place_Dialog2.Callback,Place_Dialog3.Callback{
    Calendar c;
    int month, day, year, hour, minute;
    TextView from, place1, time1, place2, time2, place3, time3;
    TextView weather1;
    public String fromTimezone = "";
    public String toTimezone1 = "";
    public String toTimezone2 = "";
    public String toTimezone3 = "";

    ImageView from_search;

    public String[] listitems = {"America/Edmonton", "America/Los_Angeles", "America/Mexico_City", "America/New_York", "America/Toronto", "America/Winnipeg", "Asia/Bangkok", "Asia/Harbin", "Asia/Hong_Kong",
            "Asia/Macao", "Asia/Shanghai", "Asia/Singapore", "Asia/Taipei", "Asia/Tokyo", "Australia/Sydney", "Canada/Eastern", "Canada/Pacific", "Europe/Berlin", "Europe/Moscow", "Europe/Paris", "Europe/Rome",
            "US/Pacific"};

//    SimpleDateFormat format=new SimpleDateFormat("EEEE, MMMM d, yyyy 'at' h:mm a");;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        //from
        from = (TextView) findViewById(R.id.from);
        from.setOnClickListener(this);
//        from_search= (ImageView) findViewById(R.id.from_search);
//        from_search.setOnClickListener(this);


        place1 = (TextView) findViewById(R.id.place1);
        place1.setOnClickListener(this);
        time1 = (TextView) findViewById(R.id.time1);

        place2 = (TextView) findViewById(R.id.place2);
        place2.setOnClickListener(this);
        time2 = (TextView) findViewById(R.id.time2);

        place3 = (TextView) findViewById(R.id.place3);
        place3.setOnClickListener(this);
        time3 = (TextView) findViewById(R.id.time3);

        weather1= (TextView) findViewById(R.id.weather1);
        weather1.setOnClickListener(this);


        DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);


        month = datePicker.getMonth();
        day = datePicker.getDayOfMonth();
        year = datePicker.getYear();
        TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker);
        hour = timePicker.getCurrentHour();
        minute = timePicker.getCurrentMinute();
        c = Calendar.getInstance();
        c.set(year, month, day, hour, minute);
        datePicker.init(year, month, day, this);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                hour = hourOfDay;
                MainActivity.this.minute = minute;
                c.set(year, month, day, hour, MainActivity.this.minute);
                if (fromTimezone.equals("")) {
                    c.setTimeZone(TimeZone.getDefault());
                } else {
                    c.setTimeZone(TimeZone.getTimeZone(fromTimezone));
                }

                //chunk1
                SimpleDateFormat format1 = new SimpleDateFormat("EEEE, MMMM d, yyyy 'at' h:mm a");
                if (toTimezone1.equals("")) {
                    format1.setTimeZone(TimeZone.getDefault());
                } else {
                    format1.setTimeZone(TimeZone.getTimeZone(toTimezone1));
                }
                time1.setText(format1.format(c.getTime()));
                //chunk2
                SimpleDateFormat format2 = new SimpleDateFormat("EEEE, MMMM d, yyyy 'at' h:mm a");
                if (toTimezone2.equals("")) {
                    format2.setTimeZone(TimeZone.getDefault());
                } else {
                    format2.setTimeZone(TimeZone.getTimeZone(toTimezone2));
                }
                time2.setText(format2.format(c.getTime()));
                //chunk3
                SimpleDateFormat format3 = new SimpleDateFormat("EEEE, MMMM d, yyyy 'at' h:mm a");
                if (toTimezone3.equals("")) {
                    format3.setTimeZone(TimeZone.getDefault());
                } else {
                    format3.setTimeZone(TimeZone.getTimeZone(toTimezone3));
                }
                time3.setText(format3.format(c.getTime()));

            }
        });

    }


    @Override
    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        month = monthOfYear;
        day = dayOfMonth;
        this.year = year;


        c.set(this.year, month, day, hour, minute);
        if (fromTimezone.equals("")) {
            c.setTimeZone(TimeZone.getDefault());
        } else {
            c.setTimeZone(TimeZone.getTimeZone(fromTimezone));
        }
        //chunk1
        SimpleDateFormat format1 = new SimpleDateFormat("EEEE, MMMM d, yyyy 'at' h:mm a");
        if (toTimezone1.equals("")) {
            format1.setTimeZone(TimeZone.getDefault());
        } else {
            format1.setTimeZone(TimeZone.getTimeZone(toTimezone1));
        }
        time1.setText(format1.format(c.getTime()));
        //chunk2
        SimpleDateFormat format2 = new SimpleDateFormat("EEEE, MMMM d, yyyy 'at' h:mm a");
        if (toTimezone2.equals("")) {
            format2.setTimeZone(TimeZone.getDefault());
        } else {
            format2.setTimeZone(TimeZone.getTimeZone(toTimezone2));
        }
        time2.setText(format2.format(c.getTime()));
        //chunk3
        SimpleDateFormat format3 = new SimpleDateFormat("EEEE, MMMM d, yyyy 'at' h:mm a");
        if (toTimezone3.equals("")) {
            format3.setTimeZone(TimeZone.getDefault());
        } else {
            format3.setTimeZone(TimeZone.getTimeZone(toTimezone3));
        }
        time3.setText(format3.format(c.getTime()));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.from: {
                From_Dialog from_dialog = new From_Dialog();
                from_dialog.show(getSupportFragmentManager(), "from_dialog");
                break;
            }
            case R.id.place1: {
                Place_Dialog1 place_dialog1 = new Place_Dialog1();
                place_dialog1.show(getSupportFragmentManager(), "place_dialog1");
                break;
            }
            case R.id.place2:{
                Place_Dialog2 place_dialog2 = new Place_Dialog2();
                place_dialog2.show(getSupportFragmentManager(), "place_dialog2");
                break;
            }
            case R.id.place3:{
                Place_Dialog3 place_dialog3 = new Place_Dialog3();
                place_dialog3.show(getSupportFragmentManager(), "place_dialog2");
                break;
            }
            case R.id.from_search:{
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                From_Search_Fragment from_search_fragment=new From_Search_Fragment();
                fragmentTransaction.add(R.id.fragment_container,from_search_fragment,"from_search_fragment");
                fragmentTransaction.addToBackStack("FromSearchStack");
                fragmentTransaction.commitAllowingStateLoss();
                break;
            }

            case R.id.weather1:{
                if(!toTimezone1.equals("")) {
                    Uri uri = Uri.parse("http://www.google.com/#q=" + toTimezone1 + "+weather");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(this,"please input place first",Toast.LENGTH_SHORT).show();
                }
                break;
            }



        }
    }

    @Override
     public void setToTimezone1(String timezone) {
        place1.setText(timezone);
        c.set(this.year, month, day, hour, minute);
        if (fromTimezone.equals("")) {
            c.setTimeZone(TimeZone.getDefault());
        } else {
            c.setTimeZone(TimeZone.getTimeZone(fromTimezone));
        }
        //chunk1
        SimpleDateFormat format = new SimpleDateFormat("EEEE, MMMM d, yyyy 'at' h:mm a");
        format.setTimeZone(TimeZone.getTimeZone(toTimezone1));
        time1.setText(format.format(c.getTime()));

    }
    @Override
    public void setToTimezone2(String timezone) {
        place2.setText(timezone);
        c.set(this.year, month, day, hour, minute);
        if (fromTimezone.equals("")) {
            c.setTimeZone(TimeZone.getDefault());
        } else {
            c.setTimeZone(TimeZone.getTimeZone(fromTimezone));
        }
        //chunk1
        SimpleDateFormat format = new SimpleDateFormat("EEEE, MMMM d, yyyy 'at' h:mm a");
        format.setTimeZone(TimeZone.getTimeZone(toTimezone2));
        time2.setText(format.format(c.getTime()));

    }

    @Override
    public void setToTimezone3(String timezone) {
        place3.setText(timezone);
        c.set(this.year, month, day, hour, minute);
        if (fromTimezone.equals("")) {
            c.setTimeZone(TimeZone.getDefault());
        } else {
            c.setTimeZone(TimeZone.getTimeZone(fromTimezone));
        }
        //chunk1
        SimpleDateFormat format = new SimpleDateFormat("EEEE, MMMM d, yyyy 'at' h:mm a");
        format.setTimeZone(TimeZone.getTimeZone(toTimezone3));
        time3.setText(format.format(c.getTime()));

    }

    @Override
    public void setFromTimezone(String timezone) {
        from.setText(timezone);
        c.set(this.year, month, day, hour, minute);
        c.setTimeZone(TimeZone.getTimeZone(fromTimezone));
        //chunk1
        SimpleDateFormat format1 = new SimpleDateFormat("EEEE, MMMM d, yyyy 'at' h:mm a");
        if (toTimezone1.equals("")) {
            format1.setTimeZone(TimeZone.getDefault());
        } else {
            format1.setTimeZone(TimeZone.getTimeZone(toTimezone1));
        }
        time1.setText(format1.format(c.getTime()));
        //chunk2
        SimpleDateFormat format2 = new SimpleDateFormat("EEEE, MMMM d, yyyy 'at' h:mm a");
        if (toTimezone2.equals("")) {
            format2.setTimeZone(TimeZone.getDefault());
        } else {
            format2.setTimeZone(TimeZone.getTimeZone(toTimezone2));
        }
        time2.setText(format2.format(c.getTime()));
        //chunk3
        SimpleDateFormat format3 = new SimpleDateFormat("EEEE, MMMM d, yyyy 'at' h:mm a");
        if (toTimezone3.equals("")) {
            format3.setTimeZone(TimeZone.getDefault());
        } else {
            format3.setTimeZone(TimeZone.getTimeZone(toTimezone3));
        }
        time3.setText(format3.format(c.getTime()));

    }
}
