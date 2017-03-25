package cn.ctide.pet.Controller;

import cn.ctide.pet.Model.Master;
import cn.ctide.pet.Service.MasterService;
import cn.ctide.pet.container.OSS;
import com.aliyun.oss.model.PutObjectResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anker on 2017/3/24.
 */
@Controller
@RequestMapping("/upload")
public class UploadController {
    @Resource
    private MasterService masterService;

    @RequestMapping("/masterImg")
    @ResponseBody
    public Map masterImg(@RequestParam(value = "file", required = false) MultipartFile file, Master master) {
//        file.getBytes()
        Map result = new HashMap();
        System.out.println("开始");
        String path = "/pet/tmp";
        String fileName = master.getmName() + ".jpeg";
//        String fileName = new Date().getTime()+".jpg";
        System.out.println(path);
        File targetFile = new File(path, fileName);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }

        //保存
        try {
            file.transferTo(targetFile);
            OSS.INSTANCE.upload("user/", targetFile);
            targetFile.delete();
            master.setmImg("user/" + fileName);
            master = masterService.updateMaster(master);
            result.put("success", true);
            result.put("master", master);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", false);
            result.put("msg", e.getMessage());
        }
        return result;
    }
}
