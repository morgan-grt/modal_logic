package tplogique;

/**
 *
 * @author 21700094
 */
public interface Formula {
    public boolean isModelTrueForThisWorld(Model model, World world);
    public boolean getFlag();
    public Formula getA();
    public Formula getB();
    public Formula clone();
}
