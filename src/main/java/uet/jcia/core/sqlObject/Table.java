package uet.jcia.core.sqlObject;

import java.util.List;

public class Table {
	private String tableName;
	private PrimaryKey primaryKey;
	private List<Column> listColumn;
	
	
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public PrimaryKey getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(PrimaryKey primaryKey) {
		this.primaryKey = primaryKey;
	}
	public List<Column> getListColumn() {
		return listColumn;
	}
	public void setListColumn(List<Column> listColumn) {
		this.listColumn = listColumn;
	}
	public String toString(){
		String result = "";
		result += "Table : " + tableName +"\n";
		result += primaryKey;
		for(Column col : listColumn){
			result+=col;
		}
		
		return result;
	}
	
}
