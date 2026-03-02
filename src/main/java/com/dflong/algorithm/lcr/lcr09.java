package com.dflong.algorithm.lcr;

import com.dflong.greenbull.entity.ContractInfo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class lcr09 {

    public int sumNumbers(TreeNode root) {
        dfs(root, root.val);
        return res;
    }

    int res = 0;

    void dfs(TreeNode root, int sum) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            res += sum;
        }

        if (root.left != null) {
            dfs(root.left, sum * 10 + root.left.val);
        }

        if (root.right != null) {
            dfs(root.right, sum * 10 + root.right.val);
        }
    }

    public static void main(String[] args) {
       List<ContractInfo> contracts = new ArrayList<>();
        while (true) {
            System.out.println("    ddddddddddddddddddddddddddd");
            ContractInfo c = new ContractInfo();
            c.setState(1);
            c.setContractId("123456");
            c.setUnionid("gfssder");
            c.setTotalAmount(BigDecimal.ONE);
            contracts.add(c);
        }
    }

}
