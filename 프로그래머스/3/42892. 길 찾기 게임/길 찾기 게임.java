import java.util.Arrays;
class Solution {
    int idx;

    public int[][] solution(int[][] nodeinfo) {
        int n = nodeinfo.length;
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
        }

        // Y 내림차순, X 오름차순 정렬
        Arrays.sort(nodes, (a, b) -> {
            if (a.y == b.y) return a.x - b.x;
            return b.y - a.y;
        });

        Node root = nodes[0];
        for (int i = 1; i < n; i++) {
            insert(root, nodes[i]);
        }

        int[][] answer = new int[2][n];
        
        idx = 0;
        preOrder(root, answer[0]);

        idx = 0;
        postOrder(root, answer[1]);

        return answer;
    }
        public void insert(Node root, Node node) {
        if (node.x < root.x) {
            if (root.left == null) root.left = node;
            else insert(root.left, node);
        } else {
            if (root.right == null) root.right = node;
            else insert(root.right, node);
        }
    }

    public void preOrder(Node node, int[] result) {
        if (node != null) {
            result[idx++] = node.id;
            preOrder(node.left, result);
            preOrder(node.right, result);
        }
    }

    public void postOrder(Node node, int[] result) {
        if (node != null) {
            postOrder(node.left, result);
            postOrder(node.right, result);
            result[idx++] = node.id;
        }
    }

}

class Node {
    int id;
    int x, y;
    Node left;
    Node right;

    public Node(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }
}