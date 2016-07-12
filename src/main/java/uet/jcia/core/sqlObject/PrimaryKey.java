package uet.jcia.core.sqlObject;

public class PrimaryKey {
	private String name;
	private String type; 
	private String generator;
	
	
	public PrimaryKey(){
		
	}
	public PrimaryKey(String name, String type, String generator) {
		super();
		this.name = name;
		this.type = type;
		this.generator = generator;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getGenerator() {
		return generator;
	}
	public void setGenerator(String generator) {
		this.generator = generator;
	}
	public String toString(){
		return "Primary Key : " + name + " ("+type+" , "+generator+")" +"\n";
	}
}
