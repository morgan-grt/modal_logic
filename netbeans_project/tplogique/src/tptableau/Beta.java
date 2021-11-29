package tptableau;

import tplogique.And;
import tplogique.Formula;
import tplogique.Implies;
import tplogique.Neg;
import tplogique.Or;

/**
 *
 * @author 21700094
 */
public class Beta extends Rule{

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
            Formula child = f.getA();
            if (child.getA() instanceof Neg){
                Formula littleChild = child.getA();
                Tableau tableau = new Tableau(t.cloneFormulas(), t.cloneLabels(), littleChild);  
                
                t.setLeft(tableau);
            }
            else if (child.getA() instanceof And){
                Formula littleChildA = child.getA();
                Formula littleChildB = child.getB();
                
                Tableau tableauA = new Tableau(t.getFormulas(), littleChildA);
                Tableau tableauB = new Tableau(t.getFormulas(), littleChildB);
                
                t.setLeft(tableauA);
                t.setRight(tableauB);
            }
            else if (child.getA() instanceof Implies){
                Formula littleChildA = child.getA();
                Formula littleChildB = child.getB();
                
                Tableau tableauA = new Tableau(t.getFormulas(), littleChildA);
                Tableau tableauB = new Tableau(t.getFormulas(), littleChildB);
                
                t.setLeft(tableauA);
                t.setRight(tableauB);
            }
        }
        else if (f instanceof Or){
            Formula childA = f.getA();
            Formula childB = f.getB();

            Tableau tableauA = new Tableau(t.getFormulas(), childA, t.getMap());
            Tableau tableauB = new Tableau(t.getFormulas(), childB);

            t.setLeft(tableauA);
            t.setRight(tableauB);
        }  
    }
    
}
