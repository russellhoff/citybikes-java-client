package es.joninx.citybikes.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.locationtech.jts.geom.Point;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * Represents a Network.
 * 
 * @author Jon I. (captain06@gmail.com)
 * @since 2020-04-09
 * @version 1.3.1-RELEASE
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Network implements Serializable {

	private static final long serialVersionUID = -8160960443199692227L;

	/**
	 * Network's id string
	 */
	private String id = "";
	/**
	 * Network's link
	 */
	private String href = "";
	/**
	 * Network's name
	 */
	private String name = "";
	/**
	 * Network's companies
	 */
	private Set<String> company = new HashSet<>();
	/**
	 * Network's location
	 */
	private Location location = new Location();
	/**
	 * Network's stations
	 */
	private Set<Station> stations = new HashSet<>();
	
	/**
	 * Whether a Network is valid or not is determined by its id's not nullity.
	 * 
	 * @return Boolean Valid or not
	 */
	public Boolean isValid() {
		return StringUtils.isNotBlank(id); 
	}
	
	/**
	 * Tells whether a Network owns stations or not.
	 * 
	 * @return Boolean Whether it has stations or not
	 */
	public Boolean hasStations() {
		return stations.size()>0;
	}
	
	/**
	 * Returns the point of the location.
	 * 
	 * @return org.locationtech.jts.geom.Point
	 */
	public Point getLocationPoint() {
		return location.getPoint();
	}
	
}
