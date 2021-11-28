package tplogique;

/**
 *
 * @author 21700094
 */
public class Box extends Unaire{
    public Box(Formula a){
        super(a);
    }
    
    @Override
    public String toString(){
        return "( □ " + getA() + " )";
    }

    @Override
    public boolean isModelTrueForThisWorld(Model model, World world) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
