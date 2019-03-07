package abilities;

import cards.Card;

public class NoAbility extends Abilities{

public NoAbility() {super("", "",0,0,0,0,null,0,"NoAbility");}

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

return 0;}

@Override
public int inLastRow(Card card) {

return 0;}	

@Override
public Card createCard(Card card) {
	
return null;}

}
