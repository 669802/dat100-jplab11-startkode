package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg {

	private Innlegg[] innleggstabell;
	private int nesteledige = 0; 
	

	public Blogg() {
		
		this.innleggstabell = new Innlegg[20];
		
	}

	public Blogg(int lengde) {
		
		this.innleggstabell = new Innlegg[lengde];
		
	}

	public int getAntall() {
		
		return this.nesteledige;
		
	}
	
	public Innlegg[] getSamling() {
		
		return this.innleggstabell; 

	}
	
	public int finnInnlegg(Innlegg innlegg) {

		boolean funnet = false;
		int i = 0;
		
		while (!funnet && i<this.getAntall()) {
			if (innleggstabell[i].erLik(innlegg)) {
				funnet = true; 
			} else {
				i++;
			}
		} 
		
		return !funnet ? -1 : i;
		
	}

	public boolean finnes(Innlegg innlegg) {
		
		return this.finnInnlegg(innlegg) >= 0;
		
	}

	public boolean ledigPlass() {
		
		return this.getAntall() < innleggstabell.length; 

	}
	
	public boolean leggTil(Innlegg innlegg) {

		if (this.ledigPlass()) {
			this.innleggstabell[this.nesteledige] = innlegg;
			this.nesteledige++;
			return true;
		} else {
			return false;
		}
		
	}
	
	public String toString() {
		
		String output = Integer.toString(this.getAntall()) + "\n";
		
		for (int i = 0; i<this.getAntall(); i++) {
			output += innleggstabell[i].toString();
		}
		
		return output;
		
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());
		
	}
	
	public boolean slett(Innlegg innlegg) {
		
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public int[] search(String keyword) {
		
		throw new UnsupportedOperationException(TODO.method());

	}
}