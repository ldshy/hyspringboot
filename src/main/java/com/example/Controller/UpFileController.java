package com.example.Controller;

import com.example.Mapper.UserMapper;
import com.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;

@RequestMapping("/up")
@Controller
public class UpFileController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/upfile")
    public String upfile(ModelMap map){
       return "page/index";
    }

    @RequestMapping(value="/scwj", method= RequestMethod.POST )
    public String scwj(@RequestParam("file") MultipartFile file, HttpServletRequest request){
        String filetype = file.getContentType();
        System.out.print(filetype);
        String filename = file.getOriginalFilename();
        String uppath = request.getSession().getServletContext().getRealPath("upload/");
        try {
            uploadFile(file.getBytes(), uppath, filename);
            return "login/login";
        } catch (Exception e) {
            // TODO: handle exception
        }
        return "login/login";
    }
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }
}
