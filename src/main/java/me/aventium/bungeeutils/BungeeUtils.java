package me.aventium.bungeeutils;

import me.aventium.bungeeutils.commands.Message;
import me.aventium.bungeeutils.commands.Reply;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

public class BungeeUtils extends Plugin {

    public void onEnable() {
        // Register commands
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new Message());
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new Reply());
    }

}
