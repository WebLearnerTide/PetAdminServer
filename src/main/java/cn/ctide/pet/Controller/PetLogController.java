package cn.ctide.pet.Controller;

import cn.ctide.pet.Model.PetLog;
import cn.ctide.pet.Service.PetLogService;
import cn.ctide.pet.container.OSS;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Anker on 2017/3/26.
 */
@Controller
@RequestMapping("/petLog")
public class PetLogController {
    @Resource
    private PetLogService petLogService;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

    @RequestMapping("/getLogsByPet/{pId}")
    @ResponseBody
    public Map getLogs(@PathVariable  Integer pId) {
        Map result = new HashMap();
        try {
            List<PetLog> list = petLogService.getLogsByPet(pId);
            result.put("success", true);
            result.put("logs", list);
        } catch (Exception e) {
//            e.printStackTrace();
            result.put("success", false);
            result.put("msg", e.getMessage());
        }
        return result;
    }

    @RequestMapping("/add")
    @ResponseBody
    public Map addPetLog(@RequestParam(value = "file", required = false) MultipartFile file, PetLog log) throws Exception {
        Map result = new HashMap();
        Date now = new Date();
        log.setPlogTime(now);
        Integer petId = log.getPetId();
        log.setPlogCode(petId + "_" + sdf.format(now));
        if (null!=file && !file.isEmpty()) {
            String path = "/pet/tmp";
            String fileName = petId + "_" + sdf.format(now) + ".jpeg";
            System.out.println(path);
            File targetFile = new File(path, fileName);
            if(!targetFile.exists()){
                targetFile.mkdirs();
            }
            file.transferTo(targetFile);
            OSS.INSTANCE.upload("petlog/", targetFile);
            targetFile.delete();
            log.setPlogImg("petlog/" + fileName);
            petLogService.addPetLog(log);
            result.put("success", true);
        } else {
            petLogService.addPetLog(log);
            result.put("success", true);
        }
        return result;
    }
}
