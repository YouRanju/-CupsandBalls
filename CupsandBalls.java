import java.util.Scanner;

//개인정보를 저장하는 클래스
class PersonalData 
{	
	private String name = "";
	private int money = 50000;	//기본금액 저장
	
	public void setName(String name)
	{
		this.name = name;
	} //method setName()

	public String getName() 
	{
		return this.name;
	} //method getName()

	public void setMoney(int money) 
	{
		this.money += money;
	} //method setMoney()

	public int getMoney() 
	{
		return this.money;
	} //method getMoney()
}; //class PersonalData

//상황에 따라 다른 야바위컵을 출력하기 위한 클래스
//클래스를 인스턴스화할 과정의 코드를 생략하여 간편화하고
//객체 변수명 없이 객체가 무슨 용도인지 명확히 보이기 위해 static 사용
class YabawiCup
{
	public static void ballinOne() 
	{
		System.out.println("        ┌───┐   ┌───┐");
		System.out.println("        │   │   │   │");
		System.out.println("  ●     └───┘   └───┘");
		System.out.println(" (1)     (2)     (3)");	
	} //method ballinOne()
	
	public static void ballinTwo() {
		System.out.println("┌───┐           ┌───┐");
		System.out.println("│   │           │   │");
		System.out.println("└───┘     ●     └───┘");
		System.out.println(" (1)     (2)     (3)");	
	} //method ballinTwo()
	
	public static void ballinThree() {
		System.out.println("┌───┐   ┌───┐");
		System.out.println("│   │   │   │");
		System.out.println("└───┘   └───┘     ●");
		System.out.println(" (1)     (2)     (3)");	
	} //method ballinThree()
	
	public static void closeCup () {	
		System.out.println("┌───┐   ┌───┐   ┌───┐");
		System.out.println("│   │   │   │   │   │");
		System.out.println("└───┘   └───┘   └───┘");
		System.out.println(" (1)     (2)     (3)");		
	} //method closeCup()
}; //class YabawiCup

//Main
public class CupsandBalls
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
	
		//개인정보용 변수
		PersonalData ID = new PersonalData();		//개인정보 객체
		String inputName = "";			//사용자의 이름 (입력받는 용도)
		int inputMoney = 0;			//사용자가 추가로 입력할 돈 / 배팅할 돈(입력받는 용도)
		boolean isStart= false;			//처음 실행하거나 게임을 다시 시작할 때 체크하는 변수
		
		//게임 플레이용 변수
		int choice = 0;				//사용자가 선택한 컵의 위치 (입력받는용도)							
		int randCup = 0;				//프로그램이 섞어논 컵의 위치							
		String YN = "";				//사용자가 게임을 계속하기 원하는지 체크하는 변수 (입력받는용도)
			
		//게임 시작
		//유저 정보 입력 - 이름 입력
		System.out.print("이름을 입력해 주세요 : ");	
		inputName = sc.next();
		ID.setName(inputName);					
		
		//유저가 그만 하길 원할 때까지 게임 반복
		while(true) 
		{
			//처음 실행이거나 게임을 다시 시작한다면 추가 배팅금 입력						
			if(!isStart)
			{
				System.out.println();			
				System.out.print("금액을 넣어주세요 (기본 금액 50000원) : "); 
				inputmoney = sc.nextInt();		
				ID.setMoney(inputmoney);		
		
				System.out.println(ID.getName()+"님의 배팅금 : " + ID.getMoney());	
				System.out.println();

				isStart = true;
			}
			
			//컵 출력 과정
			System.out.println();
			YabawiCup.ballinOne();	
			
			System.out.println();
			System.out.println("[덮습니다.]");	
			
			YabawiCup.closeCup();	
		
			System.out.println();
			System.out.println("[섞는 중...]");	
		
			YabawiCup.closeCup();	
			
			//사용자에게 컵의 위치를 입력받는 과정
			//사용자가 1, 2, 3 이외의 문자를 입력했을 시 다시 입력받기 위한 반복
			for(int i = 0; i < 1; i++) 
			{	
				System.out.println();
				System.out.println("구슬은 어디에 있을까요?");
				System.out.print("입력 : ");	
				choice = sc.nextInt();	
				
				switch(choice)
				{
					case 1: case 2: case 3:	
						break;			
					default:			
						System.out.println("다시 입력해주십시오.");
						i--;			
					break;
				} //switch - user choice cup
			} //for - input user's choice
			
			//사용자가 배팅할 금액을 입력받는 과정
			//사용자가 가지고 있는 금액보다 큰 경우를 입력할 때 다시 입력받기 위한 반복
			for(int i = 0 ; i < 1; i++) 
			{
				System.out.println();
				System.out.println("얼마 거시겠습니까?");
				System.out.print("입력 : ");	
				inputMoney = sc.nextInt();	
			
				if(inputMoney > ID.getMoney()) 
				{	
					System.out.println("가지고 계신 금액보다 큽니다. 다시입력해주십시오.");
					i--;	
				}
				
			} //for - input user's bat money
		
			//공의 위치 섞기
			randCup = (int)(Math.random() * 3) + 1;	
		
			switch(randCup) 
			{	
				case 1 :		
					YabawiCup.ballinOne();
					break;
			
				case 2:			
					YabawiCup.ballinTwo();	
					break;
			
				case 3:			
					YabawiCup.ballinThree();	
					break;
			} //switch - rand result
			
			//공의 위치와 유저가 선택한 컵이 같은 지 확인하는 과정
			switch(randCup - choice) 
			{	
				//같음
				case 0:
					System.out.println("대단하십니다!");
					System.out.println("+" + inputMoney * 2 + "(원)");
			
					ID.setMoney(inputMoney * 2);

					break;
				//다름
				default :
					System.out.println("실패");	
					System.out.println("-" + inputMoney + "(원)");	
			
					ID.setMoney(-inputMoney);	
			
					break;
			} //switch - user result
			
			//남은 금액 출력
			System.out.println(ID.getName() + "님의 배팅금 : " + ID.getMoney()); 
			
			//사용자가 금액을 모두 사용했을 경우
			if (ID.getMoney() == 0) {
				System.out.println();
				System.out.println("앗!! 모두 탕진해버렸습니다.");	
			} 
		
			System.out.println();
			
			//다시 시작을 원하는지 입력받는 과정
			// y 또는 n 이외의 문자를 입력했을 시 다시 입력받기 위해 반복
			for(int i = 0; i < 1; i++) {	
				
				System.out.print("다시하시겠습니까? (Y/N) : ");	
				YN = sc.next();	
				
				if(YN.equalsIgnoreCase("n") || YN.equalsIgnoreCase("y")) {	
					break;	
				}
				
				else {
					System.out.println("다시 입력해주세요.");	
					i--;	
				}
			}
			
			if(YN.equalsIgnoreCase("y") && ID.getMoney() == 0) {	
				ID.setMoney(50000);	
				isStart= false;	
			}	
			
			if(YN.equalsIgnoreCase("n")) {	
				System.out.println();
				System.out.println("안녕히 가십시오.");	
				break; 
			}	
		
		}
	}
}