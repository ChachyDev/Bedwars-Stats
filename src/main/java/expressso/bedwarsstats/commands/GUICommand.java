package expressso.bedwarsstats.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

public class GUICommand extends CommandBase {
    @Override
    public String getCommandName() {
        return "bedwarsstatsgui";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "bedwarsstatsgui";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        //todo Make GUI
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }
}
