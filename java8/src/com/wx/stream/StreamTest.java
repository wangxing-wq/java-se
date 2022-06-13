package com.wx.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @version 1.0
 * @author 王兴
 * @date 2022/5/27 14:55
 */
public class StreamTest {

	ArrayList<Integer> list;
	@Before
	public void init(){
		list = new ArrayList<>();
		list.add(1);
		list.add(3);
		list.add(5);
		list.add(5);
		list.add(8);
		list.add(10);
	}

	@Test
	public void streamCreateTest(){
		// 1. 通过Arrays.stream 方式创建流
		IntStream intStream = Arrays.stream(new int[]{1, 3, 5, 6, 8});
		System.out.println(intStream.max().orElse(1));
		// 2. 通过Stream.of 这种值的方式创建
		Stream<int[]> stream = Stream.of(new int[]{1, 3, 5, 6, 8},new int[]{1, 3, 5, 6, 8,9});
		Optional<int[]> max = stream.max(Comparator.comparingInt(a -> a.length));
		System.out.println(Arrays.toString(max.orElseGet(null)));
	}

	@Test
	public void screeningAndSectioningTest(){
		// filter | 过滤响应条件 | 使用Predicate函数接口做为自定义判断条件
		Stream<Integer> filterStream = list.stream().filter(integer -> integer > 3);
		// distinct | 去除重复元素 | 根据equals 和 hashCode 判断是否像相同
		Stream<Integer> distinct = filterStream.distinct();
		// limit | 限制数量 | 根据传入参数,从第一个开始截断数量
		Stream<Integer> limit = distinct.limit(3);
		// skip | 跳过数量 | 与limit 相似,limit截断,skip跳过
		Stream<Integer> skip = limit.skip(2);
		System.out.println(Arrays.toString(skip.toArray()));
	}

	@Test
	public void mapStreamTest(){
		// map 将流转换成其他流
		Stream<ArrayList<Integer>> arrayListStream = list.stream().map(item -> {
			ArrayList<Integer> temp = new ArrayList();
			temp.add(item);
			temp.add(new Random().nextInt(1000));
			return temp;
		});
		// flatMap 将流中每个值都换成流,然后合并成新的流
		Stream<Object> objectStream = arrayListStream.flatMap(new Function<ArrayList<Integer>, Stream<?>>() {
			@Override
			public Stream<?> apply(ArrayList<Integer> integers) {
				return integers.stream();
			}
		});
		System.out.println(objectStream.collect(Collectors.toList()));
	}

	@Test
	public void sortStreamTest(){
		// sort 会将流进行排序并产生新的流
		Stream<Integer> sorted = list.stream().sorted();
		System.out.println(sorted.collect(Collectors.toList()));
	}

	@Test
	public void findAndMatchStreamTest(){
		Stream<Integer> stream = list.stream();
		// allMatch | 流中的值都符合条件
		//boolean b = stream.allMatch(integer -> integer == 1);
		// 流中至少要有一个满足条件
		//boolean b1 = stream.anyMatch(integer -> integer > 16);
		boolean b1 = stream.anyMatch(integer -> integer > 16);
		System.out.println(b1);
	}

}
