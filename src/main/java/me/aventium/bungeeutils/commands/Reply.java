package me.aventium.bungeeutils.commands;

import me.aventium.bungeeutils.utils.Chat;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

/**
 * Created by student on 9/11/14.
 */
public class Reply extends Command {

    public Reply() {
        super("reply", "bungeeutils.message", "r");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(args.length < 1) {
            Chat.sendMessage(sender, "&c/reply <message>");
            return;
        }

        if(!Chat.messages.containsKey(sender.getName())) {
            Chat.sendMessage(sender, "&cYou haven't messaged anyone!");
            return;
        }

        ProxiedPlayer player = ProxyServer.getInstance().getPlayer(Chat.messages.get(sender.getName()));

        if(player == null) {
            Chat.sendMessage(sender, "&cPlayer '" + args[0] + "' not found!");
            return;
        }

        StringBuilder message = new StringBuilder();
        for(int i = 0; i < args.length; i++) {
            message.append(args[i] + " ");
        }

        String msg = message.toString().trim();

        Chat.sendMessage(sender, "&7[me -> " + player.getName() + "] " + msg);
        Chat.sendMessage(player, "&7[" + sender.getName() + " -> me] " + msg);

        Chat.messages.put(player.getName(), sender.getName());
    }

}
