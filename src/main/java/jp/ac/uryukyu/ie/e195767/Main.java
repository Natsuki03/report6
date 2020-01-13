package jp.ac.uryukyu.ie.e195767;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

public class Main {

}