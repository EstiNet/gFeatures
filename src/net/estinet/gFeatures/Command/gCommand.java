package net.estinet.gFeatures.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2016 EstiNet

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

public class gCommand extends Command{
	  private CommandExecutor exe = null;
	  
      public gCommand(String name) {
          super(name);
      }

      public boolean execute(CommandSender sender, String commandLabel, String[] args) {
          if(exe != null){
              exe.onCommand(sender, this, commandLabel,args);
          }
          return false;
      }
     
      public void setExecutor(CommandExecutor exe){
          this.exe = exe;
      }
}
