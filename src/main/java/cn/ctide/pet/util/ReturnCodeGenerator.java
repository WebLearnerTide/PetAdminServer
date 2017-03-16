package cn.ctide.pet.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum ReturnCodeGenerator {
	INSTANCE {
		@Override
		protected void init() {
			if (null==list || list.size()==0) {
				String[] split = buf.toString().split("-");
				list = new ArrayList(Arrays.asList(split));
			}
		}
	};
	protected StringBuffer buf = new StringBuffer("0-1-2-3-4-5-6-7-8-9");
	protected List<String> list;
	
	abstract protected void init();
	
	public String getCode(int count) {
		init();
		Collections.shuffle(list, new Random(System.currentTimeMillis()));
		StringBuffer b = new StringBuffer();
		for (int i=0; i<count; i++) {
			b.append(list.get(i));
		}
		return b.toString();
	}
	
	public String getCode() {
		return getCode(6);
	}
}
