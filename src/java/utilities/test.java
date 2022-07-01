/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.util.Arrays;

/**
 *
 * @author lekha
 */
public class test {
    public static void main(String[] args){
        System.out.println(StringUtil.generateSlug("tôi tên             là LÊ %^&#*&!(*#@NGU@*&^^@&*(*!&*^@$(YÊN                        KH&#^!ANG đ&#^$^#*@ó"));
        System.out.println(StringUtil.removeAccent("Đ đ"));
    }
}
