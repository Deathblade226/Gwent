package models;

import java.util.ArrayList;

import cards.Card;
import interfaces.Shuffle;

public class Deck implements Shuffle{

private ArrayList<Card> deck = new ArrayList<>();
private Card leader;

public Deck(ArrayList<Card> deck, Card leader) {
	super();
	this.setDeck(deck);
	this.setLeader(leader);}

@Override
public void shuffle(ArrayList<Card> deck) {

}

public Card getLeader() {
return leader;}

public void setLeader(Card leader) {
	this.leader = leader;}

public ArrayList<Card> getDeck() {
return deck;}

public void setDeck(ArrayList<Card> deck) {
	this.deck = deck;}	

}
