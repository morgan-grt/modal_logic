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
    private boolean flag;
    
    public Atom(String proposition, boolean f){
        this.proposition = proposition;
        this.top = false;
        this.bot = false;
        flag = f;
    }
    
    public Atom(String proposition){
        this(proposition, false);
    }
    public Atom(boolean top, String proposition){
        this(proposition);
        this.top = top;
    }
    
    public Atom(String proposition, boolean f, boolean top, boolean bot){
        this(proposition, f);
        this.top = top;
        this.bot = bot;
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
    public boolean isModelTrueForThisWorld(Model model, World world) {
        return world.get().contains(this) || top;
    }

    @Override
    public Formula getA() {
        return null;
    }

    @Override
    public Formula getB() {
        return null;
    }

    @Override
    public Formula clone() {
        return new Atom(proposition, flag, top, bot);
    }
}
