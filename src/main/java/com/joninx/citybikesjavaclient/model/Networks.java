package com.joninx.citybikesjavaclient.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Networks implements Serializable {
	
	private static final long serialVersionUID = -5844242567735934304L;
	
	private List<Network> networks;
}
