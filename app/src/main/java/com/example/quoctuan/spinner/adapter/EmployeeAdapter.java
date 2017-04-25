package com.example.quoctuan.spinner.adapter;


import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.quoctuan.spinner.R;
import com.example.quoctuan.spinner.model.Employee;

import java.io.Serializable;
import java.util.List;

public class EmployeeAdapter extends ArrayAdapter<Employee>{

    Activity context;
    int resource;
    List<Employee> objects;
    public EmployeeAdapter(Activity context, @LayoutRes int resource, @NonNull List<Employee> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater =this.context.getLayoutInflater();
        View row=inflater.inflate(this.resource,null);
        TextView txtlvName= (TextView) row.findViewById(R.id.txtLvName);
        TextView txtlvDay= (TextView) row.findViewById(R.id.txtLvDay);
        TextView txtlvExDay= (TextView) row.findViewById(R.id.txtLvExDay);
        Employee em=this.objects.get(position);
        return row;
    }
}
