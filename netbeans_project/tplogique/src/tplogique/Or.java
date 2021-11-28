package tplogique;

/**
 *
 * @author 21700094
 */
public class Or extends Binaire{
    public Or(Formula a, Formula b){
        super(a, b);
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
}
