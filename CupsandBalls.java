import java.util.Scanner;

//���������� �����ϴ� Ŭ����
class PersonalData 
{	
	private String name = "";
	private int money = 50000;	//�⺻�ݾ� ����
	
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

//��Ȳ�� ���� �ٸ� �߹������� ����ϱ� ���� Ŭ����
//Ŭ������ �ν��Ͻ�ȭ�� ������ �ڵ带 �����Ͽ� ����ȭ�ϰ�
//��ü ������ ���� ��ü�� ���� �뵵���� ��Ȯ�� ���̱� ���� static ���
class YabawiCup
{
	public static void ballinOne() 
	{
		System.out.println("        ����������   ����������");
		System.out.println("        ��   ��   ��   ��");
		System.out.println("  ��     ����������   ����������");
		System.out.println(" (1)     (2)     (3)");	
	} //method ballinOne()
	
	public static void ballinTwo() {
		System.out.println("����������           ����������");
		System.out.println("��   ��           ��   ��");
		System.out.println("����������     ��     ����������");
		System.out.println(" (1)     (2)     (3)");	
	} //method ballinTwo()
	
	public static void ballinThree() {
		System.out.println("����������   ����������");
		System.out.println("��   ��   ��   ��");
		System.out.println("����������   ����������     ��");
		System.out.println(" (1)     (2)     (3)");	
	} //method ballinThree()
	
	public static void closeCup () {	
		System.out.println("����������   ����������   ����������");
		System.out.println("��   ��   ��   ��   ��   ��");
		System.out.println("����������   ����������   ����������");
		System.out.println(" (1)     (2)     (3)");		
	} //method closeCup()
}; //class YabawiCup

//Main
public class CupsandBalls
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
	
		//���������� ����
		PersonalData ID = new PersonalData();		//�������� ��ü
		String inputName = "";			//������� �̸� (�Է¹޴� �뵵)
		int inputMoney = 0;			//����ڰ� �߰��� �Է��� �� / ������ ��(�Է¹޴� �뵵)
		boolean isStart= false;			//ó�� �����ϰų� ������ �ٽ� ������ �� üũ�ϴ� ����
		
		//���� �÷��̿� ����
		int choice = 0;				//����ڰ� ������ ���� ��ġ (�Է¹޴¿뵵)							
		int randCup = 0;				//���α׷��� ����� ���� ��ġ							
		String YN = "";				//����ڰ� ������ ����ϱ� ���ϴ��� üũ�ϴ� ���� (�Է¹޴¿뵵)
			
		//���� ����
		//���� ���� �Է� - �̸� �Է�
		System.out.print("�̸��� �Է��� �ּ��� : ");	
		inputName = sc.next();
		ID.setName(inputName);					
		
		//������ �׸� �ϱ� ���� ������ ���� �ݺ�
		while(true) 
		{
			//ó�� �����̰ų� ������ �ٽ� �����Ѵٸ� �߰� ���ñ� �Է�						
			if(!isStart)
			{
				System.out.println();			
				System.out.print("�ݾ��� �־��ּ��� (�⺻ �ݾ� 50000��) : "); 
				inputmoney = sc.nextInt();		
				ID.setMoney(inputmoney);		
		
				System.out.println(ID.getName()+"���� ���ñ� : " + ID.getMoney());	
				System.out.println();

				isStart = true;
			}
			
			//�� ��� ����
			System.out.println();
			YabawiCup.ballinOne();	
			
			System.out.println();
			System.out.println("[�����ϴ�.]");	
			
			YabawiCup.closeCup();	
		
			System.out.println();
			System.out.println("[���� ��...]");	
		
			YabawiCup.closeCup();	
			
			//����ڿ��� ���� ��ġ�� �Է¹޴� ����
			//����ڰ� 1, 2, 3 �̿��� ���ڸ� �Է����� �� �ٽ� �Է¹ޱ� ���� �ݺ�
			for(int i = 0; i < 1; i++) 
			{	
				System.out.println();
				System.out.println("������ ��� �������?");
				System.out.print("�Է� : ");	
				choice = sc.nextInt();	
				
				switch(choice)
				{
					case 1: case 2: case 3:	
						break;			
					default:			
						System.out.println("�ٽ� �Է����ֽʽÿ�.");
						i--;			
					break;
				} //switch - user choice cup
			} //for - input user's choice
			
			//����ڰ� ������ �ݾ��� �Է¹޴� ����
			//����ڰ� ������ �ִ� �ݾ׺��� ū ��츦 �Է��� �� �ٽ� �Է¹ޱ� ���� �ݺ�
			for(int i = 0 ; i < 1; i++) 
			{
				System.out.println();
				System.out.println("�� �Žðڽ��ϱ�?");
				System.out.print("�Է� : ");	
				inputMoney = sc.nextInt();	
			
				if(inputMoney > ID.getMoney()) 
				{	
					System.out.println("������ ��� �ݾ׺��� Ů�ϴ�. �ٽ��Է����ֽʽÿ�.");
					i--;	
				}
				
			} //for - input user's bat money
		
			//���� ��ġ ����
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
			
			//���� ��ġ�� ������ ������ ���� ���� �� Ȯ���ϴ� ����
			switch(randCup - choice) 
			{	
				//����
				case 0:
					System.out.println("����Ͻʴϴ�!");
					System.out.println("+" + inputMoney * 2 + "(��)");
			
					ID.setMoney(inputMoney * 2);

					break;
				//�ٸ�
				default :
					System.out.println("����");	
					System.out.println("-" + inputMoney + "(��)");	
			
					ID.setMoney(-inputMoney);	
			
					break;
			} //switch - user result
			
			//���� �ݾ� ���
			System.out.println(ID.getName() + "���� ���ñ� : " + ID.getMoney()); 
			
			//����ڰ� �ݾ��� ��� ������� ���
			if (ID.getMoney() == 0) {
				System.out.println();
				System.out.println("��!! ��� �����ع��Ƚ��ϴ�.");	
			} 
		
			System.out.println();
			
			//�ٽ� ������ ���ϴ��� �Է¹޴� ����
			// y �Ǵ� n �̿��� ���ڸ� �Է����� �� �ٽ� �Է¹ޱ� ���� �ݺ�
			for(int i = 0; i < 1; i++) {	
				
				System.out.print("�ٽ��Ͻðڽ��ϱ�? (Y/N) : ");	
				YN = sc.next();	
				
				if(YN.equalsIgnoreCase("n") || YN.equalsIgnoreCase("y")) {	
					break;	
				}
				
				else {
					System.out.println("�ٽ� �Է����ּ���.");	
					i--;	
				}
			}
			
			if(YN.equalsIgnoreCase("y") && ID.getMoney() == 0) {	
				ID.setMoney(50000);	
				isStart= false;	
			}	
			
			if(YN.equalsIgnoreCase("n")) {	
				System.out.println();
				System.out.println("�ȳ��� ���ʽÿ�.");	
				break; 
			}	
		
		}
	}
}