Poniżej masz estetycznie sformatowaną wersję Twojego tekstu w stylu pliku `.md` (Markdown). Możesz bezpośrednio zapisać ten tekst jako `README.md` lub inny plik `.md`:

---

# Budowa Kalkulatora – Plan Działania

## Faza 1: Definiowanie i Implementacja Rdzenia Obliczeń

### 🎯 Cel: Zdefiniować Kontrakt Operacji Matematycznej

**Co zrobić:**

* Stwórz interfejs `Operation` w pakiecie `com.example.calculator.core.operations.api`.

**Pytanie:**

* Jakie metody powinien zawierać interfejs?

  * Najprostsza wersja:

    ```java
    double apply(double operand1, double operand2)
    ```
  * Lepsza wersja (zalecana ze względu na precyzję):

    ```java
    BigDecimal apply(BigDecimal operand1, BigDecimal operand2)
    ```
  * Na początek przyjmujemy prostą wersję z `double`.

**Rezultat:**

* Jasno zdefiniowany sposób reprezentowania dowolnej operacji dwuargumentowej.

---

### 🎯 Cel: Zaimplementować Pierwszą Konkretną Operację – Dodawanie

**Co zrobić:**

* Stwórz klasę `Addition` w `com.example.calculator.core.operations.impl`, implementującą `Operation`.
* Zaimplementuj metodę `apply`, zwracającą `a + b`.

**Testy:**

* Stwórz klasę `AdditionTest` w `src/test/java/...`.
* Przetestuj przypadki: `Addition.apply(2, 3) == 5`, obsługa zer, liczb ujemnych itd.

**Rezultat:**

* Działający, przetestowany komponent realizujący dodawanie.
* Zgodność z zasadami OCP i SRP.

---

### 🎯 Cel: Zaimplementować Kolejne Operacje – Odejmowanie i Mnożenie

**Co zrobić:**

* Analogicznie jak dla `Addition`, stwórz klasy `Subtraction` i `Multiplication`.
* Dodaj testy jednostkowe.

**Rezultat:**

* Podstawowy zestaw operacji matematycznych w postaci przetestowanych komponentów.

---

## Faza 2: Budowa Silnika Kalkulatora

### 🎯 Cel: Zdefiniować Kontrakt Silnika Kalkulatora

**Co zrobić:**

* Stwórz interfejs `CalculationEngine` w `com.example.calculator.core.engine.api`.

**Propozycja metody:**

```java
double calculate(Operation operation, double operand1, double operand2)
```

**Rezultat:**

* Interfejs umożliwiający użycie operacji do wykonania obliczenia.

---

### 🎯 Cel: Zaimplementować Prosty Silnik Kalkulatora

**Co zrobić:**

* Stwórz klasę `SimpleCalculationEngine` w `com.example.calculator.core.engine.impl`.
* Metoda `calculate()` wywołuje `operation.apply()`.

**Testy:**

* Stwórz `SimpleCalculationEngineTest`.
* Użyj instancji operacji lub mocków (`Mockito`).

**Rezultat:**

* Komponent orkiestrowania obliczeń.
* Zgodność z zasadą DIP – silnik zależy od abstrakcji `Operation`.

---

## Faza 3: Warstwa Serwisowa (Pośrednik)

### 🎯 Cel: Zdefiniować Kontrakt Serwisu Kalkulatora

**Co zrobić:**

* Stwórz interfejs `CalculatorService` w `com.example.calculator.service.api`.

**Propozycja metody:**

```java
double performCalculation(String operationSymbol, double operand1, double operand2)
```

**Rezultat:**

* Zdefiniowane API dla warstwy UI lub innych klientów.

---

### 🎯 Cel: Zaimplementować Podstawowy Serwis Kalkulatora

**Co zrobić:**

* Stwórz klasę `CalculatorServiceImpl` w `com.example.calculator.service.impl`.
* Użyj `Map<String, Operation>` lub `OperationRegistry`, aby mapować symbole na operacje.

**Testy:**

* Stwórz `CalculatorServiceImplTest`.
* Użyj mocków dla `CalculationEngine` i `Operation`.

**Rezultat:**

* Warstwa tłumacząca żądania zewnętrzne na akcje w rdzeniu logiki.

---

## Faza 4: Prosty Interfejs Użytkownika i Uruchomienie

### 🎯 Cel: Stworzyć Minimalny Interfejs Użytkownika (np. Konsolowy)

**Co zrobić:**

* Stwórz klasę `ConsoleUI` w `com.example.calculator.ui.console`.
* W metodzie `start()`:

  1. Wczytaj pierwszą liczbę
  2. Wczytaj symbol operacji
  3. Wczytaj drugą liczbę
  4. Wywołaj `performCalculation()`
  5. Wyświetl wynik

**Rezultat:**

* Prosty interfejs do interakcji z użytkownikiem.

---

### 🎯 Cel: Połączyć Wszystko w Punkcie Startowym

**Co zrobić:**

* Stwórz klasę `CalculatorApp` w `com.example.calculator.app` z metodą `main`.
* W metodzie:

  * Utwórz instancje operacji (`Addition`, `Subtraction`, ...)
  * Utwórz `SimpleCalculationEngine`
  * Zbuduj mapę symbol → operacja
  * Stwórz `CalculatorServiceImpl`
  * Stwórz `ConsoleUI` i wywołaj `start()`

**Rezultat:**

* Działająca, choć prosta, aplikacja kalkulatora.

---

## ✅ Dalsze Kroki

* Dodaj operację dzielenia (`Division`) z obsługą dzielenia przez zero.
* Obsługa błędów w `ConsoleUI`.
* Stwórz `InputParser`, aby oddzielić logikę parsowania od UI.
* Przejdź z `double` na `BigDecimal` dla lepszej precyzji.
* Dodaj więcej operacji (potęgowanie, pierwiastki).
* Wprowadź framework DI (np. Spring, Guice).
* Zaimplementuj graficzny interfejs użytkownika (JavaFX, Swing).

---

## 🧠 Kluczowe Zasady

* **Testuj na bieżąco:** Testy jednostkowe dla każdej nowej klasy.
* **Małe kroki:** Pracuj iteracyjnie.
* **Refaktoryzuj:** Upraszczaj kod, gdy tylko zauważysz złożoność.
* **Używaj kontroli wersji:** Commituj po każdym osiągniętym celu.

---

Budując aplikację od rdzenia (Operation, Engine) do UI, tworzysz solidną, łatwą do rozwijania architekturę.

**Powodzenia!** 🚀

---

Chcesz, żebym przygotował Ci z tego gotowy plik `.md` do pobrania?
