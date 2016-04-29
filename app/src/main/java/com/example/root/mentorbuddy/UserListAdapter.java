package com.example.root.mentorbuddy;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by root on 3/14/16.
 */
@SuppressWarnings("ALL")
public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.MyViewHolder> {

    Context context;
    List<UserMenu> data = Collections.emptyList();
    private LayoutInflater inflater;

    public UserListAdapter(Context context, List<UserMenu> data) {

        inflater = LayoutInflater.from(context);
        this.data = data;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.user_menu_rows, parent, false);
        MyViewHolder holder = new MyViewHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        final UserMenu current = data.get(position);
        holder.textView.setText(current.title);
        holder.imageView.setImageResource(current.iconId);


    }

    public void RemoveData(int position) {

        data.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public int getItemCount() {

        return data.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textView;
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.user_list_text);
            imageView = (ImageView) itemView.findViewById(R.id.list_icon);

            textView.setOnClickListener(this);


        }


        @Override
        public void onClick(View v) {

            //Log.d("Clicked", "You Clicked "+getPosition());
            //Toast.makeText(itemView.getContext(), "Item Clicked " +getPosition(), Toast.LENGTH_SHORT).show();
            //RemoveData(getPosition());
        }
    }
}
