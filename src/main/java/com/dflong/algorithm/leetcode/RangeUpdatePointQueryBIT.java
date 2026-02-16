package com.dflong.algorithm.leetcode;

/**
 * 区间修改，单点查询
 * 使用树状数组维护差分数组
 * 差分思想：将区间更新转换为两个端点的单点更新
 * 原数组：arr[1..n]
 * 差分数组：diff[i] = arr[i] - arr[i-1]，其中 arr[0] = 0
 * 性质：arr[i] = ∑(j=1 to i) diff[j]
 * 对区间 [l, r] 所有元素增加 val
 * 等价于：
 * diff[l] += val
 * diff[r+1] -= val
 */
public class RangeUpdatePointQueryBIT {

    private int[] tree;  // 树状数组（维护差分数组）
    private int n;       // 数组大小

    // ====================== 构造函数 ======================

    /**
     * 构造函数1：指定大小
     * @param n 数组大小
     */
    public RangeUpdatePointQueryBIT(int n) {
        this.n = n;
        this.tree = new int[n + 2];  // 多分配一位，方便处理 r+1
    }

    /**
     * 构造函数2：从数组初始化
     * @param nums 原始数组
     */
    public RangeUpdatePointQueryBIT(int[] nums) {
        this.n = nums.length;
        this.tree = new int[n + 2];

        // 构建差分数组
        for (int i = 0; i < n; i++) {
            int delta = nums[i]; // 差值
            if (i > 0) {
                delta -= nums[i - 1];
            }
            update(i + 1, delta); // 对应差分数组索引就是i+1
        }
    }

    // ====================== 核心私有方法 ======================

    /**
     * 获取最低位的1
     */
    private int lowbit(int x) {
        return x & (-x);
    }

    /**
     * 单点更新差分数组
     * @param i 位置（1-based）
     * @param delta 增量
     */
    private void update(int i, int delta) {
        if (i < 1 || i > n + 1) {
            return;  // 允许更新到 n+1
        }

        while (i <= n + 1) {
            tree[i] += delta;
            i += lowbit(i);
        }
    }

    /**
     * 查询差分数组的前缀和
     * @param i 位置（1-based）
     * @return 前缀和
     */
    private int query(int i) {
        if (i < 1) return 0;
        if (i > n) i = n;  // 限制最大查询位置

        int sum = 0;
        while (i > 0) {
            sum += tree[i];
            i -= lowbit(i);
        }
        return sum;
    }

    /**
     * 区间更新：[l, r] 所有元素增加 val
     * 时间复杂度：O(log n)
     * @param l 左边界（1-based）
     * @param r 右边界（1-based）
     * @param val 增加值
     */
    public void rangeUpdate(int l, int r, int val) {
        if (l > r) {
            throw new IllegalArgumentException("左边界 " + l + " 不能大于右边界 " + r);
        }
        if (l < 1) l = 1;
        if (r > n) r = n;

        // 差分数组更新
        update(l, val);
        update(r + 1, -val);
    }

    /**
     * 单点查询：获取位置 i 的值
     * 时间复杂度：O(log n)
     * @param i 位置（1-based）
     * @return 该位置的值
     */
    public int pointQuery(int i) {
        if (i < 1 || i > n) {
            throw new IndexOutOfBoundsException(
                    String.format("索引 %d 超出范围 [1, %d]", i, n)
            );
        }
        return query(i);
    }

    /**
     * 获取整个数组
     * @return 完整数组
     */
    public int[] getArray() {
        int[] result = new int[n];
        for (int i = 1; i <= n; i++) {
            result[i - 1] = pointQuery(i);
        }
        return result;
    }

    /**
     * 获取区间和 [l, r]
     * 注意：此方法复杂度为 O(n log n)，不高效
     * 需要区间查询请使用 RangeUpdateRangeQueryBIT
     */
    public int rangeSum(int l, int r) {
        if (l > r) return 0;
        if (l < 1) l = 1;
        if (r > n) r = n;

        int sum = 0;
        for (int i = l; i <= r; i++) {
            sum += pointQuery(i);
        }
        return sum;
    }

    /**
     * 设置位置 i 的值（通过差值计算）
     * @param i 位置
     * @param val 新值
     */
    public void setPoint(int i, int val) {
        if (i < 1 || i > n) {
            throw new IndexOutOfBoundsException(
                    String.format("索引 %d 超出范围 [1, %d]", i, n)
            );
        }

        int current = pointQuery(i);
        int delta = val - current;
        update(i, delta); // 当前位置变大
        update(i + 1, -delta); // 后面位置就要变小
    }
}
