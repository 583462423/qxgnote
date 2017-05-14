package com.notepad.controller;

import com.notepad.model.ResponseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.util.stream.Stream;

/**
 * Created by qxg on 17-5-14.
 */
@Controller
public class UpdateController {

    @PostMapping("update")
    @ResponseBody
    public ResponseResult update(@RequestParam("text") String text){
        File file = new File("index.txt");
        try {
            if (!file.exists()) {
                //创建file
                file.createNewFile();
            }else{
                file.delete();
                file.createNewFile();
            }
            //向file中写内容
            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"))) {
                bw.write(text);
                bw.flush();
            }
        } catch (Exception e) {
            return new ResponseResult(false,"未知错误");
        }
        return new ResponseResult(true,"更新成功");
    }

}
