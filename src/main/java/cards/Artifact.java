package cards;

import abilities.Abilities;
import enums.Factions;
import enums.Type;
import traits.Trait;

public class Artifact extends Card{

public Artifact(String name, Factions faction, Type type, int powerBase, int powerCurrent, Abilities ability, Trait trait) {
	super(name, faction, type, powerBase, powerCurrent, ability, trait);}	
	
}
