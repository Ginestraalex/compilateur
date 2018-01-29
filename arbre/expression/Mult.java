package yal.arbre.expression;

import yal.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Mult extends BinaireArithmetique {

    public Mult(Expression gauche, Expression droite) {
        super(gauche, droite);
    }
  
    @Override
    public String operateur() {
        return " * ";
    }
    
    @Override
    public String toMIPS(){
        StringBuilder res=new StringBuilder();
        res.append(super.toMIPS()+"\n #Multiplication \n");
        res.append("mul $v0,$t8,$v0 \n");
        return res.toString();
    }

	@Override
	public void verifier() {
		// TODO Auto-generated method stub
		this.gauche.verifier();
		this.droite.verifier();
		if(!gauche.getType().equals("int")||!droite.getType().equals("int")) {
			throw new AnalyseSemantiqueException("Les expressions doivent être de type entier",droite.getNoLigne());
		}
	}

}
