package com.fzw.daddb.parse;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import org.apache.commons.io.IOUtils;
import org.apache.commons.text.StringEscapeUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        File file = new File("demodata/card/1700933295293_body");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            List<String> strings = IOUtils.readLines(br);
            String jsonString = strings.get(0);
            JSONObject parse = JSONObject.parse(jsonString);
            JSONArray card = parse.getJSONArray("card");
            for (Object o : card) {
                if (o instanceof JSONArray){
                    JSONArray a = (JSONArray)o;
                    for (Object o1 : a) {
                        System.out.println(o1);
                    }
                }
            }
//            System.out.println(card.size());
//            for (int i = 0; i < card.size(); i++) {
//                Object o = card.get(i);
//                if (o instanceof String){
//                    String s = StringEscapeUtils.unescapeJava(o.toString());
//                    System.out.println(s);
//                }
//            }
            System.out.println(parse);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
