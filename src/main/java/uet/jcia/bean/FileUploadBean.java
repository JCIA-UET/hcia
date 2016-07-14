package uet.jcia.bean;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import uet.jcia.core.interact.InteractComponent;
import uet.jcia.core.scanner.ZipScanner;
import uet.jcia.core.sqlObject.Table;

 
@ManagedBean
public class FileUploadBean {
 
    public List<Table> handleFileUpload(FileUploadEvent event) {
    	UploadedFile uploadedFile = event.getFile();
        String fileName = uploadedFile.getFileName();
        List<Table> tablesList = null;
        InteractComponent ic = new InteractComponent();
        
        try {
        	if(fileName.endsWith(".hbm.xml")) {
				InputStream input = uploadedFile.getInputstream();
				String fileDir = this.writeFile(input, ZipScanner.OUT_PUT_DIR, fileName);
				tablesList = ic.xmlInteractive(fileDir);
				
        	}
        	else if(fileName.endsWith(".zip")) {
				InputStream input = uploadedFile.getInputstream();
				String fileDir = this.writeFile(input, ZipScanner.OUT_PUT_DIR, fileName);	        	
	        	tablesList = ic.zipInteractive(fileDir);
        	}
        	
        	return tablesList;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
    
    public String writeFile(InputStream is, String outputDir, String fileName) {
    	byte[] buffer = new byte[1024000];
    	String fileDir = null;
    	File path = new File(outputDir);
		try {
			BufferedOutputStream bof = new BufferedOutputStream(new FileOutputStream(new File(outputDir, fileName)));
			
			int i = -1;
			while((i = is.read(buffer)) != -1) {
				bof.write(buffer, 0, i);
			}
			bof.close();
			fileDir = path.getPath() + File.separator + fileName;
			return fileDir;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
}