package com.ancientshores.AncientRPG.Classes.Spells.Parameters;

import com.ancientshores.AncientRPG.AncientRPG;
import com.ancientshores.AncientRPG.Classes.Spells.Commands.EffectArgs;
import com.ancientshores.AncientRPG.Classes.Spells.IParameter;
import com.ancientshores.AncientRPG.Classes.Spells.ParameterType;
import com.ancientshores.AncientRPG.Classes.Spells.SpellInformationObject;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.logging.Level;

public class NearestHostileEntityParameter implements IParameter {

    @Override
    public void parseParameter(EffectArgs ea, Player mPlayer, String[] subparam, ParameterType pt) {
        int range = 10;
        int count = 1;

        if (subparam != null) {
            try {
                if (ea.p.variables.contains(subparam[0].toLowerCase())) {
                    range = ea.so.parseVariable(mPlayer, subparam[0].toLowerCase());
                } else {
                    range = Integer.parseInt(subparam[0]);
                }
            } catch (Exception e) {
                AncientRPG.plugin.getLogger().log(Level.WARNING, "Error in subparameter " + subparam + " in command " + ea.mCommand.commandString + " falling back to default");
            }
            try {
                if (ea.p.variables.contains(subparam[1].toLowerCase())) {
                    count = ea.so.parseVariable(mPlayer, subparam[1].toLowerCase());
                } else {
                    count = Integer.parseInt(subparam[1]);
                }
            } catch (Exception e) {
                AncientRPG.plugin.getLogger().log(Level.WARNING, "Error in subparameter " + subparam + " in command " + ea.mCommand.commandString + " falling back to default");
            }
        }
        if (subparam != null || ea.so.hostileEntities == null || ea.so.hostileEntities[0] == null) {
            Entity[] nEntities = ea.so.getNearestHostileEntities(mPlayer, range, count);
            ea.so.hostileEntities = nEntities;
            if (nEntities == null) {
                return;
            }
        }
        switch (pt) {
            case Entity:
                Entity[] e = ea.so.hostileEntities;
                ea.params.addLast(e);
                break;
            case Location:
                Location[] l = new Location[ea.so.hostileEntities.length];
                for (int i = 0; i < ea.so.hostileEntities.length; i++) {
                    if (ea.so.hostileEntities[i] != null) {
                        l[i] = ea.so.hostileEntities[i].getLocation();
                    }
                }
                ea.params.addLast(l);
                break;
            default:
                AncientRPG.plugin.getLogger().log(Level.SEVERE, "Syntax error in command " + ea.mCommand.commandString);
        }
    }

    @Override
    public String getName() {
        return "nearesthostilenetity";
    }

    @Override
    public Object parseParameter(Player mPlayer, String[] subparam, SpellInformationObject so) {
        int range = 10;
        int count = 1;

        if (subparam != null) {
            try {
                if (so.mSpell.variables.contains(subparam[0].toLowerCase())) {
                    range = so.parseVariable(mPlayer, subparam[0].toLowerCase());
                } else {
                    range = Integer.parseInt(subparam[0]);
                }
            } catch (Exception ignored) {
            }
            try {
                if (so.mSpell.variables.contains(subparam[1].toLowerCase())) {
                    count = so.parseVariable(mPlayer, subparam[1].toLowerCase());
                } else {
                    count = Integer.parseInt(subparam[1]);
                }
            } catch (Exception ignored) {
            }
        }
        if (subparam != null || so.hostileEntities == null || so.hostileEntities[0] == null) {
            Entity[] nEntities = so.getNearestHostileEntities(mPlayer, range, count);
            so.hostileEntities = nEntities;
        }
        return so.hostileEntities;
    }
}