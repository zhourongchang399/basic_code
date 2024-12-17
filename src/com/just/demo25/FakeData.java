package com.just.demo25;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FakeData {
    public static void main(String[] args) throws IOException {
        String surname = "https://baike.baidu.com/item/%E7%99%BE%E5%AE%B6%E5%A7%93/194637?fr=ge_ala";
        String boyName = "http://www.haoming8.cn/baobao/10881.html";
        String girlName = "http://www.haoming8.cn/baobao/7641.html";

        URL surnameUrl = new URL(surname);
        URL boyNameUrl = new URL(boyName);
        URL girlNameUrl = new URL(girlName);

        ArrayList<String> surnameArrayList = getStrFromUrl(surnameUrl, "\"\">(.)</a>", 1);
        ArrayList<String> boyNameArrayList = getStrFromUrl(boyNameUrl, "(、|>)(..)(、|。)", 2);
        ArrayList<String> girlNameArrayList = getStrFromUrl(girlNameUrl, "<p>((.. ){4}..)</p>", 1);

        ArrayList<String> tempArrayList = new ArrayList<>();
        for (String s : girlNameArrayList) {
            String[] split = s.split(" ");
            for (String s1 : split) {
                tempArrayList.add(s1);
            }
        }
        girlNameArrayList = tempArrayList;

        ArrayList<String> person = getInfo(surnameArrayList, boyNameArrayList, girlNameArrayList, 5, 5);

        File saveFile = new File("C:\\Users\\49744\\Documents\\basic_code\\src\\com\\just\\demo25\\person.txt");

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(saveFile));
        for (String s : person) {
            bufferedWriter.write(s);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

    }

    private static ArrayList<String> getInfo(ArrayList<String> surnames, ArrayList<String> boys, ArrayList<String> girls, int boyCount, int girlCount) {

        Random random = new Random();
        ArrayList<String> results = new ArrayList<>();

        for (int i = 0; i < boyCount; i++) {
            Collections.shuffle(surnames);
            Collections.shuffle(boys);
            results.add(surnames.get(0) + boys.get(0) + "-" + random.nextInt(101) + "-" + "男");
        }

        for (int i = 0; i < boyCount; i++) {
            Collections.shuffle(surnames);
            Collections.shuffle(girls);
            results.add(surnames.get(0) + girls.get(0) + "-" + random.nextInt(101) + "-" + "女");
        }

        Collections.shuffle(results);

        return results;

    }

    public static ArrayList<String> getStrFromUrl(URL url, String regex, int index) throws IOException {
        URLConnection connection = url.openConnection();
        InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());

        StringBuilder stringBuilder = new StringBuilder();
        int c;
        while ((c = inputStreamReader.read()) != -1) {
            stringBuilder.append((char) c);
        }
        String s = stringBuilder.toString();

        ArrayList<String> resultList = new ArrayList<>();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            resultList.add(matcher.group(index));
        }

        return resultList;
    }



}
