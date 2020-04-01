package chapter.android.aweme.ss.com.homework;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.graphics.ColorUtils;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.List;

import chapter.android.aweme.ss.com.homework.model.Message;
import chapter.android.aweme.ss.com.homework.model.PullParser;

import static android.support.v4.content.ContextCompat.startActivity;

//import chapter.android.aweme.ss.com.chapter2.R;
public class Adapter extends RecyclerView.Adapter <Adapter.LinearViewHolder> {
    private final int length = 20;
    Context context;
    private ListItemClickListener mOnClickListener;
    Message[] message = new Message[length];
    public Adapter(Context context,  ListItemClickListener listener){
        this.context = context;
        this.mOnClickListener = listener;
    }

//    String[] titles = {"菠菜宠物店1","菠菜宠物店2", "菠菜宠物店3", "菠菜宠物店4"};
//    String[] descriptions = {"重庆市北碚区天生路1号","重庆市北碚区天生路2号","重庆市北碚区天生路3号","重庆市北碚区天生路4号"};
//    String[] times = {"服务1","服务2","服务3","服务4"};

//    public Adapter(int numListItems, ListItemClickListener listener) {
//        mNumberItems = numListItems;
//        mOnClickListener = listener;
//        viewHolderCount = 0;
//    }

    //@Override
    public LinearViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.im_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        LinearViewHolder viewHolder = new LinearViewHolder(view);

//        int backgroundColorForViewHolder = ColorUtils
//                .getViewHolderBackgroundColorFromInstance(context, viewHolderCount);
//        viewHolder.itemView.setBackgroundColor(backgroundColorForViewHolder);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LinearViewHolder linearViewHolder, int position) {//赋值
//        linearViewHolder.bind(position);
        linearViewHolder.tv_description.setText(message[position].getDescription());
        linearViewHolder.tv_title.setText(message[position].getTitle());
        linearViewHolder.tv_time.setText(message[position].getTime());
        linearViewHolder.isOfficial = message[position].isOfficial();
//        linearViewHolder.image.setImageResource(message[position]);
        //linearViewHolder.image.setImageResource(message[position].ge);

    }

    @Override
    public int getItemCount() {
        return length;
    }

    public class LinearViewHolder extends RecyclerView.ViewHolder implements RecyclerView.OnClickListener{
         TextView tv_description, tv_title;
         TextView tv_time;
         ImageView image;
         boolean isOfficial;

        LinearViewHolder(View itemView) {
            super(itemView);
            //找到组件
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_description = itemView.findViewById(R.id.tv_description);
            tv_time = itemView.findViewById(R.id.tv_time);
            image = itemView.findViewById(R.id.robot_notice);
            itemView.setOnClickListener(this);
        }

//        void bind(int position) {
//            //   listItemNumberView.setText(String.valueOf(position));
//        }

        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            Intent intent = new Intent();
            intent.setClass(context, Activity_Exercise3.class);
            String tmp = null;
            tmp = String.valueOf(clickedPosition);
            intent.putExtra("clickedPosition", tmp);
            context.startActivity(intent);
            if (mOnClickListener != null) {
                mOnClickListener.onListItemClick(clickedPosition);
            }
        }


//        public void onClick(View v) {
//            Intent intent = new Intent();
//            intent.setClass(Exercises3.class,Activity_Exercise3.class);
//            startActivity(intent);
////            int clickedPosition = getAdapterPosition();
////
//////            if (mOnClickListener != null) {
//////                mOnClickListener.onListItemClick(clickedPosition);
//////            }
//        }

    }



    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }
}


