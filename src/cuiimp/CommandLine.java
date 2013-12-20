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
			else System.out.println ( "��������������͂��Ă������� ������x���͂��Ă�������" );
		} while ( BSwitch == 0 );
		return aa;
	}
	
	private int Stockinput ( String str1, List<String> stockList ) {
		new DataInput ( stockList, "C:\\Users\\yamamori\\Desktop\\" + str1 + ".dat" );
		String StockAry[] = new String[3]; //null����
		int Costs = 0;
		for ( int i = 0; i < stockList.size () -1 ; i++ ) {
			StockAry = stockList.get ( i ).split ( ",", 3 );
			System.out.println ( i + "." + StockAry[1] + "��" + StockAry[0] + ": " + StockAry[2] + "�~"  );
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
			else System.out.println ( "��������������͂��Ă������� ������x���͂��Ă�������" );
		} while ( BSwitch == 0 );
		BSwitch = 0;
		return Costs;
	}
	
	public CommandLine () {
		
		String str = null; //���͗p�ϐ�
		String str1 = null;
		String str2 = null;
		String str3 = null;
		int BSwitch = 0; //���[�v�����X�C�b�`
		int Cost = 0;
		List < String > CategoryList = new ArrayList <> (); //���i�̃J�e�S���[���X�g
		List < String > CostList = new ArrayList <> ();
		List < String > StockList = new ArrayList <> ();
		
		new DataInput ( CategoryList, "C:\\Users\\yamamori\\Desktop\\CategoryList.dat" );
		
		System.out.println ( "���Ȃ��̉Ƃɂ���Ƌ�Ɠd�̒l�i�𒲍����Ă��܂�" );
		System.out.println ( "�����̉Ƃɂ���Ƌ�Ɠd�i�Ȃ�ł��悢�j���V�i�ōw���������̂ł������ꍇ�A���̂Ƃ��̍w�����i���o���Ă������1���@�����łȂ�����2�������āAEnter���������Ă�������" );
		do {
			try {
				BufferedReader br = new BufferedReader ( new InputStreamReader ( System.in ) );
				str = br.readLine ();
			} catch ( IOException a ) {
				a.printStackTrace ();
			}
			if ( str.equals ( "1" ) || str.equals ( "2" ) ) BSwitch = 1;
			else System.out.println ( "��������������͂��Ă������� ������x���͂��Ă�������" );
		} while ( BSwitch == 0 );
		BSwitch = 0;
		
		System.out.println ( "���͂���Ƌ�Ɠd�̎�ʂ�I��ł�������" );
		for ( int i = 0; i < CategoryList.size () - 1 ; i++ ) { //CatList���疼�O��W�J
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
			else System.out.println ( "��������������͂��Ă������� ������x���͂��Ă�������" );
		} while ( BSwitch == 0 );
		BSwitch = 0;
		
		switch ( Integer.parseInt( str ) ) {
			case 1: {
				System.out.println( "�I�񂾉Ƌ�Ɠd�̐V�i�w�����̉��i����͂��Ă�������" );
				try {
					BufferedReader br = new BufferedReader ( new InputStreamReader ( System.in ) );
					Cost = Integer.parseInt ( br.readLine () );
				} catch ( IOException a ) {
					a.printStackTrace ();
					}
			} break;
			case 2: {
				System.out.println ( "���Ȃ��̉Ƃɂ���" + CategoryList.get ( Integer.parseInt ( str1 ) ) + "�Ɠ����悤�ȏ��i�����̃��X�g����I��ŉ�����" );
				System.out.println( CategoryList.get ( Integer.parseInt ( str1 ) ) + "�̎Q�l���i���X�g" );
				new DataInput ( CostList, "C:\\Users\\yamamori\\Desktop\\Cost" + str1 + ".dat" );
				String CostsAry[] = new String[3]; //null����
				for ( int i = 0; i < CostList.size () -1 ; i++ ) {
					CostsAry = CostList.get ( i ).split ( ",", 3 );
					System.out.println ( i + "." + CostsAry[1] + "��" + CostsAry[0] + ": " + CostsAry[2] + "�~"  );
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
					else System.out.println ( "��������������͂��Ă������� ������x���͂��Ă�������" );
				} while ( BSwitch == 0 );
				BSwitch = 0;
				
			} break;
			default: {
				System.out.println ();
			} break;
		}
		
		System.out.println ( "���Ȃ��̑I�񂾉Ƌ�Ɠd�̎�ނƒl�i��" );
		System.out.println ( CategoryList.get ( Integer.parseInt ( str1 ) ) + " " + Cost );
		System.out.println ( "�����ǉ����܂�" );
		
		File file = new File ( "C:\\kakikomi.dat" ); //�������ރt�@�C����
		PrintWriter pw;
		try {
			pw = new PrintWriter ( new BufferedWriter ( new FileWriter ( file, true ) ) );
			pw.println ( CategoryList.get ( Integer.parseInt ( str1 ) ) + "," + Cost + "�~" );
			pw.close ();
			System.out.println ( "�ǉ����܂���" );
		} catch ( IOException e ) {
			System.err.println ( "File cannot be Writed." );
		} //println�̗p��
		
		System.out.println ( "���āB�@���ܓ��͂����Ƌ�E�Ɠd���ƂɂȂ����̂Ƃ��āA���Ȃ��͓����悤�ȃX�y�b�N�𔃂��Ƃ��܂��B" );
		System.out.println ( "������P�D�^�����̐V�i�ŁA�Q�D���ÂŁA�R�D�W�����N�i�ŁA�����Ƃ����炠�Ȃ��͂�����Ȃ�x�����܂����H" );
		System.out.println ( "�l�i���ǂꂭ�炢�����邩�z���ł������1�������łȂ�������2����͂��ĉ�����" );
		
		do {
			try {
				BufferedReader br = new BufferedReader ( new InputStreamReader ( System.in ) );
				str3 = br.readLine ();
			} catch ( IOException a ) {
				a.printStackTrace ();
			}
			if ( str3.equals ( "1" ) || str3.equals ( "2" ) ) BSwitch = 1;
			else System.out.println ( "��������������͂��Ă������� ������x���͂��Ă�������" );
		} while ( BSwitch == 0 );
		int CostsAry[] = new int[3];
		switch ( Integer.parseInt( str3 ) ) {
			case 1: {
				System.out.println ( "�����X�y�b�N�̂��̂��^�����̐V�i�Ŕ����Ƃ�����A������x�����܂����H" );
				CostsAry[0] = inputusedcost ();
				System.out.println ( "�����X�y�b�N�̂��̂𒆌ÂŔ����Ƃ�����A������x�����܂����H" );
				CostsAry[1] = inputusedcost ();
				System.out.println ( "�����X�y�b�N�̂��̂��W�����N�̏�ԂŔ����Ƃ�����A������x�����܂����H" );
				CostsAry[2] = inputusedcost ();
			} break;
			case 2: {
				System.out.println ( "���̃��X�g�̒�����~�����Ǝv���V�i���i��I��ŉ�����" );
				CostsAry[0] = Stockinput ( "New" + str1, StockList );
				System.out.println ( "���̃��X�g�̒�����~�����Ǝv�����Ï��i��I��ŉ�����" );
				CostsAry[1] = Stockinput ( "Used" + str1, StockList );
				System.out.println ( "���̃��X�g�̒�����~�����Ǝv���W�����N���i��I��ŉ�����" );
				CostsAry[2] = Stockinput ( "JUNK" + str1, StockList );
			} break;
			
			default: System.out.println (); break;		
		}
		
		System.out.println ( "���Ȃ����I��" + CategoryList.get ( Integer.parseInt ( str1 ) ) + "�̍w����]���i��" );
		System.out.println ( "�V�i�F" + CostsAry[0] );
		System.out.println ( "���ÁF" + CostsAry[1] );
		System.out.println ( "�W�����N�F" + CostsAry[2] );
		System.out.println ( "�����ǉ����܂�" );
		
		file = new File ( "C:\\kakikomi.dat" ); //�������ރt�@�C����
		try {
			pw = new PrintWriter ( new BufferedWriter ( new FileWriter ( file, true ) ) );
			pw.println ( CostsAry[0] + "," + CostsAry[1] + "," + CostsAry[2] );
			pw.close();
			System.out.println ( "�ǉ����܂���" );
		} catch ( IOException e ) {
			System.err.println ( "File cannot be Writed." );
		} //println�̗p��
				
	}
}
