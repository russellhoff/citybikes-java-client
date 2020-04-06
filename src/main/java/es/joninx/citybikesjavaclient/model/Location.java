package es.joninx.citybikesjavaclient.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location implements Serializable {

	private static final long serialVersionUID = -270620977105003064L;

	private String city = "";
	private String country = "";
	private Double latitude = 0d;
	private Double longitude = 0d;
	
}
