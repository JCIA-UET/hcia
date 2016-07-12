package uet.jcia.core.hbm.tag;

public class Id {
	private String name;
	private String type;
	
	private Generator generator;

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

    public Generator getGenerator() {
        return generator;
    }

    public void setGenerator(Generator generator) {
        this.generator = generator;
    }

    @Override
    public String toString() {
        return "Id [name=" + name + ", type=" + type + ", generator=" + generator + "]";
    }	
}
