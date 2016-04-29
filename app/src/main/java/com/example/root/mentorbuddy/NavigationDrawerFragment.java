package com.example.root.mentorbuddy;


import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NavigationDrawerFragment extends Fragment {


    public static final String PREF_NAME = "PREF";
    public static final String KEY_USER_LEARNED_DRAWER = "user_learned_drawer";

    private RecyclerView recyclerView;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private View container_view;
    private UserListAdapter adapter;

    private boolean mUserLearnedDrawer;
    private boolean mFromSavedInstance;

    public NavigationDrawerFragment() {
        // Required empty public constructor

    }

    public static List<UserMenu> get_data() {

        List<UserMenu> data = new ArrayList<>();

        data.add(new UserMenu(R.mipmap.ic_timeline, "Timeline"));
        data.add(new UserMenu(R.mipmap.ic_forum, "Discussion Forum"));
        data.add(new UserMenu(R.mipmap.ic_mentor_request, "Mentor Request"));
        data.add(new UserMenu(R.mipmap.ic_mentor, "Be A Mentor"));
        data.add(new UserMenu(R.mipmap.ic_settings, "Settings"));
        data.add(new UserMenu(R.mipmap.ic_about, "About Us"));

        return data;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mUserLearnedDrawer = Boolean.valueOf(readFromSharedPreferences(getActivity(), KEY_USER_LEARNED_DRAWER, "false"));
        if (savedInstanceState != null) {

            mFromSavedInstance = true;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment_navigation_drawer2, container, false);
        recyclerView = (RecyclerView) layout.findViewById(R.id.user_list);

        adapter = new UserListAdapter(getActivity(), get_data());
        recyclerView.setAdapter(adapter);

        recyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(getActivity())
                .color(Color.GRAY)
                .build());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Inflate the layout for this fragment
        return layout;
    }

    public void setUp(int fragment_navigation_drawer, DrawerLayout drawerLayout, Toolbar toolbar) {

        container_view = getActivity().findViewById(R.id.fragment_navigation_drawer);
        mDrawerLayout = drawerLayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), mDrawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                if (!mUserLearnedDrawer) {
                    mUserLearnedDrawer = true;
                    saveSharedPreferences(getActivity(), KEY_USER_LEARNED_DRAWER, mUserLearnedDrawer + "");
                }

                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

                getActivity().invalidateOptionsMenu();

            }

        };

        if (!mUserLearnedDrawer && !mFromSavedInstance) {

            mDrawerLayout.openDrawer(container_view);
        }

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {

                mDrawerToggle.syncState();
            }
        });

    }

    public void saveSharedPreferences(Context context, String preferenceName, String preferenceValue) {

        SharedPreferences sharedpreferences = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(preferenceName, preferenceValue);
        editor.apply();

    }

    public String readFromSharedPreferences(Context context, String preferenceName, String preferenceValue) {

        SharedPreferences sharedpreferences = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);
        return sharedpreferences.getString(preferenceName, preferenceValue);
    }
}
