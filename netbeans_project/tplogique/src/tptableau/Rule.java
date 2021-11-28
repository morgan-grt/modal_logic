package tptableau;

import tplogique.Formula;

/**
 *
 * @author 21700094
 */
public abstract class Rule {
    public Rule(){}
    
    public abstract Formula canBeApplied(Tableau t);
    public abstract void apply(Formula f, Tableau t);
}
