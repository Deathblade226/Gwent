package controllers;

import java.util.ArrayList;

import abilities.Abilities;
import abilities.BoostSomeUnits;
import abilities.Decoy;
import abilities.LeadeKingHenselt;
import abilities.LeaderBranTuirsach;
import abilities.LeaderEistTuirseach;
import abilities.LeaderJanCalveit;
import abilities.LeaderPrincessAdda;
import abilities.NoAbility;
import cards.Artifact;
import cards.Card;
import cards.Leader;
import cards.Special;
import enums.Factions;
import enums.Type;
import models.Deck;
import traits.Charge;
import traits.DeathWish;
import traits.Deploy;
import traits.NoTrait;
import traits.Summon;

public class DeckBuilder {

public static Deck deckBuilder(Factions faction) {
	boolean valid = true;
	Deck deck = null;
	ArrayList<Card> cards = new ArrayList<>();
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
	deck = new Deck(cards, leader);
}while (!valid);
return deck;}

public static ArrayList<Card> cards(Factions faction) { //20 unit, 2 artifact, and 10 Special for a total of 32
	ArrayList<Card> cards = new ArrayList<>();
	int units = 20;
	int artifacts = 2;
	int special = 10;
	
	for (int i = 0; i < units; i++) {
	Card a = units(faction, i);
	cards.add(a);}
	for (int i = 0; i < artifacts; i++) {
	Card a = artifacts();
	cards.add(a);}
	for (int i = 0; i < special; i++) {
	Card a = special(i, faction);
	cards.add(a);}
	
return cards;}

public static Card units(Factions faction, int spot) {
	Card holder = null;
	switch(spot) { //[10,9,9,8,8,7,7,7,6,6,5,5,4,4,3,3,3,3,2,2] "Name","faction","Type","PowerBase","PowerCurrent","Ability","Trait"
	case 0: holder = new Card("Unit1",faction,Type.UNIT,2,2,null,null); break;
	case 1: holder = new Card("Unit2",faction,Type.UNIT,2,2,null,null); break;
	case 2: holder = new Card("Unit3",faction,Type.UNIT,3,3,null,null); break;
	case 3: holder = new Card("Unit4",faction,Type.UNIT,3,3,null,null); break;
	case 4: holder = new Card("Unit5",faction,Type.UNIT,3,3,null,null); break;
	case 5: holder = new Card("Unit6",faction,Type.UNIT,3,3,null,null); break;
	case 6: holder = new Card("Unit7",faction,Type.UNIT,4,4,null,null); break;
	case 7: holder = new Card("Unit8",faction,Type.UNIT,4,4,null,null); break;
	case 8: holder = new Card("Unit9",faction,Type.UNIT,5,5,null,null); break;
	case 9: holder = new Card("Unit10",faction,Type.UNIT,5,5,null,null); break;
	case 10: holder = new Card("Unit11",faction,Type.UNIT,6,6,null,null); break;
	case 11: holder = new Card("Unit12",faction,Type.UNIT,6,6,null,null); break;
	case 12: holder = new Card("Unit13",faction,Type.UNIT,7,7,null,null); break;
	case 13: holder = new Card("Unit14",faction,Type.UNIT,7,7,null,null); break;
	case 14: holder = new Card("Unit15",faction,Type.UNIT,7,7,null,null); break;
	case 15: holder = new Card("Unit16",faction,Type.UNIT,8,8,null,null); break;
	case 16: holder = new Card("Unit17",faction,Type.UNIT,8,8,null,null); break;
	case 17: holder = new Card("Unit18",faction,Type.UNIT,9,9,null,null); break;
	case 18: holder = new Card("Unit19",faction,Type.UNIT,9,9,null,null); break;
	case 19: holder = new Card("Unit20",faction,Type.UNIT,10,10,null,null); break;}
return holder;}

public static Card artifacts() { //Only 2 Decoys
	Card decoy = new Artifact("Decoy",Factions.UNKNOWN,Type.ARTIFACT,0,0,new Decoy("Replace a unit card on your side with this card and add that unit to your hand.","No Range"),null);
return decoy;}

public static Card special(int spot, Factions faction) { //name, faction, type, powerBase, powerCurrent, ability, trait
	Card holder = null;
	switch(spot) {
	case 0: holder = new Special("Special1",faction,Type.SPECIAL,0,0,null,null); break;
	case 1: holder = new Special("Special2",faction,Type.SPECIAL,0,0,null,null); break;
	case 2: holder = new Special("Special3",faction,Type.SPECIAL,0,0,null,null); break;
	case 3: holder = new Special("Special4",faction,Type.SPECIAL,0,0,null,null); break;
	case 4: holder = new Special("Special5",faction,Type.SPECIAL,0,0,null,null); break;
	case 5: holder = new Special("Special6",faction,Type.SPECIAL,0,0,null,null); break;
	case 6: holder = new Special("Special7",faction,Type.SPECIAL,0,0,null,null); break;
	case 7: holder = new Special("Special8",faction,Type.SPECIAL,0,0,null,null); break;
	case 8: holder = new Special("Special9",faction,Type.SPECIAL,0,0,null,null); break;
	case 9: holder = new Special("Special10",faction,Type.SPECIAL,0,0,null,null); break;}
return holder;}

public static Card leaderBSGD() {
	Card leader = new Leader("Raymond Maple", Factions.BSGD, Type.LEADER, 14, 14, new LeaderPrincessAdda("Damage a unit for 8 damage.","No Range"), null);
return leader;}

public static Card leaderBSIS() {
	Card leader = new Leader("Orrian Rich", Factions.BSIS, Type.LEADER, 14, 14, new LeaderEistTuirseach("Revive a dead unit from your graveyard.","No Range"), null);
	return leader;}

public static Card leaderBSTM() {
	Card leader = new Leader("Jeremiah Stroup", Factions.BSTM, Type.LEADER, 14, 14, new LeadeKingHenselt("Clone a unit card on your side of the field.","No Range"), null);
	return leader;}

public static Card leaderBSWD() {
	Card leader = new Leader("Tom Beatty", Factions.BSWD, Type.LEADER, 14, 14, new LeaderBranTuirsach("Discard a card, then draw a card. Whenever you discard a card, damage a random enemy by 1.","No Range"), null);
	return leader;}

public static Card leaderBSCS() {
	Card leader = new Leader("Ryan Cox", Factions.BSCS, Type.LEADER, 14, 14, new LeaderJanCalveit("Look at the top 3 cards from your deck and play one","No Range"), null);
	return leader;}

/**	
public static Abilities randAbility() {
	Abilities holder = null;
	int rng = lib.ConsoleIO.randInt(1, 23);
	switch(rng) {
	case 1: holder = new NoAbility(); break;
	case 2: holder = new NoAbility(); break;
	case 3: holder = new NoAbility(); break;
	case 4: holder = new NoAbility(); break;
	case 5: holder = new NoAbility(); break;
	case 6: holder = new NoAbility(); break;
	case 7: holder = new NoAbility(); break;
	case 8: holder = new NoAbility(); break;
	case 9: holder = new NoAbility(); break;
	case 10: holder = new NoAbility(); break;
	case 11: holder = new BoostAllUnits(); break;
	case 12: holder = new BoostAUnit(); break;
	case 13: holder = new BoostSomeUnits(); break;
	case 14: holder = new (); break;
	case 15: holder = new (); break;
	case 16: holder = new (); break;
	case 17: holder = new (); break;
	case 18: holder = new (); break;
	case 19: holder = new (); break;
	case 20: holder = new (); break;
	case 21: holder = new (); break;
	case 22: holder = new (); break;
	case 23: holder = new (); break;
	}
return holder;}

public static Trait randTraitUnit(Abilities ability) {
	Trait holder = null;
	int rng = lib.ConsoleIO.randInt(1, 10);
	int charges = lib.ConsoleIO.randInt(2, 3);
	switch(rng) {
	case 1: holder = new NoTrait("No Trait"); break;
	case 2:	holder = new NoTrait("No Trait"); break;
	case 3:	holder = new NoTrait("No Trait"); break;
	case 4:	holder = new NoTrait("No Trait"); break;
	case 5:	holder = new NoTrait("No Trait"); break;
	case 6: if (ability != null) {holder = new DeathWish("Deathwish: Use ability on death.");} else {holder = new NoTrait("No Trait");} break;
	case 7:	if (ability != null) {holder = new Deploy("Deploy: Use ability on place.");} else {holder = new NoTrait("No Trait");} break;
	case 8:	holder = new Summon("Summon: Summon some 1 power unit cards."); break;
	case 9: if (ability != null) {holder = new Charge("Charge: Can use ability " + charges + " times.", charges);} else {holder = new NoTrait("No Trait");} break;
	case 10:holder = new NoTrait("No Trait"); break;}
return holder;}
**/
}
