package me.aventium.bungeeutils.commands;

import me.aventium.bungeeutils.utils.Chat;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Message extends Command {

    public Message() {
        super("message", "bungeeutils.message", new String[]{ "tell", "msg" });
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(args.length < 2) {
            Chat.sendMessage(sender, "&c/message <player> <message>");
            return;
        }

        ProxiedPlayer player = ProxyServer.getInstance().getPlayer(args[0]);

        if(player == null) {
            Chat.sendMessage(sender, "&cPlayer '" + args[0] + "' not found!");
            return;
        }

        StringBuilder message = new StringBuilder();
        for(int i = 1; i < args.length; i++) {
            message.append(args[i] + " ");
        }

        String msg = message.toString().trim();

        Chat.sendMessage(sender, "&7[me -> " + player.getName() + "] " + msg);
        Chat.sendMessage(player, "&7[" + sender.getName() + " -> me] " + msg);

        Chat.messages.put(sender.getName(), player.getName());
        Chat.messages.put(player.getName(), sender.getName());
    }
}
