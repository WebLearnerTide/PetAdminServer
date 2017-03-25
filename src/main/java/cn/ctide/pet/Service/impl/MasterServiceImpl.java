package cn.ctide.pet.Service.impl;

import java.util.List;

import cn.ctide.pet.container.OSS;
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
			Master master1 = list.get(0);
			master1.setmImg(OSS.INSTANCE.generateUrl(master1.getmImg(), OSS.INSTANCE.USER_STYLE));
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
			master.setmImg(OSS.INSTANCE.generateUrl(master.getmImg(), OSS.INSTANCE.USER_STYLE));
		} catch (Exception e) {
			throw new Exception("查询用户失败");
		}
		return master;
	}

	@Override
	public Master getByEmail(String email) throws Exception {
		Master master = null;
		try {
			master = new Master();
			master.setmEmail(email);
			List<Master> list = masterMapper.selectSelective(master);
			if (null==list || list.size()==0) {
				throw new Exception("用户不存在");
			}
			if (list.size()!=1) {
				throw new Exception("邮箱不唯一");
			}
			master = list.get(0);
			master.setmImg(OSS.INSTANCE.generateUrl(master.getmImg(), OSS.INSTANCE.USER_STYLE));
			return master;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Master updateSign(Integer mId) throws Exception {
		masterMapper.callSign(mId);
		return this.getByPrimaryKey(mId);
	}

	@Override
	public Master updateMaster(Master master) throws Exception {
		try {
			int count = masterMapper.updateByPrimaryKeySelective(master);
			if (count < 1) {
				throw new Exception("更新失败");
			}
		} catch (Exception e) {
			throw e;
		}

		master = getByPrimaryKey(master.getmId());
		return master;
	}


}
