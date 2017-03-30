package cn.ctide.pet.Service.impl;

import java.util.List;

import cn.ctide.pet.Model.PetClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ctide.pet.Dao.PetClassMapper;
import cn.ctide.pet.Service.PetClassService;

@Service("petclassService")
public class PetClassServiceImpl implements PetClassService {
	@Autowired
	private PetClassMapper petClassMapper;

	@Override
	public List<PetClass> getPetClassList(PetClass petClass) throws Exception{
		List<PetClass> list = null;
		try {
			list = petClassMapper.selectSelective(petClass);
			if (null==list || list.size()==0) {
				throw new Exception("种类不存在");
			}
		} catch (Exception e) {
			throw new Exception("查询种类失败" + e.getMessage());
		}
		return list;
	}

	@Override
	public List<PetClass> getBuilds() throws Exception {
		List<PetClass> list = null;
		try {
			list = petClassMapper.getPetBuild();
			if (null==list || list.size()==0) {
				throw new Exception("获取体型失败");
			}
		} catch (Exception e) {
			throw new Exception("查询种类失败" + e.getMessage());
		}
		return list;
	}

	@Override
	public List<PetClass> getMasterClass(Integer mId) {
		return petClassMapper.getPetClass(mId);
	}

}
