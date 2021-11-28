package tplogique;

import java.util.ArrayList;
import java.util.List;
import tptableau.Label;

/**
 *
 * @author 21700094
 */
public abstract class Binaire extends Operator{
    
    protected Formula b;
            
    public Binaire(Formula a, Formula b, Label l, boolean f){
        super(a, l, f);
        this.b = b;
    }
    
    public Binaire(Formula a, Formula b){
        this(a, b, new Label(), false);
    }
    
    public Formula getB(){
        return b;
    }
    
    @Override
    public abstract String toString();
    
    @Override
    public List<Formula> getChildren(){
        List<Formula> f = new ArrayList();
        f.add(getA());
        f.add(getB());
        return f;
    }
}
