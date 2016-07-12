package uet.jcia.core.hbm.tag;

import java.util.List;

public class Property {
    
    private String name;
    private String type;
    
    private Column column;
    
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
    
    public Column getColumn() {
        return column;
    }
    
    public void setColumn(Column column) {
        this.column = column;
    }

    @Override
    public String toString() {
        return "Property [name=" + name + ", type=" + type + ", column=" + column + "]";
    }
    
}
