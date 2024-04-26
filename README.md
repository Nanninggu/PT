# 개인 플젝입니다.

# 명명 규칙
- Package 명은 소문자로 시작하고, 소문자로만 구성한다.
- Class 명은 대문자로 시작하고, 대문자와 서문자로 구성한다.
- Method 명은 소문자로 시작하고, 대문자와 소문자로 구성한다.
- 변수 명은 소문자로 시작하고, 대문자와 소문자로 구성한다.
- API 호출 주소는 단어와 소문자_로 구성한다. ex) /api/v1/user_info
- url은 _ underbar가 아닌, 하이픈 으로 구성한다. ex) /api/v1/user-info
- 또 생각나는거 있으면 적겠음.

# 간단 기능명세는 아래와 같다.
일단 기능은 아래와 같음.
1. port and adapter 패턴으로 인터넷에서 자료를 로컬에 다운받고 해당 파일을 읽어서 패러럴하게 동작하는 기능을 만든다.
2. 역시 port and adapter 패턴으로 TCP/IP 커넥션을 통해 서버 클라이언트 구조의 기능을 만든다.
3. MSA 처럼 1개의 기능이 1개의 DB를 사용하는 구조, 그리고 1개의 기능이 2개의 DB를 사용하는 구조를 만들어보자.
~~4. h2 db의 user 테이블의 결과를 index.html 에 보여주는 코드 작성.~~ 
→ 이건 했어 TestController 의 h2_user_table() 참고
4. 그, 마음같아선 EKS 만들어서 테스트 하고 싶은데 돈 많이 드니까 로컬에서 K8S 띄워서 테스트 해보자.
5. 추가로 작성할거 정리

# 아키텍처는 아래와 같다.

- Backend Architecture
- Frontend Architecture
- Application Architecture