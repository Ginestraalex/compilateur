package yal.arbre.expression;

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
		
	}

	@Override
	public String toMIPS() {
		// TODO Auto-generated method stub
		StringBuilder res= new StringBuilder();
		res.append(ExpressionEval());
		res.append("# addition \n");
		res.append("add $v0,$v0,$t8 \n");
		return res.toString();
	}

}
