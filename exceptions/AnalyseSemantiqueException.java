package yal.exceptions;

public class AnalyseSemantiqueException extends AnalyseException {

		public AnalyseSemantiqueException(String m,int ligne) {
	    		super("ERREUR SEMANTIQUE :\n\t ligne " + ligne +"\n\t" + m) ;
		}

	}

