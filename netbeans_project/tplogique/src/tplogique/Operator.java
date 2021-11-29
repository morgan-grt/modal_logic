package tplogique;

/**
 *
 * @author 21700094
 */
public abstract class Operator implements Formula{
    
    protected Formula a, b;
    private boolean flag;
    
    public Operator(Formula a, Formula b, boolean f){
        this.a = a;
        this.b = b;
        flag = f;
    }
    
    public Operator(Formula f){
        this(f.getA(), f.getB(), f.getFlag());
    }
    
    @Override
    public Formula getA(){
        return a;
    }
    
    @Override
    public Formula getB(){
        return b;
    }
    
    @Override
    public boolean getFlag() {
        return flag;
    }
    
    @Override
    public abstract String toString();
    
    @Override
    public abstract boolean isModelTrueForThisWorld(Model model, World world);
    
    @Override 
    public abstract Formula clone();
    
}
