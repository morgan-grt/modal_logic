package tplogique;

/**
 *
 * @author 21700094
 */
public class Neg extends Operator{
    public Neg(Formula a){
        super(a, null, false);
    }
    public Neg(Neg f){
        super(f);
    }
    
    @Override
    public String toString(){
        return "( ¬ " + getA() + " )";
    }

    @Override
    public boolean isModelTrueForThisWorld(Model model, World world) {
        return ! a.isModelTrueForThisWorld(model, world);
    }

    @Override
    public Formula clone() {
        return new Neg(this);
    }
}
