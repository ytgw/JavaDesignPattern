public class QuickSorter implements Sorter {
    public void sort(Comparable[] data) {
        recursivelySort(data, 0, data.length -1);
    }

    private void printData(Comparable[] data, int pre_idx, int post_idx, int separete_idx) {
        // デバッグ用の表示メソッド
        for (int i = 0; i < data.length; i++) {
            if (i == pre_idx) System.out.print("[ ");
            System.out.print(data[i] + " ");
            if (i == separete_idx) System.out.print("| ");
            if (i == post_idx) System.out.print("] ");
        }
        System.out.println("");
    }

    private void recursivelySort(Comparable[] data, int pre_idx, int post_idx) {
        if (pre_idx >= post_idx) return;
        // printData(data, pre_idx, post_idx, -1);
        int separete_idx = separate(data, pre_idx, post_idx);
        // printData(data, pre_idx, post_idx, separete_idx);
        recursivelySort(data, pre_idx, separete_idx);
        recursivelySort(data, separete_idx + 1, post_idx);
    }

    private int separate(Comparable[] data, int pre_idx, int post_idx) {
        Comparable mid_val = data[(pre_idx + post_idx) / 2];
        
        while (pre_idx < post_idx) {
            while(pre_idx < post_idx && data[pre_idx].compareTo(mid_val) < 0) pre_idx++;
            while(pre_idx < post_idx && data[post_idx].compareTo(mid_val) >= 0) post_idx--;
            if (pre_idx < post_idx) {
                Comparable tmp = data[pre_idx];
                data[pre_idx] = data[post_idx];
                data[post_idx] = tmp;
                pre_idx++;
                post_idx--;
            }
        }
        // 更新前 pre_idx ~ 更新後 post_idx までは mid_val 未満の値が入る。
        // 更新後 post_idx + 1 ~ 更新前 post_idx までは mid_val 以上の値が入る。
        int separete_idx = post_idx;
        return separete_idx;
    }
}
