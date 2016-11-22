package com.yk.example.algorithm;

/**
 * 基本排序算法
 * 
 * @author yukui
 *
 */
public class OrderExample {

	/**
	 * 每步将一个待排序的记录， 按其顺序码大小插入到前面已经排序的字序列的合适位置（从后向前找到合适位置后），
	 * 直到全部插入排序完为止。
	 * 稳定
	 * @param m
	 */
	public static void 直接插入排序(int[] m) {
		// 直接插入排序
		for (int i = 0; i < m.length; i++) {
			int temp = m[i]; // 待插入元素
			int j;
			for (j = i - 1; j >= 0; j--) {
				// 将大于temp的往后移动一位
				if (m[j] > temp) {
					m[j + 1] = m[j];
				} else {
					break;
				}
			}
			m[j + 1] = temp;
		}
		afterOrderPrint(m);
	}

	

	/**
	 * 要排序的一组数中，选出最小的一个数与第一个位置的数交换； 然后在剩下的数当中再找最小的与第二个位置的数交换，
	 * 如此循环到倒数第二个数和最后一个数比较为止。 不穩定
	 * 
	 * @param m
	 */
	public static void 简单的选择排序(int[] m) {
		for (int i = 0; i < m.length; i++) {
			int min = m[i];
			int n = i; // 最小值的索引数
			for (int j = (i + 1); j < m.length; j++) {
				if (m[j] < min) {// 找出最小的数
					min = m[j];
					n = j;
				}
			}
			m[n] = m[i];
			m[i] = min;
		}

		afterOrderPrint(m);
	}

	/**
	 * 比较相邻的元素。如果第一个比第二个大，就交换他们两个
	 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数
	 * 针对所有的元素重复以上的步骤，除了最后一个
	 * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较 
	 * 稳定
	 * @param m
	 */
	public static void 冒泡排序(int[] m) {
		int temp;// 记录临时中间值
		for (int i = 0; i < (m.length - 1); i++) {
			for (int j = i + 1; j < m.length; j++) {
                if(m[i] > m[j]){//交换2数组的位置
                	temp = m[i];
                	m[i] = m[j];
                	m[j] = temp;
                }
			}
		}
		
		afterOrderPrint(m);
	}

	/**
	 * 选择一个基准元素,通常选择第一个元素或者最后一个元素,通过一趟扫描，将待排序列分成两部分,
	 * 一部分比基准元素小,一部分大于等于基准元素,此时基准元素在其排好序后的正确位置,
	 * 然后再用同样的方法递归地排序划分的两部分。
	 * 不稳定
	 * @param m
	 */
	public static void 快速排序(int[] m){
	}
	
	/**
	 * 排序前打印数组
	 * 
	 * @param m
	 */
	public static void beforeOrderPrint(int[] m) {
		System.out.println("插入排序之前");
		for (int i = 0; i < m.length; i++) {
			System.out.print(m[i] + " ");
		}
		System.out.println("\n");
	}

	/**
	 * 排序后打印数组
	 * 
	 * @param m
	 */
	private static void afterOrderPrint(int[] m) {
		for (int i = 0; i < m.length; i++) {
			System.out.print(m[i] + " ");
		}
	}
}
