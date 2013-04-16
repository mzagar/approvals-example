package util;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class ObjectMapperFactory {

	public ObjectMapper build() {
		return build(new JsonFactory());
	}

	public ObjectMapper build(JsonFactory factory) {
        return configure(new ObjectMapper(factory));
    }

    public ObjectMapper configure(ObjectMapper mapper) {
		mapper.enable(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS);
		mapper.enable(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY);
		mapper.enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		return mapper;
	}
}
