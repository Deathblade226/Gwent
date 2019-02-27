package models;

import java.util.ArrayList;

import cards.Card;
import enums.Factions;

public class Player {

private String name;	
private ArrayList<Card> hand = new ArrayList<>();
private Card[][] field = new Card[3][9];
private Factions faction;
private int currentPoints;

public Player(String name, Factions faction) {
	this.setName(name);
	this.setFaction(faction);}

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

public int getCurrentPoints() {
return currentPoints;}

public void setCurrentPoints(int currentPoints) {
	this.currentPoints = currentPoints;}

@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append(getName()).append("\n").append(getFaction()).append("\nCurrent Score: ").append(getCurrentPoints());
	return builder.toString();}	

}
