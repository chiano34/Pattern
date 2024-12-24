import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

class Student_list_DB private constructor():Student_list_interface {
    private lateinit var connection: Connection

    init {
        try {
            connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/Student",
                "postgres",
                "admin"
            )
            println("Успешное подключение к БД.")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    companion object {
        @Volatile
        private var instance: Student_list_DB? = null

        fun getInstance(): Student_list_DB {
            return instance ?: synchronized(this) {
                instance ?: Student_list_DB().also { instance = it }
            }
        }
    }
    override fun get_by_id(id:Int): Student? {
        val statement: Statement = connection.createStatement()
        val result = statement.executeQuery("SELECT * FROM student WHERE id = ${id};")
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
            return  Student(list_args.get(0).toInt(),student_string)
        }
        return null
    }
    override fun add_student(student: Student) {
        val statement: Statement = connection.createStatement()

        var insert="insert into student (lastName, firstName, surname, telegram, phone, email, git)" +
                "values ('${student.lastName}','${student.firstName}','${student.surname}'"
        if(student.telegram!=null)
            insert+=",'${student.telegram}'"
        else
            insert+=",NULL"
        if(student.phone!=null)
            insert+=",'${student.phone}'"
        else
            insert+=",NULL"
        if(student.email!=null)
            insert+=",'${student.email}'"
        else
            insert+=",NULL"
        if(student.git!=null)
            insert+=",'${student.git}');"
        else
            insert+=",NULL);"
        insert+=" "
        statement.executeUpdate(insert)
    }
    override fun update_student(student: Student,id:Int) {
        val statement: Statement = connection.createStatement()
        var insert="Update student " +
                "set lastName='${student.lastName}',firstName='${student.firstName}',surname='${student.surname}'"
        if(student.telegram!=null)
            insert+=",telegram='${student.telegram}'"
        else
            insert+=",telegram=NULL"
        if(student.phone!=null)
            insert+=",phone='${student.phone}'"
        else
            insert+=",phone=NULL"
        if(student.email!=null)
            insert+=",email='${student.email}'"
        else
            insert+=",email=NULL"
        if(student.git!=null)
            insert+=",git='${student.git}'"
        else
            insert+=",git=NULL"
        insert+=" where id=$id;\n"
        println(insert)
        statement.executeUpdate(insert)

    }
    override fun delete_student(id:Int) {
        val statement: Statement = connection.createStatement()
        statement.executeUpdate("delete from student where id = ${id}")
    }
    override fun get_count():Int{
        var count=0
        var result:ResultSet
        val statement: Statement = connection.createStatement()
        result=statement.executeQuery("select count(*) from student")
        if (result.next()) {
            count = result.getInt(1)
        }
        return count
    }
    override fun get_k_n_student_short_list(k:Int,n:Int,filters:MutableList<Pair<String,String>>):Data_list_student_short {
        val list= mutableListOf<Student_short>()
        val statement: Statement = connection.createStatement()
        val result = statement.executeQuery("SELECT * FROM student ORDER BY id ASC LIMIT ${n} OFFSET ${(k-1)*n};")
        if(result!=null){
            while (result.next()) {
                var student_string=""
                var list_args= mutableListOf<String>()
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
                var a=Student(list_args.get(0).toInt(),student_string)
                if(a.check_filters(a,filters))
                    list.add(Student_short(a))
            }
            return Data_list_student_short(list)
        }
        return Data_list_student_short(list)
    }

}