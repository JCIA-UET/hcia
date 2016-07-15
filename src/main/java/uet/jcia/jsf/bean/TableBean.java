package uet.jcia.jsf.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

import uet.jcia.core.sqlObject.Column;
import uet.jcia.jsf.service.TableService;

@ManagedBean
@ViewScoped
public class TableBean {
    
    @ManagedProperty("#{tableService}")
    private TableService tableService;
    
    private List<Column> columnList;
    
//    @PostConstruct
//    public void init() {
//        columnList = tableService.getColumns("ADDRESS");
//    }
    
    public void displayTable(ActionEvent actionEvent) {
        String tableName = (String) actionEvent.getComponent()
                .getAttributes()
                .get("tblname");
        
        columnList = tableService.getColumns(tableName);
        RequestContext ctx = RequestContext.getCurrentInstance();
        ctx.update("dttable");
    }
    
    public void setTableService(TableService tableService) {
        this.tableService = tableService;
    }
    
    public List<Column> getColumnList() {
        return columnList;
    }
    
    public void setColumnList(List<Column> columnList) {
        this.columnList = columnList;
    }
    
}
