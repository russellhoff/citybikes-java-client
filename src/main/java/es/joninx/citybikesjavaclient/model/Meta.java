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
public class Meta implements Serializable {

	private static final long serialVersionUID = 3148276534542258035L;

	private String system;
	private String name;
	private String city;
    private String country;
    private Double latitude;
    private Double longitude;
    private List<String> company = new ArrayList<>();
	
    public void addCompany(String pCompany) {
    	company.add(pCompany);
    }
    
    @Override
    public String toString() {
    	return new StringBuilder()
    		.append("System: ").append(system).append("\\n")
			.append("Name: ").append(name).append("\\n")
			.append("City (Country): ").append(city).append(" (").append(country).append(") ").append("\\n")
			.append("Location: ").append(latitude).append(",").append(longitude).append("\\n")
			.append("Company: ").append(company).append("\\n")
			.toString();
    }
    
}
