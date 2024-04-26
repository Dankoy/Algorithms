package ru.dankoy.computersciencecentre.greedyalgorithms.huffman;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * input
 * <p>
 * 4 14 a: 0 b: 10 c: 110 d: 111 01001100100111
 */
public class HuffmanDecode {

  public static void main(String[] args) {
    new HuffmanDecode().run();
  }

  public void run() {

    // Чтение входных данных
    Scanner in = new Scanner(System.in);
    long amountOfSymbols = in.nextLong();
    long codeWeightSum = in.nextLong(); // не нужно на самом деле

    Map<String, String> codeSymbolRelation = new HashMap<>();
    // читаем символы и их коды, добавляем в мэп
    while (amountOfSymbols > 0) {

      String symbol = in.next();
      String code = in.next();
      symbol = symbol.replace(":", "");

      codeSymbolRelation.put(code, symbol);

      amountOfSymbols--;
    }

    in.nextLine(); // читает перенос строки
    String fullCode = in.next();

    String result = decodeHuffmanCode(codeSymbolRelation, fullCode);

    System.out.println(result);

  }


  /**
   * Читает код последовательно и ищет подходящие символы
   *
   * @param codeSymbolRelation отношения символов и кодов
   * @param fullCode           код
   * @return расшифрованную строку
   */
  private static String decodeHuffmanCode(Map<String, String> codeSymbolRelation, String fullCode) {

    StringBuilder sb = new StringBuilder();

    // Устанавливаем начальный и конечные позиции для substring
    int currentPositionToStartReadingCode = 0;
    int currentPositionToEndReadingCode = 1;

    // Пока позиция начала меньше конца строки
    while (currentPositionToStartReadingCode < fullCode.length()) {

      // берем часть строки от позиции начала и конца
      String substring = fullCode.substring(currentPositionToStartReadingCode,
          currentPositionToEndReadingCode);

      // если часть строки найдена в hashmap, то добавляем ее в результат
      if (codeSymbolRelation.containsKey(substring)) {
        sb.append(codeSymbolRelation.get(substring));

        // позиция начала подстроки заменяется на текущую позицию конца строки, а позиция конца
        // строки это следующий символ за позицией начала.
        currentPositionToStartReadingCode = currentPositionToEndReadingCode;
        currentPositionToEndReadingCode = currentPositionToStartReadingCode + 1;

      } else {

        // если же код не был найден, то увеличиваем позицию конца подстроки. Таким образом в
        // подстроку добавляется следующий символ до тех пор пока не будет сформирован и найден
        // корректный код из мэпы
        currentPositionToEndReadingCode++;

      }

    }

    return sb.toString();
  }

}
