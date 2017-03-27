package cn.ctide.pet.Controller;

import cn.ctide.pet.Service.AlbumService;
import cn.ctide.pet.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Anker on 2017/3/27.
 */
@Controller
@RequestMapping("/album")
public class AlbumController {
    @Resource
    private AlbumService albumService;

    @RequestMapping("/getPetAlbum")
    @ResponseBody
    public Map getPetAlbum(Page p, Integer petId) {
        return albumService.getPetAlbum(p, petId);
    }
}
