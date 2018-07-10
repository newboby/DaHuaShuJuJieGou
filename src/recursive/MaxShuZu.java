package recursive;

/**
 * Created by Administrator on 2018/7/10.
 */
public class MaxShuZu {

    public static Ob findMxa(int[] arr, int low, int mind, int hight) {
        int left_max = 0;
        int sum = 0;
        Ob left_o=new Ob();
        left_o.setRight(mind);
        for (int i = mind; i >= low; i--) {
            sum += arr[i];
            if (sum > left_max) {
                left_max=sum;
                left_o.setSum(sum);
                left_o.setLeft(i);
            }
        }
        int right_max = 0;
        Ob right_o=new Ob();
        right_o.setLeft(mind+1);
        sum = 0;
        for (int i = mind+1; i <= hight; i++) {
            sum += arr[i];
            if (sum > right_max) {
            right_max=sum;
                right_o.setRight(i);
                right_o.setSum(sum);
            }
        }
        return new Ob(left_o.getLeft(),right_o.getRight(),left_o.getSum()+right_o.getSum());
//        return right_max+left_max;
    }

    public static Ob find(int[] arr, int low, int hight) {
        if (low == hight) {
            return new Ob(low,hight,arr[low]);
//            return arr[low];
        }
        int mind = (hight + low) >> 1;
        Ob left_max = find(arr, low, mind);
        Ob right_max = find(arr, mind + 1, hight);
        Ob cross_max = findMxa(arr, low, mind, hight);
        if (left_max.getSum() > right_max.getSum() && left_max.getSum() > cross_max.getSum()) {
            return left_max;
        } else if (right_max.getSum() > left_max.getSum() && right_max.getSum() > cross_max.getSum()) {
            return right_max;
        } else return cross_max;
//        int left_max = find(arr, low, mind);
//        int right_max = find(arr, mind + 1, hight);
//        int cross_max = findMxa(arr, low, mind, hight);
//        if (left_max > right_max && left_max > cross_max) {
//            return left_max;
//        } else if (right_max > left_max && right_max > cross_max) {
//            return right_max;
//        } else return cross_max;
    }

    public static void main(String[] args) {
        int[] arr=new int[]{13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
        Ob ob = find(arr, 0, arr.length -1);
        System.out.println(ob);
//        int i = find(arr, 0, arr.length -1);
//        System.out.println(i);
    }
}
class Ob{
    int left;
    int right;
    int sum;

    public Ob() {
    }

    public Ob(int left, int right, int sum) {
        this.left = left;
        this.right = right;
        this.sum = sum;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Ob{" +
                "left=" + left +
                ", right=" + right +
                ", sum=" + sum +
                '}';
    }
}