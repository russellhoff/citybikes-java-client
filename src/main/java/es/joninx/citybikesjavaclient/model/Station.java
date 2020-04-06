package es.joninx.citybikesjavaclient.model;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * A base class to name a bike sharing Station. It can be:
 *        - Specific (cities):
 *           - BicingStation, VelibStation, ...
 *       - General (companies):
 *           - JCDecauxStation, ClearChannelStation
 * 
 * @author sanch
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Station implements Serializable {

	private static final long serialVersionUID = 226448043962916066L;

	protected String name;
	protected Double latitude;
	protected Double longitude;
	protected Integer bikes;
	protected Integer free;
	protected OffsetDateTime timestamp = OffsetDateTime.now(ZoneOffset.UTC);
	protected List<Extra> extra;
	
	/**
	 * Base update method for BikeShareStation, any subclass can override this method, and should/could call it from inside
	 */
	protected void update() {
		timestamp = OffsetDateTime.now(ZoneOffset.UTC);
	}
	
	@Override
	public String toString() {
		return new StringBuilder()
				.append("--- ").append(name).append(" ---\\n")
				.append("bikes: ").append(bikes).append("\\n")
				.append("free: ").append(free).append("\\n")
				.append("latlng: ").append(latitude).append(",").append(longitude).append("\\n")
				.append("extra: ").append(extra)
				.toString();
	}
}
