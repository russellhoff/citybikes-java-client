package es.joninx.citybikes.model;

import java.io.Serializable;

import org.locationtech.jts.geom.Point;

import es.joninx.citybikes.utility.GeoUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represaents a Location.
 * 
 * @author Jon I. (captain06@gmail.com)
 * @since 2020-04-09
 * @version 1.3.1-RELEASE
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location implements Serializable {

	private static final long serialVersionUID = -270620977105003064L;

	/**
	 * City within the location
	 */
	private String city = "";
	/**
	 * Country where the city belongs
	 */
	private String country = "";
    /**
     * Latitude (WGS84 reference system) 
     */
	private Double latitude = 0d;
    /**
     * Longitude component (WGS84 reference system)
     */
	private Double longitude = 0d;
	
	/**
	 * Creates a new Point based on latitude and longitude attributes.
	 * 
	 * @return The new Point.
	 */
	public Point getPoint() {
		return GeoUtil.createPoint(latitude, longitude);
	}
	
}
