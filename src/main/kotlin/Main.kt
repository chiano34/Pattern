import Student_list_DB

fun main() {
    var st=Student("Ruk Menga Liv phone=+79891214082 telegram=@sdasd email=smth@get.ru git=chino34/git")
    var a=Student_list_DB()
    a.get_k_n_student_short_list(3,2)
    a.get_by_id(1)
    a.get_count()
}