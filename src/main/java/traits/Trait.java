package traits;

import cards.Card;

public abstract class Trait {

protected String name;

public Trait(String name) {
	setName(name);}

public String getName() {
return name;}

public void setName(String name) {
	this.name = name;}	
	
public abstract void useAbility(Card card);

public abstract int setCharges(Card card);

public abstract int useCharge(Card card);

public abstract int summon(Card card);



}
