package tplogique;

import java.util.ArrayList;
import java.util.List;
import tptableau.Label;

/**
 *
 * @author 21700094
 */
public class Atom implements Formula{
    private String proposition;
    private boolean top, bot;
    private Label label;
    private boolean flag;
    
    public Atom(String proposition, Label l, boolean f){
        this.proposition = proposition;
        this.top = false;
        this.bot = false;
        label = l;
        flag = f;
    }
    
    public Atom(String proposition){
        this(proposition, new Label(), false);
    }
    public Atom(boolean top, String proposition){
        this(proposition);
        this.top = top;
    }
    
    @Override
    public String toString(){
        return proposition;
    }
    
    @Override
    public boolean equals(Object o){
        if (o == null || !(o instanceof Atom)) {
            return false;
        }
        Atom atom = (Atom) o;
        return (atom.proposition == null ? proposition == null : atom.proposition.equals(proposition));
    }

    @Override
    public boolean getFlag() {
        return flag;
    }
    
    @Override
    public Label getLabel() {
        return label;
    }

    @Override
    public List<Formula> getChildren() {
        return new ArrayList();
    }

    @Override
    public boolean isModelTrueForThisWorld(Model model, World world) {
        return world.get().contains(this) || top;
    }
}
