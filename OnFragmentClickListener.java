package com.smart.school.Main.activity;

public interface OnFragmentClickListener {
    void onFragmentClick(int id);
    void onFragmentClick(int id, String... str);
    void onFragmentClick(int id, int pos);
    void onFragmentClick(int id, Object object);
    void onFragmentClick(String id, String str);
    void onFragmentClick(int id, int pos, Object object);
}
