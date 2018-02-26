package yal.arbre;

import java.util.ArrayList;

public class CodeCible extends ArbreAbstrait {
	
	protected ArrayList<Instruction> ins;
	private int taille;

	protected CodeCible(int no) {
		super(no);
		ins=new ArrayList<>();
		// TODO Auto-generated constructor stub
	}
	public void ajouter(Instruction a) {
        ins.add(a);
    }
	@Override
	public void verifier() {
		// TODO Auto-generated method stub
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
