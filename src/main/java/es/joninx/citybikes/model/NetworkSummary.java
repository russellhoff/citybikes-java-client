package es.joninx.citybikes.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * Represents a bike {@link Network} summary. Can be used to fetch the whole network.
 * 
 * @author Jon I. (captain06@gmail.com)
 * @since 2020-04-09
 * @version 1.3.1-RELEASE
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NetworkSummary implements Serializable {

	private static final long serialVersionUID = 7966819095019847746L;

	/**
	 * Network's id string
	 */
	private String id = "";
	/**
	 * Network's link
	 */
	private String href = "";
	/**
	 * Networks name
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
		
}
