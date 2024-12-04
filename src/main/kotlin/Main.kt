fun main() {
    val dbConnection = Students_db()
    val result = dbConnection.executeQuery("SELECT * FROM student")
    if (result != null) {
        val metaData = result.metaData
        // Выводим заголовков столбцов
        for (i in 1..metaData.columnCount) {
            print("${metaData.getColumnName(i)}\t")
        }
        println()
        // Вывод каждой строки
        while (result.next()) {
            for (i in 1..metaData.columnCount) {
                print("${result.getString(i)}\t")
            }
            println()
        }
    }}