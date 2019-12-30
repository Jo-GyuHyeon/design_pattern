# java design pattern

# DI(dependency Injection)

## 객체를 사용하는 두가지 방법

1. A객체가 B/C 객체를 직접 생성한다.

        public class A {
        	private B b = new B();
        	private C c = new C();
        }

    a는 갑 b,c는 을

    a가 b,c를 사용하기도 하지만 b,c에 의존 하기도 한다.

    객체 간의 의존 관계에서 직접 생성 하면 생성 부터 메모리 관리를 위한 소멸까지 해당 객체의 라이프 사이클을 개발자가 직접 관리 해주어야 됨으로 객체 간 강한 결합이다

2. B/C 객체가 외부에 생성되어 A객체에 주입된다.

        public class A {
         	private B b;
        	private C c;
        
        	public A (B b, C c) {
        		this.b = b;
        		this.c = c;
        	}
        //or
        	public void setb(B b){
        		this.b = b;
        	}
        
        	public void setC(C c){
        		this.c = c;
        	}
        }

    a가 을 bc를 가지고, 있는 곳이 갑

    a가  b,c기능이 필요하면 갑이 a에게 bc의 기능을 주입 시켜주는 구조이다.

    이미 누군가가  생성한 객체를 주입 받아 사용만 하면 됨으로 약한 결합이다.

    객체 지향에서 약한 결합, 느슨한 결합을 사용하면 개발자가 관리 할 것이 작아진다는 장점이 있다.

        package di;
        
        import java.util.Date;
        
        public class UnderstandDI {
            public static void main(String[] args) {
                Date date = new Date();
                System.out.println(date);
            }
        
            public static void getDate(Date d) {
                Date date = d;
                System.out.println(date);
            }
        
            public static void memberUser1() {
        //        강한 결합 : 직접 생성
                Member m1 = new Member();
        //        억지스럽지만 Member 클래스의 생성자 메서드를 private 으로 변경하면 문제가 생긴다
        //        이와 반대로 약한 겷합은 안전하고 유연하게 대체 가능하다
            }
        
            public static void memberUser2(Member m) {
        //        약한 결합 : 생성된 것을 주입 받음 - 의존 주입 (Dependency Injection)
                Member m2 = m;
            }
        }
        
        //    Member를 사용한다.-->Member의 기능에 의존한다 라는 의미
        class Member {
            String name;
            String nickname;
        
            public Member() {
        
            }
        //    private Member() {
        //    }
        }
# 싱글턴 패턴

객체가 너무 많아지면 컴퓨터 자원을 과도하게 사용하게 되고, 이는 프로그램 전체의 속도를 느리게 할 수 있다.

→ 개발자는 객체의 최대 개수를 제한할 필요가 생긴다.

싱글턴 패턴 : 최대 N개로 객체 생성을 제한하는 패턴

→ 여기서 중요한 것은 생성되는 객체의 최대 개수를 제한하는 데 있어 객체의 생성을 요청하는 쪽에서는 일일이 신경쓰지 않아도 되도록 만들어주는 것이다.

## 사용 예

일반 자바 프로그래밍

- 데이터베이스 컨넥션 풀
- 로그 라이터

게임 프로그래밍

- 사운드 매니저
- 스코어 매니저

### Test code

      public class Database {
          private static Database singleton;
          private String name;
      
          public Database(String name) {
              super();
              this.name = name;
          }
      
          public static Database getInstance(String name) {
              if (singleton == null) {
                  singleton = new Database(name);
              }
              return singleton;
          }
      
          public String getName() {
              return name;
          }
      }

  ### Test code 사용 예시

      public class TestPattern1 {
      
          public static void main(String[] args) {
              Database database;
              database = Database.getInstance("첫 번째");
              System.out.println("database.getName() = " + database.getName());
      
              database = Database.getInstance("두 번째");
              System.out.println("database.getName() = " + database.getName());
      
              Database d1 = new Database("1");
              Database d2 = new Database("2");
              Database d3 = new Database("3");
              Database d4 = new Database("4");
              Database d5 = new Database("5");
              Database d6 = new Database("6");
      
              System.out.println("database use");
          }
      }

- 
