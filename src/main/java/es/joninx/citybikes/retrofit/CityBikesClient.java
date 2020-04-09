package es.joninx.citybikes.retrofit;

import es.joninx.citybikes.model.Network;
import es.joninx.citybikes.model.Networks;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * API interface.
 * 
 * @author Jon I. (captain06@gmail.com)
 * @since 2020-04-09
 * @version 1.3.1-RELEASE
 *
 */
public interface CityBikesClient {

	@GET("v2/networks")
	Call<Networks> networks();
	
	@GET("v2/networks/{network_id}")
	Call<Network> network(@Path("network_id") String pNetworkId);
	
}
