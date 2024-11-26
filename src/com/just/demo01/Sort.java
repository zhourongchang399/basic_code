package com.just.demo01;

public class Sort {
    private boolean state;

    public Sort() {
    }

    public Sort(boolean state) {
        this.state = state;
    }

    public void fastSort(int[] list, int startL, int startR) {
        if (startL >= startR){
            return;
        }
        int l = startL;
        int r = startR;
        int target = l;
        while (l != r) {
            if (target != r) {
                if (list[target] > list[r]) {
                    int temp = list[target];
                    list[target] = list[r];
                    list[r] = temp;
                    target = r;
                    l++;
                } else {
                    r--;
                }
            }
            if (target != l) {
                if (list[target] < list[l]) {
                    int temp = list[l];
                    list[l] = list[target];
                    list[target] = temp;
                    target = l;
                    r--;
                } else {
                    l++;
                }
            }
        }
        fastSort(list, startL, target - 1);
        fastSort(list, target + 1, startR);
    }

    public void insertSort(int[] list) {
        int startIndex = -1;
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i] > list[i + 1]) {
                startIndex = i + 1;
                break;
            }
        }

        if (startIndex != -1) {
            for (int i = startIndex; i < list.length; i++) {
                int j = i;
                while (j - 1 >= 0) {
                    if (list[j - 1] > list[j]) {
                        int temp = list[j];
                        list[j] = list[j - 1];
                        list[j - 1] = temp;
                        j--;
                    } else {
                        break;
                    }
                }
            }
        }

    }

    public void bubbleSort(int[] list) {

        int temp;

        for (int i = 0; i < list.length - 1; i++) {
            for (int j = i + 1; j < list.length; j++) {
                if (list[i] > list[j]){
                    temp = list[j];
                    list[j] = list[i];
                    list[i] = temp;

                }
            }
        }

    }

    public void selectedSort(int[] list) {
        
        int min;
        int temp;

        for (int i = 0; i < list.length; i++) {
            min = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[min] >= list[j])
                    min = j;
            }
            temp = list[min];
            list[min] = list[i];
            list[i] = temp;
        }
        
    }

    /**
     * 获取
     * @return state
     */
    public boolean isState() {
        return state;
    }

    /**
     * 设置
     * @param state
     */
    public void setState(boolean state) {
        this.state = state;
    }

    public String toString() {
        return "Sort{state = " + state + "}";
    }
}
