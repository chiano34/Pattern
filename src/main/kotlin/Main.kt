fun main() {
    var st=Student("Ruk Menga Liv phone=+79891214082 telegram=@sdasd email=smth@get.ru git=chino34/git")
    var b=Student_list("src/main/kotlin/output/txt.txt")
    b.get_count()

    var c=Student_list("database")
    c.get_count()
    c.get_by_id(3)
}