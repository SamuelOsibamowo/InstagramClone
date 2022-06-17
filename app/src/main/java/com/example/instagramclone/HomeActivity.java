package com.example.instagramclone;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.instagramclone.fragments.HomeFragment;
import com.example.instagramclone.fragments.PostFragment;
import com.example.instagramclone.fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.io.File;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private final static String TAG = "HomeActivity";

    private BottomNavigationView bottomNavigationView;
    private TextView tvLogout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        final FragmentManager fragmentManager = getSupportFragmentManager();
        tvLogout = findViewById(R.id.tvLogout);
        tvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.logOut();
                Intent logoutIntent = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(logoutIntent);
                finish();
            }
        });


        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()) {
                    case R.id.action_home:
                        // do something here
                        fragment = new HomeFragment();
                        break;
                    case R.id.action_post:
                        // do something here
                        fragment = new PostFragment();
                        break;
                    case R.id.action_user:
                        // do something here
                        fragment = new ProfileFragment();
                        break;
                    default:
                        fragment = new HomeFragment();
                        fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                        break;
                }
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                return true;

            }
        });
        bottomNavigationView.setSelectedItemId(R.id.action_home);


    }



}