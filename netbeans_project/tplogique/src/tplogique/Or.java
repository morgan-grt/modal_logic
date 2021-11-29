package tplogique;

/**
 *
 * @author 21700094
 */
public class Or extends Operator{
    public Or(Formula a, Formula b){
        super(a, b, false);
    }
    public Or(Or f){
        super(f);
    }
    
    @Override
    public String toString(){
        return "( " + getA() + " ∨ " + getB() + " )";
    }

    @Override
    public boolean isModelTrueForThisWorld(Model model, World world) {
        return a.isModelTrueForThisWorld(model, world)
                    || b.isModelTrueForThisWorld(model, world);
    }

    @Override
    public Formula clone() {
        return new Or(this);
    }
}
