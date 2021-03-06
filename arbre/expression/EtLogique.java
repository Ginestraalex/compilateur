package yal.arbre.expression;

import yal.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class EtLogique extends BinaireLogique {

    public EtLogique(Expression gauche, Expression droite) {
        super(gauche, droite);
    }
    
    @Override
    public String operateur() {
        return " et " ;
    }
    
    @Override
    public String toMIPS(){
        StringBuilder res=new StringBuilder();
        res.append("#Et logique \n");
        res.append(gauche.toMIPS()+"\n");
        res.append("sw $v0,($sp)\n");
        res.append("add $sp,$sp,-4 \n");
        res.append(droite.toMIPS()+"\n");
        res.append("add $sp,$sp,4 \n");
        res.append("lw $t8,($sp)\n");
        res.append("and $v0,$t8,$v0");
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
