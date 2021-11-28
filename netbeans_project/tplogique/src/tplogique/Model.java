package tplogique;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author 21700094
 */
public class Model {
    private Set<World> worldList;
    private Map<World, Set<World>> worldMap;
    
    public Model(Set<World> set, Map<World, Set<World>> map){
        worldList = set;
        worldMap = map;
    }
    
    public Set<World> getList(){
        return worldList;
    }
    
    public Map<World, Set<World>> getMap(){
        return worldMap;
    }
    
    public boolean worldIsValid(Formula f){
        for (World world : worldList){
            if (checkRules(world, f, true))
                return true;
        }
        return false;
    }
    
    public boolean checkRules(World world, Formula f, boolean bool){
        if (f instanceof Atom){
            if (world.get().contains(f))
                return (bool && true);
            else
                return false;
        }
        
        else if (f instanceof Neg) {
            return ! checkRules(world, f.getChildren().get(0), (bool));
        }
        
        else if (f instanceof And){
            return checkRules(world, f.getChildren().get(0), (bool))
                    && checkRules(world, f.getChildren().get(1), (bool));
        }
        
        else if (f instanceof Or){
            return checkRules(world, f.getChildren().get(0), (bool))
                    || checkRules(world, f.getChildren().get(1), (bool));
        }
        
        else if (f instanceof Implies){
            boolean boolLeft = checkRules(world, f.getChildren().get(0), (bool));
            boolean boolRight = checkRules(world, f.getChildren().get(1), (bool));
            return (!boolLeft || boolRight);
        }
        
        else if (f instanceof Iff){
            boolean boolLeft = checkRules(world, f.getChildren().get(0), (bool));
            boolean boolRight = checkRules(world, f.getChildren().get(1), (bool));
            return boolLeft == boolRight;
        }
        
        return bool;
    }
    
    
}
