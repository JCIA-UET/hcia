package uet.jcia.core.parser;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;

import uet.jcia.core.scanner.ZipScanner;

public class test {
	public static void main(String[] args) {
		String xmlFile = ZipScanner.searchXmlFile("src/main/resources/resources.zip");
		System.out.println(ParserXMLToTable.parserToTable(xmlFile));
		ZipScanner.deleteFile(xmlFile);
	}
}
