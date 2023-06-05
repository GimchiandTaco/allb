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
                    for (int i = 0; i < memoList.size(); i++) {
                        Memo a = memoList.get(i);
                        str += (i + 1) + ". " + "작성자: " + a.getName() + " 작성일: " + a.getDate() + "\n";
                    }
                    System.out.println(str);
                    break;

                case 3: // 수정기능
                    System.out.println("수정할 메모 번호를 입력해주세요.");
                    int updateMemoId = sc.nextInt();
                    String prevPost = "";
                    if(memoList.get(updateMemoId-1) != null){
                        System.out.println("비밀번호를 입력해 주세요.");
                        int pass = sc.nextInt();
                        if(memoList.get(updateMemoId-1).password == pass){
                            prevPost = memoList.get(updateMemoId-1).post;
                            System.out.println(prevPost);
                            System.out.println("수정할 내용을 입력해주세요.");
                            sc.nextLine();
                            String updatePost = sc.nextLine();
                            memoList.get(updateMemoId-1).setPost(updatePost);
                            System.out.println("수정이 완료되었습니다.");
                        } else {
                            System.out.println("비밀번호가 일치하지 않습니다.");
                        }
                    } else {
                        System.out.println("번호를 잘못입력하셨습니다.");
                    }
                    break;

                case 4: // 삭제기능
                    System.out.println("삭제할 글 번호를 입력해주세요");
                    int deleteId = sc.nextInt();
                    boolean found = false;

                    for (int i = 0; i < memoList.size(); i++) {
                        Memo m = memoList.get(i);
                        if (m.getId() == deleteId - 1) {
                            System.out.println("비밀번호를 입력해주세요");
                            int deletePassword = sc.nextInt();
                            if (deletePassword == m.getPassword()) {
                                memoList.remove(i);
                                System.out.println("작성글 번호" + deleteId + " 삭제처리 되었습니다.");
                                found = true;
                                break;
                            } else {
                                System.out.println("비밀번호가 일치하지 않습니다.");
                                break;
                            }
                        }
                    }

                    if (!found) {
                        System.out.println("해당 글은 존재하지 않습니다.");
                    }
                    break;
                case 5:
                    // 종료
                    return;
            }
        }
    }
}


