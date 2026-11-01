package no.hvl.dat100.oppgave3;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;

public class Blogg {

	private Innlegg[] innleggtabell;
	private int nesteledig = 0;

	public Blogg() {

		innleggtabell = new Innlegg[20];
	}

	public Blogg(int lengde) {

		innleggtabell = new Innlegg[lengde];
	}

	public int getAntall() {

		return nesteledig;
	}
	
	public Innlegg[] getSamling() {

		return innleggtabell;
	}
	
	public int finnInnlegg(Innlegg innlegg) {

		int i = 0;
		boolean erFunnet = false;
		int funnetPos = -1;
		while ((i < nesteledig) && !(erFunnet)) {
			if (innleggtabell[i].erLik(innlegg)) {
				funnetPos = i;
				erFunnet = true;
			} else {
				i++;
			}
		}
		return funnetPos;
	}

	public boolean finnes(Innlegg innlegg) {

		int i = 0;
		boolean erFunnet = false;
		while ((i < nesteledig) && !(erFunnet)) {
			if (innleggtabell[i].erLik(innlegg)) {
				erFunnet = true;
			} else {
				i++;
			}
		}
		return erFunnet;
	}

	public boolean ledigPlass() {

		return nesteledig < innleggtabell.length;
	}


	public boolean leggTil(Innlegg innlegg) {

		if (ledigPlass() && !finnes(innlegg)) {
			innleggtabell[nesteledig] = innlegg;
			nesteledig++;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {

		String toPrint = getAntall() + "\n";
		for (int i = 0; i < nesteledig; i++) {
			toPrint += innleggtabell[i].toString();
		}
		return toPrint;
	}
}