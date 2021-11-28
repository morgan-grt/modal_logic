package tplogique;

import java.util.List;
import tptableau.Label;

/**
 *
 * @author 21700094
 */
public interface Formula {
    public boolean isModelTrueForThisWorld(Model model, World world);
    public boolean getFlag();
    public Label getLabel();
    public List<Formula> getChildren();
}
