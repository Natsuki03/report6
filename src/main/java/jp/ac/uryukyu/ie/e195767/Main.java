package jp.ac.uryukyu.ie.e195767;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 特定の日付から特定の日付の差を求めるメソッド。
 */
class DifferrenceDay{
    void difDay(){
        Scanner scan = new Scanner(System.in);
        int i = 1;
        while (i > 0) {         //このwhile文は21行目のif文で分岐したときにもう一度日付の入力をさせるためのもの。24行目のwhile文も同じ働き。
            System.out.println("例に従って、初めの日付を入力してください（例:2019/01/11）");
            String Day1 = scan.nextLine();//標準出力をString型で読み込む。
            Pattern p = Pattern.compile("^[0-9]{4}/[0-9]{2}/[0-9]{2}$");//日付の正規表現。閏年や月によって日数が異なるので、簡易的になってしまっている。
            Matcher m = p.matcher(Day1);
            if (m.find() == false) {
                System.out.println("正しい日付を入力してください");
            } else {
                while (i > 0) {
                    System.out.println("例に従って、終わりの日付を入力してください（例:2019/01/11）");
                    String Day2 = scan.nextLine();
                    Pattern a = Pattern.compile("^[0-9]{4}/[0-9]{2}/[0-9]{2}$");
                    Matcher b = a.matcher(Day2);
                    if (b.find() == false) {
                        System.out.println("正しい日付を入力してください");
                    } else {
                        try {
                            SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd");//日付のフォーマット。2000/11/11のように出力される。
                            Date date1 = sdFormat.parse(Day1);
                            Date date2 = sdFormat.parse(Day2);
                            long datetime1 = date1.getTime();//Date型だった値をlong型に変換する。long型とは、日付をミリ秒に直したもの。
                            long datetime2 = date2.getTime();
                            long oneDateTime = 1000 * 60 * 60 * 24;//1日は86,400,000ミリ秒である。
                            long DifDay = (datetime2 - datetime1) / oneDateTime;
                            System.out.println(Day1+" から "+Day2+" は "+DifDay+"日後です");
                        } catch (ParseException e) {//ParseExceptionとは、SimpleDateFormatのparseメソッドを使う時に発生しうる例外。
                            e.printStackTrace();//例外処理。
                        }
                        break;
                    }
                }
                break;
            }
        }
    }
}

/**
 * AfterDayメソッドとBeforeDayメソッドの親クラス。
 */
class CalDay{
    Scanner scan = new Scanner(System.in);
    SimpleDateFormat d = new SimpleDateFormat("yyyy年MM月dd日");//日付のフォーマット。2020年01月01日のように表示される。
    Date Today = new Date();
    void calDay(){
        //サブクラスで定義
    }
}


/**
 * 現在から入力した日付後の日付を調べるメソッド。
 */
class AfterDay extends CalDay{
    @Override
    void calDay(){
        System.out.println("今日から何日後の日付が知りたいですか?日数だけを入力してください。（例：50日後が知りたい場合→50）");
        String Day1 = scan.nextLine();//標準出力をString型で読み込む。
        int addDay = Integer.parseInt(Day1);//Day1をString型からint型に変換する。
        Calendar cal = Calendar.getInstance();
        cal.setTime(Today);
        cal.add(Calendar.DATE,addDay);//ここで加算の計算が行われている。
        Date d1 = cal.getTime();//Date型に変換。
        String d2 = d.format(d1);
        System.out.println("今日から"+Day1+"日後は"+d2+"です");
    }
}


/**
 * 現在から入力した日付前の日数を調べるメソッド。やることはAfterDayメソッドと基本的には同じ。
 */
class BeforeDay extends CalDay{
    @Override
    void calDay(){
        System.out.println("今日から何日前の日付が知りたいですか?日数だけを入力してください。（例：50日前 が知りたい場合→50）");
        String Day1 = scan.nextLine();
        int addDay = Integer.parseInt(Day1);
        Calendar cal = Calendar.getInstance();
        cal.setTime(Today);
        cal.add(Calendar.DATE,-addDay);
        Date d1 = cal.getTime();
        String d2 = d.format(d1);
        System.out.println("今日から"+Day1+"日前は"+d2+"です");
    }
}

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("実行したい物を次から選んで、数字を入力してください。"+System.lineSeparator()+"1　特定の日時から特定の日時までの差を求める"+System.lineSeparator()+
                "2　今日からある日数後の日付を求める"+System.lineSeparator()+"3　今日からある日数前の日付を求める");//ユーザーが入力したコマンドを実行する。
        int command = scan.nextInt();//標準出力をint型で読み込む。
        switch(command){//標準出力の結果で、動かすメソッドを決める。
            case 1:
                DifferrenceDay difDay = new DifferrenceDay();
                difDay.difDay();
                break;
            case 2:
                AfterDay afterDay = new AfterDay();
                afterDay.calDay();
                break;
            case 3:
                BeforeDay beforeDay = new BeforeDay();
                beforeDay.calDay();
                break;
            default:
                System.out.println("提示された選択肢を選んでください");//標準出力が1,2,3以外の場合の処理。
        }
    }

}