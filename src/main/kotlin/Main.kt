fun main() {
    var st=Student("Ruk Menga Liv phone=+79891214082 telegram=@sdasd email=smth@get.ru git=chino34/git")
    var b=Student_list("src/main/kotlin/output/txt.txt")
    var c=Student_list("database")
    for(i in 0..15){
        c.add_student(st)
    }
}