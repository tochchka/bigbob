fun main() {
    val n = mapOf(
        'А' to 21, 'Б' to 13, 'В' to 4,  'Г' to 20, 'Д' to 22, 'Е' to 1,  'Ё' to 25,
        'Ж' to 12, 'З' to 24, 'И' to 14, 'Й' to 2,  'К' to 28, 'Л' to 9,  'М' to 23,
        'Н' to 3,  'О' to 29, 'П' to 6,  'Р' to 16, 'С' to 15, 'Т' to 11, 'У' to 26,
        'Ф' to 5,  'Х' to 30, 'Ц' to 27, 'Ч' to 8,  'Ш' to 18, 'Щ' to 10, 'Ь' to 33,
        'Ы' to 31, 'Ъ' to 32, 'Э' to 19, 'Ю' to 7,  'Я' to 17
    )

    val a = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЬЫЪЭЮЯ".toList().sortedBy { n[it] }

    print("Ключ: ")
    val k = readln().uppercase().filter { it in n.keys }
    if (k.isEmpty()) {
        println("Ошибка: ключ должен содержать только русские буквы")
        return
    }

    print("Текст: ")
    val t = readln().uppercase().filter { it in a }

    val r = t.mapIndexed { i, c ->
        val keyChar = k[i % k.length]
        val shift = n[keyChar] ?: 1
        a[(a.indexOf(c) + shift - 1) % 33]
    }.joinToString("")

    println("Результат: $r")
}