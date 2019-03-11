package models;

import java.util.ArrayList;

import cards.Card;
import enums.Factions;

public class Player {

private String name;	
private ArrayList<Card> hand = new ArrayList<>();
private ArrayList<Card> holder = new ArrayList<>();
private ArrayList<Card> graveyard = new ArrayList<>();
private Card[][] field = new Card[3][9];
private Factions faction;
private Deck deck;

public Player(String name, Factions faction, Deck deck) {
	setName(name);
	setFaction(faction);
	setDeck(deck);
	drawCards(10);}

public String getName() {
return name;}

public void setName(String name) {
	this.name = name;}

public ArrayList<Card> getHand() {
return hand;}

public void setHand(ArrayList<Card> hand) {
	this.hand = hand;}

public Card[][] getField() {
return field;}

public void setField(Card[][] field) {
	this.field = field;}

public Factions getFaction() {
return faction;}

public void setFaction(Factions faction) {
	this.faction = faction;}

public ArrayList<Card> getGraveyard() {
return graveyard;}

public void setGraveyard(ArrayList<Card> gaveyard) {
	this.graveyard = gaveyard;}

public Deck getDeck() {
return deck;}

public void setDeck(Deck deck) {
	this.deck = deck;}

public void drawCards(int total) {
	if (total > deck.getDeck().size()) {total = deck.getDeck().size();}
	for (int i = 0; i < total; i++) {
	for (int x = 0; x < 1; x++)	{
	hand.add(deck.getDeck().get(x));
	deck.getDeck().remove(x);}}}

public Card takeRemoveCard(int spot) {
	Card take = getHand().get(spot);
	getHand().remove(spot);
return take;}

public ArrayList<Card> getHolder() {
return holder;}

public void setHolder(ArrayList<Card> holder) {
	this.holder = holder;}

@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append(getName()).append(": \tFaction: [").append(getFaction()).append("]");
	return builder.toString();}
}
