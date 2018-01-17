package com.full.chat.chatapp;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.full.chat.chatlibrary.ChatActivity;
import com.full.chat.chatlibrary.ConversationActivity;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.back_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    public void startChat(View pView){
        startActivity(new Intent(MainActivity.this, ChatActivity.class));
        overridePendingTransition(com.full.chat.chatlibrary.R.anim.enter_from_right, com.full.chat.chatlibrary.R.anim.exit_to_left);
    }
    public void chatHistory(View pView){
        startActivity(new Intent(MainActivity.this, ConversationActivity.class));
        overridePendingTransition(com.full.chat.chatlibrary.R.anim.enter_from_right, com.full.chat.chatlibrary.R.anim.exit_to_left);
    }
}
