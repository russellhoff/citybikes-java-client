package es.joninx.citybikesjavaclient.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A base class to name a bike sharing System. It can be:
 *       - Specific (cities):
 *           - Bicing, Velib, ...
 *       - General (companies):
 *           - JCDecaux, ClearChannel
 *       At the same time, these classes can extend their base class,
 *       for example, Velib extends Smovengo extends BikeShareSystem.
 *       This class might or not have METADATA assigned, usually intended
 *       for specific cases. This METADATA is dict / json formatted.
 * @author sanch
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class System implements Serializable {

	private static final long serialVersionUID = 2688002163907129460L;

	protected List<Station> stations = new ArrayList<>();
	protected String tag;
	protected Meta meta = new Meta();
	protected Boolean sync = true;
	protected Boolean authed = false;
	protected Boolean unifeed = false;
	private String feedUrl;
	
	public void setMetaName(String pName) {
		this.meta.setName(pName);
	}

	public void setMetaCity(String pCity) {
		this.meta.setCity(pCity);
	}

	public void setMetaCountry(String pCountry) {
		this.meta.setCountry(pCountry);
	}

	public void addMetaCompany(String pCompany) {
		this.meta.addCompany(pCompany);
	}

	public void setMetaLatitude(Double pLatitude) {
		this.meta.setLatitude(pLatitude);
	}

	public void setMetaLongitude(Double pLongitude) {
		this.meta.setLongitude(pLongitude);
	}

	public void setMetaSystem(String pSystem) {
		this.meta.setSystem(pSystem);
	}
	
	@Override
	public String toString() {
		return new StringBuilder()
				.append("tag : ").append(tag).append("\\n")
				.append("meta: ").append(meta.toString())
				.toString();
	}
	
}
