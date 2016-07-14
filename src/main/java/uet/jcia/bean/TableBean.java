package uet.jcia.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.primefaces.model.TreeNode;

@ManagedBean
public class TableBean {
	
	private TreeNode root;
	
	@ManagedProperty("#{tableService}")
	private TableService tableService;
	
	@PostConstruct
	public void init(){
		root = tableService.createTable("");
	}
	public void setTableService(TableService service){
		tableService = service;
	}
	public TreeNode getRoot() {
		return root;
	}
}
