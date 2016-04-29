package com.example.root.mentorbuddy;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private Toolbar toolbar;
    private TextView txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_appbar);

        //setSupportActionBar(toolbar);

        toolbar = (Toolbar) findViewById(R.id.app_bar);//Do only for OS older than v21
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);

        NavigationDrawerFragment navigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager()
                .findFragmentById(R.id.fragment_navigation_drawer);

        navigationDrawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.dashboard_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        //txt1 = (TextView) findViewById(R.id.textv1);

        if (id == R.id.action_settings) {

            //txt1.setText("Done");

        }

        if (id == R.id.search_mentor) {

            //
        }

        return super.onOptionsItemSelected(item);
    }

    public void setUp() {

    }

    public void composeMessage(MenuItem item) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Dialog Sample").setMessage("Are You Sure");

        builder.create();
        builder.show();

    }
}
