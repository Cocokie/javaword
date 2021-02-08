package com.lix.hutool;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Console;

import java.io.File;
import java.io.IOException;

public class Customize {
    public static void main(String[] args) throws IOException {
        Class<Customize> customizeClass = Customize.class;
        ClassLoader classLoader = customizeClass.getClassLoader();
        System.out.println(classLoader);
        File file = new File("");
        System.out.println(file.getAbsolutePath());
        System.out.println(customizeClass.getResource("Customize.class"));
        System.out.println(customizeClass.getResource("/com/lix/hutool"));
        System.out.println(classLoader.getResource("com/lix/hutool/Customize.class"));
        System.out.println(classLoader.getResource("/com"));

    }
}
