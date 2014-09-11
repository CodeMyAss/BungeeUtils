package me.aventium.bungeeutils.commands;

import me.aventium.bungeeutils.BungeeUtils;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.plugin.Command;

/**
 * Created by student on 9/11/14.
 */
public class Count extends Command {

    BungeeUtils utils;

    public Count(BungeeUtils utils) {
        super("count", "bungeeutils.count", null);
        this.utils = utils;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(args.length < 1) {
            utils.sendMessage(sender, "&c/count <server>");
            return;
        }

        ServerInfo server = ProxyServer.getInstance().getServerInfo(args[0]);

        if(server == null) {
            utils.sendMessage(sender, "&cServer '" + args[0] + "' not found!");
            return;
        }

        utils.sendMessage(sender, "&ePlayer count for &6" + server.getName() + "&e: &6" + server.getPlayers().size() + "&e.");
    }

}
