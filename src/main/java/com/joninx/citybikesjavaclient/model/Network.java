package com.joninx.citybikesjavaclient.model;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Network implements Serializable {

	private static final long serialVersionUID = 760581121266679259L;

	private String id;
	private List<String> company;
	@JsonProperty("gbfs_href") private String gbfsHref;
	private String href;
	private Location location;
	private String name;
	private Optional<String> source;
	
}
