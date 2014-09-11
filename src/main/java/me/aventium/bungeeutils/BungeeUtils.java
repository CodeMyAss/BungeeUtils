package me.aventium.bungeeutils;

import me.aventium.bungeeutils.commands.Message;
import me.aventium.bungeeutils.commands.Reply;
import me.aventium.bungeeutils.commands.SendServer;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Plugin;

import java.util.HashMap;

public class BungeeUtils extends Plugin {
    
    HashMap<String, String> messages;

    public void onEnable() {
        // Register commands
        this.messages = new HashMap<String, String>();
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new Message(this));
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new Reply(this));
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new SendServer(this));
    }
    
    public HashMap<String, String> getMessages() {
      return messages;
    }
    
    public void sendMessage(CommandSender arg0, String arg1) {
      arg0.sendMessage(new TextComponent(ChatColor.translateAlternateColorCodes('&', arg1)));
    }
}
