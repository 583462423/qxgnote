package com.notepad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;

/**
 * Created by qxg on 17-5-14.
 */
@Controller
public class IndexController {

    @GetMapping("/index")
    public ModelAndView index(){
        //从文件中取数据
        ModelAndView mv = new ModelAndView("index");
        File file = new File("index.txt");
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        try {
            if (!file.exists()) {
                //创建file
                file.createNewFile();
            }
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
            String line = null;
            while((line = br.readLine()) != null){
                sb.append(line).append("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mv.addObject("text",sb.toString());
        return mv;
    }
}
