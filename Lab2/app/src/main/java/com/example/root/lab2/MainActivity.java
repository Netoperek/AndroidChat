package com.example.root.lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity
public class MainActivity extends AppCompatActivity {
    public static String IP = "ip";
    public static String NICK = "nick";

    @ViewById(R.id.ipPlainText)
    EditText ipPlainText;

    @ViewById(R.id.nickNamePlainText)
    EditText nickNamePlainText;

    @AfterViews
    void setDefaults() {
        ipPlainText.setHint("Your IP address");
        nickNamePlainText.setHint("Your Nick Name");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Click(R.id.startButton)
    void startChatActivity() {
        Intent intent = new Intent(MainActivity.this, SimpleChatActivity_.class);
        intent.putExtra(IP, ipPlainText.getText().toString());
        intent.putExtra(NICK, nickNamePlainText.getText().toString());
        startActivity(intent);
    }

}
