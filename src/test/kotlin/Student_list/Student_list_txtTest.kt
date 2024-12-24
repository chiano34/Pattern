import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir
import java.io.File
import java.io.FileWriter
import java.io.IOException
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class Student_list_txtTest{
    @Test
    //Тест на запись в файл
    fun read_from_file(@TempDir tempDir: File) {
        val file = File(tempDir, "students.txt")
        val writer = FileWriter(file)
        writer.write("Bob Smith Sun phone=+79891214092 telegram=@sdasd email=smth@get.ru git=chino34/git\n" +
                "Bobb Smith Sun phone=+79891214092 telegram=@sdasd email=smth@get.ru git=chino34/git\n" +
                "Abobbb Amith Aun phone=+79891214092 telegram=@sdasd email=smth@get.ru git=chino34/git")
        writer.close()

        val studentListTxt = Student_list_txt()
        val students = studentListTxt.read_from_file(file.path)

        assertEquals(3, students.size)
        assertEquals("Bob Smith Sun phone=+79891214092 telegram=@sdasd email=smth@get.ru git=chino34/git ",
            students[0].toString())
        assertEquals("Bobb Smith Sun phone=+79891214092 telegram=@sdasd email=smth@get.ru git=chino34/git ",
            students[1].toString())
        assertEquals("Abobbb Amith Aun phone=+79891214092 telegram=@sdasd email=smth@get.ru git=chino34/git ",
            students[2].toString())
    }
    @Test
    //Тест на вывод ошибки если файл не найден
    fun read_from_file_not_found() {
        val studentListTxt = Student_list_txt()
        val students = studentListTxt.read_from_file("non_existent_file.txt")
        assertTrue(students.isEmpty())
    }
    @Test
    //Тест на вывод ошибки при попытке чтения из не закрытого файла
    fun read_from_file_error() {
        val file = File("test_file.txt")
        val writer = FileWriter(file)
        writer.write("Bob Smith Sun phone=+79891214092 telegram=@sdasd email=smth@get.ru git=chino34/git")
        val studentListTxt = Student_list_txt()
        val students = studentListTxt.read_from_file(file.path)
        assertTrue(students.isEmpty())

        writer.close()
    }
    @Test
    //Тест на запись данных в файл
    fun  write_to_file(@TempDir tempDir: File) {
        val studentListTxt = Student_list_txt()
        "Bob Smith Sun phone=+79891214092 telegram=@sdasd email=smth@get.ru git=chino34/git\n" +
                "Bobb Smith Sun phone=+79891214092 telegram=@sdasd email=smth@get.ru git=chino34/git\n" +
                "Abobbb Amith Aun phone=+79891214092 telegram=@sdasd email=smth@get.ru git=chino34/git"
        val students = mutableListOf(Student("Bob Smith Sun phone=+79891214092 telegram=@sdasd email=smth@get.ru git=chino34/git")
            ,Student("Bobb Smith Sun phone=+79891214092 telegram=@sdasd email=smth@get.ru git=chino34/git")
            ,Student("Abobbb Amith Aun phone=+79891214092 telegram=@sdasd email=smth@get.ru git=chino34/git"))
        studentListTxt.list_data = students

        val file = File(tempDir, "students.txt")
        studentListTxt.write_to_file(file.path)
        val lines = file.readLines()
        assertEquals(3, lines.size)
        assertEquals("Bob Smith Sun phone=+79891214092 telegram=@sdasd email=smth@get.ru git=chino34/git ",
            lines[0])
        assertEquals("Bobb Smith Sun phone=+79891214092 telegram=@sdasd email=smth@get.ru git=chino34/git ",
            lines[1])
        assertEquals("Abobbb Amith Aun phone=+79891214092 telegram=@sdasd email=smth@get.ru git=chino34/git ",
            lines[2])
    }
    @Test
    //Тест на чтение некорректных данных
    fun read_from_file_not_correct(@TempDir tempDir: File) {
        val file = File(tempDir, "invalid_students.txt")
        val writer = FileWriter(file)
        writer.write("lowercase n1mb3rs uPperCase phone=+nubmers telegram=without@inbegin email=nodomen@mail git=1")
        writer.close()

        val studentListTxt = Student_list_txt()
        val students = studentListTxt.read_from_file(file.path)

        assertEquals(1, students.size)
        assertEquals("   ",
            students[0].toString())
    }
}