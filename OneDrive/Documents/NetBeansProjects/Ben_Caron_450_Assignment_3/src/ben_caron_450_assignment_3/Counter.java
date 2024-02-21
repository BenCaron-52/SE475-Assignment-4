package ben_caron_450_assignment_3;

public class Counter extends Thread {
    
    private String countType;
    
    public Counter(String cType){
        countType = cType;
    }
    
    @Override
    public void run() {
        if(countType == "even"){
            //delay evenCount thread so both threads count in ascending order
            try{
                    Thread.sleep(250);
                } catch(InterruptedException e){
                }
            
            for(int i = 2; i <= 20; i += 2) {
                System.out.println(i + " from evenCounter thread");
                
                try{
                    Thread.sleep(500);
                } catch(InterruptedException e){
                }
            }
        }
        else if(countType == "odd"){
            for(int j = 1; j < 20; j += 2){
                System.out.println(j + " from oddCounter thread");
                
                try{
                    Thread.sleep(500);
                } catch(InterruptedException e){
                }
            }
        }
    }
}
