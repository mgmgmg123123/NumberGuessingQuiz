package logic;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MainLogic {

	public static void main(String[] args) {


		//候補の数
		int CandidateNumber = 5;

	    //答えの数字の桁数
	    int AnswerLength = 3;

	    //時間測定用変数
	    long start = System.currentTimeMillis();

	    //答え格納用リスト
	    ArrayList<Integer> Answer = new ArrayList<Integer>();

	    //答え決定時に利用するリスト
	    ArrayList<Integer> AnswerCandidate = new ArrayList<Integer>();

	    System.out.println("HeroTraining!");
	    System.out.println("1から" + CandidateNumber + "までの数字のうち"+ AnswerLength + "個の数字とその位置を当てよう！");

	    //答えとなる数字を作る
	    //１～候補の数までリストに入れる
	    for(int i=0;i<CandidateNumber;i++)
	    {
	    	AnswerCandidate.add(i+1);
	    }

        //Randomクラスのインスタンス化
        Random rnd = new Random();

        for(int i = 0;i < AnswerLength;i++) {

            //リストの前から何番目を答えにするか決める
            int ran = rnd.nextInt(AnswerCandidate.size());

            //選ばれたものを答えとして答えリストに追加
            Answer.add(AnswerCandidate.get(ran));

            //出たものを答えの候補リストから削除
            AnswerCandidate.remove(ran);

        }

        /*テスト用
        for(int i=0;i<Answer.size();i++) {
            System.out.print(Answer.get(i));
            System.out.print(" ");
        }
        System.out.println(" ");
      */

        while(true){
        	//惜しい、正しい数初期化
        	int correct = 0;
        	int Regrettable = 0;
        	
    	    //入力されたものを保持するリスト
    	    ArrayList<Integer> Input = new ArrayList<Integer>();

        	System.out.println(AnswerLength+"桁の数字を空白区切りで入力してください。");


        	Scanner scan = new Scanner(System.in);

        	//正解の桁数だけ入力されたものをリストへ
        	for(int i =0;i<AnswerLength;i++) {
                int inputNumber = scan.nextInt();
                Input.add(inputNumber);
        	}

        	//場所、数ともに正しいものを算出
        	for(int i =0;i<AnswerLength;i++) {

        		if(Answer.get(i) == Input.get(i)) {
        			correct++;
        		}
        	}

        	//数が一致するものを出す
        	for(int i =0;i<AnswerLength;i++) {

        		for(int j = 0;j<AnswerLength;j++)
        		{
        			if(Input.get(i)==Answer.get(j))
        			{
        				Regrettable++;
        			}
        		}
        	}

        	//おしい！を算出
        	Regrettable = Regrettable - correct;
        	if(Regrettable<correct) {
        		Regrettable = 0;
        	}

        	
        	System.out.println("おしい！:"+Regrettable);
        	System.out.println("正解！:"+correct);

        	/*テスト用
        	System.out.print("入力");
        	for(int i =0;i<AnswerLength;i++) {
        		System.out.print(Input.get(i));
        	}
        	System.out.println("");
        	System.out.print("答え");
        	for(int i =0;i<AnswerLength;i++) {
        		System.out.print(Answer.get(i));
        	}
        	System.out.println("");*/
        	
        	
        	//すべて数、場所が正しい時にbreak
        	if(Answer.size()==correct) {
        		scan.close();
        		break;
        	}
        }

 	   long end = System.currentTimeMillis();
       System.out.println("クリアです！おめでとうございます！");
       System.out.println("あなたののタイムは"+(end-start)/1000 +"秒です。");
	}
}