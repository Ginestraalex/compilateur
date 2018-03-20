package yal.arbre.instruction;

import yal.arbre.tds.Symbole;
import yal.arbre.tds.TableSymbole;

public class SymboleFonction extends Symbole{
	private int taille;
	private int noRegion;
	private int noImbr;
	private String type;
	
	public SymboleFonction(String type) {
		this(type, TableSymbole.getInstance().getTaille(), TableSymbole.getInstance().getNumRegion(), TableSymbole.getInstance().getNumImbriquer());
	}

	public SymboleFonction(String type, int taille, int numRegion, int numImbriquer) {
		// TODO Auto-generated constructor stub
		taille=taille;
		type=type;
		noRegion=numRegion;
		noImbr=numImbriquer;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}

	@Override
	public int getPos() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int getNoRegion() {
		return noRegion;
	}
	
	public int getnoImbr() {
		return noImbr;
	}
	
	public int getTaille() {
		return taille;
	}

	public boolean isFonc() {
		// TODO Auto-generated method stub
		return true;
	}

}
