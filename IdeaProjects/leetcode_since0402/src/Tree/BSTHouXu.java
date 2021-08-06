package Tree;

public class BSTHouXu {

    public boolean verifyPostorder(int[] postorder) {
        int len = postorder.length;
        if (len == 1) return true;
        if (len == 0) return false;
        return recur(postorder, 0, len);

    }

    boolean recur(int[] postorder, int le, int ri) {
        System.out.println(le + "   " + ri);
        if (le+1>= ri){
            System.out.println("true");
            return true;
        }
        int index = 0;
        int curRoot = postorder[ri - 1];
        for (int i = le; i < ri; i++) {
            if (postorder[i] > postorder[ri - 1]) {
                index = i;
                break;
            }
        }
        System.out.println(index);

        for (int i = le; i < index; i++) {
            if (postorder[i] > postorder[ri - 1]) {
                System.out.println("1111"+i);
                return false;
            }
        }
        for (int i = index; i < ri; i++) {
            if (postorder[i] < postorder[ri - 1]) {
                System.out.println("2222"+i);
                return false;
            }
        }

        return recur(postorder, le, index) && recur(postorder, index, ri - 1);
    }

    public static void main(String[] args) {
        BSTHouXu bstHouXu = new BSTHouXu();
        bstHouXu.verifyPostorder(
                new int[]{4, 8, 6, 12, 16, 14, 10});
    }
}
