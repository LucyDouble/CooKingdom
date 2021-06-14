# CooKingdom, 요리 레시피 검색과 밀키트 구매를 한번에
## [시연 영상 바로 보기](https://youtu.be/ZX5bDemHHXQ) 
##### 팀원 : 강수목, 고현민(조장), 곽서현, 김세훈, 박준태
---
## Contents
1. 프로젝트 소개
2. [설계의 주안점](#설계의-주안점)
3. 개발환경
4. [프로젝트 기능구현](#프로젝트-기능구현)
5. 주요기능
6. Document
---
## 프로젝트 소개
- 레시피 정보 공유 및 밀키트 판매 서비스
- 코로나로 인해 외식이 어려워지는 상황에서 요리를 직접하고자 하는 사람들의 욕구 증가
- 레시피를 직접 보고도 요리하기가 어려운 경우 바로 밀키트를 구매할 수 있도록하는 편의서비스 제공

---
## 설계의 주안점


---
## 개발환경


|Category|Detail|
|:--:|:--:|
|FrontEnd|HTML5, JS, CSS3, JQuery|
|BackEnd|Java(JDK 1.8), Servlet|
|OS|Windows 10, MacOS|
|Libray&API|Apache Commons FileUpload, Imgscalr|
|IDE|Eclipse, VisualStudio|
|Server|Tomcat(v8.5)|
|Document|Google Drive, KakaoOven, ERDCloud, diagrams.net|
|CI|Github|
|DateBase|SQL Developer, Oracle(11g)|

Java, JSP/Servlets, JavaScript, jQuery, Oracle, GitHub, Apache Tomcat

---
## 프로젝트 기능구현
•	책임자, 관리자, 사용자 로그인 및 회원가입 기능
•	레시피 목록 조회, 레시피 정보 조회, 등록, 수정, 삭제 기능
•	리뷰 목록 조회, 리뷰 정보 조회, 등록, 수정, 삭제 기능
•	댓글 목록 조회, 등록, 수정, 삭제 기능
•	장바구니 조회, 등록, 삭제 기능
•	주문 목록 조회, 등록, 수정, 삭제 기능

---
## 주요기능

---
## Document

<h2>메인페이지 실행</h2><br>
  src/ckd/Main.java <br>
  <hr>
  <h2>테이블정의 sql</h2><br>
  WebContent/cookingdom.sql<br>
  <hr>
<h2>JSON 생성</h2><br>
  WebContent/json/jsonindex.jsp  (각 버튼 눌러서 json파일 생성 alert메시지 확인해야함)
