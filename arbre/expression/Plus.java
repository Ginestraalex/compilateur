package yal.arbre.expression;

import yal.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Plus extends BinaireArithmetique {

    public Plus(Expression gauche, Expression droite) {
        super(gauche, droite);
    }
    
    @Override
    public String operateur() {
        return " + " ;
    }

	@Override
	public void verifier() {
		// TODO Auto-generated method stub
		this.gauche.verifier();
		this.droite.verifier();
		if(!gauche.getType().equals("int")||!droite.getType().equals("int")) {
			throw new AnalyseSemantiqueException("Les expressions doivent être de type int",gauche.getNoLigne());
		}
	}

	@Override
	public String toMIPS() {
		// TODO Auto-generated method stub
		StringBuilder res = new StringBuilder();
		res.append(super.toMIPS()+"\n");
		res.append("# addition \n");
		res.append("add $v0,$v0,$t8 \n");
		return res.toString();
	}

}
