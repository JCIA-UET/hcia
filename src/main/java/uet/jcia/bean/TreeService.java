package uet.jcia.bean;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import uet.jcia.core.interact.InteractComponent;
import uet.jcia.core.sqlObject.Column;
import uet.jcia.core.sqlObject.Table;


@ManagedBean(name = "treeService")
@ApplicationScoped
public class TreeService {
	public TreeNode createTable(){
		InteractComponent inter = new InteractComponent();
		
		List<Table> list = inter.zipInteractive("src/main/resources/resources.zip");
		
		TreeNode root = new DefaultTreeNode("root",null) ;
		
		for(Table table : list){
			TreeNode tableNode = new DefaultTreeNode(table.getTableName(),root);
			List<Column> listColumn = table.getListColumn();
			for(Column column:listColumn){
				tableNode.getChildren().add(new DefaultTreeNode(column.getName(),tableNode));
			}
		}
		
		return root;
	}
}