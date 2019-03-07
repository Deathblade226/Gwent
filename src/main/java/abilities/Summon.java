package abilities;

import cards.Card;

public class Summon extends Abilities{

private int summonNumber = 1;
private String name;
private Card summon;

public Summon(String ability, String range, Card summon, int summonNumber) {
	super(ability, range,0,0,0,0,summon,summonNumber,"Summon");
	setSummon(summon);
	setSummonNumber(summonNumber);}

@Override
public int useOnSelf(Card card) {

return 0;}

@Override
public int useOnOther(Card card) {
	
return 0;}

@Override
public int useOnRow(Card card) {
	
return 0;}

@Override
public int inFirstRow(Card card) {

return 0;}

@Override
public int inSecondRow(Card card) {

return 0;}

@Override
public int inLastRow(Card card) {
return 0;}

public int getSummonNumber() {
return summonNumber;}

public void setSummonNumber(int summonNumber) {
	if (summonNumber < 1) {summonNumber = 1;}
	this.summonNumber = summonNumber;}

public String getName() {
return name;}

public void setName(String name) {
	this.name = name;}
	
public Card getSummon() {
	return summon;}

public void setSummon(Card summon) {
	this.summon = summon;}

@Override
public Card createCard(Card card) {
	
return null;}

}
