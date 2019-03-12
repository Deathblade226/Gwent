package abilities;

import cards.Card;

public class LeaderPrincessAdda extends Abilities{ //Damage a unit by 8

private int damage = 8;	
	
public LeaderPrincessAdda(String ability, String range) {
	super(ability, range);}

@Override
public int useOnSelf(Card card) {
	
return 0;}

@Override
public int useOnOther(Card card) {
	card.damage(damage);
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

@Override
public Card createCard(Card card) {
	
return null;}

}