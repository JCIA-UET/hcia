package uet.jcia.core.scanner;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipScanner {
	
	public static final String OUT_PUT_DIR = "src/main/resources";
	private static String IN_PUT_FILE;
	
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
	
	/*
	public static void deleteExtractedFile(String fileDir) {
		File file = new File(fileDir);
		
		if(file.isDirectory()) {
			if(file.list().length==0) {
				return;
			}
			else {
				String[] files = file.list();
				for (String temp : files) {
					String tempFileDir = OUT_PUT_DIR + File.separator + temp;
					if(!(tempFileDir.equals(IN_PUT_FILE))) {
						deleteExtractedFile(tempFileDir);
					}
				}
			}
		}
		else {
			file.delete();
			System.out.println("-- DELETE FILE: " + fileDir + " --");
		}
	}
	*/
	
	public static List<String> searchXmlFile(String zipFile) {
		List<String> namesList = new ArrayList<>();
		IN_PUT_FILE = zipFile;
		File outputDir = new File(OUT_PUT_DIR);
		String xmlFileDir = null;
		try {
			ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));
			
			ZipEntry ze = zis.getNextEntry();
			System.out.println("-- FINDING XML MAPPING FILE --");
			while(ze != null) {
				
				String fileName = ze.getName();
				
				if(fileName.endsWith(".xml")) {
					xmlFileDir = outputDir + File.separator + fileName;
					System.out.println("-- FOUND XML FILE. EXTRACTING: " + xmlFileDir + " --");
					File xmlFile = new File(xmlFileDir);
					
					new File(xmlFile.getParent()).mkdirs();
					
					extractFile(zis, outputDir, fileName);
					namesList.add(xmlFileDir);
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
		return namesList;
	}
}
