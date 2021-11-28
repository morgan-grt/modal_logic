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
}
