package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@RestController
public class FileController {

    @RequestMapping("/upload")
    public String upload(@RequestParam("file")CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        //获取文件名
        String uploadFileName=file.getOriginalFilename();
        //如果文件名为空，直接回到首页
        if("".equals(uploadFileName)) return "redirect:/index.jsp";
        System.out.println("上传文件名："+uploadFileName);
        //上传路径保存设置
        String path=request.getServletContext().getRealPath("/upload");
        //如果路径不存在则创建一个
        File realpath=new File(path);
        if(!realpath.exists()){
            realpath.mkdir();
        }
        System.out.println("上传文件保存地址："+realpath);

        InputStream inputStream=file.getInputStream();
        OutputStream os=new FileOutputStream(new File(realpath,uploadFileName));

        //读取写出
        int len=0;
        byte []buffer=new byte[1024];
        while((len=inputStream.read(buffer))!=-1){
            os.write(buffer,0,len);
            os.flush();
        }
        os.close();
        inputStream.close();

        return "redirect:/index.jsp";
    }

    @RequestMapping("/upload2")
    public String fileUpload(@RequestParam("file")CommonsMultipartFile file,HttpServletRequest request) throws IOException {
        //上传路径保存设置
        String path=request.getServletContext().getRealPath("/upload");
        File realPath=new File(path);
        if(!realPath.exists()){
            realPath.mkdir();
        }
        //上传文件地址
        System.out.println("上传文件保存地址");
        //通过transferTo直接写文件
        file.transferTo(new File(realPath+"/"+file.getOriginalFilename()));
        return "redirect:/index.jsp";
    }

    @RequestMapping("/download")
    public void download(HttpServletResponse response, HttpServletRequest request) throws IOException {

        //上传路径保存设置
        String path=request.getServletContext().getRealPath("/upload");
        String fileName="1312.6229.pdf";
        //设置response响应头
        response.reset();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("multipart/form-data");
        //设置响应头
        response.setHeader("Content-Disposition","attachment;fileName="+ URLEncoder.encode(fileName,"UTF-8"));

        File file=new File(path,fileName);


        InputStream inputStream=new FileInputStream(file);
        OutputStream out=response.getOutputStream();

        //读取写出
        int index=0;
        byte []buffer=new byte[1024];
        while((index=inputStream.read(buffer))!=-1){
            out.write(buffer,0,index);
            out.flush();
        }
        out.close();
        inputStream.close();

//        return "redirect:/index.jsp";
    }
}
















