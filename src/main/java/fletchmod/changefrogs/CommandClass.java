package fletchmod.changefrogs;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Frog;
import org.bukkit.entity.Player;

import java.util.List;

public class CommandClass implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            if(command.getName().equalsIgnoreCase("setfrogtype")){
                Frog nearestFrog=null;
                Player player= (Player) sender;
                List<Entity> near = player.getNearbyEntities(2.0D, 2.0D, 2.0D);
                Boolean frogFound=false;
                for(Entity current:near){
                    if(frogFound!=true && current instanceof Frog){
                        frogFound=true;
                        nearestFrog=(Frog)current;
                    }
                }
                if(!frogFound){
                    sender.sendMessage(ChatColor.RED+"Can't find a frog!");
                }
                else{
                    if(args[0].equalsIgnoreCase("cold")){
                        sender.sendMessage(ChatColor.GREEN+"Frog Updated!");
                        nearestFrog.setVariant(Frog.Variant.COLD);
                    }
                    else if(args[0].equalsIgnoreCase("warm")){
                        sender.sendMessage(ChatColor.GREEN+"Frog Updated!");
                        nearestFrog.setVariant(Frog.Variant.WARM);
                    }
                    else if(args[0].equalsIgnoreCase("temperate")){
                        sender.sendMessage(ChatColor.GREEN+"Frog Updated!");
                        nearestFrog.setVariant(Frog.Variant.TEMPERATE);
                    }
                    else{
                        sender.sendMessage(ChatColor.RED+"Not a valid frog type! Try warm, cold, or temperate");
                    }
                }
            }

        }
        return true;
    }
}
