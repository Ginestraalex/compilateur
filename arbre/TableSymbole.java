package yal.arbre;

import java.util.HashMap;

public class TableSymbole {
	
	private static TableSymbole instance=new TableSymbole();
	
	private HashMap<Entree,Symbole> table;
	
	private TableSymbole() {
		table=new HashMap<Entree,Symbole>();
	}
	
	public void ajouter(Entree e,Symbole s) {
		table.put(e,s);
	}
	
	public static TableSymbole getInstance() {
		return instance;
	}
}
