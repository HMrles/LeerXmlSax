package com.hmrles.sax;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 * @author HMrles
 */
public class LecturaXML {

    //Fatorya
    public static void main(String... args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory saxPaserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxPaserFactory.newSAXParser();

        File file = new File("libreria.xml");
        ObjetoHandler handler = new ObjetoHandler();
        saxParser.parse(file, handler);
        
        Libreria libreria = handler.getLibreria();
        
        System.out.println(libreria);

    }

}
