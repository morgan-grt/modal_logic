package tplogique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author 21700094
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Formula f = new Iff(new Atom("A"), new Atom("B"));
        System.out.println(f);
        
        List<String> letters = Arrays.asList("A", "B", "C", "D", "E", "F");
        List<Atom> atoms = new ArrayList();
        Set<World> worlds = new WorldGenerator(letters).generate(2);
        Map<World, Set<World>> worldMap = new HashMap();
        for (World world : worlds){
            worldMap.put(world, worlds);
        }
        Model model = new Model(worlds, worldMap);
        
        System.out.println(worlds);
        System.out.println(model.worldIsValid(f));
        
    }
    
}
