package cuiimp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class DataInput {
	public DataInput( List < String > list, String filefolder ) {
		try {
			//ファイルリーダー
			 File file = new File ( filefolder );
			 BufferedReader br = new BufferedReader ( new FileReader ( file ) );
			//ここまでファイルリーダー			 
			 String str = "0" ; //読み取り用String関数 ここをヌルにすると止まる（当たり前だ）			
			//読み込みメソッド
			while ( str != null ) { //EOFをnullとして検出、それまでは読み込み続ける
				str = br.readLine ();
				list.add ( str );			
			}			
			//ここまで読み込みメソッド
			
			br.close(); //ファイルを閉じる			
		} catch ( FileNotFoundException e ) { //例外処理
			System.err.println ( e.getMessage () ); //ファイルなしの例外	
			System.exit ( 0 );
		} catch ( IOException e ) {
		    System.err.println ( e.getMessage () ); //IOエラー例外
		    System.exit ( 0 );
		}
	}
}
