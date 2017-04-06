package com.zwl9517hotmail.joystickorrocker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.zwl9517hotmail.joysticklibrary.CircleViewByImage;

import java.text.SimpleDateFormat;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    private CircleViewByImage view;
    private TextView action;
    private String newLine = "\n";
    private String tab = "\t";
    private String text = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        view = (CircleViewByImage) findViewById(R.id.joystick_view);
        action = (TextView) findViewById(R.id.action);
        findViewById(R.id.clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action.setText("");
                text = "";
            }
        });

        view.setCallback(callback);
    }

    private String getCurTime() {
        return new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(System.currentTimeMillis());
    }

    private void showAction(String string) {
        action.setText(text.length() > 2000 ? text = "" : (text = (getCurTime() + tab + string + newLine + text)));
    }

    private CircleViewByImage.ActionCallback callback = new CircleViewByImage.ActionCallback() {
        @Override
        public void forwardMove() {
            showAction("Up");
        }

        @Override
        public void backMove() {
            showAction("Down");
        }

        @Override
        public void leftMove() {
            showAction("Left");
        }

        @Override
        public void rightMove() {
            showAction("Right");
        }

        @Override
        public void centerMove() {
            showAction("Move a little in center area");

        }

        @Override
        public void centerClick() {
            showAction("Click on center area");
        }

        @Override
        public void actionUp() {
            showAction("Action up");
        }
    };
}
