package com.joninx.citybikesjavaclient.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NetworkElement implements Serializable {
	
	private static final long serialVersionUID = -8252785296160608489L;

	private String id;
	private String name;
	private List<Station> stations;
	private List<String> company;
	@JsonProperty("gbfs_href") private String gbfsHref;
	private String href;
	private Location location;
	
}
