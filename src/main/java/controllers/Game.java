package controllers;

import java.util.ArrayList;

import cards.Card;
import enums.Factions;
import models.Deck;
import models.Player;

public class Game {

private static Player[] players = new Player[2];
private static int startingPlayer;
private static int playerCurrent = startingPlayer;
private static boolean p1Pass = false;
private static boolean p2Pass = false;
private static int rounds = 1;
private static int p1Points = 0;
private static int p2Points = 0;
private static int p1Rounds = 0;
private static int p2Rounds = 0;
	
public static void start() {
	createPlayer(2);
	lib.ConsoleIO.lineBuilder("=", 40);
	flipcoin();
	gameRunning();}

public static void gameRunning() {
	boolean winner = false;
do {Player currentPlayer = players[playerCurrent%2];
	turnMenu(currentPlayer);
	playerCurrent++;
	if (p1Pass) {playerCurrent = 1;}
	else if (p2Pass) {playerCurrent = 2;}
	if (p1Pass && p2Pass) {winner = declareWinner();}
}while(!winner);}

public static void createPlayer(int size) {
	for (int i = 0; i < size; i++) {
	String name = lib.ConsoleIO.promptForInput("What is player " + (i+1) + "'s name: ", false);
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
do {lib.ConsoleIO.lineBuilder("=", 40);
	System.out.println("Round: " + rounds + ":");
	System.out.println(players[1] + ": " + p2Points);
	p2Field();
	System.out.println(players[0] + ": " + p1Points);
	p1Field();
	lib.ConsoleIO.lineBuilder("=", 40);
	System.out.println(player);
	String[] options = {"Play a card","Use card ability","End turn","Pass Turn","Add points Demo"};
	int in = lib.ConsoleIO.promptForMenuSelection(options, false);
	
	switch(in) {
	case 1: if (!played) {handMenu(player);} else {lib.ConsoleIO.lineBuilder("=", 40); System.out.println("You have already played this turn.");} played = true; break;
	case 2: System.out.println("WIP"); break;
	case 3: playing = false; break;
	case 4: playing = false; if (player == players[0]) {p1Pass = true;} else {p2Pass = true;} break;
	case 5: addPoints(player); break;}
}while (playing);}

public static void handMenu(Player player) {
	lib.ConsoleIO.lineBuilder("=", 40);
	ArrayList<Card> hand = player.getHand();
	for (int i = 0; i < hand.size(); i++) {
	System.out.println((i+1) + ") " + hand.get(i) + "\n");}
	System.out.println("0) Quit");
	lib.ConsoleIO.lineBuilder("=", 40);
	int in = lib.ConsoleIO.promptForInt("Enter Here: ", 0, hand.size());
	if (in != 0) {
	player.getField();	
		
	}
}

public static void addPoints(Player player) {
	int in = lib.ConsoleIO.promptForInt("How many points are you adding?: ", 0, Integer.MAX_VALUE);
	if (in != 0) {
	if (players[0] == player) {p1Points = in;}
	else if (players[1] == player) {p2Points = in;}}}

public static void flipcoin() {
	System.out.println(players[0] + " is heads");
	System.out.println(players[1] + " is tails");
	lib.ConsoleIO.lineBuilder("=", 40);
	int in = lib.ConsoleIO.randInt(1, 10);
	switch(in) {
	case 1: case 2: case 3: case 4: case 5: System.out.println("The coin landed heads, " + players[0] + " goes first."); startingPlayer = 0; break;
	case 6:	case 7: case 8: case 9: case 10:System.out.println("The coin landed tails, " + players[1] + " goes first."); startingPlayer = 1; break;}}

public static void graveyard(Player player) {
	for (int i = 0; i < player.getGraveyard().size(); i++) {
	System.out.println((i+1) + ")" + player.getGraveyard().get(i));}}

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
	Card[][] holder = players[i].getField();
	players[i].setField(clearFiled(holder));}}

public static Card[][] clearFiled(Card[][] holder){
	for (int i = 0; i < holder.length; i++) {
	for (int x = 0; x < holder[i].length; x++) {	
	holder[i][x] = null;}}
return holder;}

public static void p1Field() {
	Card[][] holder = players[0].getField();
	for(int i = 0; i < holder.length; i++) {
	for(int x = 0; x < holder[i].length; x++) {
	if (holder[i][x] == null) {System.out.print(" _ ");}else{
	if (i == 0 && holder[i][x] != null) {System.out.println(" M ");}	
	else if (i == 1 && holder[i][x] != null) {System.out.println(" R ");}	
	else if (i == 2 && holder[i][x] != null) {System.out.println(" A ");}}}
	System.out.println("");}}

public static void p2Field() {
	Card[][] holder = players[1].getField();
	for(int i = holder.length-1; i >= 0 ; i--) {
	for(int x = holder[i].length-1; x >= 0; x--) {
	if (holder[i][x] == null) {System.out.print(" _ ");}else{
	if (i == 0 && holder[i][x] != null) {System.out.println(" M ");}	
	else if (i == 1 && holder[i][x] != null) {System.out.println(" R ");}	
	else if (i == 2 && holder[i][x] != null) {System.out.println(" A ");}}}
	System.out.println("");}}

}
