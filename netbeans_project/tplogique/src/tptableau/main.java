package tptableau;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        Label l = new Label("1", f, false);
        print(f);
        
        print((f instanceof Or));
        
        List<Formula> fs = new ArrayList();
        List<Label> labels = new ArrayList();
        fs.add(f);
        labels.add(l);
        Map<Formula, Label> map = new HashMap();
        map.put(f, l);
        
        Tableau t = new Tableau(fs, labels, f, map);
        
        new Alpha().apply(f, t);
        
        print(t);
    }
    
    public static void print(Object o){
        System.out.println(o);
    }
}
