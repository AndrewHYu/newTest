package Lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Andrew  on 2017/2/18.
 */
public class ThreadConditionLook {
    private static Account account = new Account();
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new DepositTask());
        executor.execute(new WithdrawTask());
        executor.shutdown();
        System.out.println("Thread 1\t\tThread 2\t\t\t\tBalance");
    }
    private static class Account{
        //create a new lock
        private static Lock lock = new ReentrantLock();
        //craete a condition
        private static Condition newDeposit = lock.newCondition();
        private int  balance =0;
        public int getBalance(){
            return balance;
        }
        public void withdraw(int mount){
            lock.lock();//Acqurie the lock
            try{
                System.out.print("get lock");
                while(balance<mount){
                    System.out.println("\t\t\tWait for a deposit");
                    newDeposit.await();
                }
                balance -=mount;
                System.out.println("\t\t\tWithdraw "+mount+"\t\t\t\t\t"+getBalance());
            }catch(InterruptedException e){

            }finally{
                lock.unlock();
            }
        }
        public void depsoit(int mount){
            lock.lock();
            try{
                balance+=mount;
                System.out.println("Deposit "+mount+"\t\t\t\t\t\t\t\t"+getBalance());
                newDeposit.signalAll();
            }finally{
                lock.unlock();
            }
        }
    }
    //Task for deposit account;
    private static class DepositTask implements Runnable{

        @Override
        public void run() {
            // TODO Auto-generated method stub

            try{
                while(true){
                    account.depsoit((int)(Math.random()*10)+1);
                    Thread.sleep(1000);
                }

            }catch(InterruptedException e){

            }


        }

    }
    //Task for withdraw account
    private static class WithdrawTask implements Runnable{

        @Override
        public void run() {
            // TODO Auto-generated method stub
            try{
                while(true){
                    account.withdraw((int)(Math.random()*10)+1);
                    Thread.sleep(1000);
                }
            }catch(InterruptedException e){

            }
        }

    }
}
