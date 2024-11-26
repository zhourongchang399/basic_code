package com.just.demo14;

import java.util.ArrayList;

public class Search {
    public static void main(String[] args) {
        int[] list = {1,3,4,5,6,7,8,123,321,545};
        int[] arr = {16, 5, 9, 12,
                    21, 18,
                    32, 23, 37, 26, 45, 34,
                    50, 48, 61, 52, 73, 66};
        ArrayList<Block> blocks = new ArrayList<>();
        Block block1 = new Block(16, 0, 3);
        Block block2 = new Block(21, 4, 5);
        Block block3 = new Block(45, 6, 11);
        Block block4 = new Block(66, 12, 17);
        blocks.add(block1);
        blocks.add(block2);
        blocks.add(block3);
        blocks.add(block4);

        System.out.println(basicSearch(list, 123));
        System.out.println(halfSearch(list, 123));
        System.out.println(insertSearch(list, 123));
        System.out.println(blockSearch(blocks, arr, 18));
    }

    public static int basicSearch(int[] arr, int number) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number){
                return i;
            }
        }
        return -1;
    }

    public static int halfSearch(int[] arr, int number) {
        int min = 0;
        int max = arr.length - 1;
        while (true) {
            int mid = (max + min) / 2;
            if (min > max) {
                return -1;
            }
            if (arr[mid] == number) {
                return mid;
            } else if (arr[mid] < number) {
                min = mid + 1;
            } else if (arr[mid] > number) {
                max = mid - 1;
            }
        }
    }

    public static int insertSearch(int[] arr, int number) {
        int min = 0;
        int max = arr.length - 1;
        while (true) {
            if (min > max) {
                return -1;
            }
            int mid = min + ((number - arr[min]) / (arr[max] - arr[min])) * (max - min);
            if (arr[mid] == number) {
                return mid;
            } else if (arr[mid] < number) {
                min = mid + 1;
            } else if (arr[mid] > number) {
                max = mid - 1;
            }
        }
    }

    public static int blockSearch(ArrayList<Block> blocks, int[] arr, int number){
        int index = getIndex(blocks, number);
        if (index == -1){
            return -1;
        } else {
            int max = blocks.get(index).getMaxIndex();
            int min = blocks.get(index).getMinIndex();
            for (int i = min; i <= max; i++) {
                if (arr[i] == number) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static int getIndex(ArrayList<Block> blocks, int number) {
        for (int i = 0; i < blocks.size(); i++) {
            if (blocks.get(i).getMaxValue() >= number) {
                return i;
            }
        }
        return -1;
    }
}

class Block {
    int maxValue;
    int minIndex;
    int maxIndex;

    public Block() {
    }

    public Block(int maxValue, int minIndex, int maxIndex) {
        this.maxValue = maxValue;
        this.minIndex = minIndex;
        this.maxIndex = maxIndex;
    }

    /**
     * 获取
     * @return maxValue
     */
    public int getMaxValue() {
        return maxValue;
    }

    /**
     * 设置
     * @param maxValue
     */
    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    /**
     * 获取
     * @return minIndex
     */
    public int getMinIndex() {
        return minIndex;
    }

    /**
     * 设置
     * @param minIndex
     */
    public void setMinIndex(int minIndex) {
        this.minIndex = minIndex;
    }

    /**
     * 获取
     * @return maxIndex
     */
    public int getMaxIndex() {
        return maxIndex;
    }

    /**
     * 设置
     * @param maxIndex
     */
    public void setMaxIndex(int maxIndex) {
        this.maxIndex = maxIndex;
    }

    public String toString() {
        return "Block{maxValue = " + maxValue + ", minIndex = " + minIndex + ", maxIndex = " + maxIndex + "}";
    }
}
