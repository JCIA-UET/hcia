package uet.jcia.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.primefaces.model.TreeNode;

@ManagedBean
public class TableBean {
	
	@ManagedProperty("#{nodeSelected}")
	private TreeNode nodeSelected;
}
