package yal.arbre;

import java.util.ArrayList;

import yal.arbre.instruction.Instruction;
import yal.arbre.tds.TableSymbole;

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
		StringBuilder res=new StringBuilder();
		// TODO Auto-generated method stub
		for(ArbreAbstrait arb:ins) {
			res.append("\n"+arb.toMIPS());
		}
		return res.toString();
	}

}
