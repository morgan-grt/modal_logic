package tplogique;

/**
 *
 * @author 21700094
 */
public class Neg extends Unaire{
    public Neg(Formula a){
        super(a);
    }
    
    @Override
    public String toString(){
        return "( ¬ " + getA() + " )";
    }

    @Override
    public boolean isModelTrueForThisWorld(Model model, World world) {
        return ! a.isModelTrueForThisWorld(model, world);
    }
}
