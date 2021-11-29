package tplogique;

/**
 *
 * @author 21700094
 */
public class Implies extends Operator{
    public Implies(Formula a, Formula b){
        super(a, b, false);
    }
    public Implies(Implies f){
        super(f);
    }
    
    @Override
    public String toString(){
        return "( " + getA() + "⇒" + getB() + " )";
    }

    @Override
    public boolean isModelTrueForThisWorld(Model model, World world) {
        return ! a.isModelTrueForThisWorld(model, world)
                    || b.isModelTrueForThisWorld(model, world);
    }

    @Override
    public Formula clone() {
        return new Implies(this);
    }
}
