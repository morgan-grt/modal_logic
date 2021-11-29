package tplogique;

import java.util.HashMap;
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
    public Model(Set<World> set){
        this(set, new HashMap());
    }
    
    public void setMap(Map<World, Set<World>> map){
        this.worldMap = map;
    }
    
    public Set<World> getList(){
        return worldList;
    }
    
    public Map<World, Set<World>> getMap(){
        return worldMap;
    }
}
