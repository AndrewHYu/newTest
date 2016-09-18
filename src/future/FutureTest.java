package future;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTest {

	public static void main(String[] args) {

		Scanner in=new Scanner(System.in);
		System.out.println("Enter base directory(e.g...)");
		String dircetory=in.nextLine();
		System.out.println("Enter keyword:");
		String keyword=in.nextLine();
		
		MatchCounter counter=new MatchCounter(new File(dircetory), keyword);
		FutureTask<Integer> task=new FutureTask<>(counter);
		Thread thread=new Thread(task);
		thread.start();
		try {
			System.out.println(task.get()+"matching files.");
		} catch (ExecutionException e) {
			e.printStackTrace();
		}catch (InterruptedException e) {
			// TODO: handle exception
		}

		
	}

}
