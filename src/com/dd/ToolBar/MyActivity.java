package com.dd.ToolBar;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

public class MyActivity extends ActionBarActivity {
	private DrawerLayout drawerLayout;
	private ListView lv_drawer;
	private FrameLayout fl_container;
	private Toolbar toolbar;

	private ActionBarDrawerToggle toggle;

	public Toolbar getToolbar() {
		return toolbar;
	}

	public ActionBarDrawerToggle getToggle() {
		return toggle;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		initResources();
	}

	private void initResources() {
		drawerLayout = (DrawerLayout) findViewById(R.id.dl_home_page);
		lv_drawer = (ListView) findViewById(R.id.lv_home_page_drawer);
		fl_container = (FrameLayout) findViewById(R.id.fl_home_page_container);

		toolbar = (Toolbar) findViewById(R.id.my_awesome_toolbar);
		toolbar.setTitle("This is a ToolBar");
		setSupportActionBar(toolbar);
		toolbar.setNavigationIcon(R.drawable.back_arrow);
		toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				System.out.println("---> hehehe");
			}
		});
		toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name) {
			@Override
			public void onDrawerClosed(View drawerView) {
				super.onDrawerClosed(drawerView);
				invalidateOptionsMenu();
			}

			@Override
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
				invalidateOptionsMenu();
			}
		};
		drawerLayout.setDrawerListener(toggle);

		String[] stringArray = getResources().getStringArray(R.array.menu);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, stringArray);
		lv_drawer.setAdapter(adapter);
		lv_drawer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				changeView(position);
				drawerLayout.closeDrawers();
			}
		});
	}

	private void changeView(int position) {
		FragmentManager supportFragmentManager = getSupportFragmentManager();
		if (position == 0) {
			supportFragmentManager.beginTransaction().replace(R.id.fl_home_page_container, new FragmentA()).commit();
		} else if (position == 1) {
			supportFragmentManager.beginTransaction().replace(R.id.fl_home_page_container, new FragmentB()).commit();
		} else {
			supportFragmentManager.beginTransaction().replace(R.id.fl_home_page_container, new FragmentC()).commit();
		}
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		toggle.syncState();
	}
}
