package uet.jcia.core.hbm.tag;

import java.util.List;

public class HibernateMapping {
    
    private List<Clazz> clazzes;
    
    public List<Clazz> getClazzes() {
        return clazzes;
    }
    
    public void setClazzes(List<Clazz> clazzes) {
        this.clazzes = clazzes;
    }

    @Override
    public String toString() {
        return "HibernateMapping [clazzes=" + clazzes + "]";
    }
    
}
