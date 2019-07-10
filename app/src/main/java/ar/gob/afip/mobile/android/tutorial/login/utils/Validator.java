package ar.gob.afip.mobile.android.tutorial.login.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    static Pattern emailPtn = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,15})");
    static Pattern passPtn = Pattern.compile("((?=.*\\d)(?=.+[a-z])(?=.+[A-Z]).{10,50})");

    static public boolean validateEmail(String email){
        Matcher match = emailPtn.matcher(email);
        return email.contains("@") && email.contains(".");
        //return match.matches();

    }
    static public boolean validatePassword(String pass){
        Matcher match = passPtn.matcher(pass);
        return pass.length() >= 10 && match.matches();

    }
}
