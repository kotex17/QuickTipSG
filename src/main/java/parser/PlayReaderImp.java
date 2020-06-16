package parser;

import objects.Play;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.apache.log4j.Logger;

public class PlayReaderImp implements PlayReader {

    private final static Logger LOGGER = Logger.getLogger(PlayReaderImp.class.getName());

    public Play read(String uri) {
        try {
            return (Play) JAXBContext.newInstance(Play.class).createUnmarshaller()
                    .unmarshal(new FileReader(uri));
        } catch (JAXBException e) {
            LOGGER.error(String.format("Unmarshal exception: %s", e.getMessage()));
        } catch (FileNotFoundException e) {
            LOGGER.error(String.format("File read exception: %s", e.getMessage()));
        }
        return null;
    }
}
