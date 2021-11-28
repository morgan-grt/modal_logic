package tptableau;

import java.util.ArrayList;
import java.util.List;
import tplogique.And;
import tplogique.Atom;
import tplogique.Formula;
import tplogique.Neg;
import tplogique.Or;


/**
 *
 * @author 21700094
 */
public class main {
    public static void main(String[] args) {
        Formula f = new And(new Or(new Atom("A"), new Neg(new Atom("B"))), new Atom("B"));
        System.out.println(f);
        
        System.out.println((f instanceof Or));
        
        List<Formula> fs = new ArrayList();
        fs.add(f);
        
        Tableau t = new Tableau(fs, f);
        
        new Alpha().apply(f, t);
        
        System.out.println(t);
    }
}
