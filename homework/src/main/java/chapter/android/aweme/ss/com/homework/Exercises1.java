package chapter.android.aweme.ss.com.homework;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.media.VolumeShaper;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * 作业1：
 * Logcat在屏幕旋转的时候 #onStop() #onDestroy()会展示出来
 * 但我们的 mLifecycleDisplay 由于生命周期的原因(Tips:执行#onStop()之后，UI界面我们是看不到的)并没有展示
 * 在原有@see Exercises1 基础上如何补全它，让其跟logcat的展示一样?
 * <p>
 * Tips：思考用比Activity的生命周期要长的来存储？  （比如：application、static变量）
 */
public class Exercises1 extends AppCompatActivity {
    private static final String TAG = "exercise1";

    private static final String ON_CREATE = "onCreate";
    private static final String ON_START = "onStart";
    private static final String ON_RESUME = "onResume";
    private static final String ON_PAUSE = "onPause";
    private static final String ON_STOP = "onStop";
    private static final String ON_RESTART = "onRestart";
    private static final String ON_DESTROY = "onDestroy";
    private static final String ON_SAVE_INSTANCE_STATE = "onSaveInstanceState";
    private static final String ON_RESTORE_INSTANCE_STATE = "onRestoreInstanceState";
    private static final String LIFECYCLE_CALLBACKS_TEXT_KEY = "callbacks";

    private TextView show;

    static String record = "";

    public boolean isFullScreen() {
        return this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
    }

//    public void rotate(View view) {
//        setRequestedOrientation(!isFullScreen() ? ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE :
//           ActivityInfo.SCREEN_ORIENTATION_PORTRAIT );
//    }

//    public Exercises1(TextView show) {
//        this.show = show;
//    }

    private void logAndAppend(String lifecycleEvent) {

        Log.d(TAG, "Lifecycle Event: " + lifecycleEvent);
        show.append(lifecycleEvent + "\n");
    //    System.out.println(lifecycleEvent);
    }

//    public void resetLifecycleDisplay(View view) {
//        show.setText("Lifecycle callbacks:\n");
//    }

//    public void showSaveInstance(View view) {
//        startActivity(new Intent(this, SaveInstanceStateActivity.class));
//    }

    //public void showUpgradeDialog(View view) {
//        new AlertDialog.Builder(this)
//                .setTitle("应用升级")
//                .setMessage("抖音1.1版本升级")
//                .setPositiveButton("取消", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                })
//                .setNegativeButton("确定", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                }).create().show();
  //      startActivity(new Intent(this, DialogActivity.class));
 //   }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise1);
        show = findViewById(R.id.textView2);
        if(savedInstanceState != null) {
            if (savedInstanceState.containsKey(LIFECYCLE_CALLBACKS_TEXT_KEY)) {
                String savedContent = (String) savedInstanceState.get(LIFECYCLE_CALLBACKS_TEXT_KEY);
                show.setText(savedContent);
            }
            if(record != "") {
                show.append(record + "\n");
            }
        }
        record = "";
        Button btn1 = findViewById(R.id.Switch_Screen);
        btn1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                setRequestedOrientation(!isFullScreen() ? ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE :
                        ActivityInfo.SCREEN_ORIENTATION_PORTRAIT );
            }
        });
       logAndAppend(ON_CREATE);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
       // System.out.println(ON_RESTART);
        logAndAppend(ON_RESTART);
    }

    @Override
    protected void onStart() {
        super.onStart();
       // System.out.println(ON_START);
        logAndAppend(ON_START);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //System.out.println(ON_RESUME);
       logAndAppend(ON_RESUME);
    }


    @Override
    protected void onPause() {
        super.onPause();
      //  System.out.println(ON_PAUSE);
        logAndAppend(ON_PAUSE);
    }

    @Override
    protected void onStop() {
        super.onStop();
      //  System.out.println(ON_STOP);
        logAndAppend(ON_STOP);
    }

    @Override
    protected void onDestroy() {
        logAndAppend(ON_DESTROY);
        record = ON_DESTROY;
        super.onDestroy();
        //System.out.println(ON_DESTROY);
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        logAndAppend(ON_SAVE_INSTANCE_STATE);
        String content = show.getText().toString();//当前已有的log 提取出来
        outState.putString(LIFECYCLE_CALLBACKS_TEXT_KEY, content); //把内容存储起来
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        logAndAppend(ON_RESTORE_INSTANCE_STATE);
    }

}
