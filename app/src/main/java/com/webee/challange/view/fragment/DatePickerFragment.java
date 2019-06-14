package com.webee.challange.view.fragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import com.webee.challange.utils.DateUtils;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment{

    private DatePickerDialog.OnDateSetListener listener;

    public DatePickerFragment(DatePickerDialog.OnDateSetListener listener) {
        this.listener = listener;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), listener, year, month, day);
        datePickerDialog.getDatePicker().setMinDate(DateUtils.getMinLimitDate());
        return datePickerDialog;
    }

}