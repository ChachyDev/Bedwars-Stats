package expressso.bedwarsstats.commands;

import expressso.bedwarsstats.stats.BedwarsLevel;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

public class ForceUpdate extends CommandBase {


    @Override
    public String getCommandName() {
        return "forceupdate";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "forceupdate";
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
