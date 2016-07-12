package uet.jcia.core.hbm.tag;

import java.util.List;

public class Clazz {
	private String name;
	private String table;
	private Id id;
	private List<Property> properties;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Clazz [name=" + name + ", table=" + table + ", id=" + id + ", properties=" + properties + "]";
    }

}