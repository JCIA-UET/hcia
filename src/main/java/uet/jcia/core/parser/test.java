package uet.jcia.core.parser;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;

public class test {
	public static void main(String[] args) {
		System.out.println(ParserXMLToTable.parserToTable("src/main/resources/Address.xml"));
	}
}
