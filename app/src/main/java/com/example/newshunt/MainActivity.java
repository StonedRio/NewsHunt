package com.example.newshunt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.example.newshunt.fragments.AboutUsFragment;
import com.example.newshunt.fragments.CategorySelectionFragment;
import com.example.newshunt.fragments.FontSizeFragment;
import com.example.newshunt.fragments.HomeFragment;
import com.example.newshunt.fragments.HowToFragment;
import com.example.newshunt.fragments.LanguageSelectionFragment;
import com.example.newshunt.fragments.NewsSelectionFragment;
import com.example.newshunt.fragments.OpinionsSelectionFragment;
import com.example.newshunt.fragments.PushNotificationFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout constraintLayout;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;

    public static int userID;
    static String name;
    static String designation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();

        Intent intent=getIntent();
        userID=intent.getIntExtra("userid",0);
        name=intent.getStringExtra("name");
        designation=intent.getStringExtra("designation");




        constraintLayout=findViewById(R.id.constrain_layout);
        toolbar=constraintLayout.findViewById(R.id.toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView =findViewById(R.id.nav_view);

        toolbar.setVisibility(View.GONE);
        ReplaceFragment(new HomeFragment());

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));



        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId()==R.id.news_selection){
                    drawerLayout.closeDrawer(GravityCompat.START);
                    toolbar.setVisibility(View.GONE);
                    ReplaceFragment(new NewsSelectionFragment());
                }
//                else if (item.getItemId()==R.id.home) {
//                    drawerLayout.closeDrawer(GravityCompat.START);
//                    toolbar.setVisibility(View.GONE);
//                    ReplaceFragment(new HomeFragment());
//                }
                else if (item.getItemId()==R.id.opinions) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                    toolbar.setVisibility(View.GONE);
                    ReplaceFragment(new OpinionsSelectionFragment());
                }
                else if (item.getItemId()==R.id.category) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                    toolbar.setVisibility(View.GONE);
                    ReplaceFragment(new CategorySelectionFragment());
                }
                else if (item.getItemId()==R.id.language) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                    toolbar.setVisibility(View.GONE);
                    ReplaceFragment(new LanguageSelectionFragment());
                }
                else if (item.getItemId()==R.id.push_notification) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                    toolbar.setVisibility(View.GONE);
                    ReplaceFragment(new PushNotificationFragment());
                }
                else if (item.getItemId()==R.id.font_size) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                    toolbar.setVisibility(View.GONE);
                    ReplaceFragment(new FontSizeFragment());
                }
                else if (item.getItemId()==R.id.how_to) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                    toolbar.setVisibility(View.GONE);
                    ReplaceFragment(new HowToFragment());
                }
                else if (item.getItemId()==R.id.about_us) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                    toolbar.setVisibility(View.GONE);
                    ReplaceFragment(new AboutUsFragment());
                }
                return false;
            }
        });


    }
    public void ReplaceFragment(Fragment fragment)
    {
        try {
            FragmentManager fragmentManager=getSupportFragmentManager();
            fragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout,fragment,"");
            //fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

        }catch (Exception e)
        {
            Log.d("aa", "Exception---"+e.getMessage());
        }
    }

    public DrawerLayout getDrawerLayout() {
        return drawerLayout;
    }
}