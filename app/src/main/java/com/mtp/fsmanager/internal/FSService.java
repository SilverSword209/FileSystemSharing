package com.mtp.fsmanager.internal;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.mtp.filesystemsharing.MainActivity;

import java.io.File;

public class FSService extends Service {

    LocalFSManager localFsManager;

    public FSService(){
    }

    @Override
    public void onCreate() {



        this.localFsManager = MainActivity.fsManager;
        // Log.d("FS ", localFsManager.serialise());
        File sdcard = new File("/sdcard/");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        localFsManager.startWatching();
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        localFsManager.stopWatching();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
