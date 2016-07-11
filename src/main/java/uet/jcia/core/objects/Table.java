package uet.jcia.core.objects;

import java.util.List;

public class Table {
	private String className;
	private String tableName;
	private List<PrimaryKey> priKey;
	private List<Column> columns;
	
	public Table(String className, String tableName) {
		this.className = className;
		this.tableName = tableName;
	}
	
	public Table(String className, String tableName, List<PrimaryKey> priKey, List<Column> properties) {
		super();
		this.className = className;
		this.tableName = tableName;
		this.priKey = priKey;
		this.columns = properties;
	}
	
	public Table() {
	}

	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public List<PrimaryKey> getPriKey() {
		return priKey;
	}
	public void setPriKey(List<PrimaryKey> priKey) {
		this.priKey = priKey;
	}
	public List<Column> getProperties() {
		return this.columns;
	}
	public void setProperties(List<Column> properties) {
		this.columns = properties;
	}
	public String toString(){
		String result = "";
		result += "Table: "+ tableName+"\n";
		for(PrimaryKey t : priKey){
			result+=t;
		}
		for(Column c : columns){
			result+=c;
		}
		return result;
	}
}
