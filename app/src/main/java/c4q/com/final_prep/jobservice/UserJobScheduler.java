package c4q.com.final_prep.jobservice;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.widget.Toast;

/**
 * Created by D on 2/22/18.
 */

public class UserJobScheduler extends JobService {


    public UserJobScheduler() {
        super();
    }

    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        Toast.makeText(this, "your battery is low!!!", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
