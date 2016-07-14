package uet.jcia.core.interact;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.SAXException;

import uet.jcia.core.convert.ConvertHBMTagtoSqlObject;
import uet.jcia.core.hbm.tag.HibernateMapping;
import uet.jcia.core.parser.HbmParser;
import uet.jcia.core.scanner.ZipScanner;
import uet.jcia.core.sqlObject.Table;

public class InteractComponent {
	public List<Table> interactive(String linkZipFile){
		List<Table> result = new ArrayList<>();
		
		List<String> listXML = ZipScanner.searchXmlFile(linkZipFile);
		HbmParser parser = HbmParser.getInstance();
		ConvertHBMTagtoSqlObject convert = new ConvertHBMTagtoSqlObject();
		
		for(String string : listXML){
			HibernateMapping hibernateMapping;
			try {
				hibernateMapping = parser.parse(string);
				List<Table> list = convert.convertToSqlObject(hibernateMapping);
				result.addAll(list);
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		return result;
	}
}
