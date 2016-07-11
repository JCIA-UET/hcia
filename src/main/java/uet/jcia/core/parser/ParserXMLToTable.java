package uet.jcia.core.parser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import uet.jcia.core.objects.Column;
import uet.jcia.core.objects.PrimaryKey;
import uet.jcia.core.objects.Table;

public class ParserXMLToTable {
	private static Document doc;
	private static Node nodeClass;

	private static void createDoc(String linkFile) {
		try {
			File fXmlFile = new File(linkFile);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(fXmlFile);
			doc.normalize();
			nodeClass = doc.getElementsByTagName("class").item(0);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static List<PrimaryKey> getPrimaryKey(){
		Element element = (Element) nodeClass;
		Element id = (Element)element.getElementsByTagName("id").item(0);
		PrimaryKey primary = new PrimaryKey();
		primary.setType(id.getAttribute("type"));
		
		Element column = (Element)id.getElementsByTagName("column").item(0);
		primary.setName(column.getAttribute("name"));
		
		Element generator= (Element)id.getElementsByTagName("generator").item(0);
		primary.setGenerator(generator.getAttribute("class"));
		
		//System.out.println(primary);
		List<PrimaryKey> result = new ArrayList<>();
		result.add(primary);
		
		return result;
	}
	
	private static List<Column> getListColumns(){
		Element element = (Element) nodeClass;
		NodeList listNode = element.getElementsByTagName("property");
		
		List<Column> result = new ArrayList<>();
		
		for(int i = 0 ; i < listNode.getLength();i++){
			Element element1 = (Element)listNode.item(i);
			Column column = new Column();
			column.setType(element1.getAttribute("type"));
			
			Element element2 = (Element)element1.getElementsByTagName("column").item(0);
			column.setName(element2.getAttribute("name"));
			
			System.out.println();
			if(!element2.getAttribute("length").equals("")){
			column.setLenght(Integer.parseInt(element2.getAttribute("length")));}
			if(element2.getAttribute("not-null")!=null)
			column.setNotNull(Boolean.valueOf(element2.getAttribute("not-null")));
			
			result.add(column);
			
			//System.out.println(column);
		}
		
		return result;
	}
	
	public static Table parserToTable(String linkFile)
	{
		createDoc(linkFile);
		Table result = new Table();
		Element element = (Element)nodeClass;
		result.setClassName(element.getAttribute("name"));
		result.setTableName(element.getAttribute("table"));
		result.setPriKey(getPrimaryKey());
		result.setProperties(getListColumns());
		return result;
	}
}
