package SQL

import Student
import org.junit.jupiter.api.*

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import java.sql.Statement
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class Student_list_DBTest {
    private lateinit var connection: Connection

    @BeforeEach
    fun setup() {
        try {
            connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/student_test",
                "postgres",
                "admin"
            )

            val statement: Statement = connection.createStatement()
            val create1 ="CREATE TABLE IF NOT EXISTS student1\n" +
                    "(\n" +
                    "    id SERIAL PRIMARY KEY, \n" +
                    "    lastname character varying(30) NOT NULL,\n" +
                    "    firstname character varying(30) NOT NULL,\n" +
                    "    surname character varying(30) NOT NULL,\n" +
                    "    telegram character varying(30),\n" +
                    "    phone character varying(15),\n" +
                    "    email character varying(50),\n" +
                    "    git character varying(50)\n" +
                    ")\n" +
                    "\n"
            val create2 ="CREATE TABLE IF NOT EXISTS student2\n" +
                    "(\n" +
                    "    id SERIAL PRIMARY KEY, \n" +
                    "    lastname character varying(30) NOT NULL,\n" +
                    "    firstname character varying(30) NOT NULL,\n" +
                    "    surname character varying(30) NOT NULL,\n" +
                    "    telegram character varying(30),\n" +
                    "    phone character varying(15),\n" +
                    "    email character varying(50),\n" +
                    "    git character varying(50)\n" +
                    ")\n" +
                    "\n"
            val create3 ="CREATE TABLE IF NOT EXISTS student3\n" +
                    "(\n" +
                    "    id SERIAL PRIMARY KEY, \n" +
                    "    lastname character varying(30) NOT NULL,\n" +
                    "    firstname character varying(30) NOT NULL,\n" +
                    "    surname character varying(30) NOT NULL,\n" +
                    "    telegram character varying(30),\n" +
                    "    phone character varying(15),\n" +
                    "    email character varying(50),\n" +
                    "    git character varying(50)\n" +
                    ")\n" +
                    "\n"
            statement.executeUpdate(create1)
            statement.executeUpdate(create2)
            statement.executeUpdate(create3)
            statement.close()

        } catch (e: SQLException) {
            e.printStackTrace()
        }
    }

    @AfterEach
    fun tearDown() {
        val statement: Statement = connection.createStatement()
        statement.execute("Drop TABLE student1;")
        statement.execute("Drop TABLE student2;")
        statement.execute("Drop TABLE student3;")
        statement.close()
        connection.close()
    }

    @ParameterizedTest
    @ValueSource(ints = [1])
    @Order(1)
    fun get_by_id(id:Int) {
        var insert="INSERT INTO student1 (lastName, firstName, surname, telegram, phone, email, git)  \n" +
                "VALUES \n" +
                "('Northwill','Lily','Kim','@tglily','+79891249082','lily@mail.ru','lily/pattern');"
        val statement: Statement = connection.createStatement()
        statement.execute(insert)
        val result = statement.executeQuery("SELECT * FROM student1 WHERE id = ${id};")
        if (result != null) {
            var student_string=""
            var list_args= mutableListOf<String>()
            while (result.next()) {
                for (i in 1..result.metaData.columnCount) {
                    if(result.getString(i)==null)
                        list_args.add("")
                    else
                        list_args.add(result.getString(i))

                }
                student_string+=list_args.get(1)+" "+list_args.get(2)+" "+list_args.get(3)+" "
                if(list_args.get(4)!=null)
                    student_string+="telegram="+list_args.get(4)+" "
                if(list_args.get(5)!=null)
                    student_string+="phone="+list_args.get(5)+" "
                if(list_args.get(6)!=null)
                    student_string+="email="+list_args.get(6)+" "
                if(list_args.get(7)!=null)
                    student_string+="git="+list_args.get(7)+" "
            }
            return assertEquals(Student(list_args.get(0).toInt(),student_string).toString(),"Northwill Lily Kim phone=+79891249082 telegram=@tglily email=lily@mail.ru git=lily/pattern ")
        }
    }

    @Test
    @Order(2)
    fun add_student() {
        var insert="INSERT INTO student2 (lastName, firstName, surname, telegram, phone, email, git)  \n" +
                "VALUES \n" +
                "('Northwill','Lily','Kim','@tglily','+79891249082','lily@mail.ru','lily/pattern');"
        val statement: Statement = connection.createStatement()
        statement.executeUpdate(insert)
        val result = statement.executeQuery("SELECT * FROM student2 WHERE id = 1;")
        if (result != null) {
            var student_string=""
            var list_args= mutableListOf<String>()
            while (result.next()) {
                for (i in 1..result.metaData.columnCount) {
                    if(result.getString(i)==null)
                        list_args.add("")
                    else
                        list_args.add(result.getString(i))

                }
                student_string+=list_args.get(1)+" "+list_args.get(2)+" "+list_args.get(3)+" "
                if(list_args.get(4)!=null)
                    student_string+="telegram="+list_args.get(4)+" "
                if(list_args.get(5)!=null)
                    student_string+="phone="+list_args.get(5)+" "
                if(list_args.get(6)!=null)
                    student_string+="email="+list_args.get(6)+" "
                if(list_args.get(7)!=null)
                    student_string+="git="+list_args.get(7)+" "
            }
            return assertEquals(Student(list_args.get(0).toInt(),student_string).toString(),"Northwill Lily Kim phone=+79891249082 telegram=@tglily email=lily@mail.ru git=lily/pattern ")
        }
    }

    @Test
    @Order(2)
    fun update_student() {
        val statement: Statement = connection.createStatement()
        var insert="INSERT INTO student3 (lastName, firstName, surname, telegram, phone, email, git)  \n" +
                "VALUES \n" +
                "('Northwill','Lily','Kim','@tglily','+79891249082','lily@mail.ru','lily/pattern');"
        statement.executeUpdate(insert)
        var update="Update student3  " +
                "set lastName='Kanny',firstName='Kane',surname='Kas', telegram='@tglily', phone='+79891249082', email='lily@mail.ru', git='lily/pattern'" +
                "where id = 1;"
        statement.executeUpdate(update)
        val result = statement.executeQuery("SELECT * FROM student3 WHERE id = 1;")
        if (result != null) {
            var student_string=""
            var list_args= mutableListOf<String>()
            while (result.next()) {
                for (i in 1..result.metaData.columnCount) {
                    if(result.getString(i)==null)
                        list_args.add("")
                    else
                        list_args.add(result.getString(i))

                }
                student_string+=list_args.get(1)+" "+list_args.get(2)+" "+list_args.get(3)+" "
                if(list_args.get(4)!=null)
                    student_string+="telegram="+list_args.get(4)+" "
                if(list_args.get(5)!=null)
                    student_string+="phone="+list_args.get(5)+" "
                if(list_args.get(6)!=null)
                    student_string+="email="+list_args.get(6)+" "
                if(list_args.get(7)!=null)
                    student_string+="git="+list_args.get(7)+" "
            }
            return assertEquals(Student(list_args.get(0).toInt(),student_string).toString(),"Kanny Kane Kas phone=+79891249082 telegram=@tglily email=lily@mail.ru git=lily/pattern ")
        }
    }


}