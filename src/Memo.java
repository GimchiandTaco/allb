//- 메모 클래스 (MemoVO, Memo)
//        - 메모 한 건에 대한 정보를 가진 클래스
//        - 메모는 글 번호, 작성자 이름, 비밀번호, 게시글, 작성일(컴퓨터 시스템의 날짜와 시간을 자동으로 저장) 가지고 있다.
//        - 글의 수정 시, 수정 시간으로 시간이 변경된다.

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Memo {
    int id; // 글 번호
    String name;
    int password;
    String post; // 글 내용
    String date;

    Memo(){

    }

    Memo(int id, String name, int password, String post){
        this.id = id;
        this.password = password;
        this.name = name;
        this.post = post;
        this.date = setDate();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getPost() {
        return post;
    }

    public String getDate(){
        return this.date;
    }
    String setDate(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(dateTimeFormatter);
    }

    @Override
    public String toString() {
        String str = "";
        str += "\n글 번호 : " + this.id + "\t작성시간 : " + this.date;
        str += "\n작성자 : " + this.name;
        str += "\n글내용 : " + this.post;
        return str;
    }
}
