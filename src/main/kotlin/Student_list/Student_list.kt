import Student
interface Student_list_interface
{
    fun get_by_id(id:Int):Student?
    fun add_student(student:Student)
    fun update_student(student: Student,id:Int,)
    fun delete_student(id:Int)
    fun get_k_n_student_short_list(k: Int, n: Int,filters:MutableList<Pair<String,String>>) : Data_list_student_short
    fun get_count():Int
}
class Student_list_adapter(var path:String):Student_list_interface
{
    private var student_list: Student_manager? = null
    init {
        if (path.split('.')[1]=="txt")
            student_list= Student_manager(Student_list_txt())
        if (path.split('.')[1]=="json")
            student_list=Student_manager(Student_list_JSON())
        if (path.split('.')[1]=="yaml")
            student_list=Student_manager(Student_list_txt())
        student_list?.read_from_file(path)
    }
    override fun get_by_id(id: Int): Student? {
        return student_list?.get_by_id(id)
    }
    override fun get_k_n_student_short_list(k: Int, n: Int,filters:MutableList<Pair<String,String>>): Data_list_student_short {
        return student_list?.get_k_n_student_short_list(k,n,filters) ?:Data_list_student_short(mutableListOf())
    }
    override fun add_student(student: Student) {
        student_list?.add_student(student)
        student_list?.write_to_file(path)
    }
    override fun update_student(student: Student,id: Int) {
        student_list?.update_student(id,student)
        student_list?.write_to_file(path)
    }
    override fun delete_student(id: Int) {
        student_list?.delete_student(id)
        student_list?.write_to_file(path)
    }
    override fun get_count(): Int {
        return student_list?.get_count()?:0
    }
}
class Student_list(path: String):Student_list_interface {
    private var student_list: Student_list_interface? = null
    init{
        if(path=="database")
        {
            student_list=Student_list_DB.getInstance()
        }
        else
        {
            student_list=Student_list_adapter(path)
        }
    }
    override fun get_by_id(id: Int): Student? {
        return student_list?.get_by_id(id)
    }
    override fun get_k_n_student_short_list(k: Int, n: Int,filters:MutableList<Pair<String,String>>): Data_list_student_short {
        return student_list?.get_k_n_student_short_list(k,n,filters) ?:Data_list_student_short(mutableListOf())
    }
    override fun add_student(student: Student) {
        student_list?.add_student(student)
    }
    override fun update_student(student: Student,id: Int) {
        student_list?.update_student(student,id)
    }
    override fun delete_student(id: Int) {
        student_list?.delete_student(id)
    }
    override fun get_count(): Int {
        return student_list?.get_count()?:0
    }
}