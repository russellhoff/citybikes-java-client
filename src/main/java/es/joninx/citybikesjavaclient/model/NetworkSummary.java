package es.joninx.citybikesjavaclient.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NetworkSummary implements Serializable {

	private static final long serialVersionUID = 7966819095019847746L;

	private String id = "";
	private String href = "";
	private String name = "";
	private Set<String> company = new HashSet<>();
	private Location location = new Location();
	
	
}
