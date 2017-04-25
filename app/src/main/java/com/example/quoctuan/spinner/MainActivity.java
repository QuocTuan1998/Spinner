 package com.example.quoctuan.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quoctuan.spinner.adapter.EmployeeAdapter;
import com.example.quoctuan.spinner.model.Employee;

import java.util.ArrayList;

 public class MainActivity extends AppCompatActivity {

     EditText txtName,txtDay;
     Button btnConfirm;
     Spinner spDay;
     ArrayList<String> listDay;
     ArrayAdapter<String> adapterDay;
     int lastSelected=-1;//chưa chọn lựa gì cả
     ListView lvEmployee;
     ArrayList<Employee> listEmployee;
     EmployeeAdapter employeeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        addControls();
        addEvents();
    }

     private void addEvents() {
         btnConfirm.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 handleComfirm();
             }
         });

         spDay.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                 Toast.makeText(MainActivity.this,
                         "Bạn chọn "+listDay.get(position),
                         Toast.LENGTH_SHORT).show();
                 lastSelected=position;//đánh dấu vị trí người dùng chọn
             }

             @Override
             public void onNothingSelected(AdapterView<?> parent) {

             }
         });
     }

     private void handleComfirm() {

        if (lastSelected==-1){
            Toast.makeText(MainActivity.this,"Bạn chưa chọn thứ ",Toast.LENGTH_SHORT).show();
            return;
        }
         Employee em=new Employee();
         em.setName(txtName.getText().toString());
         em.setDayStart(listDay.get(lastSelected));
         em.setDayNumber(Integer.parseInt(txtDay.getText().toString()));
         Toast.makeText(
                 MainActivity.this,
                 em.toString(),
                 Toast.LENGTH_SHORT).show();
         String name=txtName.getText().toString();
         listDay.add(name);
         employeeAdapter.notifyDataSetChanged();
         txtName.setText("");
         txtName.requestFocus();

     }

     private void addControls() {

         txtName= (EditText) findViewById(R.id.txtName);
         txtDay= (EditText) findViewById(R.id.txtDay);
         btnConfirm= (Button) findViewById(R.id.btnConfirm);
         ListView lvEmployee= (ListView) findViewById(R.id.lvEmployee);
         TextView txtLvName= (TextView) findViewById(R.id.txtLvName);
         TextView txtLvDay= (TextView) findViewById(R.id.txtLvDay);
         TextView txtLvExDay= (TextView) findViewById(R.id.txtLvExDay);

         spDay= (Spinner) findViewById(R.id.spDay);
         listDay=new ArrayList<>();
         listDay.add("Thứ 2");listDay.add("Thứ 3");listDay.add("Thứ 4");
         listDay.add("Thứ 5");listDay.add("Thứ 6");listDay.add("Thứ 7");listDay.add("Thứ 8");
         adapterDay=new ArrayAdapter<String>(
                 MainActivity.this,
                 android.R.layout.simple_spinner_item,
                 listDay);
         adapterDay.setDropDownViewResource(
                 android.R.layout.simple_spinner_dropdown_item);
         spDay.setAdapter(adapterDay);

         listEmployee=new ArrayList<>();
         employeeAdapter=new EmployeeAdapter(MainActivity.this,
                 R.layout.item,
                 listEmployee);
         lvEmployee.setAdapter(employeeAdapter);

     }
 }
