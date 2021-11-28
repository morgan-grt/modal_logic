package tptableau;

import java.util.ArrayList;
import java.util.List;
import tplogique.Formula;

/**
 *
 * @author 21700094
 */
public class Label {
    private List<Formula> formulas;
    private String name;
    
    public Label(String name, Formula f){
        this.name = name;
        formulas = new ArrayList();
        formulas.add(f);
    }
    
    public Label(String name){
        this.name = name;
        formulas = new ArrayList();
    }
    
    public Label(){this("1");}
    
    public void add(Formula f){
        formulas.add(f);
    }

    public List<Formula> getFormulas() {
        return formulas;
    }

    public void setFormulas(List<Formula> formulas) {
        this.formulas = formulas;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
