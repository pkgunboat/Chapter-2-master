package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

/**
 * 作业2：一个抖音笔试题：统计页面所有view的个数
 * Tips：ViewGroup有两个API
 * {@link android.view.ViewGroup #getChildAt(int) #getChildCount()}
 * 用一个TextView展示出来
 */
public class Exercises2 extends AppCompatActivity {

   // @Override

    private TextView tx1;
    private View activity_exercise2;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise2);
        ViewGroup vg = findViewById(R.id.liner_layout_ex2);
        tx1 = findViewById(R.id.textview1_ex2);
        int ans = getAllChildViewCount(vg);
        tx1.append(ans + "\n");
    }

    public int getAllChildViewCount(ViewGroup viewGroup) {
        int count = viewGroup.getChildCount();
        int tot = 0;
     //   tx1.append(count + "\n");
        //循环获取子View
        for(int i = 0; i < count; i++){
            View child = viewGroup.getChildAt(i);
            if(child instanceof ViewGroup){
                //如果子View是ViewGroup，则用递归获取子View数量
                int childCount = getAllChildViewCount((ViewGroup)child);
                tot += childCount;
            }else {
                tot++;
            }
        }
        return tot;
    }
}
