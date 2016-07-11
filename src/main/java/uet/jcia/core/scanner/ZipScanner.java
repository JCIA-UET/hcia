package uet.jcia.core.scanner;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipScanner {
	
	private static final String OUT_PUT = "src/main/resources";
	
	public static void extractFile(ZipInputStream zis, File outputDir, String fileName) {
		byte[] buffer = new byte[1024];
		try {
			BufferedOutputStream bof = new BufferedOutputStream(new FileOutputStream(new File(outputDir, fileName)));
			int i = -1;
			while((i = zis.read(buffer)) != -1) {
				bof.write(buffer, 0, i);
			}
			bof.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void deleteFile(String fileDir) {
		System.out.println("-- DELETING ALL EXTRACTED FILE AFTER PARSING --");
		
		File file = new File(fileDir);
		
		if(file.isDirectory()) {
			if(file.list().length==0) {
				file.delete();
			}
			else {
				String[] files = file.list();
				for (String temp : files) {
					File childFile = new File(file, temp);
					childFile.delete();
					
					//check again
					if(file.list().length == 0){
		           	     file.delete();
					}
				}
			}
		}
		else {
			file.delete();
		}
		
		System.out.println("-- DELETE COMPLETE --");
	}
	
	public static String searchXmlFile(String zipFile) {
		File outputDir = new File(OUT_PUT);
		String xmlFileDir = null;
		try {
			ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));
			
			ZipEntry ze = zis.getNextEntry();
			System.out.println("-- FINDING XML MAPPING FILE --");
			while(ze != null) {
				
				String fileName = ze.getName();
				
				if(fileName.endsWith(".xml")) {
					xmlFileDir = outputDir + File.separator + fileName;
					System.out.println("-- FOUND XML FILE. EXTRACTING TO: " + outputDir + " --");
					File xmlFile = new File(xmlFileDir);
					
					new File(xmlFile.getParent()).mkdirs();
					
					extractFile(zis, outputDir, fileName);
				}
				ze = zis.getNextEntry();
			}
			
			zis.closeEntry();
		    zis.close();
		    
		    System.out.println("-- ZIP FILE SCAN COMPLETE. --");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return xmlFileDir;
	}
}
