package com.example.md3.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.md3.R;
import com.example.md3.fragment.BooksFragment;
import com.example.md3.fragment.CardFragment;
import com.example.md3.fragment.ItemFragment;
import com.example.md3.fragment.LodingFragment;

public class MainActivity extends AppCompatActivity {
    //声明相关变量
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private Toolbar mToolbar;
    private NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //设置Toolbar
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        //设置DrawerLayout
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar,
                R.string.drawer_open, R.string.drawer_close);
        mDrawerToggle.syncState();
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        //设置NavigationView点击事件
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        setupDrawerContent(mNavigationView);
        //进入例子界面
        switchToBook();
        //加载顶部图片
        setUpProfileImage();
    }
    private void setUpProfileImage() {
        View headerView=  mNavigationView.inflateHeaderView(R.layout.headerlayout);
        View profileView = headerView.findViewById(R.id.avator);
        if (profileView != null) {
            profileView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   // switchToBlog();
                    mDrawerLayout.closeDrawers();
                    mNavigationView.getMenu().getItem(1).setChecked(true);
                }
            });
        }

    }
    private void switchToBook() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new BooksFragment()).commit();
        mToolbar.setTitle(R.string.navigation_book);
    }
    public void setupDrawerContent(NavigationView upDrawerContent) {
        upDrawerContent.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {

                            case R.id.navigation_item_book:
                               switchToBook();
                                break;
                            case R.id.navigation_item_example:
                                getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new CardFragment()).commit();
                                mToolbar.setTitle(R.string.card);
                                break;
                            case R.id.navigation_item_blog:
                                getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new LodingFragment()).commit();
                                mToolbar.setTitle(R.string.loding);
                                break;
                            case R.id.navigation_item_about:
                                getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new ItemFragment()).commit();
                                mToolbar.setTitle(R.string.list);
                                break;
                            case R.id.navigation_item_about1:
                               Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                                startActivity(intent);
                                break;

                        }
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }
}

