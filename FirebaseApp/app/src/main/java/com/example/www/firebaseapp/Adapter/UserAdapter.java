package com.example.www.firebaseapp;

import android.content.Context;
import android.content.Intent;
import android.icu.text.UnicodeSetSpanner;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<UserModelClass> userModelClassList;



    public UserAdapter( Context mContext,ArrayList<UserModelClass> userModelClassList) {
        this.userModelClassList = userModelClassList;
        this.mContext = mContext;

    }

    @NonNull
    @Override
    public UserAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(mContext).inflate(R.layout.user_items,parent,false);

        MyViewHolder myViewHolder = new MyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.MyViewHolder holder, int position) {

        final UserModelClass mUserModel = userModelClassList.get(position);

        holder.nameTextView.setText(mUserModel.getName());
        holder.emailTextView.setText(mUserModel.getEmail());
        holder.mobileTextView.setText(mUserModel.getMobileNumber());

        holder.mLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,AddUserDetails.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("name",mUserModel.getName());
                intent.putExtra("email",mUserModel.getEmail());
                intent.putExtra("mobile",mUserModel.getMobileNumber());
                mContext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return userModelClassList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTextView,emailTextView,mobileTextView;
        private LinearLayout mLinearLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTextView = (TextView)itemView.findViewById(R.id.user_name_textView);
            emailTextView = (TextView)itemView.findViewById(R.id.user_email_textView);
            mobileTextView = (TextView)itemView.findViewById(R.id.user_mobile_textView);

            mLinearLayout = (LinearLayout)itemView.findViewById(R.id.linear_layout);

        }

    }

}
