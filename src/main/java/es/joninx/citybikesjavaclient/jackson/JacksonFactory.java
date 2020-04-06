package es.joninx.citybikesjavaclient.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;

@Getter
public class JacksonFactory {

	private static final JacksonFactory INSTANCE = new JacksonFactory();
	
	private ObjectMapper mapper = null;
	
	private JacksonFactory() {
		mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		mapper.configure(Feature.AUTO_CLOSE_SOURCE, true);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
	}
	
	public static JacksonFactory getInstance() {
		return INSTANCE;
	}
	
}
