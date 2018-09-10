package com.example.amrit.recyclerviewwithdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context mContext;
    private Cursor mCursor;

    public MyAdapter(Context context, Cursor cursor) {
        mContext = context;
        mCursor = cursor;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.single_row_list,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder viewHolder, int i) {
        if(!mCursor.moveToPosition(i)){
            return;
        }
        String firstValue = mCursor.getString(mCursor.getColumnIndex(ModelContract.ModelEntry.HELLO_COLUMN));
        int secondValue = mCursor.getInt(mCursor.getColumnIndex(ModelContract.ModelEntry.NUMBER_COLUMN));
        viewHolder.tv1.setText(firstValue);
        viewHolder.tv2.setText(String.valueOf(secondValue));
    }

    @Override
    public int getItemCount() {
       return mCursor.getCount();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv1, tv2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv1 = itemView.findViewById(R.id.texView_1);
            tv2 = itemView.findViewById(R.id.textView_2);
        }
    }
}
