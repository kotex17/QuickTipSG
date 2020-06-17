package reader;

import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class XmlReader {

    private final static Logger LOGGER = Logger.getLogger(XmlReader.class.getName());

    public static <T> T unmarshal(String uri, Class<T> clazz) {
        try {
            return (T) JAXBContext.newInstance(clazz).createUnmarshaller()
                    .unmarshal(new FileReader(uri));
        } catch (JAXBException e) {
            LOGGER.error(String.format("Unmarshal exception: %s", e.getMessage()));
        } catch (FileNotFoundException e) {
            LOGGER.error(String.format("File read exception: %s", e.getMessage()));
        }
        return null;
    }
}

