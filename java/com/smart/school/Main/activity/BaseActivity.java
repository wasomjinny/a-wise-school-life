package com.smart.school.Main.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.smart.school.app.config.Config;
import com.smart.school.app.config.iConfig;
import com.smart.school.network.APIService;

import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class BaseActivity extends AppCompatActivity implements Response.Listener, Response.ErrorListener {

    Context mContext;
    public AbstractHttpClient mHttpClient;

    protected Config config = Config.getInstance();


    public static ArrayList<AppCompatActivity> activities = new ArrayList<>();

    //kimokwoophp.godohostin.com/school/api 접속용
    protected Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(iConfig.SERVER_URL_REAL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    //firebase 접속용
    protected Retrofit retrofit3 = new Retrofit.Builder()
            .baseUrl(iConfig.SERVER_URL_REAL1)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    protected APIService apiService = retrofit.create(APIService.class);
    protected APIService apiService3 = retrofit3.create(APIService.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mHttpClient = new DefaultHttpClient();

    }

    protected void onBackClick(){

    }


    @Override
    public void onResponse(Object response) {
    }

    public void onCustomResponse(String response, String tag) {

    }

    public void onPosResponse(String response, String tag) {

    }

    @Override
    public void onErrorResponse(VolleyError error) {
    }

    public void checkPermission(String[] permissions, int request) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            boolean checkPermission = hasPermissions(this, permissions);
            // 이 권한을 필요한 이유를 설명해야하는가?
            if (!checkPermission) {
                requestPermissions(permissions, request);
            }
        }
    }

    public static boolean hasPermissions(Context context, String... permissions) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (String permission : permissions) {
                /*
                 * 권한이 설정이 되었는지 여부 check 하는 method, 즉 어제 권한설정이 되었어도 오늘 사용자가 권한을 꺼놓았을 수도 있으니깐 Run 하기 전에 Check하는 메소드다.
                 * check 되어있으면 PackageManager.PERMISSION_GRANTED 를 Return한다. 아닐 경우 PERMISSION_DENIED 를 Return 한다 .
                 */
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                } else if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_DENIED) {
                    return true;
                }
            }
        }
        return true;
    }



    public void setActivities(){
        activities = new ArrayList<>();
    }

    public ArrayList<AppCompatActivity> getActivities(){
        return activities;
    }



    // This method  converts String to RequestBody
    protected RequestBody toRequestBody (String value) {
        return RequestBody.create(MediaType.parse("text/plain"), value);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == iConfig.REQUEST_CHECK_SETTINGS){
            switch(resultCode){
                case RESULT_OK: {
                    Toast.makeText(this, "위치 사용 가능", Toast.LENGTH_SHORT).show();
                }
                break;

                case RESULT_CANCELED: {
                }
                break;
            }
        }
    }
}
