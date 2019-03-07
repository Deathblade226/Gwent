package abilities;

import cards.Card;

public class DamageMelee extends Abilities{

private int damage;	

public DamageMelee(String ability, String range, int damage, int howMany) {
	super(ability, range,0,damage,howMany,0,null,0,"DamageMelee");
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
	card.damage(damage);
return 0;}

@Override
public int inSecondRow(Card card) {

return 0;}

@Override
public int inLastRow(Card card) {

return 0;}

public int getDamage() {
return damage;}

public void setBoost(int damage) {
	if (damage < 0) {damage = 0;}
	this.damage = damage;}

@Override
public Card createCard(Card card) {
	
return null;}

}
