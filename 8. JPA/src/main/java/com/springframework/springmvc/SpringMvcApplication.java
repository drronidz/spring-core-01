package com.springframework.springmvc;

import com.diogonunes.jcolor.Attribute;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.BOLD;

@SpringBootApplication
public class SpringMvcApplication {

    public static void main(String[] args) {
        Attribute backgroundColorOne = Attribute.BACK_COLOR(132, 147, 36);
        Attribute backgroundColorTwo = Attribute.BACK_COLOR(1, 41, 95);
        Attribute backgroundLight = Attribute.BACK_COLOR(255, 255, 255);
        Attribute backgroundDark = Attribute.BACK_COLOR(0, 0, 0);

        Attribute textColorLight = Attribute.TEXT_COLOR(255, 255, 255);
        Attribute textColorDark = Attribute.TEXT_COLOR(0, 0, 0);

        ApplicationContext context = SpringApplication.run(SpringMvcApplication.class, args);

//        System.out.println(colorize(" ################# Beans ################# ", BOLD(), textColorDark, backgroundLight));
//        System.out.println(colorize(String.valueOf(context.getBeanDefinitionCount()), BOLD(), textColorDark, backgroundColorOne));
//
//        for (String name: context.getBeanDefinitionNames()) {
//            System.out.println();
//            System.out.println(colorize(" " + name + " ", BOLD(), textColorLight, backgroundColorTwo));
//        }
    }

}
