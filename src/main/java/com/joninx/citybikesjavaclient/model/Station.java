package com.joninx.citybikesjavaclient.model;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Station implements Serializable {

	private static final long serialVersionUID = -7550726726908014634L;

	private String id;
	private String name;
	private ZonedDateTime timestamp;
	private Double longitude;
	private Double latitude;
	private Integer free_bikes;
	@JsonProperty("empty_slots") private Integer emptySlots;
	private List<Extra> extra;
	
}
