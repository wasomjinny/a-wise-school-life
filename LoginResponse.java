package com.smart.school.school.item;


/**
 * Created by 외주1 on 2017-08-03.
 */


public class LoginResponse {
    public int code;
    public String message;
    public LoginItem result;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public LoginItem getResult() {
        return result;
    }
}
