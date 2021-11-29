package tplogique;

/**
 *
 * @author 21700094
 */
public class And extends Operator{
    public And(Formula a, Formula b){
        super(a, b, false);
    }
    public And(And f){
        super(f);
    }
    
    @Override
    public String toString(){
        return "( " + getA() + " ∧ " + getB() + " )";
    }

    @Override
    public boolean isModelTrueForThisWorld(Model model, World world) {
        return a.isModelTrueForThisWorld(model, world)
                    && b.isModelTrueForThisWorld(model, world);
    }

    @Override
    public Formula clone() {
        return new And(this);
    }
   
}
