package com.joninx.citybikesjavaclient.retrofit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joninx.citybikesjavaclient.config.ProjectConfig;
import com.joninx.citybikesjavaclient.jackson.JacksonFactory;
import com.joninx.citybikesjavaclient.model.ANetwork;
import com.joninx.citybikesjavaclient.model.Networks;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * This is the main class from which make requests to the API.
 * 
 * @author Jon Inazio (captain06@gmail.com)
 *
 */
public class CityBikesClient {
	
	private static final Logger log = LogManager.getLogger(CityBikesClient.class);
	
	private String baseUrl;
	
	private Retrofit retrofit;
	private CityBikesService cityBikesService;

	private ObjectMapper mapper;

	public CityBikesClient() {
		log.debug("new CityBikesClient()");
		JacksonFactory jacksonFactory = JacksonFactory.getInstance();
		this.mapper = jacksonFactory.getMapper();
		
		ProjectConfig config = ProjectConfig.getInstance();
		this.baseUrl = config.getBaseUrl();
		
		HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
		logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

		OkHttpClient client = new OkHttpClient.Builder()
			    .addInterceptor(logInterceptor)
			    .build();
		JacksonConverterFactory fac = JacksonConverterFactory.create(mapper);

		retrofit = new Retrofit.Builder()
			    .baseUrl(baseUrl)
			    .client(client)
			    .addConverterFactory(fac)
			    .build();

		cityBikesService = retrofit.create(CityBikesService.class);
	}
	
	/**
	 * Asynchronous method to fetch every Network of the whole world.
	 * 
	 * @param pCallback Callback to listen for the answer.
	 */
	public void getNetworks(Callback<Networks> pCallback) {
		log.debug("getNetworks()");
		Call<Networks> call = cityBikesService.networks();
		call.enqueue(pCallback);
	}

	/**
	 * Asynchronous method to fetch a network data.
	 * 
	 * @param pNetworkId Network's ID. May not exist, so the ANetwork object will have an empty Optional attribute.
	 * @param pCallback Callback to listen for the answer.
	 */
	public void getNetwork(String pNetworkId, Callback<ANetwork> pCallback) {
		log.debug("getNetwork()");
		Call<ANetwork> call = cityBikesService.network(pNetworkId);
		call.enqueue(pCallback);
	}
	
}
