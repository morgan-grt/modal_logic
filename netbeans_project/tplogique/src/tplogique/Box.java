package tplogique;

/**
 *
 * @author 21700094
 */
public class Box extends Operator{
    public Box(Formula a){
        super(a, null, false);
    }
    public Box(Box f){
        super(f);
    }
    
    @Override
    public String toString(){
        return "( □ " + getA() + " )";
    }

    @Override
    public boolean isModelTrueForThisWorld(Model model, World world) {
        for (World w : model.getMap().get(world)){
            if (! getA().isModelTrueForThisWorld(model, w)){
                return false;
            }
        }
        return true;
    }

    @Override
    public Formula clone() {
        return new Diamond(this);
    }

}
