package com.csii.osgi.sht.listener;

import java.util.HashMap;
import java.util.Map;

import org.osgi.framework.BundleEvent;
import org.osgi.framework.SynchronousBundleListener;
/**
 * 定义自己的bundle监听器，方便以后观察用
 * @author SHT
 *
 */
public class MyBundleListener implements SynchronousBundleListener {

	public void bundleChanged(BundleEvent bundleEvnet) {
		String message = bundleEvnet.getBundle().getSymbolicName()+"_"+bundleEvnet.getBundle().getVersion();
		message+="\t状态："+stateMapping.get(bundleEvnet.getBundle().getState());
		message+="\t类型："+typeMapping.get(bundleEvnet.getType());
		System.err.println(message);
	}
	
	static Map stateMapping = new HashMap();
	static {
		stateMapping.put(1, "UNINSTALLED");
		stateMapping.put(2, "INSTALLED");
		stateMapping.put(4, "RESOLVED");
		stateMapping.put(8, "STARTING");
		stateMapping.put(16, "STOPPING");
		stateMapping.put(32, "ACTIVE");
	}
	
	static Map typeMapping = new HashMap();
	static {
		typeMapping.put(1,  "INSTALLED   (成功安装后发出)");
		typeMapping.put(2,  "STARTED     (成功启动后发出)");
		typeMapping.put(4,  "STOPPED     (成功停止后发出)");
		typeMapping.put(8,  "UPDATED     (成功更新后发出)");
		typeMapping.put(16, "UNINSTALLED (成功卸载后发出)");
		typeMapping.put(32, "RESOLVED    (成功解析后发出)");
		typeMapping.put(64, "UNRESOLVED  (处于为解析状态后发出)");
		typeMapping.put(128, "STARTING    (正在启动时发出)");
		typeMapping.put(256, "STOPPING    (正在停止时发出)");
		typeMapping.put(512, "LAZY_ACTIVATION   (处于懒激活状态时发出)");
	}

}
