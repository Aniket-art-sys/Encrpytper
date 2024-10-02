package com.javatrash.myapplication;

import java.util.ArrayList;

public class functions {
    public static ArrayList<Character> char_split(String sentence){
        return new ArrayList<Character>(){{
            for (char s: sentence.toCharArray()){
                add(s);
            }
        }};
    }
    public static ArrayList<Integer> chr_ord(ArrayList<Character> sentence){
        return new ArrayList<Integer>() {{
            for (char s:sentence){
                add((int) s);
            }
        }};
    }
    public static ArrayList<Character> fix_len(ArrayList<Character> sentence,ArrayList<Character> key){
            ArrayList<Character> key_1 = new ArrayList<Character>() {{
                for (int i =0; i< ((int)(sentence.size()/key.size()));i++){
                    addAll(key);
                }
            }};
            ArrayList<Character> key_2 = new ArrayList<Character>();
            int remchar = sentence.size()%key.size();
            key_2.addAll(key.subList(0,Math.min(remchar,key.size())));
            return new ArrayList<Character>(){{
                addAll(key_1);
                addAll(key_2);
            }};

    }
    public static ArrayList<Integer> ord_xor(ArrayList<Integer> sentence,ArrayList<Integer> key){
        return new ArrayList<Integer>() {{
            for (int s=0; s<= sentence.size()-1;s++){
                add(sentence.get(s)^key.get(s));
            }
        }};
    }
    public static ArrayList<Character> ord_chr(ArrayList<Integer> sentence){
        return new ArrayList<Character>() {{
           for (int i:sentence){
               add((char) i);
           }
        }};
    }
    public static ArrayList<Integer> rev_arrl_int(ArrayList<Integer> array){
            return new ArrayList<Integer>(){{
                for (int i =0; i<array.size();i++){
                    add(array.get(array.size()-i-1));
                }
            }};
            }
    public static String encrypt(String sentence,String key){
        ArrayList<Character> sen_chr = functions.char_split(sentence.strip());
        ArrayList<Character> key_chr_f = functions.char_split(key.strip());
        ArrayList<Character> key_chr = functions.fix_len(sen_chr,key_chr_f);
        ArrayList<Integer> sen_ord = functions.chr_ord(sen_chr);
        ArrayList<Integer> key_ord = functions.chr_ord(key_chr);
        ArrayList<Integer> xor_int_ = functions.ord_xor(sen_ord,key_ord);
        System.out.println(rev_arrl_int(key_ord));
        System.out.println(key_ord);
        ArrayList<Integer> xor_int = functions.ord_xor(xor_int_, rev_arrl_int(key_ord));
        ArrayList<Character> xor_chr = functions.ord_chr(xor_int);
        ArrayList<String> xor_str = new ArrayList<String>(){{
            for (char s:xor_chr){
                add(String.valueOf(s));
            }
        }};
        return String.join("",xor_str).strip();



    }

}

