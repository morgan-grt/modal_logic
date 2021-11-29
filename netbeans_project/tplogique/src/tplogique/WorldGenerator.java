package tplogique;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author 21700094
 */
public class WorldGenerator {
    private List<String> letters;
    
    public WorldGenerator(List<String> list){
        letters = list;
    }
    
    public Set<World> generate(int size){
        Set<World> worlds = new HashSet();
        Random random = new Random();
        
        for (int i = 0; i < size; i++){  
            List<Atom> atoms = new ArrayList();        
            for (String letter : letters){
                if (random.nextBoolean())
                    atoms.add(new Atom(letter));
            }
            worlds.add(new World("", atoms));
        }
        return worlds;
    }
}
