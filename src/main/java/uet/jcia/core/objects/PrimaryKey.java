package uet.jcia.core.objects;

public class PrimaryKey {
	private String name;
	private String type;
	private String generator;	
	
	
	
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
		return "Primary Key : \n"+
				"\t Name Column: "+ name +"\n"+
				"\t Type: " + type+ "\n"+
				"\t Generator: "+ generator +"\n";
		
	}
	
}
