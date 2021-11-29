package tplogique;

/**
 *
 * @author 21700094
 */
public class Diamond extends Unaire{
    public Diamond(Formula a){
        super(a);
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
}
