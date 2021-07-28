package com.example.viewpagertoolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    // 2. s icon initialization
    private TextView title;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private String[] menuName= { "Product", "Reviews", "Contact"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(0);

        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

        //setupIcon();
        SetText();


    }

    // Toolbar Menu Text set
    private void SetText(){
        tabLayout.getTabAt(0).setText(menuName[0]);
        tabLayout.getTabAt(1).setText(menuName[1]);
        tabLayout.getTabAt(2).setText(menuName[2]);
    }

    // setup viewpager
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdaptar = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdaptar.addFragment(new ProductFragment(), "Title One");
        viewPagerAdaptar.addFragment(new ReviewsFragment(), "Title Two");
        viewPagerAdaptar.addFragment(new ContactFragment(), "Title Three");
        viewPager.setAdapter(viewPagerAdaptar);
    }



}