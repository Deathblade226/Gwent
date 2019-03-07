package abilities;

import cards.Card;

public class LeadeKingHenselt extends Abilities{ //Copy a card

public LeadeKingHenselt(String ability, String range) {
	super(ability, range,0,0,1,0,null,0,"LeaderKingHenselt");}

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
	Card copy = card;;
return copy;}

}
