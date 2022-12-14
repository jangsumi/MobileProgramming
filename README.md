# 모바일 프로그래밍 개인 과제
**국민대학교 2022년 2학기 모바일 프로그래밍 수업 개인 과제** <br />
- 국민대학교 소프트웨어융합대학 소프트웨어학부
- 20193216 장수미
<br />
**개발환경 및 실행 환경** <br />
- 개발 환경
  - Android Studio Chipmunk | 2021.2.1 Patch 2
  - VM: OpenJDK 64-Bit Server VM by JetBrains s.r.o.
  - macOS 12.1

- 실행 환경
  - Pixel 2 API 30
  - 내부저장소 접근 `data/data/com.example.myassignment/shared_prefs/JoinInfo.xml`
  
  <br />
  
**설치 후 실행**
  - GitHub Repository에 최상단에 위치한 app-debug.apk로 설치 가능
  - Github Repository를 Clone한 뒤, Android Studio에서 Run 'app' 버튼 클릭하여 실행 가능
  
  <br />
  
**빌드 시 유의사항**
  - 뷰 결합(View Binding) 설정
    - findViewById 대신 뷰 결합(View Binding) 사용함
    - 사용 설정을 위해 viewBinding 요소를 build.gradle 파일에 추가
  
```kotlin  
android {
        ...
        viewBinding {
            enabled = true
        }
    }
```    

<br />

  - RecyclerView 라이브러리 추가
    - 상품 페이지에 RecyclerView를 사용함
    - 애플리케이션  모듈의 build.gradle 파일에 필요한 아티팩트의 종속 항목을 추가
  

```kotlin  
dependencies {
    implementation("androidx.recyclerview:recyclerview:1.2.1")
    // For control over item selection of both touch and mouse driven selection
    implementation("androidx.recyclerview:recyclerview-selection:1.1.0")
}
```    

<br /><br />

## 애플리케이션 설명
**총 3개의 화면으로 구성된 안드로이드 애플리케이션**
- 로그인 페이지 `activity_login`
- 회원가입 페이지 `activity_join`
- 상품 페이지 `activity_product`

<br /><br />

## 상세페이지 설명
### 로그인 페이지 <br />
  앱 구동 시 가장 먼저 뜨는 페이지이다. <br />
  로그인, 회원가입, 비회원으로 쇼핑 중 선택할 수 있다. <br />
  
  **로그인 기능 동작**
  - 로그인은 내부저장소에 있는 `JoinInfo.xml`의 정보와 일치하는지 확인하여 작동한다. <br />
  - 없는 아이디가 입력되거나, 비밀번호가 일치하지 않으면 “로그인 실패” 토스트 메세지가 뜬다. <br />
  - 아이디 혹은 비밀번호가 입력되지 않으면 “로그인 실패” 토스트 메세지가 뜬다. <br />
  - 아이디와 비밀번호가 일치하면 3번째 페이지인 상품 페이지로 이동한다. <br />

<br />

### 회원가입 페이지 <br />
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

### 상품 페이지 <br />
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
    - 로그인 시 이용할 수 있는 서비스입니다. 회원가입 하시겠습니까? 라는 문구가 뜬다<br />
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

<br /><br />

## 스크린샷

### 로그인 페이지<br />
초기화면, 로그인 실패
<div>
<img width="200" alt="01 로그인 페이지" src="https://user-images.githubusercontent.com/104475363/198942431-9ed7bd89-46a5-40d6-919a-d90fc8e47c66.png">
<img width="200" alt="03  로그인 실패" src="https://user-images.githubusercontent.com/104475363/198942437-ea7b42ed-a118-4bd9-9556-b7e21ff1041e.png">
<div/>

<br/>

### 회원가입 페이지<br />
<img width="200" alt="02 회원가입 페이지" src="https://user-images.githubusercontent.com/104475363/198942434-302c8aaa-eb7c-4192-9655-b4e8f5f21130.png">

<br/>

### 상품 페이지<br />

초기화면, 회원 정보
<div>
<img width="200" alt="04 상품 페이지" src="https://user-images.githubusercontent.com/104475363/198942445-4b0a5ee0-b03d-463d-8ccc-6fb9d395a604.png">
<img width="200" alt="10 회원 정보" src="https://user-images.githubusercontent.com/104475363/198942652-f7b0c87f-c3b8-4bda-b94f-aa84cd03b833.png">
<div/>

<br/>

상품 관리, 상품 추가 전, 상품 추가 후
<div>
<img width="200" alt="05 상품 관리" src="https://user-images.githubusercontent.com/104475363/198942448-92006f12-081d-4ceb-977c-b534548fd840.png">
<img width="200" alt="06 상품 추가 전" src="https://user-images.githubusercontent.com/104475363/198942459-013d859d-a87e-4e8f-8004-c8576afb0d43.png">
<img width="200" alt="07 상품 추가 후" src="https://user-images.githubusercontent.com/104475363/198942464-e1fbcfe2-49da-4cea-8b1f-5e7715cc82c2.png">
<div/>

<br/>

상품 삭제, 상품 삭제 전, 상품  후
<div>
<img width="200" alt="08 상품 삭제" src="https://user-images.githubusercontent.com/104475363/198942468-489e5b97-dc51-49e7-a3cb-8d4cf7cf3e66.png">
<img width="200" alt="04 상품 페이지" src="https://user-images.githubusercontent.com/104475363/198942445-4b0a5ee0-b03d-463d-8ccc-6fb9d395a604.png">
<img width="200" alt="09 상품 삭제 후" src="https://user-images.githubusercontent.com/104475363/198942471-faf486fe-4a05-4176-aa2b-5329b23de61b.png">
<div/>
