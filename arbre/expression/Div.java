package yal.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Div extends BinaireArithmetique {

    public Div(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

    @Override
    public String operateur() {
        return " / ";
    }
    
    @Override
    public String toMIPS(){
        StringBuilder res= new StringBuilder();
        res.append(super.toMIPS()+"\n #Division \n");
        res.append("div $v0,$t8,$v0 \n");
        return res.toString();
    }

	@Override
	public void verifier() {
		// TODO Auto-generated method stub
		
	}
}
