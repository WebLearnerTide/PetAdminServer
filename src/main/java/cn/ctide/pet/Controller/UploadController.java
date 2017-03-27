package cn.ctide.pet.Controller;

import cn.ctide.pet.Model.Ad;
import cn.ctide.pet.Model.Album;
import cn.ctide.pet.Model.Master;
import cn.ctide.pet.Model.PostResources;
import cn.ctide.pet.Service.AdService;
import cn.ctide.pet.Service.AlbumService;
import cn.ctide.pet.Service.MasterService;
import cn.ctide.pet.Service.PostResourcesService;
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
    @Resource
    private PostResourcesService postResourcesService;
    @Resource
    private AdService adService;
    @Resource
    private AlbumService albumService;

    @RequestMapping("/masterImg")
    @ResponseBody
    public Map masterImg(@RequestParam(value = "file", required = false) MultipartFile file, Master master) throws Exception {
        Map result = new HashMap();
        String path = "/pet/tmp";
        String fileName = master.getmName() + ".jpeg";
        System.out.println(path);
        File targetFile = new File(path, fileName);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }

        //保存
        file.transferTo(targetFile);
        OSS.INSTANCE.upload("user/", targetFile);
        targetFile.delete();
        master.setmImg("user/" + fileName);
        masterService.updateMaster(master);
        result.put("success", true);
//        result.put("master", master);
        return result;
    }

    @RequestMapping("/postImg")
    @ResponseBody
    public Map postImg(@RequestParam(value = "file", required = false) MultipartFile file, PostResources postResources) throws Exception {
        Map result = new HashMap();
        String path = "/pet/tmp";
        String fileName = System.currentTimeMillis() + ".jpeg";
        System.out.println(path);
        File targetFile = new File(path, fileName);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }

        //保存
        file.transferTo(targetFile);
        OSS.INSTANCE.upload("postimg/", targetFile);
        targetFile.delete();
        postResources.setResImg("postimg/" + fileName);
        postResourcesService.addPostResources(postResources);
        result.put("success", true);
//        result.put("master", master);
        return result;
    }

    @RequestMapping("/addAd")
    @ResponseBody
    public Map addAd(@RequestParam(value = "file", required = false) MultipartFile file, Ad ad, Integer mId) throws Exception {
        Map result = new HashMap();
        String path = "/pet/tmp";
        String fileName = System.currentTimeMillis() + ".jpeg";
        System.out.println(path);
        File targetFile = new File(path, fileName);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }

        //保存
        file.transferTo(targetFile);
        OSS.INSTANCE.upload("ad/", targetFile);
        targetFile.delete();
        ad.setAdImg("ad/" + fileName);
        Master master = masterService.getByPrimaryKey(mId);
        if (null==master) {
            throw new Exception("用户不存在");
        }
        master.setmScore(master.getmScore()-ad.getScore());
        masterService.updateMaster(master);
        adService.addAd(ad);
        result.put("success", true);
        return result;
    }

    @RequestMapping("/addAlbum")
    @ResponseBody
    public Map addAlbum(@RequestParam(value = "file", required = false) MultipartFile file, Album album) throws Exception {
        Map result = new HashMap();
        String path = "/pet/tmp";
        String fileName = System.currentTimeMillis() + ".jpeg";
        System.out.println(path);
        File targetFile = new File(path, fileName);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }

        //保存
        file.transferTo(targetFile);
        OSS.INSTANCE.upload("album/", targetFile);
        targetFile.delete();
        album.setPhotoUrl("album/" + fileName);
        albumService.addAlbum(album);
        result.put("success", true);
        return result;
    }
}
