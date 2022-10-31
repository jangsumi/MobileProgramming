# 모바일 프로그래밍 개인 과제
**국민대학교 2022년 2학기 모바일 프로그래밍 수업 개인 과제** <br />
- 국민대학교 소프트웨어융합대학 소프트웨어학부
- 20193216 장수미

**개발환경 및 실행 환경** <br />
- 개발 환경
  - Android Studio 11.0.12

- 실행 환경
  - Pixel 2 API 30
  - 내부저장소 접근

<br /><br />

## 애플리케이션 설명
**총 3개의 화면으로 구성된 안드로이드 애플리케이션**
- 로그인 페이지(activity_login)
- 회원가입 페이지(activity_join)
- 상품 페이지(activity_product)

<br /><br />

## 상세페이지 설명
### 로그인 페이지(activity_login) <br />
  앱 구동 시 가장 먼저 뜨는 페이지이다. <br />
  로그인, 회원가입, 비회원으로 쇼핑 중 선택할 수 있다. <br />
  
  **로그인 기능 동작**
  - 로그인은 내부저장소에 있는 JoinInfo.xml의 정보와 일치하는지 확인하여 작동한다. <br />
  - 없는 아이디가 입력되거나, 비밀번호가 일치하지 않으면 “로그인 실패” 토스트 메세지가 뜬다. <br />
  - 아이디 혹은 비밀번호가 입력되지 않으면 “로그인 실패” 토스트 메세지가 뜬다. <br />
  - 아이디와 비밀번호가 일치하면 3번째 페이지인 상품 페이지로 이동한다. <br />

<br />

### 회원가입 페이지 (activity_join)<br />
  회원가입 버튼을 누르면 회원가입 페이지로 이동한다<br />
  
  **회원가입 기능 동작**
  1. 입력과 저장
  - 아이디, 비밀번호의 입력과 약관 동의는 필수이며 이름, 전화번호, 주소는 선택사항이다.<br />
  - 문자는 영어만 입력 가능하다.<br />
  - 조건에 맞게 입력하였을 경우 내부저장소에 있는 JoinInfo.xml에 저장한다.<br />
  2. 아이디
  - 아이디는 확인 버튼을 통해 중복을 필수적으로 확인해야 한다. <br />
  - 이미 존재하는 아이디의 경우 “아이디가 중복입니다”라는 오류 메세지가 뜨고, 사용 가능한 아이디일 경우 아무런 변화도 나타나지 않는다.<br />
  - 아이디 중복확인을 한 후, 아이디를 다시 변경할 경우 다시 중복을 확인해야한다. <br />
  - 즉, 확인버튼을 눌렀을 시의 입력된 아이디와 회원가입 버튼을 클릭했을 때의 입력된 아이디가 다를 경우 오류 메세지가 출력된다. <br />
  3. 비밀번호
  - 비밀번호는 8~15자리이내로 영어, 숫자, 특수문자를 모두 포함해야한다.<br />
  - 비밀번호 규칙을 지키지 않으면 회원가입 버튼을 눌렀을 때 “특수문자 포함 8-15자 이내로 설정하세요.” 오류 메세지가 출력된다. <br />
  - 사용 가능한 비밀번호를 입력한 경우 아무런 변화도 나타나지 않는다.<br />
  4. 약관
  - 개인정보 약관에 동의합니다. 버튼을 눌렀을때만 회원가입이 가능하다.<br />
  - 아무 버튼도 클릭하지 않거나, 동의하지 않습니다.를 클릭한 경우 “약관에 동의해주세요.” 토스트 메세지가 뜬다.<br />
  

<br />

### 상품 페이지(activity_product) <br />
  로그인을 하거나 비회원으로 쇼핑 버튼을 클릭하면 상품 페이지로 이동한다.<br />
  1. 상품 레이아웃
  - 기본적으로 총 9개의 상품이 출력되며 이는 스크롤뷰를 통해 확인할 수 있다.<br />
  - 상품의 구성은 다음과 같다. (상품의 번호 : 상품명)<br />
      1: 초록 카라티<br />
      2: 검정 블루종<br />
      3: 남색 카라티<br />
      4: 회색 맨투맨<br />
      5: 검정 기본티<br />
      6: 검정 가디건<br />
      7: 진녹색 패딩<br />
      8: 검정 털집업<br />
      9: 검정 무스탕<br />
  2. 회원 정보
  - 하단의 회원정보 버튼을 클릭할 경우 alert dialog가 출력된다. <br />
    1) 로그인한 경우<br />
    - 회원가입시 작성된 이름, 전화번호, 주소를 보여준다.<br />
    - 만약 회원가입시에 공백으로 둔 항목이 있다면 그 부분은 공백으로 출력된다.<br />
    - 닫기버튼을 누르면 다시 3번째 페이지를 보여준다.<br />
    2) 비회원인 경우<br />
    - 로그인 시 이용할 수 있는 서비스입니다. 회원가입하시겠습니까? 라는 문구가 뜬다<br />
    - 회원가입하기 버튼을 누르면 2번째 페이지인 회원가입 페이지로 이동한다.<br />
    - 이동 후 뒤로가기를 누르면 상품 페이지로 돌아온다<br />
    - 닫기버튼을 누르면 다시 3번째 페이지를 보여준다.<br />
  3. 상품 관리
  - 상품관리 버튼을 클릭할 경우 alert dialog가 출력된다. <br />
    1) 상품 추가 선택시 <br />
    - 마지막 상품의 다음 위치에 회색 후드티가 “새로운 상품” 이라는 상품명으로 추가된다.<br />
    - 만약 상품추가 전 총 상품이 9개였을 때, 새롭게 추가된 상품의 번호는 10이다.<br />
    2) 상품 삭제 선택시<br />
    - 삭제할 상품의 번호를 입력하세요. 라는 문구와 텍스트를 입력 칸이 있는 새로운 alert dialog가 출력된다. <br />
    - (초기 상태에서) 1을 입력하면 첫번째 상품인 "초록 카라티"가 사라진다.<br />
    - 1보다 작은 값, 총 상품의 개수보다 큰 값, 숫자가 아닌 값이 입력될 경우 아무 변화도 일어나지 않는다.<br />


