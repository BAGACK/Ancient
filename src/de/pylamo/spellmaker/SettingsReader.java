package de.pylamo.spellmaker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class SettingsReader
{
  public static UpdateType type = UpdateType.Release;
  
  public static void writeSettings()
  {
    File f = new File("spellmaker.settings");
    try
    {
      if (!f.exists()) {
        f.createNewFile();
      }
      BufferedWriter br = new BufferedWriter(new FileWriter(f));
      br.write(type.name());
      br.close();
    }
    catch (Exception ignored) {}
  }
  
  public static void readSettings()
  {
    File f = new File("spellmaker.settings");
    try
    {
      if (!f.exists()) {
        return;
      }
      BufferedReader br = new BufferedReader(new FileReader(f));
      String name = br.readLine();
      type = UpdateType.valueOf(name);
      br.close();
    }
    catch (Exception ignored) {}
  }
  
  public static enum UpdateType
  {
    Release,  Development,  Custom;
    
    private UpdateType() {}
  }
}


/* Location:              C:\Users\Jens\Desktop\Spigot Server\plugins\Ancient_v1.1.0 (1).jar!\de\pylamo\spellmaker\SettingsReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */