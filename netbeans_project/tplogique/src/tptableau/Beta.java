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
                Formula littleChildA = child.getA();
                Label labelA = new Label("1", littleChildA, false);
                Tableau tableau = new Tableau(t.cloneFormulas(), t.cloneLabels(), littleChildA, t.cloneMap()); 
                tableau.add(littleChildA, labelA);
                
                t.setLeft(tableau);
            }
            else if (child.getA() instanceof And){
                Formula littleChildA = child.getA();
                Formula littleChildB = child.getB();
                
                Label labelA = new Label("1", littleChildA, false);
                Label labelB = new Label("1", littleChildB, false);
                
                Tableau tableauA = new Tableau(t.cloneFormulas(), t.cloneLabels(), littleChildA, t.cloneMap()); 
                Tableau tableauB = new Tableau(t.cloneFormulas(), t.cloneLabels(), littleChildB, t.cloneMap());
                
                tableauA.add(littleChildA, labelA);
                tableauB.add(littleChildB, labelB);
                
                t.setLeft(tableauA);
                t.setRight(tableauB);
            }
            else if (child.getA() instanceof Implies){
                Formula littleChildA = child.getA();
                Formula littleChildB = child.getB();
                
                Label labelA = new Label("1", littleChildA, false);
                Label labelB = new Label("1", littleChildB, false);
                
                Tableau tableauA = new Tableau(t.cloneFormulas(), t.cloneLabels(), littleChildA, t.cloneMap()); 
                Tableau tableauB = new Tableau(t.cloneFormulas(), t.cloneLabels(), littleChildB, t.cloneMap());
                
                tableauA.add(littleChildA, labelA);
                tableauB.add(littleChildB, labelB);
                
                t.setLeft(tableauA);
                t.setRight(tableauB);
            }
        }
        else if (f instanceof Or){
            Formula childA = f.getA();
            Formula childB = f.getB();

            Label labelA = new Label("1", childA, false);
            Label labelB = new Label("1", childB, false);

            Tableau tableauA = new Tableau(t.cloneFormulas(), t.cloneLabels(), childA, t.cloneMap()); 
            Tableau tableauB = new Tableau(t.cloneFormulas(), t.cloneLabels(), childB, t.cloneMap());

            tableauA.add(childA, labelA);
            tableauB.add(childB, labelB);

            t.setLeft(tableauA);
            t.setRight(tableauB);
        }  
    }
    
}
