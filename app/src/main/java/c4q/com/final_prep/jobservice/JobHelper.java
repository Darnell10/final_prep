package c4q.com.final_prep.jobservice;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;

import c4q.com.final_prep.jobservice.UserJobScheduler;

/**
 * Created by D on 2/22/18.
 */

public class JobHelper  {


    @RequiresApi(api = Build.VERSION_CODES.M)
    public static void scheduleJob(Context context){

        ComponentName serviceComponent = new ComponentName(context,UserJobScheduler.class);

        JobInfo.Builder jobBuilder = new JobInfo.Builder(1,serviceComponent);
        //Sets timer for job
        jobBuilder.setOverrideDeadline(3000);
        // Lets job know to continue once service is back.
        jobBuilder.setPersisted(true);

        //using this to schedule job.
        JobScheduler jobScheduler = context.getSystemService(JobScheduler.class);

        if(jobScheduler != null){
            jobScheduler.schedule(jobBuilder.build());

        }

    }


}
