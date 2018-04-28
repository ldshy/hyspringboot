package com.example.Controller;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestTree {
    class TreeNode{
        int val;
        //左孩子
        TreeNode left;
        //右孩子
        TreeNode right;
    }

    int maxDeath(TreeNode node){
        if(node==null){
            return 0;
        }
        int left = maxDeath(node.left);
        int right = maxDeath(node.right);
        return Math.max(left,right) + 1;
    }


    private static class Mytread extends Thread{

        public void run(){
            for(int i=0;i<100;i++){
                System.out.println("  兔子跑了几步"+i);
            }
        }
    }

    private static class Wgtread extends Thread{

        public void run(){
            for(int i=0;i<100;i++){
                System.out.println("乌龟跑了几步"+i);
            }
        }
    }

    public enum WeekDay{
        SUN(0),MON(1),TUS(2),WED(3),THU(4),FRI(5),SAT(6);

        private int value;

        private WeekDay(int value){
            this.value=value;
        }

        public static WeekDay getNextDay(WeekDay nowDay){
            int nextDayValue =nowDay.value;
            if(++nextDayValue==7){
                nextDayValue=0;
            }
            return getDayWeek(nextDayValue);
        }

        public static WeekDay getDayWeek(int nextday){
            for ( WeekDay w: WeekDay.values()){
                if(w.value==nextday){
                    return w;
                }
            }
            return null;
        }
    }

    public static void main(String[] arg) throws IOException{

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("输入字符, 按下 'q' 键退出。");
//
//        do{
//            System.out.println(br.readLine());
//        }while(br.readLine().equals("qq"));
        //封装ip 和dns
        InetAddress inaddress =  InetAddress.getLocalHost();

        inaddress = InetAddress.getByName("www.baidu.com");//根据ip地址或者域名得到InetAddress 对象
        inaddress.getHostName(); //new 的时候是ip地址不存在 不可以解析  这里还是ip地址  * IP地址存在 可以解析 得到域名 * new的时候是域名 的到域名
        inaddress.getHostAddress();//得到ip地址
        //封装端口
        InetSocketAddress isa = new InetSocketAddress("localhost",9999);

        test_mysql();
        System.out.print(WeekDay.FRI);

        Mytread myt = new Mytread();
        myt.start();
        Wgtread wgt =new Wgtread();
        wgt.start();

    }


    int arr[]=new int[6];
    int arr1[]=new int[]{1,2,3,4,5,6};
    int[] arr2 = {1,2,3,4,5};


    private static void test_mysql(){
        ResultSet rs=null;
        Connection conn = null;
        PreparedStatement st =null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/new","root","1234");
            String sql = "select * from news1";
            st =conn.prepareStatement(sql);
            System.out.print(st.execute());
            rs = st.executeQuery();
            System.out.print(rs);
            //下一行有数据
            while(rs.next()){
                System.out.print(rs.getInt(1)+">>"+rs.getString(2)+">>"+rs.getString(3));
            }
        }catch (Exception e){
            System.out.print(e.getStackTrace());
        }finally {
            if(rs!=null){
                try {
                    rs.close();
                    st.close();
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    if (conn!=null){
                        try{
                            conn.close();
                        }catch (Exception e){
                            e.printStackTrace();
                        }

                    }
                }

            }
        }
    }

}
