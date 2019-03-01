package abilities;

import cards.Card;

public class Summon extends Abilities{

private int power = 1;	
private int summonNumber = 1;
private String name;

public Summon(String ability, String range, int power, int summonNumber) {
	super(ability, range);
	this.setPower(power);
	this.setSummonNumber(summonNumber);}

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

public Card summon() {
	Card summon = new Card("Nothing", null, null, getPower(), getPower(), null, null);;
return summon;}

public int getPower() {
return power;}

public void setPower(int power) {
	this.power = power;}

public int getSummonNumber() {
return summonNumber;}

public void setSummonNumber(int summonNumber) {
	this.summonNumber = summonNumber;}

public String getName() {
return name;}

public void setName(String name) {
	this.name = name;}
	
@Override
public Card createCard(Card card) {
	
return null;}

}
