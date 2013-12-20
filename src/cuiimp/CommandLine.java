package cuiimp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CommandLine {
	private int inputusedcost () {
		int aa = 0;
		int BSwitch = 1;
		do {
			try {
				BufferedReader br = new BufferedReader ( new InputStreamReader ( System.in ) );
				aa = Integer.parseInt ( br.readLine () );
			} catch ( IOException a ) {
				a.printStackTrace ();
			}
			if ( aa < 999999999 || aa == 0 ) BSwitch = 1;
			else System.out.println ( "正しい数字を入力してください もう一度入力してください" );
		} while ( BSwitch == 0 );
		return aa;
	}
	
	private int Stockinput ( String str1, List<String> stockList ) {
		new DataInput ( stockList, "C:\\Users\\yamamori\\Desktop\\" + str1 + ".dat" );
		String StockAry[] = new String[3]; //null避け
		int Costs = 0;
		for ( int i = 0; i < stockList.size () -1 ; i++ ) {
			StockAry = stockList.get ( i ).split ( ",", 3 );
			System.out.println ( i + "." + StockAry[1] + "の" + StockAry[0] + ": " + StockAry[2] + "円"  );
		}
		int BSwitch = 1;
		String str4 = null;
		do {
			try {
				BufferedReader br = new BufferedReader ( new InputStreamReader ( System.in ) );
				str4 = br.readLine ();
				StockAry = stockList.get ( Integer.parseInt ( str4 ) ).split ( ",", 3 );
				Costs = Integer.parseInt ( StockAry[2] ) ;
			} catch ( IOException a ) {
				a.printStackTrace ();
			}
			int Judge3 = Integer.parseInt ( str4 );
			if ( Judge3 < stockList.size () - 1 ) BSwitch  = 1;
			else System.out.println ( "正しい数字を入力してください もう一度入力してください" );
		} while ( BSwitch == 0 );
		BSwitch = 0;
		return Costs;
	}
	
	public CommandLine () {
		
		String str = null; //入力用変数
		String str1 = null;
		String str2 = null;
		String str3 = null;
		int BSwitch = 0; //ループ抜けスイッチ
		int Cost = 0;
		List < String > CategoryList = new ArrayList <> (); //商品のカテゴリーリスト
		List < String > CostList = new ArrayList <> ();
		List < String > StockList = new ArrayList <> ();
		
		new DataInput ( CategoryList, "C:\\Users\\yamamori\\Desktop\\CategoryList.dat" );
		
		System.out.println ( "あなたの家にある家具家電の値段を調査しています" );
		System.out.println ( "自分の家にある家具家電（なんでもよい）が新品で購入したものであった場合、そのときの購入価格を覚えている方は1を　そうでない方は2を押して、Enterをたたいてください" );
		do {
			try {
				BufferedReader br = new BufferedReader ( new InputStreamReader ( System.in ) );
				str = br.readLine ();
			} catch ( IOException a ) {
				a.printStackTrace ();
			}
			if ( str.equals ( "1" ) || str.equals ( "2" ) ) BSwitch = 1;
			else System.out.println ( "正しい数字を入力してください もう一度入力してください" );
		} while ( BSwitch == 0 );
		BSwitch = 0;
		
		System.out.println ( "入力する家具家電の種別を選んでください" );
		for ( int i = 0; i < CategoryList.size () - 1 ; i++ ) { //CatListから名前を展開
			System.out.print ( i + "." + CategoryList.get ( i )+ " " );
		}
		System.out.println ();
		do {
			try {
				BufferedReader br = new BufferedReader ( new InputStreamReader ( System.in ) );
				str1 = br.readLine ();
			} catch ( IOException a ) {
				a.printStackTrace ();
				}
			int Judge1 = Integer.parseInt ( str1 );
			if ( Judge1 < CategoryList.size () -1 ) BSwitch = 1;
			else System.out.println ( "正しい数字を入力してください もう一度入力してください" );
		} while ( BSwitch == 0 );
		BSwitch = 0;
		
		switch ( Integer.parseInt( str ) ) {
			case 1: {
				System.out.println( "選んだ家具家電の新品購入時の価格を入力してください" );
				try {
					BufferedReader br = new BufferedReader ( new InputStreamReader ( System.in ) );
					Cost = Integer.parseInt ( br.readLine () );
				} catch ( IOException a ) {
					a.printStackTrace ();
					}
			} break;
			case 2: {
				System.out.println ( "あなたの家にある" + CategoryList.get ( Integer.parseInt ( str1 ) ) + "と同じような商品を次のリストから選んで下さい" );
				System.out.println( CategoryList.get ( Integer.parseInt ( str1 ) ) + "の参考価格リスト" );
				new DataInput ( CostList, "C:\\Users\\yamamori\\Desktop\\Cost" + str1 + ".dat" );
				String CostsAry[] = new String[3]; //null避け
				for ( int i = 0; i < CostList.size () -1 ; i++ ) {
					CostsAry = CostList.get ( i ).split ( ",", 3 );
					System.out.println ( i + "." + CostsAry[1] + "の" + CostsAry[0] + ": " + CostsAry[2] + "円"  );
				}
				do {
					try {
						BufferedReader br = new BufferedReader ( new InputStreamReader ( System.in ) );
						str2 = br.readLine ();
						CostsAry = CostList.get ( Integer.parseInt ( str2 ) ).split ( ",", 3 );
						Cost = Integer.parseInt ( CostsAry[2] );
					} catch ( IOException a ) {
						a.printStackTrace ();
					}
					int Judge2 = Integer.parseInt ( str2 );
					if ( Judge2 < CostList.size () - 1 ) BSwitch = 1;
					else System.out.println ( "正しい数字を入力してください もう一度入力してください" );
				} while ( BSwitch == 0 );
				BSwitch = 0;
				
			} break;
			default: {
				System.out.println ();
			} break;
		}
		
		System.out.println ( "あなたの選んだ家具家電の種類と値段は" );
		System.out.println ( CategoryList.get ( Integer.parseInt ( str1 ) ) + " " + Cost );
		System.out.println ( "これを追加します" );
		
		File file = new File ( "C:\\kakikomi.dat" ); //書き込むファイル名
		PrintWriter pw;
		try {
			pw = new PrintWriter ( new BufferedWriter ( new FileWriter ( file, true ) ) );
			pw.println ( CategoryList.get ( Integer.parseInt ( str1 ) ) + "," + Cost + "円" );
			pw.close ();
			System.out.println ( "追加しました" );
		} catch ( IOException e ) {
			System.err.println ( "File cannot be Writed." );
		} //printlnの用意
		
		System.out.println ( "さて。　いま入力した家具・家電が家にないものとして、あなたは同じようなスペックを買うとします。" );
		System.out.println ( "それを１．型落ちの新品で、２．中古で、３．ジャンク品で、買うとしたらあなたはいくらなら支払いますか？" );
		System.out.println ( "値段がどれくらいだせるか想像できる方は1をそうでないかたは2を入力して下さい" );
		
		do {
			try {
				BufferedReader br = new BufferedReader ( new InputStreamReader ( System.in ) );
				str3 = br.readLine ();
			} catch ( IOException a ) {
				a.printStackTrace ();
			}
			if ( str3.equals ( "1" ) || str3.equals ( "2" ) ) BSwitch = 1;
			else System.out.println ( "正しい数字を入力してください もう一度入力してください" );
		} while ( BSwitch == 0 );
		int CostsAry[] = new int[3];
		switch ( Integer.parseInt( str3 ) ) {
			case 1: {
				System.out.println ( "同じスペックのものを型落ちの新品で買うとしたら、いくら支払いますか？" );
				CostsAry[0] = inputusedcost ();
				System.out.println ( "同じスペックのものを中古で買うとしたら、いくら支払いますか？" );
				CostsAry[1] = inputusedcost ();
				System.out.println ( "同じスペックのものをジャンクの状態で買うとしたら、いくら支払いますか？" );
				CostsAry[2] = inputusedcost ();
			} break;
			case 2: {
				System.out.println ( "次のリストの中から欲しいと思う新品商品を選んで下さい" );
				CostsAry[0] = Stockinput ( "New" + str1, StockList );
				System.out.println ( "次のリストの中から欲しいと思う中古商品を選んで下さい" );
				CostsAry[1] = Stockinput ( "Used" + str1, StockList );
				System.out.println ( "次のリストの中から欲しいと思うジャンク商品を選んで下さい" );
				CostsAry[2] = Stockinput ( "JUNK" + str1, StockList );
			} break;
			
			default: System.out.println (); break;		
		}
		
		System.out.println ( "あなたが選んだ" + CategoryList.get ( Integer.parseInt ( str1 ) ) + "の購入希望価格は" );
		System.out.println ( "新品：" + CostsAry[0] );
		System.out.println ( "中古：" + CostsAry[1] );
		System.out.println ( "ジャンク：" + CostsAry[2] );
		System.out.println ( "これを追加します" );
		
		file = new File ( "C:\\kakikomi.dat" ); //書き込むファイル名
		try {
			pw = new PrintWriter ( new BufferedWriter ( new FileWriter ( file, true ) ) );
			pw.println ( CostsAry[0] + "," + CostsAry[1] + "," + CostsAry[2] );
			pw.close();
			System.out.println ( "追加しました" );
		} catch ( IOException e ) {
			System.err.println ( "File cannot be Writed." );
		} //printlnの用意
				
	}
}
