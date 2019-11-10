# JUnit4-5_Sample
JUnit4 Rules, JUnit5 Sample  

</br>

# JUnit4  
## JUnit Rules  

</br>

# JUnit5    
## JUnit5란??  
이전버전의 JUnit과 다르게 JUnit 5는 세가지 하위 프로젝트의 여러 모듈로 구성됩니다  
![image](https://user-images.githubusercontent.com/39984656/68537741-92c71400-03ac-11ea-9206-7a4b71e7e95f.png)  

-   **JUnit  Platform :** 테스트를 발견하고 테스트 계획을 생성하는 TestEngine 인터페이스를 가지고 있습니다. Platform은 TestEngine을 통해서 테스트를 발경하고 ,실행하고 ,결과를 보고합니다.
-   **JUnit Jupiter :** TestEngine의 실제 구현체는 별도 모듈입니다. 모듈 중 하나가 jupiter-engine입니다. 이 모듈은 jupiter-api를 사용해서 작성한 테스트 코드를 발견하고 실행합니다. Jupiter API는 JUnit 5에 새롭게 추가된 테스트 코드용 API로서, 개발자는 Jupiter API를 사용해서 테스트 코드를 작성할 수 있습니다
-   **JUnit Vintage :** 기존에 JUnit 4 버전으로 작성한 테스트 코드를 실행할 때에는 vintage-engine 모듈을 사용합니다.  

</br>

## JUnit 5 GetStart  
JUnit 5는 런타임시에 Java 8이상이 필요합니다.  
그러나 이전 버전의 JDK로 컴파일된 코드는 계속 테스트 할 수 있습니다.  

</br>


**우선 Junit 5를 사용하려면 Android Gradle Plugin 3.2.0 ,  Gradle 4.7 이상이어야 합니다.**

**download**

```
buildscript {
  dependencies {
    classpath "de.mannodermaus.gradle.plugins:android-junit5:1.5.2.0"
  }
}
```

**setUp**

```
apply plugin: 'de.mannodermaus.android-junit5'

...

dependencies {
	...
    
    // (Required) Writing and executing Unit Tests on the JUnit Platform
    testImplementation "org.junit.jupiter:junit-jupiter-api:5.5.2"
    testRuntimeOnly "org.junit.jupiter:junit-jupiter-engine:5.5.2"

    // (Optional) If you need "Parameterized Tests"
    testImplementation "org.junit.jupiter:junit-jupiter-params:5.5.2"

    // (Optional) If you also have JUnit 4-based tests
    testImplementation "junit:junit:4.12"
    testRuntimeOnly "org.junit.vintage:junit-vintage-engine:5.5.2"
}

```

Junit 5 Test를 사용하기 위해선

Junit 5 plugin 과 Jupiter-api와 jupiter-engine을 필수적으로 사용해야 합니다. (Required)

추가적 옵션으로  params test또는  Junit4 종속정을 유지하려면 위 처럼 Optional을 추가하여 줍니다.  

</br>


**ues Java8**

JUnit의 모든 기능을 활용하려면 Java8 프로젝트를 구성해야 합니다.

```
android{
...
 compileOptions {
    sourceCompatibility JavaVersion.VERSION_1_8
    targetCompatibility JavaVersion.VERSION_1_8
  }
...
}
```  

</br>
</br>


**우선 Junit 5를 사용하려면 Android Gradle Plugin 3.2.0 ,  Gradle 4.7 이상이어야 합니다.**

**download**

```
buildscript {
  dependencies {
    classpath "de.mannodermaus.gradle.plugins:android-junit5:1.5.2.0"
  }
}
```

**setUp**

```
apply plugin: 'de.mannodermaus.android-junit5'

...

dependencies {
	...
    
    // (Required) Writing and executing Unit Tests on the JUnit Platform
    testImplementation "org.junit.jupiter:junit-jupiter-api:5.5.2"
    testRuntimeOnly "org.junit.jupiter:junit-jupiter-engine:5.5.2"

    // (Optional) If you need "Parameterized Tests"
    testImplementation "org.junit.jupiter:junit-jupiter-params:5.5.2"

    // (Optional) If you also have JUnit 4-based tests
    testImplementation "junit:junit:4.12"
    testRuntimeOnly "org.junit.vintage:junit-vintage-engine:5.5.2"
}

```

Junit 5 Test를 사용하기 위해선

Junit 5 plugin 과 Jupiter-api와 jupiter-engine을 필수적으로 사용해야 합니다. (Required)

추가적 옵션으로  params test또는  Junit4 종속정을 유지하려면 위 처럼 Optional을 추가하여 줍니다.

**ues Java8 **

JUnit의 모든 기능을 활용하려면 Java8 프로젝트를 구성해야 합니다.

```
android{
...
 compileOptions {
    sourceCompatibility JavaVersion.VERSION_1_8
    targetCompatibility JavaVersion.VERSION_1_8
  }
...
}
```

</br>
</br>  

## **Write Test( 테스트 작성하기)**  

### **JUnit 5 Annotations**  

<table style="border-collapse: collapse; width: 100%;" border="1" data-ke-style="style8"><tbody><tr><td style="width: 49.8837%;"><p><b>Annotation</b></p></td><td style="width: 50%;"><p><b>description</b></p></td></tr><tr><td style="width: 49.8837%;"><p>@Test</p></td><td style="width: 50%;"><p>방법은 테스트 방법임을 나타냅니다.<span>&nbsp;</span>JUnit 4의<span>&nbsp;</span>@Test주석<span>&nbsp;</span>과 달리이<span>&nbsp;</span>주석은 속성을 선언하지 않습니다. JUnit Jupiter의 테스트 확장 프로그램은 자체 전용 주석을 기반으로 작동하기 때문입니다.<span>&nbsp;</span>이러한 메서드는<span>&nbsp;</span>재정의<span>&nbsp;</span>되지 않는 한<span>&nbsp;</span>상속<span>&nbsp;</span>됩니다<span>&nbsp;</span>.</p></td></tr><tr><td style="width: 49.8837%;"><p>@ParameterizedTest</p></td><td style="width: 50%;"><p>메소드는<span>&nbsp;</span><a href="https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests">매개 변수화 된 테스트</a><span>&nbsp;</span>임을 나타냅니다<span>&nbsp;</span>.<span>&nbsp;</span>이러한 메서드는<span>&nbsp;</span>재정의<span>&nbsp;</span>되지 않는 한<span>&nbsp;</span>상속<span>&nbsp;</span>됩니다<span>&nbsp;</span>.</p></td></tr><tr><td style="width: 49.8837%;"><p>@RepeatedTest</p></td><td style="width: 50%;"><p>방법은<span>&nbsp;</span><a href="https://junit.org/junit5/docs/current/user-guide/#writing-tests-repeated-tests">반복 테스트를</a><span>&nbsp;</span>위한 테스트 템플릿임을 나타냅니다<span>&nbsp;</span>.<span>&nbsp;</span>이러한 메서드는<span>&nbsp;</span>재정의<span>&nbsp;</span>되지 않는 한<span>&nbsp;</span>상속<span>&nbsp;</span>됩니다<span>&nbsp;</span>.</p></td></tr><tr><td style="width: 49.8837%;"><p>@TestFactory</p></td><td style="width: 50%;"><p>방법은<span>&nbsp;</span><a href="https://junit.org/junit5/docs/current/user-guide/#writing-tests-dynamic-tests">동적 테스트를</a><span>&nbsp;</span>위한 테스트 팩토리임을 나타냅니다<span>&nbsp;</span>.<span>&nbsp;</span>이러한 메서드는<span>&nbsp;</span>재정의<span>&nbsp;</span>되지 않는 한<span>&nbsp;</span>상속<span>&nbsp;</span>됩니다<span>&nbsp;</span>.</p></td></tr><tr><td style="width: 49.8837%;"><p>@TestTemplate</p></td><td style="width: 50%;"><p>메소드는<span>&nbsp;</span>등록 된<span>&nbsp;</span><a href="https://junit.org/junit5/docs/current/user-guide/#extensions-test-templates">제공자가</a><span>&nbsp;</span>리턴 한 호출 컨텍스트의 수에 따라 여러 번 호출되도록 설계된<span>&nbsp;</span><a href="https://junit.org/junit5/docs/current/user-guide/#writing-tests-test-templates">테스트 케이스</a><span>&nbsp;</span>의<span>&nbsp;</span><a href="https://junit.org/junit5/docs/current/user-guide/#writing-tests-test-templates">템플리트</a><span>&nbsp;</span>임을 나타냅니다<span>&nbsp;</span>.<span>&nbsp;</span>이러한 메서드는<span>&nbsp;</span>재정의<span>&nbsp;</span>되지 않는 한<span>&nbsp;</span>상속<span>&nbsp;</span>됩니다<span>&nbsp;</span>.</p></td></tr><tr><td style="width: 49.8837%;"><p>@TestMethodOrder</p></td><td style="width: 50%;"><p>어노테이션이있는 테스트 클래스에 대한<span>&nbsp;</span><a href="https://junit.org/junit5/docs/current/user-guide/#writing-tests-test-execution-order">테스트 메소드 실행 순서</a><span>&nbsp;</span>를 구성하는 데 사용됩니다<span>&nbsp;</span>.<span>&nbsp;</span>JUnit 4와 유사합니다<span>&nbsp;</span>@FixMethodOrder.<span>&nbsp;</span>이러한 주석은<span>&nbsp;</span>상속<span>&nbsp;</span>됩니다.</p></td></tr><tr><td style="width: 49.8837%;"><p>@TestInstance</p></td><td style="width: 50%;"><p>어노테이션이있는 테스트 클래스에 대한<span>&nbsp;</span><a href="https://junit.org/junit5/docs/current/user-guide/#writing-tests-test-instance-lifecycle">테스트 인스턴스 라이프 사이클</a><span>&nbsp;</span>을 구성하는 데 사용됩니다<span>&nbsp;</span>.<span>&nbsp;</span>이러한 주석은<span>&nbsp;</span>상속<span>&nbsp;</span>됩니다.</p></td></tr><tr><td style="width: 49.8837%;"><p>@DisplayName</p></td><td style="width: 50%;"><p>테스트 클래스 또는 테스트 메소드<span>&nbsp;</span>의 사용자 정의<span>&nbsp;</span><a href="https://junit.org/junit5/docs/current/user-guide/#writing-tests-display-names">표시 이름</a><span>&nbsp;</span>을<span>&nbsp;</span>선언합니다<span>&nbsp;</span>.<span>&nbsp;</span>이러한 주석은<span>&nbsp;</span>상속<span>&nbsp;</span>되지 않습니다<span>&nbsp;</span>.</p></td></tr><tr><td style="width: 49.8837%;"><p>@DisplayNameGeneration</p></td><td style="width: 50%;"><p>테스트 클래스에 대한<span>&nbsp;</span>사용자 정의<span>&nbsp;</span><a href="https://junit.org/junit5/docs/current/user-guide/#writing-tests-display-name-generator">표시 이름 생성기</a><span>&nbsp;</span>를<span>&nbsp;</span>선언합니다<span>&nbsp;</span>.<span>&nbsp;</span>이러한 주석은<span>&nbsp;</span>상속<span>&nbsp;</span>됩니다.</p></td></tr><tr><td style="width: 49.8837%;"><p>@BeforeEach</p></td><td style="width: 50%;"><p>주석 메소드가 실행되어야 나타낸다고<span>&nbsp;</span>전에<span>&nbsp;</span><b>각각</b><span>&nbsp;</span>@Test<span>&nbsp;</span>,<span>&nbsp;</span>@RepeatedTest,<span>&nbsp;</span>@ParameterizedTest, 또는<span>&nbsp;</span>@TestFactory현재의 메소드;<span>&nbsp;</span>JUnit 4와 유사합니다<span>&nbsp;</span>@Before.<span>&nbsp;</span>이러한 메서드는<span>&nbsp;</span>재정의<span>&nbsp;</span>되지 않는 한<span>&nbsp;</span>상속<span>&nbsp;</span>됩니다<span>&nbsp;</span>.</p></td></tr><tr><td style="width: 49.8837%;"><p>@AfterEach</p></td><td style="width: 50%;"><p>주석 메소드가 실행되어야 나타낸다고<span>&nbsp;</span>후에<span>&nbsp;</span><b>각각</b><span>&nbsp;</span>@Test<span>&nbsp;</span>,<span>&nbsp;</span>@RepeatedTest,<span>&nbsp;</span>@ParameterizedTest, 또는<span>&nbsp;</span>@TestFactory현재의 메소드;<span>&nbsp;</span>JUnit 4와 유사합니다<span>&nbsp;</span>@After.<span>&nbsp;</span>이러한 메서드는<span>&nbsp;</span>재정의<span>&nbsp;</span>되지 않는 한<span>&nbsp;</span>상속<span>&nbsp;</span>됩니다<span>&nbsp;</span>.</p></td></tr><tr><td style="width: 49.8837%;"><p>@BeforeAll</p></td><td style="width: 50%;"><p>주석 메소드가 실행되어야 함을 나타내고<span>&nbsp;</span>전에<span>&nbsp;</span><b>모든</b><span>&nbsp;</span>@Test<span>&nbsp;</span>,<span>&nbsp;</span>@RepeatedTest,<span>&nbsp;</span>@ParameterizedTest및<span>&nbsp;</span>@TestFactory현재 클래스의 메소드;<span>&nbsp;</span>JUnit 4와 유사합니다<span>&nbsp;</span>@BeforeClass.<span>&nbsp;</span>이러한 메소드는<span>&nbsp;</span>(<span>&nbsp;</span>숨겨<span>&nbsp;</span>지거나<span>&nbsp;</span>재정의<span>&nbsp;</span>되지 않는 한)<span>&nbsp;</span>상속<span>&nbsp;</span>되며 "클래스 별"<span>&nbsp;</span><a href="https://junit.org/junit5/docs/current/user-guide/#writing-tests-test-instance-lifecycle">테스트 인스턴스 라이프 사이클</a><span>&nbsp;</span>이 사용<span>&nbsp;</span>되지 않는 한<span>&nbsp;</span>있어야합니다<span>&nbsp;</span>.static</p></td></tr><tr><td style="width: 49.8837%;"><p>@AfterAll</p></td><td style="width: 50%;"><p>주석 메소드가 실행되어야 함을 나타내고,<span>&nbsp;</span>이후<span>&nbsp;</span><b>모든</b><span>&nbsp;</span>@Test<span>&nbsp;</span>,<span>&nbsp;</span>@RepeatedTest,<span>&nbsp;</span>@ParameterizedTest및<span>&nbsp;</span>@TestFactory현재 클래스의 메소드;<span>&nbsp;</span>JUnit 4와 유사합니다<span>&nbsp;</span>@AfterClass.<span>&nbsp;</span>이러한 메소드는<span>&nbsp;</span>(<span>&nbsp;</span>숨겨<span>&nbsp;</span>지거나<span>&nbsp;</span>재정의<span>&nbsp;</span>되지 않는 한)<span>&nbsp;</span>상속<span>&nbsp;</span>되며 "클래스 별"<span>&nbsp;</span><a href="https://junit.org/junit5/docs/current/user-guide/#writing-tests-test-instance-lifecycle">테스트 인스턴스 라이프 사이클</a><span>&nbsp;</span>이 사용<span>&nbsp;</span>되지 않는 한<span>&nbsp;</span>있어야합니다<span>&nbsp;</span>.static</p></td></tr><tr><td style="width: 49.8837%;"><p>@Nested</p></td><td style="width: 50%;"><p>주석이 달린 클래스는 정적이 아닌<span>&nbsp;</span><a href="https://junit.org/junit5/docs/current/user-guide/#writing-tests-nested">중첩 테스트 클래스</a><span>&nbsp;</span>임을 나타냅니다<span>&nbsp;</span>.<span>&nbsp;</span>@BeforeAll및<span>&nbsp;</span>@AfterAll방법은 직접 사용할 수 없습니다<span>&nbsp;</span>@Nested은 "당 클래스"를 제외 테스트 클래스<span>&nbsp;</span><a href="https://junit.org/junit5/docs/current/user-guide/#writing-tests-test-instance-lifecycle">테스트 인스턴스 라이프 사이클이</a><span>&nbsp;</span>사용됩니다.<span>&nbsp;</span>이러한 주석은<span>&nbsp;</span>상속<span>&nbsp;</span>되지 않습니다<span>&nbsp;</span>.</p></td></tr><tr><td style="width: 49.8837%;"><p>@Tag</p></td><td style="width: 50%;"><p>클래스 또는 메소드 레벨에서<span>&nbsp;</span><a href="https://junit.org/junit5/docs/current/user-guide/#writing-tests-tagging-and-filtering">필터링 테스트를위한 태그</a><span>&nbsp;</span>를 선언하는 데 사용됩니다<span>&nbsp;</span>.<span>&nbsp;</span>TestNG의 테스트 그룹 또는 JUnit 4의 카테고리와 유사합니다. 이러한 주석은<span>&nbsp;</span>클래스 레벨에서<span>&nbsp;</span>상속<span>&nbsp;</span>되지만 메소드 레벨<span>&nbsp;</span>에서는<span>&nbsp;</span>상속<span>&nbsp;</span>되지 않습니다.</p></td></tr><tr><td style="width: 49.8837%;"><p>@Disabled</p></td><td style="width: 50%;"><p>테스트 클래스 또는 테스트 방법<span>&nbsp;</span>을<span>&nbsp;</span><a href="https://junit.org/junit5/docs/current/user-guide/#writing-tests-disabling">비활성화</a><span>&nbsp;</span>하는<span>&nbsp;</span>데 사용됩니다<span>&nbsp;</span>.<span>&nbsp;</span>JUnit 4와 유사합니다<span>&nbsp;</span>@Ignore.<span>&nbsp;</span>이러한 주석은<span>&nbsp;</span>상속<span>&nbsp;</span>되지 않습니다<span>&nbsp;</span>.</p></td></tr><tr><td style="width: 49.8837%;"><p>@Timeout</p></td><td style="width: 50%;"><p>실행이 주어진 기간을 초과하는 경우 테스트, 테스트 팩토리, 테스트 템플릿 또는 수명주기 방법에 실패합니다.<span>&nbsp;</span>이러한 주석은<span>&nbsp;</span>상속<span>&nbsp;</span>됩니다.</p></td></tr><tr><td style="width: 49.8837%;"><p>@ExtendWith</p></td><td style="width: 50%;"><p><a href="https://junit.org/junit5/docs/current/user-guide/#extensions-registration-declarative">확장을 선언적</a><span>&nbsp;</span>으로<span>&nbsp;</span><a href="https://junit.org/junit5/docs/current/user-guide/#extensions-registration-declarative">등록하는</a><span>&nbsp;</span>데 사용됩니다<span>&nbsp;</span>.<span>&nbsp;</span>이러한 주석은<span>&nbsp;</span>상속<span>&nbsp;</span>됩니다.</p></td></tr><tr><td style="width: 49.8837%;"><p>@RegisterExtension</p></td><td style="width: 50%;"><p>필드를 통해<span>&nbsp;</span><a href="https://junit.org/junit5/docs/current/user-guide/#extensions-registration-programmatic">프로그래밍 방식으로 확장</a><span>&nbsp;</span>을<span>&nbsp;</span><a href="https://junit.org/junit5/docs/current/user-guide/#extensions-registration-programmatic">등록하는</a><span>&nbsp;</span>데 사용됩니다<span>&nbsp;</span>.<span>&nbsp;</span>이러한 필드는<span>&nbsp;</span>음영 처리<span>&nbsp;</span>되지 않는 한<span>&nbsp;</span>상속<span>&nbsp;</span>됩니다<span>&nbsp;</span>.</p></td></tr><tr><td style="width: 49.8837%;"><p>@TempDir</p></td><td style="width: 50%;"><p>수명주기 방법 또는 테스트 방법에서 필드 주입 또는 매개 변수 주입을 통해<span>&nbsp;</span><a href="https://junit.org/junit5/docs/current/user-guide/#writing-tests-built-in-extensions-TempDirectory">임시 디렉토리</a><span>&nbsp;</span>를<span>&nbsp;</span>제공하는 데 사용됩니다<span>&nbsp;</span>.<span>&nbsp;</span>에있는<span>&nbsp;</span>org.junit.jupiter.api.io패키지.</p></td></tr></tbody></table>  

</br>
</br>


### **Custom Annotation**

**JUnit Jupiter Annotation은 Meta Annotation으로 사용할  수 있습니다.**

**즉, Annotation의 의미를 자동으로 상속하는 고유한 Custom Annotation을 정의할 수 있습니다.**

**예를 들어**`@Tag("fast")` 코드 베이스 전체에 복사하여 붙여넣는 대신 

아래와 같이 이름이 지정된 Custom Annotation을 작성할수 있습니다.

그런다음  `@Fast` 와 같은 식으로 사용 가능합니다.

```
import org.junit.jupiter.api.Tag

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.TYPE)
@Retention(AnnotationRetention.RUNTIME)
@Tag("fast")
annotation class Fast
```

kotlin에서 annotation class 키워드를이용하여 메타 데이터 코드들을 주석으로 첨부할 수 있습니다.

주석 클래스에 메타 주석을 달아 주석의 추가 속성을 지정할 수 있습니다.

-   [@Target](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.annotation/-target/index.html)주석으로 주석을 달 수있는 가능한 종류의 요소 (클래스, 함수, 속성, 표현식 등)를 지정합니다.
-   [@Retention](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.annotation/-retention/index.html)주석이 컴파일 된 클래스 파일에 저장되는지 여부와 런타임시 리플렉션을 통해 표시되는지 여부를 지정합니다 (기본적으로 둘 다 true 임).
-   [@Repeatable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.annotation/-repeatable/index.html)단일 요소에 동일한 주석을 여러 번 사용할 수 있습니다.
-   [@MustBeDocumented](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.annotation/-must-be-documented/index.html)주석이 공개 API의 일부이고 생성 된 API 문서에 표시된 클래스 또는 메소드 서명에 포함되어야 함을 지정합니다.

[Kotlin Annotation class 알아보기](https://kotlinlang.org/docs/reference/annotations.html)

생성한 주석은 아래와 같이 사용합니다.

```
class CustomAnnotationTest {

    @Fast
    @Test
    fun myFastTest() {
        //..
    }
}
```  

</br>
</br>  


### 테스트 클래스와 테스트 메소드 (Test Classes and Methods)  

**TestClass** :최소한 하나의 test-method를 포함하는최상위 클래스로,static멤버 클래스 또는[@Nested클래스](https://junit.org/junit5/docs/current/user-guide/#writing-tests-nested).

테스트 클래스는abstract단일 생성자가아니어야하며 단일 생성자가 있어야합니다.

**TestMethod**: @Test,@RepeatedTest,@ParameterizedTest,@TestFactory, 또는@TestTemplate. 주석으로 만들어진 Method

**LifecycleMethod**:@BeforeAll,@AfterAll,@BeforeEach, 또는@AfterEach.  [(Lifecycle Method 자세히 알아보기)](https://beomseok95.tistory.com/302)

테스트 메소드 및 라이프사이클 메소드는 현재 테스트 클래스 내에서 

로컬로 선언되거나  수퍼클래스에서 상속되거나 인터페이스에서 상속 될 수 있습니다.

또한 테스트 메소드와 수명주기 메소드는 abstract로 선언되어서는 안됩니다.

**example**

```
class StandardTests {

    @BeforeEach
    fun init() {
    }

    @Test
    fun succeedingTest() {
    }

    @Test
    fun failingTest() {
        fail("a failing test")
    }

    @Test
    @Disabled("for demonstration purposes")
    fun skippedTest() {
        // not executed
    }

    @Test
    fun abortedTest() {
        assumeTrue("abc".contains("Z"))
        fail("test should have been aborted")
    }

    @AfterEach
    fun tearDown() {
    }

    companion object {

        @BeforeAll
        fun initAll() {
        }

        @AfterAll
        fun tearDownAll() {
        }
    }
}
```  

</br>
</br>

### **DisplayName 설정하기**

**3.4.1 DisplayName**

테스트 클래스와 테스트 메소드는 @DisplayName Annotation을 이용하여

공백 , 특수문자 및 이모티콘등을 사용한 이름으로 IDE에 표시되도록 변경할 수 있습니다.

```
@DisplayName("A special test case")
class DisplayNameDemo {

    @Test
    @DisplayName("Custom test name containing spaces")
    fun testWithDisplayNameContainingSpaces() {
    }

    @Test
    @DisplayName("╯°□°）╯")
    fun testWithDisplayNameContainingSpecialCharacters() {
    }

    @Test
    @DisplayName("😱")
    fun testWithDisplayNameContainingEmoji() {
    }

}
```



**3.4.2보이지는 이름 생성기 (DisplayNameGeneratation)**

**JUnit Jupiter는**`**@DisplayNameGeneration**` 을 이용하여 

구성할 수 있는 custom DisplayNameGeneration을 지원합니다.

`**@DisplayName**` 주석을 통해 제공된 값은 DisplayGeneration으로 생성된 것보다 우선합니다.

아래 예를 보도록 하겠습니다.

```
class DisplayNameGeneratorDemo {

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores::class)
    inner class A_year_is_not_supported {

        @Test
        fun if_it_is_zero() {
        }

        @DisplayName("A negative value for year is not supported by the leap year computation.")
        @ParameterizedTest(name = "For example, year {0} is not supported.")
        @ValueSource(ints = [-1, -4])
        fun if_it_is_negative(year: Int) {
        }
    }

    @Nested
    @DisplayNameGeneration(IndicativeSentences::class)
    inner class A_year_is_a_leap_year {

        @Test
        fun if_it_is_divisible_by_4_but_not_by_100() {
        }

        @ParameterizedTest(name = "Year {0} is a leap year.")
        @ValueSource(ints = [2016, 2020, 2048])
        fun if_it_is_one_of_the_following_years(year: Int) {
        }
    }

    class IndicativeSentences : DisplayNameGenerator.ReplaceUnderscores() {
        override fun generateDisplayNameForNestedClass(nestedClass: Class<*>): String {
            return super.generateDisplayNameForNestedClass(nestedClass) + "..."
        }

        override fun generateDisplayNameForMethod(testClass: Class<*>, testMethod: Method): String {
            val name = testClass.simpleName + ' ' + testMethod.name
            return name.replace('_', ' ') + '.'
        }
    }
}
```


첫 번째  이너클래스  A\_year\_is\_not\_supported 클래스 

DisplayNameGenerator.ReplaceUnderscores 클래스를 NameGenerator로 사용했습니다.

Underbar를 삭제해주는 NameGenerator입니다.

결과값을 보면 클래스 name과 메소드 name의 Underbar가 사라진 것을 볼 수 있습니다.

두번째  이너클래스 A\_year\_is\_a\_leap\_year 클래스는

DisplayNameGenerator.ReplaceUnderscores 를 상속받아 두개의 메소드를 재정의한

IndicativeSentens 클래스를 사용합니다 .

재정의한 메소드를 보면  

`fun generateDisplayNameForNestedClass()` ,

`fun generateDisplayNameForMethod()` 을 통해

클래스이름뒤에 " ... "을 추가하고 

메소드이름 앞뒤로 클래스이름과 메소드이름을 출력하고 언더바를 제거하도록 정의되어있습니다.  

</br>
</br>


#### ** 테스트 클래스와 테스트 메소드 (Test Classes and Methods)**

**TestClass** :최소한 하나의 test-method를 포함하는최상위 클래스로,static멤버 클래스 또는[@Nested클래스](https://junit.org/junit5/docs/current/user-guide/#writing-tests-nested).

테스트 클래스는abstract단일 생성자가아니어야하며 단일 생성자가 있어야합니다.

**TestMethod**: @Test,@RepeatedTest,@ParameterizedTest,@TestFactory, 또는@TestTemplate. 주석으로 만들어진 Method

**LifecycleMethod**:@BeforeAll,@AfterAll,@BeforeEach, 또는@AfterEach.  [(Lifecycle Method 자세히 알아보기)](https://beomseok95.tistory.com/302)

테스트 메소드 및 라이프사이클 메소드는 현재 테스트 클래스 내에서 

로컬로 선언되거나  수퍼클래스에서 상속되거나 인터페이스에서 상속 될 수 있습니다.

또한 테스트 메소드와 수명주기 메소드는 abstract로 선언되어서는 안됩니다.

**example**

```
class StandardTests {

    @BeforeEach
    fun init() {
    }

    @Test
    fun succeedingTest() {
    }

    @Test
    fun failingTest() {
        fail("a failing test")
    }

    @Test
    @Disabled("for demonstration purposes")
    fun skippedTest() {
        // not executed
    }

    @Test
    fun abortedTest() {
        assumeTrue("abc".contains("Z"))
        fail("test should have been aborted")
    }

    @AfterEach
    fun tearDown() {
    }

    companion object {

        @BeforeAll
        fun initAll() {
        }

        @AfterAll
        fun tearDownAll() {
        }
    }
}
```

#### **DisplayName 설정하기**

**3.4.1 DisplayName**

테스트 클래스와 테스트 메소드는 @DisplayName Annotation을 이용하여

공백 , 특수문자 및 이모티콘등을 사용한 이름으로 IDE에 표시되도록 변경할 수 있습니다.

```
@DisplayName("A special test case")
class DisplayNameDemo {

    @Test
    @DisplayName("Custom test name containing spaces")
    fun testWithDisplayNameContainingSpaces() {
    }

    @Test
    @DisplayName("╯°□°）╯")
    fun testWithDisplayNameContainingSpecialCharacters() {
    }

    @Test
    @DisplayName("😱")
    fun testWithDisplayNameContainingEmoji() {
    }

}
```


**3.4.2보이지는 이름 생성기 (DisplayNameGeneratation)**

**JUnit Jupiter는**`**@DisplayNameGeneration**` 을 이용하여 

구성할 수 있는 custom DisplayNameGeneration을 지원합니다.

`**@DisplayName**` 주석을 통해 제공된 값은 DisplayGeneration으로 생성된 것보다 우선합니다.

아래 예를 보도록 하겠습니다.

```
class DisplayNameGeneratorDemo {

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores::class)
    inner class A_year_is_not_supported {

        @Test
        fun if_it_is_zero() {
        }

        @DisplayName("A negative value for year is not supported by the leap year computation.")
        @ParameterizedTest(name = "For example, year {0} is not supported.")
        @ValueSource(ints = [-1, -4])
        fun if_it_is_negative(year: Int) {
        }
    }

    @Nested
    @DisplayNameGeneration(IndicativeSentences::class)
    inner class A_year_is_a_leap_year {

        @Test
        fun if_it_is_divisible_by_4_but_not_by_100() {
        }

        @ParameterizedTest(name = "Year {0} is a leap year.")
        @ValueSource(ints = [2016, 2020, 2048])
        fun if_it_is_one_of_the_following_years(year: Int) {
        }
    }

    class IndicativeSentences : DisplayNameGenerator.ReplaceUnderscores() {
        override fun generateDisplayNameForNestedClass(nestedClass: Class<*>): String {
            return super.generateDisplayNameForNestedClass(nestedClass) + "..."
        }

        override fun generateDisplayNameForMethod(testClass: Class<*>, testMethod: Method): String {
            val name = testClass.simpleName + ' ' + testMethod.name
            return name.replace('_', ' ') + '.'
        }
    }
}
```



첫 번째  이너클래스  A\_year\_is\_not\_supported 클래스 

DisplayNameGenerator.ReplaceUnderscores 클래스를 NameGenerator로 사용했습니다.

Underbar를 삭제해주는 NameGenerator입니다.

결과값을 보면 클래스 name과 메소드 name의 Underbar가 사라진 것을 볼 수 있습니다.

두번째  이너클래스 A\_year\_is\_a\_leap\_year 클래스는

DisplayNameGenerator.ReplaceUnderscores 를 상속받아 두개의 메소드를 재정의한

IndicativeSentens 클래스를 사용합니다 .

재정의한 메소드를 보면  

`fun generateDisplayNameForNestedClass()` ,

`fun generateDisplayNameForMethod()` 을 통해

클래스이름뒤에 " ... "을 추가하고 

메소드이름 앞뒤로 클래스이름과 메소드이름을 출력하고 언더바를 제거하도록 정의되어있습니다.  

</br>
</br>

### **Assertions**

**3.5.1 Assertion (알아보기)**

JUnit Jupiter에는 JUnit 4에 있는 많은 Assertion Method가 포함되어 있으며

Java 8 람다와 함께 사용하기 적합한 몇가지를 추가 하였습니다.

JUnit Jupiter Assertion 은 모두 static method입니다. ([org.junit.jupiter.api.Assertions](https://junit.org/junit5/docs/current/api/org/junit/jupiter/api/Assertions.html))

```
internal class AssertionsDemo {

    private val calculator = Calculator()

    private val person = Person("Jane", "Doe")

    @Test
    fun standardAssertions() {
        assertEquals(2, calculator.add(1, 1))
        assertEquals(
            4, calculator.multiply(2, 2),
            "The optional failure message is now the last parameter"
        )
        assertTrue('a' < 'b') { "Assertion messages can be lazily evaluated -- to avoid constructing complex messages unnecessarily." }
    }

    @Test
    fun groupedAssertions() {
        // In a grouped assertion all assertions are executed, and all
        // failures will be reported together.
        assertAll("person",
            { assertEquals("Jane", person.getFirstName()) },
            { assertEquals("Doe", person.getLastName()) }
        )
    }

    @Test
    fun dependentAssertions() {
        // Within a code block, if an assertion fails the
        // subsequent code in the same block will be skipped.
        assertAll("properties",
            {
                val firstName = person.getFirstName()
                assertNotNull(firstName)

                // Executed only if the previous assertion is valid.
                assertAll("first name",
                    { assertTrue(firstName.startsWith("J")) },
                    { assertTrue(firstName.endsWith("e")) }
                )
            },
            {
                // Grouped assertion, so processed independently
                // of results of first name assertions.
                val lastName = person.getLastName()
                assertNotNull(lastName)

                // Executed only if the previous assertion is valid.
                assertAll("last name",
                    { assertTrue(lastName.startsWith("D")) },
                    { assertTrue(lastName.endsWith("e")) }
                )
            }
        )
    }

    @Test
    fun exceptionTesting() {
        val exception = assertThrows(ArithmeticException::class.java) { calculator.divide(1, 0) }
        assertEquals("/ by zero", exception.message)
    }

    @Test
    fun timeoutNotExceeded() {
        // The following assertion succeeds.
        assertTimeout(ofMinutes(2)) {
            // Perform task that takes less than 2 minutes.
        }
    }

    @Test
    fun timeoutNotExceededWithResult() {
        // The following assertion succeeds, and returns the supplied object.

        val actualResult = assertTimeout(ofMinutes(2)) { "a result" }
        assertEquals("a result", actualResult)
    }

    @Test
    fun timeoutNotExceededWithMethod() {
        // The following assertion invokes a method reference and returns an object.
        val actualGreeting: String = assertTimeout(ofMinutes(2)) { greeting() }
        assertEquals("Hello, World!", actualGreeting)
    }

    @Test
    fun timeoutExceeded() {
        // The following assertion fails with an error message similar to:
        // execution exceeded timeout of 10 ms by 91 ms
        assertTimeout(ofMillis(10)) {
            // Simulate task that takes more than 10 ms.
            Thread.sleep(5)
        }
    }

    @Test
    fun timeoutExceededWithPreemptiveTermination() {
        // The following assertion fails with an error message similar to:
        // execution timed out after 10 ms
        assertTimeoutPreemptively(ofMillis(10)) {
            // Simulate task that takes more than 10 ms.
            Thread.sleep(100)
        }
    }

    private fun greeting(): String {
        return "Hello, World!"
    }
}
```

assertTimeout() , assertAll(), assetEqaul() , assertTrue등을 람다를 이용하여 작성할 수 있습니다. 

**선점 시간 제한assertTimeoutPreemptively()**

[선언적 타임 아웃](https://junit.org/junit5/docs/current/user-guide/#writing-tests-declarative-timeouts)과는 달리클래스의 다양한assertTimeoutPreemptively() 메소드Assertions는 제공된 코드executable또는supplier호출 코드의 스레드와 다른 스레드에서실행됩니다.이 동작은executable또는내부에서 실행되는 코드가스토리지에supplier의존하는 경우 바람직하지 않은 부작용을 초래할 수 있습니다

**3.5.2 Assertion Kotlin (알아보기)**

JUnit Jupiter는 Kotlin에서 사용하기에 적합한 몇 가지 Assetion 방법도 제공합니다.

**example**

```
class KotlinAssertionsDemo {

    private val person = Person("Jane", "Doe")
    private val people = setOf(person, Person("John", "Doe"))

    @Test
    fun `exception absence testing`() {
        val calculator = Calculator()
        val result = assertDoesNotThrow("Should not throw an exception") {
            calculator.divide(0, 1)
        }
        assertEquals(0, result)
    }

    @Test
    fun `expected exception testing`() {
        val calculator = Calculator()
        val exception =
            assertThrows(
                ArithmeticException::class.java,
                { calculator.divide(1, 0) }) { "Should throw an exception" }
        assertEquals("/ by zero", exception.message)
    }

    @Test
    fun `grouped assertions`() {
        assertAll("Person properties",
            { assertEquals("Jane", person.getFirstName()) },
            { assertEquals("Doe", person.getLastName()) }
        )
    }

    @Test
    fun `grouped assertions from a stream`() {
        assertAll("People with first name starting with J",
            people
                .stream()
                .map {
                    // This mapping returns Stream<() -> Unit>
                    { assertTrue(it.getFirstName().startsWith("J")) }
                }
        )
    }

    @Test
    fun `grouped assertions from a collection`() {
        assertAll("People with last name of Doe",
            people.map { { assertEquals("Doe", it.getLastName()) } }
        )
    }

    @Test
    fun `timeout not exceeded testing`() {
        val fibonacciCalculator = FibonacciCalculator()
        val result: Int = assertTimeout(Duration.ofMillis(100)) {
            fibonacciCalculator.fib(14)
        }
        assertEquals(377, result)
    }

    @Test
    fun `timeout exceeded with preemptive termination`() {
        // The following assertion fails with an error message similar to:
        // execution timed out after 10 ms
        assertTimeoutPreemptively(Duration.ofMillis(10)) {
            // Simulate task that takes more than 10 ms.
            Thread.sleep(100)
        }
    }
}
```  
