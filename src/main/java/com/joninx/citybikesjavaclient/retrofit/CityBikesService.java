package com.joninx.citybikesjavaclient.retrofit;

import com.joninx.citybikesjavaclient.model.ANetwork;
import com.joninx.citybikesjavaclient.model.Networks;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CityBikesService {

	@GET("v2/networks")
	Call<Networks> networks();

	@GET("v2/networks/{network_id}")
	Call<ANetwork> network(@Path("network_id") String pNetworkId);
	
}
