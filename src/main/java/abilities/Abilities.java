package abilities;

import cards.Card;

public abstract class Abilities {

protected String ability;
protected String range;
protected int damage;
protected int boost;
protected int heal;
protected int howMany;
protected Card summon;
protected int summonTotal;
protected String type;

public Abilities(String ability, String range, int heal, int damage, int howMany, int boost, Card summon, int summonTotal, String type) {
	setAbility(ability);
	setRange(range);
	setDamage(damage);
	setHeal(heal);
	setHowMany(howMany);
	setBoost(boost);
	setSummon(summon);
	setType(type);}

public String getAbility() {
	return ability;}

public void setAbility(String ability) {
	this.ability = ability;}

public String getRange() {
	return range;}

public void setRange(String range) {
	this.range = range;}

public abstract int useOnSelf(Card card);

public abstract int useOnOther(Card card);

public abstract int useOnRow(Card card);

public abstract int inFirstRow(Card card);

public abstract int inSecondRow(Card card);

public abstract int inLastRow(Card card);

public abstract Card createCard(Card card);

public int getDamage() {
return damage;}

public void setDamage(int damage) {
	if (damage < 0) {damage = 0;}
	this.damage = damage;}

public int getHeal() {
return heal;}

public void setHeal(int heal) {
	if (heal < 0) {heal = 0;}
	this.heal = heal;}

public int getHowMany() {
return howMany;}

public void setHowMany(int howMany) {
	if (howMany < 0) {howMany = 0;}
	this.howMany = howMany;}

public int getBoost() {
return boost;}

public void setBoost(int boost) {
	if (boost < 0) {boost = 0;}
	this.boost = boost;}

public Card getSummon() {
return summon;}

public void setSummon(Card summon) {
	this.summon = summon;}

public int getSummonTotal() {
return summonTotal;}

public void setSummonTotal(int summonTotal) {
	if (summonTotal < 0) {summonTotal = 0;}
	this.summonTotal = summonTotal;}

public String getType() {
return type;}

public void setType(String type) {
	this.type = type;}

@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append(getRange()).append(" ").append(getAbility());
	return builder.toString();
}



}
