package com.Jongyeol.Library.CheckSet;

public class Number {
    private static String makeNumber(String string){
        String[] strings = string.split("");
        String st = "";
        if(strings[0].equals("-")){
            st = st + "-";
        }
        for(int i1=0; i1<strings.length; i1++){
            for(int i2=0; i2<10; i2++){
                if(strings[i1].equals(i2 + "")){
                    st = st + i2;
                }
            }
            if(strings[i1].equals(".")){
                st = st + ".";
            }
        }
        st = st + ".0";
        String[] sts = st.split("\\.");
        if(sts.length == 0) {
            return st;
        } else {
            return sts[0] + "." + sts[1];
        }
    }
    private static boolean dotup(String string) {
        String[] st = string.split("");
        if(Integer.parseInt(st[0]) >= 5){
            return true;
        }
        return false;
    }
    public static byte makebyte(String string) {
        String[] st = makeNumber(string).split("\\.");
        if(st.length == 1){
            return Byte.parseByte(st[0]);
        }
        if(dotup(st[1])){
            return (byte) (Byte.parseByte(st[0]) + 1);
        } else {
            return Byte.parseByte(st[0]);
        }
    }
    public static short makeshort(String string) {
        String[] st = makeNumber(string).split("\\.");
        if(st.length == 1){
            return Short.parseShort(st[0]);
        }
        if(dotup(st[1])){
            return (short) (Short.parseShort(st[0]) + 1);
        } else {
            return Short.parseShort(st[0]);
        }
    }
    public static int makeinteger(String string) {
        String[] st = makeNumber(string).split("\\.");
        if(st.length == 1){
            return Integer.parseInt(st[0]);
        }
        if(dotup(st[1])){
            return Integer.parseInt(st[0]) + 1;
        } else {
            return Integer.parseInt(st[0]);
        }
    }
    public static long makeLong(String string) {
        String[] st = makeNumber(string).split("\\.");
        if(st.length == 1){
            return Long.parseLong(st[0]);
        }
        if(dotup(st[1])){
            return Long.parseLong(st[0]) + 1;
        } else {
            return Long.parseLong(st[0]);
        }
    }
    public static float makefloat(String string) {
        return Float.parseFloat(makeNumber(string));
    }
    public static double makedouble(String string) {
        return Double.parseDouble(makeNumber(string));
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
