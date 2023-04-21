package com.android.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.IPackageDataObserver;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.RemoteException;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clear(){
        PackageManager pm = getPackageManager();
        List<PackageInfo> packlist = pm.getInstalledPackages(PackageManager.GET_ACTIVITIES);
        for (PackageInfo packageName:packlist) {
            pm.deleteApplicationCacheFiles(packageName.packageName, new IPackageDataObserver.Stub() {
                @Override
                public void onRemoveCompleted(final String packageName, final boolean succeeded) throws
                        RemoteException {
                }
            });
        }
    }
}