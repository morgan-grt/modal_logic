package tplogique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
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
        
        List<String> letters = Arrays.asList("A", "B", "C", "D", "E", "F");
        List<Atom> atoms = new ArrayList();
        Set<World> worlds = new WorldGenerator(letters).generate(2);
        Map<World, Set<World>> worldMap = new HashMap();
        for (World world : worlds){
            worldMap.put(world, worlds);
        }
        Model model = new Model(worlds, worldMap);
        
        //print(f);
        //print(worlds);
        
        // exemple cours
        exempleCours();
        exempleTP();
    }
    
    public static void exempleCours(){
        print("-----");
        print("Exemple Cours:");
        Formula f1_w1 = new Neg(new Atom("Φ"));
        Formula f2_w1 = new Box(new Box(new Atom("Φ")));
        Formula f1_w2 = new Box(new Atom("Φ"));
        Formula f1_w3 = new Diamond(new Atom("Φ"));
        Formula f1_w5 = new Box(new Atom("Φ"));
        Formula f2_w5 = new Box(new Neg(new Atom("Φ")));
        
        World w1 = new World("w1");
        World w2 = new World("w2");
        World w3 = new World("w3", new Atom("Φ"));
        World w4 = new World("w4", new Atom("Φ"));
        World w5 = new World("w5");
        
        Set<World> worlds = new HashSet();
        worlds.add(w1);
        worlds.add(w2);
        worlds.add(w3);
        worlds.add(w4);
        worlds.add(w5);
        
        Model model = new Model(worlds);
        Map<World, Set<World>> child_w = new HashMap();
        
        //creation successeur w1
        Set<World> w1_ws = new HashSet();
        w1_ws.add(w2);
        child_w.put(w1, w1_ws);
        
        //creation successeur w2
        Set<World> w2_ws = new HashSet();
        w2_ws.add(w3);w2_ws.add(w4);
        child_w.put(w2, w2_ws);
        
        //creation successeur w3
        Set<World> w3_ws = new HashSet();
        w3_ws.add(w5);w3_ws.add(w3);
        child_w.put(w3, w3_ws);
        
        //creation successeur w4
        Set<World> w4_ws = new HashSet();
        w4_ws.add(w5);
        child_w.put(w4, w4_ws);
        
        //creation successeur w5
        Set<World> w5_ws = new HashSet();
        child_w.put(w5, w5_ws);
        
        model.setMap(child_w);
        
        print(f1_w1.isModelTrueForThisWorld(model, w1));
        print(f2_w1.isModelTrueForThisWorld(model, w1));
        print(f1_w2.isModelTrueForThisWorld(model, w2));
        print(f1_w3.isModelTrueForThisWorld(model, w3));
        print(f1_w5.isModelTrueForThisWorld(model, w5));
        print(f2_w5.isModelTrueForThisWorld(model, w5));
    }
    
    public static void exempleTP(){
        print("-----");
        print("Exemple TP:");
        Formula f1_w0 = new Box(new Atom("P"));
        Formula f1_w3 = new Box(new Atom("P"));
        Formula f2_w3 = new Box(new Box(new Atom("P")));
        Formula f2_w0 = new Box(new Neg(new Atom("Q")));
        Formula f3_w3 = new Implies(new Box(new Atom("P")), new Atom("P"));
        Formula f3_w0 = new Box(new Diamond(new Atom("P")));
        Formula f4_w0 = new Diamond(new Neg(new Atom("Q")));
        Formula f1_w1 = new Box(new Atom(true, "T"));
        Formula f1_w2 = new Box(new Diamond(new Neg(new Atom("Q"))));
        
        World w0 = new World("w0", Arrays.asList(new Atom("P"), new Atom("Q")));
        World w1 = new World("w1", new Atom("P"));
        World w2 = new World("w2", new Atom("P"));
        World w3 = new World("w3");
        
        Set<World> worlds = new HashSet();
        worlds.add(w0);
        worlds.add(w1);
        worlds.add(w2);
        worlds.add(w3);
        
        Model model = new Model(worlds);
        Map<World, Set<World>> child_w = new HashMap();
        
        //creation successeur w0
        Set<World> w0_ws = new HashSet();
        w0_ws.add(w0);
        w0_ws.add(w1);
        w0_ws.add(w2);
        child_w.put(w0, w0_ws);
        
        //creation successeur w1
        Set<World> w1_ws = new HashSet();
        child_w.put(w1, w1_ws);
        
        //creation successeur w2
        Set<World> w2_ws = new HashSet();
        w2_ws.add(w0);w2_ws.add(w2);
        child_w.put(w2, w2_ws);
        
        //creation successeur w3
        Set<World> w3_ws = new HashSet();
        w3_ws.add(w1);w3_ws.add(w2);
        child_w.put(w3, w3_ws);
        
        model.setMap(child_w);
        
        print(f1_w0.isModelTrueForThisWorld(model, w0));
        print(f1_w3.isModelTrueForThisWorld(model, w3));
        print(f2_w3.isModelTrueForThisWorld(model, w3));
        print(f2_w0.isModelTrueForThisWorld(model, w0));
        print(f3_w3.isModelTrueForThisWorld(model, w3));
        print(f3_w0.isModelTrueForThisWorld(model, w0));
        print(f4_w0.isModelTrueForThisWorld(model, w0));
        print(f1_w1.isModelTrueForThisWorld(model, w1));
        print(f1_w2.isModelTrueForThisWorld(model, w2));
    }
    
    public static void print(Object o){
        System.out.println(o);
    }
    
}
