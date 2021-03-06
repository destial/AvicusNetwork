package net.avicus.magma.channel.premium;

import java.util.Locale;
import java.util.Map;
import net.avicus.magma.channel.distributed.DistributedSimpleDescriptorChannel;
import net.avicus.magma.database.model.impl.Server;
import net.avicus.magma.database.model.impl.User;
import net.avicus.magma.network.rtp.RTPHelpers;
import net.avicus.magma.text.Components;
import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.ChatColor;

public final class BedrockChannel extends DistributedSimpleDescriptorChannel {

  public BedrockChannel() {
    super("bedrock", "channel.bedrock", channelDescriptor("BEDROCK", ChatColor.DARK_GRAY));
  }

  @Override
  protected void format(BaseComponent template, Server server, User source,
      BaseComponent[] components, Map<String, String> context) {
    if (!context.getOrDefault("simple", "false").equals("true")) {
      template.addExtra(RTPHelpers.clickablePlayerFullName(server, source, Locale.US));
      template.addExtra(Components.simple(": ", ChatColor.GRAY));
    }

    template.addExtra(Components.simple(components, ChatColor.WHITE));
  }
}
