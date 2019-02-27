package abilities;

import cards.Card;

public class DamageRange extends Abilities{

private int damage;	

public DamageRange(String ability, String range, int damage) {
	super(ability, range);
	setBoost(damage);}

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
	card.damage(damage);
return 0;}

@Override
public int inLastRow(Card card) {
	card.damage(damage);
return 0;}

public int getDamage() {
return damage;}

public void setBoost(int damage) {
	if (damage < 0) {damage = 0;}
	this.damage = damage;}
	
}
