package com.ithinksky.java.n07generic.base001;

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
		SingleSearchResultConvert convert = new SingleSearchResultConvert();
		String test = Base001Test.queryForList("名称啊", convert, String.class);
		System.out.println(" test ----- " + test);
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