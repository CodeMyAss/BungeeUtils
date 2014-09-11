package me.aventium.bungeeutils.utils;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;

import java.util.HashMap;


public class Chat {

    public static HashMap<String, String> messages = new HashMap<>();

    public static void sendMessage(CommandSender arg0, String arg1) {
        arg0.sendMessage(new TextComponent(ChatColor.translateAlternateColorCodes('&', arg1)));
    }

}
