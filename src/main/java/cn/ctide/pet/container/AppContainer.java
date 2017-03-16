package cn.ctide.pet.container;

import java.util.HashMap;
import java.util.Map;

import cn.ctide.pet.Model.Master;

/**
 * 应用容器，用于承载登录用户以及用户返回码
 * @author 
 *
 */
public enum AppContainer {
	INSTANCE {
		@Override
		protected void initContainer() {
			if(null==_MASTERS) {
				_MASTERS = new HashMap();
			}
			if (null==_RETURN_CODE) {
				_RETURN_CODE = new HashMap();
			}
		}
	};
	private static Map _MASTERS;
	private static Map _RETURN_CODE;
	
	abstract protected void initContainer();
	
	public void addMaster(Master master) {
		initContainer();
		_MASTERS.put(master.getmName(), master);
	}
	
	public void removeMaster(String username) {
		initContainer();
		_MASTERS.remove(username);
	}
	
	public void addReturnCode(String email, String code) {
		initContainer();
		_RETURN_CODE.put(email, code);
	}
	
	public void removeReturnCode(String email) {
		initContainer();
		_RETURN_CODE.remove(email);
	}
}
