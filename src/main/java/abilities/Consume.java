package abilities;

import cards.Card;

public class Consume extends Abilities{

private int boost;
private int damage;

public Consume(String ability, String range) {
	super(ability, range);}

@Override
public int useOnSelf(Card card) {
	card.buff(getBoost());
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

public int getBoost() {
return boost;}

public void setBoost(int boost) {
	if (boost < 0) {boost = 0;}
	this.boost = boost;}

public int getDamage() {
return damage;}

public void setDamage(int damage) {
	this.damage = damage;}
	
@Override
public Card createCard(Card card) {
	
return null;}

}
