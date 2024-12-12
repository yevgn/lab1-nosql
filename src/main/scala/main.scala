package ru.antonov


// 13. Найдите самые популярные первые буквы слов в данном тексте. Выведите букву и соответствующие слова.

val text = "His palms are sweaty, knees weak, arms are heavy\n" +
  "There is vomit on his sweater already, mom's spaghetti\n" +
  "He is nervous, but on the surface, he looks calm and ready\n" +
  "To drop bombs, but he keeps on forgetting\n" +
  "What he wrote down, the whole crowd goes so loud\n" +
  "He opens his mouth, but the words won't come out\n" +
  "He is chokin', how? Everybody is jokin' now\n" +
  "The clock is run out, time is up, over, blaow\n" +
  "Snap back to reality, ope, there goes gravity"

@main
def main(): Unit = {
  
  // \\W+ - рег. выр (1 и более неалфавитно-цифровых символов)
  val words = text.split("\\W+").filter(_.nonEmpty)
  
  val groupedWords = words.groupBy(word => word.toLowerCase.head)
  
  // _1 - ключ в Map, _2 - значение в Map
  val mostPopularLetters = groupedWords.toList.sortWith(_._2.length > _._2.length)
  
  // s перед строкой - для включения переменных, констант и выражений в строку
  mostPopularLetters.foreach { (l, words) =>
    println(s"Буква $l: ${words.mkString(", ")}")
  }
}