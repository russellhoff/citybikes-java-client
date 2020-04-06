package es.joninx.citybikesjavaclient.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Networks implements Serializable {

	private static final long serialVersionUID = 7851178075771352967L;

	private List<NetworkSummary> networks = new ArrayList<>();
	
}
