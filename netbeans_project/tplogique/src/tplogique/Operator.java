package tplogique;

import java.util.List;
import tptableau.Label;

/**
 *
 * @author 21700094
 */
public abstract class Operator implements Formula{
    
    protected Formula a;
    private Label label;
    private boolean flag;
    
    public Operator(Formula a, Label l, boolean f){
        this.a = a;
        label = l;
        flag = f;
    }
    
    public Formula getA(){
        return a;
    }
    
    @Override
    public boolean getFlag() {
        return flag;
    }
    
    @Override
    public Label getLabel() {
        return label;
    }
    
    @Override
    public abstract String toString();
    
    @Override
    public abstract List<Formula> getChildren();
    
    @Override
    public abstract boolean isModelTrueForThisWorld(Model model, World world);
    
}
