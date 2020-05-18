package com.ithinksky.java.n07generic.base001;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author tengpeng.gao
 */
public class Base001Test {

	/**
	 *
	 * @param name
	 * @param searchResultConvert
	 * @param targetType
	 * @param <T>
	 * @return
	 */
	public static <T> T queryForList(String name, SearchResultConvert searchResultConvert, Class<T> targetType) {
		Object convertResult = searchResultConvert.convert(name);
		return targetType.cast(convertResult);
	}

	public static void main(String[] args) {
		SingleSearchResultConvert searchResultConvert = new SingleSearchResultConvert();
		String test = Base001Test.queryForList("名称啊", searchResultConvert, String.class);
		System.out.println(" test 单个值转换器----- " + test);

		ListSearchResultConvert listSearchResultConvert = new ListSearchResultConvert();
		List<String> list = Base001Test.queryForList("张三,李四,王五", listSearchResultConvert, List.class);
		System.out.println(" test 列表值转换器----- " + list);

	}
}

class ListSearchResultConvert implements SearchResultConvert<List<String>> {
	@Override
	public List<String> convert(String name) {

		if (name == null || "".equals(name)) {
			return Collections.EMPTY_LIST;
		}
		String[] names = name.split(",");
		if (names == null || names.length <= 0) {
			return Collections.EMPTY_LIST;
		}

		int size = names.length;
		ArrayList<String> result = new ArrayList(size);
		for (int i = 0; i < size; i++) {
			result.add("列表值转换器" + names[i]);
		}
		return result;
	}
}

class SingleSearchResultConvert implements SearchResultConvert<String> {
	@Override
	public String convert(String name) {
		return "单个值转换器" + name;
	}
}

interface SearchResultConvert<T> {

	T convert(String name);

}