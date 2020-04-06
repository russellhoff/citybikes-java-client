package es.joninx.citybikesjavaclient.retrofit;

import es.joninx.citybikesjavaclient.model.Network;
import es.joninx.citybikesjavaclient.model.Networks;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CityBikesClient {

	@GET("v2/networks")
	Call<Networks> networks();
	
	@GET("v2/networks/{network_id}")
	Call<Network> network(@Path("network_id") String pNetworkId);
	
}
