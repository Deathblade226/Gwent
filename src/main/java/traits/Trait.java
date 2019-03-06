package traits;

import cards.Card;

public abstract class Trait {

protected String name;
protected Card summon;
protected int totalSummons;
protected int charges;
protected boolean useOnPlace;
protected boolean useOnDeath;

public Trait(String name, Card summon, int totalSummons, int charges, boolean useOnPlace, boolean useOnDeath) {
	super();
	setName(name);
	setSummon(summon);
	setTotalSummons(totalSummons);
	setCharges(charges);
	setUseOnPlace(useOnPlace);
	setUseOnDeath(useOnDeath);}

public String getName() {
return name;}

public void setName(String name) {
	this.name = name;}	
	
public abstract void useAbility(Card card);

public abstract int setCharges(Card card);

public abstract int useCharge(Card card);

public abstract int summon(Card card);

public Card getSummon() {
return summon;}

public void setSummon(Card summon) {
	this.summon = summon;}

public int getTotalSummons() {
return totalSummons;}

public void setTotalSummons(int totalSummons) {
	if (totalSummons < 0) {totalSummons = 0;}
	this.totalSummons = totalSummons;}


public int getCharges() {
return charges;}

public void setCharges(int charges) {
	if (charges < 0) {charges = 0;}
 	this.charges = charges;}

public boolean isUseOnPlace() {
return useOnPlace;}

public void setUseOnPlace(boolean useOnPlace) {
	this.useOnPlace = useOnPlace;}

public boolean isUseOnDeath() {
return useOnDeath;}

public void setUseOnDeath(boolean useOnDeath) {
	this.useOnDeath = useOnDeath;}

@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append(getName());
	return builder.toString();
}



}
