package no.hvl.dat100.jplab11.oppgave4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.Innlegg;
import no.hvl.dat100.jplab11.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {

		PrintWriter writer; 
		boolean fullført = false;
		int forsøk = 0; 
		
		while (forsøk < 2 && !fullført) {
			try {
				writer = new PrintWriter(mappe + "\\" + filnavn);
				Innlegg[] innlegg = samling.getSamling();
				for (int i = 0; i<samling.getAntall(); i++) {
					writer.println(innlegg[i].toString());
				}
				fullført = true; 
			} catch (FileNotFoundException e) {
				System.out.println("Oppretter fil");
				File f = new File(mappe + "\\" + filnavn, "UTF8");
				try {
					f.createNewFile();
				} catch (IOException e1) {
					if (forsøk < 1) {
						System.out.println("Feil oppdaget, prøv å kjør program som administrator");
					}
				}
			}
			forsøk++;
		}
		return fullført;
		
	}
}
