package uet.jcia.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
 
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
 
@ManagedBean
public class FileUploadBean {
 
    public void handleFileUpload(FileUploadEvent event) {
    	UploadedFile uploadedFile = event.getFile();
        String fileName = uploadedFile.getFileName();
        String contentType = uploadedFile.getContentType();
        System.out.println(fileName);
    }
}