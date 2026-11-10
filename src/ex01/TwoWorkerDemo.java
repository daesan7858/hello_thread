package ex01;

public class TwoWorkerDemo {

	public static void main(String[] args) {
		// 첫번째 작업흐름 객체 생성
		NumberWorker2 numberWork 	= new NumberWorker2();
		// 두번재 작업흐름 객체 생성
		TextWorker 	 textWork 		= new TextWorker();
		
		// 두 작업흐름이 실행되었나요?
		// 객체가 생성될 때 자동호출되는 생성자만 유일 자동실행
		// 내가 run()를 불러야 한다. but, 권장하지 않음
		// start()에 위임을 해야한다.
		numberWork.start(); // start => run을 대신 실행
		textWork.start();
		
		// 작업흐름은 현재 3개 = 메인 + numberWork + textWork
	}

}

// 첫번째 NumberWorker2
class NumberWorker2 extends Thread {
	@Override
	public void run() {
		for(int i=1; i<=5; i++) {
			System.out.println("숫자 : " + i);
			try {
				Thread.sleep(500);
			}catch(InterruptedException e) {
					System.out.println("숫자출력 오류");
					
					return;
				}
		}
		
	}
}

// 두번째 TextWorker
class TextWorker extends Thread {
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println("반갑다");
			try {
				Thread.sleep(500);
			}catch(InterruptedException e) {
					System.out.println("문자출력 오류");
					
					return;
				}
		}
		
	}
}