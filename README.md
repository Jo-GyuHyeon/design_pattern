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

객체 생성 개수 제한 하기

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

Test code 사용 예시

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

생성자 문제점과 해결, 쓰레드 사용시 문제점 파악하기

- 생성자를 priavte로 막아 둔다.
- 생성을 하기 위해 생성 유틸리티 메서드를 사용한다.
- 아래의 코드 중 생성자 메서드는 실제 DB 커넥션을 하는 것 처럼 효과를 주기 위함이다.
      public class Database {
          private static Database singleton;
          private String name;
      
      //    public Database(String name) {
      //        super();
      //        this.name = name;
      //    }
          
          private Database(String name) {
              try {
                  Thread.sleep(100);
                  this.name = name;
              } catch (Exception e) {
                  e.printStackTrace();
              }
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

Test code 사용 예시

- for 문으로 생성된 객체는 거의 동시에 실행한 효과와 같다. 그렇기 때문에 sigleton 객체는 null로 인식하여 전부 인스턴스를 생성한다.
- 생성 순서는 랜덤으로 메모리에 로드되는 순서대로 생성된다.
- 이 처럼 싱글턴은 스레드에 취약점을 가지고 있다.
      public class TestPattern2 {
      
          static int nNUm = 0;
      
          public static void main(String[] args) {
              Runnable task = () -> {
                  try {
                      nNUm++;
                      Database database = Database.getInstance(nNUm + "번째 Database");
                      System.out.println("This is the " + database.getName());
      
                  } catch (Exception e) {
                      e.getStackTrace();
                  }
              };
      
              for (int i = 0; i < 10; i++) {
                  Thread t = new Thread(task);
                  t.start();
              }
          }
      }

쓰레드 사용시 문제점 해결 1

- synchronized 예약어를 사용하여 동기화 처리
- 단점: synchronized 는 비용이 비싸다.
- 스레드를 한줄로 세워서 순서대로 처리 해야 되기 때문에 병목현상이 일어 한다.
- Database 클래스 중 getInstance() 코드 예시
      public class Database {
          private static Database singleton;
          private String name;
      
          private Database(String name) {
              try {
                  Thread.sleep(100);
                  this.name = name;
              } catch (Exception e) {
                  e.printStackTrace();
              }
          }
      
          public synchronized static Database getInstance(String name) {
              if (singleton == null) {
                  singleton = new Database(name);
              }
              return singleton;
          }
      
          public String getName() {
              return name;
          }
      }

쓰레드 사용시 문제점 해결 2

- Static 키워드는 프로그램이 실행되면 제일 먼저 메모리에 로드 된다는 특성을 가지고 있다.
- Static 키워드의 특성을 잘 활용한다. - 생성자 생성 x  직접 생성 o
      public class Database {
          private static Database singleton = new Database("product");
          private String name;
          private Database(String name) {
              try {
                  Thread.sleep(100);
                  this.name = name;
              } catch (Exception e) {
                  e.printStackTrace();
              }
          }
      
          public static Database getInstance(String name) {
               return singleton;
          }
      
          public String getName() {
              return name;
          }
      }

싱글턴 패턴을 이용한 예제 - 로그 객체

    import java.io.BufferedWriter;
    import java.io.FileWriter;
    import java.time.LocalDateTime;
    
    public class LogWriter {
        private static LogWriter singleton = new LogWriter();
        private static BufferedWriter bw;
    
        private LogWriter() {
            try {
                bw = new BufferedWriter(new FileWriter("log.txt"));
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    
        public static LogWriter getInstance() {
            return singleton;
        }
    
        public synchronized void log(String str) {
            try {
     **           bw.write(LocalDateTime.now() + " : " + str + "\n");
                bw.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    
        @Override
        protected void finalize() {
            try {
                super.finalize();
                bw.close();
            } catch (Throwable ex) {
                ex.printStackTrace();
            }
        }
    }

Test code 사용 예시

    public class TestPattern1 {
        public static void main(String[] args) {
            LogWriter loggger;
    
            loggger = LogWriter.getInstance();
            loggger.log("홍길동");
    
            loggger = LogWriter.getInstance();
            loggger.log("전우치");
        }
    }
    
    //    웹 상의 많은 페이지를 동시에 열어 본다는 것은 쓰레드에서 동시에 메서드를 호출하는 것과 동일 하다.
    public class TestPattern2 {
        public static void main(String[] args) {
            for (int i = 0; i < 50; i++) {
    //            쓰레드 마다 구분되는 로그 작성용 파라미터
                Thread thread = new ThreadSub(i);
                thread.start();
            }
        }
    }
    
    //    외부 클래스
    class ThreadSub extends Thread {
        int num;
    
        public ThreadSub(int num) {
            this.num = num;
        }
    
        @Override
        public void run() {
            LogWriter logger = LogWriter.getInstance();
            if (num < 10) {
                logger.log("*** 0" + num + "***");
            } else {
                logger.log("*** " + num + "***");
    
            }
        }
    }

- TestPattern2 은 실제 여러 스레드가 동시에 접근하더라도 synchronized 예약어를 통해 겹치지 않고 각자 실행이 잘 이루어 진다.
- 하지만 실행 순서는 보장되지 않는다. (실행 순서를 확인하기 위해 실행 순서 num 변수 사용)
