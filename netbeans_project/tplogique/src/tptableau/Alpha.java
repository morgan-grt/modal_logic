package tptableau;

import tplogique.And;
import tplogique.Formula;
import tplogique.Implies;
import tplogique.Neg;

/**
 *
 * @author 21700094
 */
public class Alpha extends Rule{

    @Override
    public Formula canBeApplied(Tableau t) {
        for (Formula f : t.getFormulas()){
            if (f.getFlag())
                return f;
        }
        return null;
        
    }

    @Override
    public void apply(Formula f, Tableau t) {
        if (f instanceof Neg){
            Formula child = f.getChildren().get(0);
            if (child.getChildren().get(0) instanceof Neg){
                Formula littleChild = child.getChildren().get(0);
                Tableau tableau = new Tableau(t.getFormulas(), littleChild);  
                
                t.setLeft(tableau);
            }
            else if (child.getChildren().get(0) instanceof And){
                Formula littleChildA = child.getChildren().get(0);
                Formula littleChildB = child.getChildren().get(1);
                
                Tableau tableauA = new Tableau(t.getFormulas(), littleChildA);
                Tableau tableauB = new Tableau(t.getFormulas(), littleChildB);
                
                t.setLeft(tableauA);
                t.setRight(tableauB);
            }
            else if (child.getChildren().get(0) instanceof Implies){
                Formula littleChildA = child.getChildren().get(0);
                Formula littleChildB = child.getChildren().get(1);
                
                Tableau tableauA = new Tableau(t.getFormulas(), littleChildA);
                Tableau tableauB = new Tableau(t.getFormulas(), littleChildB);
                
                t.setLeft(tableauA);
                t.setRight(tableauB);
            }
        }
        else if (f instanceof And){
            Formula childA = f.getChildren().get(0);
            Formula childB = f.getChildren().get(1);

            Tableau tableauA = new Tableau(t.getFormulas(), childA);
            Tableau tableauB = new Tableau(t.getFormulas(), childB);

            t.setLeft(tableauA);
            t.setRight(tableauB);
        }  
    } 
}
