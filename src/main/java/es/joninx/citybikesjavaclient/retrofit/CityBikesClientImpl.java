package es.joninx.citybikesjavaclient.retrofit;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.joninx.citybikesjavaclient.jackson.JacksonFactory;
import es.joninx.citybikesjavaclient.model.Network;
import es.joninx.citybikesjavaclient.model.NetworkSummary;
import es.joninx.citybikesjavaclient.model.Networks;
import lombok.extern.log4j.Log4j2;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Log4j2
public class CityBikesClientImpl {

	private String baseUrl;
	private Retrofit retrofit;
	private ObjectMapper mapper;
	private CityBikesClient client;
	
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
	
	public void getNetworksAsync(Callback<Networks> pCallback) {
		Call<Networks> call = client.networks();
		call.enqueue(pCallback);
	}
	
	public Response<Networks> getNetworks() throws IOException {
		Call<Networks> call = client.networks();
		return call.execute();
	}
	
	public void getNetworkAsync(NetworkSummary pNetworkSummary, Callback<Network> pCallback) {
		String networkId = pNetworkSummary.getId();
		Call<Network> call = client.network(networkId);
		call.enqueue(pCallback);
	}

	public Response<Network> getNetwork(NetworkSummary pNetworkSummary) throws IOException {
		String networkId = pNetworkSummary.getId();
		Call<Network> call = client.network(networkId);
		return call.execute();
	}
	
}
