package chapter.android.aweme.ss.com.homework;

import android.content.Intent;
import android.os.Bundle;
//import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.io.InputStream;
import java.util.List;


import chapter.android.aweme.ss.com.homework.model.Message;
import chapter.android.aweme.ss.com.homework.model.PullParser;

import static android.support.v4.content.ContextCompat.startActivity;

/**
 * 大作业:实现一个抖音消息页面,
 * 1、所需的data数据放在assets下面的data.xml这里，使用PullParser这个工具类进行xml解析即可
 * <p>如何读取assets目录下的资源，可以参考如下代码</p>
 * <pre class="prettyprint">
 *
 *         @Override
 *     protected void onCreate(@Nullable Bundle savedInstanceState) {
 *         super.onCreate(savedInstanceState);
 *         setContentView(R.layout.activity_xml);
 *         //load data from assets/data.xml
 *         try {
 *             InputStream assetInput = getAssets().open("data.xml");
 *             List<Message> messages = PullParser.pull2xml(assetInput);
 *             for (Message message : messages) {
 *
 *             }
 *         } catch (Exception exception) {
 *             exception.printStackTrace();
 *         }
 *     }
 * </pre>
 * 2、所需UI资源已放在res/drawable-xxhdpi下面
 *
 * 3、作业中的会用到圆形的ImageView,可以参考 widget/CircleImageView.java
 */
public class Exercises3 extends AppCompatActivity implements Adapter.ListItemClickListener{

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);
        RecyclerView mRecycleView = findViewById(R.id.rv_list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecycleView.setLayoutManager(layoutManager);
        Adapter madapter = new Adapter(Exercises3.this, this);
        mRecycleView.setAdapter(madapter);
        mRecycleView.setHasFixedSize(true);
        int pos = 0;
        try {
              InputStream assetInput = getAssets().open("data.xml");
              List<Message> messages = PullParser.pull2xml(assetInput);
             for (Message message : messages) {
                 madapter.message[pos] = message;
                 pos++;
              }
          } catch (Exception exception) {
              exception.printStackTrace();
          }
  //      mRecycleView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//
//
//
   //         onClick(mRecycleView);

    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
//        TextView tx = findViewById(R.id.tv_content_info);
//        tx.setText(clickedItemIndex);
    }

//    public void onClick(View v) {
//        Intent intent = new Intent();
//        intent.setClass(this, Activity_Exercise3.class);
//        startActivity(intent);
//    }
//////            int clickedPosition = getAdapterPosition();
//////
////////            if (mOnClickListener != null) {
////////                mOnClickListener.onListItemClick(clickedPosition);
////////            }
////    }
//    public void onListItemClick(int clickedItemIndex) {
//
//        Log.d(TAG, "onListItemClick: ");
//        if (mToast != null) {
//            mToast.cancel();
//        }
//        String toastMessage = "Item #" + clickedItemIndex + " clicked.";
//        mToast = Toast.makeText(this, toastMessage, Toast.LENGTH_LONG);
//
//        mToast.show();
//    }

}
