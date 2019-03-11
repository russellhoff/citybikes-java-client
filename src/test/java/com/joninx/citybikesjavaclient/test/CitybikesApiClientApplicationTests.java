package com.joninx.citybikesjavaclient.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.joninx.citybikesjavaclient.model.ANetwork;
import com.joninx.citybikesjavaclient.model.Network;
import com.joninx.citybikesjavaclient.model.NetworkElement;
import com.joninx.citybikesjavaclient.model.Networks;
import com.joninx.citybikesjavaclient.retrofit.CityBikesClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CitybikesApiClientApplicationTests {

	private static CityBikesClient client;
	
	@BeforeAll
	static void setup() {
		client = new CityBikesClient();
	}
	
	@DisplayName("networks")
	@Test
	public void networks() {
		
		client.getNetworks(new Callback<Networks>() {

			@Override
			public void onResponse(Call<Networks> call, Response<Networks> response) {
				assertTrue(response.isSuccessful());
				if(response.isSuccessful()) {
					Networks networks = response.body();
					assertNotNull(networks);
					List<Network> networksList = networks.getNetworks();
					assertTrue(networksList.size()>0);
					networksList.forEach(n -> {
						assertTrue(StringUtils.isNotBlank(n.getId()));
					});
				}else {
					fail("This should not happen.");
				}
			}

			@Override
			public void onFailure(Call<Networks> call, Throwable t) {
				fail("This should not happen.");
			}
			
		});
		
	}

	@DisplayName("existingNetwork")
	@Test
	public void existingNetwork() {
		client.getNetwork("bilbon-bizi", new Callback<ANetwork>() {

			@Override
			public void onResponse(Call<ANetwork> call, Response<ANetwork> response) {
				if(response.isSuccessful()) {
					ANetwork aNetwork = response.body();
					assertNotNull(aNetwork);
					Optional<NetworkElement> opt = aNetwork.getNetwork();
					assertTrue(opt.isPresent());
					NetworkElement networkElement = opt.get();
					assertNotNull(networkElement);
					assertTrue(StringUtils.isNotBlank(networkElement.getId()));
				}else {
					fail("This should not happen.");
				}
			}

			@Override
			public void onFailure(Call<ANetwork> call, Throwable t) {
				fail("This should not happen.");
			}
			
		});
	}

	@DisplayName("notExistingNetwork")
	@Test
	public void notExistingNetwork() {
		client.getNetwork("asada", new Callback<ANetwork>() {

			@Override
			public void onResponse(Call<ANetwork> call, Response<ANetwork> response) {
				if(response.isSuccessful()) {
					ANetwork aNetwork = response.body();
					assertNotNull(aNetwork);
					Optional<NetworkElement> opt = aNetwork.getNetwork();
					assertFalse(opt.isPresent());
				}else {
					fail("This should not happen.");
				}
			}

			@Override
			public void onFailure(Call<ANetwork> call, Throwable t) {
				fail("This should not happen.");
			}
			
		});
	}
	
}
