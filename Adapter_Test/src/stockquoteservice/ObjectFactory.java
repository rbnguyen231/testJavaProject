
package stockquoteservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the stockquoteservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetQuoteSymbol_QNAME = new QName("http://StockQuoteService", "symbol");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: stockquoteservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetFieldNamesResponse }
     * 
     */
    public GetFieldNamesResponse createGetFieldNamesResponse() {
        return new GetFieldNamesResponse();
    }

    /**
     * Create an instance of {@link GetQuote }
     * 
     */
    public GetQuote createGetQuote() {
        return new GetQuote();
    }

    /**
     * Create an instance of {@link GetQuoteResponse }
     * 
     */
    public GetQuoteResponse createGetQuoteResponse() {
        return new GetQuoteResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StockQuoteService", name = "symbol", scope = GetQuote.class)
    public JAXBElement<String> createGetQuoteSymbol(String value) {
        return new JAXBElement<String>(_GetQuoteSymbol_QNAME, String.class, GetQuote.class, value);
    }

}
