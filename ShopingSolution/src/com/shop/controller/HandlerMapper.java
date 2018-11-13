package com.shop.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import com.shop.action.Action;

public class HandlerMapper {
	private static HandlerMapper instance = new HandlerMapper();

	protected HandlerMapper() {
	}

	public static HandlerMapper getInstance() {
		return instance;
	}

	private static Map<String, Action> commandMap = new HashMap<String, Action>();

	public Map<String, Action> getMap() {
		return commandMap;
	}

	static {
		String path = "com/shop/properties/command";
		ResourceBundle rbHome = ResourceBundle.getBundle(path);

		Set<String> actionSetHome = rbHome.keySet();

		Iterator<String> it = actionSetHome.iterator();

		while (it.hasNext()) {
			String command = it.next();
			String className = rbHome.getString(command);

			try {
				Class actionClass = Class.forName(className);
				Action commandAction = (Action) actionClass.newInstance();
				commandMap.put(command, commandAction);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
}
