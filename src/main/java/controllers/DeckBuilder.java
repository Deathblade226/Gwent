package controllers;

import abilities.BoostSomeUnits;
import cards.Artifact;
import cards.Card;
import cards.Leader;
import enums.Factions;
import enums.Type;
import models.Deck;
import traits.Charge;

public class DeckBuilder {

public Deck deckBuilder(Factions faction) {
	boolean valid = true;
	Deck deck = null;
	Card[] cards = null;
do {Card leader = null;
	cards = cards(faction);
	switch(faction) {
	case BSGD: leader = leaderBSGD(); valid = true; break;
	case BSIS: leader = leaderBSIS(); valid = true; break;
	case BSTM: leader = leaderBSTM(); valid = true; break;
	case BSWD: leader = leaderBSWD(); valid = true; break;
	case BSCS: leader = leaderBSCS(); valid = true; break;
	case UNKNOWN: valid = false; break;
	default: valid = false; break;}
	deck = new Deck(null, leader);
}while (!valid);
return deck;}

public Card[] cards(Factions faction) { //20 unit, 2 artifact, and 10 Special for a total of 32
	Card[] cards = new Card[32];
	int units = 20;
	int artifacts = 2;
	int special = 10;
	
	for (int i = 0; i < units; i++) {
	Card a = units(faction);
	cards[cards.length] = a;
	}
	for (int i = 0; i < artifacts; i++) {
		
	}
	for (int i = 0; i < special; i++) {
	
	}
	
return cards;}

public Card units(Factions faction) {

return null;}

public Card artifacts() {
	Card a = new Artifact("Thunderbolt", Factions.UNKNOWN, Type.ARTIFACT, 0, 0, new BoostSomeUnits("Boost an ally by 3", "Ally", 3), new Charge("Charges", 2));
return null;}

public Card special() {
	
return null;}

public static Card leaderBSGD() {
	Card leader = new Leader("Raymond Maple", Factions.BSGD, Type.LEADER, 14, 14, null, null);
return leader;}

public static Card leaderBSIS() {
	Card leader = new Leader("Orrian Rich", Factions.BSIS, Type.LEADER, 14, 14, null, null);
	return leader;}

public static Card leaderBSTM() {
	Card leader = new Leader("Jeremiah Stroup", Factions.BSTM, Type.LEADER, 14, 14, null, null);
	return leader;}

public static Card leaderBSWD() {
	Card leader = new Leader("Tom Beatty", Factions.BSWD, Type.LEADER, 14, 14, null, null);
	return leader;}

public static Card leaderBSCS() {
	Card leader = new Leader("Ryan Cox", Factions.BSCS, Type.LEADER, 14, 14, null, null);
	return leader;}
	
	
	
}
