package es.joninx.citybikes.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.locationtech.jts.geom.Point;

import es.joninx.citybikes.utility.GeoUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * Meta information, used within the {@link System} class.
 * 
 * @author Jon I. (captain06@gmail.com)
 * @since 2020-04-09
 * @version 1.3.1-RELEASE
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Meta implements Serializable {

	private static final long serialVersionUID = 3148276534542258035L;

	/**
	 * System string
	 */
	private String system;
	/**
	 * Name
	 */
	private String name;
	/**
	 * City name
	 */
	private String city;
	/**
	 * Country name
	 */
    private String country;
    /**
     * Latitude (WGS84 reference system) 
     */
    private Double latitude;
    /**
     * Longitude component (WGS84 reference system)
     */
    private Double longitude;
    /**
     * Company list
     */
    private List<String> company = new ArrayList<>();
	
    /**
     * Adds a company to the company list if does not exist.
     * 
     * @param pCompany Company string
     */
    public void addCompany(String pCompany) {
    	if(!company.contains(pCompany))
    		company.add(pCompany);
    }

	/**
	 * Creates a new Point based on latitude and longitude attributes.
	 * 
	 * @return The new Point.
	 */
	public Point getPoint() {
		return GeoUtil.createPoint(latitude, longitude);
	}
	
}
