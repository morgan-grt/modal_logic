package tptableau;

import java.util.ArrayList;
import java.util.List;
import tplogique.Formula;

/**
 *
 * @author 21700094
 */
public class Label {
    private Formula formula;
    private boolean handled;
    private String name;
        
    public Label(String name, Formula f){
        this.name = name;
        formula = f;
        handled = false;
    }
    
    public Label(String name, Formula f, boolean bool){
        this(name, f);
        handled = bool;
    }
    
    public Formula getFormula() {
        return formula;
    }

    public void setFormula(Formula formula) {
        this.formula = formula;
    }

    public boolean isHandled() {
        return handled;
    }

    public void setHandled(boolean handled) {
        this.handled = handled;
    }
    
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public Label clone(){
        return new Label(name, formula, handled);
    }
}
