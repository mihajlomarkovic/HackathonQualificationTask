package com.example.mihajlo.hackathonqualificationtaskapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mihajlo.hackathonqualificationtaskapp.R;
import com.google.firebase.auth.FirebaseAuth;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;

@OptionsMenu(R.menu.signout)
@EActivity(R.layout.activity_home)
public class HomeActivity extends AppCompatActivity {

    private static final int LOGIN_REQUEST_CODE = 42;

    @AfterViews
    void init() {
        // if no user is logged in
        if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            LoginActivity_.intent(this).start();
        }
    }

    @OptionsItem
    void signOut() {
        FirebaseAuth.getInstance().signOut();

        // restart this activity after user is logged out because if there is no user we will start
        // login activity
        final Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
}
