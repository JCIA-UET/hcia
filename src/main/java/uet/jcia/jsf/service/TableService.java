package uet.jcia.jsf.service;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import uet.jcia.core.interact.InteractComponent;
import uet.jcia.core.sqlObject.Column;
import uet.jcia.core.sqlObject.Table;

@ManagedBean
@ApplicationScoped
public class TableService {

    public List<Column> getColumns(String tableName) {
        List<Table> tableList = InteractComponent.getSampleTableList();
        
        for (Table tbl : tableList) {
            if (tbl.getTableName().equalsIgnoreCase(tableName)) {
                return tbl.getListColumn();
            }
        }
        
        return null;
    }
}
