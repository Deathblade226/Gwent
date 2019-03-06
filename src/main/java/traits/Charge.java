package traits;

import cards.Card;

public class Charge extends Trait{

private int charges;	
	
public Charge(String name, Card summon, int totalSummons, int charges, boolean useOnPlace, boolean useOnDeath) {
	super(name, summon, totalSummons, charges, useOnPlace, useOnDeath);
	this.setCharges(charges);}

@Override
public void useAbility(Card card) {
	
}

@Override
public int setCharges(Card card) {
	
return 0;}

@Override
public int useCharge(Card card) {
	if (charges == 0) {System.out.println("This card is out of charges");}
	else {charges--;}
return 0;}

@Override
public int summon(Card card) {

return 0;}

public int getCharges() {
return charges;}

public void setCharges(int charges) {
	this.charges = charges;}



}
