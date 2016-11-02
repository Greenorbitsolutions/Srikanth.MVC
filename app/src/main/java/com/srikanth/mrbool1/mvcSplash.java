package com.srikanth.mrbool1;

/**
 * Created by srikanth on 11/1/2016.
 */
import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.view.menu.MenuView;

public class mvcSplash extends Activity
{
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.ui_splash);

        Thread timer = new Thread()
        {
            public void run()
            {
                try
                {
                    sleep(1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    Intent intent = new Intent(mvcSplash.this, MVCView.class);
                    startActivity(intent);
                }
            }
        };

        timer.start();
    }
}



