package com.example.songhyeonseok.ccs;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by lmiz2 on 2017-10-22.
 */




public class BaseActivity extends AppCompatActivity {//모든 액티비티의 부모 액티비티로, 글로벌 폰트 크기 조절을 위해서 만들어짐.
    public static int Global_FontSize = 15;

    private FirebaseAuth globalAuth;
    private FirebaseUser globalUser;
    private DatabaseReference globalRef;
    private GoogleApiClient globalGApi;
    private FirebaseDatabase globalDB;
    private User LoginUserSession;

    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
    }
    public void setAppFontSize(int size){
        ViewGroup root = (ViewGroup) findViewById(android.R.id.content);
        setGlobalFont(root,size);
    }

    void setGlobalFont(ViewGroup root, int size) {
        for (int i = 0; i < root.getChildCount(); i++) {
            View child = root.getChildAt(i);
            if (child instanceof TextView)
            {                // 크기 조절
                ((TextView)child).setTextSize(size);
            }
            else if (child instanceof ViewGroup)
                setGlobalFont((ViewGroup)child,size);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("LifeCycle","onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCycle","onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("LifeCycle","onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("LifeCycle","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LifeCycle","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycle","onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LifeCycle","onRestart");
    }

    @Override
    public void onLowMemory() {
        logoutUser();
        super.onLowMemory();
        Log.d("LifeCycle","onLowMemory");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.d("LifeCycle","onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("LifeCycle","onRestoreInstanceState");
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return false;
    }

    public void logoutUser(){
        if(globalRef != null && globalUser != null) {
            globalRef.child(globalUser.getUid()).child("connecting").setValue(false);
        }
    }

    public static int getGlobal_FontSize() {
        return Global_FontSize;
    }

    public static void setGlobal_FontSize(int global_FontSize) {
        Global_FontSize = global_FontSize;
    }

    public FirebaseAuth getGlobalAuth() {
        return globalAuth;
    }

    public void setGlobalAuth(FirebaseAuth globalAuth) {
        this.globalAuth = globalAuth;
    }

    public FirebaseUser getGlobalUser() {
        return globalUser;
    }

    public void setGlobalUser(FirebaseUser globalUser) {
        this.globalUser = globalUser;
    }

    public DatabaseReference getGlobalRef() {
        return globalRef;
    }

    public void setGlobalRef(DatabaseReference globalRef) {
        this.globalRef = globalRef;
    }

    public GoogleApiClient getGlobalGApi() {
        return globalGApi;
    }

    public void setGlobalGApi(GoogleApiClient globalGApi) {
        this.globalGApi = globalGApi;
    }

    public FirebaseDatabase getGlobalDB() {
        return globalDB;
    }

    public void setGlobalDB(FirebaseDatabase globalDB) {
        this.globalDB = globalDB;
    }

    public User getLoginUserSession() {
        return LoginUserSession;
    }

    public void setLoginUserSession(User loginUserSession) {
        LoginUserSession = loginUserSession;
    }
}
