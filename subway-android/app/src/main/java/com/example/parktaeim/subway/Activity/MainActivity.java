package com.example.parktaeim.subway.Activity;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.example.parktaeim.subway.Fragment.EventFragment;
import com.example.parktaeim.subway.Fragment.HoneyFragment;
import com.example.parktaeim.subway.Fragment.MenuFragment;
import com.example.parktaeim.subway.Fragment.MypageFragment;
import com.example.parktaeim.subway.Fragment.StoreFragment;
import com.example.parktaeim.subway.R;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {
    public static AHBottomNavigation bottomTabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTabLayout();
    }

    private void setTabLayout() {
        bottomTabLayout = (AHBottomNavigation) findViewById(R.id.main_tabLayout);

        AHBottomNavigationItem item1 = new AHBottomNavigationItem("꿀조합", R.drawable.ic_honey);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem("메뉴", R.drawable.ic_menu);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem("매장찾기", R.drawable.ic_store);
        AHBottomNavigationItem item4 = new AHBottomNavigationItem("이벤트", R.drawable.ic_event);
        AHBottomNavigationItem item5 = new AHBottomNavigationItem("마이페이지", R.drawable.ic_mypage);

        bottomTabLayout.addItem(item1);
        bottomTabLayout.addItem(item2);
        bottomTabLayout.addItem(item3);
        bottomTabLayout.addItem(item4);
        bottomTabLayout.addItem(item5);

        bottomTabLayout.setAccentColor(Color.parseColor("#029545"));
        bottomTabLayout.setInactiveColor(Color.parseColor("#c4c4c4"));
        bottomTabLayout.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);
        bottomTabLayout.setCurrentItem(0);
        bottomTabLayout.setTitleTextSizeInSp(9,8);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HoneyFragment()).commit();
        bottomTabLayout.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                switch (position) {
                    case 0:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HoneyFragment()).commit();
                        break;
                    case 1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MenuFragment()).commit();
                        break;
                    case 2:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new StoreFragment()).commit();
                        break;
                    case 3:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new EventFragment()).commit();
                        break;
                    case 4:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MypageFragment()).commit();
                        break;
                }
                return true;
            }
        });
        bottomTabLayout.setOnNavigationPositionListener(new AHBottomNavigation.OnNavigationPositionListener() {
            @Override public void onPositionChange(int y) {
                // Manage the new y position
            }
        });
    }

}
