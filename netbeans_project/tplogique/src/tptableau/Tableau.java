package tptableau;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tplogique.Formula;

/**
 *
 * @author 21700094
 */
public class Tableau {
    
    private List<Formula> formulas;
    private List<Label> labels;
    private Map<Formula, Label> map;
    private Tableau left, right;
    private Formula formula;
    
    public Tableau(List<Formula> a, List<Label> l, Formula f, Map<Formula, Label> m){
        formulas = a;
        labels = l;
        formula = f;
        map = m;
    }
    
    public void add(Formula f, Label l){
        formulas.add(f);
        labels.add(l);
        map.put(f, l);
    }
    
    public void handleLabel(Formula f, boolean bool){
        map.get(f).setHandled(bool);
    }

    public Map<Formula, Label> getMap() {
        return map;
    }

    public List<Formula> getFormulas() {
        return formulas;
    }

    public void setFormulas(List<Formula> formulas) {
        this.formulas = formulas;
    }
    
    public Formula getFormula() {
        return formula;
    }

    public void setFormula(Formula formula) {
        this.formula = formula;
    } 

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }
    
    public Tableau getLeft() {
        return left;
    }

    public void setLeft(Tableau left) {
        this.left = left;
    }

    public Tableau getRight() {
        return right;
    }

    public void setRight(Tableau right) {
        this.right = right;
    }
    
    @Override
    public String toString(){
        return formula + "\n |\n" + left.getFormula() + "\n |\n" + right.getFormula(); 
    }
    
    public List<Formula> cloneFormulas(){
        List<Formula> clone = new ArrayList(formulas.size());
        for (Formula item : formulas) clone.add(item.clone());
        return clone; 
    }
    
    public List<Label> cloneLabels(){
        List<Label> clone = new ArrayList(labels.size());
        for (Label item : labels) clone.add(item.clone());
        return clone; 
    }
    
    public Map<Formula, Label> cloneMap(){
        Map<Formula, Label> m = new HashMap();
        for (Map.Entry mapentry : map.entrySet()){
            m.put(mapentry.getKey().clone(), mapentry.getValue().clone());
        }
        return m;
    }
}
