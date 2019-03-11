package traits;

import cards.Card;

public class Deploy extends Trait{

public Deploy(String name) {
	super(name, null, 0, 0, true, false, "Deploy");}

@Override
public void useAbility(Card card) {
	
}

@Override
public int setCharges(Card card) {
	
return 0;}

@Override
public int useCharge(Card card) {
	
return 0;}

@Override
public int summon(Card card) {

return 0;}

	
}
