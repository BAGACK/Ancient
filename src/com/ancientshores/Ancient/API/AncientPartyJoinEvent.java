package com.ancientshores.Ancient.API;

import com.ancientshores.Ancient.Party.AncientParty;
import java.util.UUID;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class AncientPartyJoinEvent
  extends Event
  implements Cancellable
{
  final HandlerList hl = new HandlerList();
  boolean cancelled;
  private UUID uuid;
  private AncientParty mParty;
  
  public AncientPartyJoinEvent(UUID uuidPlayerJoining, AncientParty mParty)
  {
    this.mParty = mParty;
    this.uuid = uuidPlayerJoining;
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


/* Location:              C:\Users\Jens\Desktop\Spigot Server\plugins\Ancient_v1.1.0 (1).jar!\com\ancientshores\Ancient\API\AncientPartyJoinEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */