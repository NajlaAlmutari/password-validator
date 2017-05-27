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

        public static int Stage2ValidatingPassword(String password) {
            int MatchingRules = 0;
            // to get the 2 matching rules from stage1
            MatchingRules += Stage1ValidatingPassword(password);

            // test the password for both upper and lower case characters
            if (Pattern.compile("[a-z]").matcher(password).find() && Pattern.compile("[A-Z]").matcher(password).find() ) {
                System.out.println("Upper lower for " + password);
                MatchingRules++;
            }
            // test the password if it has at-least one digit
            if (Pattern.compile("[0-9]").matcher(password).find()) {
                System.out.println("Digit for " + password);
                MatchingRules++;
            }
            // test the password if it has at-least one special character   @,!,&, #,$
            if (password.indexOf('@') != -1 || password.indexOf('!') != -1  || password.indexOf('&') != -1 || password.indexOf('#') != -1|| password.indexOf('$') != -1) {
                MatchingRules++;
            }
            return MatchingRules;
        }
    }


            }




