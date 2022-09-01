package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Callback;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {
    private List<Example> mDataList;
    private LayoutInflater mInflater;

    // 剛剛context跟list就是透過這個傳進來 然後我們設mData=data
    // 所以mData=Horse，Cow，Camel，Sheep，Goat
    // 這裡的inflater是要可以載入黃色那塊 就是recyclerview_row.xml
    RecycleViewAdapter(Context context, List<Example> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mDataList = data;
    }

    //創造viewHolder

    // 用inflater載入黃色這塊，並傳入viewHolder

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recycle_text, parent, false);
        return new ViewHolder(view);
    }

    // 這裡是黃色那塊尋找textView Id的，不找就不知道在哪
    public class ViewHolder extends RecyclerView.ViewHolder  {
        TextView myTextView;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.textView);
        }


    }
    // 用viewHolder綁定資料
    //position是mData的第幾個 向是第零個是Horse 第二個是Camel
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Example example = mDataList.get(position);
        holder.myTextView.setText(example.getValue());
    }

    // 確定mData有幾個 ， 可以試試看return1的話就只會有一個資料出來喔
    @Override
    public int getItemCount() {
        return mDataList.size();
    }


}
