package me.aventium.bungeeutils;

import me.aventium.bungeeutils.commands.Message;
import me.aventium.bungeeutils.commands.Reply;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

public class BungeeUtils extends Plugin {
    
    HashMap<String, String> messages;

    public void onEnable() {
        // Register commands
        this.messages = new HashMap<String, String>();
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new Message());
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new Reply());
    }
    
    public HashMap<String, String> getMessages() {
      return messages;
    }
}
