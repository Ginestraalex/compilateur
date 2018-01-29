package yal.arbre.expression;

import yal.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class NonLogique extends Unaire {
    
    public NonLogique(Expression expr) {
        super(expr);
    }

    @Override
    public String operateur() {
        return " non " ;
    }
    
    @Override
    public String toMIPS(){
        StringBuilder res=new StringBuilder();
        res.append(super.toMIPS()+"\n #Non Logique \n");
        res.append("xori $v0,$v0,1 \n");
        return res.toString();
    }

	@Override
	public void verifier() {
		// TODO Auto-generated method stub
		if(!expression.getType().equals("bool")) {
			throw new AnalyseSemantiqueException("Les expressions doivent être de type int",expression.getNoLigne());
		}
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

}
