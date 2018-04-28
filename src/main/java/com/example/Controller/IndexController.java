package com.example.Controller;

import com.example.Mapper.UserMapper;
import com.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.util.List;
import java.util.Map;

@RequestMapping("/index")
@Controller
public class IndexController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/index")
    public String index(ModelMap map){
       List<Map<String ,Object>> list = userMapper.findName("黄宇");
        for (Map<String ,Object> ob:list ) {
            System.out.print(ob.get("username"));
       }
        map.addAttribute("name","huangyu");
        map.addAttribute("list",list);
        userService.createJdbcUser();
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login/login";
    }


    @RequestMapping("/getimg")
    @ResponseBody
    public void getimg(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Map<String ,Object>> list = userMapper.addimg("5");
        System.out.print(list.get(0).get("img"));
        byte[] imgblob = (byte[]) list.get(0).get("img");
        OutputStream os = response.getOutputStream();

        //InputStream is = null;
        byte[] b = new byte[1024];
        os.write(imgblob);
       // is = imgblob.getBinaryStream();
       // int i = 0;
       // while ((i = is.read(b)) != -1) {
       //     os.write(b, 0, i);
       //  }
        os.close();
       // is.close();

    }

    /**
     * 将blob转化为byte[],可以转化二进制流的
     *
     * @param blob
     * @return
     */
    private byte[] blobToBytes(Blob blob) {
        InputStream is = null;
        byte[] b = null;
        try {
            is = blob.getBinaryStream();
            b = new byte[(int) blob.length()];
            is.read(b);
            return b;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                is = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return b;
    }
}
