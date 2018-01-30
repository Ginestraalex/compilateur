package yal.arbre.expression;

import yal.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class OuLogique extends BinaireLogique {

    public OuLogique(Expression gauche, Expression droite) {
        super(gauche, droite);
    }
    
    @Override
    public String operateur() {
        return " ou " ;
    }

    @Override
    public String toMIPS(){
        StringBuilder res=new StringBuilder();
        res.append(super.toMIPS()+"\n #Ou Logique \n");
        res.append("or $v0,$t8,$v0 \n");
        return res.toString();
    }

	@Override
	public void verifier() {
		// TODO Auto-generated method stub	
		this.gauche.verifier();
	    	this.droite.verifier();
	    	if(!gauche.getType().equals("bool")|| !droite.getType().equals("bool")){
				throw new AnalyseSemantiqueException("Les expressions deoivent être de type booléen", gauche.getNoLigne());
	    }
	}
}
