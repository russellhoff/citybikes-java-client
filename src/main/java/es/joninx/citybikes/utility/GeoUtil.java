package es.joninx.citybikes.utility;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.PrecisionModel;

/**
 * Utility class to aid you to build geospatial objects. Currently only supporting WGS84 reference system.
 * 
 * @author Jon I. (captain06@gmail.com)
 * @since 2020-04-09
 * @version 1.3.1-RELEASE
 *
 */
public class GeoUtil {

	/**
	 * WGS84 Geometry Factory.
	 */
	private static GeometryFactory factory4326 = new GeometryFactory(new PrecisionModel(PrecisionModel.FLOATING), 4326);

	/**
	 * Creates a raw Coordinate.
	 * 
	 * @param pLatitude The latitude
	 * @param pLongitude The longitude
	 * 
	 * @return A new Coordinate.
	 */
	public static Coordinate createCoordinate(Double pLatitude, Double pLongitude){
		return new Coordinate(pLongitude, pLatitude);
	}
		
	/**
	 * Creates a new {@link org.locationtech.jts.geom.Point} using the WGS84 geometry factory.
	 * 
	 * @param pLatitude The latitude
	 * @param pLongitude The longitude
	 * 
	 * @return A new {@link org.locationtech.jts.geom.Point}
	 */
	public static Point createPoint(Double pLatitude, Double pLongitude){
		return factory4326.createPoint(createCoordinate(pLatitude, pLongitude));
	}
	
	/**
	 * Creates a new {@link org.locationtech.jts.geom.LineString} based on a {@link org.locationtech.jts.geom.Coordinate} array.
	 * 
	 * @param pCoordsArray Coords array
	 * 
	 * @return A new {@link org.locationtech.jts.geom.LineString}
	 */
	public static LineString createLineString(Coordinate[] pCoordsArray){
		return factory4326.createLineString(pCoordsArray);
	}
	
}
