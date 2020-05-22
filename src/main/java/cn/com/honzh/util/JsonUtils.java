package cn.com.honzh.util;

import java.io.IOException;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
	/**
     * Json转对象
     * @param json
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T convertJson2Object(String json, Class<T> type) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        return mapper.readValue(json, type);
    }

}
