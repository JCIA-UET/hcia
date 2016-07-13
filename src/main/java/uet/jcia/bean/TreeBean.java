package uet.jcia.bean;

import java.util.ArrayList;
import java.util.List;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import uet.jcia.core.sqlObject.Column;
import uet.jcia.core.sqlObject.Table;

public class TreeBean {
	// TreeNode instance
	private TreeNode root;
	private List<Table> tablesList;
	private List<Column> colsList;
	
	public TreeBean() {
		Column col1 = new Column();
		col1.setName("Column 1");
		colsList.add(col1);
		
		Column col2 = new Column();
		col2.setName("Column 2");
		colsList.add(col2);
		
		Table table1 = new Table();
		table1.setTableName("Table 1");
		table1.setListColumn(colsList);
		tablesList.add(table1);
		
		Table table2 = new Table();
		table2.setTableName("Table 2");
		table2.setListColumn(colsList);
		tablesList.add(table2);
		
		// Create new database
		this.root = new DefaultTreeNode("db1", null);
		
		//for(Table table : tablesList) {
			//List<Column> tableCols = table.getListColumn();
			TreeNode tableNode1 = new DefaultTreeNode("Table 1", this.root);
			TreeNode tableNode2 = new DefaultTreeNode("Table 2", this.root);
			
			//for(Column col: tableCols) {
					TreeNode colNode1 = new DefaultTreeNode("table1", "Column 1", tableNode1);
					TreeNode colNode2 = new DefaultTreeNode("table1", "Column 2", tableNode1);
					
					TreeNode colNode3 = new DefaultTreeNode("table2", "Column 3", tableNode2);
					TreeNode colNode4 = new DefaultTreeNode("table2", "Column 4", tableNode2);
			//}
		//}
	}
	
	public TreeNode getRoot() {
		return this.root;
	}
	
	public void setRoot(TreeNode root) {
		this.root = root;
	}
}
