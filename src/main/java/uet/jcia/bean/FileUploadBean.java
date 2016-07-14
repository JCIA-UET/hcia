package uet.jcia.bean;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import uet.jcia.core.interact.InteractComponent;
import uet.jcia.core.scanner.ZipScanner;
import uet.jcia.core.sqlObject.Table;

 
@ManagedBean
public class FileUploadBean {
	private List<Table> tablesList;
	
	public List<Table> getTablesList() {
		return tablesList;
	}

	public void setTablesList(List<Table> tablesList) {
		this.tablesList = tablesList;
	}
	
    public void handleFileUpload(FileUploadEvent event) {
    	UploadedFile uploadedFile = event.getFile();
        String fileName = uploadedFile.getFileName();
        InteractComponent ic = new InteractComponent();
        String fileDir = null;
        
        try {
        	if(fileName.endsWith(".hbm.xml")) {
				InputStream input = uploadedFile.getInputstream();
				fileDir = this.writeFile(input, ZipScanner.OUT_PUT_DIR, fileName);
				this.setTablesList(ic.xmlInteractive(fileDir));
				
        	}
        	else if(fileName.endsWith(".zip")) {
				InputStream input = uploadedFile.getInputstream();
				fileDir = this.writeFile(input, ZipScanner.OUT_PUT_DIR, fileName);	        	
				this.setTablesList(ic.zipInteractive(fileDir));
        	}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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