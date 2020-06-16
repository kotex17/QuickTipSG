package parser;

import objects.GameList;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class XmlReaderImpl {

    private final static Logger LOGGER = Logger.getLogger(XmlReaderImpl.class.getName());

    public static <T> T read(String uri, Class<T> clazz) {

        try {
            return clazz.cast(JAXBContext.newInstance(clazz).createUnmarshaller()
                    .unmarshal(new FileReader(uri)));
        } catch (JAXBException e) {
            LOGGER.error(String.format("Unmarshal exception: %s", e.getMessage()));
        } catch (FileNotFoundException e) {
            LOGGER.error(String.format("File read exception: %s", e.getMessage()));
        }
        return null;

//        JAXBContext jc = JAXBContext.newInstance(clazz);
//        Unmarshaller unmarshaller = jc.createUnmarshaller();
//        T obj = clazz.cast(unmarshaller.unmarshal(new FileReader(xml)));
//        return obj;
    }
}

