package me.axua.impactplus.module.modules.chat;

import java.util.ArrayList;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.command.Command;
import me.axua.impactplus.event.events.PacketEvent;
import me.axua.impactplus.gui.settings.Setting;
import me.axua.impactplus.module.Module;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.network.play.client.CPacketChatMessage;

public class ChatSuffix extends Module {

    Setting suffixmode;

    public ChatSuffix() {
        super("ChatSuffix", Module.Category.CHAT, "Adds a suffix to your messages");
    }

    @EventHandler
    private Listener<PacketEvent.Send> listener = new Listener<>(event -> {
        if (event.getPacket() instanceof CPacketChatMessage) {
            if (((CPacketChatMessage)event.getPacket()).getMessage().startsWith("/") || ((CPacketChatMessage)event.getPacket()).getMessage().startsWith(Command.getPrefix()) || ((CPacketChatMessage)event.getPacket()).getMessage().startsWith(".") || ((CPacketChatMessage)event.getPacket()).getMessage().startsWith("!") || ((CPacketChatMessage)event.getPacket()).getMessage().startsWith("#"))
                return;
            String server = (mc.getCurrentServerData()).serverIP.toLowerCase();
            String old = ((CPacketChatMessage)event.getPacket()).getMessage();
            String suffix = "";
            String s = "";
            if (server.equals("2b2t.org")) {
                if (this.suffixmode.getValString().equalsIgnoreCase("Salhack"))
                    suffix = " Salhack";
                if (this.suffixmode.getValString().equalsIgnoreCase("Impact+"))
                    suffix = " Impact+";
            } else {
                if (this.suffixmode.getValString().equalsIgnoreCase("Salhack"))
                    suffix = " áµŸáµƒá´¸á´´áµƒá¶œá´·";
                if (this.suffixmode.getValString().equalsIgnoreCase("Impact+"))
                    suffix = " Éªá´?á´˜á´€á´„á´›â‚Š";
            }
            s = old + suffix;
            int longs = s.length();
            int ok = 0;
            if (s.length() > 255)
                ok = longs - 255;
            s = s.substring(0, s.length() - ok);
            ((CPacketChatMessage)event.getPacket()).message = s;
        }
    });

    public void setup() {
        ArrayList<String> modes = new ArrayList<>();
        modes.add("Impact+");
        modes.add("Salhack");
        (ImpactPlus.getInstance()).settingsManager.rSetting(this.suffixmode = new Setting("Suffix", this, "Impact+", modes, "SuffixMode"));
    }

    public void onEnable() {
        ImpactPlus.EVENT_BUS.subscribe(this);
    }

    public void onDisable() {
        ImpactPlus.EVENT_BUS.unsubscribe(this);
    }
}