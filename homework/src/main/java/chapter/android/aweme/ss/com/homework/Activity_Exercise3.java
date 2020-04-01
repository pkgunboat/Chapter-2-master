package chapter.android.aweme.ss.com.homework;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.Nullable;
import android.widget.TextView;


public class Activity_Exercise3 extends AppCompatActivity {
    public int clickedItemIndex;
   // @Override


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom);
        TextView tx = findViewById(R.id.tv_content_info);
        Intent intent = getIntent();
        tx.setText(intent.getStringExtra("clickedPosition"));
    }
}
