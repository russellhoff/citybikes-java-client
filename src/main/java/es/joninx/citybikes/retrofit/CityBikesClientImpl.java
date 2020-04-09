package es.joninx.citybikes.retrofit;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.joninx.citybikes.jackson.JacksonFactory;
import es.joninx.citybikes.model.Network;
import es.joninx.citybikes.model.NetworkSummary;
import es.joninx.citybikes.model.Networks;
import lombok.extern.log4j.Log4j2;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * 
 * Citybikes client implementation
 * 
 * @author Jon I. (captain06@gmail.com)
 * @since 2020-04-09
 * @version 1.3.1-RELEASE
 *
 */
@Log4j2
public class CityBikesClientImpl {

	/**
	 * Base URL.
	 */
	private String baseUrl;
	/**
	 * Retrofit object.
	 */
	private Retrofit retrofit;
	/**
	 * Jackson's object mapper.
	 */
	private ObjectMapper mapper;
	/**
	 * Citybikes client interface.
	 */
	private CityBikesClient client;
	
	/**
	 * Class constructor.
	 * 
	 * @param pBaseUrl Citybikes API's base url. E.g. http://api.citybik.es/
	 */
	public CityBikesClientImpl(String pBaseUrl) {
		log.debug("new CityBikesClient({})", pBaseUrl);
		JacksonFactory jacksonFactory = JacksonFactory.getInstance();
		this.mapper = jacksonFactory.getMapper();
		
		this.baseUrl = pBaseUrl;
		
		HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
		logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

		OkHttpClient okhttpClient = new OkHttpClient.Builder()
			    .addInterceptor(logInterceptor)
			    .build();
		JacksonConverterFactory fac = JacksonConverterFactory.create(mapper);

		retrofit = new Retrofit.Builder()
			    .baseUrl(baseUrl)
			    .client(okhttpClient)
			    .addConverterFactory(fac)
			    .build();
		
		this.client = retrofit.create(CityBikesClient.class);
	}
	
	/**
	 * Get networks (network summaries list) in an asynchronous way.
	 * 
	 * @param pCallback The callback
	 */
	public void getNetworksAsync(Callback<Networks> pCallback) {
		Call<Networks> call = client.networks();
		call.enqueue(pCallback);
	}
	
	/**
	 * Fetches the networks synchronously.
	 * 
	 * @return Response containing Networks
	 * @throws IOException If a problem occurred talking to the server.
	 */
	public Response<Networks> getNetworks() throws IOException {
		Call<Networks> call = client.networks();
		return call.execute();
	}
	
	/**
	 * Gets a network's information asynchronously based on a network summary.
	 * 
	 * @param pNetworkSummary Network summary fetched from the API previously.
	 * @param pCallback The callback
	 */
	public void getNetworkAsync(NetworkSummary pNetworkSummary, Callback<Network> pCallback) {
		String networkId = pNetworkSummary.getId();
		Call<Network> call = client.network(networkId);
		call.enqueue(pCallback);
	}

	/**
	 * Gets a network's information synchronously based on a summary.
	 * 
	 * @param pNetworkSummary Network summary fetched from the API previously.
	 * @return Response containing Networks
	 * @throws IOException If a problem occurred talking to the server.
	 */
	public Response<Network> getNetwork(NetworkSummary pNetworkSummary) throws IOException {
		String networkId = pNetworkSummary.getId();
		Call<Network> call = client.network(networkId);
		return call.execute();
	}
	
}
