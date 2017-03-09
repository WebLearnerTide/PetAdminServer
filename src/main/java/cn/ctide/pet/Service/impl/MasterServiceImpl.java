package cn.ctide.pet.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ctide.pet.Dao.MasterMapper;
import cn.ctide.pet.Model.Master;
import cn.ctide.pet.Service.MasterService;

@Service("masterService")
public class MasterServiceImpl implements MasterService {
	@Autowired
	private MasterMapper masterMapper;

	public Master getMaster() {
		return masterMapper.selectByPrimaryKey(1);
	}

	@Override
	public Master getMasterByMaster(Master master) throws Exception {
		List<Master> list = masterMapper.selectSelective(master);
		if (null==list || list.size()==0) {
			throw new Exception("登录异常");
		} else if(list.size()>1) {
			throw new Exception("还是异常");
		} else {
			return list.get(0);
		}
	}

	@Override
	public int addMaster(Master master) throws Exception {
		// TODO Auto-generated method stub
		
			int result = masterMapper.insertSelective(master);
			if (result==1) {
				return result;
			}else{
				throw new Exception("注册失败");
			}
		
	}

	@Override
	public Master getByPrimaryKey(Integer mId) throws Exception {
		Master master = null;
		try {
			master = masterMapper.selectByPrimaryKey(mId);
			if (null==master) {
				throw new Exception("用户不存在");
			}
		} catch (Exception e) {
			throw new Exception("查询用户失败");
		}
		return master;
	}
	
	

}
