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
public class Extra implements Serializable {

	private static final long serialVersionUID = 561651487901712655L;
	
	private String uid;
	private Integer slots;
	private String number;
	@JsonProperty("bike_uids") private List<String> bikeUids;
}
