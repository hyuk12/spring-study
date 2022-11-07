package hello.core.singleton;

public class SingletonService {

    // static 영역에 instance 를 미리 하나 생성해서 올려준다.
    private static final SingletonService instance = new SingletonService();

    // 조회 : 이 객체 인스턴스가 필요하면 오직 getInstance 메서드를 이용해서만 조회할 수 있다.
    public static SingletonService getInstance(){
        return instance;
    }

    // private 로막아서 혹시라도 외부에서 new 키워드로 객체 인스턴스가 생성 되는 것을 막아준다. 중요함!!
    private SingletonService(){

    }
    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
