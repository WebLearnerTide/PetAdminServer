package cn.ctide.pet.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ctide.pet.Dao.PetclassMapper;
import cn.ctide.pet.Model.Petclass;
import cn.ctide.pet.Service.PetclassService;

@Service("petclassService")
public class PetclassServiceImpl implements PetclassService {
	@Autowired
	private PetclassMapper petclassMapper;

	@Override
	public List<Petclass> getPetclassList(Petclass petclass) throws Exception{
		List<Petclass> list = null;
		try {
			list = petclassMapper.selectSelective(petclass);
			if (null==list || list.size()==0) {
				throw new Exception("种类不存在");
			}
		} catch (Exception e) {
			throw new Exception("查询种类失败" + e.getMessage());
		}
		return list;
	}

	@Override
	public List<Petclass> getBuilds() throws Exception {
		List<Petclass> list = null;
		try {
			list = petclassMapper.getPetBuild();
			if (null==list || list.size()==0) {
				throw new Exception("获取体型失败");
			}
		} catch (Exception e) {
			throw new Exception("查询种类失败" + e.getMessage());
		}
		return list;
	}

}
