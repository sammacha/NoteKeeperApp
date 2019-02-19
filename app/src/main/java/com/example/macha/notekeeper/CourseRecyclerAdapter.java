package com.example.macha.notekeeper;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CourseRecyclerAdapter extends RecyclerView.Adapter<CourseRecyclerAdapter.viewHolder> {

    private final Context mContext;
    private final List<CourseInfo> mCourses;
    private LayoutInflater layoutInflater;

    public CourseRecyclerAdapter(Context mContext, List<CourseInfo> mCourses) {
        this.mContext = mContext;
        layoutInflater = LayoutInflater.from(mContext);
        this.mCourses = mCourses;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.item_course_list,parent,false);
        return new viewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        CourseInfo course = mCourses.get(position);
        holder.textCourse.setText(course.getTitle());
        holder.mCurrentPosition = position;

    }

    @Override
    public int getItemCount() {
        return mCourses.size();
    }

    public  class viewHolder extends RecyclerView.ViewHolder{

        public final TextView textCourse;
        public int mCurrentPosition;

        public viewHolder(View itemView) {
            super(itemView);
            textCourse = (TextView) itemView.findViewById(R.id.text_course);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, mCourses.get(mCurrentPosition).getTitle(),
                    Snackbar.LENGTH_LONG).show();
                }
            });
        }
    }
}
