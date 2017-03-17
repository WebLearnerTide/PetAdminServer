package cn.ctide.pet.Service;

import cn.ctide.pet.Model.Master;

public interface MasterService {
	Master getMaster();

	Master getMasterByMaster(Master master) throws Exception;
	
	int addMaster(Master master) throws Exception;

	Master getByPrimaryKey(Integer mId) throws Exception;

	Master getByEmail(String email) throws Exception;

	Master updateSign(Integer mId);
} 
