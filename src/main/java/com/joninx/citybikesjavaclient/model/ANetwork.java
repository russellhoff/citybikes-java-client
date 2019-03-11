package com.joninx.citybikesjavaclient.model;

import java.io.Serializable;
import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ANetwork implements Serializable {


	private static final long serialVersionUID = 4315605074181645263L;
	
	private Optional<NetworkElement> network;
}
