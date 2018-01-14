package com.websystique.springmvc.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("globalSession")
public class Global {
private static int count=1;

public static int getCount() {
	return count;
}

public static void setCount(int count) {
	Global.count = count;
}

public static int increaseCount (){
	
	return count++;
	
}

public static int decreaseCount(){
	return count--;
}



}
