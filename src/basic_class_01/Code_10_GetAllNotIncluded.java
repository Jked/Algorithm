package basic_class_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 
 * @author Jiankang
 *	给定两个数组 A 、 B ，得到 B中有，A中没有 的所有元素。
 */
public class Code_10_GetAllNotIncluded {

	//主方法方法（感觉像是二分查找）
	public static List<Integer> GetAllNotIncluded(int[] A, int[] B) {
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < B.length; i++) {
			int l = 0;
			int r = A.length - 1;
			boolean contains = false;
			while (l <= r) {
				int mid = l + ((r - l) >> 1);
				if (A[mid] == B[i]) {
					contains = true;
					break;
				}
				if (A[mid] > B[i]) {
					r = mid - 1;
				} else {
					l = mid + 1;
				}
			}
			if (!contains) {
				res.add(B[i]);
			}
		}
		return res;
	}

	
	//写一个绝对对的方法，但时间复杂度高的方法，即：遍历两个数组； 应用在 对数器 中
	public static List<Integer> comparator(int[] A, int[] B) {
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < B.length; i++) {
			boolean contains = false;
			for (int j = 0; j < A.length; j++) {
				if (A[j] == B[i]) {
					contains = true;
					break;
				}
			}
			if (!contains) {
				res.add(B[i]);
			}
		}
		return res;
	}

	//用于生成随机数组，应用于 对数器
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	//判断用 自己写的主方法   和   绝对对的笨方法  得到的结果是否一致
	public static boolean isEqual(List<Integer> l1, List<Integer> l2) {
		if (l1.size() != l2.size()) {
			return false;
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		for (Integer i : l1) {
			if (!map.containsKey(i)) {
				map.put(i, 0);
			}
			map.put(i, map.get(i) + 1);
		}
		for (Integer i : l2) {
			if (!map.containsKey(i)) {
				return false;
			}
			map.put(i, map.get(i) - 1);
			if (map.get(i) < 0) {
				return false;
			}
		}
		return true;
	}

	//main函数
	public static void main(String[] args) {
		int testTime = 300000;
		int sortedArrayMaxSize = 300;
		int unsortedArrayMaxSize = 10;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] A = generateRandomArray(sortedArrayMaxSize, maxValue);
			int[] B = generateRandomArray(unsortedArrayMaxSize, maxValue);
			Arrays.sort(A);
			List<Integer> res1 = GetAllNotIncluded(A, B);
			List<Integer> res2 = comparator(A, B);
			if (!isEqual(res1, res2)) {
				succeed = false;
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");

	}

}
