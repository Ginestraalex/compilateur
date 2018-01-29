package yal.arbre.expression;

import yal.exceptions.AnalyseSemantiqueException;

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
        return "-" ;
    }
    
    @Override
    public String toMIPS(){
        StringBuilder res=new StringBuilder();
        res.append(super.toMIPS()+"\n #Moins unaire \n");
        res.append("xori $v0,$v0,0xFFFFFFFF \n");
        res.append("addi $v0,$v0,1 \n");
        return res.toString();
    }

	@Override
	public void verifier() {
		// TODO Auto-generated method stub
		if(!this.expression.getType().equals("int")) {
			throw new AnalyseSemantiqueException("L'expression doit être de type int",expression.getNoLigne());
		}
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "int";
	}

}
