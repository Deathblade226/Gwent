package abilities;

import cards.Card;

public class LeaderKingHenselt extends Abilities{ //Copy a card

public LeaderKingHenselt(String ability, String range) {
	super(ability, range);}

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
