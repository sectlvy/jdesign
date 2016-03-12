package com.sect.datax.logreport.base;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtil {
    private static String floatGetRegex = "\\d+(\\.\\d+)?";

    public static String getFloat(String str) {
	Matcher keyWordMatcher = Pattern.compile(floatGetRegex).matcher(str);
	if (keyWordMatcher.find()) {
	    return keyWordMatcher.group(0);
	}
	return null;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static <R> List[] getPartByNum(List<R> rlist, int splitNum) {
	int nidUrlNum = rlist.size() / splitNum + 1;
	List<R>[] lists = new ArrayList[nidUrlNum];
	for (int i = 0; i < nidUrlNum; i++) {
	    lists[i] = new ArrayList<R>();
	    int start = i * splitNum;
	    int end = (i + 1) * splitNum;
	    for (int j = start; j < end && j < rlist.size(); j++) {
		lists[i].add(rlist.get(j));
	    }
	}
	return lists;
    }

}
