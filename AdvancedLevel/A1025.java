import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
 
public class Main {
 
    static class cmp implements Comparator<Student>{
 
        @Override
        public int compare(Student o1, Student o2) {
            // TODO Auto-generated method stub
            int a=-1;
            if(o1.score==o2.score){
                if(o1.id==o2.id.max(o1.id)){
                    a=1;
                }
            }
            if(o1.score>o2.score){
                a= -1;
            }
            if(o1.score<o2.score){
                a= 1;
            } 
            return a;           
        }       
    }
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Student  student[] = new Student[30000];
        int num=0;
        try{
            int n = Integer.parseInt(br.readLine());
 
              for(int i=0;i<n;i++){
                  //num 为考生数
                  int k=Integer.parseInt(br.readLine());
                  for(int j=0;j<k;j++){
                      student[num]=new Student();
                     // System.out.println(student[num].id);
                      String arr= br.readLine();
                      String arrs[] = arr.split(" ");
                      student[num]=new Student();
                      student[num].id=new BigInteger(arrs[0]);
                      student[num].score=Integer.parseInt(arrs[1]);
                      student[num].location_number=i+1;
                      num++;
                  }
                  //内部排序
                  int num1=num-k;
                 Arrays.sort(student, num1, num,new cmp());
                  //内部排名次
                  student[num-k].local_rank=1;
                  for(int j=num-k+1;j<num;j++){
                      if (student[j].score==student[j-1].score){
                          student[j].local_rank=student[j-1].local_rank;
                      }else {
                          student[j].local_rank=j+1-(num-k);
                      }
                  }
              } 
        }catch(IOException e){
            e.printStackTrace();
        }
        //全部排序
        Arrays.sort(student,0,num,new cmp());
      System.out.println(num);
        int mm=1;
        for(int i=0;i<num;i++){
            if(i>0&&student[i].score==student[i-1].score){
                System.out.println(student[i].id+" "+mm+" "+student[i].location_number+" "+student[i].local_rank);
            }else {
                mm=i+1;
                System.out.println(student[i].id + " " + mm + " " + student[i].location_number + " " + student[i].local_rank);
            }
        } 
    }
    public static class Student{
        BigInteger id;
        int score;
        int location_number;
        int local_rank;
    }
 
}