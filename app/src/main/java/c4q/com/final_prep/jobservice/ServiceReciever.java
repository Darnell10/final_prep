package c4q.com.final_prep.jobservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.Objects;

/**
 * Created by D on 2/22/18.
 */

public class ServiceReciever extends BroadcastReceiver {


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onReceive(Context context, Intent intent) {
        if(Objects.equals(intent.getAction(),Intent.ACTION_BATTERY_LOW)){
            JobHelper.scheduleJob(context);
        }

    }
}
