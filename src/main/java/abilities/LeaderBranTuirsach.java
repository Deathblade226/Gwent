package abilities;

import cards.Card;

public class LeaderBranTuirsach extends Abilities{ //Discard Draw Damage

public LeaderBranTuirsach(String ability, String range) {
	super(ability, range,0,2,1,0,null,0);}

@Override
public int useOnSelf(Card card) {
	
return 0;}

@Override
public int useOnOther(Card card) {
	card.damage(1);
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

public void ddd() { //Logic will use a draw and discard method outside this code.
	
}

}
