package net.estinet.gFeatures.Command;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import net.estinet.gFeatures.Extension;
import net.estinet.gFeatures.gFeature;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2018 EstiNet

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

public class EstiCommand extends Command {
    private gFeature feature;
    private Extension extension;
    private CommandExecutable execution;
    private boolean methodTrigger = false;

    public EstiCommand(String name, String description, String usageMessage, String permission, gFeature feature, CommandExecutable executedTask) {
        super(name);
        super.setDescription(description);
        super.setPermission(permission);
        super.setUsage(usageMessage);
        this.feature = feature;
        execution = executedTask;
    }

    public EstiCommand(String name, String description, String usageMessage, String permission, Extension extension, CommandExecutable executedTask) {
        super(name);
        super.setDescription(description);
        super.setPermission(permission);
        super.setUsage(usageMessage);
        this.extension = extension;
        execution = executedTask;
    }

    public EstiCommand(String name, String description, String usageMessage, String permission, gFeature feature, CommandExecutable executedTask, List<String> aliases) {
        super(name);
        super.setDescription(description);
        super.setPermission(permission);
        super.setUsage(usageMessage);
        this.feature = feature;
        super.setAliases(aliases);
        execution = executedTask;
    }

    public EstiCommand(String name, String description, String usageMessage, String permission, Extension extension, CommandExecutable executedTask, List<String> aliases) {
        super(name);
        super.setDescription(description);
        super.setPermission(permission);
        super.setUsage(usageMessage);
        this.extension = extension;
        super.setAliases(aliases);
        execution = executedTask;
    }

    public EstiCommand(String name, String description, String usageMessage, String permission, gFeature feature, boolean methodTrigger) {
        super(name);
        super.setDescription(description);
        super.setPermission(permission);
        super.setUsage(usageMessage);
        this.feature = feature;
        this.methodTrigger = methodTrigger;
    }

    public EstiCommand(String name, String description, String usageMessage, String permission, Extension extension, boolean methodTrigger) {
        super(name);
        super.setDescription(description);
        super.setPermission(permission);
        super.setUsage(usageMessage);
        this.extension = extension;
        this.methodTrigger = methodTrigger;
    }

    public EstiCommand(String name, String description, String usageMessage, String permission, gFeature feature, List<String> aliases, boolean methodTrigger) {
        super(name);
        super.setDescription(description);
        super.setPermission(permission);
        super.setUsage(usageMessage);
        this.feature = feature;
        super.setAliases(aliases);
        this.methodTrigger = methodTrigger;
    }

    public EstiCommand(String name, String description, String usageMessage, String permission, Extension extension, List<String> aliases, boolean methodTrigger) {
        super(name);
        super.setDescription(description);
        super.setPermission(permission);
        super.setUsage(usageMessage);
        this.extension = extension;
        super.setAliases(aliases);
        this.methodTrigger = methodTrigger;
    }

    public EstiCommand(String name, String description, String usageMessage, gFeature feature, CommandExecutable executedTask) {
        super(name);
        super.setDescription(description);
        super.setUsage(usageMessage);
        this.feature = feature;
        execution = executedTask;
    }

    public EstiCommand(String name, String description, String usageMessage, Extension extension, CommandExecutable executedTask) {
        super(name);
        super.setDescription(description);
        super.setUsage(usageMessage);
        this.extension = extension;
        execution = executedTask;
    }

    public EstiCommand(String name, String description, String usageMessage, gFeature feature, CommandExecutable executedTask, List<String> aliases) {
        super(name);
        super.setDescription(description);
        super.setUsage(usageMessage);
        this.feature = feature;
        super.setAliases(aliases);
        execution = executedTask;
    }

    public EstiCommand(String name, String description, String usageMessage, Extension extension, CommandExecutable executedTask, List<String> aliases) {
        super(name);
        super.setDescription(description);
        super.setUsage(usageMessage);
        this.extension = extension;
        super.setAliases(aliases);
        execution = executedTask;
    }

    public EstiCommand(String name, String description, String usageMessage, gFeature feature, boolean methodTrigger) {
        super(name);
        super.setDescription(description);
        super.setUsage(usageMessage);
        this.feature = feature;
        this.methodTrigger = methodTrigger;
    }

    public EstiCommand(String name, String description, String usageMessage, Extension extension, boolean methodTrigger) {
        super(name);
        super.setDescription(description);
        super.setUsage(usageMessage);
        this.extension = extension;
        this.methodTrigger = methodTrigger;
    }

    public EstiCommand(String name, String description, String usageMessage, gFeature feature, List<String> aliases, boolean methodTrigger) {
        super(name);
        super.setDescription(description);
        super.setUsage(usageMessage);
        this.feature = feature;
        super.setAliases(aliases);
        this.methodTrigger = methodTrigger;
    }

    public EstiCommand(String name, String description, String usageMessage, Extension extension, List<String> aliases, boolean methodTrigger) {
        super(name);
        super.setDescription(description);
        super.setUsage(usageMessage);
        this.extension = extension;
        super.setAliases(aliases);
        this.methodTrigger = methodTrigger;
    }

    public gFeature getFeature() {
        return feature;
    }

    public Extension getExtension() {
        return extension;
    }

    public void setFeature(gFeature feature) {
        this.feature = feature;
    }

    public void setExtension(Extension extension) {
        this.extension = extension;
    }

    @Override
    public boolean execute(CommandSender sender, String arg1, String[] args) {
        if (methodTrigger) {
            feature.commandTrigger(sender, this, this.getLabel(), args);
        } else {
            execution.args = args;
            execution.cmd = this;
            execution.sender = sender;
            execution.run();
        }
        return false;
    }
}
