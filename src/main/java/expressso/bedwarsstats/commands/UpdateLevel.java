package expressso.bedwarsstats.commands;

import expressso.bedwarsstats.stats.BedwarsLevel;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

public class UpdateLevel extends CommandBase {


    @Override
    public String getCommandName() {
        return "updatelevel";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "updatelevel";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        BedwarsLevel.getBedwarsLevel();
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }
}
