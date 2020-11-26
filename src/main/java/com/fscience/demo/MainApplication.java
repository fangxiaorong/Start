package com.fscience.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fscience.demo.backend.loader.ExtendClassLoader;
import com.fscience.demo.controllers.IndexController;
import jdk.jshell.JShell;
import jdk.jshell.SnippetEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.util.List;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);

//        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
//        compiler.run()
//        System.out.println(JSON.parse("{}"));
//        JShell shell = JShell.create();
//        List<SnippetEvent> data = shell.eval("import com.alibaba.fastjson.JSON;");
//        for (SnippetEvent datum : data) {
//            System.out.println("Value: " + datum.status());
//            System.out.println(datum.toString());
//        }
//        shell.addToClasspath("/home/fscience/IdeaProjects/movehouse/demo/target/fastjson-1.2.70.jar");
//        data = shell.eval("import com.alibaba.fastjson.JSON;");
//        for (SnippetEvent datum : data) {
//            System.out.println("Value: " + datum.status());
//            System.out.println(datum.toString());
//        }
//        data = shell.eval("JSON.parse(\"{}\");");
//        for (SnippetEvent datum : data) {
//            System.out.println("Value: " + datum.status());
//            System.out.println(datum.toString());
//        }
//        shell.close();
    }
}
