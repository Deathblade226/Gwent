package controllers;

import java.util.ArrayList;

import abilities.BoostAllUnits;
import abilities.Consume;
import abilities.DamageUnit;
import abilities.Decoy;
import abilities.DestroyHighestUnit;
import abilities.HealCard;
import abilities.LeadeKingHenselt;
import abilities.LeaderBranTuirsach;
import abilities.LeaderEistTuirseach;
import abilities.LeaderJanCalveit;
import abilities.LeaderPrincessAdda;
import abilities.Medic;
import abilities.Summon;
import abilities.TeamUp;
import cards.Artifact;
import cards.Card;
import cards.Leader;
import cards.Special;
import cards.Unit;
import enums.Factions;
import enums.Type;
import models.Deck;
import traits.DeathWish;
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
	case 2: holder = new Card("Warrior",faction,Type.MELEE,3,3, new BoostAllUnits("Boost all units by 2.","Melee: ", 2),null); break; 		//Boost all units	//No Trait
	case 3: holder = new Card("Warrior",faction,Type.MELEE,3,3, new TeamUp("Boost self by 1 for each card with team up on your side.", "Row: ", 1), new Deploy("Deploy: This card uses its ability on place.")); break; 		//Team-Up 			//Deploy
	case 4: holder = new Card("Warrior",faction,Type.MELEE,3,3, new TeamUp("Boost self by 1 for each card with team up on your side.", "Row: ", 1), new Deploy("Deploy: This card uses its ability on place.")); break; 		//Team-Up 			//Deploy
	case 5: holder = new Card("Warrior",faction,Type.MELEE,3,3, new TeamUp("Boost self by 1 for each card with team up on your side.", "Row: ", 1), new Deploy("Deploy: This card uses its ability on place.")); break; 		//Team-Up 			//Deploy
	case 6: holder = new Card("Artillery",faction,Type.ARTILLERY,4,4, new DamageUnit("Damage an enemy unit for 2 damage.","Ranged: ",2), new DeathWish("Deathwish: This card uses its ability on death.")); break; //Boost a Unit		//Deploy
	case 7: holder = new Card("Artillery",faction,Type.ARTILLERY,4,4, new Consume("Consume a unit your side and add its current power to this card.","Ranged: "), new Deploy("Deploy: This card uses its ability on place.")); break; //Consume			//Deploy
	case 8: holder = new Card("Ranger",faction,Type.RANGED,5,5, new Medic("Bring a card back from your graveyard.","Ranged: "),null); break;		//Medic				//No Trait
	case 9: holder = new Card("Artillery",faction,Type.ARTILLERY,5,5,new BoostAllUnits("Boost all units by 2.","Artillery: ", 2),null); break; //Boost all units	//No Trait
	case 10: holder = new Card("Warrior",faction,Type.MELEE,6,6, new Summon("Summon 3 spiders (1 Power) to the melee row.","Melee: ", new Unit("Spider",Factions.UNKNOWN,Type.MELEE,1,1,null,null),3), new Deploy("Deploy: This card uses its ability on place.")); break;		//Summon			//Deploy
	case 11: holder = new Card("Artillery",faction,Type.ARTILLERY,6,6,null,null); break;//No Ability 		//No Trait
	case 12: holder = new Card("Ranger",faction,Type.RANGED,7,7, new DamageUnit("Damage an enemy unit for 2 damage.","Ranged: ",2), new DeathWish("Deathwish: This card uses its ability on death.")); break;		//Damage a unit		//Deathwish
	case 13: holder = new Card("Artillery",faction,Type.ARTILLERY,7,7,null,null); break;//No Ability 		//No Trait
	case 14: holder = new Card("Warrior",faction,Type.MELEE,7,7,null,null); break;		//No Ability 		//No Trait
	case 15: holder = new Card("Ranger",faction,Type.RANGED,8,8,null,null); break; 		//No Ability 		//No Trait
	case 16: holder = new Card("Artillery",faction,Type.ARTILLERY,8,8, new Summon("Summon 2 Mortar Cannon (1 Power) to the artillery row.","Artillery: ", new Unit("Mortar Cannon",Factions.UNKNOWN,Type.ARTILLERY,1,1,null,null),2), new Deploy("Deploy: This card uses its ability on place.")); break;//Summon			//Deploy
	case 17: holder = new Card("Ranger",faction,Type.RANGED,9,9,null,null); break;  	//No Ability 		//No Trait
	case 18: holder = new Card("Warrior",faction,Type.MELEE,9,9,null,null); break;		//No Ability 		//No Trait
	case 19: holder = new Card("Warrior",faction,Type.MELEE,10,10,null,null); break;}  	//No Ability 		//No Trait
return holder;}

public static Card artifacts() { //Only 2 Decoys
	Card decoy = new Artifact("Decoy",Factions.UNKNOWN,Type.ARTIFACT,1,1,new Decoy("Replace a unit card on your side with this card and add that unit to your hand.","No Range"),null);
return decoy;}

public static Card special(int spot, Factions faction) { //name, faction, type, powerBase, powerCurrent, ability, trait
	Card holder = null;
	switch(spot) {
	case 0: holder = new Special("Holy Light",faction,Type.SPECIAL,0,0, new BoostAllUnits("Boost all units by 2.","Special Card: ", 2),null); break; 	//Boost all units
	case 1: holder = new Special("Scorch",faction,Type.SPECIAL,0,0, new DestroyHighestUnit("Destroy the highest unit on the field.","Special Card: "),null); break;		//Destroy highest level
	case 2: holder = new Special("Thunder",faction,Type.SPECIAL,0,0, new DamageUnit("Damage an enemy unit for 5 damage.","Special Card: ",2),null); break;		//Damage a card by X amount				//Charges: 3
	case 3: holder = new Special("Thunder",faction,Type.SPECIAL,0,0, new DamageUnit("Damage an enemy unit for 5 damage.","Special Card: ",2),null); break;		//Damage a card by X amount				//Charges: 3			
	case 4: holder = new Special("Health Potion",faction,Type.SPECIAL,0,0, new HealCard("Heal a unit card for 5 points.","Special Card: ",5),null); break;		//Heal a card by X						
	case 5: holder = new Special("Health Potion",faction,Type.SPECIAL,0,0, new HealCard("Heal a unit card for 5 points.","Special Card: ",5),null); break;		//Heal a card by X
	case 6: holder = new Special("Spider Eggs",faction,Type.SPECIAL,0,0, new Summon("Summon 3 spiders (1 Power) to the melee row.","Melee: ", new Unit("Spider",Factions.UNKNOWN,Type.MELEE,1,1,null,null),3),null); break;		//Summon X SomeMonster (1 power) units
	case 7: holder = new Special("Spider Eggs",faction,Type.SPECIAL,0,0, new Summon("Summon 3 spiders (1 Power) to the melee row.","Melee: ", new Unit("Spider",Factions.UNKNOWN,Type.MELEE,1,1,null,null),3),null); break;		//Summon X SomeMonster (1 power) units
	case 8: holder = new Special("Revive",faction,Type.SPECIAL,0,0, new Medic("Revives a card from your grave yard.","Special Card: "),null); break;		//Revive a card
	case 9: holder = new Special("Revive",faction,Type.SPECIAL,0,0, new Medic("Revives a card from your grave yard.","Special Card: "),null); break;}	//Revive a card
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
