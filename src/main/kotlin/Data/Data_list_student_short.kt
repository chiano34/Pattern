import MVC.View
import kotlin.math.ceil
class Data_list_student_short(studentsList: List<Student_short>):Data_list<Student_short>(studentsList) {
    private var observer: View? = null
    fun notify_view() {
        observer?.setTableData(this.data)
    }
    fun setObserver(observer: View) {
        this.observer = observer
    }
    override fun get_names(): List<String> {
        return listOf("№","FIO","git","contact")
    }
    override fun get_args(): MutableList<MutableList<Any?>> {
        var args= mutableListOf<MutableList<Any?>>()
        var count =1
        for(row in data)
        {
            args.add(mutableListOf(count,row.FIO,row.git,row.contact))
            count++
        }
        return args
    }
    fun get_table(): Data_table{
        var names= get_names()
        var args=get_data()
        args.add(0,names.toMutableList())
        return Data_table(args)
    }
}