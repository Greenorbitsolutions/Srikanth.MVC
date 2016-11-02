package com.srikanth.mrbool1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

public class mvcController
{
    private mvcModel model;
    private List<String> tasks;

    public mvcController(Context app_context)
    {
        tasks = new ArrayList<String>();
        model = new mvcModel(app_context);
    }

    public void addTask(final String title)
    {
        final ContentValues data = new ContentValues();
        data.put("title", title);
        model.addTask(data);
    }

    public void deleteTask(final String title)
    {
        model.deleteTask("title='" + title + "'");
    }

    public void deleteTask(final long id)
    {
        model.deleteTask("id='" + id + "'");
    }

    public void deleteAllTask()
    {
        model.deleteTask(null);
    }

    public List<String> getTasks()
    {
        Cursor c = model.loadAllTasks();
        tasks.clear();
       // tasks.isEmpty();
        if (c != null)
        {
            c.moveToFirst();

            while (c.isAfterLast() == false)
            {
                tasks.add(c.getString(0));
                c.moveToNext();
            }

            c.close();
        }

        return tasks;
    }}
