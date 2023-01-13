import java.util.*;
public class Timetable {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
        String students[]=new String[10];
        int x,y,z;
        int course[]=new int[15];
        System.out.println("Enter registration numbers: ");
        for(int i=0;i<10;i++){
            students[i]=sc.next();
        }
         for(int j=0;j<15;j++){
            course[j]=0;
        }
        for(int i=0;i<10;i++){
            while(true){
            System.out.println("Select first course for student "+students[i]);
            System.out.println("1.Course-1");
            System.out.println("2.Course-2");
            System.out.println("3.Course-3");
            System.out.println("4.Course-4");
            System.out.println("5.Course-5");
            System.out.println("6.Course-6");
            System.out.println("7.Course-7");
            System.out.println("8.Course-8");
            System.out.println("9.Course-9");
            System.out.println("10.Course-10");
            System.out.println("11.Course-11");
            System.out.println("12.Course-12");
            System.out.println("13.Course-13");
            System.out.println("14.Course-14");
            System.out.println("15.Course-15");
            x=sc.nextInt();
            if(course[x]<3){
            course[x]=course[x]+1;
            break;
            }
            else
            System.out.println("Enter again");
        }
            while(true){
            System.out.println("Select second course for student "+students[i]);
            y=sc.nextInt();
            if(x!=y){
            if(course[y]<3){
             course[y]=course[y]+1;   
              break;
            }
            }
            else
            System.out.println("Enter again");
}
            while(true){
            System.out.println("Select third course for student "+students[i]);
            z=sc.nextInt();
            if(x!=z && y!=z){
            if(course[z]<3){
             course[z]=course[z]+1;   
              break;
            }
            }
            else
            System.out.println("Enter again");
        }
        if(x<=3){
          System.out.println("Student "+students[i]+" has first course at 9 on monday");  
        }
        else if(x<=6){
            System.out.println("Student "+students[i]+" has first course at 9 on tuesday");  
        }
        else if(x<=9){
          System.out.println("Student "+students[i]+" has first course at 9 on wednesday");    
        }
        else if(x<=12){
          System.out.println("Student "+students[i]+" has first course at 9 on thursday");    
        } 
        else if(x<=15){
          System.out.println("Student "+students[i]+" has first course at 9 on friday");    
        }
        if(y<=3){
          System.out.println("Student "+students[i]+" has second course at 9 on monday");  
        }
        else if(y<=6){
            System.out.println("Student "+students[i]+" has second course at 9 on tuesday");  
        }
        else if(y<=9){
          System.out.println("Student "+students[i]+" has second course at 9 on wednesday");    
        }
        else if(y<=12){
          System.out.println("Student "+students[i]+" has second course at 9 on thursday");    
        } 
        else if(y<=15){
          System.out.println("Student "+students[i]+" has second course at 9 on friday");    
        }
        if(z<=3){
          System.out.println("Student "+students[i]+" has third course at 9 on monday");  
        }
        else if(z<=6){
            System.out.println("Student "+students[i]+" has third course at 9 on tuesday");  
        }
        else if(z<=9){
          System.out.println("Student "+students[i]+" has third course at 9 on wednesday");    
        }
        else if(z<=12){
          System.out.println("Student "+students[i]+" has third course at 9 on thursday");    
        } 
        else if(z<=15){
          System.out.println("Student "+students[i]+" has third course at 9 on friday");    
        }
    }
	}

}
