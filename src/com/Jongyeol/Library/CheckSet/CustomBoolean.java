package com.Jongyeol.Library.CheckSet;

import java.util.ArrayList;

public class CustomBoolean {

    private static ArrayList<String> True = new ArrayList<>();
    private static ArrayList<String> False = new ArrayList<>();
    private static ArrayList<String> CustomBoolean = new ArrayList<>();
    public CustomBoolean() {
        True.add("true");
        True.add("yes");
        True.add("ok");
        True.add("positive");
        True.add("1");
        True.add("on");
        False.add("false");
        False.add("nope");
        False.add("not");
        False.add("denial");
        False.add("0");
        False.add("off");
        CustomBoolean.addAll(True);
        CustomBoolean.addAll(False);
    }
    public static boolean booleanCheck(String string) {
        String[] args = string.toLowerCase().split("");
        Boolean test = true;
        for(int i1=0; i1 < CustomBoolean.size(); i1++){
            String[] bool = CustomBoolean.get(i1).split("");
            for(int i2=0; i2 < args.length; i2++){
                if (args.length < bool.length){
                    if (!args[i2].equals(bool[i2])) {
                        test = false;
                        break;
                    }
                } else {
                    test = false;
                    break;
                }
            }
            if(test) { return true;}
        }
        return false;
    }
    public static boolean makeboolean(String string) {
        String[] args = string.toLowerCase().split("");
        Boolean test = true;
        for(int i1=0; i1 < True.size(); i1++){
            if(string.toLowerCase().equals(True.get(i1))){
                return true;
            }
            String[] true1b = True.get(i1).split("");
            for(int i2=0; i2 < args.length; i2++){
                if (args.length < true1b.length){
                    if (!args[i2].equals(true1b[i2])) {
                        test = false;
                        break;
                    }
                } else {
                    test = false;
                    break;
                }
            }
            if(test) { return true;}
        }
        return false;
    }
    public static ArrayList<String> getTrue() {
        return True;
    }

    public static ArrayList<String> getFalse() {
        return False;
    }

    public static ArrayList<String> getCustomBoolean() {
        return CustomBoolean;
    }
}
