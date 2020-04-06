package es.joninx.citybikesjavaclient.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Network implements Serializable {

	private static final long serialVersionUID = -8160960443199692227L;

	private String id = "";
	private String href = "";
	private String name = "";
	private Set<String> company = new HashSet<>();
	private Location location = new Location();
	private Set<Station> stations = new HashSet<>();
	
	/**
	 * Whether a Network is valid or not is determined by its id's not nullity.
	 * @return Boolean
	 */
	public Boolean isValid() {
		return StringUtils.isNotBlank(id); 
	}
	
	/**
	 * Tells whether a Network owns stations or not.
	 * @return Boolean
	 */
	public Boolean hasStations() {
		return stations.size()>0;
	}
	
}
