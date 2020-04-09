package es.joninx.citybikes.model;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

import org.locationtech.jts.geom.Point;

import es.joninx.citybikes.utility.GeoUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * Represents a bike sharing Station. 
 *      
 * @author Jon I. (captain06@gmail.com)
 * @since 2020-04-09
 * @version 1.3.1-RELEASE
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Station implements Serializable {

	private static final long serialVersionUID = 226448043962916066L;

	/**
	 * The name of the station.
	 */
	private String name;
	/**
	 * Latitude component (WGS84 reference system).
	 */
	private Double latitude;
	/**
	 * Longitude component (WGS84 reference system).
	 */
	private Double longitude;
	/**
	 * Available number of bikes to be taken.
	 */
	private Integer bikes;
	/**
	 * Available slots to leave a bike in.
	 */
	private Integer free;
	/**
	 * Latest update timestamp (UTC time).
	 */
	private OffsetDateTime timestamp = OffsetDateTime.now(ZoneOffset.UTC);
	/**
	 * Extra information.
	 */
	private List<Extra> extra;

	/**
	 * Creates a new Point based on latitude and longitude attributes.
	 * 
	 * @return The new Point.
	 */
	public Point getPoint() {
		return GeoUtil.createPoint(latitude, longitude);
	}
	
}
