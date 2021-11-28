package tplogique;

import java.util.ArrayList;
import java.util.List;
import tptableau.Label;

/**
 *
 * @author 21700094
 */
public abstract class Unaire extends Operator{
    
    public Unaire(Formula a, Label l, boolean f){
        super(a, l, f);
    } 
    
    public Unaire(Formula a){
        this(a, new Label(), false);
    }
    
    @Override
    public abstract String toString();
    
    @Override
    public List<Formula> getChildren(){
        List<Formula> f = new ArrayList();
        f.add(getA());
        return f;
    }
}
