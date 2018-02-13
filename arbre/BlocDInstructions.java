package yal.arbre;

import java.util.ArrayList;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class BlocDInstructions extends ArbreAbstrait {
    
    protected ArrayList<Instruction> ins;
    private int taille;
    
    public BlocDInstructions(int n) {
        super(n) ;
        ins=new ArrayList<Instruction>();
    }
    
    public void ajouter(Instruction a) {
        ins.add(a);
    }
    
    @Override
    public String toString() {
        return ins.toString() ;
    }

	@Override
	public void verifier() {
		// TODO Auto-generated method stub
		taille=TableSymbole.getInstance().getTaille();
		for(ArbreAbstrait arb:ins) {
			arb.verifier();
		}
	}

	@Override
	public String toMIPS() {
		// TODO Auto-generated method stub
		StringBuilder res= new StringBuilder();
		res.append(".text \n");
		res.append("main: \n");
		res.append(" # initialisation de la base des variables \n");
		res.append("move $s7,$sp \n");
		res.append("addi $sp,$sp,-"+taille+"\n");
		res.append("li $t8,0 \n");
		for (int i=0;i<taille;i+=4) {
        res.append("sw $t8, -"+i);
        	res.append("($s7)\n");
        }
		for(ArbreAbstrait arb:ins) {
			res.append("\n"+arb.toMIPS());
		}
		res.append("\n end :\n" + 
				"         move $v1, $v0      # copie de v0 dans v1 pour permettre les tests de plic0\n" + 
				"         li $v0, 10               # retour au système\n" + 
				"         syscall");
		return res.toString();
		}

}
