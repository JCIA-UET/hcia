package uet.jcia.core.convert;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import uet.jcia.core.hbm.tag.Clazz;
import uet.jcia.core.hbm.tag.HibernateMapping;
import uet.jcia.core.hbm.tag.Property;
import uet.jcia.core.sqlObject.Column;
import uet.jcia.core.sqlObject.PrimaryKey;
import uet.jcia.core.sqlObject.Table;

public class ConvertHBMTagtoSqlObject {
	private Hashtable<String,String> mappingType;
	
	public ConvertHBMTagtoSqlObject(){
		mappingType = new Hashtable<>();
		mappingType.put("java.lang.Integer", "INTEGER");
		mappingType.put("int", "INTEGER");
		mappingType.put("java.lang.Long", "BIGINT");
		mappingType.put("long", "BIGINT");
		mappingType.put("java.lang.Short", "SMALLINT");
		mappingType.put("short", "SMALLINT");
		mappingType.put("java.lang.Float", "FLOAT");
		mappingType.put("float", "FLOAT");
		mappingType.put("java.lang.Double", "DOUBLE");
		mappingType.put("double", "DOUBLE");
		mappingType.put("java.math.BigDecimal", "NUMERIC");
		mappingType.put("java.lang.String", "VARCHAR");
		mappingType.put("string", "VARCHAR");
		mappingType.put("java.lang.Byte", "TINYINT");
		mappingType.put("byte", "TINYINT");
		mappingType.put("java.lang.Boolean", "BIT");
		mappingType.put("boolean", "BIT");
		mappingType.put("java.sql.Date", "DATE");
		mappingType.put("date", "DATE");
		mappingType.put("java.util.Date", "DATE");
		mappingType.put("java.sql.Time", "TIME");
		mappingType.put("java.sql.Timestamp", "TIMESTAMP");
		mappingType.put("java.util.Calendar", "TIMESTAMP");
		mappingType.put("byte[]", "VARBINARY()");
		mappingType.put("java.io.Serializable", "BLOB()");
		mappingType.put("java.sql.Clob", "CLOB()");
		mappingType.put("java.sql.Blob", "BLOB()");
		mappingType.put("java.lang.Class", "VARCHAR");
		mappingType.put("java.util.Locale", "VARCHAR");
		mappingType.put("java.util.TimeZone", "VARCHAR");
		mappingType.put("java.util.Currency", "VARCHAR");
	}
	
	public List<Table> convertToSqlObject(HibernateMapping hibernateMapping){
		List<Table> result = new ArrayList<>();
		List<Clazz> listClazz = hibernateMapping.getClazzes();
		
		for(Clazz clazz : listClazz ){
			//creat new table
			Table table = new Table();
			//set name for table
			table.setTableName(clazz.getTable());
			
			//set primarykey for table
			PrimaryKey primaryKey = new PrimaryKey();
			primaryKey.setName(clazz.getId().getName());
			primaryKey.setType(mappingType.get(clazz.getId().getType()));
			primaryKey.setGenerator(clazz.getId().getGenerator().getClazz());
			table.setPrimaryKey(primaryKey);
			
			
			// set listColumn for table
			List<Column> listColumn = new ArrayList<>();
			for(Property property : clazz.getProperties()){
				Column column = new Column();
				column.setName(property.getColumn().getName());
				column.setType(mappingType.get(property.getType()));
				listColumn.add(column);
			}
			table.setListColumn(listColumn);
			result.add(table);
		}
		
		
		return result;
	}
}
