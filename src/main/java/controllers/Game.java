package controllers;

import java.util.ArrayList;

import abilities.Abilities;
import abilities.NoAbility;
import cards.Card;
import enums.Factions;
import enums.Type;
import models.Deck;
import models.Player;

public class Game {

private static Player[] players = new Player[2];
private static int startingPlayer;
private static int playerCurrent;
private static boolean p1Pass = false;
private static boolean p2Pass = false;
private static int rounds = 1;
private static int p1Points = 0;
private static int p2Points = 0;
private static int p1Rounds = 0;
private static int p2Rounds = 0;
	
public static void start(int number) {
	createPlayer(number);
	flipcoin();
	gameRunning();}

public static void gameRunning() {
	boolean winner = false;
do {Player currentPlayer = players[playerCurrent%2];
	turnMenu(currentPlayer);
	
	if (currentPlayer.getHand().size() == 0) {
	if (currentPlayer == players[0]) {p1Pass = true;} else {p2Pass = true;}}
	
	playerCurrent++;
	if (p1Pass) {playerCurrent = 1;}
	else if (p2Pass) {playerCurrent = 2;}
	
	if (p1Pass && p2Pass) {winner = declareWinner();}
	
}while(!winner);}

public static void createPlayer(int size) {
	for (int i = 0; i < size; i++) {
	String name = lib.ConsoleIO.promptForInput("What is player " + (i+1) + "'s name: ", false);
	lib.ConsoleIO.lineBuilder("=", 40);
	System.out.println("Select Faction: ");
	String[] options = {"BSGD","BSIS","BSTM","BSWD","BSCS"};
	int in = lib.ConsoleIO.promptForMenuSelection(options, false);
	Factions faction = null;
	switch(in) {
	case 1: faction = Factions.BSGD; break;
	case 2: faction = Factions.BSIS; break;
	case 3: faction = Factions.BSTM; break;
	case 4: faction = Factions.BSWD; break;
	case 5: faction = Factions.BSCS; break;}
	Deck deck = DeckBuilder.deckBuilder(faction);
	Player a = new Player(name, faction, deck);	
	players[i] = a;
	System.out.println("");}}

public static void turnMenu(Player player) {//Demo menu
	boolean playing = true;
	boolean played = false;
	boolean mustPlay = true;
do {lib.ConsoleIO.lineBuilder("=", 40);
	System.out.println("Round: " + rounds + ":");
	System.out.println(players[1] + ": " + p2Points);
	p2Field();
	System.out.println(players[0] + ": " + p1Points);
	p1Field();
	lib.ConsoleIO.lineBuilder("=", 40);
	System.out.println(player);
	String[] options = {"Play a card","Use card ability","Use special card from hand","End turn","Pass Turn","View Graveyard"};
	int in = lib.ConsoleIO.promptForMenuSelection(options, false);
	
	switch(in) {
	case 1: if (!played) {boolean valid = handMenu(player);  if (valid) {mustPlay = false;}} else {lib.ConsoleIO.lineBuilder("=", 40); System.out.println("You have already played this turn.");} played = true; break;
	case 2: useAbility(player); break;
	case 3: System.out.println("WIP"); lib.ConsoleIO.lineBuilder("=", 40); break;
	case 4: if (!mustPlay) {playing = false;} else {System.out.println("You have to play a card or pass your turn.");} break;
	case 5: if (!played) {playing = false; if (player == players[0]) {p1Pass = true;} else {p2Pass = true;}}else {lib.ConsoleIO.lineBuilder("=", 40); System.out.println("You cant pass your turn because you played a card this turn.");} break;
	case 6: graveyard(player); break;}
	checkCards(player);
}while (playing);}

public static void fieldView(Player player) {
	boolean running = true;
do {lib.ConsoleIO.lineBuilder("=", 40);
	Card[][] field = player.getField();
	ArrayList<Card> holder = new ArrayList<>();
	for (int i = 0; i < field.length; i++) {
	for (int x = 0; x < field[i].length; x++) {
	if (field[i][x] != null && !(field[i][x].isUsed())) {holder.add(field[i][x]);}}}
	
	for (int i = 0; i < field.length; i++) {	
	System.out.println((i+1) + ") " + holder.get(i));}
	
	lib.ConsoleIO.lineBuilder("=", 40);
	int in = lib.ConsoleIO.promptForInt("Enter here: ", 0, holder.size());
	lib.ConsoleIO.lineBuilder("=", 40);
	
	if (in == 0) {running = false;}else {}
}while(running);}

public static void checkAbility() {
	
}

public static boolean handMenu(Player player) {
	boolean valid = true;
do {lib.ConsoleIO.lineBuilder("=", 40);
	ArrayList<Card> hand = player.getHand();
	for (int i = 0; i < hand.size(); i++) {
	System.out.println((i+1) + ") " + hand.get(i));}
	System.out.println("0) Quit");
	lib.ConsoleIO.lineBuilder("=", 40);
	int in = lib.ConsoleIO.promptForInt("Enter Here: ", 0, hand.size());
	if (in != 0) {valid = playCard(player, player.getHand().get(in-1), player.getField());
	if (valid) {player.takeRemoveCard(in-1);}}
	else if (in == 0) {valid = true;}
}while(!valid);
return valid;}

public static boolean playCard(Player player, Card card, Card[][] field) {
	boolean valid = true;
	int row1 = 0;
	int row2 = 0;
	int row3 = 0;
	for(int i = 0; i < 3; i++) {
	int holder = 0;	
	for(int x = 0; x < 9; x++) {
	if (field[i][x] != null) {holder++;}}
	switch(i) {
	case 0: row1 = holder; break;
	case 1: row2 = holder; break;
	case 2: row3 = holder; break;}}
	
	if (card.getType() == Type.MELEE) {
	if (row1 != 9) {field[0][row1] = card; addPoints(player);}	
	else {System.out.println("That row is filled."); valid = false;}}
	else if (card.getType() == Type.RANGED) {
	if (row2 != 9) {field[1][row2] = card; addPoints(player);}	
	else {System.out.println("That row is filled."); valid = false;}	}
	else if (card.getType() == Type.ARTILLERY) {
	if (row3 != 9) {field[2][row3] = card; addPoints(player);}	
	else {System.out.println("That row is filled."); valid = false;}}
	player.setField(field);
return valid;}

public static void addPoints(Player player) {
	Card[][] holder = player.getField();
	int points = 0;
	for (int i = 0; i < 3; i++) {
	for (int x = 0; x < 9; x++) {
	if (holder[i][x] != null) {points += holder[i][x].getPowerCurrent();}}}
	
	if (player == players[0]) {p1Points = points;} else {p2Points = points;}}

public static void addPointsDemo(Player player) {
	int in = lib.ConsoleIO.promptForInt("How many points are you adding?: ", 0, Integer.MAX_VALUE);
	if (in != 0) {
	if (players[0] == player) {p1Points = in;}
	else if (players[1] == player) {p2Points = in;}}}

public static void useAbility(Player player) {
	Card[][] field = player.getField();
	ArrayList<Card> holder = new ArrayList<>();
	Abilities blank = new NoAbility();
	lib.ConsoleIO.lineBuilder("=", 40);
	for (int i = 0; i < field.length; i++) {
	for (int x = 0; x < field[i].length; x++) {
	if (field[i][x] != null) {if (field[i][x].getAbility() != null && field[i][x].getAbility() != blank && !field[i][x].isUsed()) {holder.add(field[i][x]);}}}}
	for (int i = 0; i < holder.size(); i++) {
	System.out.println((i+1) + ") " + holder.get(i));}
	System.out.println("0) Quit");
	lib.ConsoleIO.lineBuilder("=", 40);
	int in = lib.ConsoleIO.promptForInt("Enter here: ", 0, holder.size());
	lib.ConsoleIO.lineBuilder("=", 40);
	if (in != 0) {checkAbility(holder.get(in-1),player); holder.get(in-1).setUsed(true);}}

public static void checkAbility(Card card, Player player) {
	switch(card.getAbility().getType()) {
	case "BoostAllUnits": boostAllUnits(card, player); break;
	case "BoostAUnits": boostAUnits(card, player); break;
	case "TeamUp": teamUp(card, player); break;
	case "Consume": consume(card, player); break;
	case "Medic": medic(card, player); break;
	case "Summon": summon(card, player); break;
	case "DamageUnit": Card holder = enemyField(player); if (holder != null) {damageCard(card, holder, player);} break;
	case "NoAbility": System.out.println("That card has no ability select a different card."); break;}}

public static void boostAUnits(Card card, Player player) {
	
}

public static void boostAllUnits(Card card, Player player) {
	Card[][] field = player.getField();
	int buff = card.getAbility().getBoost();
	for (int i = 0; i < field.length; i++) {
	for (int x = 0; x < field[i].length; x++) {
	if (field[i][x] != null) {field[i][x].buff(buff);}}}
	addPoints(player);}

public static void teamUp(Card card, Player player) {
	Card[][] field = player.getField();
	int boost = card.getAbility().getBoost();
	for (int i = 0; i < field.length; i++) {
	for (int x = 0; x < field[i].length; x++) {
	if (field[i][x] != null) {if (field[i][x].getAbility().getType() == "TeamUp") {field[i][x].buff(boost);}}}}}

public static void consume(Card card, Player player) {
	Card[][] field = player.getField();
	int power = 0;
	ArrayList<Card> holder = new ArrayList<>();
	for (int i = 0; i < field.length; i++) {
	for (int x = 0; x < field[i].length; x++) {
	if (field[i][x] != null && field[i][x] != card) {
	holder.add(field[i][x]);}}}

	for (int i = 0; i < holder.size(); i++) {
	System.out.println((i+1) + ") " + holder.get(i));}
	lib.ConsoleIO.lineBuilder("=", 40);
	int in = lib.ConsoleIO.promptForInt("What card are you eating: ", 0, holder.size());
	lib.ConsoleIO.lineBuilder("=", 40);
	if (in != 0) {power = holder.get(in-1).getPowerCurrent();
	holder.get(in-1).damage(power);
	card.buff(power);
	holder.get(in-1).setUsed(true);}}

public static void medic(Card card, Player player) {
	boolean valid = true;
	Card holder = null;
do {holder = graveyard(player);
	valid = playCard(player, holder, player.getField());
}while(!valid);	
	ArrayList<Card> graveyard = player.getGraveyard();
	for (int i = 0; i < graveyard.size(); i++) {
	if (graveyard.get(i) == holder) {graveyard.remove(i); i = graveyard.size(); card.setUsed(true);}}}

public static void flipcoin() {
	System.out.println(players[0] + " is heads");
	System.out.println(players[1] + " is tails");
	lib.ConsoleIO.lineBuilder("=", 40);
	int in = lib.ConsoleIO.randInt(1, 10);
	switch(in) {
	case 1: case 2: case 3: case 4: case 5: System.out.println("The coin landed heads, " + players[0] + " goes first."); startingPlayer = 0; playerCurrent = 0; break;
	case 6:	case 7: case 8: case 9: case 10:System.out.println("The coin landed tails, " + players[1] + " goes first."); startingPlayer = 1; playerCurrent = 1; break;}}

public static void checkCards(Player player) {
	for (int i = 0; i < 2; i++) {
	Card[][] field = player.getField();
	for (int x = 0; x < 3; x++) {
	int counter = 0;
	Card[] holder = new Card[9];
	for (int c = 0; c < 9; c++) {
	if (field[x][c] != null && field[x][c].isAlive() == false) {field[x][c].heal(field[x][c].getPowerBase()); player.getGraveyard().add(field[x][c]); field[x][c] = null;}
	if (field[x][c] != null && field[x][c].getPowerCurrent() != 0) {holder[counter] = field[x][c]; counter++;}}	
	field[x] = holder;}}}

//public static void checkCards() {
//	for (int i = 0; i < 2; i++) {
//	Player player = players[i];
//	for (int x = 0; x < 2; x++) {
//	Card[][] field = player.getField();
//	for (int z = 0; z < 2; z++) {	
//	if (field[x][z] != null && field[x][z].isAlive() == false) {field[x][z].heal(field[x][z].getPowerBase()); player.getGraveyard().add(field[x][z]); field[x][z] = null;}}}}}

public static void damageCard(Card damager, Card damaged, Player player) {
	int damage = damager.getAbility().getDamage();
	if (damaged.getPowerCurrent() < damage) {damage = damaged.getPowerCurrent();}
	if (player == players[1]) {
	if (p1Points < damage) {p1Points = 0;} else {p1Points -= damage;}	
	} else { if (p2Points < damage) {p2Points = 0;} else {
	p2Points -= damage;}}
	damaged.damage(damage);}

public static void summon(Card card, Player player) {
	Card summon = card.getAbility().getSummon();
	for (int i = 0; i < 3; i++) {		
	playCard(player, new Card(card.getAbility().getSummon().getName(),card.getAbility().getSummon().getFaction(),card.getAbility().getSummon().getType(),1,1,null,null),player.getField());}
	System.out.println(player + "\nSummoned : 3 \n" + summon);}

public static Card enemyField(Player player) {
	lib.ConsoleIO.lineBuilder("=", 40);
	ArrayList<Card> cards = new ArrayList<>();
	Card holder = null;
	Player otherPlayer = null;
	if (player == players[1]) {otherPlayer = players[0];} else {otherPlayer = players[1];}
	int counter = 1;
	Card[][] field = otherPlayer.getField();
	for (int i = 0; i < 3; i++) {for (int x = 0; x < 9; x++) {
	if (field[i][x] != null) {System.out.println(counter + ") " + field[i][x]); counter++; cards.add(field[i][x]);}}}
	System.out.println("\n0) Quit");
	if (counter != 0) {
	lib.ConsoleIO.lineBuilder("=", 40);
	int in = lib.ConsoleIO.promptForInt("What card are you selecting: ", 0, counter);
	if (in != 0) {holder = cards.get(in-1);}}
return holder;}

public static Card randEnemyField(Player player) {
	ArrayList<Card> cards = new ArrayList<>();
	Card holder = null;
	Player otherPlayer = null;
	if (player == players[1]) {otherPlayer = players[0];} else {otherPlayer = players[1];}
	Card[][] field = otherPlayer.getField();
	for (int i = 0; i < 3; i++) {for (int x = 0; x < 9; x++) {
	if (field[i][x] != null) {cards.add(field[i][x]);}}}
	int in = lib.ConsoleIO.randInt(0, cards.size());
	holder = cards.get(in);
return holder;}

public static Card graveyard(Player player) {
	lib.ConsoleIO.lineBuilder("=", 40);
	ArrayList<Card> graveyard = player.getGraveyard();
	Card holder = null;
	for (int i = 0; i < graveyard.size(); i++) {
	System.out.println((i+1) + ")" + player.getGraveyard().get(i));}
	System.out.println("0) Quit");
	lib.ConsoleIO.lineBuilder("=", 40);
	int in = lib.ConsoleIO.promptForInt("Enter Here: ", 0, player.getGraveyard().size());
	if (in != 0) {holder = graveyard.get(in-1);}
return holder;}

public static boolean declareWinner() {
	boolean gameWinner = false;
	if (p1Points > p2Points) {System.out.println(players[0] + " won that round.");}
	else if (p1Points < p2Points) {System.out.println(players[1] + " won that round.");}
	else if (p1Points == p2Points) {System.out.println("Both players tied."); rounds--;}
	if (rounds == 3) {
	if (p1Rounds > p2Rounds) {System.out.println(players[0] + " won the game."); gameWinner = true;}
	else if (p1Rounds < p2Rounds) {System.out.println(players[1] + " won the game."); gameWinner = true;}}
	postRound();
return gameWinner;}

public static void postRound() {
	if (startingPlayer == 1) {startingPlayer = 0;} else {startingPlayer = 1;}
	playerCurrent = startingPlayer;
	p1Points = 0;
	p2Points = 0;
	rounds++;
	for (int i = 0; i < 2; i++) {
	players[i].drawCards(3);
	Card[][] holder = players[i].getField();
	players[i].setField(clearFiled(holder));}}

public static Card[][] clearFiled(Card[][] holder){
	for (int o = 0; o < 2; o++) {
	ArrayList<Card> graveyard = players[o].getGraveyard();	
	for (int i = 0; i < holder.length; i++) {
	for (int x = 0; x < holder[i].length; x++) {
	if (holder[i][x] != null) {graveyard.add(holder[i][x]);}
	holder[i][x] = null;}}}
return holder;}

public static void p1Field() {
	Card[][] holder = players[0].getField();
	for(int i = 0; i < holder.length; i++) {
	for(int x = 0; x < holder[i].length; x++) {
	if (holder[i][x] == null) {System.out.print(" _ ");}else{
	if (i == 0 && holder[i][x] != null) {System.out.print(" M ");}	
	else if (i == 1 && holder[i][x] != null) {System.out.print(" R ");}	
	else if (i == 2 && holder[i][x] != null) {System.out.print(" A ");}}}
	System.out.println("");}}

public static void p2Field() {
	Card[][] holder = players[1].getField();
	for(int i = holder.length-1; i >= 0 ; i--) {
	for(int x = holder[i].length-1; x >= 0; x--) {
	if (holder[i][x] == null) {System.out.print(" _ ");}else{
	if (i == 0 && holder[i][x] != null) {System.out.print(" M ");}	
	else if (i == 1 && holder[i][x] != null) {System.out.print(" R ");}	
	else if (i == 2 && holder[i][x] != null) {System.out.print(" A ");}}}
	System.out.println("");}}

}
