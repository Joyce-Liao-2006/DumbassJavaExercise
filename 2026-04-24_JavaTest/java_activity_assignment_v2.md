# Java 程式設計課堂作業
## 小專案：校園活動管理系統（Activity Management System）

---

## 一、題目情境

某大學學生事務處希望開發一套簡化版的「校園活動管理系統」，用來管理不同類型的校園活動，例如演講、競賽與工作坊。  
由於不同活動在報名規則、評分方式與證書發放條件上有所不同，因此系統設計時不能只用單一類別處理所有活動，而必須透過物件導向的方式，將共通特徵與特殊行為分別設計。

在這個小專案中，你需要根據教師提供的介面與主程式，完成其餘必要類別，讓整個系統可以正確執行。  
本題的設計目標，是希望你能整合目前課程中學到的幾個核心概念，包括：

- 抽象類別（abstract class）
- 繼承（inheritance）
- 方法覆寫（override）
- 介面（interface）
- 多型（polymorphism）
- inner class
- Lambda 表達式
- 陣列與物件管理

---

## 二、功能說明

本系統需支援以下三種活動：

1. **Lecture（演講）**
   - 有活動時數 `hours`
   - 可供學生報名
   - 已報名者可取得證書
   - 活動分數依時數計算

2. **Competition（競賽）**
   - 有三位評審分數
   - 可供學生報名
   - 可根據平均分數決定獎項等級
   - 活動分數為三位評審分數平均

3. **Workshop（工作坊）**
   - 有材料費 `materialFee`
   - 可供學生報名
   - 僅有報名且實際出席者才能取得證書
   - 活動分數依材料費計算

此外，系統還需要具備以下能力：

- 管理活動報名名單
- 防止同一位學生重複報名
- 防止超過活動最大人數
- 顯示各活動資訊
- 根據活動型別判斷是否可得獎或可取得證書
- 使用 `Arrays.sort()` 與 Lambda 依活動分數排序

---

## 三、作業要求

請根據教師提供的介面與主程式，完成以下類別：

- `Activity`（抽象類別）
- `Lecture`
- `Competition`
- `Workshop`

你必須讓教師提供的 `Main.java` 可以直接編譯並正確執行。

---

## 四、類別設計要求

### 1. `Activity` 必須是抽象類別

需至少包含以下欄位：

```java
protected String name;
protected String date;
protected int maxParticipants;
protected Participant[] participants;
protected int participantCount;
```

並至少包含以下方法：

```java
public String getName()
public abstract void showInfo()
public abstract double calculateScore()
```

---

### 2. `Activity` 中必須包含 inner class：`Participant`

`Participant` 必須定義在 `Activity` 類別內部，至少包含：

- `studentName`
- `attended`

以及下列方法：

- 建構子
- `getStudentName()`
- `isAttended()`
- `markAttended()`

---

### 3. `Lecture` 類別要求

- 繼承 `Activity`
- 實作 `Registrable`
- 實作 `Certifiable`

額外欄位：

```java
private int hours;
```

規則：

- `calculateScore()` = `hours * 10`
- 已報名者即可取得證書
- 不可重複報名
- 不可超過最大人數

---

### 4. `Competition` 類別要求

- 繼承 `Activity`
- 實作 `Registrable`
- 實作 `Awardable`

額外欄位：

```java
private double score1;
private double score2;
private double score3;
```

規則：

- `calculateScore()` = 三位評審平均分數
- `getAwardLevel()` 規則如下：
  - 平均分數 >= 90 → `Gold`
  - 平均分數 >= 80 → `Silver`
  - 平均分數 >= 70 → `Bronze`
  - 否則 → `None`
- 不可重複報名
- 不可超過最大人數

---

### 5. `Workshop` 類別要求

- 繼承 `Activity`
- 實作 `Registrable`
- 實作 `Certifiable`

額外欄位：

```java
private int materialFee;
```

規則：

- `calculateScore()` = `100 - materialFee`
- 只有「已報名且已出席」者才能取得證書
- 必須提供：

```java
public void markAttendance(String studentName)
```

- 不可重複報名
- 不可超過最大人數

---

## 五、限制條件

### 不可使用
- `ArrayList`
- `LinkedList`
- `HashMap`
- 其他 Collection Framework 類別

### 必須使用
- 陣列（array）
- `participantCount` 追蹤目前報名人數
- inner class
- 抽象類別
- 介面
- 多型

---

## 六、教師提供的介面程式

> 注意：以下介面名稱與方法名稱不可修改。

### `Registrable.java`

```java
/**
 * 代表某個活動具有「可報名」的能力。
 * 實作此介面的類別必須提供報名方法。
 */
public interface Registrable {

    /**
     * 讓指定學生報名此活動。
     *
     * @param studentName 學生姓名
     * @return 若報名成功則回傳 true，否則回傳 false
     */
    boolean register(String studentName);
}
```

---

### `Awardable.java`

```java
/**
 * 代表某個活動具有「可評定獎項」的能力。
 * 實作此介面的類別必須能回傳獎項等級。
 */
public interface Awardable {

    /**
     * 取得此活動目前對應的獎項等級。
     *
     * @return 獎項等級字串，例如 Gold、Silver、Bronze、None
     */
    String getAwardLevel();
}
```

---

### `Certifiable.java`

```java
/**
 * 代表某個活動具有「可發放證書」的能力。
 * 實作此介面的類別必須能判斷指定學生是否可取得證書。
 */
public interface Certifiable {

    /**
     * 判斷指定學生是否符合取得證書的資格。
     *
     * @param studentName 學生姓名
     * @return 若可取得證書則回傳 true，否則回傳 false
     */
    boolean canGetCertificate(String studentName);
}
```

---

## 七、教師提供的主程式

> 注意：
> 1. 學生不得修改 `Main.java`
> 2. 你的程式必須能直接搭配以下主程式編譯與執行

### `Main.java`

```java
import java.util.Arrays;

/**
 * 主程式：
 * 用來測試學生所完成的 Activity、Lecture、Competition、Workshop 類別，
 * 並驗證其是否正確實作抽象類別、介面、多型、inner class 與 Lambda 排序等概念。
 */
public class Main {

    /**
     * 程式進入點。
     * 建立三種活動物件，測試報名、顯示資訊、獎項/證書判定，以及依分數排序的功能。
     *
     * @param args 命令列參數
     */
    public static void main(String[] args) {
        Activity[] activities = new Activity[3];

        activities[0] = new Lecture("AI_Lecture", "2026-05-01", 2, 3);
        activities[1] = new Competition("Hackathon", "2026-05-10", 3, 80, 85, 90);
        activities[2] = new Workshop("UI_Workshop", "2026-05-15", 2, 50);

        System.out.println("=== Register Result ===");
        testRegister((Registrable) activities[0], "AI_Lecture", "Alice");
        testRegister((Registrable) activities[0], "AI_Lecture", "Bob");
        testRegister((Registrable) activities[0], "AI_Lecture", "Bob");
        testRegister((Registrable) activities[0], "AI_Lecture", "Carol");

        testRegister((Registrable) activities[1], "Hackathon", "Tom");
        testRegister((Registrable) activities[1], "Hackathon", "Jane");

        testRegister((Registrable) activities[2], "UI_Workshop", "Mary");
        testRegister((Registrable) activities[2], "UI_Workshop", "John");

        ((Workshop) activities[2]).markAttendance("Mary");

        System.out.println();

        System.out.println("=== Activity Info ===");
        for (int i = 0; i < activities.length; i++) {
            activities[i].showInfo();
            System.out.println();
        }

        System.out.println("=== Award / Certificate Check ===");
        for (int i = 0; i < activities.length; i++) {
            System.out.println("Activity: " + activities[i].getName());

            if (activities[i] instanceof Awardable) {
                Awardable a = (Awardable) activities[i];
                System.out.println("Award Level: " + a.getAwardLevel());
            }

            if (activities[i] instanceof Certifiable) {
                Certifiable c = (Certifiable) activities[i];
                System.out.println("Alice certificate: " + c.canGetCertificate("Alice"));
                System.out.println("Mary certificate: " + c.canGetCertificate("Mary"));
                System.out.println("John certificate: " + c.canGetCertificate("John"));
            }

            System.out.println();
        }

        System.out.println("=== Sorted Activities ===");
        Arrays.sort(activities, (a, b) -> Double.compare(b.calculateScore(), a.calculateScore()));

        for (int i = 0; i < activities.length; i++) {
            System.out.println(activities[i].getName() + " " + activities[i].calculateScore());
        }
    }

    /**
     * 測試指定活動的報名功能，並輸出報名是否成功。
     *
     * @param r 可報名活動的介面型別物件
     * @param activityName 活動名稱
     * @param studentName 學生姓名
     */
    public static void testRegister(Registrable r, String activityName, String studentName) {
        boolean result = r.register(studentName);

        if (result) {
            System.out.println("Register: " + studentName + " -> " + activityName + " SUCCESS");
        } else {
            System.out.println("Register: " + studentName + " -> " + activityName + " FAIL");
        }
    }
}
```

---

## 八、預期輸出（範例）

> 說明：  
> 下列輸出為主要測試流程的範例。  
> `showInfo()` 的格式可由教師另外規定，但至少應能正確顯示活動資訊與報名名單。

```text
=== Register Result ===
Register: Alice -> AI_Lecture SUCCESS
Register: Bob -> AI_Lecture SUCCESS
Register: Bob -> AI_Lecture FAIL
Register: Carol -> AI_Lecture FAIL
Register: Tom -> Hackathon SUCCESS
Register: Jane -> Hackathon SUCCESS
Register: Mary -> UI_Workshop SUCCESS
Register: John -> UI_Workshop SUCCESS

=== Activity Info ===
（依學生實作內容顯示）

=== Award / Certificate Check ===
Activity: AI_Lecture
Alice certificate: true
Mary certificate: false
John certificate: false

Activity: Hackathon
Award Level: Silver

Activity: UI_Workshop
Alice certificate: false
Mary certificate: true
John certificate: false

=== Sorted Activities ===
Hackathon 85.0
UI_Workshop 50.0
AI_Lecture 30.0
```

---

## 九、評分重點

| 項目 | 說明 |
|---|---|
| 抽象類別設計 | 是否正確設計 `Activity` 並定義抽象方法 |
| 繼承與覆寫 | 是否正確讓子類別繼承並覆寫方法 |
| 介面實作 | 是否正確實作 `Registrable`、`Awardable`、`Certifiable` |
| 多型使用 | 是否能正確搭配 `Activity[]`、介面轉型與 `instanceof` |
| inner class | 是否在 `Activity` 中正確設計 `Participant` |
| 陣列操作 | 是否正確使用陣列管理報名者 |
| 邏輯正確性 | 是否能處理重複報名、額滿、證書資格與獎項判定 |
| 輸出結果 | 是否能與教師提供的主程式正確搭配執行 |

---

## 十、注意事項

1. 不可修改教師提供的介面與 `Main.java`
2. 必須在 `Activity` 中使用 inner class `Participant`
3. 必須正確使用抽象類別、繼承、介面、多型與方法覆寫
4. 若程式無法直接搭配教師提供的 `Main.java` 編譯執行，視為未完成
