package com.example.exempletablayout;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TableLayout;

import com.example.exempletablayout.fragments.FirstFragment;
import com.example.exempletablayout.fragments.MainFragment;
import com.example.exempletablayout.fragments.SecondFragment;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager;
    ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getFragmentManager();

        fragments = new ArrayList<>();
        fragments.add(new MainFragment());
        fragments.add(new FirstFragment());
        fragments.add(new SecondFragment());

        TabLayout tabLayout = findViewById(R.id.tabLayout);

        // on ajoute tabitem dynamiquement
        TabLayout.Tab firstTab = tabLayout.newTab();
        firstTab.setText("Lundi");
        firstTab.setIcon(R.drawable.ic_assessment_black_24dp);
        tabLayout.addTab(firstTab);

        TabLayout.Tab secondTab = tabLayout.newTab();
        secondTab.setText("Mardi");
        secondTab.setIcon(R.drawable.ic_assignment_black_24dp);
        tabLayout.addTab(secondTab);

        TabLayout.Tab thirdTab = tabLayout.newTab();
        thirdTab.setText("Mecredi");
        thirdTab.setIcon(R.drawable.ic_assignment_ind_black_24dp);
        tabLayout.addTab(thirdTab);


        // Fragment affiché par defaut au démarrage de l'application
        Fragment mainFragment = fragments.get(0);
        replaceFragment(mainFragment);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Fragment fragment = fragments.get(position);
                replaceFragment(fragment);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void replaceFragment(Fragment fragment) {
        // on démarre une transaction pour gérer les differents fragments
        fragmentManager.beginTransaction()
                .replace(R.id.frmMain, fragment)
                .commit();
    }
}
