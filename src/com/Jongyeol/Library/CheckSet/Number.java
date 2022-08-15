package com.Jongyeol.Library.CheckSet;

public class Number {
    private static String makeNumber(String string){
        String[] strings = string.split("");
        String st = "";
        if(strings[0].equals("-")){
            st = st + "-";
        }
        for(String s : strings) {
            for(int i = 0; i < 10; i++) {
                if(s.equals(i + "")) {
                    st = st + i;
                }
            }
            if(s.equals(".")) {
                break;
            }
        }
        return st;
    }
    private static String makeDotNumber(String string){
        String[] strings = string.split("");
        String st = "";
        if(strings[0].equals("-")){
            st = st + "-";
        }
        for(String s : strings) {
            for(int i = 0; i < 10; i++) {
                if(s.equals(i + "")) {
                    st = st + i;
                }
            }
            if(s.equals(".")) {
                st = st + ".";
            }
        }
        return st;
    }
    public static byte makebyte(String string) {
        return Byte.parseByte(makeNumber(string));
    }
    public static short makeshort(String string) {
        return Short.parseShort(makeNumber(string));
    }
    public static int makeinteger(String string) {
        return Integer.parseInt(makeNumber(string));
    }
    public static long makeLong(String string) {
        return Long.parseLong(makeNumber(string));
    }
    public static float makefloat(String string) {
        return Float.parseFloat(makeDotNumber(string));
    }
    public static double makedouble(String string) {
        return Double.parseDouble(makeDotNumber(string));
    }
    public static boolean NumberCheck(String string){
        for (int i=0; i < 10; i++){
            if(string.contains(""+i)){
                return false;
            }
        }
        return true;
    }
}
