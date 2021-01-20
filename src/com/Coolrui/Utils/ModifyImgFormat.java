package com.Coolrui.Utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;



/**
 * @Author MaRuiYa
 * @Date 2021/1/8 9:51
 */
public class ModifyImgFormat {
    public static String[] modify(String imgs){
        if (imgs.length() > 1){
            String substring = imgs.substring(1, imgs.length() - 1);
            List<String> collect = Arrays.asList(substring.split(",")).stream().map(s -> s.substring(1, s.length() - 1)).collect(Collectors.toList());
            return collect.toArray(new String[collect.size()]);
        }else {
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(modify("[")));
    }
}
