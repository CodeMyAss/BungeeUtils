package me.aventium.bungeeutils.commands;

import me.aventium.bungeeutils.BungeeUtils;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class SendServer extends Command {

    BungeeUtils utils;

    public SendServer(BungeeUtils utils) {
        super("sendserver", "bungeeutils.sendserver", "sserver");
        this.utils = utils;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(args.length < 2) {
            utils.sendMessage(sender, "&c/sendserver <from> <to>");
            return;
        }

        ServerInfo from = ProxyServer.getInstance().getServerInfo(args[0]);
        ServerInfo to = ProxyServer.getInstance().getServerInfo(args[1]);

        if(from == null) {
            utils.sendMessage(sender, "&cServer '" + args[0] + "' not found!");
            return;
        }

        if(to == null) {
            utils.sendMessage(sender, "&cServer '" + args[1] + "' not found!");
            return;
        }

        for(ProxiedPlayer p : from.getPlayers()) {
            p.connect(to);
            utils.sendMessage(p, "&eYou have been summoned to &6" + to.getName() + " &eby &6" + sender.getName() + "&e.");
        }
        return;
    }
}
