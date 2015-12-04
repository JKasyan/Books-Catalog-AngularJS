package catalog.angularjs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.nio.charset.Charset;

public class TestUtil {

    private static final Logger logger = Logger.getLogger(TestUtil.class);

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    public static byte[] convertObjectToJsonBytes(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        byte[] content = mapper.writeValueAsBytes(object);
        logger.debug("Converted object: "+content);
        return content;
    }
}
