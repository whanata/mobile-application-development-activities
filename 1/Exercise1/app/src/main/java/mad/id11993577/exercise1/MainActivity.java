package mad.id11993577.exercise1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.app.DatePickerDialog;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String firstName, lastName, gender;
    private int age;
    private Calendar calendarDate = Calendar.getInstance();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            calendarDate.set(arg1, arg2, arg3);
            TextView dateOfBirth = (TextView) findViewById(R.id.editDate);
            dateOfBirth.setText(dateFormat.format(calendarDate.getTime()));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView dateOfBirth = (TextView) findViewById(R.id.editDate);
        dateOfBirth.setText(dateFormat.format(calendarDate.getTime()));
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.submit);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    public void submitInfo(View v) {
        EditText inputFirstName = (EditText) findViewById(R.id.firstName);
        firstName = inputFirstName.getText().toString();
        EditText inputLastName = (EditText) findViewById(R.id.lastName);
        lastName = inputLastName.getText().toString();
        String dOB = dateFormat.format(calendarDate.getTime());
        String information = "Hi " + firstName + " " + lastName + ".";
        Snackbar.make(v, information, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    public void showDatePickerDialog(View v) {
        int year = calendarDate.get(Calendar.YEAR);
        int month = calendarDate.get(Calendar.MONTH);
        int day = calendarDate.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePicker = new DatePickerDialog(this, myDateListener, year, month, day);
        datePicker.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
