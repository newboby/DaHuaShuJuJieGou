package session9.util;

/**
 * Created by Administrator on 2018/5/4.
 */
public class util {
    private util(){};//防止实例化
    public static final void swap(int[] list,int a,int b){
            int temp=list[a];
            list[a]=list[b];
            list[b]=temp;
    }
}
