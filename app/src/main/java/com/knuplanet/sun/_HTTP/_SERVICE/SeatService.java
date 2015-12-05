package com.knuplanet.sun._HTTP._SERVICE;

import com.knuplanet.sun._DTO.ResultDTO;

import retrofit.Call;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;

/**
 * Created by ladmusician on 15. 12. 5..
 */
public interface SeatService {
    @Multipart
    @POST("test/login")
    Call<ResultDTO> login(@Part("username") String username, @Part("password") String password);
}
