package es.joninx.citybikes.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a bike sharing System. 
 * 
 * @author Jon I. (captain06@gmail.com)
 * @since 2020-04-09
 * @version 1.3.1-RELEASE
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class System implements Serializable {

	private static final long serialVersionUID = 2688002163907129460L;

	/**
	 * System's station list.
	 */
	private List<Station> stations = new ArrayList<>();
	/**
	 * Associated tag.
	 */
	private String tag;
	/**
	 * Meta information.
	 */
	private Meta meta = new Meta();
	/**
	 * Tells whether it's synchronized or not.
	 */
	private Boolean sync = true;
	/**
	 * Authed attribute.
	 */
	private Boolean authed = false;
	/**
	 * Unifeed attribute.
	 */
	private Boolean unifeed = false;
	/**
	 * The URL from which the data may be fetched.
	 */
	private String feedUrl;
	
	/**
	 * Sets Meta's name
	 * 
	 * @param pName Meta's new name
	 */
	public void setMetaName(String pName) {
		this.meta.setName(pName);
	}

	/**
	 * Sets Meta's city
	 * 
	 * @param pCity Meta's new city
	 */
	public void setMetaCity(String pCity) {
		this.meta.setCity(pCity);
	}

	/**
	 * Sets Meta's country
	 * 
	 * @param pCountry Meta's new country
	 */
	public void setMetaCountry(String pCountry) {
		this.meta.setCountry(pCountry);
	}

	/**
	 * Sets Meta's company
	 * 
	 * @param pCompany Meta's new company
	 */
	public void addMetaCompany(String pCompany) {
		this.meta.addCompany(pCompany);
	}

	/**
	 * Sets Meta's latitude
	 * 
	 * @param pLatitude Meta's new latitude
	 */
	public void setMetaLatitude(Double pLatitude) {
		this.meta.setLatitude(pLatitude);
	}

	/**
	 * Sets Meta's longitude
	 * 
	 * @param pLongitude Meta's new longitude
	 */
	public void setMetaLongitude(Double pLongitude) {
		this.meta.setLongitude(pLongitude);
	}

	/**
	 * Sets Meta's system
	 * 
	 * @param pSystem Meta's new system
	 */
	public void setMetaSystem(String pSystem) {
		this.meta.setSystem(pSystem);
	}
	
}
