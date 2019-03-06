package controllers;

import java.util.ArrayList;

import abilities.Decoy;
import abilities.LeadeKingHenselt;
import abilities.LeaderBranTuirsach;
import abilities.LeaderEistTuirseach;
import abilities.LeaderJanCalveit;
import abilities.LeaderPrincessAdda;
import abilities.Summon;
import cards.Artifact;
import cards.Card;
import cards.Leader;
import cards.Special;
import enums.Factions;
import enums.Type;
import models.Deck;
import traits.Deploy;

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

//Charge only for special
//Deploy and dethwish are card specific

public static Card units(Factions faction, int spot) {
	Card holder = null; 
	switch(spot) { //[10,9,9,8,8,7,7,7,6,6,5,5,4,4,3,3,3,3,2,2] "Name","faction","Type","PowerBase","PowerCurrent","Ability","Trait" //11 abilities / 9 no abilitys
	case 0: holder = new Card("Ranger",faction,Type.RANGED,2,2,null,null); break; 		//No Ability 		//No Trait
	case 1: holder = new Card("Ranger",faction,Type.RANGED,2,2,null,null); break; 		//No Ability 		//No Trait
	case 2: holder = new Card("Warrior",faction,Type.MELEE,3,3,null,null); break; 		//Boost all units	//No Trait
	case 3: holder = new Card("Warrior",faction,Type.MELEE,3,3,null,null); break; 		//Team-Up 			//Deploy
	case 4: holder = new Card("Warrior",faction,Type.MELEE,3,3,null,null); break; 		//Team-Up 			//Deploy
	case 5: holder = new Card("Warrior",faction,Type.MELEE,3,3,null,null); break; 		//Team-Up 			//Deploy
	case 6: holder = new Card("Artillery",faction,Type.ARTILLERY,4,4,null,null); break; //Boost a Unit		//Deploy
	case 7: holder = new Card("Artillery",faction,Type.ARTILLERY,4,4,null,null); break; //Consume			//Deploy
	case 8: holder = new Card("Ranger",faction,Type.RANGED,5,5,null,null); break;		//Medic				//No Trait
	case 9: holder = new Card("Artillery",faction,Type.ARTILLERY,5,5,null,null); break; //Boost all units	//No Trait
	case 10: holder = new Card("Warrior",faction,Type.MELEE,6,6,null,null); break;		//Summon			//Deploy
	case 11: holder = new Card("Artillery",faction,Type.ARTILLERY,6,6,null,null); break;//No Ability 		//No Trait
	case 12: holder = new Card("Ranger",faction,Type.RANGED,7,7,null,null); break;		//Damage a unit		//Deathwish
	case 13: holder = new Card("Artillery",faction,Type.ARTILLERY,7,7,null,null); break;//No Ability 		//No Trait
	case 14: holder = new Card("Warrior",faction,Type.MELEE,7,7,null,null); break;		//No Ability 		//No Trait
	case 15: holder = new Card("Ranger",faction,Type.RANGED,8,8,null,null); break; 		//No Ability 		//No Trait
	case 16: holder = new Card("Artillery",faction,Type.ARTILLERY,8,8,null,null); break;//Summon			//Deploy
	case 17: holder = new Card("Ranger",faction,Type.RANGED,9,9,null,null); break;  	//No Ability 		//No Trait
	case 18: holder = new Card("Warrior",faction,Type.MELEE,9,9,null,null); break;		//No Ability 		//No Trait
	case 19: holder = new Card("Warrior",faction,Type.MELEE,10,10,null,null); break;}  	//No Ability 		//No Trait
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



}
