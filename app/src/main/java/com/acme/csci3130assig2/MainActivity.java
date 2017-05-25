package com.acme.csci3130assig2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    static class UserPasswordValidator {

        static int Stage1ValidatingPassword(String password) {
            if (password == null || password.isEmpty()) {
                return 0;
            }
            int MatchingRules = 0;

            // test if string is not password
            if (!password.equalsIgnoreCase("PASSWORD")) {
                MatchingRules++;
            }

            // test if string is at-least 8 character long
            if (password.length() >= 8) {
                MatchingRules++;
            }

            return MatchingRules;
        }
}
}
