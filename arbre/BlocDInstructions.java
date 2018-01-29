package yal.arbre;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class BlocDInstructions extends ArbreAbstrait {
    
    protected ArbreAbstrait expr ;
    
    public BlocDInstructions(int n) {
        super(n) ;
    }
    
    public void ajouter(ArbreAbstrait a) {
        expr = a ;
    }
    
    @Override
    public String toString() {
        return expr.toString() ;
    }

	@Override
	public void verifier() {
		// TODO Auto-generated method stub
		expr.verifier();
	}

	@Override
	public String toMIPS() {
		// TODO Auto-generated method stub
		StringBuilder res= new StringBuilder();
		res.append(".text \n");
		res.append("main: \n");
		res.append(" # initialisation de la base des variables");
		res.append("move $s7,$sp \n");
		res.append(expr.toMIPS()+"\n");
		res.append("end :\n" + 
				"         move $v1, $v0      # copie de v0 dans v1 pour permettre les tests de plic0\n" + 
				"         li $v0, 10               # retour au système\n" + 
				"         syscall");
		return res.toString();
		}

}
