package kr.ac.yonsei.a5days.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import java.text.SimpleDateFormat;
import java.util.Date;

import kr.ac.yonsei.a5days.R;
import kr.ac.yonsei.a5days.item.Goal;

public class CustomDialog extends Dialog implements  View.OnClickListener {
    RatingBar spinnerLevel;
    Button btnSubmit, btnSubmit2;
    EditText text;
    private Context context;
    private String day;
    private CustomDialogListener customDialogListener;
    public  CustomDialog(@NonNull Context context){
        super(context);
        this.context = context;
    }
    interface CustomDialogListener{
        void onPositiveClicked(Goal goal);
    }
    public void setDialogListener(CustomDialogListener customDialogListener){
        this.customDialogListener = customDialogListener;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_goal);
        spinnerLevel = findViewById(R.id.level);
        btnSubmit = findViewById(R.id.submit);
        btnSubmit2 = findViewById(R.id.submit2);
        text = findViewById(R.id.text);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date time = new Date();
        day = sdf.format(time);
        btnSubmit.setOnClickListener(this);
        btnSubmit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.submit){
            Goal goal = new Goal(text.getText().toString(),(int)spinnerLevel.getRating() ,day);
            customDialogListener.onPositiveClicked(goal);}
        else Log.e("hello is ti si","heell");
        dismiss();
    }
}