# JH_HeathCare 01

불규칙적인 식습관, 운동부족으로 인한 체력저하를 방지/관리하여 건강을 유지하는데 도움이 되는 **헬스 케어북**을 만들어 보았습니다.

# information

  JAVA를 사용한 윈도우 응용프로그램입니다.

  \HealthCare_01\src\main\MainApp.java 을 통해 실행합니다.
  
  
  Build path -> Configue Build path
  Api folder 'mysql-connector-java-8.0.18.jar' 버전확인 필요
  ID password 체크
  
  main ScreenShot
  ---------------------
  ![ex_screenshot](/ScreenShot/main.jpg)
  
  * 게스트 로그인과  회원가입 , 로그인을 구현 
  * 로그인을 하면 전 메뉴가 이용 가능합니다.
  * 게스트 로그인시 DB에 저장하는 기능은 사용할수 없도록 하였습니다. (Guest id로 로그인 되도록)
  
  Alram ScreenShot
  ---------------------
  ![ex_screenshot](/ScreenShot/IDChack.jpg)
  
  * DB에 있는 usertbl에 Uid를 검색해서 검색된 것이 있으면 사용불가를 검색된것이 없으면 사용가능을 label로 출력합니다.
  
  ![ex_screenshot](/ScreenShot/empty.jpg)
  
  * login (ID,PassWord),register (ID,PassWord,PassWord Conform,Name) 페이지에서 빈칸이 존재하면 alram popup을 출력하여 나타내도록 합니다. 
  
  Section ScreenShot
  ---------------------
  Ex Section
  
  ![ex_screenshot](/ScreenShot/excercise.jpg)
  
  * Bmi 계산과 운동을 선택하여 add 버튼으로 추가 del 버튼으로 제거 
  * Save를 선택시 DB에 저장됨 userinfomation table
  * userinformation table =  
	  Userid 아이디, 
	  Uweight 몸무게, 
	  Uheight 키, 
	  Ubmi BMI, 
	  Uinputdate 입력된 시간 
  
  Food Section
  
  ![ex_screenshot](/ScreenShot/foodsection.jpg)
  
  * menu 버튼을 통해서 음식의 종류를 선택하고 add 버튼으로 추가 del 버튼으로 제거
  
  Memo Section
  
  ![ex_screenshot](/ScreenShot/Memo.jpg)
  
  * 전체적인 내용에 대해서 간략적으로 표시 DB에 저장된 데이터가 없을 시 0으로 표시
  * 구현중 - 비밀번호 바꾸기
  
    ---------------------
* 현재 문제점  


로그인화면에서 회원가입창으로 이동이 가능하나 취소후 다시 이동할때 문제가 발생 (Exception)

* 추가 구현 예정


  
  
2019-12-12

mainscreen image simple manual

AmountEx - savebutton sqldb connect

Barchart updating..

Memo section update and password change Implementing

ex소개 webview "https://terms.naver.com/list.nhn?cid=51032&categoryId=51032" connect

DB table weight height bmi write
  
  
  
  
