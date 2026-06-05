# ST-5 Модульное тестирование на Java с использованием jUnit и Maven


![GitHub pull requests](https://img.shields.io/github/issues-pr/UNN-CS/ST-5)
![GitHub closed pull requests](https://img.shields.io/github/issues-pr-closed/UNN-CS/ST-5)

Срок выполнения задания:

**по 19.04.2026** ![Relative date](https://img.shields.io/date/1776632400)


Перед началом работы необходимо установить пакет разработчика JDK и утилиту **Maven** [https://maven.apache.org](https://maven.apache.org)


## Задание №1. Создание проекта Maven

Используя командную строку и утилиту **Maven** создать новый проект, используя вариант команды

```java
mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.5 -DinteractiveMode=false
```

В проекте Maven, по-умолчанию, создаются тесты - заглушки.

Добавить в проект класс **Sqrt**, содержащий алгоритм вычисления квадратного корня методом последовательных приближений.

```java
public class Sqrt
{
   double precision=0.00000001;
   double arg;

   public Sqrt(double arg) {
      this.arg=arg;
   }
   public double mean(double x,double y) {
      return (x+y)/2.0;
   }
   public boolean isAccurate(double guess,double x) {
      return Math.abs(guess*guess-x)<precision;
   }
   public double nextApproximation(double guess,double x) {
      return mean(guess,x/guess);
   }
   public double iter(double guess, double x) {
      if(isAccurate(guess,x))
         return guess;
      else
         return iter(nextApproximation(guess,x),x);
   }
   public double calc() {
      return iter(1.0,arg);
   }
}
```

В класс **App** можно поместить следующий демонстрационный пример:

```java
public class App
{
   public static void main(String[] args)
   {
      double val=Double.parseDouble("2.0");
      Sqrt sqrt=new Sqrt(val);
      double result=sqrt.calc();
      System.out.println("Sqrt of " + val + " = " + result);
   }
}
```

Далее, построить проект и убедиться, что ошибок нет и фиктивные тесты запускаются успешно.

```
mvn compile
mvn test
```


## Задание №2

Поместить в соответствующий исходный файл тесты для покрытия всех методов класса **Sqrt**. Минимальное количество тестов - 10.

## Задание №3

Загрузить проект на **GitHub** и убедиться в работоспособности проекта через сценарии **GH Actions**. Главное, - убедиться в том, что тесты распознаются и запускаются на сервере!
