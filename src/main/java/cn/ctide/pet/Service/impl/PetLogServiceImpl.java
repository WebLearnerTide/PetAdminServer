package cn.ctide.pet.Service.impl;

import cn.ctide.pet.Dao.PetLogMapper;
import cn.ctide.pet.Model.PetLog;
import cn.ctide.pet.Service.PetLogService;
import cn.ctide.pet.container.OSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Anker on 2017/3/26.
 */
@Service("petLogService")
public class PetLogServiceImpl implements PetLogService {
    @Autowired
    private PetLogMapper petLogMapper;

    @Override
    public List<PetLog> getLogsByPet(Integer pId) throws Exception {
        List<PetLog> list = petLogMapper.getLogsByPet(pId);
        if (null==list||list.size()==0) {
            throw new Exception("查询失败");
        }
        ArrayList<PetLog> target = new ArrayList<>();
        for (PetLog log : list) {
            String logImg = log.getPlogImg();
            if (null!=logImg && !"".equals(logImg)) {
                log.setPlogImg(OSS.INSTANCE.generateUrl(logImg, ""));
            }
            target.add(log);
        }
        list = null;
        return target;
    }

    @Override
    public void addPetLog(PetLog log) throws Exception {
        int count = petLogMapper.insertSelective(log);
        if (count!=1) {
            throw new Exception("添加失败");
        }
    }
}
