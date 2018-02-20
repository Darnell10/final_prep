package c4q.com.final_prep;

import c4q.com.final_prep.modelclasses.Response;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by D on 2/18/18.
 */

public interface UserService {
    // https://randomuser.me/api/?nat=us&inc=name,location,cell,email,dob,picture&results=20

    @GET("api/?nat=us&inc=name,location,cell,email,dob,picture&results=20")
    Call<Response>getUser();
}
