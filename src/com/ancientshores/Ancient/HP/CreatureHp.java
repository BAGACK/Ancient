package com.ancientshores.Ancient.HP;

import com.ancientshores.Ancient.Ancient;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Skeleton.SkeletonType;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Wolf;
import org.bukkit.entity.Zombie;
import org.bukkit.scheduler.BukkitScheduler;

public class CreatureHp
{
  private static FileConfiguration config;
  static final HashSet<CreatureHp> registeredMonsters = new HashSet();
  LivingEntity ent;
  public long lastFireDamage;
  public long lastCactusDamage;
  public long lastLavaDamage;
  public long lastAttackDamage;
  
  public CreatureHp(LivingEntity e, double maxHealth)
  {
    if ((e instanceof HumanEntity)) {
      return;
    }
    if (e.getHealth() <= 0.0D) {
      return;
    }
    e.setMaxHealth(maxHealth);
    e.setHealth(maxHealth);
    this.ent = e;
    
    registeredMonsters.add(this);
  }
  
  public static CreatureHp getCreatureHpByEntity(LivingEntity e)
  {
    return getCreatureHpByEntity(e, getMaxHpByEntity(e));
  }
  
  public static CreatureHp getCreatureHpByEntity(LivingEntity e, double maxHealth)
  {
    for (CreatureHp hp : registeredMonsters) {
      if (e.getUniqueId().compareTo(hp.ent.getUniqueId()) == 0) {
        return hp;
      }
    }
    return new CreatureHp(e, maxHealth);
  }
  
  public static void removeCreature(LivingEntity e)
  {
    CreatureHp mhp = null;
    for (CreatureHp hp : registeredMonsters) {
      if (e == hp.ent)
      {
        mhp = hp;
        break;
      }
    }
    if (mhp != null) {
      registeredMonsters.remove(mhp);
    }
  }
  
  public static boolean containsCreature(LivingEntity e)
  {
    for (CreatureHp hp : registeredMonsters) {
      if (e == hp.ent) {
        return true;
      }
    }
    return false;
  }
  
  public static void loadConfig()
  {
    File file = new File(Ancient.plugin.getDataFolder().getPath() + File.separator + "creaturehpconfig.yml");
    if (!file.exists()) {
      Ancient.plugin.saveResource("creaturehpconfig.yml", true);
    }
    config = YamlConfiguration.loadConfiguration(file);
  }
  
  public static void writeConfig()
  {
    File file = new File(Ancient.plugin.getDataFolder().getPath() + File.separator + "creaturehpconfig.yml");
    try
    {
      config.save(file);
    }
    catch (IOException ex)
    {
      ex.printStackTrace();
    }
  }
  
  public static void startCleaner()
  {
    Bukkit.getScheduler().scheduleSyncDelayedTask(Ancient.plugin, new Runnable()
    {
      public void run()
      {
        HashSet<CreatureHp> scheduledRemovals = new HashSet();
        for (CreatureHp hp : CreatureHp.registeredMonsters) {
          if (hp.ent.isDead()) {
            scheduledRemovals.add(hp);
          }
        }
        CreatureHp.registeredMonsters.removeAll(scheduledRemovals);
      }
    }, 1000L);
  }
  
  public static double getMaxHpByEntity(LivingEntity e)
  {
    switch (e.getType())
    {
    case BLAZE: 
      return config.getDouble("CreatureHp.hp of a blaze");
    case CAVE_SPIDER: 
      return config.getDouble("CreatureHp.hp of a cave spider");
    case CHICKEN: 
      return config.getDouble("CreatureHp.hp of a chicken");
    case COW: 
      return config.getDouble("CreatureHp.hp of a cow");
    case CREEPER: 
      return config.getDouble("CreatureHp.hp of a creeper");
    case ENDERMAN: 
      return config.getDouble("CreatureHp.hp of a Enderman");
    case ENDER_DRAGON: 
      return config.getDouble("CreatureHp.hp of an ender dragon");
    case GHAST: 
      return config.getDouble("CreatureHp.hp of a ghast");
    case GIANT: 
      return config.getDouble("CreatureHp.hp of a giant");
    case IRON_GOLEM: 
      return config.getDouble("CreatureHp.hp of an iron golem");
    case MUSHROOM_COW: 
      return config.getDouble("CreatureHp.hp of a mooshroom");
    case OCELOT: 
      return config.getDouble("CreatureHp.hp of an Ocelot");
    case PIG: 
      return config.getDouble("CreatureHp.hp of a pig");
    case PIG_ZOMBIE: 
      return config.getDouble("CreatureHp.hp of a zombie pigman");
    case SHEEP: 
      return config.getDouble("CreatureHp.hp of a sheep");
    case SILVERFISH: 
      return config.getDouble("CreatureHp.hp of a silverfish");
    case SNOWMAN: 
      return config.getDouble("CreatureHp.hp of a snow golem");
    case SPIDER: 
      return config.getDouble("CreatureHp.hp of a spider");
    case SQUID: 
      return config.getDouble("CreatureHp.hp of a squid");
    case WITCH: 
      return config.getDouble("CreatureHp.hp of a witch");
    case HORSE: 
      return config.getDouble("CreatureHp.hp of a horse");
    case VILLAGER: 
      return config.getDouble("CreatureHp.hp of a villager");
    case BAT: 
      return config.getDouble("CreatureHp.hp of a bat");
    case WITHER: 
      return config.getDouble("CreatureHp.hp of a wither");
    case WOLF: 
      if (((Wolf)e).isTamed()) {
        return config.getDouble("CreatureHp.hp of a tamed wolf");
      }
      return config.getDouble("CreatureHp.hp of a wolf");
    case SKELETON: 
      Skeleton sk = (Skeleton)e;
      if (sk.getSkeletonType() == Skeleton.SkeletonType.WITHER) {
        return config.getDouble("CreatureHp.hp of a wither skeleton");
      }
      return config.getDouble("CreatureHp.hp of a skeleton");
    case MAGMA_CUBE: 
      int size = ((MagmaCube)e).getSize();
      switch (size)
      {
      case 1: 
        return config.getDouble("CreatureHp.hp of a magma cube tiny");
      case 2: 
        return config.getDouble("CreatureHp.hp of a magma cube small");
      }
      return config.getDouble("CreatureHp.hp of a magma cube big");
    case SLIME: 
      int s = ((Slime)e).getSize();
      switch (s)
      {
      case 1: 
        return config.getDouble("CreatureHp.hp of a slime tiny");
      case 2: 
        return config.getDouble("CreatureHp.hp of a slime small");
      }
      return config.getDouble("CreatureHp.hp of a slime big");
    case ZOMBIE: 
      Zombie z = (Zombie)e;
      if (z.isVillager())
      {
        if (z.isBaby()) {
          return config.getDouble("CreatureHp.hp of a baby zombie villager");
        }
        return config.getDouble("CreatureHp.hp of a zombie villager");
      }
      if (z.isBaby()) {
        return config.getDouble("CreatureHp.hp of a baby zombie");
      }
      return config.getDouble("CreatureHp.hp of a zombie");
    }
    return e.getMaxHealth();
  }
  
  public static boolean isEnabledInWorld(World w)
  {
    if (w == null) {
      return false;
    }
    if (!isEnabled()) {
      return false;
    }
    List<String> worlds = config.getStringList("CreatureHp.enabledWorlds");
    if ((worlds == null) || (worlds.size() == 0)) {
      return true;
    }
    if ((worlds.size() == 1) && (((String)worlds.get(0)).equalsIgnoreCase(""))) {
      return true;
    }
    for (String s : worlds) {
      if (w.getName().equalsIgnoreCase(s)) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean isEnabled()
  {
    return config.getBoolean("CreatureHp.enabled");
  }
  
  public static long getMinimumTimeBetweenAttacks()
  {
    return config.getLong("CreatureHp.minimum time between each attack on a creature in milliseconds");
  }
}
