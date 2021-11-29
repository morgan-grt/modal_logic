package tplogique;

/**
 *
 * @author 21700094
 */
public class Diamond extends Operator{
    public Diamond(Formula a){
        super(a, null, false);
    }
    public Diamond(Diamond f){
        super(f);
    }
    
    @Override
    public String toString(){
        return "( ◇ " + getA() + " )";
    }

    @Override
    public boolean isModelTrueForThisWorld(Model model, World world) {
        for (World w : model.getMap().get(world)){
            if (getA().isModelTrueForThisWorld(model, w)){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public Formula clone() {
        return new Diamond(this);
    }
}
