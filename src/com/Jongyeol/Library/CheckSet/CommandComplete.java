package com.Jongyeol.Library.CheckSet;

import java.util.List;

public class CommandComplete {
    public static List<String> getCompleteList(List<String> commandList, String arguments){
        String[] args = arguments.toLowerCase().split("");
        if (args[0].equals("")){
            return commandList;
        }
        int i1=0;
        while(i1 < commandList.size()) {
            String[] arg1b = commandList.get(i1).toLowerCase().split("");
            for(int i2=0; i2 < args.length; i2++){
                if (args.length < arg1b.length){
                    if (!args[i2].equals(arg1b[i2])) {
                        commandList.remove(commandList.get(i1));
                        i1--;
                        break;
                    }
                } else {
                    commandList.remove(commandList.get(i1));
                    i1--;
                    break;
                }
            }
            i1++;
        }
        return commandList;
    }
}
