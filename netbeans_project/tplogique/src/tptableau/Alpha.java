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
            Formula child = f.getA();
            if (child.getA() instanceof Neg){
                Formula littleChild = child.getA();
                
                t.handleLabel(f, true);
                t.add(littleChild, new Label("1", littleChild, false));
                
            }
            else if (child.getA() instanceof And){
                Formula littleChildA = child.getA();
                Formula littleChildB = child.getB();
                
                t.handleLabel(f, true);
                t.add(littleChildA, new Label("1", littleChildA, false));
                t.add(littleChildB, new Label("1", littleChildB, false));
            }
            else if (child.getA() instanceof Implies){
                Formula littleChildA = child.getA();
                Formula littleChildB = child.getB();
                
                t.handleLabel(f, true);
                t.add(littleChildA, new Label("1", littleChildA, false));
                t.add(littleChildB, new Label("1", littleChildB, false));
            }
        }
        else if (f instanceof And){
            Formula childA = f.getA();
            Formula childB = f.getB();

            t.handleLabel(f, true);
            t.add(childA, new Label("1", childA, false));
            t.add(childB, new Label("1", childB, false));
        }  
    } 
}
