package tplogique;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 21700094
 */
public class World {
    private List<Atom> atomList;
    
    public World(List<Atom> list){atomList = list;}
    public World(Atom a){atomList = new ArrayList();atomList.add(a);}
    
    public List<Atom> get(){
        return atomList;
    }
    
    @Override
    public String toString(){
        return "Atomes :" + atomList + "\n";
        
    }
}
