package com.ancientreborn.Ancient.Loader;

import com.ancientreborn.Ancient.Ancient;
import com.ancientreborn.Ancient.CompatibilityTool;
import com.ancientreborn.Ancient.Dependencies.DependencyManager;
import com.ancientreborn.Ancient.Dependencies.DependencyManager.DependencyType;
import org.bukkit.Bukkit;

public class Dependencys 
{
    
    private final Ancient plugin;
    
    //Construction
    public Dependencys( Ancient plugin )
    {
        
        this.plugin = plugin;
        
        LoadDependency();
        
        LoadVersionDependency();
        
    }
    
    /*                              HOW TO USE
     * DependencyManager.CheckDependency( PluginName, DependencyType );
     */
    
    //Check dependency
    private void LoadDependency()
    {
        
        //Check for Vault
        DependencyManager.CheckDependency( "Vault" , DependencyType.REQUIRED );
        
    }
    
    //Check dependencies by version
    private void LoadVersionDependency()
    {
        
        switch( CompatibilityTool.getSrvVersion() )
            {
                
                //Version unknown
                case VERSION_NONE:
                    
                    System.out.println( plugin.ConsoleBrand + "Unknown server system! Disabling." );
                    
                    Bukkit.getPluginManager().disablePlugin( plugin );
                    
                    break;
                    
                case VERSION_1_9_2:
                    
                    System.out.println( plugin.ConsoleBrand + "Using compatibility: 1.9.2" );
                    
                    /*
                     *      Load all classes/listeners that require 1.9.2
                     */
                    
                    break;
                    
                case VERSION_1_9_4:
                    
                    System.out.println( plugin.ConsoleBrand + "Using compatibility: 1.9.4" );
                    
                    /*
                     *      Load all classes/listeners that require 1.9.4
                     */
                    
                    break;
                    
                case VERSION_1_10_0:
                    
                    System.out.println( plugin.ConsoleBrand + "Using compatibility: 1.10.0" );
                    
                    /*
                     *      Load all classes/listeners that require 1.10.0
                     */
                
                    break;
                    
            }
        
    }
    
}
