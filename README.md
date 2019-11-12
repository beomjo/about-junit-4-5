# JUnit4-5_Sample
JUnit4 Rules, JUnit5 Sample  

# Table of Contents  
- [JUnit4](#junit4)
  * [JUnit Rules](#junit-rules)
    + [**JUnit의 Rule이란??**](#--junit--rule------)
    + [**JUnit Rule 종류**](#--junit-rule-----)
    + [**1\. TemporaryFoler Rule**](#--1--temporaryfoler-rule--)
    + [**2\. ExternalResources Rule**](#--2--externalresources-rule--)
    + [**3\. ErrorCollector Rule**](#--3--errorcollector-rule--)
    + [**4\. Verifier Rule**](#--4--verifier-rule--)
    + [**5\. TestWatcher**](#--5--testwatcher--)
    + [**6\. TestName**](#--6--testname--)
    + [**7\. Timeout**](#--7--timeout--)
    + [**8\. ExpectedException**](#--8--expectedexception--)
    + [**9\. ClassRule**](#--9--classrule--)
    + [****10\. Rule Chaine****](#----10--rule-chaine----)
    + [**11\. Custom Rule**](#--11--custom-rule--)
    + [**12\. Custom Rule**](#--12--custom-rule--)
- [JUnit5](#junit5)
  * [JUnit5란??](#junit5---)
  * [JUnit 5 GetStart](#junit-5-getstart)
  * [**Write Test( 테스트 작성하기)**](#--write-test-------------)
    + [**JUnit 5 Annotations**](#--junit-5-annotations--)
    + [**Custom Annotation**](#--custom-annotation--)
    + [테스트 클래스와 테스트 메소드 (Test Classes and Methods)](#------------------test-classes-and-methods-)
    + [**DisplayName 설정하기**](#--displayname-------)
      - [** 테스트 클래스와 테스트 메소드 (Test Classes and Methods)**](#---------------------test-classes-and-methods---)
      - [**DisplayName 설정하기**](#--displayname--------1)
    + [**Assertions**](#--assertions--)
    + [**테스트 비활성화 (Disabling Test)**](#------------disabling-test---)
    + [**조건부 테스트 실행 (Conditional Test Excution)**](#--------------conditional-test-excution---)
    + [**태깅 및 필터링 ( Tagging and Filtering)**](#-------------tagging-and-filtering---)
    + [**테스트 실행 순서 (Test Excution Order)**](#-------------test-excution-order---)
    + [**인스턴스 수명주기 테스트 (****Test Instance Lifecycle)**](#---------------------test-instance-lifecycle---)
    + [**중첩 테스트 ( Nested Tests)**](#-----------nested-tests---)
    + [**생성자와 메소드에 대한의존성 주입 (DI for Constructors and Method)**](#----------------------di-for-constructors-and-method---)
    + [**테스트 인터페이스 및 기본 메소드 (Test Interface and Default Method)**](#----------------------test-interface-and-default-method---)
    + [**반복테스트 (Repeated Test)**](#---------repeated-test---)
    + [**매개 변수화 된 테스트**](#----------------)
    + [**동적 테스트 (Dynamic Tests)**](#----------dynamic-tests---)
    + [**타임아웃 (TimeOut)**](#--------timeout---)
    + [**병렬실행 (Parallel Execution)**](#--------parallel-execution---)


</br>

# JUnit4  
## JUnit Rules  

### **JUnit의 Rule이란??**

**Rule은 테스트 클래스에서 동작 방식을 재정의하거나 쉽게 추가하는 것을 말합니다.**

**사용자는 기존의 Rule을 재사용하거나 확장하는 것이 가능합니다.**  

</br>

### **JUnit Rule 종류**

JUnit은 사용할 수 있는 여러 가지 Rule이 존재합니다. (아래의 표 참고)

여러 가지 Rule에 대하여 자세히 알아보겠습니다.

**기본 Rule 클래스**

규칙 이름 설명

<table style="border-collapse: collapse; width: 100%; height: 219px;" border="1" data-ke-style="style12"><tbody><tr style="height: 19px;"><td style="height: 19px;"><b>&nbsp;Rule</b></td><td style="height: 19px;">Description</td></tr><tr style="height: 19px;"><td style="height: 19px;"><b>TemporaryFolder</b></td><td style="height: 19px;">임시폴더 관리. 테스트 후 삭제</td></tr><tr style="height: 19px;"><td style="height: 19px;"><b>ExternalResources</b></td><td style="height: 19px;">자원(DB, 파일, 소켓) 관리</td></tr><tr style="height: 19px;"><td style="height: 19px;"><b>ErrorCollector</b></td><td style="height: 19px;">지속적 테스트 실패 수집</td></tr><tr style="height: 19px;"><td style="height: 19px;"><b>Verifier</b></td><td style="height: 19px;">별개 조건 확인 (vs<span>&nbsp;</span>assert*)</td></tr><tr style="height: 19px;"><td style="height: 19px;"><b>TestWatcher</b></td><td style="height: 19px;">테스트 인터셉터 (starting, succeeded, failed, finished…)</td></tr><tr style="height: 19px;"><td style="height: 19px;"><b>TestName</b></td><td style="height: 19px;">테스트 메소드명을 알려줌</td></tr><tr style="height: 19px;"><td style="height: 19px;"><b>Timeout</b></td><td style="height: 19px;">테스트 클래스 전역 timeout 설정 (vs<span>&nbsp;</span>@Timeout)</td></tr><tr style="height: 19px;"><td style="height: 19px;"><b>ExpectedException</b></td><td style="height: 19px;">예외 직접 확인 (vs<span>&nbsp;</span>@Expected)</td></tr><tr style="height: 19px;"><td style="height: 19px;"><b>DisableOnDebug</b></td><td style="height: 19px;">Rule 디버그 비활성화 데코레이터</td></tr><tr style="height: 19px;"><td style="height: 19px;"><b>RuleChain</b></td><td style="height: 19px;">복수 Rule chaining 복합체</td></tr><tr style="height: 10px;"><td style="height: 10px;"><b>ClassRule</b></td><td style="height: 10px;">테스트슈트 전체에 Rule 적용</td></tr></tbody></table>  

</br>


### **1\. TemporaryFoler Rule**

-   임시 폴더, 파일들을 생성할 수 있습니다.
-   테스트가 모두 끝난 후 삭제합니다.
-   기본적으로 resource를 삭제하지 못하는 경우 어떠한 exception도 반환하지 않습니다.

```
class HasTempFolderTest {
    @get:Rule
    val folder = TemporaryFolder()


    @Test
    fun testUsingTempFolder() {
        val createdFile = folder.newFile("myfile.txt")
        val createdFolder = folder.newFolder("subfolder")

        println(createdFile)
        println(createdFolder)

        Assert.assertEquals(2,folder.root.list().size)
    }
}
```

아래처럼 임시저장소에 저장되는 것을 알 수 있습니다.

```
//result
/var/folders/8_/pk7f5n_x6j5fsyn6dftvnpz40000gn/T/junit7812537062205433850/myfile.txt
/var/folders/8_/pk7f5n_x6j5fsyn6dftvnpz40000gn/T/junit7812537062205433850/subfolder

```

### **2\. ExternalResources Rule**

-   **외부 Resource(DB connect, File, Socket) 초기화 /반환을 관리합니다.**
-   **특정 자원을 다른 테스트 케이스에서 재사용할 때 유용합니다.**

```
class UsesExternalResourceTest {
    internal var myServer = Server()

    @get:Rule
    val resource: ExternalResource = object : ExternalResource() {
        @Throws(Throwable::class)
        override fun before() {
            myServer.connect()
        }

        override fun after() {
            myServer.disconnect()
        }
    }

    @Test
    fun testFoo() {
        val user = Client(1)

        user.run(myServer)

        Assert.assertEquals(1, myServer.activeUser.size)
    }
}
```  

</br>

### **3\. ErrorCollector Rule**

-   에러가 발생하더라도 지속적으로 테스트를 진행하게 도와주는 Rule입니다.

```
class UsesErrorCollectorTwiceTest {
    @get:Rule
    val collector = ErrorCollector()

     @Test
    fun example() {
        collector.addError(Throwable("first thing went wrong"))
        collector.addError(Throwable("second thing went wrong"))

        collector.checkThat("a", equalTo("b"))
        collector.checkThat(1, equalTo(2))
        println("Test continues even if an error occurs")
    }
}
```

collector에 error를 담으면 test를 진행하면서 발생했던 모든 error의 결과를 알 수 있습니다.


```
//result
Test continues even if an error occurs

java.lang.Throwable: first thing went wrong

    at k.bs.junit.test_rule.errorcollector.UsesErrorCollectorTwiceTest.example(UsesErrorCollectorTwiceTest.kt:15)
    at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
    at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
    at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
    at java.lang.reflect.Method.invoke(Method.java:498)
    ....


java.lang.Throwable: second thing went wrong

    at k.bs.junit.test_rule.errorcollector.UsesErrorCollectorTwiceTest.example(UsesErrorCollectorTwiceTest.kt:16)
    at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
    at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
    at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
    at java.lang.reflect.Method.invoke(Method.java:498)
    ...


java.lang.AssertionError: 
Expected: "b"
     but: was "a"
Expected :b
Actual   :a
<Click to see difference>


    at org.hamcrest.MatcherAssert.assertThat(MatcherAssert.java:20)
    at org.junit.Assert.assertThat(Assert.java:956)
    at org.junit.rules.ErrorCollector$1.call(ErrorCollector.java:65)
    at org.junit.rules.ErrorCollector.checkSucceeds(ErrorCollector.java:78)
    at org.junit.rules.ErrorCollector.checkThat(ErrorCollector.java:63)
    ...


java.lang.AssertionError: 
Expected: <2>
     but: was <1>
Expected :<2>
Actual   :<1>
<Click to see difference>


    at org.hamcrest.MatcherAssert.assertThat(MatcherAssert.java:20)
    at org.junit.Assert.assertThat(Assert.java:956)
    at org.junit.rules.ErrorCollector$1.call(ErrorCollector.java:65)
    at org.junit.rules.ErrorCollector.checkSucceeds(ErrorCollector.java:78)
    at org.junit.rules.ErrorCollector.checkThat(ErrorCollector.java:63)
    at org.junit.rules.ErrorCollector.checkThat(ErrorCollector.java:54)
    ....

```  

</br>

### **4\. Verifier Rule**

-   **테스트 자체를 검증하는 assert 와는 다르게 , 테스트 케이스 실행 후 만족해야 하는 환경조건이나 Global조건(객체들의 종합 상태)을 검사하는 데 사용됩니다.**
-   **즉 ,\*\***테스트 실행할 때마다 실행되며 사용자 정의 검증 로직을 추가로 넣어 특정 조건을 만족하는지 검증하는 데 사용됩니다.\*\*

```
class VerifierRuleTest {
    private var MAX_AGE = 25
    internal var peopleWithAgeGreaterThanMaxAge: MutableList<Person> = ArrayList()

    @get:Rule
    var verifier: Verifier = object : Verifier() {
        public override fun verify() {
            assertThat(peopleWithAgeGreaterThanMaxAge.size, CoreMatchers.equalTo(0))
        }
    }

    @Test
    fun personTest1() {
        val person = Person.Builder()
                .name("Frank")
                .age(20)
                .build()

        if (person.age > MAX_AGE) {
            peopleWithAgeGreaterThanMaxAge.add(person)
        }
    }

    @Test
    fun personTest2() {
        val person = Person.Builder()
                .name("Angela")
                .age(30)
                .build()

        if (person.age > MAX_AGE) {
            peopleWithAgeGreaterThanMaxAge.add(person)
        }
    }
}
```

매 테스트 케이스를 수행할 때마다 추가로 verify()가 수행됩니다.

두 번째 테스트 케이스에서 age는 30이 넘으므로 test 가 실패합니다.  

</br>

### **5\. TestWatcher**

-   테스트 Interceptor (starting, succeeded, failed , finished)을 intercept

```
class WatchermanTest {

    @get:Rule
    val watchman: TestRule = object : TestWatcher() {
        fun applying(base: Statement, description: Description): Statement {
            return super.apply(base, description)
        }

        override fun succeeded(description: Description) {
            watchedLog += description.displayName + " " + "success!\n"
        }

        override fun failed(e: Throwable, description: Description) {
            watchedLog += description.displayName + " " + e.javaClass.simpleName + "\n"
        }

        override fun skipped(e: AssumptionViolatedException, description: Description) {
            watchedLog += description.displayName + " " + e.cause + "\n"
        }

        override fun starting(description: Description) {
            super.starting(description)
        }

        override fun finished(description: Description) {
            super.finished(description)
        }
    }

    @Test
    fun fails() {
        fail()
    }

    @Test
    fun test_success() {
    }

    companion object {
        private var watchedLog = ""

        @AfterClass
        @JvmStatic
        fun teardown() {
            println(watchedLog)
        }
    }
}
```

테스트 정보를 남기는 코드를 분리하여 기록할 수 있습니다.  

</br>

### **6\. TestName**

-   **테스트 메서드명을 얻을 수 있습니다.**

```
class NameRuleTest {
    @get:Rule
    val name = TestName()

    @Test
    fun testA() {
        assertEquals("testA", name.methodName)
    }

    @Test
    fun testB() {
        assertEquals("testB", name.methodName)
    }
}
```  

</br>

### **7\. Timeout**

-   **하나의 테스트가 통과하기 위한 timeout을 설정할 수 있습니다.**

```
class HasGlobalTimeout {

    @get:Rule
    val globalTimeout: TestRule = Timeout.millis(20)

    @Test
    fun testInfiniteLoop1() {
        log += "ran1"

        while (true) {
        }

    }

    @Test
    fun testInfiniteLoop2() {
        log += "ran2"
        while (true) {
        }
    }

    companion object {
        var log: String = ""
    }
}
```

테스트 케이스마다 timeout을 설정하여 timeout시 에러를 발생시킵니다.  

</br>

### **8\. ExpectedException**

-   예외 직접 확인할 수 있습니다.
-   Error 메시지도 검증이 가능합니다.

```
class HasExpectedException {
    @get:Rule
    val thrown = ExpectedException.none()

    @Test
    fun throwsNothing() {

    }

    @Test
    fun throwsNullPointerException() {
        thrown.expect(NullPointerException::class.java)
        throw NullPointerException()
    }

    @Test
    fun throwsNullPointerExceptionWithMessage() {
        thrown.expect(NullPointerException::class.java)
        thrown.expectMessage("happened?")
        thrown.expectMessage(startsWith("What"))
        throw NullPointerException("What happened?")
    }
}
```  

</br>

### **9\. ClassRule**

-   **TestSuite의 클래스마다 적용할 수 있는 Rule입니다.**

\*_TestSuite란 테스트할 클래스가 하나가 아니라 여럿이라면 묶어서 테스트하는 것입니다.  
\*_

```
@RunWith(Suite::class)
@Suite.SuiteClasses(A::class, B::class)
class UsesExternalResourceTest {

    companion object {
        val myServer = Server()

        @get:ClassRule
        @JvmStatic
        val resource: ExternalResource = object : ExternalResource() {
            @Throws(Throwable::class)
            override fun before() {
                myServer.connect()
            }

            override fun after() {
                myServer.disconnect()
            }
        }
    }
}
```

@RunWith(Suite::class) , @Suite. SuiteClasses(..)를 이용하여

A 클래스의 테스트 케이스와 B클래스의 테스트 케이스를 모두 수행합니다.  

</br>


### ****10\. Rule Chaine****

-   **여러 개의 Rule을 chain으로 적용할 수 있습니다.**

```
class UseRuleChainTest {
    @get:Rule
    val chain: TestRule = RuleChain
            .outerRule(LoggingRule("outer rule"))
            .around(LoggingRule("middle rule"))
            .around(LoggingRule("inner rule"))

    @Test
    fun example() {
        assertTrue(true)
    }
}
```

**사용자 정의로 생성한 LoggingRule을 체인 형식으로 적용하였습니다.**

**LoggingRule은 각 테스트 전후로 시작… 끝…. 로그 메시지를 출력하는 Rule로 입니다.**

**자세한 내용은 아래에서 보도록 하겠습니다.**

```
//result
start: outer rule
start: middle rule
start: inner rule
end: inner rule
end: middle rule
end: outer rule
```

**RuleChain 클래스 method**

<table style="border-collapse: collapse; width: 100%; height: 95px;" border="1" data-ke-style="style8"><tbody><tr style="height: 19px;"><td style="width: 50%; height: 19px;"><b>Method</b></td><td style="width: 50%; height: 19px;"><b>Description</b></td></tr><tr style="height: 19px;"><td style="width: 50%; height: 19px;"><b><span style="color: #333333;">emptyRuleChain()</span></b></td><td style="width: 50%; height: 19px;">TestRule없이 리턴합니다. RuleChain선언의 시작이 될 수 있습니다.</td></tr><tr style="height: 19px;"><td style="width: 50%; height: 19px;"><b>outerRule(TestRule outerRule)</b></td><td style="width: 50%; height: 19px;"><p><span style="color: #333333;">emptyRuleChain</span><span style="color: #333333;">().around(outerRule)</span></p></td></tr><tr style="height: 19px;"><td style="width: 50%; height: 19px;"><b>around(TestRule encloseRule)</b></td><td style="width: 50%; height: 19px;">기존의 Rule체인을 감까 새로운 룰을 추가합니다.</td></tr></tbody></table>

위의 예제처럼 around로 감싼 룰들은 아래와 같은 구조를 띄게 됩니다.

**(outer ( middle (inner()))**  

</br>

### **11\. Custom Rule**

-   **Custom 한 rule을 생성하여 사용할 수 있습니다.**
-   **TestRule Interface을 구현하여 사용합니다.**

```
class LoggingRule(private val name: String) : TestRule {
    override fun apply(base: Statement, description: Description): Statement {
        return object : Statement() {
            @Throws(Throwable::class)
            override fun evaluate() {
                try {
                    println("start: $name")
                    base.evaluate()
                } finally {
                    println("end: $name")
                }
            }
        }
    }
}
```

**TestRule interface는 apply함수를 가지고 있습니다.**

**Stetement : Rule이 사용되는 Junit Runtime 내의 테스트들을 나타냅니다.**

base.evaluate()은 테스트 케이스의 실행입니다.

아래와 같이 테스트 전 후로 로그를 찍어주는 Custom TestRule인 것입니다.

```
println("start: $name") //테스트 전 로그출력
base.evaluate()			//테스트실행
println("end: $name")	//테스트 후 로그 출력
```

****[https://junit.org/junit4/javadoc/4.12/org/junit/runners/model/Statement.html](https://junit.org/junit4/javadoc/4.12/org/junit/runners/model/Statement.html)****

[

Statement (JUnit API)

abstract  void evaluate()           Run the action, throwing a Throwable if anything goes wrong.

junit.org



](https://junit.org/junit4/javadoc/4.12/org/junit/runners/model/Statement.html)  

</br>

### **12\. Custom Rule**

**[https://stefanbirkner.github.io/system-rules/](https://stefanbirkner.github.io/system-rules/)**



</br>
</br>
</br>
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

</br>

### **테스트 비활성화 (Disabling Test)**

**disabledClass Test**

```
@Disabled("Disabled until bug #99 has been fixed")
class DisabledClassDemo {

    @Test
    fun testWillBeSkipped() {
    }
}
```

**disabledTests **

```
class DisabledTestsDemo {

    @Disabled("Disabled until bug #42 has been resolved")
    @Test
    fun testWillBeSkipped() {
    }

    @Test
    fun testWillBeExecuted() {
    }

}
```  

</br>

### **조건부 테스트 실행 (Conditional Test Excution)**

JUnit Jupiter의 확장 API를 통해 개발자는 컨테이너를 활성화 또는 비활성화 하거나

특정 조건에 따라 프로그래밍 방식으로  테스트 할 수 있습니다.

**1\. 운영체제 조건(**Operating System Conditions**)**

```
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@Test
@EnabledOnOs(OS.MAC)
internal annotation class TestOnMac


class DisplayOnOsTest {

    @Test
    @EnabledOnOs(OS.MAC)
    fun onlyOnMacOs() {
        //..
    }

    @TestOnMac
    fun testOnMac() {
        //.
    }

    @Test
    @EnabledOnOs(OS.LINUX, OS.MAC)
    fun onLinuxOrMac() {
        //.
    }

    @Test
    @DisabledOnOs(OS.WINDOWS)
    fun notOnWindows() {
        //.
    }
    
      @Test
    @DisabledOnOs(OS.MAC)
    fun notOnMac(){
        //.
    }
}
```  


글쓴이의 환경은 Mac이므로 위처럼 테스트가 활성화 or 비활성화 됩니다.

컨테이너 또는 테스트는 `@EnabledOnOs` 및 운영체제를 통해 특정 운영체제에서 활성화

or 비활성화 될 수 있습니다(`@DisabledOnOs`)

**2\. 자바 런타임 환경 조건(**Java Runtime Environment Condition**)**

자바 런타임 환경 조건에 따라 테스트 활성화 또는 비활성화 할 수 있습니다.

```
class JavaRuntimeEnvironmentTest {
    @Test
    @EnabledOnJre(JRE.JAVA_8)
    fun onlyOnJava8() {
        // ...
    }

    @Test
    @EnabledOnJre(JRE.JAVA_9, JRE.JAVA_10)
    fun onJava9Or10() {
        // ...
    }

    @Test
    @DisabledOnJre(JRE.JAVA_9)
    fun notOnJava9() {
        // ...
    }
}
```


**3\. 환경 변수 조건( System Property Conditions)**

컨테이너 또는 테스트는 및 named  운영체제를 통해 기본 운영체제의 환경 변수값에 따라 

활성화 or 비활성화 될 수 있습니다. 

속성을 통해 제공된 값은 정규식으로 해석됩니다.

[@EnabledIfEnvironmentVariable,](https://junit.org/junit5/docs/current/api/org/junit/jupiter/api/condition/EnabledIfEnvironmentVariable.html)[@DisabledIfEnvironmentVariable  ](https://junit.org/junit5/docs/current/api/org/junit/jupiter/api/condition/DisabledIfEnvironmentVariable.html)matches

```
class SystemPropertyTests {
    @Test
    @EnabledIfEnvironmentVariable(named = "ENV", matches = "staging-server")
    fun onlyOnStagingServer() {
        // ...
    }

    @Test
    @DisabledIfEnvironmentVariable(named = "ENV", matches = ".*development.*")
    fun notOnDeveloperWorkstation() {
        // ...
    }
}
```

**4\. 스크립트 기반 조건( Script-Based Conditions)**

**Deprecated 되었으므로 설명 생략**

**[https://junit.org/junit5/docs/current/user-guide/#writing-tests-conditional-execution-scripts](https://junit.org/junit5/docs/current/user-guide/#writing-tests-conditional-execution-scripts)**

[

JUnit 5 User Guide

Although the JUnit Jupiter programming model and extension model will not support JUnit 4 features such as Rules and Runners natively, it is not expected that source code maintainers will need to update all of their existing tests, test extensions, and cus

junit.org


  
  </br>
  

### **태깅 및 필터링 ( Tagging and Filtering)**

**TAG 규칙**

태그는 null일 수 없습니다.

A trimmed(손질된) 태그는 공백을 포함 할 수 없습니다.

A trimmed(손질된) 태그는 ISO 제어 문자를 포함 할 수 없습니다.

A trimmed(손질된)  다음 중 하나를 포함 할 수 없습니다예약 문자를.

    -  ** , :쉼표**

    -  ** ( :왼쪽 괄호**

    -  ** ) :오른쪽 괄호**

    -  **& :앰퍼샌드**

    -  **| :세로 막대**

    -  **! :느낌표**

**example**

```
@Tags(Tag("fast"), Tag("model"))
class TaggingDemo {

    @Test
    @Tag("taxes")
    fun testingTaxCalculation() {
    }

}
```  

</br>

### **테스트 실행 순서 (Test Excution Order)**

기본적으로 Test Method는 의도적으로 불명확한 알고리즘을 사용하여 정렬됩니다.

Test Suite의 후속 실행에서 동일한 메소드를 실행하여 반복빌드를 하려면 정확한 순서로 Test Method가 실행될 필요가 있습니다.

실제 단위 테스트는 일반적으로 실행 순서에 의존해서는 안되지만 

특정 테스트 방법 실행 순서를 시행해야 할 경우가 있기 때문입니다(ex : 테스트순서가 통합 된 테스트 또는 기능테스트를 작성 하는 경우 )

특히 @TestInstance(Lifecycle.PER\_CLASS) 등과 사용할때 중요합니다.

테스트 메소드의 실행 순서를 제어하려면 테스트 클래스 또는 테스트 인터페이스에 Annotation을  달고

[@TestMethodOrder](https://junit.org/junit5/docs/current/api/org/junit/jupiter/api/TestMethodOrder.html)원하는[MethodOrderer](https://junit.org/junit5/docs/current/api/org/junit/jupiter/api/MethodOrderer.html) 을 지정합니다.

고유 한 사용자 정의를 구현MethodOrderer하거나 다음 내장MethodOrderer구현중 하나를 사용할수 있습니다.

**[Alphanumeric](https://junit.org/junit5/docs/current/api/org/junit/jupiter/api/MethodOrderer.Alphanumeric.html):**이름과 형식 매개 변수 목록을 기준으로Test Method을알파벳순으로정렬합니다.

**[OrderAnnotation](https://junit.org/junit5/docs/current/api/org/junit/jupiter/api/MethodOrderer.OrderAnnotation.html):**주석을통해 지정된 값을 기준으로 Test Method을숫자로정렬합니다[@Order](https://junit.org/junit5/docs/current/api/org/junit/jupiter/api/Order.html).

**[Random](https://junit.org/junit5/docs/current/api/org/junit/jupiter/api/MethodOrderer.Random.html):**의사테스트 방식을의사 무작위로주문하고 사용자 정의Seed구성을 지원합니다.

```
@TestMethodOrder(OrderAnnotation::class)
class OrderedTestsDemo {

    @Test
    @Order(1)
    fun nullValues() {
        // perform assertions against null values
    }

    @Test
    @Order(2)
    fun emptyValues() {
        // perform assertions against empty values
    }

    @Test
    @Order(3)
    fun validValues() {
        // perform assertions against valid values
    }
}
```

</br>

### **인스턴스 수명주기 테스트 (****Test Instance Lifecycle)**

개별 테스트 메소드를 개별적으로 실행하고 변경 가능한 테스트 인스턴스 상태로 인한 예기치 않는 부작용을 피하기 위해

JUnit은 각 TestMethod를  실행하기 전에 TestClass의 새 인스턴스를 작성합니다.

JUnit Jupiter도 마찬가지로 모든 이전 버전의 JUnit과 동일합니다.

JUnit Jupiter가 동일한 테스트 인스턴스에서 모든 테스트 메소드를 실행하려면 테스트클래스에 @TestInstance(Lifecycle.PER\_CLASS)

주석을 사용합니다.  TestMethod는 인스턴스 변수에 저장상태에 의존하는 경우에는 

`@BeforeEach`,`@AfterEcah`Annotation을 사용하여 테스트 실행 전후의 상태를 관리하면 됩니다.  

</br>

### **중첩 테스트 ( Nested Tests)**

`@Nested` 테스트는 테스트 작성에게  여러 테스트 그룹 간의 관계를 표현할 수있는 더 많은 기능을 제공합니다.

```
@DisplayName("A stack")
class TestingAStackDemo {

    var stack: Stack<Any>? = null

    @Test
    @DisplayName("is instantiated with new Stack()")
    fun isInstantiatedWithNew() {
        stack = Stack()
    }

    @Nested
    @DisplayName("when new")
    internal inner class WhenNew {

        @BeforeEach
        fun createNewStack() {
            stack = Stack()
        }

        @Test
        @DisplayName("is empty")
        fun isEmpty() {
            assertTrue(stack.isNullOrEmpty())
        }

        @Test
        @DisplayName("throws EmptyStackException when popped")
        fun throwsExceptionWhenPopped() {
            assertThrows(EmptyStackException::class.java) {
                stack?.pop()
            }
        }

        @Test
        @DisplayName("throws EmptyStackException when peeked")
        fun throwsExceptionWhenPeeked() {
            assertThrows(EmptyStackException::class.java) {
                stack?.peek()
            }
        }

        @Nested
        @DisplayName("after pushing an element")
        inner class AfterPushing {

            var anElement = "an element"

            @BeforeEach
            fun pushAnElement() {
                stack?.push(anElement)
            }

            @Test
            @DisplayName("it is no longer empty")
            fun isNotEmpty() {
                assertFalse(stack.isNullOrEmpty())
            }

            @Test
            @DisplayName("returns the element when popped and is empty")
            fun returnElementWhenPopped() {
                assertEquals(anElement, stack?.pop())
                assertTrue(stack.isNullOrEmpty())
            }

            @Test
            @DisplayName("returns the element when peeked but remains not empty")
            fun returnElementWhenPeeked() {
                assertEquals(anElement, stack?.peek())
                assertFalse(stack.isNullOrEmpty())
            }
        }
    }
}
```


내부 클래스만 `@Nested` 를 사용하여 중첩클래스로 만들 수 있습니다.

중첩클래스 각각 마다 @BeforeEach , @AfterEach가 작동합니다.

그리고 @BeforeAll 및 @AfterAll은 작동하지 않습니다. 그 이유는 java가 static 내부클래스를 허용하지 않기 때문입니다.

그러나 위의 제한  @TestInstance(Lifecycler.PER\_CLASS) Annotaion을 사용하여 회피할 수 있습니다.  

</br>

### **생성자와 메소드에 대한의존성 주입 (DI for Constructors and Method)**

이전의 모든  JUnit 버전에서 테스트 생성자 또는 테스트 메소드는 매개 변수를 가질 수 없었습니다.

JUnit Jupinter의 주요 변경사항 중 하나인 테스트 생성자와 메소드는 매개변수를 가질 수 있습니다.

이는 유연성을 높이고 생성자와 메소드에 대한 종속성 주입을 가능하게 합니다.

[ParameterResolver](https://junit.org/junit5/docs/current/api/org/junit/jupiter/api/extension/ParameterResolver.html)런타임시 매개 변수를동적으로해결하려는 테스트 확장을위한 API를 정의합니다.

만약 클래스 생성자, 테스트메소드, 또는 라이프사이클 메소드를 파라미터를 받으려 한다면,

파라미터를 등록을 런타임에 해결되어야합니다.

**바로 ParameterResolver등록을 통해서 해결합니다.**

**현재 자동으로 등록 된 내장 리졸버 3 개가 있습니다.**

**1\. [TestInfoParameterResolver](https://github.com/junit-team/junit5/tree/r5.5.2/junit-jupiter-engine/src/main/java/org/junit/jupiter/engine/extension/TestInfoParameterResolver.java):**

생성자 또는 메소드 매개 변수가 유형[TestInfo](https://junit.org/junit5/docs/current/api/org/junit/jupiter/api/TestInfo.html)인경우 현재 컨테이너TestInfoParameterResolver에TestInfo해당하는 인스턴스를 제공하거나 매개 변수의 값으로 테스트합니다.  TestInfo는 다음과 같은 표시 이름, 테스트 클래스, 시험 방법, 및 관련 태그로 현재 컨테이너 또는 검사에 대한 정보를 검색 할 수 있습니다.표시 이름은 테스트 클래스 또는 테스트 방법의 이름과 같은 기술적 이름이거나를 통해 구성된 사용자 지정 이름@DisplayName입니다.

```
@DisplayName("TestInfo Demo")
internal class TestInfoDemo(testInfo: TestInfo) {

    init {
        println("init call")
        assertEquals("TestInfo Demo", testInfo.displayName)
    }

    @BeforeEach
    fun init(testInfo: TestInfo) {
        val displayName = testInfo.displayName
        assertTrue(displayName == "TEST 1" || displayName == "test2()")
    }

    @Test
    @DisplayName("TEST 1")
    @Tag("my-tag")
    fun test1(testInfo: TestInfo) {
        assertEquals("TEST 1", testInfo.displayName)
        assertTrue(testInfo.tags.contains("my-tag"))
    }

    @Test
    fun test2() {
    }

}
```

`@BeforeEach`Annotation으로 선언된 메소드에서 매개변수를 TestInfo를 받으면 

@BeforeEach가 호출될 때마다 생성자가 호출됩니다.

TestInfo에는 아래와 같은 method 가 존재합니다.

```
String getDisplayName();

Set<String> getTags();

Optional<Class<?>> getTestClass();

Optional<Method> getTestMethod();
```

**2.[RepetitionInfoParameterResolver](https://github.com/junit-team/junit5/tree/r5.5.2/junit-jupiter-engine/src/main/java/org/junit/jupiter/engine/extension/RepetitionInfoParameterResolver.java):**

@BeforeEach또는@AfterEach method  파라미터가 [RepetitionInfo](https://junit.org/junit5/docs/current/api/org/junit/jupiter/api/RepetitionInfo.html)  이면은RepetitionInfoParameterResolver인스턴스를 제공합니다.RepetitionInfo 다음과 현재 반복 및 해당에 대한 총 반복 수에 대한 정보를 검색하는 데 사용할 수 있습니다. 그러나RepetitionInfoParameterResolver이는 컨텍스트 외부에서 등록되지 않습니다@RepeatedTest.[반복 테스트 예를](https://junit.org/junit5/docs/current/user-guide/#writing-tests-repeated-tests-examples)참조하십시오.

```
class RepeatedTestsDemo {

    private val logger = Logger.getLogger(this::class.java.canonicalName)

    @BeforeEach
    fun beforeEach(testInfo: TestInfo, repetitionInfo: RepetitionInfo) {
        val currentRepetition = repetitionInfo.currentRepetition
        val totalRepetitions = repetitionInfo.totalRepetitions
        val methodName = testInfo.testMethod.get().name
        logger.info(
            String.format(
                "About to execute repetition %d of %d for %s", //
                currentRepetition, totalRepetitions, methodName
            )
        );
    }

    @RepeatedTest(10)
    fun repeatedTest() {
        // ...
    }

    @RepeatedTest(5)
    fun repeatedTestWithRepetitionInfo(repetitionInfo: RepetitionInfo) {
        assertEquals(5, repetitionInfo.totalRepetitions);
    }

    @RepeatedTest(value = 1, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("Repeat!")
    fun customDisplayName(testInfo: TestInfo) {
        assertEquals("Repeat! 1/1", testInfo.displayName);
    }

    @RepeatedTest(value = 1, name = RepeatedTest.LONG_DISPLAY_NAME)
    @DisplayName("Details...")
    fun customDisplayNameWithLongPattern(testInfo: TestInfo) {
        assertEquals("Details... :: repetition 1 of 1", testInfo.displayName);
    }

    @RepeatedTest(value = 5, name = "Wiederholung {currentRepetition} von {totalRepetitions}")
    fun repeatedTestInGerman() {
        // ...
    }

}
```

@BeforeEach, @AfterEach Annotation 이 작성된 메소드가 존재한다면

@ReapeatedTest() Annotation을 사용하여  현재 반복 테스트 실행에 대한 정보를 얻을 수 있습니다.

**3.**[TestReporterParameterResolver](https://github.com/junit-team/junit5/tree/r5.5.2/junit-jupiter-engine/src/main/java/org/junit/jupiter/engine/extension/TestReporterParameterResolver.java):

생성자 또는 메소드 매개 변수가 유형[TestReporter](https://junit.org/junit5/docs/current/api/org/junit/jupiter/api/TestReporter.html)인 경우TestReporterParameterResolver의 인스턴스를 제공TestReporter합니다.은TestReporter현재 테스트 실행에 대한 추가 데이터를 게시 할 수 있습니다.의reportingEntryPublished()메소드를통해 데이터를 사용하여[TestExecutionListener](https://junit.org/junit5/docs/current/api/org/junit/platform/launcher/TestExecutionListener.html)IDE에서 보거나 보고서에 포함시킬 수 있습니다.

```
class TestReporterDemo {

    @Test
    fun reportSingleValue(testReporter: TestReporter) {
        testReporter.publishEntry("a status message")
    }

    @Test
    fun reportKeyValuePair(testReporter: TestReporter) {
        testReporter.publishEntry("a key", "a value")
    }

    @Test
    fun reportMultipleKeyValuePairs(testReporter: TestReporter) {
        val values = HashMap<String, String>()
        values.put("user name", "dk38")
        values.put("award year", "1974")

        testReporter.publishEntry(values)
    }

}
```  

</br>

### **테스트 인터페이스 및 기본 메소드 (Test Interface and Default Method)**

**JUnit Jupiter는 인터페이스에서 default 메소드에  @Test , @RepeatedTest , @ParameterizedTest , @TestFactory, @TestTemplate, @BeforeEach, @AfterEach  Annotation을 선언할 수 있습니다.**

**테스트 인터페이스 또는 테스트 클래스에 @TestInstance(Lifecycler.PER\_CLASS)가 Annotation 선언 되어있는 경우 **

**테스트 인터페이스의 static Method 또는 interface의 default메소드에서** **@BeforeAll과 @AfterAll을 선언할 수 있습니다.**

```
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal interface TestLifecycleLogger {

    @BeforeAll
    fun beforeAllTests() {
        logger.info("Before all tests")
    }

    @AfterAll
    fun afterAllTests() {
        logger.info("After all tests")
    }

    @BeforeEach
    fun beforeEachTest(testInfo: TestInfo) {
        logger.info {
            String.format(
                "About to execute [%s]",
                testInfo.displayName
            )
        }
    }

    @AfterEach
    fun afterEachTest(testInfo: TestInfo) {
        logger.info {
            String.format(
                "Finished executing [%s]",
                testInfo.displayName
            )
        }
    }

    companion object {
        val logger = Logger.getLogger(TestLifecycleLogger::class.java.name)
    }

}
```

```
interface TestInterfaceDynamicTestsDemo {

    @TestFactory
    fun dynamicTestsForPalindromes(): List<DynamicTest> {
        return listOf("racecar", "radar", "mom", "dad")
            .map { t -> dynamicTest(t) { Assertions.assertTrue(t.isPalindrome()) } }
    }
}
```

`@ExtendWith` 및`@Tag` 를 사용하여 인터페이스를 구현하는 클래스가 자동으로 태그 및 확장을 상속하도록

인터페이스에 선언 가능합니다.

```
@Tag("timed")
@ExtendWith(TimingExtension::class)
interface TimeExecutionLogger
```

테스트 클래스에서 이러한 테스트 인터페이스를 구현하여 적용 할 수 있습니다.

```
class TestInterfaceDemo : TestLifecycleLogger, TimeExecutionLogger, TestInterfaceDynamicTestsDemo {

    @Test
    fun isEqualValue() {
        Assertions.assertEquals(1, "a".length, "is always equal")
    }

}
```

TestInterface 의 또 다른 가능한 적용은 인터페이스 계약에 대한 테스트를 작성하는 것입니다.

예를들어 아래와 같이 Object.equals 또는 Comparable.comoareTo 작동 방식에 대한 테스트를 작성할 수 있습니다.

```
interface Testable<T> {
    fun createValue(): T
}
```

```
interface EqualsContract<T> : Testable<T> {

    fun createNotEqualValue(): T

    @Test
    fun valueEqualsItself() {
        val value = createValue()
        assertEquals(value, value)
    }

    @Test
    fun valueDoesNotEqualNull() {
        val value = createValue()
        assertFalse(value == null)
    }

    @Test
    fun valueDoesNotEqualDifferentValue() {
        val value = createValue()
        val differentValue = createNotEqualValue()
        assertNotEquals(value, differentValue)
        assertNotEquals(differentValue, value)
    }

}
```

```
interface ComparableContract<T : Comparable<T>> : Testable<T> {

    fun createSmallerValue(): T

    @Test
    fun returnsZeroWhenComparedToItself() {
        val value = createValue()
        assertEquals(0, value.compareTo(value))
    }

    @Test
    fun returnsPositiveNumberWhenComparedToSmallerValue() {
        val value = createValue()
        val smallerValue = createSmallerValue()
        assertTrue(value > smallerValue)
    }

    @Test
    fun returnsNegativeNumberWhenComparedToLargerValue() {
        val value = createValue()
        val smallerValue = createSmallerValue()
        assertTrue(smallerValue < value)
    }
}
```

테스트 클래스에서 두 Contract interface를 모두 구현하여 해당 테스트를 상속 할 수 있습니다.

물론 abstract  method는 구현해주어야 합니다.

```
class StringTests : ComparableContract<String>, EqualsContract<String> {
    override fun createValue(): String {
        return "banana"
    }

    override fun createSmallerValue(): String {
        return "apple" // 'a' < 'b' in "banana"
    }

    override fun createNotEqualValue(): String {
        return "cherry"
    }

}
```  

</br>


### **반복테스트 (Repeated Test)**

JUnit Jupiter는 메소드에 `@RepeatedTest` Annotation을 달고 원하는 총 반복 횟수를 지정하여 

지정된 횟수 만큼 테스트를 반복 할 수 있는 기능을 제공합니다. 

반복되는 테스트를 호출할 때마다 동일한 Lifecycle 콜백 및 상속된 메소드들이 동일하게 작용합니다.

반복 횟수를 지정하는것 외에도 name속성을 통해 반복마다 사용자 정의 표시 이름을 구성할 수 있습니다.

**\- {displayName}**:@RepeatedTest메소드의표시 이름

**\- {currentRepetition}**: 현재 반복 횟수

**\- {totalRepetitions}**: 총 반복 횟수

주어진 반복에 대한 기본 표시 이름은  아래와 같은 패턴으로 생성됩니다.

" repetition {currentRepetition} of {totalRepetitions} "

ex) repetition 1 of 10 , repetition 2 of 10

@RepeatedTest 으로 선언된 메소드의 기본 표시 이름말고 다른이름으로 사용하고 싶다면

사용자 정의 패턴을 정의하거나, 사전에 정의된 RepeatedTest.LONG\_DISPLAY\_NAME

RepeatedTest.LONG\_DISPLAY\_NAME은 아래와 같은 패턴으로 사용합니다.

" {displayName} :: repetition {currentRepetiton} of {totalRepetitions} "

**example)**

**13\. 생성자와 메소드에 대한의존성 주입 (DI for Constructors and Method)에서 **

**반복 테스트의 예를 보게 되면  아래와 같이 실행되는것을 볼 수 있습니다.**


</br>


### **매개 변수화 된 테스트**

매개 변수화 된 테스를 통해 다른 인수로 테스트를 여러번 테스트 할 수 있습니다.

`@Test` 대신 `@ParameterizedTest` Annotation을 사용합니다.

또한 각 호출데 대한 인수를 제공하고 테스트 메소드에서 사용할 소스를 하나 이상 선언해야 합니다.

example)

```
class ParameterizedTest {
    @ParameterizedTest
    @ValueSource(strings = ["racecar", "radar", "able was I ere I saw elba"])
    fun palindromes(candidate: String) {
        Assertions.assertTrue(candidate.isPalindrome())
    }
}
```  

**3.16.1 인수 소비하기**

매개변수화 된 테스트 메소드는 일반적으로  argument source index 와 method parameter index 사이의 일대일 상관 관계에 따라 

구성된 소스에서 직접 인수를 소비합니다.

그러나 매개 변수화 된 테스트 메소드는 소스에서 인수를 메소드에 전달 된 단일 오브젝트로 집계할 수 있도록 선택할 수도 있습니다.

그리고ParameterResolver가 추가 인수를 제공 할 수도 있습니다 (예 : TestInfo, TestReporter 등의 인스턴스를 얻기 위해).

특히 매개 변수화 된 테스트 방법은 다음 규칙에 따라 공식 매개 변수를 선언해야합니다

-   0 개 이상의인덱싱 된 인수를먼저 선언해야합니다.
    
-   다음에 0 개 이상의애그리 게이터(aggregators)를 선언해야합니다.
    
-   ParameterResolver가 제공하는 0 개 이상의 인수는 마지막에 선언해야합니다.
    

이와 관련하여 색인화 된 인수는 메소드의 공식 매개 변수 목록에서

동일한 색인에있는 매개 변수화 된 메소드에 인수로 전달되는 ArgumentsProvider에서 제공 한 인수의 지정된 색인에 대한 인수입니다.

애그리 게이터는 ArgumentsAccessor 유형의 매개 변수 또는 @AggregateWith로 주석이 달린 매개 변수입니다.

**3.16.2 인수의 근원(Source of Arguments)**

JUnit Jupiter는 기본적으로 몇 가지 source Annotation을  사용합니다.

**@ValueSource**

@ValueSource가장 간단한 소스 중 하나입니다.

리터럴 값의 단일 배열을 지정할 수 있으며 매개 변수화 된 테스트 호출마다 단일 인수를 제공하는 데만 사용할 수 있습니다.

아래와 같은 유형의 리터럴 값이 지원됩니다

**\- short**

**\- byte**

**\- int**

**\- long**

**\- float**

**\- double**

**\- char**

**\- boolean**

**\- java.lang.String**

**\- java.lang.Class**

**Null and Empty Sources**

입력이잘못공급 될 때 코너 케이스를 확인하고 소프트웨어의 올바른 동작을 확인하려면 파라미터 화 된 테스트에 값을 제공null하고비워두는 것이 유용 할 수 있습니다.다음 주석은null단일 인수를 허용하는 매개 변수화 된 테스트의소스및 빈 값으로 사용됩니다.

1 .[@NullSource](https://junit.org/junit5/docs/current/api/org/junit/jupiter/params/provider/NullSource.html):null Annotation이 달린@ParameterizedTest메소드에단일인수를제공합니다.

  -  @NullSource기본 유형이있는 매개 변수에는 사용할 수 없습니다.

2.[@EmptySource](https://junit.org/junit5/docs/current/api/org/junit/jupiter/params/provider/EmptySource.html): 빈 소스를 제공합니다.

- java.lang.String,java.util.List,java.util.Set,java.util.Map, 배열 프리미티브 (예를 들면int\[\],char\[\]\[\]등), 오브젝트 어레이 (예를 들어String\[\],Integer\[\]\[\]등).

 - 지원되는 유형의 하위 유형은 지원되지 않습니다.

3\. [@NullAndEmptySource](https://junit.org/junit5/docs/current/api/org/junit/jupiter/params/provider/NullAndEmptySource.html):및의 기능을 결합한구성된 Annotation입니다.@NullSource@EmptySource

매개 변수화 된 테스트에여러 유형의빈문자열을 제공해야하는 경우

[@ValueSource](https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests-sources-ValueSource)를 사용하여 이를 달성 할 수 있습니다 ( 예[:)](https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests-sources-ValueSource)@ValueSource(strings = {" ", "   ", "\\t", "\\n"}).

또한 결합 할 수 있습니다@NullSource,@EmptySource그리고@ValueSource(A)의 넓은 범위의 테스트null,빈, 그리고빈입력합니다.다음 예제는 문자열에서이를 달성하는 방법을 보여줍니다.

**example)**

```
  @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = [" ", "   ", "\t", "\n"])
    fun nullEmptyAndBlankStrings(text: String?) {
        assertTrue(text == null || text.trim { it <= ' ' }.isEmpty())
    }
```

밑의 결과에서 

\[1\]는 @NullSource

\[2\]는 @EmptySource

\[3\],\[4\],\[5\],\[6\]은 @ValueSource  값입니다.

@NullSource와 @EmptySource 어노테이션을 둘다 사용하지않고

@NullAndEmptySource 어노테이션을 사용할 수도있습니다 

결과는 똑같습니다.

```
 @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = [" ", "   ", "\t", "\n"])
    fun nullEmptyAndBlankStrings2(text: String?) {
        assertTrue(text == null || text.trim { it <= ' ' }.isEmpty())
    }
```  

**@EnumSource**

@EnumSource는 상수 클래스에 선언된 상수를 사용하는 편리한 방법을 제공합니다.

@EnumSource의 names 속성은 선택적으로 매개변수를 사용할 수 있습니다.

```
@ParameterizedTest
@EnumSource(TimeUnit::class)
fun testWithEnumSource(timeUnit: TimeUnit) {
    assertNotNull(timeUnit)
}

@ParameterizedTest
@EnumSource(value = TimeUnit::class, names = ["DAYS", "HOURS"])
fun testWithEnumSourceInclude(timeUnit: TimeUnit) {
    assertTrue(EnumSet.of(TimeUnit.DAYS, TimeUnit.HOURS).contains(timeUnit))
}
```  

@EnumSource Annotation은  또한 옵션으로 `mode` 를 제공합니다.

mode는 아래 예와 같이 열거 형 상수 풀에서 이름을 제외하거나 정규식을 지정할 수 있습니다.

```
 @ParameterizedTest
    @EnumSource(value = TimeUnit::class, mode = EnumSource.Mode.EXCLUDE, names = ["DAYS", "HOURS"])
    fun testWithEnumSourceExclude(timeUnit: TimeUnit) {
        assertFalse(EnumSet.of(TimeUnit.DAYS, TimeUnit.HOURS).contains(timeUnit))
        assertTrue(timeUnit.name.length > 5)
    }
```
  

```
   @ParameterizedTest
    @EnumSource(value = TimeUnit::class, mode = EnumSource.Mode.MATCH_ALL, names = ["^(M|N).+SECONDS$"])
    fun testWithEnumSourceRegex(timeUnit: TimeUnit) {
        val name = timeUnit.name
        assertTrue(name.startsWith("M") || name.startsWith("N"))
        assertTrue(name.endsWith("SECONDS"))
    }
```  


**@MethodSource**

@MethodSource Annotation은 테스트 클래스 또는 외부 클래스 하나 이상의 팩토리 메소드를 참조할  수 있습니다.

테스트 클래스에 @TestInstance (Lifecycle.PER\_CLASS)로 주석을 달지 않는 한 테스트 클래스 내의 팩토리 메소드는 static이어야 합니다. 반면, 외부 클래스의 팩토리 메소드는 항상 static 이어야합니다.

또한 이러한 팩토리 메소드는 인수를 허용하지 않아야합니다.

각 팩토리 메소드는 인수 스트림을 생성해야 하며

스트림 내의 각 인수 세트는 어노테이션이 있는 메소드의 개별 호출에 대한 실제 인수로 제공됩니다.

**example)**

```
    @ParameterizedTest
    @MethodSource("stringProvider")
    fun testWithExplicitLocalMethodSource(argument: String) {
        assertNotNull(argument)
    }

    companion object {
        @JvmStatic
        fun stringProvider(): Stream<String> = listOf("apple", "banana").stream()
    }
```

위와 같이 팩토리 메소드의 이름을 명시적으로 제공해주어야 합니다.

팩토리 메소드의 이름을 명시적으로 제공하지 않는다면

JUnit Jupiter의 규칙에 따라 현재 메소드와 이름이 동일한 팩토리 메소드를 검색합니다.

아래의 예와 같습니다.

```
 @ParameterizedTest
    @MethodSource
    fun testWithDefaultLocalMethodSource(argument: String) {
        assertNotNull(argument)
    }
    

    companion object {
        @JvmStatic
        fun testWithDefaultLocalMethodSource(): Stream<String> = listOf("apple", "banana").stream()
    }
```

매개변수화 된 테스트 메소드가 여러 매개 변수를 선언하는 경우`arguments` 를 이용합니다

 arguments (Object…)는 Arguments 인터페이스에 정의 된 정적 팩토리 메소드입니다.

또한 Arguments.of (Object…)를 인수 (Object…)의 대안으로 사용할 수도 있습니다.

```
  @ParameterizedTest
    @MethodSource("stringIntAndListProvider")
    fun testWithMultiArgMethodSource(str: String, num: Int, list: List<String>) {
        assertEquals(5, str.length)
        assertTrue(num in 1..2)
        assertEquals(2, list.size)
    }


    companion object {
     
        @JvmStatic
        fun stringIntAndListProvider(): Stream<Arguments> {
            return listOf<Arguments>(
                Arguments.of("apple", 1, listOf("a", "b")),
                Arguments.of("lemon", 2, listOf("x", "y"))
            ).stream()
        }
    }
```

Arguments.of() 를사용하려면 Kotlin이 컴파일 대상으로 JVM 1.6을 사용하므로 Java 인터페이스에서 기본 메소드를 사용할 수 없기 때문에  build.gradle에 아래와 같이 추가하여 주어야 합니다.

```
android{
	...
	kotlinOptions {
        jvmTarget = '1.8'
    }
}
```

또한 아래와 같이 외부의 static 팩토리 메소드를 참조 할  수도 있습니다.

```
class ExternalMethodSourceDemo {
    @ParameterizedTest
    @MethodSource("k.bs.junit5.parameterized_test.StringsProviders#tinyStrings")
    fun testWithExternalMethodSource(tinyString: String) {
        // test with tiny string
    }
}
```

```
object StringsProviders {

    @JvmStatic
    fun tinyStrings(): Stream<String> {
        return listOf(".", "oo", "OOO").stream()
    }
}
```

**@CsvSource**

인수 목록을 쉼표로 구분된 값으로 표현할 수 있습니다.

**example)**

```
  @ParameterizedTest
    @CsvSource(
        "apple,1",
        "banana,        2",
        "'lemon, lime', 0xF1"
    )
    fun testWithCsvSource(fruit: String, rank: Int) {
        assertNotNull(fruit)
        assertNotEquals(0, rank)
    }

```

@CsvSource 는 작은 따옴표 `'`를 안의 내용을 문자로 사용합니다.

아래 표의 'lemon , lime'을 같은 예입니다.

아무값도 입력되지않은 `''`경우는 빈값입니다.

반면 완전히 빈 값은 참조로 해석됩니다.

참조의 대상유형이 Primitive 인 경우 An이 발생합니다.(StringemptyValuenullArgumentConversionExceptionnul)

<table style="border-collapse: collapse; width: 100%;" border="1" data-ke-style="style8"><tbody><tr><td><p><b>입력 예</b></p></td><td><p>&nbsp;결과 인수 목록</p></td></tr><tr><td><p>@CsvSource({ "apple, banana" })</p></td><td><p>"apple",<span>&nbsp;</span>"banana"</p></td></tr><tr><td><p>@CsvSource({ "apple, 'lemon, lime'" })</p></td><td><p>"apple",<span>&nbsp;</span>"lemon, lime"</p></td></tr><tr><td><p>@CsvSource({ "apple, ''" })</p></td><td><p>"apple",<span>&nbsp;</span>""</p></td></tr><tr><td><p>@CsvSource({ "apple, " })</p></td><td><p>"apple",<span>&nbsp;</span>null</p></td></tr></tbody></table>

**@ArgumentsSource**

@ArgumentsSource재사용 가능한 사용자 정의를 지정하는 데 사용할 수 있습니다.

ArgumentsProvider의 구현은ArgumentsProvider 최상위 클래스 또는static중첩 클래스로 선언되어야합니다.

```
@ParameterizedTest
    @ArgumentsSource(MyArgumentsProvider::class)
    fun testWithArgumentsSource(argument: String) {
        assertNotNull(argument)
    }
```

```
class MyArgumentsProvider : ArgumentsProvider {

    override fun provideArguments(context: ExtensionContext): Stream<Arguments> {
        return listOf("apple", "banana").map { Arguments.of(it) }.stream()
    }
}
```

**3.16.3 인수 변환(Argument Conversion)**

****확대 변환****

JUnit Jupiter는 @ParameterizedTest에 제공된 인수에 대해 [확장 기본 변환](https://docs.oracle.com/javase/specs/jls/se8/html/jls-5.html#jls-5.1.2)을 지원합니다.

예를 들어, @ValueSource (ints = {1, 2, 3})로 주석이 달린 매개 변수화 된 테스트는 int 유형의 인수뿐만 아니라 long, float 또는 double 유형의 인수도 허용하도록 선언 할 수 있습니다.

******암시적 변환******

@CsvSource와 같은 사용 사례를 지원하기 위해 JUnit Jupiter는 여러 내장 암시 적 유형 변환기를 제공합니다. 

변환 프로세스는 각 메소드 매개 변수의 선언 된 유형에 따라 다릅니다.  
  
예를 들어, @ParameterizedTest가 TimeUnit 유형의 매개 변수를 선언하고 선언 된 소스에서 제공 한 실제 유형이 문자열 인 경우 문자열은 해당 TimeUnit 열거 상수로 자동 변환됩니다.

```
@ParameterizedTest
@ValueSource(strings = ["SECONDS"])
fun testWithImplicitArgumentConversion(argument: TimeUnit) {
    assertNotNull(argument.name)
}
```

문자열 인스턴스는 암시 적으로 다음 대상 유형으로 변환됩니다.  
  
10 진, 16 진 및 8 진 문자열 리터럴은 바이트, short, int, long 및 박스형 대응 문자의 정수 유형으로 변환됩니다.

[https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests-argument-conversion-implicit](https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests-argument-conversion-implicit)

[

JUnit 5 User Guide

Although the JUnit Jupiter programming model and extension model will not support JUnit 4 features such as Rules and Runners natively, it is not expected that source code maintainers will need to update all of their existing tests, test extensions, and cus

junit.org



](https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests-argument-conversion-implicit)

**Fallback String-to-Object Conversion**

JUnit Jupiter는 문자열에서 위 표에 나열된 대상 유형으로의 암시 적 변환 외에도 대상 유형이 정확히 하나의 적절한 팩토리 메소드 또는 팩토리 생성자를 선언하는 경우 문자열에서 지정된 대상 유형으로 자동 변환하는 폴백 메커니즘을 제공합니다.   
  
팩토리 메소드 : 단일 String 인수를 허용하고 대상 유형의 인스턴스를 리턴하는 대상 유형으로 선언 된 개인용이 아닌 정적 메소드. 메소드의 이름은 임의적 일 수 있으며 특정 규칙을 따를 필요가 없습니다.  
  
팩토리 생성자 : 단일 문자열 인수를 허용하는 대상 유형의 개인용이 아닌 생성자. 대상 유형은 최상위 클래스 또는 정적 중첩 클래스로 선언되어야합니다.  
  
여러 팩토리 메소드가 발견되면 무시됩니다. 팩토리 메소드와 팩토리 생성자가 발견되면 팩토리 메소드가 생성자 대신 사용됩니다.

  
예를 들어, 다음 @ParameterizedTest 메소드에서 Book 인수는 Book.fromTitle (String) 팩토리 메소드를 호출하고 책 제목으로 "42 Cats"를 전달하여 작성됩니다.

```
 @ParameterizedTest
    @ValueSource(strings = ["42 Cats"])
    fun testWithImplicitFallbackArgumentConversion(book: Book) {
        assertEquals("42 Cats", book.title)
    }
```

```
class Book private constructor(val title: String) {
    companion object {
        @JvmStatic
        fun fromTitle(title: String): Book {
            return Book(title)
        }
    }
}
```

******명시적 변환******

암시 적 인수 변환에 의존하는 대신다음 예제와 같이 Annotation  ArgumentConverter사용하여 특정 매개 변수에 사용할를 명시 적으로 지정할 수 있습니다@ConvertWith.의 구현은ArgumentConverter최상위 클래스 또는static중첩 클래스로 선언되어야합니다

```
@ParameterizedTest
    @EnumSource(TimeUnit::class)
    fun testWithExplicitArgumentConversion(@ConvertWith(ToStringArgumentConverter::class) argument: String) {
        assertNotNull(TimeUnit.valueOf(argument))
    }
```

```
class ToStringArgumentConverter : SimpleArgumentConverter() {

    override fun convert(source: Any, targetType: Class<*>): Any {
        assertEquals(String::class.java, targetType, "Can only convert to String")
        return source.toString()
    }
}
```

명시 적 인수 변환기는 테스트 및 확장 작성자가 구현해야합니다.따라서junit-jupiter-params참조 구현으로도 사용할 수있는 하나의 명시 적 인수 변환기 만 제공합니다JavaTimeArgumentConverter.구성된 Annotation을 통해 사용됩니다JavaTimeConversionPattern.

```
  @ParameterizedTest
    @ValueSource(strings = ["01.01.2017", "31.12.2017"])
    fun testWithExplicitJavaTimeConverter(@JavaTimeConversionPattern("dd.MM.yyyy") argument: LocalDate) {
        assertEquals(2017, argument.year)
    }
```

**3.16.4 인수 집계**

기본적으로메소드에제공된각인수@ParameterizedTest는 단일 메소드 매개 변수에 해당합니다.

결과적으로 많은 수의 인수를 제공 할 것으로 예상되는 인수 소스는 메소드 서명을 크게 만들 수 있습니다.

이러한 경우[ArgumentsAccessor](https://junit.org/junit5/docs/current/api/org/junit/jupiter/params/aggregator/ArgumentsAccessor.html)여러 매개 변수 대신을 사용할 수 있습니다.이 API를 사용하면 테스트 메소드에 전달 된 단일 인수를 통해 제공된 인수에 액세스 할 수 있습니다.또한 유형 변환은[암시 적 변환](https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests-argument-conversion-implicit)에서 설명한대로 지원됩니다.

```
 @ParameterizedTest
    @CsvSource(
        "Jane, Doe, F, 1990-05-20",
        "John, Doe, M, 1990-10-22"
    )
    fun testWithArgumentsAccessor(arguments: ArgumentsAccessor) {
        val person = Person(
            arguments.getString(0),
            arguments.getString(1),
            gender = arguments.get(2, Gender::class.java),
            birthDay = arguments.get(3, LocalDate::class.java)
        )

        if (person.getFirstName() == "Jane") {
            assertEquals(Gender.F, person.gender)
        } else {
            assertEquals(Gender.M, person.gender)
        }

        assertEquals("Doe", person.getLastName())
        assertEquals(1990, person.birthDay?.year)
    }
```

ArgumentsAccessor 인스턴스는 ArgumentsAccessor 유형의 모든 매개 변수에 자동으로 주입됩니다.

**Custom Aggregators(맞춤 수집기)**

JUnit Jupiter는을@ParameterizedTest사용하여 메소드의 인수에직접 액세스하는 것 외에도ArgumentsAccessor재사용 가능한 사용자 정의어 그리 게이터의 사용을 지원합니다.

사용자 정의 애그리 게이터를 사용하려면[ArgumentsAggregator](https://junit.org/junit5/docs/current/api/org/junit/jupiter/params/aggregator/ArgumentsAggregator.html)인터페이스를구현@AggregateWith하고

@ParameterizedTest메소드의 호환 가능한 매개 변수에 주석을통해 인터페이스를 등록하십시오.

그러면 매개 변수화 된 테스트가 호출 될 때 집계 결과가 해당 매개 변수에 대한 인수로 제공됩니다.

**example)**

```
@ParameterizedTest
    @CsvSource("Jane, Doe, F, 1990-05-20", "John, Doe, M, 1990-10-22")
    fun testWithArgumentsAggregator(@AggregateWith(PersonAggregator::class) person: Person) {
        // perform assertions against person
    }
```

```
class PersonAggregator : ArgumentsAggregator {
    override fun aggregateArguments(
        arguments: ArgumentsAccessor,
        context: ParameterContext
    ): Person {
        return Person(
            arguments.getString(0),
            arguments.getString(1),
            gender = arguments.get(2, Gender::class.java),
            birthDay = arguments.get(3, LocalDate::class.java)
        )
    }
}
```

자주쓰는 Aggregator가 있다면 

Annotation으로 생성하여 사용하는 것도 좋은 방법입니다.

```
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.VALUE_PARAMETER)
@AggregateWith(PersonAggregator::class)
annotation class CsvToPerson
```

```
@ParameterizedTest
    @CsvSource("Jane, Doe, F, 1990-05-20", "John, Doe, M, 1990-10-22")
    fun testWithCustomAggregatorAnnotation(@CsvToPerson person: Person) {
        // perform assertions against person
    }

```

**3.16.5 표시 이름 사용자 정의**

기본적으로 매개 변수화 된 테스트 호출의 표시 이름에는 호출 색인 및 해당 특정 호출에 대한 모든 인수의 문자열 표시가 포함됩니다.

그러나 다음 예제와 같이 @ParameterizedTest 주석의 name 속성을 통해 호출 표시 이름을 사용자 정의 할 수 있습니다.

```
 @DisplayName("Display name of container")
    @ParameterizedTest(name = "{index} ==> fruit=''{0}'', rank={1}")
    @CsvSource("apple, 1", "banana, 2", "'lemon, lime', 3")
    fun testWithCustomDisplayNames(fruit: String, rank: Int) {
    }
```  


다음 자리 표시자는 사용자 지정 표시 이름 내에서 지원됩니다.

<table style="border-collapse: collapse; width: 100%; height: 289px;" border="1" data-ke-style="style8"><tbody><tr style="height: 54px;"><td style="text-align: center; height: 54px;"><span style="color: #333333;">자리 표시자</span></td><td style="text-align: center; height: 54px;"><p><span style="color: #333333;">설명</span></p></td></tr><tr style="height: 54px;"><td style="height: 54px;"><p>{index}</p></td><td style="height: 54px;"><p>현재 호출 인덱스 (1 기반)</p></td></tr><tr style="height: 54px;"><td style="height: 54px;"><p>{arguments}</p></td><td style="height: 54px;"><p>쉼표로 구분 된 완전한 인수 목록</p></td></tr><tr style="height: 54px;"><td style="height: 54px;"><p>{0},<span>&nbsp;</span>{1}…</p></td><td style="height: 54px;"><p>개별 논쟁</p></td></tr></tbody></table>

**3.16.6 수명주기 및 상호 운용성**

매개 변수화 된 테스트를 호출 할 때마다 일반@Test메소드와 동일한 라이프 사이클이있습니다.

예를 들어,@BeforeEach메소드는 각 호출 전에 실행됩니다.[Dynamic Tests](https://junit.org/junit5/docs/current/user-guide/#writing-tests-dynamic-tests)와유사하게, 호출은 IDE의 테스트 트리에 하나씩 나타납니다.동일한 테스트 클래스 내에서정규@Test메소드와@ParameterizedTest메소드를혼합 할 수 있습니다.

메소드ParameterResolver와 함께 확장을사용할 수 있습니다@ParameterizedTest.그러나 인수 소스로 분석되는 메소드 매개 변수는 인수 목록에서 먼저 와야합니다.테스트 클래스에는 규칙적인 테스트와 다른 매개 변수 목록이있는 매개 변수화 된 테스트가 포함될 수 있으므로 인수 소스의 값은 수명주기 메소드 (예 :)@BeforeEach및 테스트 클래스 생성자에대해 분석되지 않습니다.

```
 @BeforeEach
    fun beforeEach(testInfo: TestInfo) {
        // ...
    }

    @ParameterizedTest
    @ValueSource(strings = ["apple","banana"])
    fun testWithRegularParameterResolver(argument: String, testReporter: TestReporter) {
        testReporter.publishEntry("argument", argument)
    }

    @AfterEach
    fun afterEach(testInfo: TestInfo) {
        // ...
    }
```  

</br>

### **동적 테스트 (Dynamic Tests)**

주석에 설명 된 JUnit Jupiter의 표준 @Test 어노테이션은 JUnit 4의 @Test 어노테이션과 매우 유사합니다.

둘 다 테스트 사례를 구현하는 메소드를 설명합니다. 이 테스트 케이스는 컴파일 타임에 완전히 지정되었다는 점에서 정적이며 런타임시 발생하는 동작으로 동작을 변경할 수 없습니다. 가정은 기본적인 형태의 역동적 행동을 제공하지만 의도적으로 표현력이 다소 제한적입니다.

JUnit Jupiter에서는 `**@TestFactory**` 어노테이션을 사용하여 동적으로 생성되는 테스트를 생성할 수 있습니다.

@Test 메소드와 달리 @TestFactory 메소드는 테스트 케이스가 아니라 테스트 케이스의 팩토리입니다.

따라서 동적 테스트는 공장의 제품입니다.

**@TestFactory 메소드는 단일 DynamicNode 또는 Stream, Collection, Iterable, Iterator 또는 DynamicNode 인스턴스 배열을 리턴해야합니다.** DynamicNode의 인스턴스화 가능한 서브 클래스는 DynamicContainer 및 **DynamicTest**입니다. **DynamicContainer** 인스턴스는 표시 이름과 동적 자식 노드 목록으로 구성되어 임의로 중첩 된 동적 노드 계층을 만들 수 있습니다. DynamicTest 인스턴스는 느리게 실행되어 동적이면서도 비 결정적 테스트 사례를 생성 할 수 있습니다.

@TestFactory에 의해 반환 된 모든 Stream은 stream.close ()를 호출함으로써 올바로 닫히게되어 Files.lines ()와 같은 리소스를 안전하게 사용할 수 있습니다.

@Test 메소드와 마찬가지로 @TestFactory 메소드는 private 또는 static이  아니어야하며 선택적으로 ParameterResolvers가 분석 할 매개 변수를 선언 할 수 있습니다. DynamicTest는 런타임에 생성 된 테스트 케이스입니다. 표시 이름과 실행 파일로 구성됩니다. Executable은 @FunctionalInterface이며 동적 테스트 구현은 람다 식 또는 메서드 참조로 제공 될 수 있습니다.

  

동적 테스트 수명주기

  

  

동적 테스트의 실행 수명주기는 표준 @Test 케이스와는 상당히 다릅니다.

특히 개별 동적 테스트에 대한 수명주기 콜백이 없습니다.

이는 @BeforeEach 및 @AfterEach 메소드와 해당 확장 콜백이 @TestFactory 메소드에 대해 실행되지만 각 동적 테스트에 대해 실행되지 않음을 의미합니다.

다시 말해, 동적 테스트를위한 람다 식 내에서 테스트 인스턴스의 필드에 액세스하는 경우 동일한 @TestFactory 메소드로 생성 된 개별 동적 테스트 실행 사이의 콜백 메소드 또는 확장으로 해당 필드가 재설정되지 않습니다.

**동적 테스트 예시**

다음DynamicTestsDemo클래스는 테스트 팩토리 및 동적 테스트의 몇 가지 예를 보여줍니다.

첫 번째 메소드(dynamicTestsWithInvalidReturnType)는 유효하지 않은 리턴 유형을 리턴합니다.

컴파일시 유효하지 않은 리턴 유형을 감지 할 수 없으므로JUnitException런타임에 감지되면a가 발생합니다.

그 다음 다섯 가지 방법은 생성 보여 매우 간단한 예입니다Collection,Iterable,Iterator, 또는Stream의DynamicTest인스턴스.이 예제의 대부분은 실제로 동적 동작을 나타내지 않고 원칙적으로 지원되는 리턴 유형을 보여줍니다.

그러나,dynamicTestsFromStream()그리고dynamicTestsFromIntStream() 그 문자열의 주어진 세트 또는 입력 번호의 범위의 동적 시험을 생성하는 방법을 쉽게 입증합니다.

다음 방법은 실제로 동적입니다.generateRandomNumberOfTests()구현하는Iterator임의의 숫자 표시 이름 생성기 및 테스트 실행 프로그램을 생성하고 그 다음에 세를 제공한다DynamicTest.stream().비 결정적 행동은generateRandomNumberOfTests()물론 테스트 반복성과 상충되므로주의해서 사용해야하지만 동적 테스트의 표현력과 힘을 보여줍니다.

마지막 method는 DynamicContainer를 사용하여 중첩 된 동적 테스트 계층 구조를 생성합니다

```
class DynamicTestsDemo {

    private val calculator = Calculator()

    // This will result in a JUnitException!
    @TestFactory
    fun dynamicTestsWithInvalidReturnType(): List<String> {
        return listOf("Hello")
    }

    @TestFactory
    fun dynamicTestsFromCollection(): Collection<DynamicTest> {
        return listOf(
            dynamicTest("1st dynamic test") { assertTrue("madam".isPalindrome()) },
            dynamicTest("2nd dynamic test") { assertEquals(4, calculator.multiply(2, 2)) }
        )
    }

    @TestFactory
    fun dynamicTestsFromIterable(): Iterable<DynamicTest> {
        return listOf(
            dynamicTest("3rd dynamic test") { assertTrue("madam".isPalindrome()) },
            dynamicTest("4th dynamic test") { assertEquals(4, calculator.multiply(2, 2)) }
        )
    }

    @TestFactory
    fun dynamicTestsFromIterator(): Iterator<DynamicTest> {
        return listOf(
            dynamicTest("5th dynamic test") { assertTrue("madam".isPalindrome()) },
            dynamicTest("6th dynamic test") { assertEquals(4, calculator.multiply(2, 2)) }
        ).iterator()
    }

    @TestFactory
    fun dynamicTestsFromArray(): Array<DynamicTest> {
        return arrayOf(
            dynamicTest("7th dynamic test") { assertTrue("madam".isPalindrome()) },
            dynamicTest("8th dynamic test") { assertEquals(4, calculator.multiply(2, 2)) })
    }

    @TestFactory
    fun dynamicTestsFromStream(): Stream<DynamicTest> {
        return listOf("racecar", "radar", "mom", "dad")
            .map { text -> dynamicTest(text) { assertTrue(text.isPalindrome()) } }
            .stream()
    }

    @TestFactory
    fun dynamicTestsFromIntStream(): Stream<DynamicTest> {
        // Generates tests for the first 10 even integers.
        return IntStream.iterate(0) { n -> n + 2 }.limit(10)
            .mapToObj { n -> dynamicTest("test$n") { assertTrue(n % 2 == 0) } }
    }

    @TestFactory
    fun generateRandomNumberOfTests(): Stream<DynamicTest> {

        // Generates random positive integers between 0 and 100 until
        // a number evenly divisible by 7 is encountered.
        val inputGenerator = object : Iterator<Int> {

            internal var random = Random()
            internal var current: Int = 0

            override fun hasNext(): Boolean {
                current = random.nextInt(100)
                return current % 7 != 0
            }

            override fun next(): Int {
                return current
            }
        }

        // Generates display names like: input:5, input:37, input:85, etc.
        val displayNameGenerator: (a: Int) -> String = { input -> "input:$input" }

        // Executes tests based on the current input value.
        val testExecutor: (a: Int) -> Unit = { input -> assertTrue(input % 7 != 0) }

        // Returns a stream of dynamic tests.
        return DynamicTest.stream(inputGenerator, displayNameGenerator, testExecutor)
    }

    @TestFactory
    fun dynamicTestsWithContainers(): Stream<DynamicNode> {
        return Stream.of("A", "B", "C")
            .map { input ->
                dynamicContainer(
                    "Container $input", Stream.of(
                        dynamicTest("not null") { assertNotNull(input) },
                        dynamicContainer("properties", Stream.of(
                            dynamicTest("length > 0") { assertTrue(input.isNotEmpty()) },
                            dynamicTest("not empty") { assertFalse(input.isEmpty()) }
                        ))
                    ))
            }
    }

    @TestFactory
    fun dynamicNodeSingleTest(): DynamicNode {
        return dynamicTest("'pop' is a palindrome") { assertTrue("pop".isPalindrome()) }
    }

    @TestFactory
    fun dynamicNodeSingleContainer(): DynamicNode {
        return dynamicContainer("palindromes",
            Stream.of("racecar", "radar", "mom", "dad")
                .map { text -> dynamicTest(text) { assertTrue(text.isPalindrome()) } })
    }
}
```  

</br>

### **타임아웃 (TimeOut)**

@Timeout주석은 하나의 실행 시간이 주어진 기간을 초과하는 경우 테스트, 시험 공장, 테스트 템플릿, 또는 수명주기 방법이 실패 할 것을 선언 할 수 있습니다.지속 시간의 시간 단위는 기본적으로 초이지만 구성 할 수 있습니다.

다음 예제는@Timeout수명주기 및 테스트  method에 적용되는방법을 보여줍니다.

```
class TimeoutDemo {

    @BeforeEach
    @Timeout(5)
    fun setUp() {
        // fails if execution time exceeds 5 seconds
    }

    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    fun failsIfExecutionTimeExceeds100Milliseconds() {
        // fails if execution time exceeds 100 milliseconds
    }

}
```

**assertTimeoutPreemptively ()** 어설션과 달리 어노테이션이있는 메소드의 실행은 테스트의 기본 스레드에서 진행됩니다.

제한 시간이 초과되면 다른 스레드에서 기본 스레드가 중단됩니다.

이는 현재 실행중인 스레드 (예 : ThreadLocal 트랜잭션 관리)에 민감한 메커니즘을 사용하는 Spring과 같은 프레임 워크와의 상호 운용성을 보장하기 위해 수행됩니다.

**테스트 클래스 내의 모든 테스트 메소드 및 모든 @Nested 클래스에 동일한 제한 시간을 적용하기 위해 클래스 레벨에서**

**@Timeout 어노테이션을 선언 할 수 있습니다**. 그런 다음 특정 메서드 또는 @Nested 클래스의 @Timeout 주석으로 재정의되지 않는 한 해당 클래스와 해당 @Nested 클래스 내의 모든 테스트, 테스트 팩토리 및 테스트 템플릿 메서드에 적용됩니다.

**클래스 수준에서 선언 된 @Timeout 주석은 수명주기 메서드에 적용되지 않습니다.**

**@TestFactory 메소드에서 @Timeout을 선언하면 팩토리 메소드가 지정된 기간 내에 리턴되는지 확인하지만 팩토리가 생성 한 각 개별 DynamicTest의 실행 시간을 확인합니다.** 이를 위해 assertTimeout () 또는 assertTimeoutPreemptively ()를 사용하십시오. @Timeout이 @TestTemplate 메서드 (예 : @RepeatedTest 또는 @ParameterizedTest)에 있으면 각 호출에 지정된 시간 초과가 적용됩니다. 다음

다음[구성 매개 변수](https://junit.org/junit5/docs/current/user-guide/#running-tests-config-params)를 사용하여 특정 카테고리의 모든 메소드에 대한 글로벌 제한 시간을 지정하거나 포함 된 테스트 클래스에 @Timeout어노테이션이 없도록 타임아웃을 설정할 수 있습니다.

**junit.jupiter.execution.timeout.default**

모든 테스트 가능 및 수명주기 방법에 대한 기본 시간 초과

**junit.jupiter.execution.timeout.testable.method.default**

모든 테스트 가능한 메소드에 대한 기본 제한 시간

**junit.jupiter.execution.timeout.test.method.default**

@Test메소드의기본 시간 종료

**junit.jupiter.execution.timeout.testtemplate.method.default**

@TestTemplate메소드의기본 시간 종료

**junit.jupiter.execution.timeout.testfactory.method.default**

@TestFactory메소드의기본 시간 종료

**junit.jupiter.execution.timeout.lifecycle.method.default**

모든 수명주기 방법에 대한 기본 시간 초과

**junit.jupiter.execution.timeout.beforeall.method.default**

@BeforeAll메소드의기본 시간 종료

**junit.jupiter.execution.timeout.beforeeach.method.default**

@BeforeEach메소드의기본 시간 종료

**junit.jupiter.execution.timeout.aftereach.method.default**

@AfterEach메소드의기본 시간 종료

**junit.jupiter.execution.timeout.afterall.method.default**

@AfterAll메소드의기본 시간 종료

보다 구체적인 구성 매개 변수는 덜 구체적인 구성 매개 변수보다 우선합니다.예를 들어,junit.jupiter.execution.timeout.test.method.defaultoverridesjunit.jupiter.execution.timeout.testable.method.default를 대체junit.jupiter.execution.timeout.default합니다.

이러한 구성 매개 변수의 값은 대소 문자를 구분하지 않는 다음 형식이어야합니다<number> \[ns|μs|ms|s|m|h|d\]..숫자와 단위 사이의 공백은 생략 될 수 있습니다.단위를 지정하지 않으면 초를 사용하는 것과 같습니다.

표 1. 시간 종료 구성 매개 변수 값 예파라미터 값동등한 주석

<table style="border-collapse: collapse; width: 100%;" border="1"><tbody><tr><td><p>42</p></td><td><p>@Timeout(42)</p></td></tr><tr><td><p>42 ns</p></td><td><p>@Timeout(value = 42, unit = NANOSECONDS)</p></td></tr><tr><td><p>42 μs</p></td><td><p>@Timeout(value = 42, unit = MICROSECONDS)</p></td></tr><tr><td><p>42 ms</p></td><td><p>@Timeout(value = 42, unit = MILLISECONDS)</p></td></tr><tr><td><p>42 s</p></td><td><p>@Timeout(value = 42, unit = SECONDS)</p></td></tr><tr><td><p>42 m</p></td><td><p>@Timeout(value = 42, unit = MINUTES)</p></td></tr><tr><td><p>42 h</p></td><td><p>@Timeout(value = 42, unit = HOURS)</p></td></tr><tr><td><p>42 d</p></td><td><p>@Timeout(value = 42, unit = DAYS)</p></td></tr></tbody></table>

**폴링 테스트에 @Timeout 사용**

비동기 코드를 처리 할 때는 어설 션을 수행하기 전에 어떤 일이 발생하기를 기다리는 동안 폴링하는 테스트를 작성하는 것이 일반적입니다.경우에 따라CountDownLatch또는 다른 동기화 메커니즘을 사용하도록 로직을 다시 작성할 수있지만 때로는 불가능합니다.

예를 들어 테스트중인 대상이 외부 메시지 브로커의 채널에 메시지를 전송하고 메시지가 나타날 때까지 어설 션을 수행 할 수없는 경우 채널을 통해 성공적으로 전송되었습니다.이와 같은 비동기 테스트는 비동기 메시지가 성공적으로 전달되지 않는 경우처럼 무한정으로 실행하여 테스트 스위트가 중단되지 않도록하기 위해 일정 시간 종료 형식이 필요합니다.

폴링하는 비동기 테스트에 대한 제한 시간을 구성하여 테스트가 무기한으로 실행되지 않도록 할 수 있습니다.다음 예제는 JUnit Jupiter의@Timeout주석으로이를 달성하는 방법을 보여줍니다.이 기술은 "poll until"논리를 매우 쉽게 구현하는 데 사용할 수 있습니다.

```
 @Test
    @Timeout(5) // Poll at most 5 seconds
    @Throws(InterruptedException::class)
    fun pollUntil() {
        while (asynchronousResultNotAvailable()) {
            Thread.sleep(250) // custom poll interval
        }
        // Obtain the asynchronous result and perform assertions
    }
```

### **병렬실행 (Parallel Execution)**

기본적으로 JUnit Jupiter 테스트는 단일 스레드에서 순차적으로 실행됩니다.

테스트를 병렬은 (예 : 실행 속도 향상) 버전 5.3부터 옵트 인 기능으로 사용할 수 있습니다.

병렬 실행을 사용하려면 junit.jupiter.execution.parallel.enabled 구성 매개 변수를 true로 설정하십시오 (예 : junit-platform.properties) (다른 옵션의 구성 매개 변수 참조).

이 속성을 활성화하는 것은 테스트를 병렬로 실행하는 데 필요한 첫 번째 단계 일뿐입니다.

활성화 된 경우 테스트 클래스 및 메소드는 기본적으로 계속 순차적으로 실행됩니다.

테스트 트리의 노드가 동시에 실행되는지 여부는 실행 모드에 의해 제어됩니다.

다음 두 가지 모드를 사용할 수 있습니다.

**SAME\_THREAD**

부모가 사용하는 동일한 스레드에서 강제로 실행하십시오. 예를 들어, 테스트 메소드에서 사용될 때 테스트 메소드는 포함하는 테스트 클래스의 @BeforeAll 또는 @AfterAll 메소드와 동일한 스레드에서 실행됩니다.

**CONCURRENT**

리소스 잠금이 동일한 스레드에서 강제 실행되지 않는 한 동시에 실행됩니다.

기본적으로 테스트 트리의 노드는 SAME\_THREAD 실행 모드를 사용합니다.

junit.jupiter.execution.parallel.mode.default 구성 매개 변수를 설정하여 기본값을 변경할 수 있습니다. 또는 @Execution 어노테이션을 사용하여 주석이있는 요소 및 해당 하위 요소 (있는 경우)의 실행 모드를 개별 테스트 클래스에 대한 병렬 실행을 하나씩 활성화 할 수 있도록 변경할 수 있습니다

**모든 테스트를 병렬로 실행하기위한 구성 매개 변수**

```
junit.jupiter.execution.parallel.enabled = true 
junit.jupiter.execution.parallel.mode.default = concurrent
```

기본 실행 모드는 몇 가지 주목할만한 예외, 즉 Lifecycle.PER\_CLASS 모드 또는 MethodOrderer (임의의 경우 제외)를 사용하는 테스트 클래스를 제외하고 테스트 트리의 모든 노드에 적용됩니다.

전자의 경우, 테스트 작성자는 테스트 클래스가 스레드로부터 안전해야합니다. 후자의 경우 동시 실행이 구성된 실행 순서와 충돌 할 수 있습니다. 따라서 두 경우 모두 이러한 테스트 클래스의 테스트 메소드는 @Execution (CONCURRENT) 주석이 테스트 클래스 또는 메소드에 존재하는 경우에만 동시에 실행됩니다.

CONCURRENT 실행 모드로 구성된 테스트 트리의 모든 노드는 선언 된 동기화 메커니즘을 관찰하면서 제공된 구성에 따라 완전히 병렬로 실행됩니다.

캡처 표준 출력 / 오류는 별도로 활성화해야합니다. 또한 junit.jupiter.execution.parallel.mode.classes.default 구성 매개 변수를 설정하여 최상위 클래스의 기본 실행 모드를 구성 할 수 있습니다. 두 구성 매개 변수를 결합하면 클래스가 병렬로 실행되지만 메소드가 동일한 스레드에서 실행되도록 구성 할 수 있습니다.

**최상위 클래스를 병렬로 실행하지만 동일한 스레드에서 메소드를 실행하기위한 구성 매개 변수**

```
junit.jupiter.execution.parallel.enabled = true
junit.jupiter.execution.parallel.mode.default = same_thread
junit.jupiter.execution.parallel.mode.classes.default = concurrent
```

반대 조합은 한 클래스 내에서 모든 메소드를 병렬로 실행하지만 최상위 클래스는 순차적으로 실행됩니다.

**최상위 레벨 클래스를 순차적으로 실행하지만 해당 메소드를 병렬로 실행하는 구성 매개 변수**

```
junit.jupiter.execution.parallel.enabled = true
junit.jupiter.execution.parallel.mode.default = concurrent
junit.jupiter.execution.parallel.mode.classes.default = same_thread
```

다음 다이어그램은 두 개의 최상위 레벨 테스트 클래스를 실행A하고B클래스 당 두 개의 테스트 메소드를 사용하여junit.jupiter.execution.parallel.mode.default및의네 가지 조합 모두에대해 어떻게 작동하는지 보여줍니다junit.jupiter.execution.parallel.mode.classes.default(첫 번째 열의 레이블 참조).


**기본 실행 모드 구성 조합**

junit.jupiter.execution.parallel.mode.classes.default구성 매개 변수가 명시 적으로 설정되지 않은경우에대한 값junit.jupiter.execution.parallel.mode.default이 대신 사용됩니다.

**3.19.1 구성 (Configuration)**

원하는 병렬 처리 및 최대 풀 크기와 같은 속성은을 사용하여 구성 할 수 있습니다[ParallelExecutionConfigurationStrategy](https://junit.org/junit5/docs/current/api/org/junit/platform/engine/support/hierarchical/ParallelExecutionConfigurationStrategy.html)의 JUnit 플랫폼은 상자 밖으로 두 가지 구현을 제공dynamic하고fixed.또는custom전략을구현할 수도 있습니다.

전략을 선택하려면**junit.jupiter.execution.parallel.config.strategy**구성 매개 변수를 다음 옵션 중 하나로설정하십시오.

**\- dynamic**

사용 가능한 프로세서 / 코어 수에junit.jupiter.execution.parallel.config.dynamic.factor구성 매개 변수를곱한값 (기본값은1)을기준으로 원하는 병렬 처리를 계산합니다.

**\- fixed**

필수junit.jupiter.execution.parallel.config.fixed.parallelism구성 매개 변수를 원하는 병렬 처리로사용합니다.

**\- custom**

[ParallelExecutionConfigurationStrategy](https://junit.org/junit5/docs/current/api/org/junit/platform/engine/support/hierarchical/ParallelExecutionConfigurationStrategy.html)필수junit.jupiter.execution.parallel.config.custom.class구성 매개 변수를통해사용자 정의구현을 지정하여 원하는 구성을 결정할 수 있습니다.

구성 전략이 설정되지 않은 경우 JUnit Jupiter는dynamic인수로 구성 전략을사용합니다1.결과적으로 원하는 병렬 처리는 사용 가능한 프로세서 / 코어 수와 같습니다

  

병렬 처리는 최대 동시 스레드 수를 의미하지 않습니다.

  

JUnit Jupiter는 동시에 실행되는 테스트 수가 구성된 병렬 처리를 초과하지 않을 것이라고 보장하지 않습니다.

예를 들어, 다음 섹션에서 설명하는 동기화 메커니즘 중 하나를 사용할 때ForkJoinPool, 씬 뒤에 사용되는동기화 메커니즘은실행이 충분한 병렬 처리를 계속하도록 추가 스레드를 생성 할 수 있습니다.

따라서 테스트 클래스에서 이러한 보증이 필요한 경우 자체 동시성 제어 수단을 사용하십시오.

**3.19.2 동기화( Synchronization)**

[@Execution](https://junit.org/junit5/docs/current/api/org/junit/jupiter/api/parallel/Execution.html)JUnit Jupiter는 주석을사용하여 실행 모드를 제어하는 ​​것 외에도다른 주석 기반 선언적 동기화 메커니즘을 제공합니다.

[@ResourceLock](https://junit.org/junit5/docs/current/api/org/junit/jupiter/api/parallel/ResourceLock.html)주석은 당신이 테스트 클래스 나 메소드가 신뢰할 수있는 테스트 실행을 보장하기 위해 동기화 된 액세스를 필요로하는 특정 공유 자원을 사용한다는 선언 할 수 있습니다.공유 리소스는 고유 한 이름으로 식별됩니다String.이름이 될 수있는 사용자 정의 또는 미리 정의 된 상수 중 하나입니다.[Resources](https://junit.org/junit5/docs/current/api/org/junit/jupiter/api/parallel/Resources.html):SYSTEM\_PROPERTIES,SYSTEM\_OUT,SYSTEM\_ERR,LOCALE, 또는TIME\_ZONE.

다음 예제의 테스트가[@ResourceLock을](https://junit.org/junit5/docs/current/api/org/junit/jupiter/api/parallel/ResourceLock.html)사용하지 않고병렬로 실행 된경우비정상적입니다.

때로는 통과 할 수도 있고 같은 JVM 시스템 속성을 작성하고 읽는 고유의 경쟁 조건으로 인해 실패 할 수도 있습니다.

**[@ResourceLock](https://junit.org/junit5/docs/current/api/org/junit/jupiter/api/parallel/ResourceLock.html)어노테이션을사용하여 공유 자원에 대한 액세스가 선언되면 JUnit Jupiter 엔진은이 정보를 사용하여 충돌 테스트가 병렬로 실행되지 않도록합니다.**

**String공유 리소스를 고유하게 식별하는것 외에도액세스 모드를 지정할 수 있습니다.**

**READ공유 리소스에 액세스해야하는 두 가지 테스트는서로 병렬로 실행될 수 있지만READ\_WRITE동일한 공유 리소스에 액세스해야하는 다른 테스트는 실행되지 않습니다.**

**example)**

```
@Execution(ExecutionMode.CONCURRENT)
class SharedResourcesDemo {

    private var backup: Properties? = null

    @BeforeEach
    fun backup() {
        backup = Properties()
        backup!!.putAll(System.getProperties())
    }

    @AfterEach
    fun restore() {
        System.setProperties(backup)
    }

    @Test
    @ResourceLock(value = SYSTEM_PROPERTIES, mode = ResourceAccessMode.READ)
    fun customPropertyIsNotSetByDefault() {
        assertNull(System.getProperty("my.prop"))
    }

    @Test
    @ResourceLock(value = SYSTEM_PROPERTIES, mode = ResourceAccessMode.READ_WRITE)
    fun canSetCustomPropertyToApple() {
        System.setProperty("my.prop", "apple")
        assertEquals("apple", System.getProperty("my.prop"))
    }

    @Test
    @ResourceLock(value = SYSTEM_PROPERTIES, mode = ResourceAccessMode.READ_WRITE)
    fun canSetCustomPropertyToBanana() {
        System.setProperty("my.prop", "banana")
        assertEquals("banana", System.getProperty("my.prop"))
    }
}
```  
