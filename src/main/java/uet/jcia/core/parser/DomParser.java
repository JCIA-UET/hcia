//package uet.jcia.core.parser;
//
//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//
//import org.w3c.dom.Document;
//
//
//
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.ParserConfigurationException;
//
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//import org.w3c.dom.Node;
//import org.w3c.dom.NodeList;
//import org.xml.sax.SAXException;
//
//import uet.jcia.core.objects.Clazz;
//import uet.jcia.core.objects.PrimaryKey;
//
//public class DomParser {
//	private File file;
//	
//	public DomParser(File file) {
//		this.file = file;
//	}
//	
//	public NodeList getChild(Node node) {
//		if(node.hasChildNodes()) {
//			return node.getChildNodes();
//		}
//		return null;
//	}
//	
//	public Document getDocument() {
//		try {
//			Document doc = null;
//			DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
//			doc = dBuilder.parse(file);
//			doc.getDocumentElement().normalize();
//			return doc;
//		} catch (ParserConfigurationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SAXException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
//	
//	/*
//	 *  return root node
//	 */
//	public Node getRootNode(Document doc) {
//		Node rootNode = doc.getDocumentElement();
//		return rootNode;
//	}
//	
//	public static void main(String[] args) {
//		File file = new File("src/main/resources/Address.xml");
//		DomParser parse = new DomParser(file);
//		Document doc = parse.getDocument();
//		Node rootNode = parse.getRootNode(doc);
//			
//		// kiem tra chi lay du lieu trong node "hibernate-mapping"
//		if(rootNode.getNodeName().equals("hibernate-mapping")) {
//			if(rootNode.hasChildNodes()) {
//				
//				
//				// Tao list de luu danh sach cac clazz
//				List<Clazz> clazzList = new ArrayList<>();
//				
//				NodeList clazzListNode = doc.getElementsByTagName("class");
//				int i, j;
//				
//				for(i = 0; i < clazzListNode.getLength(); i++) {
//					// doc class
//					Node clazzNode = clazzListNode.item(i);
//					Element clazzElement = (Element) clazzNode;
//						
//					// Lay gia tri cac attribute
//					String clazzName = clazzElement.getAttribute("name");
//					String clazzTable = clazzElement.getAttribute("table");
//						
//					// Tao doi tuong Clazz de luu du lieu
//					if(clazzName != null && clazzTable != null) {
//						Clazz clazz = new Clazz(clazzName, clazzTable);
//						clazzList.add(clazz);
//					}
//					else {
//						System.err.println("Class tag sai cau truc");
//					}
//						
//					// Lay cac node con cua node Class
//					NodeList propsList = clazzNode.getChildNodes();
//					
//					// Phan tu dau tien luon luon la khoang trang
//					for(j = 0; j < propsList.getLength(); j++) {
//						Node propNode = propsList.item(j);
//						
//						// Doc den tag id
//						if(propNode.getNodeName().equals("id")) {
//							Element priElement = (Element) propNode;
//							PrimaryKey priKey = new PrimaryKey();
//						}
//						//System.out.println(propNode);
//					}
//					
//						
//							
//				}
//			}
//		}
//	}
//}
