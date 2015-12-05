package com.knuplanet.sun._HTTP._SERVICE;

import com.knuplanet.sun._DTO.ResultDTO;

import retrofit.Call;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;

/**
 * Created by ladmusician on 15. 12. 5..
 */
public interface AuthService {
    @Multipart
    @POST("test/loginadas")
    Call<ResultDTO> login(
            @Part("username") String username,
            @Part("password") String password
    );

    @Multipart
    @POST("test/join")
    Call<ResultDTO> join(
            @Part("username") String username,
            @Part("password") String password
    );
}
