
public class GCF
{
    public static int GCF(int top,int bottom){      
        int temp;
        while(bottom!=0){     
            temp=top%bottom;       
            top=bottom;    
            bottom=temp;      
        } 
        return top;    
    }
    
    public static int power(int base, int exp){
        int result=1;
        for(int i=1; i<=exp; i++){
            result*=base;
        }
        return result;
    }

    public static void main(String[] args){
        double answer=GCF(15,5);
        System.out.println(answer);
        System.out.println(power(2,3));
    }
}
