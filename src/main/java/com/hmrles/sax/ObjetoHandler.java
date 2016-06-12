package com.hmrles.sax;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author HMrles
 */
public class ObjetoHandler extends DefaultHandler {

    private Libreria libreria = new Libreria();
    private ArrayList<Libro> libros = new ArrayList();
    private Libro libro;

    private StringBuilder buffer = new StringBuilder();

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch, start, length);
    }

    public Libreria getLibreria() {
        return libreria;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case "nombre":
                libreria.setNombre(buffer.toString());
                break;
            case "titulo":
                libro.setTitulo(buffer.toString());
                break;
            case "autor":
                libro.setAutor(buffer.toString());
                break;
            case "libro":
                break;

            case "libros":
                break;

            case "libreria":
                break;

        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case "libreria":
                break;
            case "nombre":
                buffer.delete(0, buffer.length());
                break;

            case "libros":

                break;

            case "libro":
                libro = new Libro();
                libreria.setLibros(libros);
                libros.add(libro);
                libro.setIsbn(attributes.getValue("isbn"));
                break;
            case "titulo":
                buffer.delete(0, buffer.length());
                break;

            case "autor":
                buffer.delete(0, buffer.length());
                break;
        }
    }


}
