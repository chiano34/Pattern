import Student_super.Companion.fioReg
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException
class Student: Student_super{
    @field:JsonProperty("lastName") var lastName: String=""
        get() {
            return field
        }
        set(value){
            if(checkFio(value))
                field=value
        }
    @field:JsonProperty("firstName") var firstName: String=""
        get() {
            return field
        }
        set(value){
            if(checkFio(value))
                field=value
        }
    @field:JsonProperty("surname") var surname: String=""
        get() {
            return field
        }
        set(value){
            if(checkFio(value))
                field=value
        }
    @field:JsonProperty("phone") var phone: String?=null
        get() {
            return field
        }
        set(value){
            if(checkPhone(value))
                field=value
        }
    @field:JsonProperty("telegram") var telegram: String?=null
        get() {
            return field
        }
        set(value){
            if(checkTg(value))
                field=value
        }
    @field:JsonProperty("email") var email: String?=null
        get() {
            return field
        }
        set(value){
            if(checkEmail(value))
                field=value
        }
    @field:JsonProperty("git") var git: String?=null
        get() {
            return field
        }
        set(value){
            if(checkGit(value))
                field=value
        }

    companion object{
        fun read_from_txt(address:String):MutableList<Student>{
            val file=File(address)
            val list= mutableListOf<Student>()
            print(file.absolutePath)
            try{
                val lines=file.readLines()
                for (line in lines){
                    list.add(Student(line))
                }
            }
            catch(e:FileNotFoundException){
                println("could not find file")
            }
            catch(e:IOException){
                println("could not read file")
            }
            return list
        }
        fun write_to_txt(adress:String,name:String, students:MutableList<Student>){
            val file=File(adress+name)
            for(student in students) {
                file.writeText(student.toString())
            }
        }
    }
    fun validate():Boolean{
        if(checkGit(this.git)&&(GetContact()!=null)){
            return true
        }
        else
            println("Валидация не пройдена")
            return false
    }
    fun Set_contact(_email: String?=null,_phone: String?=null,_telegram: String?=null){
            this.email=_email
            this.phone=_phone
            this.telegram=_telegram
    }

    @JsonCreator
    constructor(
        @JsonProperty("id") _id: String = "",
        @JsonProperty("lastName") _lastName: String = "",
        @JsonProperty("firstName")  _firstName: String = "",
        @JsonProperty("surname")  _surname: String = "",
        @JsonProperty("telegram")  _telegram: String? = null,
        @JsonProperty("phone")  _phone: String? = null,
        @JsonProperty("email")  _email: String? = null,
        @JsonProperty("git") _git: String? = null,
    )
    {
        id=_id.toInt()
        lastName=_lastName
        firstName=_firstName
        surname=_surname
        phone=_phone
        telegram=_telegram
        email=_email
        git=_git
    }
    constructor(_lastName:String,_firstName:String,_surname:String){
        id= counter
        lastName=_lastName
        firstName=_firstName
        surname=_surname
    }
    constructor(_id:Int,_info:String){
        val args: List<String>
        args=_info.split(" ")
        id=_id
        if(checkFio(args[0])&&checkFio(args[1])&&checkFio(args[2])){
            lastName=args[0]
            firstName=args[1]
            surname=args[2]
        }
        for(arg in args){
            if(arg.split("=")[0]=="phone"){
                if(checkPhone(arg.split("=")[1]))
                    phone=arg.split("=")[1]
            }
            if(arg.split("=")[0]=="telegram"){
                if(checkTg(arg.split("=")[1]))
                    telegram=arg.split("=")[1]
            }
            if(arg.split("=")[0]=="email"){
                if(checkEmail(arg.split("=")[1]))
                    email=arg.split("=")[1]
            }
            if(arg.split("=")[0]=="git"){
                if(checkGit(arg.split("=")[1]))
                    git=arg.split("=")[1]
            }
        }

    }
    constructor(_info:String){
        val args: List<String>
        args=_info.split(" ")
        id=counter
        if(checkFio(args[0])&&checkFio(args[1])&&checkFio(args[2])){
        lastName=args[0]
        firstName=args[1]
        surname=args[2]}
        for(arg in args){
            if(arg.split("=")[0]=="phone"){
                if(checkPhone(arg.split("=")[1]))
                phone=arg.split("=")[1]
            }
            if(arg.split("=")[0]=="telegram"){
                if(checkTg(arg.split("=")[1]))
                telegram=arg.split("=")[1]
            }
            if(arg.split("=")[0]=="email"){
                if(checkEmail(arg.split("=")[1]))
                email=arg.split("=")[1]
            }
            if(arg.split("=")[0]=="git"){
                if(checkGit(arg.split("=")[1]))
                git=arg.split("=")[1]
            }
        }

    }
    constructor(_lastName:String,_firstName:String,_surname:String,
                _phone:String?=null,_telegram:String?=null,_email:String?=null,_git:String?=null){
        id = counter
        lastName=_lastName
        firstName=_firstName
        surname=_surname
        phone=_phone
        telegram=_telegram
        email=_email
        git=_git
    }
    constructor(infoHash: HashMap<String,Any?>)
    {
        id= counter
        lastName=infoHash["lastName"].toString()
        firstName=infoHash["firstName"].toString()
        surname=infoHash["surname"].toString()
        phone=infoHash.getOrDefault("phone",null).toString()
        telegram=infoHash.getOrDefault("telegram",null).toString()
        email=infoHash.getOrDefault("email",null).toString()
        git=infoHash.getOrDefault("git",null).toString()
    }
    fun printObj()
    {
        print("ID: $id, Фамилия: $lastName, Имя: $firstName, Отчество: $surname")
        if(phone!=null)
            print(", Телефон: $phone")
        if(telegram!=null)
            print(", Телеграм: $telegram")
        if(email!=null)
            print(", Почта: $email")
        if(git!=null)
            print(", Git: $git")
        println()
    }
    fun GetInfo()
    {
        print("ID: $id, Фамилия: $lastName, Имя: $firstName, Отчество: $surname")
        if(git!=null)
            print(", Git: $git")
        val contact = GetContact()
        if(contact!=null){
            print(", Контакт: $contact")
        }
    }
    fun GetFIO():String{
        val fio=lastName+" "+firstName[0]+"."+surname[0]+"."
        return fio
    }
    fun GetContact():String?{
        if(telegram!=null)
            return telegram
        else if(phone!=null)
            return phone
        else if(email!=null)
            return email
        return null
    }
    fun GetFullName():String{
        return lastName+" "+firstName+" "+surname
    }
    fun check_filters(student: Student,filters: MutableList<Pair<String, String>>):Boolean{
        var check=true
        if(filters[0].first!=""){
            if(student.GetFullName().contains(filters[0].first)==false)
                check=false
        }

        if( filters[1].second=="Да"){
            if(student.git!=null){
                if(filters[1].first!=""){
                    println(student.git+filters[1].first)
                    if(student.git!!.contains(filters[1].first)==false){
                        check=false
                    }
                }
            }
            else{
                check=false
            }
        }
        else if(filters[1].second=="Нет"&&(student.git!=null))
            check=false

        if( filters[2].second=="Да"){
            if(student.telegram!=null){
                if(filters[2].first!=""){
                    if(student.telegram!!.contains(filters[2].first)==false){
                        check=false
                    }
                }
            }
            else{
                check=false
            }
        }
        else if(filters[2].second=="Нет"&&(student.telegram!=null))
            check=false

        if( filters[3].second=="Да"){
            if(student.phone!=null){
                if(filters[3].first!=""){
                    if(student.phone!!.contains(filters[3].first)==false){
                        check=false
                    }
                }
            }
            else{
                check=false
            }
        }
        else if(filters[3].second=="Нет"&&(student.phone!=null))
            check=false

        if( filters[4].second=="Да"){
            if(student.email!=null){
                if(filters[4].first!=""){
                    if(student.email!!.contains(filters[4].first)==false){
                        check=false
                    }
                }
            }
            else{
                check=false
            }
        }
        else if(filters[4].second=="Нет"&&(student.email!=null))
            check=false

        return check
    }
    override fun toString():String{
        var string=lastName+" "+firstName+" "+surname+" "
        if(phone!=null)
            string+="phone="+phone+" "
        if(telegram!=null)
            string+="telegram="+telegram+" "
        if(email!=null)
            string+="email="+email+" "
        if(git!=null)
            string+="git="+git+" "
        return string
    }

}