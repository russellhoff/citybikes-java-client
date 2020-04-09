package es.joninx.citybikes.model;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Extra information, not widely used.
 * 
 * @author Jon I. (captain06@gmail.com)
 * @since 2020-04-09
 * @version 1.3.1-RELEASE
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Extra implements Serializable {

	private static final long serialVersionUID = -7996779883770668821L;
	
	private String uid;
	private Boolean status;
	private Integer slots;
	private String number;
	private String address;
	private String placement;
	private String name;
	private String terminalName;
	private Boolean locked;
	private Boolean installed;
	private Boolean temporary;
	private OffsetDateTime installDate;
	private OffsetDateTime removalDate;
	private List<String> bikeUids;
	private String statusValue;
	private String statusKey;
	private String stAddress1;
	private String stAddress2;
	private String city;
	private String postalCode;
	private String location;
	private Double altitude;
	private String testStation;
	private String lastCommunicationTime;
	private String landMark;
	private Integer totalDocks;
	@JsonProperty(value = "public") private Boolean dataPublic;
	private OffsetDateTime latestUpdateTime;
	private Boolean online;
	private Boolean hasEbikes;
	private Integer ebikes;
	private Float score;
	private Integer reviews;
	private String light;
	private Boolean closed;
	private String type;
	private String picture;
	
}
