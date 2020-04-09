package es.joninx.citybikes.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Comprises a list of {@link Network} summaries.
 *
 * @author Jon I. (captain06@gmail.com)
 * @since 2020-04-09
 * @version 1.3.1-RELEASE
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Networks implements Serializable {

	private static final long serialVersionUID = 7851178075771352967L;

	/**
	 * Network summaries
	 */
	private List<NetworkSummary> networks = new ArrayList<>();
	
}
