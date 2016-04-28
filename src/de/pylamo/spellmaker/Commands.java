package de.pylamo.spellmaker;

import com.ancientshores.Ancient.Classes.Spells.ParameterType;

public enum Commands
{
  AddExperience("<html>Adds the specific amount of experience to the player<br>Parameter 1: The player who receives the xp<br>Parameter 2: The amount of experience the player receives</html>", new String[] { "the player", "the number" }, "AddExperience", new ParameterType[] { ParameterType.Player, ParameterType.Number }),  AddGlobalVariable("<html>Creates a global variable which is visible to all spells, can be accessed using normal variables.</html>", new String[] { "varname" }, "AddGlobalVariable", new ParameterType[] { ParameterType.String }),  AddGroup("<html>Sets the player to the permission group with the specified name</html>", new String[] { "the player", "the group" }, "AddGroup", new ParameterType[] { ParameterType.Player, ParameterType.String }),  AddItem("<html>Adds the specified amount of items to the invenory of the player</html>", new String[] { "the player", "the itemid", "the amount" }, "AddItem", new ParameterType[] { ParameterType.Player, ParameterType.Number, ParameterType.Number }),  AddMana("<html>Adds the specified amount of mana to the players mana system</html>", new String[] { "the player", "amount" }, "AddMana", new ParameterType[] { ParameterType.Player, ParameterType.Number }),  AddPermission("<html>Adds the specified permission to the player</html>", new String[] { "player", "permission" }, "AddPermission", new ParameterType[] { ParameterType.Player, ParameterType.String }),  AddPlayerVariable("<html>Creates a player variable which is visible to all of the players spells, can be accessed using normal variables.</html>", new String[] { "player", "varname" }, "AddPlayerVariable", new ParameterType[] { ParameterType.Player, ParameterType.String }),  AddPrefix("<html>Adds a prefix to the players name if it doesn't already exist</html>", new String[] { "player", "prefix" }, "AddPrefix", new ParameterType[] { ParameterType.Player, ParameterType.String }),  AnimatedBall("<html>Creates an animated ball at the given location</html>", new String[] { "location", "particlename", "particles", "particles per iteration", "size", "x rotation", "y rotation", "z rotation", "x factor", "y factor", "z factor", "period", "iterations" }, "AnimatedBall", new ParameterType[] { ParameterType.Location, ParameterType.String, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number }),  Arc("<html>Creates an arc from the first to the second location</html>", new String[] { "location from", "location to", "particlename", "particles", "height", "period", "iterations" }, "Arc", new ParameterType[] { ParameterType.Location, ParameterType.Location, ParameterType.String, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number }),  Atom("<html>Creates an animated ball at the given location</html>", new String[] { "location", "particlename nucleus", "particlename orbital", "radius", "radiusNucleus", "particels nucleus", "particels orbital", "orbitals", "rotation", "angular velocity", "period", "iterations" }, "Atom", new ParameterType[] { ParameterType.Location, ParameterType.String, ParameterType.String, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number }),  BigBang("<html>Creates a big firework explosion at the given location</html>", new String[] { "location", "firework type", "color 1 red", "color 1 green", "color 1 blue", "color 2 red", "color 2 green", "color 2 blue", "color 3 red", "color 3 green", "color 3 blue", "fade color red", "fade color green", "fade color blue", "intensity", "radius", "explosions", "sound interval", "sound", "sound volume", "sound pitch", "period", "iterations" }, "BigBang", new ParameterType[] { ParameterType.Location, ParameterType.String, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.String, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number }),  Bleed("<html>Plays an bleed effect to/at the entity</html>", new String[] { "entity", "hurt effect visible for entity", "color", "period", "iterations" }, "Bleed", new ParameterType[] { ParameterType.Entity, ParameterType.Boolean, ParameterType.Number, ParameterType.Number, ParameterType.Number }),  Blind("<html>Blinds the specified player for the entered amount of time in milliseconds.</html>", new String[] { "entity", "duration", "amplifier" }, "Blind", new ParameterType[] { ParameterType.Entity, ParameterType.Number, ParameterType.Number }),  Broadcast("<html>Broadcasts the message</html>", new String[] { "message" }, "Broadcast", new ParameterType[] { ParameterType.String }),  BuffForTime("<html>Buffs the player with the specified buff for the specified time in milliseconds</html>", new String[] { "player", "buffname", "duration" }, "BuffForTime", new ParameterType[] { ParameterType.Player, ParameterType.String, ParameterType.Number }),  CancelEvent("<html>Cancels the event, can only be used in a passive spell</html>", new String[0], "CancelEvent", new ParameterType[0]),  CancelSpell("<html>Cancels the currently executing spell</html>", new String[0], "CancelSpell", new ParameterType[0]),  ChangeAggro("Changes the aggro of the entity to the new target for atleast the specified time", new String[] { "entity", "newtarget", "duration" }, "ChangeAggro", new ParameterType[] { ParameterType.Entity, ParameterType.Entity, ParameterType.Number }),  Charge("<html>The player charges to the location</html>", new String[] { "location", "speed", "maxdistance" }, "Charge", new ParameterType[] { ParameterType.Location, ParameterType.Number, ParameterType.Number }),  ChargeEntityTo("<html>Charges the entity to the location with the speed in blocks/s stops after maxdistance</html>", new String[] { "entity", "location", "speed", "maxdistance" }, "ChargeEntityTo", new ParameterType[] { ParameterType.Entity, ParameterType.Location, ParameterType.Number, ParameterType.Number }),  Chat("<html>The player says the specified message in the chat</html>", new String[] { "player", "message" }, "Chat", new ParameterType[] { ParameterType.Player, ParameterType.String }),  CheckCooldown("<html>Checks if the cooldown with the specified name is ready, cancels if not</html>", new String[] { "cdname" }, "CheckCooldown", new ParameterType[] { ParameterType.String }),  Circle("<html>Creates a (rotating) circle at the given location</html>", new String[] { "location", "particlename", "particles", "radius", "period", "iterations", "x rotation", "y rotation", "z rotation", "rotating", "angular velocity x", "angular velocity y", "angular velocity z" }, "Circle", new ParameterType[] { ParameterType.Location, ParameterType.String, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Boolean, ParameterType.Number, ParameterType.Number, ParameterType.Number }),  Cloud("<html>Creates a cloud at the given location</html>", new String[] { "location", "cloud particlename", "rain particlename", "cloud size", "rain particle radius", "period", "iterations" }, "Cloud", new ParameterType[] { ParameterType.Location, ParameterType.String, ParameterType.String, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number }),  ColoredImage("<html>Shows a colored image at the given location</html>", new String[] { "location", "particlename", "file name", "show every x pixel", "show every y pixel", "size", "enable rotation", "rotation axis", "angular velocity x", "angular velocity y", "angular velocity z", "period", "iterations" }, "ColoredImage", new ParameterType[] { ParameterType.Location, ParameterType.String, ParameterType.String, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Boolean, ParameterType.String, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number }),  Cone("<html>Creates a cone at the given location</html>", new String[] { "location", "particlename", "cone-particles per iteration", "particles per cone", "rotation", "angular velocity", "length grow per iteration", "radius grow per iteration", "randomize", "period", "iterations" }, "Cone", new ParameterType[] { ParameterType.Location, ParameterType.String, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Boolean, ParameterType.Number, ParameterType.Number }),  ConsoleCommand("<html>Executes the command in the server console</html>", new String[] { "command" }, "ConsoleCommand", new ParameterType[] { ParameterType.String }),  Cooldown("<html>Triggers the cooldown with the specified name for the given amount of time</html>", new String[] { "cooldownname", "duration" }, "Cooldown", new ParameterType[] { ParameterType.String, ParameterType.Number }),  CopyVariable("<html>Copies the content of the source to the target</html>", new String[] { "variable1", "variable2" }, "CopyVariable", new ParameterType[] { ParameterType.String, ParameterType.String }),  Cube("<html>Creates a cube at the given location</html>", new String[] { "location", "particlename", "particles", "edge length", "enable rotation", "angular velocity x", "angular velocity y", "angular velocity z", "outline only", "period", "iterations" }, "Cube", new ParameterType[] { ParameterType.Location, ParameterType.String, ParameterType.Number, ParameterType.Number, ParameterType.Boolean, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Boolean, ParameterType.Number, ParameterType.Number }),  Cylinder("<html>Creates a cylinder at the given location</html>", new String[] { "location", "particlename", "radius", "height", "x rotation", "y rotation", "z rotation", "particles", "solid", "enable rotation", "angular velocity x", "angular velocity y", "angular velocity z", "period", "iterations" }, "Cylinder", new ParameterType[] { ParameterType.Location, ParameterType.String, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Boolean, ParameterType.Boolean, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number }),  Damage("<html>Damages the targeted entity with the specified damage</html>", new String[] { "entity", "damage" }, "Damage", new ParameterType[] { ParameterType.Entity, ParameterType.Number }),  DamageModify("<html>Modifies the damage of the current damage event</html>", new String[] { "modifier" }, "DamageModify", new ParameterType[] { ParameterType.Number }),  DirectDamage("<html>Damages the entity directly, ignoring armor reduction</html>", new String[] { "entity", "damage" }, "DamageDirectly", new ParameterType[] { ParameterType.Entity, ParameterType.Number }),  Disarm("<html>Disarms the player for the specified time</html>", new String[] { "player", "duration" }, "Disarm", new ParameterType[] { ParameterType.Player, ParameterType.Number }),  DiscoBall("<html>Creates a disco ball at the given location</html>", new String[] { "location", "sphere particlename", "line particlename", "particles sphere", "particles per line", "sphere radius", "max line size", "max lines", "direction", "period", "iterations" }, "DiscoBall", new ParameterType[] { ParameterType.Location, ParameterType.String, ParameterType.String, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.String, ParameterType.Number, ParameterType.Number }),  DisruptOnDeath("<html> Disrupts the spell if player dies in the specified time</html>", new String[] { "player", "duration" }, "DisruptOnDeath", new ParameterType[] { ParameterType.Player, ParameterType.Number }),  DisruptOnMove("<html> Disrupts the spell if player moves in the specified time</html>", new String[] { "player", "duration" }, "DisruptOnMove", new ParameterType[] { ParameterType.Player, ParameterType.Number }),  DNA("<html>Creates a dna helix at the given location</html>", new String[] { "location", "helix particlename", "base 1 particlename", "base 2 particlename", "radial turns", "radius", "particles helix per iteration", "particles per base", "length", "grow", "base interval", "period", "iteration" }, "DNA", new ParameterType[] { ParameterType.Location, ParameterType.String, ParameterType.String, ParameterType.String, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number }),  Donut("<html>Creates a donut at the given location</html>", new String[] { "location", "particlename", "particles per circle", "circles", "radius donut", "radius tube", "x rotation", "y rotation", "z rotation", "period", "iterations" }, "Donut", new ParameterType[] { ParameterType.Location, ParameterType.String, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number }),  Dragon("<html>Creates a dragon at the given location</html>", new String[] { "location", "particlename", "arc pitch", "arcs", "particles per arc", "steps per iteration", "length in blocks", "period", "iterations" }, "Dragon", new ParameterType[] { ParameterType.Location, ParameterType.String, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number }),  DropItem("<html>Drops the specified amount of items at the location</html>", new String[] { "location", "material", "amount" }, "DropItem", new ParameterType[] { ParameterType.Location, ParameterType.Material, ParameterType.Number }),  Earth("<html>Creates a earth at the given location</html>", new String[] { "location", "precision", "particles", "radius", "mountain high", "period", "iterations" }, "Earth", new ParameterType[] { ParameterType.Location, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number }),  Enchant("<html>Enchants the item in hand with the id (or all if allitems is true) with the enchantment and strength</html>", new String[] { "material", "name", "level", "allitems" }, "Enchant", new ParameterType[] { ParameterType.Number, ParameterType.String, ParameterType.Number, ParameterType.Boolean }),  Execute("<html>Executes the spell</html>", new String[] { "player", "spellname" }, "Execute", new ParameterType[] { ParameterType.Player, ParameterType.String }),  Explosion("<html>Creates an explosion with the specified strength at the location</html>", new String[] { "location", "radius" }, "Explosion", new ParameterType[] { ParameterType.Location, ParameterType.Number }),  ExplodeEffect("<html>Creates an explosion effect at the given location</html>", new String[] { "location", "amount", "speed" }, "ExplodeEffect", new ParameterType[] { ParameterType.Location, ParameterType.Number, ParameterType.Number }),  Fireball("<html>the caster throws a fireball</html>", new String[0], "Fireball", new ParameterType[0]),  Flame("<html>Creates flames at the given location</html>", new String[] { "location", "period", "iterations" }, "Flame", new ParameterType[] { ParameterType.Location, ParameterType.Number, ParameterType.Number }),  Fountain("<html>Creates a fountain at the given location</html>", new String[] { "location", "particlename", "strands", "particles per strand", "particles per iteration in spout", "radius", "radius of spout", "height", "height of spout", "rotation", "period", "iterations" }, "Fountain", new ParameterType[] { ParameterType.Location, ParameterType.String, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number }),  Grenade("<html>The caster throws tnt which explodes after the time</html>", new String[] { "time" }, "Grenade", new ParameterType[] { ParameterType.Number }),  Grid("<html>Creates a grid at the given location</html>", new String[] { "location", "particlename", "rows", "columns", "width of cell", "height of cell", "particles spawned along horizontal borders of cell", "particles spawned along vertical borders of cell", "rotation", "period", "iterations" }, "Grid", new ParameterType[] { ParameterType.Location, ParameterType.String, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number }),  Heal("<html>Heals the target the specified amount of health</html>", new String[] { "entity", "amount" }, "Heal", new ParameterType[] { ParameterType.Entity, ParameterType.Number }),  Heart("<html>Creates a heart at the given location</html>", new String[] { "location", "particlename", "particles", "x rotation", "y rotation", "z rotation", "x factor", "y factor", "factor of inner spike (the \\/)", "compress factor along y axis", "compilation" }, "Heart", new ParameterType[] { ParameterType.Location, ParameterType.String, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number }),  Helix("<html>Creates a helix at the given location</html>", new String[] { "location", "particlename", "strands", "particles per strand", "radius", "curve", "rotation", "period", "iterations" }, "Helix", new ParameterType[] { ParameterType.Location, ParameterType.String, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number }),  Hill("<html>Creates a hill at the given location</html>", new String[] { "location", "particlename", "height", "particles per row", "y rotation", "period", "iterations" }, "Hill", new ParameterType[] { ParameterType.Location, ParameterType.String, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number }),  Icon("<html>Creates an icon at the given location</html>", new String[] { "location", "particlename", "y offset", "period", "iterations" }, "Icon", new ParameterType[] { ParameterType.Location, ParameterType.String, ParameterType.Number, ParameterType.Number, ParameterType.Number }),  Ignite("<html>Ignites the target for the specified time</html>", new String[] { "entity", "duration" }, "Ignite", new ParameterType[] { ParameterType.Entity, ParameterType.Number }),  Image("<html>Creates an image at the given location</html>", new String[] { "location", "particlename", "file name", "invert", "show every x pixel", "show every y pixel", "size", "enable rotation", "rotation axis", "angular velocity x", "angular velocity y", "angular velocity z", "period", "iterations" }, "Image", new ParameterType[] { ParameterType.Location, ParameterType.String, ParameterType.String, ParameterType.Boolean, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Boolean, ParameterType.String, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number }),  Invisible("<html>Makes the player invisible for the specified amount of time</html>", new String[] { "player", "duration" }, "Invisible", new ParameterType[] { ParameterType.Player, ParameterType.Number }),  Invulnerable("<html>Makes the player invulnerable for the specified amount of time</html>", new String[] { "player", "duration" }, "Invulnerable", new ParameterType[] { ParameterType.Player, ParameterType.Number }),  Jump("<html>Let the given entity jump</html>", new String[] { "entity", "power" }, "Jump", new ParameterType[] { ParameterType.Entity, ParameterType.Number }),  JumpHigher("<html>Lets the target jump the amount of blocks higher for the specified time</html>", new String[] { "entity", "duration", "amplifier" }, "JumpHigher", new ParameterType[] { ParameterType.Entity, ParameterType.Number, ParameterType.Number }),  Kill("<html>Kills the target</html>", new String[] { "entity" }, "Kill", new ParameterType[] { ParameterType.Entity }),  LaunchFirework("<html>Launches a firework at the location with the effect type and the color (must be specified in \"r, g, b\")</html>", new String[] { "location", "effectname", "color", "flickering", "trail" }, "LaunchFirework", new ParameterType[] { ParameterType.Location, ParameterType.String, ParameterType.String, ParameterType.Boolean, ParameterType.Boolean }),  Lightning("<html>Lightning will strike at the location</html>", new String[] { "location" }, "Lightning", new ParameterType[] { ParameterType.Location }),  LightningEffect("<html>Lightning effect will strike at the location</html>", new String[] { "location" }, "LightningEffect", new ParameterType[] { ParameterType.Location }),  Line("<html>Creates a line from the given location one to the other</html>", new String[] { "location1", "location2", "particlename", "is a zig-zag-line", "amount of zig zags", "particles (per arc)", "period", "iterations" }, "Line", new ParameterType[] { ParameterType.Location, ParameterType.Location, ParameterType.String, ParameterType.Boolean, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number }),  Love("<html>Creates a love like effect, placing particles at random locations around the given location</html>", new String[] { "location", "particlename", "period", "iterations" }, "Love", new ParameterType[] { ParameterType.Location, ParameterType.String, ParameterType.Number, ParameterType.Number }),  MusicNotes("<html>Spawns music notes at the given location</html>", new String[] { "location", "radials per step", "radius", "period", "iterations" }, "MusicNotes", new ParameterType[] { ParameterType.Location, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number }),  ParticleText("<html>Creates a text consisting of particles at the given location</html>", new String[] { "location", "particlename", "text", "invert", "only show every x. pixel", "only show every y. pixel", "size", "font", "period", "iterations" }, "ParticleText", new ParameterType[] { ParameterType.Location, ParameterType.String, ParameterType.String, ParameterType.Boolean, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.String, ParameterType.Number, ParameterType.Number }),  PlayEffect("<html>Play effect at the location</html>", new String[] { "location", "effectname" }, "PlayEffect", new ParameterType[] { ParameterType.Location, ParameterType.String }),  PlayEntityEffect("<html>Play entity effect at the location</html>", new String[] { "entity", "effectname" }, "PlayEntityEffect", new ParameterType[] { ParameterType.Entity, ParameterType.String }),  Poison("<html>Poisons the target for the specified amount of time</html>", new String[] { "entity", "duration", "amplifier" }, "Poison", new ParameterType[] { ParameterType.Entity, ParameterType.Number, ParameterType.Number }),  PotionEffect("<html>Adds a potioneffect with the specified effect to the entity for the specified duration</html>", new String[] { "entity", "name", "duration", "amplifier" }, "PotionEffect", new ParameterType[] { ParameterType.Entity, ParameterType.String, ParameterType.Number, ParameterType.Number }),  PrintToConsole("<html>Logs the message to the server console</html>", new String[] { "message" }, "PrintToConsole", new ParameterType[] { ParameterType.String }),  RemoveBuff("<html>removes the specified buff of the player so it can't be triggered anymore</html>", new String[] { "player", "buffname" }, "RemoveBuff", new ParameterType[] { ParameterType.Player, ParameterType.String }),  RemoveGroup("<html>Removes the permission group from the player</html>", new String[] { "player", "group" }, "RemoveGroup", new ParameterType[] { ParameterType.Player, ParameterType.String }),  RemoveItem("<html>Removes the amount of items from the players inventory, cancels the spell if it fails if cancelonfail is true</html>", new String[] { "player", "material", "amount", "cancelonfail" }, "RemoveItem", new ParameterType[] { ParameterType.Player, ParameterType.Material, ParameterType.Number, ParameterType.Boolean }),  RemoveMana("<html>Removes the amount of mana from the player's mana system</html>", new String[] { "player", "amount", "cancelonfail" }, "RemoveMana", new ParameterType[] { ParameterType.Player, ParameterType.Number, ParameterType.Boolean }),  RemovePermission("<html>Removes the permission from the player</html>", new String[] { "player", "permission" }, "RemovePermission", new ParameterType[] { ParameterType.Player, ParameterType.String }),  RemovePotion("<html>Removes the specified potion effect from the player</html>", new String[] { "entity", "effectname" }, "RemovePotionEffect", new ParameterType[] { ParameterType.Entity, ParameterType.String }),  RemoveProjectile("<html>Removes the projectile which hit something, can only be used in ProjectileHitEvent</html>", new String[0], "RemoveProjectile", new ParameterType[0]),  ResetCooldown("<html>Resets the cooldown with the specified name or all for all cooldowns</html>", new String[] { "player", "cdname" }, "ResetCooldown", new ParameterType[] { ParameterType.Player, ParameterType.String }),  Revive("<html>Revives a player who is still in the death screen and he is teleported back to his death location when he respawns</html>", new String[] { "player" }, "Revive", new ParameterType[] { ParameterType.Player }),  SendMessage("<html>Sends the message to the specified player</html>", new String[] { "player", "message" }, "SendMessage", new ParameterType[] { ParameterType.Player, ParameterType.String }),  SetArmor("Sets the players armor in the specified slot", new String[] { "player", "material", "slot", "amount" }, "SetArmor", new ParameterType[] { ParameterType.Player, ParameterType.Material, ParameterType.Number, ParameterType.Number }),  SetBlock("<html>Sets the block at the location to the specified id</html>", new String[] { "location", "material" }, "SetBlock", new ParameterType[] { ParameterType.Location, ParameterType.Material }),  SetBlockTemporary("<html>Sets the id of the block, sets it back after the time</html>", new String[] { "location", "material", "duration" }, "SetBlockTemporary", new ParameterType[] { ParameterType.Location, ParameterType.Material, ParameterType.Number }),  SetDamage("<html>Sets the damage of a damage event (attackevent/damageevent/damagebyentityevent)</html>", new String[] { "amount" }, "SetDamage", new ParameterType[] { ParameterType.Number }),  SetFly("<html>Sets if the player can fly or not</html>", new String[] { "player", "canfly" }, "SetFly", new ParameterType[] { ParameterType.Player, ParameterType.Boolean }),  SetFoodLevel("<html>Sets the foodlevel of the player</html>", new String[] { "player", "amount" }, "SetFoodLevel", new ParameterType[] { ParameterType.Player, ParameterType.Number }),  SetGainedExperience("<html>Changes the amount of xp a player gains of an ancientgainxp event</html>", new String[] { "amount" }, "SetGainedExperience", new ParameterType[] { ParameterType.Number }),  SetHp("<html>Sets the health of the target to the specified amount</html>", new String[] { "entity", "amount" }, "SetHp", new ParameterType[] { ParameterType.Entity, ParameterType.Number }),  SetInvisible("<html>Makes the player invisible or makes them visible</html>", new String[] { "player", "isinvisible" }, "SetInvisible", new ParameterType[] { ParameterType.Player, ParameterType.Boolean }),  SetItem("Sets the item in the specified slot of the player's inventory", new String[] { "player", "material", "slot", "amount" }, "SetItem", new ParameterType[] { ParameterType.Player, ParameterType.Material, ParameterType.Number, ParameterType.Number }),  SetItemName("Sets the item name of the item in the players inventory", new String[] { "player", "slot", "name" }, "SetItemName", new ParameterType[] { ParameterType.Player, ParameterType.Number, ParameterType.String }),  SetMana("<html>Sets the amount of mana of the player</html>", new String[] { "player", "amount" }, "SetMana", new ParameterType[] { ParameterType.Player, ParameterType.Number }),  SetMaxHp("<html>Sets the maximumhealth of the target to the specified amount</html>", new String[] { "player", "amount" }, "SetMaxHp", new ParameterType[] { ParameterType.Player, ParameterType.Number }),  SetMaxMana("<html>Sets the maximum amount of mana the player can have</html>", new String[] { "player", "amount" }, "SetMaxMana", new ParameterType[] { ParameterType.Player, ParameterType.Number }),  SetPitch("Sets the pitch of the entity", new String[] { "location", "amount" }, "SetPitch", new ParameterType[] { ParameterType.Entity, ParameterType.Number }),  SetTime("<html>Sets the time of the world</html>", new String[] { "world", "time" }, "SetTime", new ParameterType[] { ParameterType.Location, ParameterType.Number }),  SetVelocity("<html>Sets the velo of the entity</html>", new String[] { "entity", "forward", "sideward", "upward" }, "SetVelocity", new ParameterType[] { ParameterType.Entity, ParameterType.Number, ParameterType.Number, ParameterType.Number }),  SetWeather("<html>Changes the weather in the world for atleast the specified time</html>", new String[] { "world", "duration", "raining", "thundering" }, "SetWeather", new ParameterType[] { ParameterType.Location, ParameterType.Number, ParameterType.Boolean, ParameterType.Boolean }),  SetYaw("Sets the yaw of the specified entity", new String[] { "entity", "yaw" }, "SetYaw", new ParameterType[] { ParameterType.Entity, ParameterType.Number }),  Shield("<html>Creates a particle shield at the given location</html>", new String[] { "location", "particlename", "radius", "particles", "full sphere(true) or half sphere(false)", "period", "iterations" }, "Shield", new ParameterType[] { ParameterType.Location, ParameterType.String, ParameterType.Number, ParameterType.Number, ParameterType.Boolean, ParameterType.Number, ParameterType.Number }),  ShootArrow("<html>The entity shoots an arrow with the specified velocity</html>", new String[] { "entity", "velocity" }, "ShootArrow", new ParameterType[] { ParameterType.Entity, ParameterType.Number }),  ShootWitherSkull("<html>The entity shoots a witherskull</html>", new String[] { "shooter" }, "ShootWitherSkull", new ParameterType[] { ParameterType.Entity }),  Silence("<html>Silences the player for the specified amount of time</html>", new String[] { "player", "duration" }, "Silence", new ParameterType[] { ParameterType.Player, ParameterType.Number }),  Slow("<html>Slows the target for the specified amount of time</html>", new String[] { "entity", "duration" }, "Slow", new ParameterType[] { ParameterType.Entity, ParameterType.Number }),  Smoke("<html>Creates smoke particles at the location</html>", new String[] { "location" }, "Smoke", new ParameterType[] { ParameterType.Location }),  SmokeEffect("<html>Creates smoke at the given location</html>", new String[] { "location", "particlename", "period", "iterations" }, "SmokeEffect", new ParameterType[] { ParameterType.Location, ParameterType.String, ParameterType.Number, ParameterType.Number }),  SpawnArrow("<html>Spawns an arrow at the location with the velocity</html>", new String[] { "location", "forward", "sideward", "upward" }, "SpawnArrow", new ParameterType[] { ParameterType.Location, ParameterType.Number, ParameterType.Number, ParameterType.Number }),  SpawnCreature("<html>Spawns creatures at the location with the given health and of the specified type</html>", new String[] { "location", "creaturename", "health", "amount" }, "SpawnCreature", new ParameterType[] { ParameterType.Location, ParameterType.String, ParameterType.Number, ParameterType.Number }),  Speedup("<html>Speeds up the player for the specified amount of time</html>", new String[] { "entity", "duration" }, "Speedup", new ParameterType[] { ParameterType.Entity, ParameterType.Number }),  Sphere("<html>Creates a sphere at the given location</html>", new String[] { "location", "particlename", "radius", "y offset", "particles", "period", "iterations" }, "Sphere", new ParameterType[] { ParameterType.Location, ParameterType.String, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number }),  Star("<html>Creates a star at the given location</html>", new String[] { "location", "particlename", "particles per spike", "spike height", "half amount of spikes", "inner radius", "period", "iterations" }, "Star", new ParameterType[] { ParameterType.Location, ParameterType.String, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number }),  Stun("<html>Stuns the player for the specified amount of time</html>", new String[] { "entity", "duration" }, "Stun", new ParameterType[] { ParameterType.Entity, ParameterType.Number }),  Summon("<html>Summons the amount of creatures at the specified location for the specified amount of time</html>", new String[] { "location", "creaturename", "duration", "amount" }, "Summon", new ParameterType[] { ParameterType.Location, ParameterType.String, ParameterType.Number, ParameterType.Number }),  Tame("<html>Tames the target if it is tameable</html>", new String[] { "entity" }, "Tame", new ParameterType[] { ParameterType.Entity }),  Teleport("<html>Teleports the player to the location</html>", new String[] { "location" }, "Teleport", new ParameterType[] { ParameterType.Location }),  TeleportPlayer("<html>Teleports the target to the location</html>", new String[] { "entity", "location" }, "TeleportPlayer", new ParameterType[] { ParameterType.Entity, ParameterType.Location }),  TemporaryItem("<html>Gives the player specified items for the specified amount of time</html>", new String[] { "player", "materialid", "amount", "time" }, "TemporaryItem", new ParameterType[] { ParameterType.Player, ParameterType.Number, ParameterType.Number, ParameterType.Number }),  ThrowEgg("The entity throws an egg", new String[] { "entity" }, "ThrowEgg", new ParameterType[] { ParameterType.Entity }),  ThrowEnderpearl("<html>The shooter throws an enderpearl in the direction he is looking at<br> Parameter 1: the player who throws the egg</html>", new String[] { "entity" }, "ThrowEnderpearl", new ParameterType[] { ParameterType.Entity }),  ThrowPotion("The entity throws a potion with the specified effects", new String[] { "entity", "potionname", "duration", "amplifier" }, "ThrowPotion", new ParameterType[] { ParameterType.Entity, ParameterType.String, ParameterType.Number, ParameterType.Number }),  ThrowSmallFireball("The caster throws a asmall fireball", new String[0], "ThrowSmallFireball", new ParameterType[0]),  ThrowSnowball("<html>The shooter throws a snowball in the direction he is looking at<br> Parameter 1: the player who throws the snowball</html>", new String[] { "entity" }, "ThrowSnowball", new ParameterType[] { ParameterType.Entity }),  Tornado("<html>Creates a tornado at the given location</html>", new String[] { "location", "tornado particlename", "cloud particlename", "cloud size", "y offset", "height of tornado", "max tornado radius", "show cloud", "show tornado", "distance between rows", "period", "iterations" }, "Tornado", new ParameterType[] { ParameterType.Location, ParameterType.String, ParameterType.String, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Boolean, ParameterType.Boolean, ParameterType.Number, ParameterType.Number, ParameterType.Number }),  Turn("<html>Turns the given entity</html>", new String[] { "entity", "angle", "period", "iterations" }, "Turn", new ParameterType[] { ParameterType.Entity, ParameterType.Number, ParameterType.Number, ParameterType.Number }),  Vortex("<html>Creates a vortex at the given location</html>", new String[] { "location", "particlename", "radius", "grow per iteration", "radials per iteration", "helix circles per iterations", "helices", "period", "iterations" }, "Vortex", new ParameterType[] { ParameterType.Location, ParameterType.String, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number }),  Wait("<html>Delays the execution of the spell for the specified amount of time in millaseconds.</html>", new String[] { "duration" }, "Wait", new ParameterType[] { ParameterType.Number }),  WarpEffect("<html>Creates a warp effect at the given location</html>", new String[] { "location", "particlename", "circles", "particles per circle", "radius", "grow", "period", "iterations" }, "WarpEffect", new ParameterType[] { ParameterType.Location, ParameterType.String, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number }),  WaterBreathing("<html>Enables water breathing for the specified amount of time</html>", new String[] { "entity", "duration" }, "WaterBreathing", new ParameterType[] { ParameterType.Entity, ParameterType.Number }),  Wave("<html>Creates a wave at the given location</html>", new String[] { "location", "wave particlename", "cloud particlename", "speed x", "speed y", "speed z", "particles on the front forming the tube", "particles forming the back", "width of wave in rows", "length of front", "length of back", "depth of parabola tube", "height of parabola arc at the end", "height", "width", "period", "iterations" }, "Wave", new ParameterType[] { ParameterType.Location, ParameterType.String, ParameterType.String, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number, ParameterType.Number }),  Weaken("<html>Weakens the player for the time with the specified strength</html>", new String[] { "entity", "duration", "amplifier" }, "Weaken", new ParameterType[] { ParameterType.Entity, ParameterType.Number, ParameterType.Number });
  
  private String description;
  private String[] argnames;
  private String name;
  private ParameterType[] params;
  
  private Commands(String description, String[] argnames, String name, ParameterType[] params)
  {
    this.description = description;
    this.argnames = argnames;
    this.name = name;
    this.params = params;
  }
  
  public String[] getArgnames()
  {
    return this.argnames;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public ParameterType[] getParams()
  {
    return this.params;
  }
}


/* Location:              C:\Users\Jens\Desktop\Spigot Server\plugins\Ancient_v1.1.0 (1).jar!\de\pylamo\spellmaker\Commands.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */