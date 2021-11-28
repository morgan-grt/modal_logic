package tptableau;

import java.util.List;
import tplogique.Formula;

/**
 *
 * @author 21700094
 */
public class Tableau {
    
    private List<Formula> formulas;
    private List<Label> labels;
    private Tableau left, right;
    private Formula formula;
    
    public Tableau(List<Formula> a, Formula f){
        formulas = a;
        formula = f;
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
}
