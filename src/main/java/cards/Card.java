package cards;

import abilities.Abilities;
import abilities.NoAbility;
import enums.Factions;
import enums.Type;
import traits.NoTrait;
import traits.Trait;

public class Card {

protected String name;	
protected Factions faction;
protected Type type;
protected int powerBase;
protected int powerCurrent;
protected Abilities ability;
protected Trait trait;
protected boolean alive = true;

public Card(String name, Factions faction, Type type, int powerBase, int powerCurrent, Abilities ability, Trait trait) {
	setName(name);
	setFaction(faction);
	setType(type);
	setPowerBase(powerBase);
	setPowerCurrent(powerCurrent);
	setAbility(ability);
	setTrait(trait);}

public String getName() {
return name;}

public void setName(String name) {
	this.name = name;}

public Factions getFaction() {
return faction;}

public void setFaction(Factions faction) {
	this.faction = faction;}

public Type getType() {
return type;}

public void setType(Type type) {
	this.type = type;}

public int getPowerBase() {
return powerBase;}

public void setPowerBase(int powerBase) {
	this.powerBase = powerBase;}

public int getPowerCurrent() {
return powerCurrent;}

public void setPowerCurrent(int powerCurrent) {
	this.powerCurrent = powerCurrent;}

public Abilities getAbility() {
return ability;}

public void setAbility(Abilities ability) {
	if (ability == null) {ability = new NoAbility();}
	this.ability = ability;}

public Trait getTrait() {
return trait;}

public void setTrait(Trait trait) {
	if (trait == null) {trait = new NoTrait("Nothing");}
	this.trait = trait;}

public boolean isAlive() {
return alive;}

public void setAlive(boolean alive) {
	this.alive = alive;}

public void buff(int buff) {
	if (buff < 0) {buff = 0;}
	setPowerCurrent(getPowerCurrent() + buff);}

public void damage(int damage) {
	if (damage < 0) {damage = 0;}
	setPowerCurrent(getPowerCurrent() - damage);}

public void heal(int heal) {
	if (getPowerCurrent() + heal > getPowerBase()) {setPowerCurrent(getPowerBase());}
	setPowerCurrent(getPowerCurrent() + heal);}

@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append(getName()).append("\tPower: ").append(getPowerCurrent()).append("\n")
	.append(getFaction()).append("\t").append(getType()).append("\n")
	.append(getAbility()).append("\n")
	.append(getTrait());
	return builder.toString();
}




}
