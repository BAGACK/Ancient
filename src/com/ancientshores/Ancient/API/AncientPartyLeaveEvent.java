package com.ancientshores.Ancient.API;

import com.ancientshores.Ancient.Party.AncientParty;
import java.util.UUID;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class AncientPartyLeaveEvent
  extends Event
  implements Cancellable
{
  final HandlerList hl = new HandlerList();
  boolean cancelled;
  private UUID uuid;
  private AncientParty mParty;
  
  public AncientPartyLeaveEvent(UUID uuidPlayerLeaving, AncientParty mParty)
  {
    this.mParty = mParty;
    this.uuid = uuidPlayerLeaving;
  }
  
  public HandlerList getHandlers()
  {
    return this.hl;
  }
  
  public boolean isCancelled()
  {
    return this.cancelled;
  }
  
  public void setCancelled(boolean arg0)
  {
    this.cancelled = arg0;
  }
  
  public UUID getUUID()
  {
    return this.uuid;
  }
  
  public AncientParty getParty()
  {
    return this.mParty;
  }
}
