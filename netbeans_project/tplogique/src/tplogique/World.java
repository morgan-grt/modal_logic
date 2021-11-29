package tplogique;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 21700094
 */
public class World {
    private String name;
    private List<Atom> atomList;
    
    public World(){atomList = new ArrayList();name = "";}
    public World(String name){
        this.name = name;
        atomList = new ArrayList();
    }
    public World(String name, List<Atom> list){
        this.name = name; 
        atomList = list;
    }
    public World(String name, Atom a){
        this(name);atomList.add(a);
    }
    
    public List<Atom> get(){
        return atomList;
    }
    
    public void add(Atom a){
        atomList.add(a);
    }
    
    @Override
    public String toString(){
        return "World: " + name + "-> Atomes :" + atomList + "\n";
        
    }
}
