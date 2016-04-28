package com.ancientshores.Ancient.Util;

import com.ancientshores.Ancient.Ancient;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

public class FlatFileConnector
{
  final Ancient plugin;
  
  public FlatFileConnector(Ancient plugin)
  {
    this.plugin = plugin;
  }
  
  public HashMap<String, Integer[]> vars = new HashMap();
  
  public HashMap<String, Integer[]> getValues(File f)
  {
    try
    {
      HashMap<String, Integer[]> map = new HashMap();
      
      BufferedReader bf = new BufferedReader(new FileReader(f));
      ArrayList<String[]> lines = new ArrayList();
      String line = bf.readLine();
      while (line != null)
      {
        lines.add(removeSpaces(line.split(" ")));
        line = bf.readLine();
      }
      bf.close();
      if (lines.size() > 1)
      {
        ArrayList<String> varnames = new ArrayList();
        for (int i = 1; i < ((String[])lines.get(0)).length; i++) {
          varnames.add(((String[])lines.get(0))[i].trim());
        }
        for (String s : varnames) {
          map.put(s.trim(), new Integer[lines.size() - 1]);
        }
        int rowcount = lines.size() - 1;
        if (rowcount > 0) {
          for (int r = 0; r < rowcount; r++) {
            for (int x = 1; x <= varnames.size(); x++) {
              ((Integer[])map.get(varnames.get(x - 1)))[r] = Integer.valueOf(Integer.parseInt(((String[])lines.get(r + 1))[x]));
            }
          }
        }
        return map;
      }
    }
    catch (FileNotFoundException e)
    {
      this.plugin.log.warning("Ancient: couldn't read flatfile, does the folder exist?");
    }
    catch (IOException e)
    {
      this.plugin.log.warning("Ancient: error by parsing the file, please recreate or fix it.");
    }
    return new HashMap();
  }
  
  public int getIntOfFile(String level, String rowName, File f)
  {
    YamlConfiguration yc = new YamlConfiguration();
    try
    {
      yc.load(f);
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    catch (InvalidConfigurationException e)
    {
      e.printStackTrace();
    }
    return yc.getInt(f.getName().substring(0, f.getName().lastIndexOf('.')) + ".variables." + rowName + ".level" + level);
  }
  
  public String[] removeSpaces(String[] s)
  {
    int count = 0;
    for (String value1 : s) {
      if ((!value1.equalsIgnoreCase("")) && (!value1.equalsIgnoreCase(" ")) && (!value1.equalsIgnoreCase("\t"))) {
        count++;
      }
    }
    String[] st = new String[count];
    int anzahl = 0;
    for (String value : s) {
      if ((!value.equalsIgnoreCase("")) && (!value.equalsIgnoreCase(" ")) && (!value.equalsIgnoreCase("\t")))
      {
        st[anzahl] = value;
        anzahl++;
      }
    }
    return st;
  }
}


/* Location:              C:\Users\Jens\Desktop\Spigot Server\plugins\Ancient_v1.1.0 (1).jar!\com\ancientshores\Ancient\Util\FlatFileConnector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */