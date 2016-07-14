package uet.jcia.bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import org.primefaces.model.TreeNode;

@ManagedBean
public class TreeBean {
	
	private TreeNode root;
	private TreeNode selectedNode;
	
	@ManagedProperty("#{tableService}")
	private TreeService tableService;
	
	@ManagedProperty(value="#{fileUploadBean}")
	private FileUploadBean fileUploadBean;
	
	@PostConstruct
	public void init(){
		root = tableService.createTable(fileUploadBean.getTablesList());
	}
	public void setTableService(TreeService service){
		tableService = service;
	}
	 
	public void setFileUploadBean(FileUploadBean fileUploadBean) {
		this.fileUploadBean = fileUploadBean;
	}
	
	public void setSelectedNode(TreeNode selectedNode) {
        this.selectedNode = selectedNode;
    }
	
	public TreeNode getSelectedNode() {
        return selectedNode;
    }

	public void displaySelectedSingle() {
        if(selectedNode != null) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected", selectedNode.getData().toString());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
	
	public TreeNode getRoot() {
		return root;
	}
}