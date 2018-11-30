package com.example.admin.topsheetexample;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private Button mButton;
    private ImageView mFilterIcon;
    ImageView dCloseIcon;
    RelativeLayout dDone;
    private Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeView();
        OnClickListener();
       /* mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View layoutView = getLayoutInflater().inflate(R.layout.sample_layout, null);
                final Dialog mBottomSheetDialog = new Dialog(MainActivity.this, R.style.MaterialDialogSheet);
                mBottomSheetDialog.setContentView(layoutView); // your custom view.
                mBottomSheetDialog.setCancelable(true);
                mBottomSheetDialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                mBottomSheetDialog.getWindow().setGravity(Gravity.BOTTOM);
                mBottomSheetDialog.show();
            }
        });*/
    }

    private void OnClickListener() {
        mFilterIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTopSheetDialog();
            }
        });
    }

    private void initializeView() {
        mFilterIcon = findViewById(R.id.filterIcon);

    }

    public void showTopSheetDialog() {
        View view = getLayoutInflater().inflate(R.layout.bottom_sheet,null);
        initializeDialogView(view);
        DialogOnClickListener();
        dialog = new Dialog(MainActivity.this, R.style.MyDialog);
        Window window = dialog.getWindow();
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        window.setGravity(Gravity.TOP);
        WindowManager.LayoutParams lWindowParams = new WindowManager.LayoutParams();
        lWindowParams.copyFrom(dialog.getWindow().getAttributes());
        lWindowParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        lWindowParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.setContentView(view);
        dialog.show();
        dialog.getWindow().setAttributes(lWindowParams);
        dialog.setCanceledOnTouchOutside(true);
        /*Window window = dialog.getWindow();
        if (window != null) {
            dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
            window.setGravity(Gravity.TOP);
            *//*int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.WRAP_CONTENT;*//*
            dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
//            dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }*/
        /*dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();*/
    }

    private void DialogOnClickListener() {
        dCloseIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    public void slideUp(View view){
        view.setVisibility(View.VISIBLE);
        TranslateAnimation animate = new TranslateAnimation(
                0,
                0,
                view.getHeight(),
                0);
        animate.setDuration(500);
        animate.setFillAfter(true);
        view.startAnimation(animate);
    }

    public void slideDown(View view){
        TranslateAnimation animate = new TranslateAnimation(
                0,
                0,
                0,
                view.getHeight());
        animate.setDuration(500);
        animate.setFillAfter(true);
        view.startAnimation(animate);
    }


    private void initializeDialogView(View view) {
        dCloseIcon = view.findViewById(R.id.closeDialog);
        dDone = view.findViewById(R.id.done);
    }
}
