package com.full.chat.chatlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class ChatActivity extends FragmentActivity {

    final int CHOOSE_FILE_CODE = 11;
    private static final String TAG = "ChatActivity";
    EditText mMessageET;
    String mMessage = "";
    ImageView mSendMessageImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        mMessageET  = findViewById(R.id.message_et);
        mSendMessageImage = findViewById(R.id.choose_file_image);
        mMessageET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) {
                if ((mMessage = mMessageET.getText().toString()).isEmpty()){
                    mSendMessageImage.setImageResource(R.drawable.attach_img);
                }else {
                    mSendMessageImage.setImageResource(R.drawable.send);
                }
            }
        });
        findViewById(R.id.back_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(ChatActivity.this, ConversationActivity.class));
                finish();
                overridePendingTransition(R.anim.enter_from_left, R.anim.exit_to_right);
            }
        });

        findViewById(R.id.close_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(R.anim.enter_from_left, R.anim.exit_to_right);
            }
        });

        mSendMessageImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mMessage.isEmpty()) {
                    Intent lIntent = new Intent(Intent.ACTION_GET_CONTENT);
                    lIntent.setType("image/*");
                    lIntent.addCategory(Intent.CATEGORY_OPENABLE);
                    startActivityForResult(Intent.createChooser(lIntent, "Select a File to Upload"), CHOOSE_FILE_CODE);
                }else {

                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.enter_from_left, R.anim.exit_to_right);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CHOOSE_FILE_CODE && resultCode == RESULT_OK){
            data.getData().toString();
            Log.d(TAG, "onActivityResult: "+ data.getData().toString());
        }
    }
}
