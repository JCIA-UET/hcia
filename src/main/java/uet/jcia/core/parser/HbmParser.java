package uet.jcia.core.parser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import uet.jcia.core.hbm.tag.Clazz;
import uet.jcia.core.hbm.tag.Column;
import uet.jcia.core.hbm.tag.Generator;
import uet.jcia.core.hbm.tag.HibernateMapping;
import uet.jcia.core.hbm.tag.Id;
import uet.jcia.core.hbm.tag.Property;

public class HbmParser {

    private static DocumentBuilderFactory builderFactory;
    private static DocumentBuilder builder;
    
    private static HbmParser instance = new HbmParser();
    public static HbmParser getInstance() { return instance; }
    
    private HbmParser() {
        try {
            builderFactory = DocumentBuilderFactory.newInstance();
            builder =  builderFactory.newDocumentBuilder();
            
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
    
    public Document getDocument(File xmlFile) throws SAXException, IOException {
        Document doc = builder.parse(xmlFile);
        
        // normalize before process
        doc.normalize();
        return doc;
    }
    
    public HibernateMapping analysisHbmDocument(Document doc) {
        Element rootElement = doc.getDocumentElement();
        HibernateMapping hibernateMapping = new HibernateMapping();
        
        // get classes
        NodeList clazzNodes = rootElement.getElementsByTagName("class");
        if (clazzNodes.getLength() > 0) {
            List<Clazz> clazzList = getClazzList(clazzNodes);
            hibernateMapping.setClazzes(clazzList);
        }
        
        return hibernateMapping;
    }
    
    public List<Clazz> getClazzList(NodeList clazzNodes) {
        List<Clazz> clazzList = new ArrayList<>();
        
        for (int count = 0; count < clazzNodes.getLength(); count++) {
            Element clazzNode = (Element) clazzNodes.item(count);
            Clazz clazz = new Clazz();
            
            // get attributes
            clazz.setName(clazzNode.getAttribute("name"));
            clazz.setTable(clazzNode.getAttribute("table"));
            
            // get id
            Element idNode = (Element) clazzNode.getElementsByTagName("id").item(0);
            Id id = getId(idNode);
            clazz.setId(id);
            
            // get properties
            NodeList propertyNodes = clazzNode.getElementsByTagName("property");
            if (propertyNodes.getLength() > 0) {
                List<Property> propertyList = getPropertyList(propertyNodes);
                clazz.setProperties(propertyList);
            }
            
            // add to list
            clazzList.add(clazz);
        }
        
        return clazzList;
    }
    
    public List<Property> getPropertyList(NodeList propertyNodes) {
        List<Property> propertyList = new ArrayList<>();
        
        for (int count = 0; count < propertyNodes.getLength(); count++) {
            Element propertyNode = (Element) propertyNodes.item(count);
            Property property = new Property();
            
            // get attributes
            property.setName(propertyNode.getAttribute("name"));
            property.setType(propertyNode.getAttribute("type"));
            
            // get column
            Element columnNode =
                    (Element) propertyNode.getElementsByTagName("column").item(0);
            Column column = getColumn(columnNode);
            property.setColumn(column);
            
            // add to list
            propertyList.add(property);
        }
        
        return propertyList;
    }
    
    public Column getColumn(Element columnNode) {
        Column column = new Column();
        
        // get attributes
        column.setName(columnNode.getAttribute("name"));
        column.setType(columnNode.getAttribute("type"));
        return column;
    }
    
    public Id getId(Element idNode) {
        Id id = new Id();
        
        // get attributes
        id.setName(idNode.getAttribute("name"));
        id.setType(idNode.getAttribute("type"));
        
        // get generator
        Element generatorNode =
                (Element) idNode.getElementsByTagName("generator").item(0);
        Generator generator = getGenerator(generatorNode);
        id.setGenerator(generator);
        
        return id;
    }
    
    public Generator getGenerator(Element generatorNode) {
        Generator generator = new Generator();
        
        // get attributes 
        generator.setClazz(generatorNode.getAttribute("class"));
        return generator;
    }
    
    public HibernateMapping parse(String xmlPath) throws SAXException, IOException {
        System.out.println("....creating new xmlFile");
        File xmlFile = new File(xmlPath);
        System.out.println("....get document");
        Document doc = getDocument(xmlFile);
        System.out.println("....analysising....");
        HibernateMapping hibernateMapping = analysisHbmDocument(doc);
        return hibernateMapping;
    }
}
