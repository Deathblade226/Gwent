package abilities;

import cards.Card;

public class BoostSomeUnits extends Abilities{

private int boost;	

public BoostSomeUnits(String ability, String range, int boost, int howMany) {
	super(ability, range,0,0,howMany,boost,null,0,"BoostSomeUnits");
	setBoost(boost);}

@Override
public int useOnSelf(Card card) {

return 0;}

@Override
public int useOnOther(Card card) {
	card.buff(getBoost());
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

public int getBoost() {
return boost;}

public void setBoost(int boost) {
	if (boost < 0) {boost = 0;}
	this.boost = boost;}

@Override
public Card createCard(Card card) {
	
return null;}

}	
