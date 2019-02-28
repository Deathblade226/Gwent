package controllers;

import cards.Card;
import cards.Leader;
import enums.Factions;
import enums.Type;

public class DeckBuilder {


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
