package models;

import java.util.ArrayList;

import cards.Card;
import interfaces.Shuffle;

public class Deck implements Shuffle{

private ArrayList<Card> deck = new ArrayList<>();
private Card leader;

public Deck(ArrayList<Card> deck, Card leader) {
	super();
	setDeck(deck);
	setLeader(leader);
	shuffle(getDeck());}

@Override
public void shuffle(ArrayList<Card> deck) {
	for (int i = 0; i < deck.size(); i++){
	int index = lib.ConsoleIO.randInt(0, deck.size()-1);
	Card temp = deck.get(index);
	deck.set(index,deck.get(i));
	deck.set(i,temp);}
	setDeck(deck);}

public Card getLeader() {
return leader;}

public void setLeader(Card leader) {
	this.leader = leader;}

public ArrayList<Card> getDeck() {
return deck;}

public void setDeck(ArrayList<Card> deck) {
	this.deck = deck;}	

}
