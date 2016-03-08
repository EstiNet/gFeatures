package net.estinet.gFeatures.Command;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import net.estinet.gFeatures.Extension;
import net.estinet.gFeatures.gFeature;

public class EstiCommand {
	private String name, description;
	private gFeature feature;
	private Extension extension;
	private CommandExecutable execution;
	private boolean multiThread, methodTrigger = false;
	private List<String> aliases = new ArrayList<>();
	public EstiCommand(String name, String description, gFeature feature, CommandExecutable executedTask){
		this.name = name;
		this.description = description;
		this.feature = feature;
		execution = executedTask;
	}
	public EstiCommand(String name, String description, Extension extension, CommandExecutable executedTask){
		this.name = name;
		this.description = description;
		this.extension = extension;
		execution = executedTask;
	}
	public EstiCommand(String name, String description, gFeature feature, CommandExecutable executedTask, List<String> aliases){
		this.name = name;
		this.description = description;
		this.feature = feature;
		this.aliases = aliases;
		execution = executedTask;
	}
	public EstiCommand(String name, String description, Extension extension, CommandExecutable executedTask, List<String> aliases){
		this.name = name;
		this.description = description;
		this.extension = extension;
		this.aliases = aliases;
		execution = executedTask;
	}
	public EstiCommand(String name, String description, gFeature feature, CommandExecutable executedTask, boolean methodTrigger){
		this.name = name;
		this.description = description;
		this.feature = feature;
		this.methodTrigger = methodTrigger;
		execution = executedTask;
	}
	public EstiCommand(String name, String description, Extension extension, CommandExecutable executedTask, boolean methodTrigger){
		this.name = name;
		this.description = description;
		this.extension = extension;
		this.methodTrigger = methodTrigger;
		execution = executedTask;
	}
	public EstiCommand(String name, String description, gFeature feature, CommandExecutable executedTask, List<String> aliases, boolean methodTrigger){
		this.name = name;
		this.description = description;
		this.feature = feature;
		this.aliases = aliases;
		this.methodTrigger = methodTrigger;
		execution = executedTask;
	}
	public EstiCommand(String name, String description, Extension extension, CommandExecutable executedTask, List<String> aliases, boolean methodTrigger){
		this.name = name;
		this.description = description;
		this.extension = extension;
		this.aliases = aliases;
		this.methodTrigger = methodTrigger;
		execution = executedTask;
	}
	public String getName(){
		return name;
	}
	public String getDescription(){
		return description;
	}
	public gFeature getFeature(){
		return feature;
	}
	public Extension getExtension(){
		return extension;
	}
	public List<String> getAliases(){
		return aliases;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setDescription(String description){
		this.description = description;
	}
	public void setFeature(gFeature feature){
		this.feature = feature;
	}
	public void setExtension(Extension extension){
		this.extension = extension;
	}
	public void setAliases(List<String> aliases){
		this.aliases = aliases;
	}
	public void addAlias(String alias){
		aliases.add(alias);
	}
	public void removeAlias(String alias){
		aliases.remove(alias);
	}
	public void execute(CommandSender sender, Command cmd, String[] args){
		if(methodTrigger){
			feature.commandTrigger(sender, cmd, cmd.getLabel(), args);
		}
		else{
		execution.args = args;
		execution.cmd = cmd;
		execution.sender = sender;
		if(!multiThread){
			execution.run();
		}
		else{
			Thread thr = new Thread(new Runnable(){
				public void run(){
					execution.run();
				}
			});
			thr.start();
		}
		}
	}
}
