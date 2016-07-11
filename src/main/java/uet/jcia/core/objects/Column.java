package uet.jcia.core.objects;

public class Column {
	private String name;
	private String type;
	private int lenght; 
	private boolean notNull;
	
	
	public Column(){
		lenght = -1 ; 
		notNull = false;
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


	public int getLenght() {
		return lenght;
	}


	public void setLenght(int lenght) {
		this.lenght = lenght;
	}


	public boolean isNotNull() {
		return notNull;
	}


	public void setNotNull(boolean notNull) {
		this.notNull = notNull;
	}
	public String toString(){
		String result="";
		result += "Column : "+ name+
				"\n" ;
		result += "\t Type: " + type+"\n";
		if(lenght > 0)
			result += "\t Lenght: " +lenght+"\n";
		result += "\t Not null: " +notNull+"\n";
		return result;
	}
}
