package uet.jcia.core.objects;

import java.util.List;

public class Clazz {
	private String className;
	private String tableName;
	private PrimaryKey priKey;
	private List<Property> properties;
	
	public Clazz(String className, String tableName) {
		this.className = className;
		this.tableName = tableName;
	}
	
	public Clazz(String className, String tableName, PrimaryKey priKey, List<Property> properties) {
		super();
		this.className = className;
		this.tableName = tableName;
		this.priKey = priKey;
		this.properties = properties;
	}
	
	public Clazz() {
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
	public PrimaryKey getPriKey() {
		return priKey;
	}
	public void setPriKey(PrimaryKey priKey) {
		this.priKey = priKey;
	}
	public List<Property> getProperties() {
		return properties;
	}
	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}
}
