package yal.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class MoinsUnaire extends Unaire {
    
    public MoinsUnaire(Expression expr) {
        super(expr);
    }

    @Override
    public String operateur() {
        return "- " ;
    }
    
    @Override
    public String toMIPS(){
        StringBuilder=new StringBuilder();
        res.append(super.toMIPS()+"#Moins unaire \n");
        res.append("xori $v0,$v0,0xFFFFFFFF \n");
        res.append("addi $v0,$v0,1 \n");
        return res.toString();
    }

}
