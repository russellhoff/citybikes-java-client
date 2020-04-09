package es.joninx.citybikesjavaclient.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.*;

import es.joninx.citybikes.model.Location;
import es.joninx.citybikes.model.Network;
import es.joninx.citybikes.model.NetworkSummary;
import es.joninx.citybikes.model.Networks;
import es.joninx.citybikes.model.Station;
import es.joninx.citybikes.retrofit.CityBikesClientImpl;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainTest {

	private static CityBikesClientImpl client = new CityBikesClientImpl("http://api.citybik.es/");

	private void testResponseNetworks(Response<Networks> response) {
		Networks networks = response.body();
		assertNotNull(networks);
		List<NetworkSummary> networkSummaries = networks.getNetworks();
		assertTrue(networkSummaries.size()>0);
		networkSummaries.forEach(ns -> {
			System.out.println("Network Summary: " + ns.getId());
			String id = ns.getId();
			assertTrue(StringUtils.isNotBlank(id));
			String name = ns.getName();
			assertTrue(StringUtils.isNotBlank(name));
			String href = ns.getHref();
			assertTrue(StringUtils.isNotBlank(href));
			Location location = ns.getLocation();
			assertNotNull(location);
			String city = location.getCity();
			assertTrue(StringUtils.isNotBlank(city));
			String country = location.getCountry();
			assertTrue(StringUtils.isNotBlank(country));
			Double latitude = location.getLatitude();
			assertNotNull(latitude);
			Double longitude = location.getLongitude();
			assertNotNull(longitude);
		});
	}

	private void testResponseNetwork(Response<Network> response) {
		Network network = response.body();
		if(network.isValid()) {
			System.out.println("Network: " + network.getId());
			assertNotNull(network);
			String id = network.getId();
			assertTrue(StringUtils.isNotBlank(id));
			String name = network.getName();
			assertTrue(StringUtils.isNotBlank(name));
			String href = network.getHref();
			assertTrue(StringUtils.isNotBlank(href));
			Location location = network.getLocation();
			assertNotNull(location);
			String city = location.getCity();
			assertTrue(StringUtils.isNotBlank(city));
			String country = location.getCountry();
			assertTrue(StringUtils.isNotBlank(country));
			Double latitude = location.getLatitude();
			assertNotNull(latitude);
			Double longitude = location.getLongitude();
			assertNotNull(longitude);
			Set<Station> stations = network.getStations();
			assertTrue(stations.size()>0);
			stations.forEach(station -> {
				String nameStation = station.getName();
				assertTrue(StringUtils.isNotBlank(nameStation));
				Integer bikes = station.getBikes();
				assertNotNull(bikes);
				Integer free = station.getFree();
				assertNotNull(free);
				Double latitudeStation = station.getLatitude();
				assertNotNull(latitudeStation);
				Double longitudeStation = station.getLongitude();
				assertNotNull(longitudeStation);
				OffsetDateTime timestamp = station.getTimestamp();
				assertNotNull(timestamp);
				OffsetDateTime thisIsNow = OffsetDateTime.now(ZoneOffset.UTC);
				assertEquals(timestamp.getYear(), thisIsNow.getYear());
				assertEquals(timestamp.getMonth(), thisIsNow.getMonth());
				assertEquals(timestamp.getDayOfMonth(), thisIsNow.getDayOfMonth());
			});
		}else {
			System.err.println("Network " + network.getId() + " is invalid. To string: <<[[ " + network.toString() + " ]]>>");
		}
	}

	@DisplayName("testGetNetworksAsync")
	@Test
	public void testGetNetworksAsync() {
		client.getNetworksAsync(new Callback<Networks>() {

			@Override
			public void onResponse(Call<Networks> call, Response<Networks> response) {
				assertNotNull(response);
				assertTrue(response.isSuccessful());
				if(response.isSuccessful()) 
					testResponseNetworks(response);
				else 
					fail("Networks Async should have been fetched.");
				
			}

			@Override
			public void onFailure(Call<Networks> call, Throwable t) {
				fail("Networks Async should have been fetched.");
			}
			
		});
	}

	@DisplayName("testGetNetworks")
	@Test
	public void testGetNetworks() {
		Response<Networks> response;
		try {
			response = client.getNetworks();
			assertTrue(response.isSuccessful());
			if(response.isSuccessful()) 
				testResponseNetworks(response);
			else
				fail("Networks should have been fetched.");
		
		} catch (IOException e) {
			fail("Networks should have been fetched.");
		}
	}

	@DisplayName("testGetNetworkAsync")
	@Test
	public void testGetNetworkAsync() {
		Response<Networks> responseNetworks;
		try {
			responseNetworks = client.getNetworks();
			assertNotNull(responseNetworks);
			assertTrue(responseNetworks.isSuccessful());
			Networks networks = responseNetworks.body();
			networks.getNetworks().stream().limit(10).forEach(ns -> {
				final String nsId = ns.getId();
				client.getNetworkAsync(ns, new Callback<Network>() {

					@Override
					public void onResponse(Call<Network> call, Response<Network> response) {
						assertNotNull(response);
						assertTrue(response.isSuccessful());
						if(response.isSuccessful())
							testResponseNetwork(response);
						else
							fail("Network Async for " + nsId + " should have been fetched.");
						
					}

					@Override
					public void onFailure(Call<Network> call, Throwable t) {
						fail("Network Async for " + nsId + " should have been fetched. ");
					}
				});
			});
		} catch (IOException e) {
			fail("Networks Async should have been fetched. ");
		}
		
	}

	@DisplayName("testGetNetwork")
	@Test
	public void testGetNetwork() {
		Response<Networks> responseNetworks;
		try {
			responseNetworks = client.getNetworks();
			assertNotNull(responseNetworks);
			assertTrue(responseNetworks.isSuccessful());
			Networks networks = responseNetworks.body();
			networks.getNetworks().stream().limit(10).forEach(ns -> {
				final String nsId = ns.getId();
				try {
					Response<Network> responseNetwork = client.getNetwork(ns);
					assertNotNull(responseNetwork);
					assertTrue(responseNetwork.isSuccessful());
					if(responseNetwork.isSuccessful())
						testResponseNetwork(responseNetwork);
					else
						fail("Network for " + nsId + " should have been fetched.");
				} catch (IOException e) {
					fail("Network for " + nsId + " should have been fetched. ");
				}
			});

		} catch (IOException e) {
			fail("Networks should have been fetched. ");
		}
	}
	
}
