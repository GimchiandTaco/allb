import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Memo> memoList = new ArrayList<>();
    public static void main(String[] args) {
        Memo memo = new Memo();
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("\n1. 입력\t2. 목록보기\t3. 수정\t4. 삭제\t5. 종료");
            int selectNum = sc.nextInt();
            switch (selectNum){
                case 1:
                    System.out.println("이름을 입력해 주세요.");
                    String name = sc.next();
                    System.out.println("비밀번호를 네자리 숫자로 입력해 주세요.");
                    int password = sc.nextInt();
                    System.out.println("글 내용을 입력해 주세요.");
                    sc.nextLine();
                    String post = sc.nextLine();
                    memoList.add(new Memo(memoList.size(), name, password, post));

                    break;
                case 2:
                    String str = "\n[ 메모 목록 ]\n";
                    for (int i=0; i<memoList.size(); i++){
                        str += (memoList.get(i).id + 1) + ". " + "작성자 : \t" + memoList.get(i).name + " 작성일 : " + memoList.get(i).date;
                    }
                    System.out.println(str);
                    break;
                case 3: // 수정기능
                case 4: // 삭제기능
                case 5:
                    break;
            }
        }

    }
}