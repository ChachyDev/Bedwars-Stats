package conortheoreo.bedwarsstats.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

import static conortheoreo.bedwarsstats.stats.BedwarsLevel.getBedwarsLevel;

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
        getBedwarsLevel();
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }
}
