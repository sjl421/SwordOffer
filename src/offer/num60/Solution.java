package offer.num60;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by meitu on 2017/7/6.
 */
public class Solution {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> array = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        LinkedList<TreeNode> list = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        boolean isOdd = true;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add(node.val);
            if (isOdd) {
                if (node.left != null) {
                    list.add(node.left);
                }
                if (node.right != null) {
                    list.add(node.right);
                }
            } else {
                if (node.right != null) {
                    list.add(node.right);
                }
                if (node.left != null) {
                    list.add(node.left);
                }
            }

            if (queue.isEmpty()) {
                isOdd = !isOdd;
                array.add(res);
                for (int i = 0; i < list.size(); i++) {
                    queue.offer(list.get(i));
                }
                res = new ArrayList<>();
                list = new LinkedList<>();
            }
        }
        return array;

    }


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
