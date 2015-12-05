package com.knuplanet.sun._HTTP;

import com.knuplanet.sun._HTTP._SERVICE.AuthService;
import com.knuplanet.sun._HTTP._SERVICE.SeatService;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by ladmusician on 15. 12. 5..
 */
public class RetrofitManager {
    private static  Retrofit mRetrofit =null;
    public final static String BASE_URL = "http://goqual.com/GOQUAL/API/";

    public static AuthService mAuthServiceInstance = null;
    public static SeatService mSeatServiceInstance = null;

    private static Retrofit getRetrofitBuilder() {
        if (mRetrofit == null) {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return mRetrofit;
    }

    public static AuthService getAuthService (){
        if(mAuthServiceInstance== null){
            mAuthServiceInstance = getRetrofitBuilder().create(AuthService.class);
        }

        return mAuthServiceInstance;
    }

    public static SeatService getSeatService (){
        if(mSeatServiceInstance== null){
            mSeatServiceInstance = getRetrofitBuilder().create(SeatService.class);
        }

        return mSeatServiceInstance;
    }
}
