package abilities;

import cards.Card;

public class HealCard extends Abilities{

private int heal;	
	
public HealCard(String ability, String range, int heal) {
	super(ability, range,heal,0,1,0,null,0,"HealCard");
	setHeal(heal);}

@Override
public int useOnSelf(Card card) {

return 0;}

@Override
public int useOnOther(Card card) {
	
return 0;}

@Override
public int useOnRow(Card card) {
	card.heal(getHeal());
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

public int getHeal() {
return heal;}

public void setHeal(int heal) {
	this.heal = heal;}

@Override
public Card createCard(Card card) {
	
return null;}
	
}
