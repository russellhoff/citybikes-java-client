package com.joninx.citybikesjavaclient.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location implements Serializable {
	
	private static final long serialVersionUID = -3677187144169062252L;
	
	private String city;
	private String country;
	private Double latitude;
	private Double longitude;
}
